package mainWindow;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class HandleLogin implements ActionListener
{
	LoginWindow lw;
	private static boolean authenticity=false;
	static String url="jdbc:mysql://localhost:3306/record";
	static String username="root";
	static String pass="";
	public HandleLogin(LoginWindow obj) 
	{
		
		lw=obj;
		
	
	}
	public void actionPerformed(ActionEvent e1)
	{
		try(Connection con=DriverManager.getConnection(url,username,pass);)
		{
		
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Statement st=con.createStatement();
			 ResultSet rs= st.executeQuery("select * from admin");
			 
			 while(rs.next())
			 {
				 
				 if(rs.getString(1).equals(lw.tuser.getText()) && rs.getString(2).equals(lw.tpass.getText()))
				 {
					authenticity=true; 
					break;
				 }
				 
				 
			 }
			if(authenticity==true)
			{
				lw.setVisible(false);
				Window.main(null);
				
			}
			else
			{
				lw.message="-----Invalid USER----";
				lw.repaint();
			}
		
	    }
	    catch(SQLException e)
		{
		  
		} 
		catch (ClassNotFoundException e) 
		{

	    }
		
		
  }
}

public class LoginWindow extends Frame
{
	String message="";
	Label title,username,password;
	TextField tuser,tpass;
	Button login;
	Panel panel1,panel2;
	
    void addComponent()
    {
    	/* -----------------position---------*/
    	this.setLayout(null);// frame
    	panel1.setBounds(50,50,400,30);
    	panel2.setBounds(50,100,400,300);
    	panel2.setLayout(new GridLayout(6,1));
    	this.add(panel1);
    	this.add(panel2);
    	
        
    	
        title.setBackground(Color.YELLOW);
    	panel2.setBackground(Color.CYAN);
    	tuser.setForeground(Color.red);
    	tpass.setForeground(Color.red);
    	tpass.setEchoChar('*');
    	
    	
      panel1.add(title);
      panel2.add(username);
      panel2.add(tuser);
      panel2.add(password);
      panel2.add(tpass);
      panel2.add(login);
      
      
    
     
      
      
    }
	public LoginWindow()
	{
	  	this.setVisible(true);
	  	this.setBounds(400,100,500,500);
	  	this.setResizable(false);
	  	this.setBackground(Color.gray);
	  	this.setFont(new Font("Verdana", Font.PLAIN, 20));
	  	this.addWindowListener(new WindowAdapter(){
	    	   public void windowClosing(WindowEvent e)
	    	   {
	    		   System.exit(0);
	    	   }
	       });
	  	
	  	/* *************LABEL**************** */
	  	title=new Label("LOGIN WINDOW");
	  	username=new Label("USERNAME");
	  	password=new Label("PASSWORD");
	  	/* ************ TEXTFIELD ************ */
	  	tuser=new TextField(20);
	  	tpass=new TextField(20);
	  	/* ************ BUTTON ************ */
	  	login=new Button("Login");
	  	/* *************PANEL***************** */
	  	panel1=new Panel();
	  	panel2=new Panel();
	  	
	  	
	  	
	   this.addComponent();
	   login.addActionListener(new HandleLogin(this));
	}
	
	public void paint(Graphics g)
	{g.setColor(Color.red);
		g.drawString(message, 100,460);
		
	}
	public static void main(String[] args) 
	{
	 LoginWindow lw=new LoginWindow();

	}

}
