package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import carshowroom.*;
class dashboard extends JFrame implements ActionListener 
{
	JPanel upper;
	JPanel login,registration,book,cancel,custdetails,empdetails,cardetails,accdetails,report,exit;
	JButton logb,regb,bookb,cancelb,custdetailsb,empdetailsb,cardetailsb,accdetailsb,reportb,exitb;

	JLabel luid,luid_value;

	login1 log1;	Details details;
	registration reg1;	CarDetails dcar;	Accountant1 acc;	
	Booking book1;	customer cust1;	employee emp1;
	String tablename;
	int carid;

	
	dashboard()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);

		
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,50,500,50);

		login=new JPanel();
		login.setVisible(true);
		login.setBounds(54,180,0,0);
		login.setBackground(new Color(255,255,255));
		login.setSize(150,150);
		login.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		login.setLayout(null);
		logb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/login1.png"));
		login.add(logb);
		logb.setBounds(0,0,150,150);
		logb.setContentAreaFilled(false);
		logb.setBorderPainted(false);
		logb.setForeground(new Color(150,2,60));
		logb.setToolTipText("Login Into System");
		logb.addActionListener(this);

		registration=new JPanel();
		registration.setVisible(true);
		registration.setBounds(247,180,0,0);
		registration.setBackground(new Color(255,255,255));
		registration.setSize(150,150);
		registration.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		registration.setLayout(null);
		regb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/registration.png"));
		registration.add(regb);
		regb.setBounds(0,0,150,150);
		regb.setContentAreaFilled(false);
		regb.setBorderPainted(false);
		regb.setForeground(new Color(150,2,60));
		regb.setToolTipText("Registration for Employee of Car ShowRoom");
		regb.addActionListener(this);
		

		book=new JPanel();
		book.setVisible(true);
		book.setBounds(437,180,0,0);
		book.setBackground(new Color(255,255,255));
		book.setSize(150,150);
		book.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		book.setLayout(null);
		bookb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/booking1.png"));
		book.add(bookb);
		bookb.setBounds(0,0,150,150);
		bookb.setContentAreaFilled(false);
		bookb.setBorderPainted(false);
		bookb.setForeground(new Color(150,2,60));
		bookb.setToolTipText("Booking of Car");
		bookb.addActionListener(this);

		cancel=new JPanel();
		cancel.setVisible(true);
		cancel.setBounds(627,180,0,0);
		cancel.setBackground(new Color(255,255,255));
		cancel.setSize(150,150);
		cancel.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		cancel.setLayout(null);
		cancelb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/cancel.png"));
		cancel.add(cancelb);
		cancelb.setBounds(0,0,150,150);
		cancelb.setContentAreaFilled(false);
		cancelb.setBorderPainted(false);
		cancelb.setForeground(new Color(150,2,60));
		cancelb.setToolTipText("Cancleation OF Booking");
		cancelb.addActionListener(this);

		custdetails=new JPanel();
		custdetails.setVisible(true);
		custdetails.setBounds(817,180,0,0);
		custdetails.setBackground(new Color(255,255,255));
		custdetails.setSize(150,150);
		custdetails.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		custdetails.setLayout(null);
		custdetailsb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/customer.png"));
		custdetails.add(custdetailsb);
		custdetailsb.setBounds(0,0,150,150);
		custdetailsb.setContentAreaFilled(false);
		custdetailsb.setBorderPainted(false);
		custdetailsb.setForeground(new Color(150,2,60));
		custdetailsb.setToolTipText("Customer Details");
		custdetailsb.addActionListener(this);

		empdetails=new JPanel();
		empdetails.setVisible(true);
		empdetails.setBounds(54,400,0,0);
		empdetails.setBackground(new Color(255,255,255));
		empdetails.setSize(150,150);
		empdetails.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		empdetails.setLayout(null);
		empdetailsb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/employee1.png"));
		empdetails.add(empdetailsb);
		empdetailsb.setBounds(0,0,150,150);
		empdetailsb.setContentAreaFilled(false);
		empdetailsb.setBorderPainted(false);
		empdetailsb.setForeground(new Color(150,2,60));
		empdetailsb.setToolTipText("Employee Details");
		empdetailsb.addActionListener(this);

		cardetails=new JPanel();
		cardetails.setVisible(true);
		cardetails.setBounds(247,400,0,0);
		cardetails.setBackground(new Color(255,255,255));
		cardetails.setSize(150,150);
		cardetails.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		cardetails.setLayout(null);
		cardetailsb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/car1.png"));
		cardetails.add(cardetailsb);
		cardetailsb.setBounds(0,0,150,150);
		cardetailsb.setContentAreaFilled(false);
		cardetailsb.setBorderPainted(false);
		cardetailsb.setForeground(new Color(150,2,60));
		cardetailsb.setToolTipText("Details Of Car ");
		cardetailsb.addActionListener(this);

		accdetails=new JPanel();
		accdetails.setVisible(true);
		accdetails.setBounds(437,400,0,0);
		accdetails.setBackground(new Color(255,255,255));
		accdetails.setSize(150,150);
		accdetails.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		accdetails.setLayout(null);
		accdetailsb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/accountant1.png"));
		accdetails.add(accdetailsb);
		accdetailsb.setBounds(0,0,150,150);
		accdetailsb.setContentAreaFilled(false);
		accdetailsb.setBorderPainted(false);
		accdetailsb.setForeground(new Color(150,2,60));
		accdetailsb.setToolTipText("Accountant Details");
		accdetailsb.addActionListener(this);

		report=new JPanel();
		report.setVisible(true);
		report.setBounds(627,400,0,0);
		report.setBackground(new Color(255,255,255));
		report.setSize(150,150);
		report.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		report.setLayout(null);
		reportb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/report.png"));
		report.add(reportb);
		reportb.setBounds(0,0,150,150);
		reportb.setContentAreaFilled(false);
		reportb.setBorderPainted(false);
		reportb.setForeground(new Color(150,2,60));
		reportb.setToolTipText("Showing Report ");
		reportb.addActionListener(this);

		exit=new JPanel();
		exit.setVisible(true);
		exit.setBounds(817,400,0,0);
		exit.setBackground(new Color(255,255,255));
		exit.setSize(150,150);
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60)));
		exit.setLayout(null);
		exitb=new JButton(new ImageIcon("C:/Users/sameer satpute/package/image/exit.png"));
		exit.add(exitb);
		exitb.setBounds(0,0,150,150);
		exitb.setContentAreaFilled(false);
		exitb.setBorderPainted(false);
		exitb.setForeground(new Color(150,2,60));
		exitb.setToolTipText("EXIT FROM SYSTEM");
		exitb.addActionListener(this);

		
		/*JButton logout=new JButton("LogOut");
		add(logout);
		logout.setBounds(820,10,50,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(255,255,255));
		logout.setForeground(new Color(150,2,60));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		logout.addActionListener(this);*/

		add(heading);
		add(login);
		add(registration);
		add(book);
		add(cancel);
		add(custdetails);
		add(empdetails);
		add(cardetails);
		add(accdetails);
		add(report);
		add(exit);
		add(upper);
	
		
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//dashboard()

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==logb){
		log1=new login1();
		close();
		}
		if(e.getSource()==bookb){
		book1=new Booking();
		close();
		}
		if(e.getSource()==regb){
		reg1=new registration();
		close();
		}
		if(e.getSource()==cancelb){
		deleteRow();
		}
		if(e.getSource()==custdetailsb){
		cust1=new customer();
		close();
		}
		if(e.getSource()==empdetailsb){
		emp1=new employee();
		close();
		}
		if(e.getSource()==cardetailsb){
		dcar=new CarDetails();
		close();}
		if(e.getSource()==accdetailsb){
		acc=new Accountant1();
		close();
		}
		if(e.getSource()==reportb)
		{
	     tablename=JOptionPane.showInputDialog(null,"Enter Table Name ");
		details=new Details(tablename);
		close();
		}
		if(e.getSource()==exitb)
		System.exit(0);

		//if(e.getSource()==logout)
		//log1=new login1();
	}
	public void deleteRow()
	{
		Connection con=null;
		Statement stmt=null,stmt2=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		String bookno=JOptionPane.showInputDialog(null,"Enter Booking ID to cancle ");
		String q="delete from tbl_booking where book_id='"+bookno+"'";
		String qd="delete from tbl_customerbill where book_id='"+bookno+"'";
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

		
		stmt2=con.createStatement();
		stmt2.executeUpdate(qd);

		stmt=con.createStatement();
		stmt.executeUpdate(q);
		
		JOptionPane.showMessageDialog(null,"Successfully Cancle");
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			//JOptionPane.showMessageDialog(null,e);
		}
	}
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public static void main(String args[])
	{
		new dashboard();
	}//main
}//reg class
	
