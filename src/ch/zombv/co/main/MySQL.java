package ch.zombv.co.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MySQL
{
	  public String username = "root";
	  public String password = "ratitixu";
	  public String database = "db";
	  public String host = "5.135.214.32";
	  public String port = "3306";
	  public Connection con;

	  public void connect()
	  {
	    if (!isConnected())
	      try {
	        this.con = DriverManager.getConnection("jdbc:mysql://" + this.host + ":3306/" + this.database + "?autoReconnect=true", this.username, this.password);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Es konnte keine MySQL Verbindung hergestellt werden!");
	      }
	  }

	  public void createCoinsTable()
	  {
	    if (isConnected())
	      try {
	        this.con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Player_Coins (UUID VARCHAR(100), Coins long)");
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Es ist ein Fehler beim Erstellen der Datenbank aufgetreten!");
	      }
	  }
	  public void createChestsTable()
	  {
	    if (isConnected())
	      try {
	        this.con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Player_Chests (UUID VARCHAR(100), Bronze long, Silver long, Gold long, Smaragd long, Diamant long, Platin long, Legendary long)");
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Es ist ein Fehler beim Erstellen der Datenbank aufgetreten!");
	      }
	  }
	  
	  public void CreateCosTable()
	  {
	    if (isConnected())
	      try {
	        this.con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Player_Cosmetics (UUID VARCHAR(100), Partikel1 long, Partikel2 long, Partikel3 long, Partikel4 long, Partikel5 long, Partikel6 long, Partikel7 long, Partikel8 long, Partikel9 long, Partikel10 long, Partikel11 long, Partikel12 long, Partikel13 long, Partikel14 long, Partikel15 long, Partikel16 long, Partikel17 long, Partikel18 long, Partikel19 long, Partikel20 long, Partikel21 long, Partikel22 long, Partikel23 long, Partikel24 long, Partikel25 long, Mount1 long, Mount2 long, Mount3 long, Mount4 long, Mount5 long, Mount6 long, Mount7 long, Mount8 long, Mount9 long, Mount10 long, Mount11 long, Mount12 long, Mount13 long, Mount14 long, Mount15 long, Mount16 long, Mount17 long, Mount18 long, Mount19 long, Mount20 long, Mount21 long, Mount22 long, Mount23 long, Mount24 long, Mount25 long, Pet1 long, Pet2 long, Pet3 long, Pet4 long, Pet5 long, Pet6 long, Pet7 long, Pet8 long, Pet9 long, Pet10 long, Pet11 long, Pet12 long, Pet13 long, Pet14 long, Pet15 long, Pet16 long, Pet17 long, Pet18 long, Pet19 long, Pet20 long, Pet21 long, Pet22 long, Pet23 long, Pet24 long, Pet25 long, Boot1 long, Boot2 long, Boot3 long, Boot4 long, Boot5 long, Boot6 long, Boot7 long, Boot8 long, Boot9 long, Boot10 long, Boot11 long, Boot12 long, Boot13 long, Boot14 long, Boot15 long, Boot16 long, Boot17 long, Boot18 long, Boot19 long, Boot20 long, Boot21 long, Boot22 long, Boot23 long, Boot24 long, Boot25 long, Gadget1 long, Gadget2 long, Gadget3 long, Gadget4 long, Gadget5 long, Gadget6 long, Gadget7 long, Gadget8 long, Gadget9 long, Gadget10 long, Gadget11 long, Gadget12 long, Gadget13 long, Gadget14 long, Gadget15 long, Gadget16 long, Gadget17 long, Gadget18 long, Gadget19 long, Gadget20 long, Gadget21 long, Gadget22 long, Gadget23 long, Gadget24 long, Gadget25 long, Hat1 long, Hat2 long, Hat3 long, Hat4 long, Hat5 long, Hat6 long, Hat7 long, Hat8 long, Hat9 long, Hat10 long, Hat11 long, Hat12 long, Hat13 long, Hat14 long, Hat15 long, Hat16 long, Hat17 long, Hat18 long, Hat19 long, Hat20 long, Hat21 long, Hat22 long, Hat23 long, Hat24 long, Hat25 long, GunGameI1 long, GunGameI2 long, GunGameI3 long, GunGameI4 long, GunGameI5 long, GunGameI6 long, GunGameS1 long, GunGameS2 long, GunGameS3 long, GunGameS4 long, GunGameS5 long)");
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Es ist ein Fehler beim Erstellen der Datenbank aufgetreten!");
	      }
	  }
	  
	  public void createKitTable()
	  {
	    if (isConnected())
	      try {
	    	  
	    	  String str = "CREATE TABLE IF NOT EXISTS Player_Kits (UUID VARCHAR(100), def INTEGER, kit1 Bit, kit2 Bit, kit3 Bit, kit4 Bit, kit5 Bit, kit6 Bit, kit7 Bit, kit8 Bit, kit9 Bit, kit10 Bit, kit11 Bit, kit12 Bit, kit13 Bit, kit14 Bit, kit15 Bit, kit16 Bit, kit17 Bit, kit18 Bit, kit19 Bit, kit20 Bit, kit21 Bit, kit22 Bit, kit23 Bit, kit24 Bit, kit25 Bit, kit26 Bit, kit27 Bit)";
	      //  System.out.println(str);
	    	  this.con.createStatement().executeUpdate(str);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Es ist ein Fehler beim Erstellen der Datenbank aufgetreten!");
	      }
	  }

	  public void close()
	  {
	    if (isConnected())
	      try {
	        this.con.close();
	        this.con = null;
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Die MySQL Verbundung konnte nicht nicht geschlossen werden");
	      }
	  }

	  public boolean isConnected()
	  {
	    return this.con != null;
	  }

	  public void update(String qry) {
	    if (isConnected())
	      try {
	        this.con.createStatement().executeUpdate(qry);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Es konnte kein MySQL Update ausgeführt werden");
	      }
	  }

	  public ResultSet getResult(String qry)
	  {
	    if (isConnected()) {
	      try {
	        return this.con.createStatement().executeQuery(qry);
	      } catch (SQLException e) {
	        e.printStackTrace();
	        Main.getInstance().log("Fehler getResult");
	      }
	    }
	    return null;
	  }
}
  
  
  
  