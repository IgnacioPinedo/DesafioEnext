package desafio.enext;

import java.io.File;
import java.io.FileInputStream;

public class Parser {
	
	public String[] Parse(String path)
	{
		String str = "";
		try
		{
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
	
			str = new String(data, "UTF-8");
		}
		catch(Exception e) 
		{
			System.out.println("Error when reading the file");
		}
		
		String[] parsedText = str.split("\\s+");
			
		return parsedText;
	}
}