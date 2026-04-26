package com.mySpringClass.InternalWorkingOfSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringApplication.class, args);
	}

// Way 2 -> Field Injection
//	@Autowired
//	private RazorPay pyService;
//////  Way 1 -> Constructor Dependency injection
////
////	public InternalWorkingOfSpringApplication(RazorPay pyService) {
////		this.pyService = pyService;
////	}
///
///

	private final PaymentService ps;
	public InternalWorkingOfSpringApplication(PaymentService ps) {
		this.ps = ps;
	}

	@Override
	public void run(String... args) throws Exception {
//		String py = pyService.pay();
//		System.out.println("Payment Done: " + py);
		String py = ps.pay();
		System.out.println("Payment Done: " + py);
	}
}
