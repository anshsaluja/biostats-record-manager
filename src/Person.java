/** An abstract data type done to serve as a representation of a 
* Person, containing the name, age, gender, height,
* weight and methods to change these values. 
*/
package src;

import java.util.*;
import java.io.File;

public class Person {
	private String name;
	private String  gender;
    private int age;
    private double height;
    private double weight; 
    /** No-Arg constructor
     * @custom.Postcondtion
     *      This object initializes to a default Person.
     */
	public Person() {
	}
	/**
     * Default constructor
     * @custom.Postcondtion
     *      This object initializes to an assigned with the name,age,gender,height and weight.
     */
	public Person(String name, String gender, int age, double height, double weight) {
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.height=height;
		this.weight=weight;
		
	}
	/**
     * A method to convert the information of the person to be displayed neatly in a table
     * @return
     *      A string of information the person in a tabular format.
     */
	public String toString() { 
		return String.format("%-10s%-5d%-7s%-12.2f%-12.2f", name, age, gender, height, weight);
	}
	/**
     * Public getter method for the name variable.
     * @return
     *      The name of the Person called.
     */
	public String getName() {
		return name;
	}
	/**
     * Public getter method for the gender member variable.
     * @return
     *      The gender of the Person.
     */
	public String getGender() {
		return gender;
	}
	/**
     * Public getter method for the age member variable.
     * @return
     *      The age of the Person.
     */
	public int getAge() {
		return age;
	}
	/**
     * Public getter method for the height member variable.
     * @return
     *      The height of the Person.
     */
	public double getHeight() {
		return height;
	}
	/**
     * Public getter method for the weight member variable.
     * @return
     *      The weight of the Person.
     */
	public double getWeight() {
		return weight;
	}
	/**
     * Public setter method for the name member variable.
     * @param name
     *      The new name of this person. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new name of the person. This parameter should not have any digits or shall not be empty
     * @throws IllegalArgumentException
     * 		Thrown if name is null or has any digits.
     */
	public void setName(String name) throws IllegalArgumentException { //.matches not sure
		if(name!=null && name.matches(".*\\d.*")) {
			throw new IllegalArgumentException("Wrong Input");
		}
		else {
			this.name = name;
		}
		
	}
	/**
     * Public setter method for the gender member variable.
     * @param gender
     *      The new gender of the person. This parameter should not be null or have other input except M or F
     * @custom.Precondition
     *      The new gender of the person. This parameter should not be null or has other input except M or F
     * @throws IlleaglArgumentException
     * 		Thrown if gender is null or has any digits
     */
	public void setGender(String gender) throws IllegalArgumentException{ // use .matches if possible
		if((gender.equals("M")) || (gender.equals("F"))) {
			
			this.gender = gender;
		}
		else {
			throw new IllegalArgumentException("Wrong Input");
		}
		
	}
	/**
     * Public setter method for the age member variable.
     * @param age
     *      The new age of the person. This parameter should not be null or have input less than 0 or have any alphabets
     * @custom.Precondition
     *      The new gender of the person. This parameter should not be null or have input less than 0 or have any alphabets
     * @throws IlleaglArgumentException
     * 		Thrown if age <0
     */
	public void setAge(int age) throws IllegalArgumentException{
		if(age<0) {
			
			throw new IllegalArgumentException("Wrong Input");
		}
		else {
			this.age=age;
		}
		
		}
	/**
     * Public setter method for the height member variable.
     * @param weight
     *      The new weight of the person. This parameter should not be null or have input less than 0 or have any alphabets
     * @custom.Precondition
     *      The new weight of the person. This parameter should not be null or have input less than 0 or have any alphabets
     * @throws IlleaglArgumentException
     * 		Thrown if weight <0
     */
	public void setWeight(double weight) throws IllegalArgumentException {
		if(weight<0) {
			throw new IllegalArgumentException(" Wrong Input ");
		}
		else {
			this.weight= weight;
		}
	}
	/**
     * Public setter method for the height member variable.
     * @param height
     *      The new height of the person. This parameter should not be null or have input less than 0 or have any alphabets
     * @custom.Precondition
     *      The new height of the person. This parameter should not be null or have input less than 0 or have any alphabets
     * @throws IlleaglArgumentException
     * 		Thrown if height <0
     */
	public void setHeight(double height) throws IllegalArgumentException {
		if(height<0) {
			throw new IllegalArgumentException(" Wrong Input ");
		}
		else {
			this.height= height;
		}
	}
	/**
     * A method to convert the information of the person to be displayed neatly in a file
     * @return
     *      A string of information the person in proper format.
     */
	public String toCsvString()
	{
		String answer = "";
		answer += name+",";
		answer += gender+",";
		answer += age+",";
		answer += height+",";
		answer += weight+"\n";

		return answer;
	}
	
	public String heightinFt(double height) {
		int ft;
		int in;
		ft = (int)height/12;
		in = (int)height - ft*12;

		return ft + " feet " + in + " inches";
		}
}


