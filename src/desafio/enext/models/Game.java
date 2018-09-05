package desafio.enext.models;

import java.util.Dictionary;
import java.util.List;

public class Game {
	
	public int TotalKills;
	public List<String> Players;
	public Dictionary<String, Integer> Kills;
	
	public void AddKill(String killer, String killed)
	{
		if(killer == "<world>")
		{
			if(!Players.contains(killed))
			{
				Players.add(killed);
				Kills.put(killed, 0);
			}
			
			int kills = Kills.get(killed) - 1;
			
			Kills.remove(killed);
			
			Kills.put(killed, kills);
		}
		else
		{
			if(!Players.contains(killer))
			{
				Players.add(killer);
				Kills.put(killer, 0);
			}
			
			int kills = Kills.get(killer) + 1;

			Kills.remove(killer);
			
			Kills.put(killer, kills);
		}
		
		TotalKills++;
	}
}