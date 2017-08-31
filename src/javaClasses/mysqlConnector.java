package javaClasses;
import java.sql.*;


public class mysqlConnector {

	
	String URL = "jdbc:mysql://localhost:3306/newdb?autoReconnect=true&useSSL=true";
    String USERNAME = "root";
    String PASSWORD = "6666";
    Connection con = null;
	
    public void establishConnection(){

        try {            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void destroyConnection(){
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
public boolean searchForUser(String usrnm) throws SQLException{
	
		boolean answer = false;
		
		

            if (con != null) {
                java.sql.PreparedStatement statement = null;
                ResultSet rs = null;

                statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME=?");

                statement.setString(1, usrnm);

                rs = statement.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i) + " : " + columnValue + " ");
                        if(rsmd.getColumnName(i).equals("USER_NAME")){
                        	if(columnValue.equals(usrnm)) answer = true;
                        }
                    }
                }

            }

        
        return answer;
	}

	public boolean searchForUser(String usrnm,String psswd) throws SQLException{
		
		boolean answer = false;
		
		

		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME=? and PASSWORD=?");

            statement.setString(1, usrnm);
            statement.setString(2, psswd);

            rs = statement.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " : " + columnValue + " ");
                    if(rsmd.getColumnName(i).equals("USER_NAME")){
                    	if(columnValue.equals(usrnm)) answer = true;
                    	else answer = false;
                    }
                    if(rsmd.getColumnName(i).equals("PASSWORD")){
                    	if(columnValue.equals(psswd)) answer = true;
                    	else answer = false;
                    }                        
                    
                }
            }

        }

        
        return answer;
	}
	
	public ResultSet userInfo(String usrnm) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME=?");
            statement.setString(1, usrnm);

            rs = statement.executeQuery();
            return rs;
		}
		
		return null;
		
	}
	
	public ResultSet searchForAds(String kind,String res) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM ROOM WHERE "+kind+ "=? ORDER BY length(PRICE),PRICE");
            statement.setString(1, res);

            rs = statement.executeQuery();
            return rs;
		}
		
		return null;
	}
	
	public void makeReservation(String usrnm, String id) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;

            statement = con.prepareStatement("insert into RESERVATION (USER_NAME,AD_ID) values (?, ?);");

            statement.setString(1, usrnm);
            statement.setString(2, id);

            statement.executeUpdate();


        }
	}
	
	public void ConfirmUser(String usrnm) throws SQLException{
		if (con != null) {
            java.sql.PreparedStatement statement = null;

            statement = con.prepareStatement("UPDATE USER_ACCOUNT SET ROLE='H' WHERE USER_NAME=?");

            statement.setString(1, usrnm);
            statement.executeUpdate();


        }
		
	}
	
	public ResultSet searchForReservations(String usrnm) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM RESERVATION WHERE USER_NAME=?");
            statement.setString(1, usrnm);

            rs = statement.executeQuery();
            return rs;
		}
		
		return null;
	}
	
	public String FindImage(String usrnm) throws SQLException{
		if (con != null) {
	        PreparedStatement statement = null;

	        statement = con.prepareStatement("SELECT IMAGE FROM USER_ACCOUNT WHERE USER_NAME=?");
	        statement.setString(1, usrnm);
	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	        	String fin = rs.getString(1);
	        	return fin;
	        }
		}
		return null;
	}
	
	public String FindRole(String usrnm) throws SQLException{
		if (con != null) {
	        PreparedStatement statement = null;

	        statement = con.prepareStatement("SELECT ROLE FROM USER_ACCOUNT WHERE USER_NAME=?");
	        statement.setString(1, usrnm);
	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	        	String fin = rs.getString(1);
	        	return fin;
	        }
		}
		return null;
	}
	
	
	public void updateUserInfo(String usrnm, String psswd, String phone, String email,String pic) throws SQLException{
		
		if(psswd.equals("")) psswd = null;
		if(phone.equals("")) phone = null;
		if(email.equals("")) email = null;
		if(pic.equals("")) pic=null;
		if (con != null) {
            PreparedStatement statement = null;

            statement = con.prepareStatement("UPDATE USER_ACCOUNT SET PASSWORD=COALESCE(?,PASSWORD),PHONE=COALESCE(?,PHONE),EMAIL=COALESCE(?,EMAIL),IMAGE=COALESCE(?,IMAGE) WHERE USER_NAME=?");
            statement.setString(1, psswd);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, pic);
            statement.setString(5, usrnm);
            statement.executeUpdate();
		}
	}
	
	public void insertUserToDB(String usrnm,String psswd,String email,String phone,String role,String pic) throws SQLException {


            if (con != null) {
                java.sql.PreparedStatement statement = null;

                statement = con.prepareStatement("insert into USER_ACCOUNT (USER_NAME,PASSWORD,EMAIL,PHONE,ROLE,IMAGE) values (?, ?, ?, ?, ?, ?);");

                statement.setString(1, usrnm);
                statement.setString(2, psswd);
                statement.setString(3, email);
                statement.setString(4, phone);
                statement.setString(5, role);
                statement.setString(6, pic);

                statement.executeUpdate();


            }
 
    }
	
	public ResultSet allUsers() throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT ORDER BY ROLE;");
            rs = statement.executeQuery();
            return rs;


        }
		
		return null;
	}
	
public ResultSet User(String name) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME=?;");
            statement.setString(1, name);
            rs = statement.executeQuery();
            return rs;


        }
		
		return null;
	}
	
	
}
