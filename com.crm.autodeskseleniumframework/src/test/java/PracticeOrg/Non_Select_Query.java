package PracticeOrg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Non_Select_Query
{
	public static void main(String[] args) throws Throwable 
	{
		Connection conn=null;
		int result=0;
		try
		{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra1", "root", "root");
		System.out.println("connection is done");
		
		Statement stat=conn.createStatement();
		String query="insert into students_info values('9', 'rak', 'gowd', 'h')";
		
		result=stat.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
		finally
		{
			if(result==1)
			{
				System.out.println("inserted succesfully");
			}
			else
			{
				System.out.println("not inserted successfully");
			}
			conn.close();
			System.out.println("---close db connect-----");
		}
		


		
		
		
		
	}

}

