package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import carshowroom.*;

class login1 extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField tuserid;
	JPasswordField tpassword;
	JButton login,signup,exit;
	String uid,pass,q;
	login1()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);
		upper.setLayout(null);
		//llogo.setBounds(30,50,400,100);


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
		JLabel subheading=new JLabel("Login into System");
		subheading.setFont(new Font("Arial Black",Font.BOLD,20));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(30,10,200,30);
		sublower.add(subheading);
		lower.add(sublower);
	
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,90,500,50);
		add(heading);
		

		JLabel luserid=new JLabel("UserID :");
		lower.add(luserid);
		luserid.setBounds(30,100,100,20);
		
		tuserid=new JTextField();
		lower.add(tuserid);
		tuserid.setBounds(30,120,200,30);
		tuserid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tuserid.setForeground(new Color(150,2,60));
	
		JLabel lpassword=new JLabel("Password :");
		lower.add(lpassword);
		lpassword.setBounds(30,220,100,20);

		tpassword=new JPasswordField();
		lower.add(tpassword);
		tpassword.setBounds(30,242,200,30);
		tpassword.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tpassword.setForeground(new Color(150,2,60));

		login=new JButton("LogIn");
		lower.add(login);
		login.setBounds(30,350,200,30);
		login.setBorderPainted(true);
		login.setContentAreaFilled(true);
		login.setBackground(new Color(150,2,60));
		login.setForeground(new Color(255,255,255));
		login.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		login.addActionListener(this);


		signup=new JButton("SignUP");
		lower.add(signup);
		signup.setBounds(30,390,200,30);
		signup.setBorderPainted(true);
		signup.setContentAreaFilled(true);
		signup.setBackground(new Color(150,2,60));
		signup.setForeground(new Color(255,255,255));
		signup.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		signup.addActionListener(this);

		exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	
				
		JLabel ilogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(ilogo);
		ilogo.setBounds(30,60,500,130);


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

		if(text.equals("LogIn"))
		{
			checkUser();
			clear();
		}//if

		if(text.equals("SignUP"))
		{
			registration reg=new registration();
			close();
		}//if
		if(text.equals("Exit"))
		{
			System.exit(0);
		}

	}//actionPerformed

	public void checkUser()
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		uid=tuserid.getText();
		pass=tpassword.getText();
		q="select * from tbl_login where user_id=? and password=?";
		String suid=tuserid.getText();
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","nilesh");

			ps=con.prepareStatement(q);
			ps.setString(1,uid);
			ps.setString(2,pass);

			rs=ps.executeQuery();

			if(rs.next())
			{
				JOptionPane.showMessageDialog(null,"Welcome "+suid);
				dashboard dash=new dashboard();
				//close();
			}//
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Username or Password");
			}//else
	

			close();
		}//try

		catch(Exception ex)
		{
				JOptionPane.showMessageDialog(null,ex);
		}//catch
	}//checkUser


	void clear()
	{
		tuserid.setText("");
		tpassword.setText("");
	}//clear

	public void close()
	{
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public static void main(String args[])
	{
		splash sp=new splash();
		new login1();
	}//main
}//reg class
	
