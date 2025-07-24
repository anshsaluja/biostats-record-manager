/**
 * An abstract data type meant to serve as a representation of a 
 * slide, containing the title, bullet points, duration
 * and with methods to manipulate these values. 
 */
package src;
import java.util.*;
import java.io.*;
public class PersonDataManager {
     static int count;
     static Person[] people;
     
     /**
      * Returns the number of lines in the file to initialize the people array 
 	 * @param location
 	 * 		Location of the file
      * @return
      *      The number of lines in the file.
 	 * @throws FileNotFoundException
 	 * 		Thrown if the file cannot be found since the name of the file is incorrect
      */
     public static int count(String location) throws FileNotFoundException
 	{
 		int numOfLines=1;
 		try {
 			File myObj = new File(location);
 			Scanner myReader1 = new Scanner(myObj);
 		    myReader1.nextLine();
 		    while(myReader1.hasNextLine())
 		    {
 		    	myReader1.nextLine();
 		    	numOfLines++;
 		    }
 		    System.out.println();
 			//intitalize the array with a fixed value
 			people =new Person[numOfLines];
 			count=numOfLines-2;
 		    return numOfLines;
 	      }
 	      catch(FileNotFoundException e)
 	      {
 	    	  throw new FileNotFoundException();
 	      }
 	}

     /**
      * Reads the file input from the user and stores it in the people array. 
 	 * @param location
 	 * 		Name of the file
      * @throws IllegalArgumentExcpetion
      *      Thrown if values stored in the file are incorrect.
 	 * @throws FileNotFoundException
 	 * 		Thrown if the file name is incorrect since the file could not be found and read.
      */
    public void buildFromFile(String location) throws IllegalArgumentException, FileNotFoundException {
    	for(int i = 0; i<PersonDataManager.count;i++) 
        {
        	PersonDataManager.people[i] = new Person();
        }
        File newFile = new File(location);
        Scanner input = new Scanner(newFile);
        input.nextLine();

        int index = 0;

        while (input.hasNextLine()) {
            if (index == 18) {
                break;
            }
            String row = input.nextLine();
            row = row.replace("\"", "");
            String[] array = row.split(",");

            for (int i = 0; i < array.length; i++) {
                array[i] = array[i].trim();
            }

            for (int i = 0; i < array.length; i++) {

                switch (i) {
                    case 0:
                        if ((array[0].matches(".\\d."))) {
                            throw new IllegalArgumentException();
                        } else {
                            people[index].setName(array[0]);
                            ;
                        }
                        break;

                    case 1:

                        people[index].setGender(array[1]);
                        break;

                    case 2:
                        people[index].setAge(Integer.parseInt(array[2]));

                    case 3:
                        people[index].setHeight(Double.parseDouble(array[3]));
                        break;

                    case 4:
                        people[index].setWeight(Double.parseDouble(array[4]));
                        break;
                }
            }
            index++;
        }
    }

    /**
     * Ensures the capactiy of the array so that the enough data can be stored.
     * @param capacity
     *      The array size is increased to new size
     * @custom.Precondition
     *      The Capacity is greater than the previous capacity
     * @custom.Postcondition
     *  	The array size has been increased to gretr amount so that more person can be added.   
     */
    public void  ensureCapacity() {
        Person[] bigPeople = new Person[2 * people.length + 1];//Newer array
        System.arraycopy(people, 0, bigPeople, 0, people.length);
        people = bigPeople;
        for(int i=count; i< people.length ; i++)//Initiallizing newer array
        {
            people[i] = new Person();
        }
    }


