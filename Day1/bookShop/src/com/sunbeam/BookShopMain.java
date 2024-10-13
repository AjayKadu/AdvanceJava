package com.sunbeam;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookShopMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
       /*  // Find customer by Email
        
		try (CustomerDao c2 = new CustomerDao()) {
			
			System.out.print("Enter a Email: ");
			String email = sc.nextLine();
			Customer cust = c2.findByEmail(email);
			System.out.println(cust);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		*/

		/* // Add Customer
		
		try (CustomerDao c1 = new CustomerDao()) {

			System.out.print("Enter Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			System.out.print("Enter Password: ");
			String password = sc.nextLine();
			System.out.print("Enter Mobile No: ");
			String mobile = sc.nextLine();
			System.out.print("Enter Address: ");
			String address = sc.nextLine();
			System.out.print("Enter Email: ");
			String email = sc.nextLine();
			System.out.println("Enter Birth Date e.g(yyyy-mm-dd): ");
			String birth = sc.nextLine();
			Date birth1 = Date.valueOf(birth);

			Customer cs = new Customer(id, name, password, mobile, address, email, birth1);

			int count = c1.addCustomer(cs);
			System.out.println(count);
		  } 
		    catch (Exception e) {
			e.printStackTrace();
		}
	*/	

	/*
	 	// Find All Books
		
		try (BookDao b1 = new BookDao()) {

			List<Book> list = b1.findAllBook();
			for (Book book : list) {
				System.out.println(book);
			}
        }
		catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
    /*		
		// Find All Subject

		try(BookDao b2 = new BookDao()){
			
			List<String> list = b2.findAllSubject();
			for (String book : list) {
				System.out.println(book);
			}
		 }
		catch (Exception e) {
			e.printStackTrace();
		}

    */		


	 /*
	      // Update into Books
	  
			try (BookDao b3 = new BookDao()) {
				
				System.out.print("Enter Id: ");
				int id = sc.nextInt();
				System.out.print("Enter Book name: ");
				String name = sc.next();
				sc.nextLine();
				System.out.print("Enter Author: ");
				String author = sc.next();
				System.out.print("Enter Subject: ");
				String subject = sc.next();
				System.out.print("Enter Price: ");
				double price = sc.nextDouble();

				Book boo = new Book(id, name, author, subject, price);

				int count = b3.update(boo);
				System.out.println(count);
			} 
			 catch (Exception e) {
				e.printStackTrace();
			}
        */
    
	/*
		
		// Delete By Id
        
		try (BookDao b4 = new BookDao()) {
            
			System.out.print("Enter id to Delete: ");
			int id = sc.nextInt();
			int count = b4.deletebyId(id);
		    System.out.println(count);
        }
		catch (Exception e) {
			e.printStackTrace();
		}
		
	*/
		
    /* 
	      // Insert into Books
	  
			try (BookDao b5 = new BookDao()) {
				
				System.out.print("Enter Id: ");
				int id = sc.nextInt();
				System.out.print("Enter Book name: ");
				String name = sc.next();
				sc.nextLine();
				System.out.print("Enter Author: ");
				String author = sc.next();
				System.out.print("Enter Subject: ");
				String subject = sc.next();
				System.out.print("Enter Price: ");
				double price = sc.nextDouble();

				Book boo = new Book(id, name, author, subject, price);

				int count = b5.save(boo);
				System.out.println(count + " Row Sussesfuly Added");
			} 
			 catch (Exception e) {
				e.printStackTrace();
			}
     */ 	
	
	 /*	
		// Find By Id
        
				try (BookDao b6 = new BookDao()) {
		            
					System.out.print("Enter id to Find: ");
					int id = sc.nextInt();
					Book b = b6.findbyId(id);
				    System.out.println(b);
		        }
				catch (Exception e) {
					e.printStackTrace();
				}
	 */
		
	/*	
		// Find By Subject
        
				try (BookDao b7 = new BookDao()) {
		            
					System.out.print("Enter Subject to Find: ");
					String sub = sc.nextLine();
					List<Book> list = b7.findbySubject(sub);
				    for (Book book : list) {
						System.out.println(book);
					}
		        }
				catch (Exception e) {
					e.printStackTrace();
				}
		
		
	*/	
                   
      }

   }
