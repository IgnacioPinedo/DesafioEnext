package desafio.enext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import desafio.enext.models.Game;

public class SQL {

	public void UploadGameList(List<Game> gameList)
	{
		String connectionUrl =
                "jdbc:sqlserver://desafioenext.database.windows.net:1433;"
                        + "database=DesafioEnext;"
                        + "user=UserName@desafioenext;"
                        + "password=Password;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate=*.database.windows.net;"
                        + "loginTimeout=30;";


        String insertGame = "INSERT INTO TB_Game (GameHash, TotalKills) VALUES ";
        
        String selectGameId = "SELECT GameId " + 
        					  "FROM TB_Game " + 
        					  "WHERE GameHash = ";
        
        String insertPlayer = "INSERT INTO TB_Player_Kill (PlayerName, Kills, GameId) VALUES ";
        
        
        try (Connection connection = DriverManager.getConnection(connectionUrl);) {

        	for (int x = 0; x < gameList.size(); x++) {
        		Game game = gameList.get(x);
                Statement stmt = null;
                try {
                	String query = insertGame + "(" + game.hashCode() + ", " + game.TotalKills + ")"; 
                	
                    stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                    
                    query = selectGameId + game.hashCode();

                    ResultSet rs = stmt.executeQuery(query);
                    
                    int gameId = 0;
                    
                    while (rs.next()) {
                    	gameId = rs.getInt("GameId");
                    }
                    
                    Map<String, Integer> playersKills = game.Kills;

                    for (Map.Entry<String, Integer> entry : playersKills.entrySet()) {
                    	query = insertPlayer + "('" + entry.getKey() + "', " + entry.getValue() + ", " + gameId + ")";

                    	stmt.executeUpdate(query);
                    }
                } catch (SQLException e ) {
                    System.out.println("Ocorreu algum erro ao enviar os dados para o banco de dados.");
                } finally {
                    if (stmt != null) { stmt.close(); }
                }
			}
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
