/*
Name: Ayden Khairis
Student Number: C3282229
Date: 01/06/2018
Description:
This is a veterinary clinic program which allows the user input an unlimited amount of doctors and pets,
delete doctors and pets,print doctors and pets, assign doctors to pets, print a doctor's patients, and 
analyse a pet as to whether it is overweight or not. Users can also edit pet information, read information
from a file, and add/save information to a file. 
*/

import java.util.*;
import java.io.*;

public class Clinic2
{
     //Initialising starting variables
     private Doctor2[] doctorList;
     private Pet2[] petList;
     final private int initialSize = 3;
     private String fileName = "VetManagement.txt";
     private int doctors = 0;
     private int counter;
     private int pets = 0;
     static Scanner console = new Scanner(System.in);
     

     private void run() 
     {
        //Initialising doctor and pet arrays
        doctorList = new Doctor2[initialSize];
        petList = new Pet2[initialSize];
		int option;
		//The menu the user can select from
        do
        {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ");
        System.out.println("Menu:");
        System.out.println("Please select a menu item by entering the corresponding number");
        System.out.println("[01] - Enter a New Doctor");
        System.out.println("[02] - Print Doctors List");
        System.out.println("[03] - Delete a Doctor");
        System.out.println("[04] - Add a Pet");
        System.out.println("[05] - Print all Pets");
        System.out.println("[06] - Delete a Pet");
        System.out.println("[07] - Assign a Doctor to a Pet");
        System.out.println("[08] - Print a Doctor's Patients");
        System.out.println("[09] - Analyse a Pet");
        System.out.println("[10] - Edit Pet Information");
        System.out.println("[11] - Import File");
        System.out.println("[12] - Save File");
        System.out.println("[0]  - Close program");
        System.out.println("--------------------------------------------------------------- ");
        
        option = console.nextInt();
        
        //Switch case so the user can select the option they would like the pick
        	switch (option)
            {
            case 1: addDoctor();
                    break;
            case 2: printDoctors();
            		break;
            case 3: deleteDoctor();
            		break;
            case 4: addPet();
            		break;
            case 5: printPets();
            		break;
            case 6: deletePet();
            		break;
            case 7: assignDoctor();
            		break;
            case 8: printDoctorsList();
            		break;
            case 9: petAnalysis();
            		break;
            case 10:editPet();
            		break;
            case 11:importFile();
            		break;
            case 12:fileSave();
            		break;
            case 0: break;
            }
        }
        while (option!=0);
        
        }

        //This method checks the name of the doctors
        public int doctorNameCheck(String name)
		{
		int check = 0;
			for (int i = 0; i < doctorList.length; i++)
			{
				if(doctorList[i] != null && name.equalsIgnoreCase(doctorList[i].getName()))
					{
						check++;
						break;
					}
			}
		return(check);
		}

		//This method checks the name of the pets
        public int petNameCheck(String name)
        {
            int checked = 0;
            for (int i=0;i<petList.length;i++)
            {

                if (petList[i] != null && name.equalsIgnoreCase(petList[i].getName()))
                {
                	checked++;
                    break;
                 }
            }
            return(checked);
        }

        //This method resizes the array to allow for more doctors to be added
        public void addDoctorSpace(int currentLength)
        {
            Doctor2[] tempAry = new Doctor2[currentLength + 1];
            for (int i=0; i<currentLength; i++)
            {
                tempAry[i] = doctorList[i];
            }
            doctorList = tempAry;
        }
        
        //This method resizes the array to allow for more pets to be added
        public void addPetSpace(int currentLength)
        {
            Pet2[] tempAry = new Pet2[currentLength + 1];
            for (int i=0; i<currentLength; i++)
            {
                tempAry[i] = petList[i];
            }
            petList = tempAry;
        }

