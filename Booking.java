package carshowroom;
import java.awt.*;	
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Booking extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField tBookid,tprod_quntity,tprodid,tcarid,tcustomerid;
	JFormattedTextField tbookdate;
	JButton submit,reset,exit,logout;
	Booking()
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
		lower.setBounds(580,100,250,550);

		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,250,60);
		JLabel subheading=new JLabel("Booking");
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

		JLabel llogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(llogo);
		llogo.setBounds(30,60,400,100);

		JLabel lBookid=new JLabel("BookingID :");
		lower.add(lBookid);
		lBookid.setBounds(30,100,100,20);

		tBookid=new JTextField();
		lower.add(tBookid);
		tBookid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tBookid.setForeground(new Color(150,2,60));
		tBookid.setBounds(30,120,200,30);

		JLabel lbookdate=new JLabel("Booking Date :");
		lower.add(lbookdate);
		lbookdate.setBounds(30,160,100,20);
	
		tbookdate=new JFormattedTextField(new java.util.Date());
		lower.add(tbookdate);
		tbookdate.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tbookdate.setForeground(new Color(150,2,60));
		tbookdate.setBounds(30,180,200,30);

		JLabel lprod_quntity=new JLabel("Product Quntity :");
		lower.add(lprod_quntity);
		lprod_quntity.setBounds(30,220,110,20);

		tprod_quntity=new JTextField();
		lower.add(tprod_quntity);
		tprod_quntity.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tprod_quntity.setForeground(new Color(150,2,60));
		tprod_quntity.setBounds(30,240,200,30);

		JLabel lprodid=new JLabel("ProductID :");
		lprodid.setBounds(30,280,100,20);
		lower.add(lprodid);

		tprodid=new JTextField();
		lower.add(tprodid);
		tprodid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tprodid.setForeground(new Color(150,2,60));
		tprodid.setBounds(30,300,200,30);

		JLabel lcustomerid=new JLabel("CustomerID :");
		lcustomerid.setBounds(30,340,100,20);
		lower.add(lcustomerid);

		tcustomerid=new JTextField();
		lower.add(tcustomerid);
		tcustomerid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcustomerid.setForeground(new Color(150,2,60));
		tcustomerid.setBounds(30,360,200,30);

		JLabel lcarid=new JLabel("CarID :");
		lcarid.setBounds(30,400,100,20);
		lower.add(lcarid);

		tcarid=new JTextField();
		lower.add(tcarid);
		tcarid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarid.setForeground(new Color(150,2,60));
		tcarid.setBounds(30,420,200,30);

		submit=new JButton("Submit");
		submit.setBounds(30,460,200,30);
		submit.setBorderPainted(true);
		submit.setContentAreaFilled(true);
		submit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		submit.setBackground(new Color(150,2,60));
		submit.setForeground(new Color(255,255,255));
		lower.add(submit);
		submit.addActionListener(this);

		
		reset=new JButton("Show Details");
		reset.setBounds(30,500,200,30);
		reset.setBorderPainted(true);
		reset.setContentAreaFilled(true);
		reset.setBackground(new Color(150,2,60));
		reset.setForeground(new Color(255,255,255));
		reset.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		lower.add(reset);
		reset.addActionListener(this);

				exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	

		logout=new JButton("Home");
		add(logout);
		logout.setBounds(820,20,70,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(255,255,255));
		logout.setForeground(new Color(150,2,60));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	logout.addActionListener(this);	


		add(lower);				
		add(upper);		
	
		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Submit"))
		{
			save();
		}
		else if(text.equals("Exit"))
		{
				System.exit(0);
		}
		else if(text.equals("Home"))
		{
			dashboard dash=new dashboard();
		}
		else if(text.equals("Show Details"))
		{
			Details detail=new Details("tbl_booking");
		}
	}
	public void save()
	{
		try{
			Connection conn=null;
			Statement stmt=null;

			
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tbl_booking(book_id,book_date,prod_quntity,prod_id,cust_id,car_id) values('"+tBookid.getText()+"','"+tbookdate.getText()+"','"+tprod_quntity.getText()+"','"+tprodid.getText()+"','"+tcustomerid.getText()+"','"+tcarid.getText()+"')");


		JOptionPane.showMessageDialog(null,"Successfull!!!");
		}
		catch(Exception ex)
		{
			//JOptionPane.showMessageDialog(null,"NILESH:---"+ex);
			System.out.println("NILESH:-"+ex);
		}
	}
	public static void main(String args[])
	{
		new Booking();
	}//main
}//reg class
	
