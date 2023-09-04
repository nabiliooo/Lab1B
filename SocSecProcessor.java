import java.util.*;

public class SocSecProcessor 
{
	public static void main(String args[])
	{
		String name, num;
		String choice = "y";
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		while(choice.charAt(0) == 'y') {
			System.out.print("Name? ");
			name = input.nextLine();
			System.out.print("SSN? ");
			num = input.nextLine();
			try 
			{
				valid = isValid(num);
				if(valid) {
					System.out.println(name + " " + num + " is valid.");
			}
			}
			catch(SocSecException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println("Continue? (y/n) ");
			choice = input.nextLine();
			choice = choice.toLowerCase();
		} 
		input.close();
	}
	public static boolean isValid(String ssn) throws SocSecException
	{
		if(ssn.length() != 11)
			throw new SocSecException("there is a wrong number of characters");
		if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-')
			throw new SocSecException("there are dashes at wrong positions");
		for(int i = 0; i < 11; i++)
		{
			if(i != 3 && i != 6)
			{
				if(!Character.isDigit(ssn.charAt(i)))
				{
					throw new SocSecException("input contains a character that is not a digit");
				}
			}
		}
		return true;
	}
}