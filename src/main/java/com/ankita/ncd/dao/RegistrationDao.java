package com.ankita.ncd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ankita.ncd.model.Registration;

public class RegistrationDao {

	 public long registerPatient(Registration register) throws ClassNotFoundException {
	        
		   String SELECT_ALL_SQL = "SELECT patient_id from patientinfo";
		 
		    String INSERT_PATIENT_SQL = "INSERT INTO patientinfo" +
	            "  (patient_id,first_name, last_name, gender, aadhaar_uid, phone_no, dob, pincode) VALUES " +
	            " (?,?, ?, ?, ?, ?,?,?);";
	        
	        String SELECT_PATIENT_SQL= "SELECT patient_id from patientinfo WHERE aadhaar_uid = ?;";

	        //int result = 0;
	        long result=0;

	        Class.forName("com.mysql.jdbc.Driver");
	        
	        
	       
			try ( Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "root", "Ankita@18Riya");

		            //Create a statement using connection object
		            PreparedStatement selectStatement = connection.prepareStatement(SELECT_ALL_SQL)) {
		            
	        		System.out.println(selectStatement);
	        		ResultSet rs = selectStatement.executeQuery();
	        
	        		if(rs.next())
	        		{
	        			while(rs.next())
	        			{
	        				long id = (long) (Math.random() * 100000000000000L);
	        				System.out.println(id);
	        				if(id!=rs.getLong(1))
	        				{
	        					try (Connection con = DriverManager
	        				            .getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "root", "Ankita@18Riya");

	        				            //Create a statement using connection object
	        				            PreparedStatement preparedStatement = con.prepareStatement(INSERT_PATIENT_SQL)) {
	        							preparedStatement.setLong(1, id);
	        							preparedStatement.setString(2, register.getFirstname());
	        				            preparedStatement.setString(3, register.getLastname());
	        				            preparedStatement.setString(4, register.getGender());
	        				            preparedStatement.setString(5, register.getAadhaar());
	        				            preparedStatement.setString(6, register.getPhone());
	        				            preparedStatement.setString(7, register.getBirthday());
	        				            preparedStatement.setInt(8, register.getPincode());
	        				            
	        				            //connection.commit();

	        				            System.out.println(preparedStatement);
	        				            // Execute the query or update query
	        				            preparedStatement.executeUpdate();
	        				            break;

	        				        } catch (SQLException e) {
	        				            // process sql exception
	        				            printSQLException(e);
	        				        }
	        				}
	        				else
	        				{
	        					continue;
	        				}
	        			}
	        		}
	        		else
	        		{
	        			long id = (long) (Math.random() * 100000000000000L);
	        			try (Connection con = DriverManager
    				            .getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "root", "Ankita@18Riya");

    				            //Create a statement using connection object
    				            PreparedStatement preparedStatement = con.prepareStatement(INSERT_PATIENT_SQL)) {
    							preparedStatement.setLong(1, id);
    							preparedStatement.setString(2, register.getFirstname());
    				            preparedStatement.setString(3, register.getLastname());
    				            preparedStatement.setString(4, register.getGender());
    				            preparedStatement.setString(5, register.getAadhaar());
    				            preparedStatement.setString(6, register.getPhone());
    				            preparedStatement.setString(7, register.getBirthday());
    				            preparedStatement.setInt(8, register.getPincode());
    				            
    				            //connection.commit();

    				            System.out.println(preparedStatement);
    				            // Execute the query or update query
    				            preparedStatement.executeUpdate();
    				           

    				        } catch (SQLException e) {
    				            // process sql exception
    				            printSQLException(e);
    				        }
	        		}
	        		
		            

		        } catch (SQLException e) {
		            // process sql exception
		            printSQLException(e);
		        }
	        
	        
	        
	        
	        

	        /*try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "root", "Ankita@18Riya");

	            //Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {
	            preparedStatement.setString(1, register.getFirstname());
	            preparedStatement.setString(2, register.getLastname());
	            preparedStatement.setString(3, register.getGender());
	            preparedStatement.setString(4, register.getAadhaar());
	            preparedStatement.setString(5, register.getPhone());
	            preparedStatement.setString(6, register.getBirthday());
	            preparedStatement.setInt(7, register.getPincode());
	            
	            //connection.commit();

	            System.out.println(preparedStatement);
	            // Execute the query or update query
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }*/
	        
	        
	        try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "root", "Ankita@18Riya");

		            //Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_SQL)) {
		            preparedStatement.setString(1, register.getAadhaar());
		    
		            
		            System.out.println(preparedStatement);
		            // Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();
		            
		            while (rs.next())
		                result = rs.getLong("patient_id");

		        } catch (SQLException e) {
		            // process sql exception
		            printSQLException(e);
		        }
	        
	        
	        return result;
	    }
	 

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}

