package requestInfo;
import java.util.Scanner;
import java.util.HashMap; // import the HashMap class
import select.Select;

public class Vehicle {
	Boolean request, requestAge, proceed;
	private String model, make, ageType;
	String[] makesInStock = {"BMW","Ford","Dodge","Chevrolet","Cadillac","Audi"};
	String[] modelsInStock = {"M3","Fusion","Durango","Camaro","ATS-V", "Q7"};
	String[] newVehiclesInStock = {"M3","Fusion","Durango","Camaro","ATS-V","Q7"};
	String[] usedVehiclesInStock = {"M3","Fusion","Durango","Camaro","ATS-V"};
	// Create a HashMap object called newModelInformation and oldModelInformation
    HashMap<String, String> newModelInformation = new HashMap<String, String>();
    HashMap<String, String> oldModelInformation = new HashMap<String, String>();
    
	public void openVehicleDealership() {
		loadHashMap();
		greet();
		
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    String input = myObj.nextLine();// Read user input
	    make = input;
	    
    	    if (checkMake(input)) { // If checkMake finds "Make" then processed to the next question
    	    	System.out.println("Good choice, now what "+ make+" model would you like?");
    	    	input = myObj.nextLine();// Read user input
    	    	model = input;

		    	if (checkModel(input)) {// If checkModel finds "Model" then processed to the next question
		    		System.out.println("Good choice, would you like a "+model+" that is new or used?");
		    		input = myObj.nextLine();// Read user input
		    		ageType= input;   
		    		
	    	    	if (checkAge(input)) {// If checkAge finds New or Used Model, proceed with description
	    	    		if (input.equalsIgnoreCase("new")) {
	    	    		System.out.println(newModelInformation.get(model.toUpperCase()));
	    	    		}
	    	    		else if (input.equalsIgnoreCase("used")) {
	    	    			System.out.println(newModelInformation.get(model.toUpperCase()));
	    	    		}
	    	    	    System.out.println("Type: \"back\"  To look up another vehicle"); // Prints out statement
	    	    	    System.out.println("Type: \"select\"  To select "+ input +" " + make +" "+ model); // Prints out statement
	    	    	    
	    	    	    while (!checkProceed(input = myObj.nextLine())) { // Ask buy if they want to select or go back
	 	    	    	    checkProceed(input = myObj.nextLine());
	    	    	    }  	    	    
	    	    	}    	    	
		    	}   		 
		    } 	    	 	    
    		myObj.close();// Close Scanner Object
    		System.exit(0);		
	}
	// Method to load up Hash Map key and values
	public void loadHashMap() {
		// Add keys and values (Model, Description)
	    newModelInformation.put("FUSION", "We have in stock a New Ford Fusion. It is a well-rounded sedan with spirited handling and a roomy cabin");
	    newModelInformation.put("M3", "We have in stock a New BMW M3 Sedan. It dominates every scene with performance-focused engineering, design, and technology.");
	    newModelInformation.put("DURANGO", "We have in stock a New Dodge Durango. Inside the Durango, a driver-centric cockpit surrounds you with performance-inspired design and available leather-trim seating.");
	    newModelInformation.put("CAMARO", "We have in stock a New Chevrolet Camaro. It comes standard with a turbocharged inline-4 engine that pumps out 275 hp and 295 lb-ft of torque.");
	    newModelInformation.put("Q7", "We have in stock a New Audi Q7. It comes with three rows of seating for up to seven passengers and a spacious cargo area.");
	       
	    oldModelInformation.put("FUSION", "We have in stock an Old Ford Fusion. It is a well-rounded sedan with spirited handling and a roomy cabin");
	    oldModelInformation.put("M3", "We have in stock an Old BMW M3 Sedan. It dominates every scene with performance-focused engineering, design, and technology.");
	    oldModelInformation.put("DURANGO", "We have in stock an Old Dodge Durango. Inside the Durango, a driver-centric cockpit surrounds you with performance-inspired design and available leather-trim seating.");
	    oldModelInformation.put("CAMARO", "We have in stock an Old Chevrolet Camaro. It comes standard with a turbocharged inline-4 engine that pumps out 275 hp and 295 lb-ft of torque.");	
	}
	// Checks if Make exists in makeStock[] array.
	public boolean checkMake(String input) {
	try {
		int i = 0;
		while (!input.equalsIgnoreCase(makesInStock[i])) {
			i++;
		}
		this.request = input.equalsIgnoreCase(makesInStock[i]);
		}	
	catch(Exception e) {
		this.request = false;
		System.out.println("Sorry, we don't have any " + make +" in stock this week.");
    	System.out.println("Try Again Next Week, Have A Great Day!");    	
		}
		
		return request;
		}
	// Checks if Model exists in modelStock[] array.
	public Boolean checkModel(String input) {	
	try {
		int i = 0;
		while (!input.equalsIgnoreCase(modelsInStock[i])) {
		  i++;
		}
		this.request = input.equalsIgnoreCase(modelsInStock[i]);
		}
	catch(Exception e) {
		this.request = false;
		System.out.println("Sorry, we don't have any " + make +" "+ model +" in stock this week.");
		System.out.println("Try Again Next Week, Have A Great Day!");
		}
	
		return request;
	}
	// Checks if New or Old car exists in modelStock[] array.
	public Boolean checkAge(String input) {	
		//try {
		if(input.equalsIgnoreCase("New")){
			int i = 0;
			while (!model.equalsIgnoreCase(newVehiclesInStock[i])) 
			i++;				
		
			this.requestAge = model.equalsIgnoreCase(newVehiclesInStock[i]);
		}		
		else if(input.equalsIgnoreCase("Used")) {	
			int i = 0;
			while (!model.equalsIgnoreCase(usedVehiclesInStock[i])) 
			i++;	
			this.requestAge = model.equalsIgnoreCase(usedVehiclesInStock[i]);
		}
		else {
			this.requestAge = false;
			System.out.println("Sorry, we don't have any "+ input +" " + make +" "+ model + " in stock this week.");
    		System.out.println("Try Again Next Week, Have A Great Day!");
		}
			
		return requestAge;	
	}
	
	// Checks Buyer wants to go back to look up another car or Select car.
		public Boolean checkProceed(String input) {	
		
			if(input.equalsIgnoreCase("Back")) {			
				openVehicleDealership();
				 this.proceed = true;
			}
			else if(input.equalsIgnoreCase("Select")) {			
				Select select = new Select(); // Proceeds to selection view
				select.getSelect(model,ageType);
				 this.proceed = true;
			}
			else {
				//System.out.println("else");
				this.proceed = false;
				System.out.println("Type: \"back\"  To look up another vehicle"); // Prints out statement
  	    	    System.out.println("Type: \"select\"  To select "+ input +" " + make +" "+ model); // Prints out statement
			}
			
			return proceed;
		}
		public void greet(){
			System.out.println("Welcome to BTOWN dealership. The best prices in town!"); // Prints out statement
			System.out.println("My name is Henry, what car make are you looking for today?"); // Prints out statement
		}
	}
