package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import carshowroom.*;

class SupplierBill extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField tsupplier_billno,tsuppbill_totamt,tpurchaseorderid,tsupplierid;
	JFormattedTextField tsupplier_billdate;
	JButton save,clear,logout,exit;
	login1 log1;	dashboard dash;

	SupplierBill()
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
		JLabel subheading=new JLabel("Supplier Bill");
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

		JLabel lsupplier_billno=new JLabel("Supplier Bill No :");
		lsupplier_billno.setBounds(30,100,150,20);
		lower.add(lsupplier_billno);
		
		tsupplier_billno=new JTextField();
		lower.add(tsupplier_billno);
		tsupplier_billno.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupplier_billno.setForeground(new Color(150,2,60));
		tsupplier_billno.setBounds(30,130,200,30);

		JLabel lsupplier_billdate=new JLabel("Supplier Bill Date :");
		lsupplier_billdate.setBounds(30,160,150,20);
			lower.add(lsupplier_billdate);

		tsupplier_billdate=new JFormattedTextField(new java.util.Date());
		lower.add(tsupplier_billdate);
		tsupplier_billdate.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupplier_billdate.setForeground(new Color(150,2,60));
		tsupplier_billdate.setBounds(30,190,200,30);

		JLabel lsuppbill_totamt=new JLabel("Supplier Bill Total Amount :");
		lsuppbill_totamt.setBounds(30,220,180,20);
		lower.add(lsuppbill_totamt);
		
		tsuppbill_totamt=new JTextField();
		lower.add(tsuppbill_totamt);
		tsuppbill_totamt.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsuppbill_totamt.setForeground(new Color(150,2,60));
		tsuppbill_totamt.setBounds(30,250,200,30);

		JLabel lpurchaseorderid=new JLabel("Purchase Order ID :");
		lpurchaseorderid.setBounds(30,280,180,20);
		lower.add(lpurchaseorderid);
		
		tpurchaseorderid=new JTextField();
		lower.add(tpurchaseorderid);
		tpurchaseorderid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tpurchaseorderid.setForeground(new Color(150,2,60));
		tpurchaseorderid.setBounds(30,310,200,30);

		JLabel lsupplierid=new JLabel("SupplierID :");
		lsupplierid.setBounds(30,350,180,20);
		lower.add(lsupplierid);
	
		tsupplierid=new JTextField();
		lower.add(tsupplierid);
		tsupplierid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupplierid.setForeground(new Color(150,2,60));
		tsupplierid.setBounds(30,380,200,30);


		save=new JButton("Save");
		lower.add(save);
		save.setBounds(30,430,90,30);
		save.setBorderPainted(true);
		save.setContentAreaFilled(true);
		save.setBackground(new Color(150,2,60));
		save.setForeground(new Color(255,255,255));
		save.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		save.addActionListener(this);

		clear=new JButton("Show Detail");
		lower.add(clear);
		clear.setBounds(140,430,90,30);
		clear.setBorderPainted(true);
		clear.setContentAreaFilled(true);
		clear.setBackground(new Color(150,2,60));
		clear.setForeground(new Color(255,255,255));
		clear.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		clear.addActionListener(this);
		
		logout=new JButton("LogOut");
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


		JLabel ilogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(ilogo);
		ilogo.setBounds(30,60,500,130);	


		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//SuppBill()

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Save")){
		save();
		clear();
		}
		else if(text.equals("Show Detail")){
		Details detail=new Details("tbl_supbill");
		clear();
		}
		else if(text.equals("Home"))
		dash=new dashboard();
		else if(text.equals("Exit"))
		System.exit(0);
	}
	public void save()
	{
		Connection conn=null;
		Statement stmt=null;

		try{

		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tbl_supbill(supbill_no,sup_date,sup_totamt,po_id,sup_id) values('"+tsupplier_billno.getText()+"','"+tsupplier_billdate.getText()+"','"+tsuppbill_totamt.getText()+"','"+tpurchaseorderid.getText()+"','"+tsupplierid.getText()+"')");
		
		JOptionPane.showMessageDialog(null,"Successfull!!!");
	
		}//trytemployee_saleryid,
			 //temployeeid,temployee_saleryamt,temploye_incentive;
		

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error : "+ex);
			//System.out.println("Error : "+ex);
		}//catch
	}

	public void clear()
	{	
			tsupplier_billno.setText("");
			tsupplier_billdate.setText("");
			tsuppbill_totamt.setText("");			
			tpurchaseorderid.setText("");
			tsupplierid.setText("");			
			
			
	}

	public static void main(String args[])
	{
		new SupplierBill();
	}//main
}//reg class
	
