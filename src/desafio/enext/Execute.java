package desafio.enext;

import java.util.ArrayList;
import java.util.List;
import desafio.enext.models.Game;

public class Execute {

	public List<Game> ExecuteLog(String[] parsedText)
	{
		List<Game> gameList = new ArrayList<>();
		
		Game game = null;
		
		for (int x = 0; x < parsedText.length; x++) {
			
			if(parsedText[x].equals("InitGame:"))
			{
				if(game != null && !gameList.contains(game))
					gameList.add(game);
				game = new Game();
			}
			else if(parsedText[x].equals("Kill:"))
			{
				int y = x + 5;
				
				String killer = parsedText[y-1];
				
				while(!parsedText[y].equals("killed"))
				{
					killer += " " + parsedText[y];
					
					y++;
				}
				
				y++;

				String killed = parsedText[y];
				
				y++;
				
				while(!parsedText[y].equals("by"))
				{
					killed += " " + parsedText[y];
					
					y++;
				}
				
				String gun = parsedText[y+1];
				
				
				game.AddKill(killer, killed, gun);
				
			}
			else if(parsedText[x].equals("ShutdownGame:"))
				gameList.add(game);
		}
		return gameList;
	}
	
}