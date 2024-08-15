package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private String email;
	private int maxemailcapacity = 500;
	private int defaultpasslength = 8;;
	private String alternateEmail;
	private String companysuffix = "anycompany.com";
	
	//constructor to receive lastname and firstname;
	public Email(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created:"+this.firstName+" "+this.lastName);
				
		//call a method to get department
		this.department=setDepartment();
		System.out.println("Department :"+this.department);
		
		this.password = randomPassword(defaultpasslength);
		System.out.println("Your password is  : "+this.password+" Dont share with anyone.");
		
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companysuffix;
		System.out.println("Your email is: "+email);
	}
	
	
	
	
	// enter department
	private String setDepartment() {
		System.out.print("Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code:");
		Scanner sc = new Scanner(System.in);
		int depChoice= sc.nextInt();
		if(depChoice==1) {
			return "sales";
		}
		else if(depChoice==2) {
			return "development";
		}
		else if(depChoice==3) {
			return "accounting";
		}
		else {
			return "";
		}
	}
	// generate password;
	private String randomPassword(int length) {
		String passString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random()*passString.length());
			password[i]=passString.charAt(rand);
		}
		return new String (password);
		
	}
	
	// set max mailbox capacity
	public void setmaxemailcapacity(int capacity) {
		this.maxemailcapacity = capacity;
	}
	
	// set alternate email;
	
	public void setAlternateEmail(String altemail) {
		this.alternateEmail = altemail;
	}
	
	//change password on 1st login
	
	public void changePass(String pass) {
		this.password = password;
	}
	
	public int getMaxEmailCapacity(){ return maxemailcapacity;}
	public String getAlternateEmail(){ return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Display Name: "+firstName+" "+lastName+
				"\nCompany Email: "+email+
				"\nMail Capacity: "+maxemailcapacity;
	}
	
}