        //This method adds a new doctor
        public void addDoctor()
        {
            console.nextLine();
           
            String name,specialisation;
            counter = 0;
                do{
                        if (counter > 0)
                        {
                            System.out.println("A doctor by that name exists, please try again.");
                        }

                   		System.out.print("Please enter the new doctor's name: ");
		                name = console.nextLine();
		                counter++;

                    	}while(doctorNameCheck(name) != 0);
            
            counter = 0;
            do
            {
                if (counter > 0)
                    {
                        System.out.println("Please enter specialisation that is either dog or cat.");
                    }
                    System.out.print("What do you specialise in: ");
                    specialisation=console.nextLine();                    
                    counter++;

    	    }while(!(specialisation.equalsIgnoreCase("dog") || specialisation.equalsIgnoreCase("cat")));
                    System.out.println("Specialisation = "+specialisation);

                    if (doctors == doctorList.length)
                    {
                        addDoctorSpace(doctorList.length);
                    }

                    for (int i=0; i<doctorList.length; i++)
                    {
                        if (doctorList[i] == null)
                        {
                            doctorList[i] = new Doctor2(name, specialisation);
                            break;
                        }
                    }

                    doctors += 1;
        }
        
        //This method prints the doctor list
        public void printDoctors()
        {
        	for (int i=0; i<doctors; i++)
        	{
        		if (doctorList[i] != null)
        		{
        			System.out.println(doctorList[i].getName()+ " - specialises in " +doctorList[i].getSpecialisation()+"s");
        		}        	
      		}
      		if (doctors == 0)
      		{
				System.out.println("There are no doctors in the system.");
      		}
        	
        }

        //This method deletes a doctor
        public void deleteDoctor()
        {
			String name;
			counter = 0;
        	if (doctors != 0)
        	{	
                console.nextLine();
                do{
                    if (counter > 0)
                    {
                        System.out.println("A doctor by that name doesn't exist, please try again.");
                    }
                   
                   	System.out.print("Please enter the doctor you want to delete: ");
		            name = console.nextLine();
		            counter++;
                    
                    }while(doctorNameCheck(name) == 0);
                    doctors -= removeDoctor(name);
                    System.out.println("Doctor was deleted. ");
        	}
        	else
        		System.out.println("There are no doctors in the system.");
        }
       
        //This method removes a doctor from the array
        public int removeDoctor(String name)
        {
        	int delete = 0;
        	int position = 0;

        	for (int i=0; i<doctors; i++)
        	{
        		if (doctorList[i] != null && name.equalsIgnoreCase(doctorList[i].getName()))
        		{
        			doctorList[i] = null;
        			delete = 1;
        			position = i;
        			for (int j=0; j<pets; j++)
        			{
        				if (name.equalsIgnoreCase(petList[j].getDoctor()))
        					petList[j].setDoctor("no doctor assigned. ");
        			}
        		}
        	}
        	return delete;
        }

