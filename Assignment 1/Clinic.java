/*
Name: Ayden Khairis
Student Number: C3282229
Date: 27/04/2018
Description:
This is a veterinary clinic  program which allows the user input new doctors and pets, delete doctors and pets,
print doctors and pets, assign doctors to pets, print a doctor's patients, and analyse a pet as to whether
it is overweight or not. 
*/

import java.util.*;

public class Clinic
{
    //Initialising starting variables
	private Doctor doctor1, doctor2;
    private Pet pet1, pet2, pet3, pet4;
    int counter = 0;
    static Scanner console = new Scanner(System.in);

	private void run() 
    {
        //Initialising doctor and pet variables
		doctor1 = null;
        doctor2 = null;
        pet1 = null;
        pet2 = null;
        pet3 = null;
        pet4 = null;
        int option;
        //The menu the user can select from
		do
        {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ");
        System.out.println("Menu:");
        System.out.println("Please select a menu item by entering the corresponding number");
        System.out.println("[1] - Enter a New Doctor");
        System.out.println("[2] - Enter a New Pet");
        System.out.println("[3] - Delete a Doctor");
        System.out.println("[4] - Print all Doctors");
        System.out.println("[5] - Delete a Pet");
        System.out.println("[6] - Print all Pets");
        System.out.println("[7] - Assign a Doctor to a Pet");
        System.out.println("[8] - Print a Doctor's Patients");
        System.out.println("[9] - Analyse a Pet");
        System.out.println("[0] - Close program");
        System.out.println("--------------------------------------------------------------- ");
        option = console.nextInt();
        //Switch case so the user can select the option they would like the pick
		switch (option)
            {
            case 1: addDoctor();
                    break;
            case 2: addPet();
                    break;
            case 3: deleteDoctor();
                    break;
            case 4: printDoctor();
                    break;
            case 5: deletePet();
                    break;
            case 6: printPet();
                    break;
            case 7: assignDoctor();
                    break;
			case 8: printDoctorsList();
					break;
			case 9: petAnalysis();
					break;
            case 0: break;
            }
        }
        while (option!=0);
        
        }
   
    //This method allows the user to add a doctor
    public void addDoctor()
    {
         //Initialising doctor variable, strings and a counter
		 Doctor doctor = new Doctor();
         String name,specialisation;
         counter = 0;
         console.nextLine();
            //Checks if there is no doctors in the system
			if (doctor1==null || doctor2==null)
            {
                System.out.print("What is your name: ");
                name=console.nextLine();
                //Send user input to create a new doctor
				doctor.setName(name);
                System.out.println("Name = "+doctor.getName());

                //Asks the doctor for their specialisation
				do {
                    if (counter > 0)
                        {
                            System.out.println("Please enter specialisation that is either dog or cat.");
                        }
                    System.out.print("What do you specialise in: ");
                    specialisation=console.nextLine();
                    //Send user input to the doctor class
					doctor.setSpecialisation(specialisation);
                    
                    counter++;
                    //While statement so if "dog" or "cat" is not put in by the user, it will ask again
					} while(!(specialisation.equalsIgnoreCase("dog") || specialisation.equalsIgnoreCase("cat")));

                    System.out.println("Specialisation = "+doctor.getSpecialisation());
                    //Sends user input to set the new doctor created
					if (doctor1==null) 
                        {
                            doctor1=doctor;
                        }
                    else 
                        {
                            doctor2=doctor;
                        }
                    }   
                    //If both doctors are full, system informs the user
					else
                        {
                            System.out.println("No space for a new doctor");
                        }
    }
      
