package carshowroom;
import java.awt.*;
import javax.swing.*;
import carshowroom.*;
import java.awt.event.*;

class CustomerBill extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JButton exit,logout;
	JTextField tcustomer_billno;
	CustBillDetails1 cbill;
	CustomerBill()
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

		JLabel lcustomer_billno=new JLabel("Customer Bill No :");
		lcustomer_billno.setBounds(30,100,150,20);
		lower.add(lcustomer_billno);
		
		tcustomer_billno=new JTextField();
		lower.add(tcustomer_billno);
		tcustomer_billno.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcustomer_billno.setForeground(new Color(150,2,60));
		tcustomer_billno.setBounds(30,120,200,30);

		JLabel lcustomer_billdate=new JLabel("Cutomer Bill Date :");
		lcustomer_billdate.setBounds(30,150,150,20);
			lower.add(lcustomer_billdate);

		JFormattedTextField tcustomer_billdate=new JFormattedTextField(new java.util.Date());
		lower.add(tcustomer_billdate);
		tcustomer_billdate.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcustomer_billdate.setForeground(new Color(150,2,60));
		tcustomer_billdate.setBounds(30,170,200,30);

		JLabel lbookid=new JLabel("BookID :");
		lbookid.setBounds(30,200,180,20);
		lower.add(lbookid);
		
		JTextField tbookid=new JTextField();
		lower.add(tbookid);
		tbookid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tbookid.setForeground(new Color(150,2,60));
		tbookid.setBounds(30,230,200,30);

		JLabel lproductquntity=new JLabel("Product Quntity :");
		lproductquntity.setBounds(30,260,180,20);
		lower.add(lproductquntity);
		
		JTextField tproductquntity=new JTextField();
		lower.add(tproductquntity);
		tproductquntity.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tproductquntity.setForeground(new Color(150,2,60));
		tproductquntity.setBounds(30,280,200,30);

		JLabel lproductid=new JLabel("ProductID :");
		lproductid.setBounds(30,310,180,20);
		lower.add(lproductid);
	
		JTextField tproductid=new JTextField();
		lower.add(tproductid);
		tproductid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tproductid.setForeground(new Color(150,2,60));
		tproductid.setBounds(30,330,200,30);

		JLabel lcarid=new JLabel("CarID :");
		lcarid.setBounds(30,360,180,20);
		lower.add(lcarid);
	
		JTextField tcarid=new JTextField();
		lower.add(tcarid);
		tcarid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarid.setForeground(new Color(150,2,60));
		tcarid.setBounds(30,380,200,30);


		JButton login=new JButton("Save");
		lower.add(login);
		login.setBounds(30,430,90,30);
		login.setBorderPainted(true);
		login.setContentAreaFilled(true);
		login.setBackground(new Color(150,2,60));
		login.setForeground(new Color(255,255,255));
		login.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		

		JButton signup=new JButton("Clear");
		lower.add(signup);
		signup.setBounds(140,430,90,30);
		signup.setBorderPainted(true);
		signup.setContentAreaFilled(true);
		signup.setBackground(new Color(150,2,60));
		signup.setForeground(new Color(255,255,255));
		signup.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));

		
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
	}//CustomerBill()

	public void actionPerformed(ActionEvent e){}

	public static void main(String args[])
	{
		new CustomerBill();
	}//main
}//reg class
	
