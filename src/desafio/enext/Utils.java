package desafio.enext;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import desafio.enext.models.Game;

public class Utils {
	
	public String GetPath()
	{
		String path = System.getProperty("user.dir");
		
		 return path + "\\Log\\games.log.txt";
	}
	
	public void PrintGames(List<Game> gameList)
	{
		for (int x = 0; x < gameList.size(); x++) 
		{
			Game game = gameList.get(x);
			
			int gameHash = game.hashCode();
			
			Map<String, Integer> ordedKills = OrderKills(game.Kills);
			
			PrintGameLine(gameHash, ordedKills);
		}
	}
	
    private Map<String, Integer> OrderKills(Map<String, Integer> kills) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(kills.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() 
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) 
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> ordedKills = new LinkedHashMap<String, Integer>();
        
        for (Map.Entry<String, Integer> entry : list) 
        {
        	ordedKills.put(entry.getKey(), entry.getValue());
        }

        return ordedKills;
    }
	
	private void PrintGameLine(int gameHash, Map<String, Integer> kills)
	{
		System.out.println("------------------------------------");
		System.out.println(" GameHash: " + gameHash);
		System.out.println();
		
		for (Map.Entry<String, Integer> entry : kills.entrySet()) {
			System.out.println(" Player : " + entry.getKey() + " Kills : " + entry.getValue());
		}

		System.out.println();
	}
}