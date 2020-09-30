package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Accountant1 extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JButton report,cal_salery,gen_cust_bill,gen_supp_bill,exit,logout,supplier;
	JLabel llogo;
	SuppBillDetails sbill;	CustBillDetails1 cbill;
	Accountant1()
	{
		setLayout(null);
		setUndecorated(true);
		upper=new JPanel();
		upper.setLayout(null);
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);

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
		JLabel subheading=new JLabel("Accountant");
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
		llogo.setBounds(30,50,500,130);

		
		report=new JButton("Show Report");
		report.setBounds(30,100,200,30);
		report.setBorderPainted(true);
		report.setContentAreaFilled(true);
		report.setBackground(new Color(150,2,60));
		report.setForeground(new Color(255,255,255));
		report.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		lower.add(report);
		report.addActionListener(this);

		cal_salery=new JButton("Calculate Salery");
		cal_salery.setBounds(30,180,200,30);
		cal_salery.setBorderPainted(true);
		cal_salery.setContentAreaFilled(true);
		cal_salery.setBackground(new Color(150,2,60));
		cal_salery.setForeground(new Color(255,255,255));
		cal_salery.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		lower.add(cal_salery);
		cal_salery.addActionListener(this);

		gen_cust_bill=new JButton("Genrate Customer Bill");
		gen_cust_bill.setBounds(30,260,200,30);
		gen_cust_bill.setBorderPainted(true);
		gen_cust_bill.setContentAreaFilled(true);
		gen_cust_bill.setBackground(new Color(150,2,60));
		gen_cust_bill.setForeground(new Color(255,255,255));
		gen_cust_bill.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		lower.add(gen_cust_bill);
		gen_cust_bill.addActionListener(this);
		
		gen_supp_bill=new JButton("Genrate Supplier Bill");
		gen_supp_bill.setBounds(30,340,200,30);
		gen_supp_bill.setBorderPainted(true);
		gen_supp_bill.setContentAreaFilled(true);
		gen_supp_bill.setBackground(new Color(150,2,60));
		gen_supp_bill.setForeground(new Color(255,255,255));
		gen_supp_bill.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		lower.add(gen_supp_bill);
		gen_supp_bill.addActionListener(this);
		
		exit=new JButton("Exit");
		exit.setBounds(940,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(150,2,60));
		exit.setForeground(new Color(255,255,255));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		add(exit);
		exit.addActionListener(this);

		supplier=new JButton("Supplier");
		supplier.setBounds(30,420,200,30);
		supplier.setBorderPainted(true);
		supplier.setContentAreaFilled(true);
		supplier.setBackground(new Color(150,2,60));
		supplier.setForeground(new Color(255,255,255));
		supplier.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		lower.add(supplier);
		supplier.addActionListener(this);


		logout=new JButton("Home");
		logout.setBounds(850,20,70,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(150,2,60));
		logout.setForeground(new Color(255,255,255));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		add(logout);
		logout.addActionListener(this);

		

		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//Accountant()
	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Show Report"))
		{
			String name=JOptionPane.showInputDialog(null,"Enter Table name ");
			Details d1=new Details(name);
			close();
		}
		else if(text.equals("Calculate Salery"))
		{
			totalSalery();
		}
		else if(text.equals("Genrate Customer Bill"))	
		{
			cbill=new CustBillDetails1();
		}
		else if(text.equals("Genrate Supplier Bill"))
		{
			sbill=new SuppBillDetails();
		}
		else if(text.equals("Exit"))
		{
			System.exit(0);
		}
		else if(text.equals("Home"))
		{
			dashboard dash=new dashboard();
			close();
		}
		else if(text.equals("Supplier"))
		{
			Supplier sup=new Supplier();
			close();
		}
		
	}//actionPerformed*/
	
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void totalSalery()
	{
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		float sal,ince,tot;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

			int emp_id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Employee ID so calculate Salery"));
			String emp_date=(JOptionPane.showInputDialog(null,"Enter Current Salery Date :"));
			String q="select emp_sal_amt,emp_ince from tbl_empsalery where empid="+emp_id+" and  emp_sal_date='"+emp_date+"'";
			//String q2="select emp_ince from tblempsal where emp_id="+emp
			stmt=con.createStatement();
			rs=stmt.executeQuery(q);
			while(rs.next())
			{
				sal=rs.getFloat("emp_sal_amt");
				ince=rs.getFloat("emp_ince");
				tot=sal+ince;
				JOptionPane.showMessageDialog(null,"Total Salery : Rs."+tot);	
			}
			
		  }
		catch(Exception ex)
		{
			System.out.println("ERROR"+ex);
		}
	}
	public static void main(String args[])
	{
		new Accountant1();
	}//main
}//reg class
	
