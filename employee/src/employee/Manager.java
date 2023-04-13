package employee;
import java.util.*;
import java.util.Scanner;

public class Manager {
	String str;
	int count=1;
	Integer sum=0;
    public Map<String,Integer> employeeAndAmount=new HashMap<String,Integer>();
    public int noOfEmployee;
    public Map<String,String> employeeAndManager=new HashMap<String,String>();
    public Map<String,Integer> managerAndAmount=new HashMap<String,Integer>();
   
    void underpaidManager() {
    	
    	//System.out.println(employeeAndManager);
    	Iterator<Map.Entry<String, String> > iterator = employeeAndManager.entrySet().iterator();
    	while (iterator.hasNext()) {
    		Map.Entry<String, String> entry= iterator.next();
    	//for(Map.Entry<String,String> entry:managerAndEmployee.entrySet()) {
    		String managerName=entry.getValue();
    		//System.out.println(managerName);
    		//str=entry.getKey();
			//sum=keyPresent(str);
    		//sum=checkEmployeeIsManager(str);
    		//count=1;
    		for(Map.Entry<String,String> entry1:employeeAndManager.entrySet()) {
    			str=entry1.getValue();
    			//System.out.println("inside nested for :"+managerName+" "+entry1.getValue());
    			if(managerName.equals(entry1.getValue()) && managerPresent(managerName)) {
    				count++;
    				str=entry1.getKey();
    				sum+=checkEmployeeIsManager(str);
    				sum+=keyPresent(str);
    				//System.out.println("inside underpaid for if :"+count+str);
    			}
    		}
    		if(managerAndAmount.isEmpty()) {
    		sum=sum/(count-1);
    		//System.out.println(managerName+"if");
    		managerAndAmount.put(managerName, sum);
    		//System.out.println(managerAndAmount);
    		}
    		else if(managerPresent(managerName))
    		{
    			sum=sum/(count-1);
    			//System.out.println(managerName+"else");
        		managerAndAmount.put(managerName, sum);
        		//System.out.println(managerAndAmount);
    		}
    		sum=0;count=1;
    	}
    	//System.out.println(managerAndAmount);
    }
    void isManagerUnderpaid() {
    	int c=0;
    	for(Map.Entry<String,Integer> entry:employeeAndAmount.entrySet()) {
    		//System.out.println("inside isManagerUnderpaid inside first for \n");
    		for(Map.Entry<String,Integer> entry1:managerAndAmount.entrySet()) {
    			//System.out.println("inside isManagerUnderpaid inside second for \n");
    			if(entry.getKey().equals(entry1.getKey())) {
    				//System.out.println("inside isManagerUnderpaid inside first if \n"+ entry1.getKey()+" "+entry1.getValue());
    				if(entry.getValue()<entry1.getValue()) {
    					//System.out.println("inside isManagerUnderpaid inside second if \n");
    					c++;
    					System.out.println("Underpaid Employee is "+ entry.getKey()+" and minimum salary should be "+entry1.getValue());
    				}
    			}
    		}
    	}
    	System.out.println("The count is : "+c);
    }
    Integer keyPresent(String str) {
    	Iterator<Map.Entry<String, Integer> > iterator = employeeAndAmount.entrySet().iterator();
    	Integer amount=0;
    	while (iterator.hasNext()) {
    		
            Map.Entry<String, Integer> entry= iterator.next();
            //System.out.println("inside keyPresent outside loop: \n"+entry.getKey()+" "+str);
            if (str.equals(entry.getKey())) {
            	//System.out.println("inside keyPresent inside loop\n");
                amount= entry.getValue();
            }
        }
    	return amount;
    }
    Boolean managerPresent(String str) {
    	Iterator<Map.Entry<String, Integer> >iterator = managerAndAmount.entrySet().iterator();
    boolean isKeyPresent = true;
    if(managerAndAmount.isEmpty()) {
    	isKeyPresent=true;
    	//System.out.println("inside managerPresent inside if \n");
    }
    else {
    	while (iterator.hasNext()) {

            Map.Entry<String, Integer>entry = iterator.next();
            if (str.equals(entry.getKey())) {
            	//System.out.println("inside managerPresent inside while if \n");
                isKeyPresent = false;
                break;
            }
            
        }
    }
    	return isKeyPresent;
    }
    Integer checkEmployeeIsManager(String s) {
    	Iterator<Map.Entry<String, String> > iterator = employeeAndManager.entrySet().iterator();
    	Integer amt=0;
    	while (iterator.hasNext()) {
    		
            Map.Entry<String, String> entry= iterator.next();
            //System.out.println("inside keyPresent outside loop: \n"+entry.getKey()+" "+str);
            if (s.equals(entry.getValue())) {
            	//System.out.println("inside keyPresent inside loop\n");
            	count++;
               amt+=keyPresent(entry.getKey());
            }
        }
        return amt;
    }
}
