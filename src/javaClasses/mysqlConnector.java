package javaClasses;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class mysqlConnector {

	
	String URL = "jdbc:mysql://localhost:3306/TED?autoReconnect=true&useSSL=true";
    String USERNAME = "root";
    String PASSWORD = "1234";
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
	
	public User userInfo(String usrnm) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE USER_NAME=?");
            statement.setString(1, usrnm);

            rs = statement.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] strs = new String[columnsNumber];
            User user = null;
            while(rs.next()){
            	 for (int i = 1; i <= columnsNumber; i++) {
            	         String columnValue = rs.getString(i);
            	         strs[i-1] = columnValue;	 
            	 }
            	 user = new User(strs[0],strs[2],strs[3],strs[4],strs[5],strs[6]);
            }
            return user;
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
            	adList.add(new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7],
            			strs[8],strs[9],strs[10],strs[11],strs[12],strs[13],strs[14],strs[15]));
            	
            }
            /*for(Ad temp: adList){
            	temp.print();
            }*/
            return adList;
		}
		
		return null;
	}
	
	public List<Ad> searchForAds(String user) throws SQLException{
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM AD WHERE HOST_NAME=?");
            statement.setString(1, user);

            rs = statement.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] strs = new String[columnsNumber];
           	String ads = "";
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}     
            	if(ads.equals("")) ads = ads + strs[1];
            	else ads = ads + "," +strs[1];
            }
             statement = null;
            statement = con.prepareStatement("SELECT * FROM ROOM WHERE ID IN ("+ ads+")");

            rs = statement.executeQuery();
            rsmd = rs.getMetaData();
            columnsNumber = rsmd.getColumnCount();
            strs = new String[columnsNumber];
            List<Ad> adList = new ArrayList<Ad>();
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}
            	adList.add(new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7],
            			strs[8],strs[9],strs[10],strs[11],strs[12],strs[13],strs[14],strs[15]));
            	
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

            statement = con.prepareStatement("SELECT * FROM ROOM INNER JOIN(SELECT distinct(listing_id) FROM calendar WHERE available='t' AND date>=? AND date<? GROUP BY listing_id HAVING count(date)=?) WW ON ID=WW.listing_id AND CITY=? ORDER BY length(PRICE),PRICE");
            statement.setString(4, res);
            statement.setString(1, from);
            statement.setString(2, to);
            statement.setString(3, diff);
            statement.setFetchSize(150);
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
            	adList.add(new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7],
            			strs[8],strs[9],strs[10],strs[11],strs[12],strs[13],strs[14],strs[15]));
            	
            }
            /*for(Ad temp: adList){
            	temp.print();
            }*/
            return adList;
		}
		return null;
	}
	
	public void makeReservation(String usrnm, String id, String from, String to) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;

            statement = con.prepareStatement("insert into RESERVATION (USER_NAME,AD_ID,FROM_DATE,TO_DATE) values (?,?,?,?);");

            statement.setString(1, usrnm);
            statement.setString(2, id);
            statement.setString(3, from);
            statement.setString(4, to);

            statement.executeUpdate();


        }
	}
	
	public List<Ad> searchForReservations(String usrnm, List<String> datesList) throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM RESERVATION WHERE USER_NAME=?");
            statement.setString(1, usrnm);

            rs = statement.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] strs = new String[columnsNumber];
           	String ads = "";
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}     
            	if(ads.equals("")) ads = ads + strs[1];
            	else ads = ads + "," +strs[1];
            	datesList.add(strs[2]);
            	datesList.add(strs[3]);
            }
            statement = null;
            statement = con.prepareStatement("SELECT * FROM ROOM WHERE ID IN ("+ ads+")");

            rs = statement.executeQuery();
            rsmd = rs.getMetaData();
            columnsNumber = rsmd.getColumnCount();
            strs = new String[columnsNumber];
            List<Ad> adList = new ArrayList<Ad>();
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}
            	adList.add(new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7],
            			strs[8],strs[9],strs[10],strs[11],strs[12],strs[13],strs[14],strs[15]));
            	
            }
            return adList;
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
	
	public Ad findRoom(String id) throws SQLException{
		if (con != null) {
	        PreparedStatement statement = null;

	        statement = con.prepareStatement("SELECT * FROM ROOM WHERE ID=?");
	        statement.setString(1, id);
	        ResultSet rs = statement.executeQuery();
	        
	        ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String[] strs = new String[columnsNumber];
            Ad ad = null;
            
            while(rs.next()){
            	for (int i = 1; i <= columnsNumber; i++) {
       	         String columnValue = rs.getString(i);
       	         strs[i-1] = columnValue;	 
            	}

            	ad = new Ad(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7],
            			strs[8],strs[9],strs[10],strs[11],strs[12],strs[13],strs[14],strs[15]);
            	
            }
            return ad;
            
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
	
	public void fromSendMessageTo(String from, String id, String content) throws SQLException{
		
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
            statement = con.prepareStatement("insert into MESSAGE (SENDER,CONTENT,RECEIVER) values (?, ?, ?);");

            statement.setString(1, from);
            statement.setString(2, content);
            statement.setString(3, to);

            statement.executeUpdate();


        }

}
	public void deleteMessageFromDB(String from, String content) throws SQLException{
		if (con != null) {
		        	
	      PreparedStatement statement = null;
	      statement = con.prepareStatement("delete from MESSAGE where SENDER=? and CONTENT=?;");

	      statement.setString(1, from);
	      statement.setString(2, content);
	      statement.executeUpdate();


		}
	}
	
	public List<Message> showMessages(String usrnm) throws SQLException{
	
		if (con != null) {
			PreparedStatement statement = null;

			statement = con.prepareStatement("SELECT * FROM MESSAGE WHERE RECEIVER=?");
			statement.setString(1, usrnm);
			ResultSet rs = statement.executeQuery();
        
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			String[] strs = new String[columnsNumber];
			List<Message> msgList = new ArrayList<Message>(); 
        
			while(rs.next()){
				for (int i = 1; i <= columnsNumber; i++) {
					String columnValue = rs.getString(i);
					strs[i-1] = columnValue;	 
				}
				msgList.add(new Message(strs[0],strs[1],strs[2]));
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
	
	
	public List<User> allUsers() throws SQLException{
		
		if (con != null) {
            java.sql.PreparedStatement statement = null;
            ResultSet rs = null;

            statement = con.prepareStatement("SELECT * FROM USER_ACCOUNT ORDER BY ROLE;");
            rs = statement.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			String[] strs = new String[columnsNumber];
			List<User> usrList = new ArrayList<User>(); 
        
			while(rs.next()){
				for (int i = 1; i <= columnsNumber; i++) {
					String columnValue = rs.getString(i);
					strs[i-1] = columnValue;	 
				}
				usrList.add(new User(strs[0],strs[2],strs[3],strs[4],strs[5],strs[6]));
			}
        
            
            return usrList;


        }
		
		return null;
	}
	
	
	public void holdRoom(String id,String from,String to) throws SQLException {
		if (con != null) {
            java.sql.PreparedStatement statement = null;

            statement = con.prepareStatement("UPDATE calendar SET available='f' WHERE listing_id=? AND date>? AND date<=?");
            
            statement.setString(1,id);
            statement.setString(2,from);
            statement.setString(3,to);
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
	
	public void addAd(Ad ad, String hostname, List<String> dates) throws SQLException{
			if (con != null) {
				java.sql.PreparedStatement statement = null;

				statement = con.prepareStatement("insert into ROOM (ID,NAME,DESCRIPTION,"
				+"CITY,ADDRESS,COUNTRY,PIC,PRICE,PRICE_PER_PERSON,MAX_PEOPLE,"
				+ "TYPE,BEDS,WCS,BEDROOMS,LIVING_ROOMS,AREA) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

				statement.setString(1, ad.id);
				statement.setString(2, ad.name);
				statement.setString(3, ad.desc);
				statement.setString(4, ad.city);
				statement.setString(5, ad.address);
				statement.setString(6, ad.country);
				statement.setString(7, ad.pic);
	        	statement.setString(8, ad.price);
	        	statement.setFloat(9, ad.ppr);
	        	statement.setInt(10, ad.maxp);
	        	statement.setString(11, ad.type);
	        	statement.setInt(12, ad.beds);
	        	statement.setInt(13, ad.wcs);
	        	statement.setInt(14, ad.bedrooms);
	        	statement.setInt(15, ad.living_rooms);
	        	statement.setFloat(16, ad.area);
	        	
	        	statement.executeUpdate();

	        	statement = con.prepareStatement("insert into AD (HOST_NAME,ID) values (?,?)");
	        	
	        	statement.setString(1, hostname);
	        	statement.setString(2, ad.id);

	        	statement.executeUpdate();
	        	
	        	for(String date: dates){
	        		statement = con.prepareStatement("insert into calendar (listing_id,date,available,price) values (?,?,?,?)");
		        	
		        	statement.setString(1, ad.id);
		        	statement.setString(2, date);
		        	statement.setString(3, "t");
		        	statement.setString(4, ad.price);

		        	statement.executeUpdate();
	        	}
	        	
	        	
			}
		}
	
	public void updateAd(Ad ad) throws SQLException{
		if (con != null) {
			java.sql.PreparedStatement statement = null;

			statement = con.prepareStatement("UPDATE ROOM SET NAME=COALESCE(?,NAME),DESCRIPTION=COALESCE(?,DESCRIPTION),"
			+"CITY=COALESCE(?,CITY),ADDRESS=COALESCE(?,ADDRESS),COUNTRY=COALESCE(?,COUNTRY),PIC=COALESCE(?,PIC),"
			+ "PRICE=COALESCE(?,PRICE),PRICE_PER_PERSON=COALESCE(?,PRICE_PER_PERSON),MAX_PEOPLE=COALESCE(?,MAX_PEOPLE),"
			+ "TYPE=COALESCE(?,TYPE),BEDS=COALESCE(?,BEDS),WCS=COALESCE(?,WCS),BEDROOMS=COALESCE(?,BEDROOMS),"
			+ "LIVING_ROOMS=COALESCE(?,LIVING_ROOMS),AREA=COALESCE(?,AREA) WHERE ID=?;");

			statement.setString(1, ad.name);
			statement.setString(2, ad.desc);
			statement.setString(3, ad.city);
			statement.setString(4, ad.address);
			statement.setString(5, ad.country);
			statement.setString(6, ad.pic);
        	statement.setString(7, ad.price);
        	statement.setFloat(8, ad.ppr);
        	statement.setInt(9, ad.maxp);
        	statement.setString(10, ad.type);
        	statement.setInt(11, ad.beds);
        	statement.setInt(12, ad.wcs);
        	statement.setInt(13, ad.bedrooms);
        	statement.setInt(14, ad.living_rooms);
        	statement.setFloat(15, ad.area);
			statement.setString(16, ad.id);
        	
        	statement.executeUpdate();
		}
	}
	
	public List<Listing> allRooms() throws SQLException{
		
		 	if (con != null) {
		         java.sql.PreparedStatement statement = null;
		         ResultSet rs = null;
		 
		         statement = con.prepareStatement("SELECT * FROM ROOM;");
		         rs = statement.executeQuery();
		         
		         ResultSetMetaData rsmd = rs.getMetaData();
		 		int columnsNumber = rsmd.getColumnCount();
		 		String[] strs = new String[columnsNumber];
		 		List<Listing> roomList = new ArrayList<Listing>(); 
		 		List<String> mylist;
		 		while(rs.next()){
		 			for (int i = 1; i <= columnsNumber; i++) {
		 				String columnValue = rs.getString(i);
		 				strs[i-1] = columnValue;	
		 				//mylist.add(columnValue);
		 			}
		 			roomList.add(new Listing(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7]));
		 		}
		     
		         
		         return roomList;
		 
		 
		     }
		 	
		 	return null;
		 }

}








