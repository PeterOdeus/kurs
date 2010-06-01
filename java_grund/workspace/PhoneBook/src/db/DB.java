package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import model.Contact;
import model.PhoneNumber;


public class DB {
	String url = "jdbc:derby://localhost:1527/phonebook;create=true";
	String user = "peter";
	String pwd = "peter";
	
	public DB(){
		try {
			createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Contact contact){
		try{
			Connection db = DriverManager.getConnection(url, user, pwd);
			db.setAutoCommit(false);
			Statement statement = db.createStatement();
			String sql = String.format("INSERT INTO CONTACT VALUES ('%s','%s')", 
					contact.getName(), 
					contact.getPhoneNumber().getDigits());
			statement.execute(sql);
			statement.close();
			db.commit();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<Contact> select(String contactName){
		List<Contact> contactList = new ArrayList<Contact>();
		Contact tempContact = null; 
		try{
			Connection db = DriverManager.getConnection(url, user, pwd);
			Statement s = db.createStatement();
			String sql = String.format(
					"SELECT * FROM CONTACT WHERE NAME = '%s'", contactName);
			ResultSet rs = s.executeQuery(sql);
			String tempName = null;
			PhoneNumber phoneNumber = null;
			while (rs.next()) {
				tempName = rs.getString("NAME");
				phoneNumber = new PhoneNumber(rs.getString("PHONENUMBER"));
				tempContact = new Contact(tempName, phoneNumber);
				contactList.add(tempContact);
			}
			s.close();
			db.commit();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactList;
	}
	
	/*
	 * private methods down under*/
	private void createTable() throws SQLException{
		boolean insertSuccessful = false;
		Connection db = null;
		Statement s = null;
		try{
			db = DriverManager.getConnection(url, user, pwd);
			db.setAutoCommit(false);
			s = db.createStatement();
			s.execute("create table Contact(NAME varchar(40), PHONENUMBER varchar(40))");
			db.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			db.rollback();
			throw e;
		}finally{
			if(s != null){
				s.close();
			}
			if(db != null){				
				db.close();
			}
		}
	} 
}
