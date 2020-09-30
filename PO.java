package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import carshowroom.*;


class PO extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField tpurchase_orderid,tcarid,tsupplierid
			,tpurchase_orderQuntity,tproductid;
	JFormattedTextField tpurchase_orderdate;
	JButton save,clear,exit,logout;
	login1 log1;

	PO()
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
		JLabel subheading=new JLabel("Purchase Order");
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

		JLabel lpurchase_orderid=new JLabel("Prchase Order ID :");
		lpurchase_orderid.setBounds(30,90,150,20);
		lower.add(lpurchase_orderid);
		
		tpurchase_orderid=new JTextField();
		lower.add(tpurchase_orderid);
		tpurchase_orderid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tpurchase_orderid.setForeground(new Color(150,2,60));
		tpurchase_orderid.setBounds(30,110,200,30);

		JLabel lpurchase_orderdate=new JLabel("Purchase Order Date :");
		lpurchase_orderdate.setBounds(30,140,150,20);
			lower.add(lpurchase_orderdate);

		tpurchase_orderdate=new JFormattedTextField(new java.util.Date());
		lower.add(tpurchase_orderdate);
		tpurchase_orderdate.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tpurchase_orderdate.setForeground(new Color(150,2,60));
		tpurchase_orderdate.setBounds(30,160,200,30);

		JLabel lpurchase_orderQuntity=new JLabel("Purchase Quntity :");
		lpurchase_orderQuntity.setBounds(30,190,180,20);
		lower.add(lpurchase_orderQuntity);
		
		tpurchase_orderQuntity=new JTextField();
		lower.add(tpurchase_orderQuntity);
		tpurchase_orderQuntity.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tpurchase_orderQuntity.setForeground(new Color(150,2,60));
		tpurchase_orderQuntity.setBounds(30,210,200,30);		


		JLabel lproductid=new JLabel("ProductID :");
		lproductid.setBounds(30,240,180,20);
		lower.add(lproductid);
		
		tproductid=new JTextField();
		lower.add(tproductid);
		tproductid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tproductid.setForeground(new Color(150,2,60));
		tproductid.setBounds(30,270,200,30);

		JLabel lsupplierid=new JLabel("SupplierID :");
		lsupplierid.setBounds(30,300,180,20);
		lower.add(lsupplierid);
		
		tsupplierid=new JTextField();
		lower.add(tsupplierid);
		tsupplierid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupplierid.setForeground(new Color(150,2,60));
		tsupplierid.setBounds(30,320,200,30);		

		JLabel lcarid=new JLabel("CarID :");
		lcarid.setBounds(30,350,180,20);
		lower.add(lcarid);
		
		tcarid=new JTextField();
		lower.add(tcarid);
		tcarid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarid.setForeground(new Color(150,2,60));
		tcarid.setBounds(30,370,200,30);		
		

		save=new JButton("Save");
		lower.add(save);
		save.setBounds(30,410,190,30);
		save.setBorderPainted(true);
		save.setContentAreaFilled(true);
		save.setBackground(new Color(150,2,60));
		save.setForeground(new Color(255,255,255));
		save.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		save.addActionListener(this);

		exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	
		

		clear=new JButton("Clear");
		lower.add(clear);
		clear.setBounds(30,450,190,30);
		clear.setBorderPainted(true);
		clear.setContentAreaFilled(true);
		clear.setBackground(new Color(150,2,60));
		clear.setForeground(new Color(255,255,255));
		clear.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		clear.addActionListener(this);

		JLabel ilogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(ilogo);
		ilogo.setBounds(30,60,500,130);

		logout=new JButton("LogOut");
		add(logout);
		logout.setBounds(800,20,70,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(255,255,255));
		logout.setForeground(new Color(150,2,60));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	logout.addActionListener(this);	


		
		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);

	}//PO()
	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Save"))
		save();
		clear();
		if(text.equals("Clear"))
		clear();
		if(text.equals("LogOut"))
		log1=new login1();
		if(text.equals("Exit"))
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
			stmt.executeUpdate("insert into tbl_PO(PO_id,PO_date,PO_qty,prod_id,sup_id,car_id) values('"+tpurchase_orderid.getText()+"','"+tpurchase_orderdate.getText()+"','"+tpurchase_orderQuntity.getText()+"','"+tproductid.getText()+"','"+tsupplierid.getText()+"','"+tcarid.getText()+"')");
		
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
			tpurchase_orderid.setText("");
			tpurchase_orderdate.setText("");
			tpurchase_orderQuntity.setText("");			
			tproductid.setText("");
			tsupplierid.setText("");			
			tcarid.setText("");
			
	}

	public static void main(String args[])
	{
		new PO();
	}//main
}//reg class
	