    /**
     * Adds a new person to the list in alphabetical order.
     * If the list is full, the size of the list is increased.
     * Throws an exception if a person with the same biological statistics already exists in the list.
     *
     * @param newPerson the Person object to be added to the list
     * @throws PersonAlreadyExistException if a person with the same biological statistics already exists in the list
     */
    public void addPerson(Person newPerson) throws PersonAlreadyExistException {
        // Check that the newPerson parameter is not null
        if (newPerson == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        // If the list is full, increase its size
        if (count == people.length) {
            ensureCapacity();
        }

        // Find the index where the new person should be inserted
        int insertIndex = 0;
        int c = 0;
        for(int i=0 ; i<count; i++)
        {
            c = people[i].getName().compareToIgnoreCase(newPerson.getName());

            if(c > 0)
            {
                insertIndex = i;
                break;
            }
            else if( c == 0)
            {
                throw new PersonAlreadyExistException();
            }
            
            if(i != 0 && insertIndex == 0) 
            {
            	insertIndex = count;
            }
        }

        // Shift existing elements to make room for new person
        for (int i = count - 1; i >= insertIndex; i--) {
            people[i + 1] = people[i];
        }

        // Insert new person
        people[insertIndex] = newPerson;
        count++;
    }

    /**
     * Returns the person with the given name in the people array.
     * @param name
     *      The person is returned if the person is present in the array.
     * @custom.Precondition
     *      Name is not null
     * @custom.Postcondition
     *  	Person has been returned
	 * @throws PersonDoesNotExistException
	 * 		Thrown if the person with the given name is entered but it does not exist in the array.    
     */
    public void getPerson(String name) throws PersonDoesNotExistException
    {
        Person toGet = new Person();// To store the person to be printed
        boolean check = true;

        if(name == null)
        {
            throw new PersonDoesNotExistException();
        }

        int m = 0;
        for(int i = 0; i<count ; i++)
        {
            if(people[i].getName().equalsIgnoreCase(name))
            {
                toGet = people[i];
                m = i;
                check = false;
                break;
            }
        }

        String g = "";// To express M and F as male and female
        if(people[m].getGender().equals("M")){
            g = "Male";
        }
        else{
            g = "Female";
        }

        if(check)
        {
            throw new PersonDoesNotExistException();
        }

        System.out.println(toGet.getName() + " is a " + toGet.getAge() + " year old " + g + " who is " +
                Math.floor(toGet.getHeight() / 10) + " feet " + toGet.getHeight() % 10 + " inches and weighs " +
                toGet.getWeight() + " pounds.");
    }

    /**
     * The person with the given name is removed from the array.
     * @param name
     *      The person is removed if the person exists in the array.
     * @custom.Precondition
     *      Name is not null
     * @custom.Postcondition
     *  	Person is removed
	 * @throws PersonDoesNotExistException
	 * 		Thrown if the person with the given name is entered but it does not exist in the array.    
     */
    public void removePerson(String name) throws PersonDoesNotExistException
    {
        int counter = 0;
        if(name == null)
        {
            throw new PersonDoesNotExistException();
        }

        Person[] newPerson = new Person[people.length];// New array to copy the original array without the person to be removed

        for(int i=0 ; i< newPerson.length ; i++)
        {
            newPerson[i] = new Person();
        }
        int i=0;
        for(i=0 ; i<count ; i++)
        {
            if(!(people[i].getName().equalsIgnoreCase(name)))
            {
                newPerson[counter] = people[i];
                             counter++;
            }
            
        }
        if(i==counter)
        {
        	throw new PersonDoesNotExistException();
        }
//        else {
//        	count--;
//        }
        people = newPerson;
    }
    
    /**
     * The people array is printed.
     * @custom.Postcondition
     *  	People array is printed
     */
    public void printTable()
    {
        System.out.print("    Name     |     Age     |    Gender    |    Height          |    Weight");
        System.out.println();
        System.out.println("===============================================================================");
        //loop helps to print the people array
        for(int i=0;i<count;i++)
		{
			if(people[i].getName()!=null)
				{
					System.out.printf("    %s     |     %d      |      %s       | %s", people[i].getName(), people[i].getAge(), people[i].getGender(), people[i].heightinFt(people[i].getHeight()) + "    |");
					System.out.printf("   %.0f",people[i].getWeight());
					System.out.println(" pounds");
				}
		}
                    }
    }
