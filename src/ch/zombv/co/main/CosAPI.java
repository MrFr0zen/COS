package ch.zombv.co.main;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CosAPI {
	 private MySQL mysql;

	  public boolean existCosmeticsPlayer(String UUID)
	  {
	    try
	    {
	      ResultSet rs = this.mysql.getResult("SELECT * FROM Player_Cosmetics WHERE UUID= '" + UUID + "'");

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
	  
	  public void createCosmeticsPlayer(String UUID) {
		  String str = "INSERT INTO Player_Cosmetics(UUID, Partikel1, Partikel2, Partikel3, Partikel4, Partikel5, Partikel6, Partikel7, Partikel8, Partikel9, Partikel10, Partikel11, Partikel12, Partikel13, Partikel14, Partikel15, Partikel16, Partikel17, Partikel18, Partikel19, Partikel20, Partikel21, Partikel22, Partikel23, Partikel24, Partikel25, Mount1, Mount2, Mount3, Mount4, Mount5, Mount6, Mount7, Mount8, Mount9, Mount10, Mount11, Mount12, Mount13, Mount14, Mount15, Mount16, Mount17, Mount18, Mount19, Mount20, Mount21, Mount22, Mount23, Mount24, Mount25, Pet1, Pet2, Pet3, Pet4, Pet5, Pet6, Pet7, Pet8, Pet9, Pet10, Pet11, Pet12, Pet13, Pet14, Pet15, Pet16, Pet17, Pet18, Pet19, Pet20, Pet21, Pet22, Pet23, Pet24, Pet25, Boot1, Boot2, Boot3, Boot4, Boot5, Boot6, Boot7, Boot8, Boot9, Boot10, Boot11, Boot12, Boot13, Boot14, Boot15, Boot16, Boot17, Boot18, Boot19, Boot20, Boot21, Boot22, Boot23, Boot24, Boot25, Gadget1, Gadget2, Gadget3, Gadget4, Gadget5, Gadget6, Gadget7, Gadget8, Gadget9, Gadget10, Gadget11, Gadget12, Gadget13, Gadget14, Gadget15, Gadget16, Gadget17, Gadget18, Gadget19, Gadget20, Gadget21, Gadget22, Gadget23, Gadget24, Gadget25, Hat1, Hat2, Hat3, Hat4, Hat5, Hat6, Hat7, Hat8, Hat9, Hat10, Hat11, Hat12, Hat13, Hat14, Hat15, Hat16, Hat17, Hat18, Hat19, Hat20, Hat21, Hat22, Hat23, Hat24, Hat25, GunGameI1, GunGameI2, GunGameI3, GunGameI4, GunGameI5, GunGameI6, GunGameS1, GunGameS2, GunGameS3, GunGameS4, GunGameS5) VALUES ('" + UUID + "', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
		  
		  this.mysql.update(str);
	    
	  }

	  public long getCosmetics(String UUID, String CosID) {
	    try {
	      ResultSet rs = this.mysql.getResult("SELECT * FROM Player_Cosmetics WHERE UUID= '" + UUID + "'");
	      if (rs.next()) {
	        return rs.getLong(CosID);
	      }
	      rs.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return 0L;
	  }


	  public void addCosmetics(String UUID, String CosID, long amount) {
	    
	    String str = "UPDATE Player_Cosmetics SET "+ CosID +"='" + Long.valueOf(getCosmetics(UUID, CosID) + amount) + "' WHERE UUID='" + UUID + "';";
	//    System.out.println(str);
		  this.mysql.update(str);
	  }

	  public void removeCosmetics(String UUID, String CosID, long amount) {
	    this.mysql.update("UPDATE Player_Cosmetics SET "+ CosID +"='" + Long.valueOf(getCosmetics(UUID, CosID) - amount) + "' WHERE UUID='" + UUID + "';");
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