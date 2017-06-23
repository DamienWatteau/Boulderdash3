package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BddRequete {
	
	public void user (String nom){

		try {

	    Statement state = BoulderDashBDDConnector.getInstance().createStatement();


	    ResultSet result = state.executeQuery("SELECT * FROM players");
	    
	    int ID = 0;
	    String nomBDD = " ";
	    int nbrcolumn = 0;
	    
	    
	    result.last();
	    nbrcolumn = result.getRow();
	
	    // next() récupere la ligne
	    result.beforeFirst();
		    do{
		    	result.next();
		    	ID = result.getInt(1);
		    	nomBDD =result.getString(2);
		    }while(!(nom.equals(nomBDD)) && (ID != nbrcolumn));

		   //String sql = "{call insert_player("+nom+")}";
		    
			if(!nom.equals(nomBDD)){
				System.out.println("ERROR");
				Statement state2 = BoulderDashBDDConnector.getInstance().createStatement();

			    state2.executeUpdate("INSERT INTO players (player_name) VALUES ('"+nom+"') ");
				
			}
			else{
				System.out.println("Trouvé");
			}
	       
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	}
	
	public void selectTable(String level){
		char[][]chars = new char[20][35];
		try{
				
				Statement st; // L'objet Statement permet d'exécuter des instructions SQL (Il interroge la base de donnée et retourne les résultats)
				ResultSet rst; // L'objet ResultSet stocke les résultats de Statement (soit les données de la BDD)
				
				st = BoulderDashBDDConnector.getInstance().createStatement();
				rst = st.executeQuery("SELECT * From maps WHERE map_name = '"+level+"'"); // Execution 
				String texte;
				int line;
				int column;
				
				char niveau = ' ';
				int s = 0;
				int longueur = 0;
				
					rst.next();
					texte=(rst.getString("map_code"));
					line = (rst.getInt("map_line"));
					column = (rst.getInt("map_column"));
					

					System.out.println(line);
					
					for (int j = 0; j < column; j++){
						
						for(int i = 0; i < line; i++){
							
							niveau = texte.charAt(s);
							chars[j][i]=niveau;
							s++;
						}
						s+=2;
					}
					
					for(char sousTab[] : chars)
					{
					  for(char str : sousTab)
					  {     
					    System.out.print(str);
					  }
					  System.out.println(" ");
					}

			}catch (Exception ex){
				ex.printStackTrace();
			}
	}
}