package desafio.enext;

public class Main {
	
	public static void main(String[] args) 
	{
		String path = new Utils().GetPath();

		String[] parsedText = new Parser().Parse(path);
		
	}
}