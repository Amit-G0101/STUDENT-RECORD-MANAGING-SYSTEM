package mainWindow;
import java.awt.event.*;
import java.sql.*;

class EventHandling implements ActionListener
{
	Window w;
	LoginWindow lw;
	static String url="jdbc:mysql://localhost:3306/record";
	static String username="root";
	static String pass="";
	String name,fname,dob,course,sem,gender;
	String s_name,s_course,s_sem;
	static String insertqry="insert into student values(?,?,?,?,?,?)";
	static String fetchqry="select * from student where name=? AND Course=? AND semester=?";
	
    public EventHandling(Object obj)
    {
    	if(obj instanceof Window)
        w=(Window)obj;

    }
   
	public void actionPerformed(ActionEvent e)
	{
	
	
		if(e.getActionCommand().equals("Register"))
		{
		name= w.tname.getText();
		fname=w.tfname.getText();
		dob=w.tdob.getText();
		gender=w.cbg_gender.getSelectedCheckbox().getLabel();
		course=w.c_course.getSelectedItem();
		sem=w.tsem.getText();
		}
		else // search
		{
			s_name=w.t2_name.getText();
			s_course=w.t2_course.getText();
			s_sem=w.t2_sem.getText();
			
		}
		
		try(Connection con=DriverManager.getConnection(url,username,pass);)
		{
			
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			if(e.getActionCommand().equals("Register"))
			{
				
			
			 PreparedStatement pst=con.prepareStatement(insertqry);
			
			 pst.setString(1,name);
			 pst.setString(2,fname);
			
			 pst.setString(3,dob);
			 pst.setString(4,gender);
			 pst.setString(5,course);
			 pst.setString(6,sem);
			 pst.executeUpdate();
			 pst.close();
			 
		  }
			else
			{
				PreparedStatement pst=con.prepareStatement(fetchqry);
				pst.setString(1,s_name);
				pst.setString(2, s_course);
				pst.setString(3,s_sem);
				ResultSet rs=pst.executeQuery();
			
				
				if(rs.next()==false) // empty
				{
					w.tarea.setText("OPPS!!!! NO RECORD FOUND");
					
				}
				else
				{
				
					int i=1;
					
				    w.tarea.setText("NAME: "+rs.getString(i++)+"\n"+
				    "FATHER's NAME: "+rs.getString(i++)+"\n"+
				    "DOB: "+rs.getString(i++)+"\n"+
				    "GENDER: "+rs.getString(i++)+"\n"+
				    "COURSE: "+rs.getString(i++)+"\n"+
				    "SEMESTER: "+rs.getString(i++));
				 
				 
				 
				}
			}
		}
		catch(Exception a)
		{
			
		}
		
	}
 
}
