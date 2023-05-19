package module2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {
private static Connection con;
private static Statement st;
private static PreparedStatement pst;
private static ResultSet rs;
private static Scanner ip=new Scanner(System.in);//getting input from user
public static void create()throws ClassNotFoundException,SQLException{
	con=DB.getConnection();//conecting database
	st=con.createStatement();//conecting statement with database
	st.execute("create table marks(name varchar(20),rollno varchar(10),maths int,science int,english int)");//executing statement
	System.out.println("table created sucessfully");
}
public static void insert()throws ClassNotFoundException,SQLException{
	con=DB.getConnection();
	pst=con.prepareStatement("insert into marks values(?,?,?,?,?)");//prepared statement is used to get the values in the runtime
	for(int i=0;i<1;i++) {//getting four person data
	System.out.println("enter your name");
	pst.setString(1,ip.next() );//setstring is used to set the value to the database
	System.out.println("enter your age");
	pst.setString(2, ip.next());
	System.out.println("enter your maths mark");
	pst.setInt(3,ip.nextInt());
	System.out.println("enter your science mark");
	pst.setInt(4, ip.nextInt());
	System.out.println("enter your english");
	pst.setInt(5, ip.nextInt());
	pst.executeUpdate();//execute update is used to execute the query
	}
	}
public static void display() throws ClassNotFoundException,SQLException{
	con=DB.getConnection();
	st=con.createStatement();
	rs=st.executeQuery("select * from marks");//resultset is used to store the data 
	while(rs.next()) {//move until the database gets over
	System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));//to get the value and print it
			}
}

public static void update()throws ClassNotFoundException,SQLException{
	con=DB.getConnection();
	pst=con.prepareStatement("update marks set maths=(?)where name='hari'");//using prepared statement to update the values
	System.out.println("enter your marks");
	pst.setString(1,ip.next() );
	pst.executeUpdate();
	}
	
public static void delete()throws ClassNotFoundException,SQLException{
	con=DB.getConnection();
	pst=con.prepareStatement("delete from marks where name=(?)");
	System.out.println("enter the name of the record to delete");
	pst.setString(1,ip.next() );
	pst.executeUpdate();
	}
public static void main(String[] args)throws ClassNotFoundException,SQLException{
	Scanner sc=new Scanner(System.in);
	while(true) {//infinite loop
	System.out.println("1:create \n2:insert \n3:display");
	int option=sc.nextInt();
	switch(option) {
	case 1:
		create();
		break;
	case 2:
		insert();
		break;
	case 3:
		display();
		break;
	
	case 4:
		update();
		break;
	case 5:
		delete();
		break;
	}
	}
}
}

