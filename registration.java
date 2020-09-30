package carshowroom;
import carshowroom.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;


class registration extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JLabel subheading,heading,lusername,luserid,lpassword,lgender,laddress;
	JTextField tusername,tuserid;
	JPasswordField tpassword;
	JTextArea taddress;
	JRadioButton rmale,rfemale;
	JButton signup,clear,exit;
	String sgender;
	dashboard dash;

	registration()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);
		upper.setLayout(null);

		lower=new JPanel();
		lower.setLayout(null);
		lower.setSize(250,600);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(580,100,250,500);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,250,60);
		subheading=new JLabel("User Registration");
		subheading.setFont(new Font("Arial Black",Font.BOLD,20));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(30,10,200,30);
		sublower.add(subheading);
		lower.add(sublower);
	
		heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,90,500,50);
		add(heading);
		

		lusername=new JLabel("Enter Full Name :");
		lower.add(lusername);
		lusername.setBounds(30,100,120,20);
		
		tusername=new JTextField();
		lower.add(tusername);
		tusername.setBounds(30,120,200,30);
		tusername.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tusername.setForeground(new Color(150,2,60));
	
		luserid=new JLabel("Choose UserID :");
		lower.add(luserid);
		luserid.setBounds(30,160,100,20);

		tuserid=new JTextField();
		lower.add(tuserid);
		tuserid.setBounds(30,180,200,30);
		tuserid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tuserid.setForeground(new Color(150,2,60));
	

		lpassword=new JLabel("Enter Password :");
		lower.add(lpassword);
		lpassword.setBounds(30,215,120,20);

		tpassword=new JPasswordField();
		lower.add(tpassword);
		tpassword.setBounds(30,235,200,30);
		tpassword.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tpassword.setForeground(new Color(150,2,60));

		lgender=new JLabel("Gender :");
		lower.add(lgender);
		lgender.setBounds(30,270,100,20);

		ButtonGroup rgender=new ButtonGroup();
		rmale=new JRadioButton("Male");
		lower.add(rmale);
		rmale.setBounds(30,300,60,20);
		rmale.setContentAreaFilled(false);
		rmale.setSelected(true);
		rgender.add(rmale);

		rfemale=new JRadioButton("Female");
		lower.add(rfemale);
		rfemale.setBounds(110,300,70,20);
		rfemale.setContentAreaFilled(false);
		rgender.add(rfemale);

		laddress=new JLabel("Residential Address :");
		lower.add(laddress);
		laddress.setBounds(30,335,135,20);

		taddress=new JTextArea();
		JScrollPane sc=new JScrollPane(taddress);
		lower.add(taddress);
		taddress.setBounds(30,355,200,80);
		taddress.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		taddress.setForeground(new Color(150,2,60));
		taddress.setLineWrap(true);

		JLabel ilogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(ilogo);
		ilogo.setBounds(30,60,500,130);


		signup=new JButton("SignUP");
		lower.add(signup);
		signup.setBounds(30,450,90,30);
		signup.setBorderPainted(true);
		signup.setContentAreaFilled(true);
		signup.setBackground(new Color(150,2,60));
		signup.setForeground(new Color(255,255,255));
		signup.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		signup.addActionListener(this);	

		clear=new JButton("Clear");
		lower.add(clear);
		clear.setBounds(140,450,90,30);
		clear.setBorderPainted(true);
		clear.setContentAreaFilled(true);
		clear.setBackground(new Color(150,2,60));
		clear.setForeground(new Color(255,255,255));
		clear.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		clear.addActionListener(this);

		exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	



		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//reg()
	
	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		String id=tuserid.getText();
		String pass=tpassword.getText();
		
		if(text.equals("SignUP"))
		{
			if(id.equals("")||pass.equals("")){
			JOptionPane.showMessageDialog(null,"Please Fill above Details");
			}
			else{
				save();
				dash=new dashboard();
				close();
			}
 		
		}//if

		else if(text.equals("Clear"))
		{
 			clear();
		}//if
		else if(text.equals("Exit"))
		{
			System.exit(0);
		}

		
	}//actionPerformed

	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	public void save()
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		if(rmale.isSelected()==true)
			sgender="Male";
		else
			sgender="Female";

		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","nilesh");

			stmt=con.createStatement();

			/*stmt.executeUpdate("insert into tbllogin(full_name) values('"+tusername.getText()+"')");*/			
			
			stmt.executeUpdate("insert into tbl_login(full_name,user_id,password,gender,address) values('"+tusername.getText()+"','"+tuserid.getText()+"','"+tpassword.getText()+"','"+sgender+"','"+taddress.getText()+"')");
			JOptionPane.showMessageDialog(null,"Susscesfully Register");		

			clear();
			
		}//try

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error : "+ex);
		}//catch
	}//save

	public void clear()
	{
		tusername.setText("");
		tuserid.setText("");
		tpassword.setText("");
		taddress.setText("");
	}
	public static void main(String args[])
	{
		new registration();
	}//main
}//reg class
	
