package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import carshowroom.*;

class customer extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	
	JTextField tcustid,tcustname,tcustmobile,tcustdob; 
	JTextArea tcustaddress;
	JButton save,clear,exit,logout;
	JRadioButton rcustmale,rcustfemale;
	String sgender;
	customer()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);
		upper.setLayout(null);

		lower=new JPanel();
		lower.setLayout(null);
		lower.setSize(250,650);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(580,20,250,650);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,250,60);
		JLabel subheading=new JLabel("Add Customer Details");
		subheading.setFont(new Font("Arial Black",Font.BOLD,17));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(30,10,200,30);
		sublower.add(subheading);
		lower.add(sublower);
	
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,90,500,50);

		JLabel lcustid=new JLabel("Enter CustomerID :");
		lower.add(lcustid);
		lcustid.setBounds(30,100,120,20);
		
		tcustid=new JTextField();
		lower.add(tcustid);
		tcustid.setBounds(30,130,200,30);
		tcustid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		tcustid.setForeground(new Color(150,2,60));

		JLabel lcustname=new JLabel("Customer Name :");
		lower.add(lcustname);
		lcustname.setBounds(30,170,200,30);
		
		tcustname=new JTextField();
		lower.add(tcustname);
		tcustname.setBounds(30,200,200,30);
		tcustname.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		tcustname.setForeground(new Color(150,2,60));

		
		JLabel lcustmobile=new JLabel("Customer Mobile Number :");
		lower.add(lcustmobile);
		lcustmobile.setBounds(30,240,200,30);

		tcustmobile=new JTextField();
		lower.add(tcustmobile);
		tcustmobile.setBounds(30,270,200,30);
		tcustmobile.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		tcustmobile.setForeground(new Color(150,2,60));

		JLabel lgender=new JLabel("Gender :");
		lower.add(lgender);
		lgender.setBounds(30,310,200,30);
		
		ButtonGroup rcustgender=new ButtonGroup();
		rcustmale=new JRadioButton("Male");
		lower.add(rcustmale);
		rcustmale.setBounds(30,350,60,20);
		rcustmale.setContentAreaFilled(false);
		rcustgender.add(rcustmale);

		JRadioButton rcustfemale=new JRadioButton("Female");
		lower.add(rcustfemale);
		rcustfemale.setBounds(110,350,70,20);
		rcustfemale.setContentAreaFilled(false);
		rcustgender.add(rcustfemale);


		JLabel lcustaddress=new JLabel("Customer Address :");
		lower.add(lcustaddress);
		lcustaddress.setBounds(30,380,200,30);

		tcustaddress=new JTextArea();
		lower.add(tcustaddress);
		tcustaddress.setBounds(30,410,200,100);
		tcustaddress.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		tcustaddress.setForeground(new Color(150,2,60));
		tcustaddress.setLineWrap(true);

		JLabel lcustdob=new JLabel("Date of Birth :");
		lower.add(lcustdob);
		lcustdob.setBounds(30,520,200,30);
		
		tcustdob=new JTextField();
		lower.add(tcustdob);
		tcustdob.setBounds(30,550,200,30);
		tcustdob.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		tcustdob.setForeground(new Color(150,2,60));

		save=new JButton("Save");
		lower.add(save);
		save.setBounds(30,600,90,30);
		save.setBorderPainted(true);
		save.setContentAreaFilled(true);
		save.setBackground(new Color(150,2,60));
		save.setForeground(new Color(255,255,255));
		save.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		save.addActionListener(this);

		JButton clear=new JButton("Show Details");
		lower.add(clear);
		clear.setBounds(140,600,90,30);
		clear.setBorderPainted(true);
		clear.setContentAreaFilled(true);
		clear.setBackground(new Color(150,2,60));
		clear.setForeground(new Color(255,255,255));
		clear.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		clear.addActionListener(this);
		

		JLabel ilogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(ilogo);
		ilogo.setBounds(30,60,500,130);

		logout=new JButton("Home");
		add(logout);
		logout.setBounds(836,20,70,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(255,255,255));
		logout.setForeground(new Color(150,2,60));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	logout.addActionListener(this);	

		exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	
		
		
		add(heading);
		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//customer()

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Save")){
		save();
		clear();
		}
		if(text.equals("Show Details")){
		clear();
		Details d=new Details("tbl_customer");
		close();
		}
		if(text.equals("Home"))
		{
			dashboard dash=new dashboard();
			close();
		}
		if(text.equals("Exit"))
			System.exit(0);
	}
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	public void save()
	{
		Connection conn=null;
		Statement stmt=null;

		if(rcustmale.isSelected()==true)
			sgender="Male";
		else
			sgender="Female";

		try{

	
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tbl_customer(cust_id,cust_name,cust_addr,cust_mobno,cust_gender,cust_dob) values('"+tcustid.getText()+"','"+tcustname.getText()+"','"+tcustaddress.getText()+"','"+tcustmobile.getText()+"','"+sgender+"','"+tcustdob.getText()+"')");
			
		}//try

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error : "+ex);
			//System.out.println("Error : "+ex);
		}//catch
	}

	public void clear()
	{	
			tcustid.setText("");
			tcustname.setText("");
			tcustaddress.setText("");			
			tcustmobile.setText("");
			tcustdob.setText("");
	}
	public static void main(String args[])
	{
		new customer();
	}//main
}//reg class
	
