package src;
/**
 * An driver program used to test out the <CODE>PersonDataManager</CODE>
 * written as part of this assignment.  The user can use the commands below
 * to perform operations on <CODE>PersonDataManager</CODE> objects.
 * <dt><b>Commands:</b><dd>
 * 		(I) - Import from File
		(A) - Add Person
		(R) - Remove Person
		(G) - Get Info on Person
		(P) - Print Table
		(S) - Save to File
		(Q) - Quit
 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class PersonManager {
    static PersonDataManager personDataManager = new PersonDataManager();
    
    /**
     * Main function that calls the function based on the user's input.
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Scanner for input
        String choice = "";
        
        boolean isImported = false;
        
        // A while loop to ask for an input from the user which does not terminate until the user input's "Q"
        while (true) {
            System.out.println("Menu ");
            System.out.println("(I) - Import from File");
            System.out.println("(A) - Add Person");
            System.out.println("(R) - Remove Person");
            System.out.println("(G) - Get Info on Person");
            System.out.println("(P) - Print Table");
            System.out.println("(S) - Save to File");
            System.out.println("(Q) - Quit");
            choice = input.nextLine();
            choice = choice.toUpperCase();
            
            if (choice.equals("I")) {
                String filePath = "";
                try {
                    System.out.print("Please enter a file path: ");
                    filePath = input.nextLine();
                    filePath = "src/Homework1/" + filePath;
                    personDataManager.count(filePath);
                    // calls the static method buildFromFile in PersonDataManager
                    personDataManager.buildFromFile(filePath);
                    isImported = true;
                    System.out.println("Loading...");
                    System.out.println("Person data loaded successfully!");
                } catch (FileNotFoundException | IllegalArgumentException e) {
                    System.out.println("File is invalid ");
                }
                    
            } 
            
            else if (choice.equals("P")) {
                // Print the table in tabular format
                personDataManager.printTable();
            } 
            
            else if (choice.equals("A")) {
                
            	if (!isImported) {
                    System.out.println("Please import a file first.");
                    continue;
                }
                // initializes a person
                Person person = new Person();
                String name = "";
                String age = "";
                String height = "";
                String weight = "";
                String gender = "";
                try {
                    System.out.println("Please enter the name of the person:");
                    name = input.nextLine();
                    person.setName(name);
                    
                    System.out.println("Please enter the age:");
                    age = input.nextLine();
                    person.setAge(Integer.parseInt(age));
                    
                    System.out.println("Please enter the gender (M or F):");
                    gender = input.nextLine().toUpperCase();
                    if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
                        person.setGender(gender);
                    } else {
                        System.out.println("The input you entered is incorrect. Please try again!");
                        continue;
                    }
                    
                    System.out.println("Please enter the height (in inches): ");
                    height = input.nextLine();
                    if(height.length() == 1) {height+="0";}
                    person.setHeight(Double.parseDouble(height));
                    
                    System.out.println("Please enter the weight (in lbs): ");
                    weight = input.nextLine();
                    person.setWeight(Double.parseDouble(weight));
                    
                    personDataManager.addPerson(person);
                    System.out.println(name+" has been added to the list!");
                    
                } catch (IllegalArgumentException e) {
                    System.out.println("The input you entered is incorrect. Please try again!");
                } catch(PersonAlreadyExistException e) {
                	System.out.println("Person already exists!");
                }
            }
            else if(choice.equalsIgnoreCase("R"))
            {
            	if(isImported==false)
                {
            		System.out.println("Please enter a location");
                    continue;
                }
            	
                try {
                	System.out.println("Please enter the name of the person:");
                    String remove = input.nextLine();
                    //calls the method removePerson
                    personDataManager.removePerson(remove);
                    System.out.println(remove + " has been removed!");
                    }
                    catch(PersonDoesNotExistException e)
                    {
                    	System.out.println("Person does not exist");
                    }
             }
             else if(choice.equalsIgnoreCase("G"))
             {
            	 if(isImported==false)
                 {
            		 System.out.println("Please enter a location");
                     continue;
                 }
              try {
                  System.out.println("Please enter the name of the person:");
                    String name=input.nextLine();
                                        
                      personDataManager.getPerson(name);
                             }
                 catch(PersonDoesNotExistException e)
                          {
             System.out.println("Person does not exist");
                                   }
        }
             else if(choice.equalsIgnoreCase("S"))
    		{
    			if(isImported==false)
    			{
    				System.out.println("Please enter a location");
    			}
    			
    			
    			System.out.print("Please select a name for the file: ");
    			String fileName = input.nextLine();
    			if(fileName.substring(fileName.length()-4,fileName.length()).equals(".csv"))
    			{
    				String FilePath = "src/Homework1/" + fileName;
    			File output = new File(FilePath);
    			try
    			{
    				PrintWriter pw = new PrintWriter(output);
    				pw.append("Name,Sex,Age,Height (in),Weight (lbs)\n");
    				for(int i = 1; i<PersonDataManager.count;i++)
    				{
    					pw.append(PersonDataManager.people[i].toCsvString());
    				}
    				pw.close();
    				System.out.println("A file named "+fileName+" has been created!");
    			}
    			catch(FileNotFoundException e)
    			{
    				System.out.println("File not found");
    			}
    			}
    			else
    			{
    				System.out.println("Somrthing went wrong");
    			}
    			
    		}
            else if(choice.equalsIgnoreCase("Q")) 
            {
            	 System.out.println("Sorry to see you go :( !");
            	 input.close();
            	 break;
            }
        }
    }
}

                                

                            
