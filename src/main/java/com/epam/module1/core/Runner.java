package com.epam.module1.core;

import java.util.Scanner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.module1.core.impl.DefaultCommentService;
import com.epam.module1.core.spring.beans.Client;
import com.epam.module1.core.spring.beans.Review;

public class Runner {
	public static void main(String[] args) {

		//reduce coupling, use IOC
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring.xml" });
		DefaultCommentService commentService = (DefaultCommentService) context.getBean("commentService");

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your first name: ");
			String firstName = scanner.nextLine();
			if ("".equals(firstName)) {
				break;
			}
			System.out.println("Enter your second name: ");
			String secondName = scanner.nextLine();
			System.out.println("Enter your review: ");
			String message = scanner.nextLine();
			System.out.println("Enter your rating [1-5]: ");
			int rating = scanner.nextInt();

			Client client = new Client(firstName, secondName);
			Review review = new Review(client, message, rating);
			commentService.writeComment(review);
		}
		context.close();
	}
}
