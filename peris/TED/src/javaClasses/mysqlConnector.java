package javaClasses;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
	
	public List<Ad> searchForAds(String kind,String res) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM ROOM WHERE "+kind+ "=? ORDER BY length(PRICE),PRICE");
            statement.setString(1, res);

            rs = statement.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] strs = new String[columnsNumber];
            List<Ad> adList = new ArrayList<Ad>(); 
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}
            	adList.add(new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7]));
            	
            }
            /*for(Ad temp: adList){
            	temp.print();
            }*/
            return adList;
		}
		
		return null;
	}
	
public List<Ad> searchForAds(String res,String from,String to,String diff) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM ROOM WHERE CITY=? AND ID IN(SELECT distinct(listing_id) FROM calendar WHERE available='t' AND date>=? AND date<? GROUP BY listing_id HAVING count(date)=?) ORDER BY length(PRICE),PRICE");
            statement.setString(1, res);
            statement.setString(2, from);
            statement.setString(3, to);
            statement.setString(4, diff);

            rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] strs = new String[columnsNumber];
            List<Ad> adList = new ArrayList<Ad>(); 
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}
            	adList.add(new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7]));
            	
            }
            /*for(Ad temp: adList){
            	temp.print();
            }*/
            return adList;
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
	
	public void sendMessageToHost(String from, String id, String content) throws SQLException{
		
		PreparedStatement statement = null;
        statement = con.prepareStatement("SELECT * FROM AD WHERE ID=?");
        statement.setString(1, id);
        
        ResultSet rs = statement.executeQuery();
        rs.next();
        String to = rs.getString(1);
        System.out.println("SENDING TO:"+to);
        
        insertMessageToDB(from,content,to);
	}
	
	public void insertMessageToDB(String from,String content, String to) throws SQLException {


        if (con != null) {
        	
          PreparedStatement statement = null;
            statement = con.prepareStatement("insert into MESSAGE (USER_NAME,CONTENT,HOST_NAME) values (?, ?, ?);");

            statement.setString(1, from);
            statement.setString(2, content);
            statement.setString(3, to);

            statement.executeUpdate();


        }

}
	
public List<String> showMessages(String usrnm) throws SQLException{
	
	if (con != null) {
        PreparedStatement statement = null;

        statement = con.prepareStatement("SELECT * FROM MESSAGE WHERE USER_NAME=?");
        statement.setString(1, usrnm);
        ResultSet rs = statement.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        String[] strs = new String[columnsNumber];
        List<String> msgList = new ArrayList<String>(); 
        
        while(rs.next()){
        	for (int i = 1; i <= columnsNumber; i++) {
   	         String columnValue = rs.getString(i);
   	         strs[i-1] = columnValue;	 
        	}
        	msgList.add(strs[1]);
        }
        
        msgList.add("as host");
        
        statement = null;
        statement = con.prepareStatement("SELECT * FROM MESSAGE WHERE HOST_NAME=?");
        statement.setString(1, usrnm);
        rs = statement.executeQuery();

        rsmd = rs.getMetaData();
        columnsNumber = rsmd.getColumnCount();
        strs = new String[columnsNumber];
        
        while(rs.next()){
        	for (int i = 1; i <= columnsNumber; i++) {
   	         String columnValue = rs.getString(i);
   	         strs[i-1] = columnValue;	 
        	}
        	msgList.add(strs[1]);
        }
        
        return msgList;
	}
	
	return null;
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

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT;");
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
	
public void ConfirmUser(String usrnm) throws SQLException{
		if (con != null) {
            java.sql.PreparedStatement statement = null;

            statement = con.prepareStatement("UPDATE USER_ACCOUNT SET ROLE='H' WHERE USER_NAME=?");

            statement.setString(1, usrnm);
            statement.executeUpdate();


        }
		
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

public void addAd(String access, String desc, String rules, String from, String to
		,String maxpeople,String minprice,String adcost,String type, String beds, String wcs, String bedrooms, String living_rooms, String area) throws SQLException{
	 if (con != null) {
         java.sql.PreparedStatement statement = null;

         //statement = con.prepareStatement("insert into ROOM (USER_NAME,PASSWORD,EMAIL,PHONE,ROLE,IMAGE) values (?, ?, ?, ?, ?, ?);");

         statement.setString(1, access);
         statement.setString(2, desc);
         statement.setString(3, rules);
         statement.setInt(4, Integer.parseInt(maxpeople));
         statement.setFloat(5, Float.parseFloat(minprice));
         statement.setFloat(6, Float.parseFloat(adcost));
         statement.setString(7, type);
         statement.setInt(8, Integer.parseInt(beds));
         statement.setInt(9, Integer.parseInt(wcs));
         statement.setInt(10, Integer.parseInt(bedrooms));
         statement.setInt(11, Integer.parseInt(living_rooms));
         statement.setFloat(12, Float.parseFloat(area));

         //statement.executeUpdate();


     }
}
}

