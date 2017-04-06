package com.epam.module9.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomStringUtils;

public class TaskRunnerBatchFIXED {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/dbfortest?currentSchema=module9";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    private static int maxTables;
    private static int maxThreads = 25;
    private static int maxColumns;
    private static int maxRows;

    public static void main(String[] args) {
        enterArgumentsMethod();
        long startGlobalTime = System.currentTimeMillis();
        AtomicInteger tablesNumber = new AtomicInteger(maxTables);
        int threadsNumber = maxThreads;
        Set<Thread> threads = new HashSet<>();
        Connection connection = null;
        Statement stmt = null;
        try {

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
            connection.setAutoCommit(false);

            for (int i = 0; i < threadsNumber; i++) {
                Runnable runnable = () -> {
                    long startTime = System.currentTimeMillis();
                    int tableNumber = tablesNumber.getAndDecrement();

                    while (tableNumber > 0) {
                        String tableName = RandomStringUtils.randomAlphabetic(7);
                        int numberColumns = maxColumns;
                        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + "(");
                        for (int j = 0; j < numberColumns; j++) {
                            sql.append(RandomStringUtils.randomAlphabetic(7) + " varchar(255)");
                            if (j != numberColumns - 1) {
                                sql.append(",");
                            }
                        }
                        sql.append(");");

                       addToBatch(sql.toString(), stmt);

                        int rowsNumber = maxRows;
                        for (int j = 0; j < rowsNumber; j++) {
                            sql = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
                            for (int k = 0; k < numberColumns; k++) {
                                sql.append("'" + RandomStringUtils.randomAlphabetic(4) + "'");
                                if (k != numberColumns - 1) {
                                    sql.append(",");
                                }
                            }
                            sql.append(");");
                            addToBatch(sql.toString(), stmt);

                        }
                        tableNumber = tablesNumber.getAndDecrement();
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("Execution time of "
                                       + Thread.currentThread().getName()
                                       + " : "
                                       + (endTime - startTime));
                };
                Thread thread = new Thread(runnable);
                thread.start();
                threads.add(thread);
            }
            threads.stream().forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            stmt.executeBatch();
            connection.commit();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Global Execution time of "
                + ( System.currentTimeMillis() - startGlobalTime));
    }

    private static void enterArgumentsMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of tables");
        maxTables = scanner.nextInt();
        System.out.println("Enter the number of columns");
        maxColumns = scanner.nextInt();
        System.out.println("Enter the number of rows");
        maxRows = scanner.nextInt();
    }

    private static synchronized void addToBatch(String sql, Statement stmt) {
        try {
            stmt.addBatch(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
