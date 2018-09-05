package desafio.enext;

public class Utils {
	
	public String GetPath()
	{
		String path = System.getProperty("user.dir");
		
		 return path + "\\Log\\games.log.txt";
	}
}
