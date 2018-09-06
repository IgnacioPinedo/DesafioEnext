package desafio.enext.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
	
	public int TotalKills;
	public List<String> Players;
	public Map<String, Integer> Kills;
	public Map<String, Integer> GunKills;
	
	public Game()
	{
		TotalKills = 0;
		Players = new ArrayList<String>();
		Kills = new HashMap<String, Integer>();
		GunKills = new HashMap<String, Integer>();
	}
	
	public void AddKill(String killer, String killed, String gun)
	{
		if(killer.equals("<world>"))
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
		
		if(!GunKills.containsKey(gun))
		{
			GunKills.put(gun, 0);
		}
		
		int gunKills = GunKills.get(gun);
		
		GunKills.remove(gun);
		
		GunKills.put(gun, gunKills);
				
		TotalKills++;
	}
}