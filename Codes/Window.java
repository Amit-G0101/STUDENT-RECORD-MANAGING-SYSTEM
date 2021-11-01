package mainwindow;
import java.applet.*;
import java.awt.*;


public class Window extends Applet
{
   Panel panel1,sub1$panel1,sub2$panel1;
   Panel panel2,sub1$panel2,sub2$panel2;
   Button regisbtn, searchbtn;
   Label l1_name ,l1_fname,l1_dob,l1_course,l1_sem,l1_gender, l1_title;
   Label l2_title,l2_name,l2_course,l2_sem;
   TextField tname ,tfname,tdob,tcourse,tsem,tgender;
   TextField t2_name,t2_course,t2_sem;
   
   
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
	   /********** panel1 *************/
          panel1.setLayout(null);
          sub1$panel1.setBounds(200,10,400,50);
          sub2$panel1.setBounds(200,100,400,600);
          regisbtn.setBounds(300,720,200,50);
          panel1.setFont(new Font("Verdana", Font.PLAIN, 20));
          
           panel1.add(sub1$panel1);
           panel1.add(sub2$panel1);
           panel1.add(regisbtn);
           sub1$panel1.add(l1_title);
          
	   sub2$panel1.add(l1_name);
	   sub2$panel1.add(tname);
	   sub2$panel1.add(l1_fname);
	   sub2$panel1.add(tfname);
	   sub2$panel1.add(l1_dob);
	   sub2$panel1.add(tdob);
	   sub2$panel1.add(l1_gender);
	   sub2$panel1.add(tgender);
	   sub2$panel1.add(l1_course);
	   sub2$panel1.add(tcourse);
	   sub2$panel1.add(l1_sem);
	   sub2$panel1.add(tsem);
	   
	/* ******************** panel2 ****************** */
	   
	  panel2.setLayout(null);
       sub1$panel2.setBounds(250,10,500,50);
       sub2$panel2.setBounds(250,100,500,260);
       searchbtn.setBounds(350,400,300,50);
       panel2.setFont(new Font("Verdana", Font.PLAIN, 20));
      
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
       
      
       

   }
   public void init()
   {
	   this.setLayout(new GridLayout());
           
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
	   l1_dob=new Label("DATE OF BIRTH");
	   l1_course=new Label("COURSE");
	   l1_sem=new Label("SEMESTER");
	   l1_gender=new Label("GENDER");
       l1_title=new Label("Registration Window");
           
           
           l2_name=new Label("NAME");
    	   l2_course=new Label("COURSE");
    	   l2_sem=new Label("SEMESTER");
           l2_title=new Label("SEARCH RECORD");
       
     /*---------------------TEXTFIELD-------------------*/
           
       tname=new TextField(30);
       tfname=new TextField(30);
       tdob=new TextField(30);
       tcourse=new TextField(30);
       tsem=new TextField(30);
       tgender=new TextField(30);
      	
       
       t2_name=new TextField(40);
       t2_course=new TextField(40);
       t2_sem=new TextField(40);
     /*---------------------BUTTON-------------------*/
         regisbtn=new Button("Register");
         searchbtn=new Button("Search");
         
	   this.backgrd();
	   
	   
	   this.add(panel1);
	   this.add(panel2);
       this.addingIntoPanel();
       
       regisbtn.addActionListener(new EventHandling(this));
    
   }
   
   


}

/*<applet code="Window.class" width=1500 height=700>
 </applet>
 
*/