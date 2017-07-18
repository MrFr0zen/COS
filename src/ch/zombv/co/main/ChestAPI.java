package ch.zombv.co.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChestAPI {
	 private MySQL mysql;

	  public boolean existChestPlayer(String UUID)
	  {
	    try
	    {
	      ResultSet rs = this.mysql.getResult("SELECT * FROM Player_Chests WHERE UUID= '" + UUID + "'");

	      if (rs.next()) {
	        return rs.getString("UUID") != null;
	      }
	      rs.close();
	      return false;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return false;
	  }
	  
	  public void createChestPlayer(String UUID) {
		  String str = "INSERT INTO Player_Chests(UUID, Bronze, Silver, Gold, Smaragd, Diamant, Platin, Legendary) VALUES ('" + UUID + "', 0, 0, 0, 0, 0, 0, 0)";
		  
		  this.mysql.update(str);
	    
	  }

	  public long getChests(String UUID, String ChestID) {
	    try {
	      ResultSet rs = this.mysql.getResult("SELECT * FROM Player_Chests WHERE UUID= '" + UUID + "'");
	      if (rs.next()) {
	        return rs.getLong(ChestID);
	      }
	      rs.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return 0L;
	  }


	  public void addChests(String UUID, String ChestID, long amount) {
	    
	    String str = "UPDATE Player_Chests SET "+ ChestID +"='" + Long.valueOf(getChests(UUID, ChestID) + amount) + "' WHERE UUID='" + UUID + "';";
	//    System.out.println(str);
		  this.mysql.update(str);
	  }

	  public void removeChests(String UUID, String ChestID, long amount) {
	    this.mysql.update("UPDATE Player_Chests SET "+ ChestID +"='" + Long.valueOf(getChests(UUID, ChestID) - amount) + "' WHERE UUID='" + UUID + "';");
	  }

	  public MySQL getMysql()
	  {
	    return this.mysql;
	  }
	  public void setMysql(MySQL mysql_in)
	  {
	     this.mysql = mysql_in;
	  }
}
