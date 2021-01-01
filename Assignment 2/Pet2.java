public class Pet2 extends Clinic2
{
   	private String type; 	// the type of the pet. It can be only "cat" or "dog".
	private String size; 	// the size of the pet. It can be only "small, medium, or large"
	private String name; 	// the name of the pet. 
	private double weight; 	// the weight of the pet.
	private int age; 		// the age of the pet.
	private String doctor;  // the doctor of the pet.
	
	//Initialising starting variables
	public Pet2()
	{
		this.type = "No Type";
		this.size = "No Size";
		this.name = "No Name";
		this.weight = 0;
		this.age = 0;
		this.doctor = "No Doctor";
	}

	//Implementing new variables to create a doctor
	public Pet2(String newType, String newSize, String newName, double newWeight, int newAge)
	{
		this.type = newType;
		this.size = newSize;
		this.name = newName;
		this.weight = newWeight;
		this.age = newAge;
		this.doctor = "no doctor";
	}

	//Sets value based off user input
	public void setType(String type)
	{
		this.type = type;
	}
	//Returns value to clinic
	public String getType()
	{
		return type;
	}
	//Sets value based off user input
	public void setSize(String size)
	{
		this.size = size;
	}
	//Returns value to clinic
	public String getSize()
	{
		return size;
	}
	//Sets value based off user input
	public void setName(String name)
	{
		this.name = name;
	}
	//Returns value to clinic
	public String getName()
	{
		return name;
	}
	//Sets value based off user input
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	//Returns value to clinic
	public double getWeight()
	{
		return weight;
	}
	//Sets value based off user input
	public void setAge(int age)
	{
		this.age = age;
	}
	//Returns value to clinic
	public int getAge()
	{
		return age;
	}
	//Sets value based off user input
	public void setDoctor(String dr)
	{
		this.doctor = dr;
	}
	//Returns value to clinic
	public String getDoctor()
	{
		return doctor;
	}
}