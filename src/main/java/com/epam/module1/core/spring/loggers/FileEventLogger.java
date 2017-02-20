package com.epam.module1.core.spring.loggers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

import com.epam.module1.core.spring.beans.Review;

public class FileEventLogger implements EventLogger {

	private File outputFile;
	private String outputPath;
	private boolean append = true;
	private String fileName;

	public FileEventLogger(String fileName) {
		super();
		this.outputPath = fileName;
	}

	private void init() throws IOException {
		outputFile = new File(outputPath);
		try {
			outputFile.createNewFile();
			if (!outputFile.canWrite()) {
				throw new IOException();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logEvent(Review review) {
		try {
			FileUtils.writeStringToFile(outputFile, review.toString() + "\n", append);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