    //This method allows the user to add a new pet
	public void addPet()
    {
         //Initialising pet variable, strings for pet description, and a counter
		 Pet pet = new Pet();
         String type,size,name;
         double weight;
         int age;
         counter = 0;
         console.nextLine();
		//Checks if there are any pets in the system
		if (pet1==null || pet2==null || pet3==null || pet4==null)
            {   
            //Asks the user for the pet type
			do 
                    {
                    if (counter > 0)
                        {
                            System.out.println("Please enter type that is either dog or cat.");
                        }
                    System.out.print("What is your pet type: ");
                    type=console.nextLine();
                    pet.setType(type);
                    
                    counter++;
                    //While statement so if "dog" or "cat" is not put in by the user, it will ask again
					} while(!(type.equalsIgnoreCase("dog") || type.equalsIgnoreCase("cat")));
                    System.out.println("Pet type = "+pet.getType()+". ");

            counter = 0;
            //Asks the user for pet name
			do              
                    {
                    if (counter > 0)
                        {
                            System.out.println("That name is already in the system.");
                        }
                    System.out.print("What is the name of the "+pet.getType()+": ");
                    name=console.nextLine();
                    
                    counter++;
                    //Checks if the pet name is already in the system
                    }while (checkPetNames(name) > 0);
                        pet.setName(name);  
                        if (pet1==null) 
                        {
                            pet1=pet;
                        }
                        else if (pet2==null)
                        {
                            pet2=pet;
                        }
                        else if (pet3==null)
                        {
                            pet3=pet;
                        }
                        else if (pet4==null) 
                        {
                            pet4=pet;
                        }  
            
            counter = 0;
            //Asks user for pet size
			do 
                    {
                    if (counter > 0)
                        {
                            System.out.println("Please enter small, medium or large.");
                        }
                    System.out.print("What is the size of "+pet.getName()+": ");
                    size=console.nextLine();
                    pet.setSize(size);
                    
                    counter++;
                    //While statement is if "small", "medium", or "large" is not input, the user tries again
					}while(!(size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")));
                    System.out.println(""+pet.getName()+"'s size = "+pet.getSize()+". ");

            counter = 0;
            //Asks user for pet weight
			do 
            {
                if (counter > 0)
                {
                System.out.println("A negative weight is not possible. ");
                System.out.println("Please re-enter the weight of your pet: ");
                }
                System.out.print("What is the weight of "+pet.getName()+" in kilograms: ");
                weight=console.nextDouble();
                pet.setWeight(weight);
                    
                counter++;
                //Checks if the weight is not negative, if it is, the user can try again
				}while(!(weight > 0));
                System.out.println(""+pet.getName()+"'s weight = "+pet.getWeight()+" kilograms.");
                
            counter = 0;
            //Asks the user for pet age
			do 
            {
                if (counter > 0)
                {
                System.out.println("A negative age is not possible. ");
                System.out.println("Please re-enter the age of your pet: ");
                }
                System.out.print("What is the age of your pet: ");
                age=console.nextInt();
                pet.setAge(age);
                    
                counter++;
				//Checks if the age is not negative, if it is, the user can try again
				}while(!(age > 0));
                System.out.println(""+pet.getName()+"'s age = "+pet.getAge()+". ");
                System.out.println(""+pet.getName()+" is currently not assigned to a doctor. ");

            }

                //There is no more room for any more pets
				else
                {
                    System.out.println("No space for a new pet.");
                }
            }

    //Method to check the pet names and make sure they aren't the same
	public int checkPetNames(String name)
     {
         //Resets all boolean values to zero
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        boolean test4 = false;

        //Resets all values to zero
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        int tester = 0;

        //Compares pet names
            if (pet1==null){ t1 = 0; }
                else 
                {                    
                    test1 = name.equalsIgnoreCase(pet1.getName());
                    if (test1 == true){ t1=1; }
                    else{ t1=0; }
                }
            

            if (pet2==null){ t2=0; }
                else{
                       test2 = name.equalsIgnoreCase(pet2.getName());
                    if (test2 == true){ t2=1; }
                    else{ t2=0; }
                   }

            if (pet3==null){ t3=0; }
                else
                {
                    test3 = name.equalsIgnoreCase(pet3.getName());
                       if (test3 == true){ t3=1; }
                    else{ t3=0; }
                }

            if (pet4==null){ t4=0; }
                else
                {
                    test4 = name.equalsIgnoreCase(pet4.getName());
                    if (test4 == true){ t4=1; }
                    else{ t4=0; }
                }
            
            tester = t1 + t2 + t3 + t4;
            return(tester);

        }

     //Method for deleting a doctor 
    public void deleteDoctor()
    {
		//Initialising string, and int variables
	   console.nextLine();
       String name;
       int doctors = 0;
       //Checks if there is a doctor in the system
		if (doctor1!=null || doctor2!=null) 
            {
               System.out.println("Please enter the name of the doctor you would like to delete: ");
               name=console.nextLine();
               //Checks if the first doctor has the same name as the one the user input
			   if (doctor1!=null)
               {
                   doctors +=1;
                   if (name.equalsIgnoreCase(doctor1.getName()))
               {
                   doctor1 = null;
                   doctors =0;
                   System.out.println("Doctor "+name+" has been deleted. ");
               }
               
               }
               
			   //Checks if the second doctor has the same name as the one the user input
               if (doctor2!=null)
               {
                   doctors +=1;
                   if (name.equalsIgnoreCase(doctor2.getName()))
               {
                   doctor2 = null;
                   doctors =0;
                   System.out.println("Doctor "+name+" has been deleted. ");
               }
               }  
               
			   //If there are no doctors with the name the user input, it will inform the user
			   if (doctors > 0)
               {
				System.out.println("There is no doctor by that name. Please try again. ");     
               }           
			}
       //Informs the user there are no doctors in the system
		else
        {
            System.out.println("There are no doctors in the system. ");     
        }
        }
     
	//Method to print doctors and their specialisation
    public void printDoctor()
    {
    //Prints the first doctor and their specialisation
	if (doctor1 != null)
    {
        System.out.println(doctor1.getName() + " specialises in - " + doctor1.getSpecialisation() +"s");
    }
    //Prints the second doctor and their specialisation
	if (doctor2 != null)
    {
        System.out.println(doctor2.getName() + " specialises in - " + doctor2.getSpecialisation() +"s");
    }
    //Informs the user that there are no doctors in the system
	if (doctor1 == null && doctor2 == null)
    {
        System.out.println("There are no doctors. ");       
    }
    }
    
	//Method for deleting a pet
    public void deletePet()
    {
        //Initialising string and int
		console.nextLine();
        String name;
        int pets = 0;
        //Checks if there are any pets in the system
		if (pet1!=null || pet2!=null || pet3!=null || pet4!=null) 
            {
                System.out.println("Please enter the name of the pet you would like to delete: ");
                name=console.nextLine();
                //Checks if a pet exists and checks if their name is the same as the one the user inputted
				if (pet1!=null)
                {
                    pets +=1;
					if (name.equalsIgnoreCase(pet1.getName()))
                {
                    pet1 = null;
                    pets =0;
                    System.out.println("Pet "+name+" has been deleted. ");
                }
                }
                //Checks if a pet exists and checks if their name is the same as the one the user inputted
                if (pet2!=null)
                {
                    pets +=1;
                    if (name.equalsIgnoreCase(pet2.getName()))
                {
                    pet2 = null;
                    pets =0;
                    System.out.println("Pet "+name+" has been deleted. ");
                }
                }
				//Checks if a pet exists and checks if their name is the same as the one the user inputted
                if (pet3!=null)
                {
                    pets +=1;
                    if (name.equalsIgnoreCase(pet3.getName()))
                {
                    pet3 = null;
                    pets =0;
                    System.out.println("Pet "+name+" has been deleted. ");
                }
                }
				//Checks if a pet exists and checks if their name is the same as the one the user inputted
                if (pet4!=null)
                {
                    pets +=1;
                    if (name.equalsIgnoreCase(pet4.getName()))
                {
                    pet4 = null;
                    pets =0;
                    System.out.println("Pet "+name+" has been deleted. ");
                }
                }
                //Informs the user there is no pets named as the name they input
                if (pets > 0)
                {
                 System.out.println("There is no pet by that name. Please try again. ");    
                }           
            }
        //Informs the user there are no pets in the system
		else
        {
            System.out.println("There are no pets in the system. ");        
        }
    }

	//Method for printing pets
    public void printPet()
    {
		//Checks if there are pets in the system, if so, prints their details
	   if (pet1 != null)
        {
            System.out.println(""+pet1.getName()+" is registered the system. ");
            System.out.println(""+pet1.getName()+" is a "+pet1.getSize()+" "+pet1.getType()+".");       
            System.out.println(""+pet1.getName()+" weighs "+pet1.getWeight()+" kilograms and is "+pet1.getAge()+" years old.");
            System.out.println(""+pet1.getName()+" is currently assigned to "+pet1.getDoctor()+". ");
			System.out.println(" ");
        }
        if (pet2 != null)
        {
            System.out.println(""+pet2.getName()+" is registered the system. ");
            System.out.println(""+pet2.getName()+" is a "+pet2.getSize()+" "+pet2.getType()+".");       
            System.out.println(""+pet2.getName()+" weighs "+pet2.getWeight()+" kilograms and is "+pet2.getAge()+" years old.");
            System.out.println(""+pet2.getName()+" is currently assigned to "+pet2.getDoctor()+". ");
			System.out.println(" ");
        }
        if (pet3 != null)
        {
            System.out.println(""+pet3.getName()+" is registered the system. ");
            System.out.println(""+pet3.getName()+" is a "+pet3.getSize()+" "+pet3.getType()+".");       
            System.out.println(""+pet3.getName()+" weighs "+pet3.getWeight()+" kilograms and is "+pet3.getAge()+" years old.");
            System.out.println(""+pet3.getName()+" is currently assigned to "+pet3.getDoctor()+". ");
			System.out.println(" ");
        }
        if (pet4 != null)
        {
            System.out.println(""+pet4.getName()+" is registered the system. ");
            System.out.println(""+pet4.getName()+" is a "+pet4.getSize()+" "+pet4.getType()+".");       
            System.out.println(""+pet4.getName()+" weighs "+pet4.getWeight()+" kilograms and is "+pet4.getAge()+" years old.");
            System.out.println(""+pet4.getName()+" is currently assigned to "+pet4.getDoctor()+". ");
			System.out.println(" ");
        }
        //Informs the user there are no pets in the system
		if (pet1 == null && pet2 == null && pet3 == null && pet4 == null)
        {
            System.out.println("There are no pets in the system. ");        
        }
    }

	//Method to assign a doctor
    public void assignDoctor()
    {
		//Initialising string variables
		console.nextLine();
        String name = "";
		String pet = "";
        //Checks if there is a doctor in the system
		if (doctor1 != null || doctor2 != null)
		{    
		//Asks the user for the doctor and pet they would like to assign
		do
        {
			System.out.println("Please enter the name of the doctor you would like to assign a pet to: ");
			name=console.nextLine();
		//Runs checkDoctorNames method
		}while(!(checkDoctorNames(name) > 0));
			System.out.println("You have selected "+name+". ");	
		//Asks the user for the pet they would like to be assigned
		do{
			System.out.println("Please select a pet you would like to assign this doctor to: ");
			pet=console.nextLine();
		//Runs checkPetNames method
		}while(!(checkPetNames(pet) > 0));	
			System.out.println("You have selected "+pet+". ");
		//Checks if the user inputted the name of the first doctor
		if(doctor1 != null)
		{
		if (name.equalsIgnoreCase(doctor1.getName()))
		{
			if (pet1 != null && pet.equalsIgnoreCase(pet1.getName()))
			{
				//Checks if the doctor specialises in the pet selected
				if (doctor1.getSpecialisation().equalsIgnoreCase(pet1.getType()))
				{
					pet1.setDoctor(name);
				}
				//Informs the user the doctor doesn't specialise in this pet
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}
			//Same as pet1 comments
			else if (pet2 != null && pet.equalsIgnoreCase(pet2.getName()))
			{
				if (doctor1.getSpecialisation().equalsIgnoreCase(pet2.getType()))
				{
					pet2.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}
			//Same as pet1 comments
			else if (pet3 != null && pet.equalsIgnoreCase(pet3.getName()))
			{
				if (doctor1.getSpecialisation().equalsIgnoreCase(pet3.getType()))
				{
					pet3.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}
			//Same as pet1 comments
			else if (pet4 != null && pet.equalsIgnoreCase(pet4.getName()))
			{
				if (doctor1.getSpecialisation().equalsIgnoreCase(pet4.getType()))
				{
					pet4.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}		
		} 
		}
		
		//Same as doctor1 comments
		if(doctor2 != null)
		{
		if (name.equalsIgnoreCase(doctor2.getName()))
		{
			if (pet1 != null && pet.equalsIgnoreCase(pet1.getName()))
			{
				if (doctor2.getSpecialisation().equalsIgnoreCase(pet1.getType()))
				{
					pet1.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}
			else if (pet2 != null && pet.equalsIgnoreCase(pet2.getName()))
			{
				if (doctor2.getSpecialisation().equalsIgnoreCase(pet2.getType()))
				{
					pet2.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}
			else if (pet3 != null && pet.equalsIgnoreCase(pet3.getName()))
			{
				if (doctor2.getSpecialisation().equalsIgnoreCase(pet3.getType()))
				{
					pet3.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
			}
			else if (pet4 != null && pet.equalsIgnoreCase(pet4.getName()))
			{
				if (doctor2.getSpecialisation().equalsIgnoreCase(pet4.getType()))
				{
					pet4.setDoctor(name);
				}
				else
				{
					System.out.println("This doctor does not specialise in this animal. ");
				}
		}
		}
		}
		}	
			//Informs the user there are no doctors by the name they have inputted
			else
				System.out.println("There are no doctors by that name. Please try again. ");
	}
	
	 //Method to check doctor names  
	 public int checkDoctorNames(String name)
     {
         //Resets all boolean values to false
        boolean test1 = false;
        boolean test2 = false;

        //Resets all test values to 0
        int t1 = 0;
        int t2 = 0;
        int tester = 0;

        //Compares doctor names
            if (doctor1==null){ t1 = 0; }
                else 
                {                    
                    test1 = name.equalsIgnoreCase(doctor1.getName());
                    if (test1 == true){ t1=1; }
                    else{ t1=0; }
                }
            

            if (doctor2==null){ t2=0; }
                else{
                       test2 = name.equalsIgnoreCase(doctor2.getName());
                    if (test2 == true){ t2=1; }
                    else{ t2=0; }
                   }
                   
            tester = t1 + t2;
            return(tester);

        }
		
		//Method to print doctors list
		public void printDoctorsList()
		{
		//Initialising string variables
		console.nextLine();
		String name = "";
		String pet = "";
        //Checks if there are any doctors in the system
		if (doctor1 != null || doctor2 != null)
		{    
		//Asks the user to input the doctor they would like to print a patient list for
		do
        {
			System.out.println("Please enter the name of the doctor you would like to print a patient list for: ");
			name=console.nextLine();
		}while(!(checkDoctorNames(name) > 0));
			System.out.println("You have selected "+name+". ");	
			//Checks which pets are assigned to a doctor
			if (pet1 != null && pet1.getDoctor().equalsIgnoreCase(name))
			{
				System.out.println("- " + pet1.getName());
			}
			//Checks which pets are assigned to a doctor
			if (pet2 != null && pet2.getDoctor().equalsIgnoreCase(name))
			{
				System.out.println("- " + pet2.getName());
			}
			//Checks which pets are assigned to a doctor
			if (pet3 != null && pet3.getDoctor().equalsIgnoreCase(name))
			{
				System.out.println("- " + pet3.getName());
			}
			//Checks which pets are assigned to a doctor
			if (pet4 != null && pet4.getDoctor().equalsIgnoreCase(name))
			{
				System.out.println("- " + pet4.getName());
			}
		}
		}
		
		//Method to analyse a pet
		public void petAnalysis()
		{
		//Initialsing string, double, and int variables
		console.nextLine();
		String pet = "";
		String type = "No Type";
		String size = "No Size";
		double weight = 0;
		int age = 0;
		String analysis = "";
        //Checks if there is a pet in the system
		if (pet1 != null || pet2 != null || pet3 != null || pet4 != null)
		{    
		//Asks the user for the pet name they would like analysed
		do
        {
			System.out.println("Please enter the name of the pet you would like to analyse: ");
			pet=console.nextLine();
		}while(!(checkPetNames(pet) > 0));
		
		//Checks if the pet the user inputted is in the system and grabs the pet's details
		if (pet1 != null && pet.equalsIgnoreCase(pet1.getName()))
		{
			type = pet1.getType();
			size = pet1.getSize();
			weight = pet1.getWeight();
			age = pet1.getAge();
			analysis = analysedPet(type,size,weight);
		}
		//Checks if the pet the user inputted is in the system and grabs the pet's details
		else if (pet2 != null && pet.equalsIgnoreCase(pet2.getName()))
		{
			type = pet2.getType();
			size = pet2.getSize();
			weight = pet2.getWeight();
			age = pet2.getAge();
			analysis = analysedPet(type,size,weight);
		}
		//Checks if the pet the user inputted is in the system and grabs the pet's details
		else if (pet3 != null && pet.equalsIgnoreCase(pet3.getName()))
		{
			type = pet3.getType();
			size = pet3.getSize();
			weight = pet3.getWeight();
			age = pet3.getAge();
			analysis = analysedPet(type,size,weight);
		}
		//Checks if the pet the user inputted is in the system and grabs the pet's details
		else if (pet4 != null && pet.equalsIgnoreCase(pet4.getName()))
		{
			type = pet4.getType();
			size = pet4.getSize();
			weight = pet4.getWeight();
			age = pet4.getAge();
			analysis = analysedPet(type,size,weight);
		}
		
		//Prints the pet's details and analysis
		System.out.println("Pet:" + pet);
		System.out.println("Type:" + type);
		System.out.println("Size:" + size);
		System.out.println("Weight:" + weight);
		System.out.println("Age:" + age);
		System.out.println("Analysis:" + analysis);	
		
		}
		//Informs the user there are no pets in the system
		else
		{
			System.out.println("There are no pets in the system");
		}
		}
		
		//Method for pet analysis
		public String analysedPet(String pet, String size, double weight)
		{
		//Gives values for pet analysis for cats
		if (pet.equalsIgnoreCase("cat")){
			
			if (size.equalsIgnoreCase("small")){
				if (weight > 4)
				{
					
					return("Overweight");
				}
				else{
					
					return("Correct Weight Range");
				}
			}
			else if (size.equalsIgnoreCase("medium")){
				if (weight > 6)
				{
					return("Overweight");
				}
				else{
					return("Correct Weight Range");
				}
			}
			else if (size.equalsIgnoreCase("large")){
				if (weight > 8)
				{
					return("Overweight");
				}
				else{
					return("Correct Weight Range");
				}
			}

		}
		//Gives values for pet analysis for dogs
		if (pet.equalsIgnoreCase("dog")){
					
					if (size.equalsIgnoreCase("small")){
						if (weight > 6)
						{
							
							return("Overweight");
						}
						else{
							
							return("Correct Weight Range");
						}
					}
					else if (size.equalsIgnoreCase("medium")){
						if (weight > 9)
						{
							return("Overweight");
						}
						else{
							return("Correct Weight Range");
						}
					}
					else if (size.equalsIgnoreCase("large")){
						if (weight > 12)
						{
							return("Overweight");
						}
						else{
							return("Correct Weight Range");
						}
					}
		}
		//Returns error message
		return ("Error - Please try again");
}

	 //Method for starting program
	 public static void main(String[] args)
	 {
	     Clinic clinic = new Clinic();
	     clinic.run();
	 }
}