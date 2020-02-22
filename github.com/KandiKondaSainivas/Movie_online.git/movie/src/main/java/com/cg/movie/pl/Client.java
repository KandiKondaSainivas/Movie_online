package com.cg.movie.pl;

import java.util.Scanner;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.AdminService;
import com.cg.movie.service.AdminServiceImpl;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AdminService adminService = new AdminServiceImpl();
		Theater theater = null;
		int choice = 0;
		while (choice != 3) {
			System.out.println("1.Add Theater\n2.Delete Theater");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter theater Id");
				int theaterId = scanner.nextInt();
				System.out.println("Enter theater Name");
				scanner.nextLine();
				String theaterName = scanner.nextLine();
				System.out.println("Enter theater City");
				String theaterCity = scanner.nextLine();
				System.out.println("Enter Manager Name");
				String managerName = scanner.nextLine();
				System.out.println("Enter Manager Contact");
				String managerContact = scanner.nextLine();

				theater = new Theater();

				theater.setTheaterId(theaterId);
				theater.setTheaterName(theaterName);
				theater.setTheaterCity(theaterCity);
				theater.setManagerName(managerName);
				theater.setManagerContact(managerContact);

				try {
					Theater t = adminService.addTheater(theater);
					System.out.println("Added theater successfully ");
				} catch (MovieException e) {
					System.err.println(e.getMessage());
				}

				break;

			case 2:
				System.out.println("Enter theater id to delete");
				int theaterId1 = scanner.nextInt();
				try {
					boolean flag = adminService.deleteTheater(theaterId1);
					if (flag == true) {
						System.out.println(" Theater Deleted successfully");
					}

				} catch (MovieException e) {
					System.err.println(e.getMessage());
				}
				break;

			}

		}
	}
}
