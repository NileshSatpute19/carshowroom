package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import carshowroom.*;

class SuppBillDetails extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JButton logout,exit;

	SuppBillDetails()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setLayout(null);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);
		JLabel llogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(llogo);
		llogo.setBounds(30,50,400,100);

		lower=new JPanel();
		lower.setLayout(null);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(480,150,510,500);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,510,60);
		JLabel subheading=new JLabel("Generated Supplier Bill");
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
	
		logout=new JButton("Home");
		add(logout);
		logout.setBounds(800,20,70,30);
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

		String billno=JOptionPane.showInputDialog(null,"Enter Supplier bill ID");
		generate(billno);
		
		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//SuppBillDetails1()

	public void actionPerformed(ActionEvent e){
			String text=(String)e.getActionCommand();
			if(text.equals("Home"))
			{
				dashboard dash=new dashboard();
			}
			else if(text.equals("Exit"))
			{
				System.exit(0);
			}
		}
	public void generate(String billno)
	{

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String supp_billno,supp_billdate,supp_totamt,poid,supp_id;

		try
		{

			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from tbl_supbill where supbill_no='"+billno+"'");

			while(rs.next())
			{
				supp_billno=Integer.toString(rs.getInt(1));
				supp_billdate=rs.getString(2);
				supp_totamt=Float.toString(rs.getFloat(3));
				poid=Integer.toString(rs.getInt(4));
				supp_id=Integer.toString(rs.getInt(5));

				JLabel dsupplier_billno=new JLabel(supp_billno);
				dsupplier_billno.setBounds(185,100,150,20);
				lower.add(dsupplier_billno);	
				
				JLabel dsupplier_billdate=new JLabel(supp_billdate);
				dsupplier_billdate.setBounds(185,150,150,20);
				lower.add(dsupplier_billdate);
			
				JLabel dsuppbill_totamt=new JLabel(supp_totamt);
				dsuppbill_totamt.setBounds(205,200,150,20);
				lower.add(dsuppbill_totamt);
			
				JLabel dpurchaseorderid=new JLabel(poid);
				dpurchaseorderid.setBounds(185,250,150,20);
				lower.add(dpurchaseorderid);
		
				JLabel dsupplierid=new JLabel(supp_id);
				dsupplierid.setBounds(185,300,150,20);
				lower.add(dsupplierid);
	
			}	
			JLabel lsupplier_billno=new JLabel("Supplier Bill No :");
			lsupplier_billno.setBounds(30,100,150,20);
			lower.add(lsupplier_billno);

			JLabel lsupplier_billdate=new JLabel("Supplier Bill Date :");
			lsupplier_billdate.setBounds(30,150,150,20);
			lower.add(lsupplier_billdate);

		JLabel lsuppbill_totamt=new JLabel("Supplier Bill Total Amount :");
		lsuppbill_totamt.setBounds(30,200,180,20);
		lower.add(lsuppbill_totamt);

			JLabel lpurchaseorderid=new JLabel("Purchase Order ID :");
			lpurchaseorderid.setBounds(30,250,180,20);
			lower.add(lpurchaseorderid);

			JLabel lsupplierid=new JLabel("SupplierID :");
			lsupplierid.setBounds(30,300,180,20);
			lower.add(lsupplierid);

			JLabel signature=new JLabel("Signature");
			signature.setBounds(430,450,180,20);
			lower.add(signature);

		}//try
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
		}//catch
	
	}//generate()

	public static void main(String args[])
	{
		new SuppBillDetails();
	}//main
}//SuppBillDetails class
	

