package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import carshowroom.*;

class Supplier extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField tsupplierid,tsuppliername,tsupp_office_addr
			,tsupp_mobno,tsupp_phoneno;
	JButton submit,reset,exit,logout;
	login1 log1;	dashboard dash;
	Supplier()
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
		JLabel subheading=new JLabel("Supplier");
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

		JLabel lsupplierid=new JLabel("SupplierID :");
		lower.add(lsupplierid);
		lsupplierid.setBounds(30,110,100,20);

		tsupplierid=new JTextField();
		lower.add(tsupplierid);
		tsupplierid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupplierid.setForeground(new Color(150,2,60));
		tsupplierid.setBounds(30,130,200,30);

		JLabel lsuppliername=new JLabel("Supplier Name :");
		lower.add(lsuppliername);
		lsuppliername.setBounds(30,160,100,20);

		tsuppliername=new JTextField();
		lower.add(tsuppliername);
		tsuppliername.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsuppliername.setForeground(new Color(150,2,60));
		tsuppliername.setBounds(30,180,200,30);
		
		JLabel lsupp_office_addr=new JLabel("Supplier Office Address :");
		lsupp_office_addr.setBounds(30,210,190,20);
		lower.add(lsupp_office_addr);

		tsupp_office_addr=new JTextField();
		tsupp_office_addr.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupp_office_addr.setForeground(new Color(150,2,60));
		tsupp_office_addr.setBounds(30,230,200,30);
		lower.add(tsupp_office_addr);

		JLabel lsupp_mobno=new JLabel("Supplier Mobile NO. :");
		lsupp_mobno.setBounds(30,260,180,20);
		lower.add(lsupp_mobno);

		tsupp_mobno=new JTextField();
		tsupp_mobno.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupp_mobno.setForeground(new Color(150,2,60));
		tsupp_mobno.setBounds(30,280,200,30);
		lower.add(tsupp_mobno);

		JLabel lsupp_phoneno=new JLabel("Supplier Office No.:");
		lsupp_phoneno.setBounds(30,310,170,20);
		lower.add(lsupp_phoneno);
	
		tsupp_phoneno=new JTextField();
		tsupp_phoneno.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tsupp_phoneno.setForeground(new Color(150,2,60));
		tsupp_phoneno.setBounds(30,330,200,30);
		lower.add(tsupp_phoneno);

		submit=new JButton("Submit");
		submit.setBounds(30,370,200,30);
		submit.setBorderPainted(true);
		submit.setContentAreaFilled(true);
		submit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		submit.setBackground(new Color(150,2,60));
		submit.setForeground(new Color(255,255,255));
		lower.add(submit);
		submit.addActionListener(this);

		
		reset=new JButton("Reset");
		reset.setBounds(30,420,200,30);
		reset.setBorderPainted(true);
		reset.setContentAreaFilled(true);
		reset.setBackground(new Color(150,2,60));
		reset.setForeground(new Color(255,255,255));
		reset.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	
		reset.addActionListener(this);
		lower.add(reset);	

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
	}//Supplier()

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Submit")){
		save();
		clear();
		}
		else if(text.equals("Reset"))
		clear();
		else if(text.equals("Home")){
		dash=new dashboard();
		close();
		}
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
			stmt.executeUpdate("insert into tbl_supplier(sup_id,sup_name,sup_off_addr,sup_mob,sup_off_phone) values('"+tsupplierid.getText()+"','"+tsuppliername.getText()+"','"+tsupp_office_addr.getText()+"','"+tsupp_mobno.getText()+"','"+tsupp_phoneno.getText()+"')");
		
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
			tsupplierid.setText("");
			tsuppliername.setText("");
			tsupp_office_addr.setText("");			
			tsupp_mobno.setText("");
			tsupp_phoneno.setText("");			
						
	}
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	public static void main(String args[])
	{
		new Supplier();
	}//main
}//reg class
	
