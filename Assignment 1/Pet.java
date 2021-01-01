public class Pet extends Clinic 
{
	private String type = null; 	// the type of the pet. It can be only “cat” or “dog”.
	private String size = null; 	// the size of the pet. It can be only “small”, “medium” or “large”.
	private String name = null; 	// the name of the pet. 
	private double weight = 0; 		// the weight of the pet.
	private int age = 0; 			// the age of the pet.
	private String doctor = null;   // the doctor of the pet.
	
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