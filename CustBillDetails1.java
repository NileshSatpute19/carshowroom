package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import carshowroom.*;

class CustBillDetails1 extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JButton exit,logout;

	CustBillDetails1()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setLayout(null);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);
		JLabel llogo=new JLabel(new ImageIcon("/root/Desktop/Car Showroom/actual/logo/log1.png"));
		upper.add(llogo);
		llogo.setBounds(30,50,400,100);

		lower=new JPanel();
		lower.setLayout(null);
		//lower.setSize(400,600);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(480,150,510,500);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,510,60);
		JLabel subheading=new JLabel("Generated Customer Bill");
		subheading.setFont(new Font("Arial Black",Font.BOLD,20));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(10,10,400,30);
		sublower.add(subheading);
		lower.add(sublower);
	
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,90,500,50);
		add(heading);

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

		logout=new JButton("Home");
		add(logout);
		logout.setBounds(800,20,70,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(255,255,255));
		logout.setForeground(new Color(150,2,60));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	logout.addActionListener(this);	


		String billno=JOptionPane.showInputDialog(null,"Enter Customer bill ID");

		generate(billno);
		
		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//CustBillDetails1()


	public void generate(String billno)
	{

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		//int billid,bookid,prodqty,prodid,carid;
		String custbill_date,billid,bookid,prodqty,prodid,carid;
		try
		{

			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from tbl_customerbill where custbill_id='"+billno+"'");

			while(rs.next())
			{
				billid=Integer.toString(rs.getInt(1));
				bookid=Integer.toString(rs.getInt(2));
				prodqty=Integer.toString(rs.getInt(3));
				custbill_date=rs.getString(4);
				prodid=Integer.toString(rs.getInt(5));
				carid=Integer.toString(rs.getInt(6));

				JLabel dcustomer_billno=new JLabel(billid);
				dcustomer_billno.setBounds(185,100,150,20);
				lower.add(dcustomer_billno);

				JLabel dcustomer_billdate=new JLabel(custbill_date);
				dcustomer_billdate.setBounds(185,150,150,20);
				lower.add(dcustomer_billdate);
	
				JLabel dbookid=new JLabel(bookid);
				dbookid.setBounds(185,200,150,20);
				lower.add(dbookid);
					
				JLabel dproductquntity=new JLabel(prodqty);
				dproductquntity.setBounds(185,250,150,20);
				lower.add(dproductquntity);
	
				JLabel dproductid=new JLabel(prodid);
				dproductid.setBounds(185,300,180,20);
				lower.add(dproductid);

				JLabel dcarid=new JLabel(carid);
				dcarid.setBounds(185,350,180,20);
				lower.add(dcarid);
		
			}//while

			JLabel lcustomer_billno=new JLabel("Customer Bill No :");
			lcustomer_billno.setBounds(30,100,150,20);
			lower.add(lcustomer_billno);
	
			
			JLabel lcustomer_billdate=new JLabel("Cutomer Bill Date :");
			lcustomer_billdate.setBounds(30,150,150,20);
			lower.add(lcustomer_billdate);
	
	
			JLabel lbookid=new JLabel("BookID :");
			lbookid.setBounds(30,200,150,20);
			lower.add(lbookid);
			
			
			JLabel lproductquntity=new JLabel("Product Quntity :");
			lproductquntity.setBounds(30,250,150,20);
			lower.add(lproductquntity);
			
	
			JLabel lproductid=new JLabel("ProductID :");
			lproductid.setBounds(30,300,180,20);
			lower.add(lproductid);
	
		
			JLabel lcarid=new JLabel("CarID :");
			lcarid.setBounds(30,350,180,20);
			lower.add(lcarid);
		
	
			JLabel signature=new JLabel("Signature");
			signature.setBounds(430,450,180,20);
			lower.add(signature);
		}//try
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
		}//catch
	
	}//generate()

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Home"))
		{
			dashboard dash=new dashboard();
			close();
		}
		else if(text.equals("Exit"))
		{
			System.exit(0);
		}
	}
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public static void main(String args[])
	{
		new CustBillDetails1();
	}//main
}//reg class
	