        //This method adds a pet
        public void addPet()
        {
            console.nextLine();
           
            String name,type,size;
            double weight = 0;
           	int age = 0;

            counter = 0;
                do{
                    if (counter > 0)
                    {
                        System.out.println("A pet by that name exists, please try again.");
                    }

                   	System.out.print("Please enter the new pet's name: ");
		            name = console.nextLine();
		            counter++; 

                   	}while(petNameCheck(name) != 0);
            
            counter = 0;
            	do{
                    if (counter > 0)
                        {
                            System.out.println("Please enter pet type that is either dog or cat.");
                        }
                    System.out.print("Pet type: ");
                    type = console.nextLine();             
                    
                    counter++;
        			}while(!(type.equalsIgnoreCase("dog") || type.equalsIgnoreCase("cat")));
                    System.out.println(""+name+"'s type = "+type+". ");

            counter = 0;
            	do 
                    {
                    if (counter > 0)
                        {
                            System.out.println("Please enter small, medium or large.");
                        }
                    System.out.print("What is the size of "+name+": ");
                    size=console.nextLine();

                    counter++;
                    
					}while(!(size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")));
                    System.out.println(""+name+"'s size = "+size+". ");

            counter = 0;
            	do 
           		{
               		if (counter > 0)
                	{
                		System.out.println("A negative weight is not possible. ");
                		System.out.println("Please re-enter the weight of your pet: ");
                	}
                	System.out.print("What is the weight of "+name+" in kilograms: ");
                	weight=console.nextDouble();

                	counter++;
                }while(!(weight > 0));
                System.out.println(""+name+"'s weight = "+weight+" kilograms.");
                
            counter = 0;
            	do 
            	{
                	if (counter > 0)
                	{
                		System.out.println("A negative age is not possible. ");
                		System.out.println("Please re-enter the age of your pet: ");
                	}
                	System.out.print("What is the age of your pet: ");
                	age=console.nextInt();
                    
                counter++;
				
				}while(!(age > 0));
                System.out.println(""+name+"'s age = "+age+". ");
                System.out.println(""+name+" is currently not assigned to a doctor. ");

                if (pets == petList.length)
                {
                    addPetSpace(petList.length);
                }

                for (int i=0; i<petList.length; i++)
                    {
                        if (petList[i] == null)
                        {
                            petList[i] = new Pet2(type, size, name, weight, age);
                            break;
                        }
                    }

                    pets += 1;
        }
   
       	//This method prints the pets list
       	public void printPets()
        {
        	for (int i=0; i<pets; i++)
        	{
        		if (petList[i] != null)
        		{
        			System.out.println(petList[i].getName()+ " is a "+petList[i].getSize()+" "+petList[i].getType()+". ");
        			System.out.println(petList[i].getName()+ " weighs "+petList[i].getWeight()+" and is "+petList[i].getAge()+". ");
        			System.out.println(petList[i].getName()+ " is assigned to "+petList[i].getDoctor()+". ");
        		}        	
      		}
      		if (pets == 0)
      		{
				System.out.println("There are no pets in the system.");
      		}	
        }

        //This method deletes a pet
        public void deletePet()
        {
			String name;
			counter = 0;
        	if (pets != 0)
        	{	
                console.nextLine();
                do{
                    if (counter > 0)
                    {
                        System.out.println("A pet by that name doesn't exist, please try again.");
                    }
                    
                   	System.out.print("Please enter the pet you want to delete: ");
		            name = console.nextLine();
		            counter++;
                    
                    }while(petNameCheck(name) == 0);
                    pets -= removePet(name);
                    System.out.println("Pet was deleted. ");
        	}
        	else
        		System.out.println("There are no pets in the system.");
        }

        public int removePet(String name)
        {
        	int delete = 0;
        	int position = 0;

        	for (int i=0; i<pets; i++)
        	{
        		if (petList[i] != null && name.equalsIgnoreCase(petList[i].getName()))
        		{
        			petList[i] = null;
        			delete = 1;
        			position = i;
        			break;
        		}
        	}
        	return delete;
        }

        //This method assigns a doctor to a pet
        public void assignDoctor()
        {
		console.nextLine();
        String name = "";
		String pet = "";
		int p1 = -1;
		int returned = 0;
		String test = "";

		if (doctors != 0)
		{    
			do
        	{
				System.out.println("Please enter the name of the doctor you would like to assign a pet to: ");
				name=console.nextLine();

			}while(doctorNameCheck(name) == 0);
			System.out.println("You have selected "+name+". ");	

			do{
				System.out.println("Please select a pet you would like to assign this doctor to: ");
				pet=console.nextLine();

			}while(petNameCheck(pet) == 0);	
			System.out.println("You have selected "+pet+". ");

			for (int i = 0; i < doctorList.length; i++)
			{
        		if(doctorList[i] != null && doctorList[i].getName().equalsIgnoreCase(name))
        		{
            		p1 = i;
            		break;
        		}

    		}

    		for (int i=0; i<petList.length; i++)
    		{
        		if(petList[i] != null && petList[i].getName().equalsIgnoreCase(pet) && doctorList[p1].getSpecialisation().equalsIgnoreCase(petList[i].getType()))
        		{
            		if(!(petList[i].getDoctor().equalsIgnoreCase("No Doctor") || petList[i].getDoctor().equalsIgnoreCase("no doctor assigned")))
            		{
                 		System.out.println("This Pet already has a Doctor. Would you like to overwrite this? ");
                 		System.out.println("Enter yes to overwrite or enter any-other value to cancel. ");
                 		test = console.nextLine();
                		if(!(test.equalsIgnoreCase("Yes")))
                		{
                    	System.out.println("Doctor Assignment Canceled. ");
                    	}
                    	else
	                	{
	                   		petList[i].setDoctor(name);
	                   		returned = 1;
	                	}
	            	}
	            	else
	            	{
	               		petList[i].setDoctor(name);
	               		returned = 1;
	            	}
	           	}   
        	}

		    if (returned == 1)
		    {
		        System.out.println("Doctor successfully assigned. "); 
		    }
		    else
		    {
		        System.out.println("There was an error with your assignment. "); 
		        System.out.println("Please make sure that you input the name of a current pet and a doctor that specialises in that pet's type. "); 
		    }
	    }
		else
		System.out.println("There are no doctors in the system. ");
		}

	//This method prints the list of pets assigned to any one doctor
	public void printDoctorsList()
	{
		console.nextLine();
		String name = "";
		String pet = "";
        
		if (doctors != 0)
		{
			do
        	{
			System.out.println("Please enter the name of the doctor you would like to print a patient list for: ");
			name=console.nextLine();
			}while(!(doctorNameCheck(name) > 0));
			System.out.println("You have selected "+name+". ");
				for (int j=0; j<pets; j++)
				{
					if (pets != 0 && petList[j].getDoctor().equalsIgnoreCase(name))
					{
					
						System.out.println("- " + petList[j].getName());
					}
				}	
		}
		else
		System.out.println("There are no doctors in the system. ");
	}


	//This method does the analysis of a pet
	public void petAnalysis()
	{
		console.nextLine();
		String name = "";
		String type = "No Type";
		String size = "No Size";
		double weight = 0;
		int age = 0;
		String analysis = "";

		if (pets != 0)
		{    
			do
        	{
				System.out.println("Please enter the name of the pet you would like to analyse: ");
				name=console.nextLine();
			}while(!(petNameCheck(name) > 0));

			for (int i=0;i<pets;i++)
            {
            	if (petList[i] != null && name.equalsIgnoreCase(petList[i].getName()))
            	{
				type = petList[i].getType();
				size = petList[i].getSize();
				weight = petList[i].getWeight();
				age = petList[i].getAge();
				analysis = analysedPet(type,size,weight);		
            	}
			
			}
			System.out.println("Pet: " + name);
			System.out.println("Type: " + type);
			System.out.println("Size: " + size);
			System.out.println("Weight: " + weight);
			System.out.println("Age: " + age);
			System.out.println("Analysis: " + analysis);
		}
		else
			System.out.println("There are no pets in the system. ");
	}

	//This checks the weight of the pet to see if it is overweight or not
	public String analysedPet(String pet, String size, double weight)
	{

		if (pet.equalsIgnoreCase("cat"))
		{
			if (size.equalsIgnoreCase("small"))
			{
				if (weight > 4)
				{
					return("Overweight");
				}
				else
				{	
					return("Correct Weight Range");
				}
			}
			else if (size.equalsIgnoreCase("medium"))
			{
				if (weight > 6)
				{
					return("Overweight");
				}
				else
				{
					return("Correct Weight Range");
				}
			}
			else if (size.equalsIgnoreCase("large"))
			{
				if (weight > 8)
				{
					return("Overweight");
				}
				else
				{
					return("Correct Weight Range");
				}
			}
		}
	
		if (pet.equalsIgnoreCase("dog"))
		{			
			if (size.equalsIgnoreCase("small"))
			{
				if (weight > 6)
				{		
					return("Overweight");
				}
				else
				{		
					return("Correct Weight Range");
				}
			}
			else if (size.equalsIgnoreCase("medium"))
			{
				if (weight > 9)
				{
					return("Overweight");
				}						
				else
				{
					return("Correct Weight Range");
				}
			}
			else if (size.equalsIgnoreCase("large"))
				{
					if (weight > 12)
					{
						return("Overweight");
					}
					else
					{
						return("Correct Weight Range");
					}
				}
		}	
		return ("Error - Please try again");
	}

	//This method allows the user to edit pet information
	public void editPet()
	{
		String name,type,size;
        double weight = 0;
        int age = 0;
        console.nextLine();
		
		if(pets != 0)
		{
			counter =0;
			int position = 0;;
			do
			{
                if (counter > 0)
                {
                    System.out.println("A pet by that name does not exist, please try again.");
                }
                
                System.out.print("Please enter the pet's name: ");
		        name = console.nextLine();
		        counter++; 

            }while(petNameCheck(name) == 0);

            for (int i = 0; i <petList.length; i++)
            {
           		if(petList[i].getName().equalsIgnoreCase(name))
           		{
           			position = i;
           			break;
           		}
            }

            counter = 0;
            do
            {
                if (counter > 0)
                {
                    System.out.println("Please enter pet type that is either dog or cat. ");
                }
                System.out.print("New pet type: ");
                type = console.nextLine();                 
                counter++;

        	}while(!(type.equalsIgnoreCase("dog") || type.equalsIgnoreCase("cat")));
            System.out.println(""+name+"'s type = "+type+". ");

            counter = 0;
            	do 
                {
                	if (counter > 0)
                	{
                    	System.out.println("Please enter small, medium or large. ");
                	}
                    System.out.print("What is the new size of "+name+": ");
                    size=console.nextLine();
                    counter++;
                    
				}while(!(size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")));
                System.out.println(""+name+"'s size = "+size+". ");

            counter = 0;
            do 
           	{
           		if (counter > 0)
               	{
               		System.out.println("A negative weight is not possible. ");
               		System.out.println("Please re-enter the weight of your pet: ");
               	}
               	System.out.print("What is the new weight of "+name+" in kilograms: ");
               	weight=console.nextDouble();
                counter++;

            }while(!(weight > 0));
            System.out.println(""+name+"'s weight = "+weight+" kilograms.");
                
            counter = 0;
            do 
           	{
              	if (counter > 0)
               	{
              		System.out.println("A negative age is not possible. ");
              		System.out.println("Please re-enter the age of your pet: ");
               	}
               	System.out.print("What is the new age of your pet: ");
               	age=console.nextInt();             
                counter++;
				
			}while(!(age > 0));
            System.out.println(""+name+"'s age = "+age+". ");
               

            if(!(petList[position].getType().equalsIgnoreCase(type)))
            {
                petList[position].setDoctor("no doctor assigned");
               	System.out.println("The doctor of " + name +" has been reset as the pet type has changed");
  			}
            petList[position].setName(name);
            petList[position].setType(type);
            petList[position].setAge(age);
            petList[position].setWeight(weight);
            petList[position].setSize(size);            
       }
       else
       {
			System.out.println("Please add a pet before attempting this function.");
       }
	}

	//This method allows the user to import a file
	public void importFile()
    {
        int n = -1;
        String line,name,type,size,doctor,specialisation;
        Double weight;
        int age;
        String[] input;

        try
        {
        Scanner inputStream = new Scanner(new File (fileName));

        while (inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            //Checks if the line is a data headding of pets and will set the state to 0 if it is
            if(line.equalsIgnoreCase("Pets"))
            {
                n = 0;
            }
             //Checks if the line is a data headding of doctors and will set the state to 1 if it is
            else if(line.equalsIgnoreCase("Doctors"))
            {
                n = 1;
            }
            else
            {
            	if (n == 0)
            	{
            		input = line.split(" ", 2);
                    type = input[1];

            		line = inputStream.nextLine();
                    input = line.split(" ", 2);
                    size = input[1];

                    line = inputStream.nextLine();
                    input = line.split(" ", 2);
                    name = input[1];

                    line = inputStream.nextLine();
                    input = line.split(" ", 2);
                    weight = Double.parseDouble(input[1]);

                    line = inputStream.nextLine();
                    input = line.split(" ", 2);
                    age = Integer.parseInt(input[1]);

                    line = inputStream.nextLine();
                    input = line.split(" ", 2);
                    doctor = input[1];

                    if(petNameCheck(name) == 0)
                    {
	                    if (pets == petList.length)
	                	{
	                    	addPetSpace(petList.length);
	                	}

	               		for (int i=0; i<petList.length; i++)
	                    {
	                        if (petList[i] == null)
	                        {
	                            petList[i] = new Pet2(type, size, name, weight, age);
	                            petList[i].setDoctor(doctor);
	                            break;
	                        }
	                    }

                    	pets += 1;
                	}
                	else
                		System.out.println("Pet "+name+ " already exists. ");
            	}

            	else if(n == 1)
            	{
            		input = line.split(" ", 2);
                    name = input[1];

            		line = inputStream.nextLine();
                    input = line.split(" ", 2);
                    specialisation = input[1];

                    if(doctorNameCheck(name) == 0)
                    {
                    	if (doctors == doctorList.length)
                    {
                        addDoctorSpace(doctorList.length);
                    }

                    for (int i=0; i<doctorList.length; i++)
                    {
                        if (doctorList[i] == null)
                        {
                            doctorList[i] = new Doctor2(name, specialisation);
                            break;
                        }
                    }

                    doctors += 1;
                }
                else
                	System.out.println("Doctor "+ name +" already exists. ");
            	}

            	else
            	{
            		System.out.println("Data in file in incompatible. ");
            	}
            }
        }
        System.out.println("File imported successfully. ");
    	inputStream.close();
        } 

        catch(Exception e)
        {
        	System.out.println("Error in Input File. Error Message:\n" + e.toString());
    	}
    }

    //This method allows the user to save the information in cmd to a file
    public void fileSave()
    { 
        String fileName = "VetManagement.txt";

        PrintWriter outputStream = null;
        try 
        {
        	outputStream = new PrintWriter (fileName);
        	if (pets != 0)
        	{
        		outputStream.println("Pets");
        		for (int i=0; i<pets; i++)
        		{
        			outputStream.println("type " + petList[i].getType());
	                outputStream.println("size " + petList[i].getSize());
	                outputStream.println("name " + petList[i].getName());
	                outputStream.println("weight " + petList[i].getWeight());
	                outputStream.println("age " + petList[i].getAge());
	                outputStream.println("doctor " + petList[i].getDoctor());
        		}
        	}
        	if (doctors != 0)
        	{
        		outputStream.println("Doctors");
        		for (int i=0; i<doctors; i++)
        		{
        			outputStream.println("name " + doctorList[i].getName());
	                outputStream.println("specialisation " + doctorList[i].getSpecialisation());	                
        		}
        	}
        	System.out.println("File saved successfully. ");
        	outputStream.close();
        }
		
		catch (FileNotFoundException e)
        {
            System.out.println ("An error occured; could not write to " + fileName);
        }
    }
 	
 	//This method starts the program
 	public static void main(String[] args)
	{
    	Clinic2 clinic2 = new Clinic2();
	    clinic2.run();
	}
}