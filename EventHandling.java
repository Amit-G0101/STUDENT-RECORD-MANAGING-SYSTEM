package mainwindow;
import java.awt.event.*;
import java.sql.*;

public class EventHandling implements ActionListener
{
	Window w;
	static String url="jdbc:mysql://localhost:3308/record";
	static String username="root";
	static String pass="";
	
	static String insertqry="insert into student (name) values(?)";
	
    public EventHandling(Window obj)
    {
        w=obj;
    }
	public void actionPerformed(ActionEvent e)
	{
		
		String name= w.tname.getText();
		
		
		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			if(con!=null)
			{
				System.out.print("success");
			}
			PreparedStatement pst=con.prepareStatement(insertqry);
			
			pst.setString(1,name);
			pst.executeUpdate();
			con.close();
			
		}
		catch(Exception a)
		{
		System.out.println(a);	
		}
			
	}

}
