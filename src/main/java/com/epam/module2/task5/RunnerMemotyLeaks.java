package com.epam.module2.task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

public class RunnerMemotyLeaks {

	public static void main(String[] args) throws Exception {
		FileReader input = new FileReader("data.txt");
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		List<String> list = new ArrayList<String>();

		long before = System.currentTimeMillis();
		System.out.println("Start...");

		while ((myLine = bufRead.readLine()) != null) {
			String newString = new String();
			for (int i = 0; i < myLine.length() ; i ++) {
				String substring=myLine.substring(i, i+1);
				if ( !" ".equals(substring)){
					newString+=substring;
				}else {
					list.add(newString);
					newString=new String();
				}
			}
		}

		System.out.println("Finish.. List size = " + list.size());
		long after = System.currentTimeMillis();
		long result = after - before;
		System.out.println("result= " + result);

		generateDump();
	}

	private static void generateDump() throws IOException {
		String name = ManagementFactory.getRuntimeMXBean().getName();
		String pid = name.substring(0, name.indexOf("@"));
		String[] cmd = { "jmap", "-dump:file=D:\\temp\\heapdumps\\dump.hprof", pid };
		Process p = Runtime.getRuntime().exec(cmd);
	}

}
