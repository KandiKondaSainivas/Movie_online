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
		Theater theater = new Theater();
		int choice = 0;
		while (choice != 3) {
			System.out.println("1.Add Theater\n2.Delete Theater\n3.Exit");
			try {
				System.out.println("Enter your choice");

				choice = scanner.nextInt();
			} catch (Exception e) {
				System.err.println("Enter Correct Input");
				scanner.nextLine();
			}
			switch (choice) {

			case 1:

				try {
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

					theater.setTheaterId(theaterId);
					theater.setTheaterName(theaterName);
					theater.setTheaterCity(theaterCity);
					theater.setManagerName(managerName);
					theater.setManagerContact(managerContact);

					adminService.addTheater(theater);
					System.out.println("Added theater successfully ");
				} catch (MovieException e) {
					System.err.println(e.getMessage());
				} catch (Exception e) {
					System.err.println("Enter Correct Input");
					scanner.nextLine();
				}

				break;

			case 2:

				if (theater.getTheaterId() > 0) {
					try {

						System.out.println("Enter theater id to delete");
						int theaterId1 = scanner.nextInt();

						boolean flag = adminService.deleteTheater(theaterId1);
						if (flag == true) {
							System.out.println(" Theater Deleted successfully");
						}

					} catch (MovieException e) {
						System.err.println(e.getMessage());
					} catch (Exception e) {
						System.err.println("Enter Correct Input");
						scanner.nextLine();
					}
				} else {
					System.err.println("First add theater then we can delete the theater");
				}

				break;
			case 3:
				System.out.println("Thank You");
				return;
			}

		}
	}
}
