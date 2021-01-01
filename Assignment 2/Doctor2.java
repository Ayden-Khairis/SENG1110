public class Doctor2 extends Clinic2
{
    private String name; 
    private String specialisation;

    //Initialising starting variables
    public Doctor2()
    {
        this.name = "No Doctor";
        this.specialisation = "No Specialisation";
    }

    //Implementing new variables to create a doctor
    public Doctor2(String newName, String newSpecial)
    {
        this.name = newName;
        this.specialisation = newSpecial;
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