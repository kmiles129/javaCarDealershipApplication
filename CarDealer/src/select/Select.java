package select;
import java.util.HashMap; // import the HashMap class
import java.util.Scanner;

public class Select {
	 // Create a HashMap object called newModelInformation
    HashMap<String, String> newModelSelection = new HashMap<String, String>();
    HashMap<String, String> oldModelSelection = new HashMap<String, String>();
    
    public void getSelect(String model, String age) {
    setHashMap(); // fills HashMap with keys and values
	     
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    
    if(age.equalsIgnoreCase("new")){
    	System.out.println(newModelSelection.get(model.toUpperCase()));
    	statment();
    	String input = myObj.nextLine();// Read user input
    	newchoice(input);			
	}		
    else if (age.equalsIgnoreCase("used")) {
    	statment();
    	String input = myObj.nextLine();// Read user input
    	oldchoice(input);
    }
    myObj.close();// Close Scanner Object
    System.exit(0);	
    }
    public void setHashMap(){
    	// Add keys and values (Model, Description)
    	newModelSelection.put("FUSION", "You have selected a New Ford Fusion. It is a well-rounded sedan with spirited handling and a roomy cabin."+
    	" The price is $20,000 before sales tax");
    	newModelSelection.put("M3", "You have selected a New BMW M3 Sedan. It dominates every scene with performance-focused engineering, design, and technology."
    		+ " The price is $45,000 before sales tax");
    	newModelSelection.put("DURANGO", "We have in stock a New Dodge Durango. Inside the Durango, a driver-centric cockpit surrounds you with performance-inspired design and available leather-trim seating."+
    	    	" The price is $47,000 before sales tax");
    	newModelSelection.put("CAMARO", "We have in stock a New Chevrolet Camaro. It comes standard with a turbocharged inline-4 engine that pumps out 275 hp and 295 lb-ft of torque."+
    	    	" The price is $39,000 before sales tax");
	    newModelSelection.put("Q7", "We have in stock a New Audi Q7. It comes with three rows of seating for up to seven passengers and a spacious cargo area."+
	        	" The price is $60,000 before sales tax");
	    
	    oldModelSelection.put("FUSION", "You have selected a New Ford Fusion. It is a well-rounded sedan with spirited handling and a roomy cabin."+
	        	" The price is $20,000 before sales tax");
	    oldModelSelection.put("M3", "You have selected a New BMW M3 Sedan. It dominates every scene with performance-focused engineering, design, and technology."
	        		+ " The price is $45,000 before sales tax");
	    oldModelSelection.put("DURANGO", "We have in stock a New Dodge Durango. Inside the Durango, a driver-centric cockpit surrounds you with performance-inspired design and available leather-trim seating."+
	        	    	" The price is $47,000 before sales tax");
	    oldModelSelection.put("CAMARO", "We have in stock a New Chevrolet Camaro. It comes standard with a turbocharged inline-4 engine that pumps out 275 hp and 295 lb-ft of torque."+
	        	    	" The price is $39,000 before sales tax");
    }
    public void newchoice(String choice) {
        if(choice.equalsIgnoreCase("buy")){
    		System.out.println("Congratulations on your new purchase, please drive your newly purchased vehicle responsibly!");			
    	}		
        else if (choice.equalsIgnoreCase("decline")) {
        	System.out.println("Thank you for stoping by today, we hope to see you soon!");
        }
    }
    public void oldchoice(String choice) {

        if(choice.equalsIgnoreCase("buy")){
    		System.out.println("Congratulations on your new purchase, please drive your newly purchased vehicle responsibly!");			
    	}		
        else if (choice.equalsIgnoreCase("decline")) {
        	System.out.println("Thank you for stoping by today, we hope to see you soon!");
        }
    }
    public void statment() {
    	  System.out.println("If you would like to buy now, please type \"buy\"");
    	  System.out.println("If you don't wan't to buy now, please type \"decline\"");
    }
}
