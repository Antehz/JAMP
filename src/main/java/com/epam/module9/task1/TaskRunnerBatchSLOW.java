package com.epam.module9.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomStringUtils;

public class TaskRunnerBatchSLOW {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/dbfortest?currentSchema=module9";
    static final String USER = "postgres";
    static final String PASS = "postgres";
    private static int maxTables;
    private static int maxThreads = 1;
    private static int maxColumns;
    private static int maxRows;

    public static void main(String[] args) {
        enterArgumentsMethod();
        AtomicInteger tablesNumber = new AtomicInteger(maxTables);

        int threadsNumber = maxThreads;

        for (int i = 0; i < threadsNumber; i++) {
            new Thread(() -> {
                long startTime = System.currentTimeMillis();
                try (
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement stmt = connection.createStatement())

                {

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
                        stmt.execute(sql.toString());

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
                              stmt.execute(sql.toString());
                        }
                        tableNumber = tablesNumber.getAndDecrement();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Execution time of "
                                   + Thread.currentThread().getName()
                                   + " : "
                                   + (endTime - startTime));
            }).start();
        }
    }



    private static void enterArgumentsMethod()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of tables");
        maxTables = scanner.nextInt();
        System.out.println("Enter the number of columns");
        maxColumns = scanner.nextInt();
        System.out.println("Enter the number of rows");
        maxRows = scanner.nextInt();
    }
}
