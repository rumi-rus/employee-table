package employee;

import java.util.Scanner;

public class MainManager {

	public static void main(String[] args) {
		
		Manager M1=new Manager();
		String responce="yes";
		int countOfRelation=0;
		Scanner sc=new Scanner(System.in);
		Scanner in=new Scanner(System.in);
	    System.out.println("enter the name and salary respectively: ");
	   do {
		   System.out.println("enter name :");
		   String name=sc.next();
		   System.out.println("enter salary :");
	    	Integer amount=in.nextInt();
	    	M1.employeeAndAmount.put(name,amount);
	    	System.out.println("are there more employees ? ");
	    	responce=sc.next();
	   }while(!responce.equals("no"));
	    
	    do{
	    	System.out.println("enter the manager : ");
	    	String mName=sc.next();
	    	System.out.println("Are there any subordinate ? ");
	    	responce=sc.next();
	    	while(responce.equals("yes")) {
	    	System.out.println("enter the subordinate : ");
	    	String eName=in.next();
	    	M1.employeeAndManager.put(eName,mName);
	    	countOfRelation++;
	    	System.out.println("Are there any subordinate ? ");
	    	responce=sc.next();
	    	}
	    	System.out.println("is there another manager ? ");
	    	responce=sc.next();
	    }while(!responce.equals("no"));
	    M1.underpaidManager();
	    M1.isManagerUnderpaid();
	}

}
