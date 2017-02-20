package com.epam.module2.task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.charset.spi.CharsetProvider;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.Data;

public class RunnerFixedByte {

	public static void main(String[] args) throws Exception {
		FileReader input = new FileReader("data.txt");
		BufferedReader bufRead = new BufferedReader(input);
		byte[] myLine = null;
		String line=null;
		List<byte[]> list = new ArrayList<byte[]>();
		long before = System.currentTimeMillis();
		System.out.println("Start...");
		int count = 0;
		while ((line=bufRead.readLine()) != null) {
			count++;
			myLine = line.getBytes();
			for (int i=0; i<myLine.length;i+=4){
				byte[] subArray = new byte[3];
				subArray[0]=myLine[i];
				subArray[1]=myLine[i+1];
				subArray[2]=myLine[i+2];
				list.add(subArray);
				subArray=null;
			}
			line=null;
		}
		bufRead.close();
		input.close();
		System.gc();
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
