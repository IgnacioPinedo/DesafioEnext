package desafio.enext;

import java.util.List;

import desafio.enext.models.Game;

public class Main {
	
	public static void main(String[] args) 
	{
		String path = new Utils().GetPath();

		String[] parsedText = new Parser().Parse(path);
		
		List<Game> gameList = new Execute().ExecuteLog(parsedText);
		
		new Utils().PrintGames(gameList);
	}
}