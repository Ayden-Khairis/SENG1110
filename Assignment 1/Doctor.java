public class Doctor extends Clinic 
{
	private String name = null; 			// the name of the doctor
	private String specialisation = null; 	// the specialisation of the doctor (it can be “dog” or “cat”)
	
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
	public void setSpecialisation(String specialisation)
	{
		this.specialisation = specialisation;
	}
	//Returns value to clinic
	public String getSpecialisation()
	{
		return specialisation;
	}
}
