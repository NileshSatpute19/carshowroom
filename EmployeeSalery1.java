package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import carshowroom.*;


class EmployeeSalery1 extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField temployee_saleryid,temployeeid,temployee_salerydate,temployee_saleryamt,temploye_incentive;
	JButton save,show,getsal,logout,exit;
	float sal;

	EmployeeSalery1()
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
		JLabel subheading=new JLabel("Employee Salery ");
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

		JLabel lemp_saleryid=new JLabel("Employee SaleryID :");
		lemp_saleryid.setBounds(30,70,150,20);
		lower.add(lemp_saleryid);
		
		temployee_saleryid=new JTextField();
		lower.add(temployee_saleryid);
		temployee_saleryid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		temployee_saleryid.setForeground(new Color(150,2,60));
		temployee_saleryid.setBounds(30,90,200,30);

		JLabel lemployee_salerydate=new JLabel("Employe Salery Date :");
		lemployee_salerydate.setBounds(30,130,150,20);
			lower.add(lemployee_salerydate);

		temployee_salerydate=new JTextField();
		lower.add(temployee_salerydate);
		temployee_salerydate.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		temployee_salerydate.setForeground(new Color(150,2,60));
		temployee_salerydate.setBounds(30,150,200,30);

		JLabel lemployeeid=new JLabel("EmployeID :");
		lemployeeid.setBounds(30,190,180,20);
		lower.add(lemployeeid);
		
		temployeeid=new JTextField();
		lower.add(temployeeid);
		temployeeid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		temployeeid.setForeground(new Color(150,2,60));
		temployeeid.setBounds(30,210,200,30);

		JLabel lemployee_saleryamt=new JLabel("Employe Salery Amount :");
		lemployee_saleryamt.setBounds(30,250,180,20);
		lower.add(lemployee_saleryamt);
		
		temployee_saleryamt=new JTextField();
		lower.add(temployee_saleryamt);
		temployee_saleryamt.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		temployee_saleryamt.setForeground(new Color(150,2,60));
		temployee_saleryamt.setBounds(30,270,200,30);

		JLabel lemploye_incentive=new JLabel("Employe Incentive :");
		lemploye_incentive.setBounds(30,310,180,20);
		lower.add(lemploye_incentive);
	
		temploye_incentive=new JTextField();
		lower.add(temploye_incentive);
		temploye_incentive.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		temploye_incentive.setForeground(new Color(150,2,60));
		temploye_incentive.setBounds(30,330,200,30);

		getsal=new JButton("Get Salary");
		lower.add(getsal);
		getsal.setBounds(30,380,190,30);
		getsal.setBorderPainted(true);
		getsal.setContentAreaFilled(true);
		getsal.setBackground(new Color(150,2,60));
		getsal.setForeground(new Color(255,255,255));
		getsal.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		getsal.addActionListener(this);
		

		save=new JButton("Save");
		lower.add(save);
		save.setBounds(30,420,190,30);
		save.setBorderPainted(true);
		save.setContentAreaFilled(true);
		save.setBackground(new Color(150,2,60));
		save.setForeground(new Color(255,255,255));
		save.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		save.addActionListener(this);

		show=new JButton("Show Details");
		lower.add(show);
		show.setBounds(30,460,190,30);
		show.setBorderPainted(true);
		show.setContentAreaFilled(true);
		show.setBackground(new Color(150,2,60));
		show.setForeground(new Color(255,255,255));
		show.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		show.addActionListener(this);

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
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//UI()


	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();

		if(text.equals("Save"))
		{
			save();
			clear();
			
		}//if

		else if(text.equals("Show Details"))
		{

		}//if
		
		else if(text.equals("Get Salary"))
		{
  			
			fetch();
		}
	}//actionPerformed


	public void fetch()
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int id=Integer.parseInt(temployeeid.getText());
			
		//String q="select emp_salery from tblemployee where emp_id="+temployeeid.getText();
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select emp_salery from tbl_employee where emp_id="+id);
			while(rs.next())
			{
				sal=rs.getFloat("emp_salery");			
			}//while
			
			
			
			temployee_saleryamt.setText(Float.toString(sal));
			con.close();
		}//try
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,id);
			JOptionPane.showMessageDialog(null,"Failed");
		}//catch
	}//fetch

	public void save()
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			stmt=con.createStatement();

			stmt.executeUpdate("insert into tbl_empsalery(empsal_id,empid,emp_sal_amt,emp_sal_date,emp_ince) values('"+temployee_saleryid.getText()+"','"+temployeeid.getText()+"','"+temployee_saleryamt.getText()+"','"+temployee_salerydate.getText()+"','"+temploye_incentive.getText()+"')");

		}//try

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
		}//catch
	}//save


	public void clear()
	{
		temployee_saleryid.setText("");
		temployeeid.setText("");
		temployee_salerydate.setText("");
		temployee_saleryamt.setText("");
		temploye_incentive.setText("");
	}//clear


	public static void main(String args[])
	{
		new EmployeeSalery1();
	}//main
}//reg class
	
