package mainWindow;

import java.awt.*;

import java.awt.event.*;


public class Window extends Frame 
{
	   String choiceList[]= {"MCA","BCA","BBA","BTech","MBA","MTech"};
	   Panel panel1,sub1$panel1,sub2$panel1;
	   Panel panel2,sub1$panel2,sub2$panel2;
	   
	   Button regisbtn, searchbtn;
	   Label l1_name ,l1_fname,l1_dob,l1_sem, l1_title,l1_gender,l1_course; 
	   Label l2_title,l2_name,l2_course,l2_sem;
	   TextField tname ,tfname,tdob,tsem;   // tcourse,tgender
	   TextField t2_name,t2_course,t2_sem;
	   TextArea tarea;
	   Choice c_course;
	   Checkbox cb_male,cb_female,cb_other;
	   CheckboxGroup cbg_gender;
	   void backgrd()
	   {
		   panel1.setBackground(Color.cyan);
	           sub1$panel1.setBackground(Color.yellow);
	           sub2$panel1.setBackground(Color.orange);
	           
	       panel2.setBackground(Color.gray);
	       sub1$panel2.setBackground(Color.yellow);
	       sub2$panel2.setBackground(Color.orange);
	       
	      
	           
	   }
	   void addingIntoPanel()
	   {  
		   /*     ********** panel1 *************   */
	          panel1.setLayout(null);
	          sub1$panel1.setBounds(200,10,400,50);
	          sub2$panel1.setBounds(200,100,400,550);
	          regisbtn.setBounds(300,690,200,50);
	          panel1.setFont(new Font("Verdana", Font.PLAIN, 20));
	          
	           panel1.add(sub1$panel1);
	           panel1.add(sub2$panel1);
	           panel1.add(regisbtn);
	           sub1$panel1.add(l1_title);
	        
	           sub2$panel1.setLayout(new GridLayout(14,1));
		   sub2$panel1.add(l1_name);
		   sub2$panel1.add(tname);
		   sub2$panel1.add(l1_fname);
		   sub2$panel1.add(tfname);
		   sub2$panel1.add(l1_dob);
		   sub2$panel1.add(tdob);
		   
		   
		   sub2$panel1.add(l1_gender);
		   sub2$panel1.add(cb_male);
		   sub2$panel1.add(cb_female);
		   sub2$panel1.add(cb_other);
		   
		   sub2$panel1.add(l1_course);
		   sub2$panel1.add(c_course);
		   
		   
		   sub2$panel1.add(l1_sem);
		   sub2$panel1.add(tsem);
		   
		/* ******************** panel2 ****************** */
		   
		  panel2.setLayout(null);
	       sub1$panel2.setBounds(150,10,500,50);
	       sub2$panel2.setBounds(150,100,500,260);
	       searchbtn.setBounds(250,400,300,50);
	       panel2.setFont(new Font("Verdana", Font.PLAIN, 20));
	       tarea.setBounds(20,460,720,300);
	       tarea.setEditable(false);
	       panel2.add(sub1$panel2);
	       panel2.add(sub2$panel2);
	       panel2.add(searchbtn);
	      
	       
	       sub1$panel2.add(l2_title);
	       
	       sub2$panel2.add(l2_name);
	       sub2$panel2.add(t2_name);
	       sub2$panel2.add(l2_course);
	       sub2$panel2.add(t2_course);
	       sub2$panel2.add(l2_sem);
	       sub2$panel2.add(t2_sem);
	       
	       panel2.add(tarea);
	       

	   }
	   public  Window()
	   {
		   
		   setLayout(new GridLayout());
	       setVisible(true);  
	       setSize(getMaximumSize());
	       setResizable(false);
	       
	       addWindowListener(new WindowAdapter(){
	    	   public void windowClosing(WindowEvent e)
	    	   {
	    		   System.exit(0);
	    	   }
	       });
	     /*---------------------PANEL-------------------*/
		   panel1=new Panel();
	           sub1$panel1=new Panel();
	           sub2$panel1=new Panel();
	           
	       panel2=new Panel();    
	           sub1$panel2=new Panel();
	           sub2$panel2=new Panel();
	           
	           
	       
	    /*---------------------Label-------------------*/
		   l1_name=new Label("NAME");
		   l1_fname=new Label("FATHER'S NAME");
		   l1_dob=new Label("DATE OF BIRTH (yyyy-mm-dd)");
		   l1_course=new Label("COURSE");
		   l1_sem=new Label("SEMESTER (1-6)");
		   l1_gender=new Label("GENDER");
	       l1_title=new Label("Registration Window");
	           
	           
	           l2_name=new Label("NAME");
	    	   l2_course=new Label("COURSE");
	    	   l2_sem=new Label("SEMESTER");
	           l2_title=new Label("SEARCH RECORD");
	       
	           
	     /*---------------------TEXTFIELD-------------------*/
	           
	       tname=new TextField(25);
	       tfname=new TextField(25);
	       tdob=new TextField(25);
	       //tcourse=new TextField(25);
	       tsem=new TextField(25);
	       //tgender=new TextField(25);
	      	
	       
	       t2_name=new TextField(30);
	       t2_course=new TextField(30);
	       t2_sem=new TextField(30);
	       
	       /*--------------------------TextArea-----------------------*/
	       
	       tarea=new TextArea();
	     /*---------------------BUTTON-------------------*/
	         regisbtn=new Button("Register");
	         searchbtn=new Button("Search");
	         
	         /*---------------------Choice List-------------------*/
	         c_course=new Choice();
	         for(String s:choiceList)
	         {
	        	 c_course.add(s);
	         }
	         /*---------------------Checkbox-------------------*/
	         cbg_gender=new CheckboxGroup();
	         cb_male=new Checkbox("Male",cbg_gender,true);
	         cb_female=new Checkbox("Female",cbg_gender,false);
	         cb_other=new Checkbox("Others",cbg_gender,false);
	         
	         
	         
	         this.backgrd();
		   
		   
		    add(panel1);
		    add(panel2);
	       this.addingIntoPanel();
	       
	       regisbtn.addActionListener(new EventHandling(this));
	       searchbtn.addActionListener(new EventHandling(this));
	    
	   }


	public static void main(String[] args) 
	{
		
      Window w=new Window();
	}

}
