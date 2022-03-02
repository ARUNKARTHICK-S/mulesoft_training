import java.sql.*;
import java.util.*;
class mulesoft
{
	public static void main(String[] args) 
	{
		//Scanner sc =new Scanner(System.in);
		try
		{
			Scanner sc=new Scanner(System.in);
			String url="jdbc:mysql://localhost:3306/";
			String username="arun2";
			String password="Esysryes12@";
			Connection myConnect=DriverManager.getConnection(url,username,password);
			Statement mystat=myConnect.createStatement();
			String sql="create database mulesoft";
			mystat.executeUpdate(sql);
			String s="use mulesoft";
			mystat.executeUpdate(s);
			String sql1="create table movies (name varchar(100),actor varchar(100),actress varchar(100),director varchar(100),year integer)";
			mystat.executeUpdate(sql1);
			String query="insert into movies values ('iron man','robert downey jr','gwyneth paltrow','jon fevreau',2008)";
			mystat.executeUpdate(query);
			//System.out.println("Inserted");	
			query="insert into movies values ('iron man 3','robert downey jr','gwyneth paltrow','shane black',2013)";
			mystat.executeUpdate(query);
			//System.out.println("Inserted");	
			query="insert into movies values ('spider man no way home','tom holland','zendaya','jon watts',2021)";
			mystat.executeUpdate(query);
			//System.out.println("Inserted");
			query="insert into movies values ('sarkar','vijay','keerthy suresh','murugadoss',2018)";
			mystat.executeUpdate(query);
			//System.out.println("Inserted");	
			ResultSet myresult=mystat.executeQuery("Select * from movies");
			while(myresult.next())
			{
				System.out.println("Movie name: "+myresult.getString("name")+" Actor: "+myresult.getString("actor")+" Actress: "+myresult.getString("actress")+" Director: "+myresult.getString("director")+" Year of the movie: "+myresult.getString("year"));
			}
			System.out.println();
			System.out.println();
			mystat.getMoreResults();
			show();
			ResultSet myresult1=mystat.executeQuery("Select * from movies where actor='robert downey jr'");
			while(myresult1.next())
			{
				System.out.println("Movie name: "+myresult1.getString("name")+" Actor: "+myresult1.getString("actor")+" Actress: "+myresult1.getString("actress")+" Director: "+myresult1.getString("director")+" Year of the movie: "+myresult1.getString("year"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}