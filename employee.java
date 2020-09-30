package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class employee extends JFrame implements ActionListener
{
	JButton exit,logout;
	JPanel upper,lower,sublower;
	JRadioButton rmale,rfemale;
	JTextField tempid,tempname,tempmob,tempdob,tempincen,tempdoj,tempsal;
	JTextArea tempadd;
	JComboBox cemptype;
	String cbox,sgender;
	employee()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);

		lower=new JPanel();
		lower.setLayout(null);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(60,110,900,500);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,1000,60);
		JLabel subheading=new JLabel("Employee Details");
		subheading.setFont(new Font("Arial Black",Font.BOLD,20));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(300,10,200,45);
		sublower.add(subheading);
		lower.add(sublower);
	
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,30,500,50);

		JLabel lempid=new JLabel("Employee ID :");
		lower.add(lempid);
		lempid.setBounds(120,80,130,20);

		tempid=new JTextField();
		lower.add(tempid);
		tempid.setBounds(120,100,250,30);
		tempid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempid.setForeground(new Color(150,2,60));

		JLabel lempname=new JLabel("Employee Name :");
		lower.add(lempname);
		lempname.setBounds(120,140,130,20);
		
		tempname=new JTextField();
		lower.add(tempname);
		tempname.setBounds(120,160,250,30);
		tempname.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempname.setForeground(new Color(150,2,60));

		JLabel lempadd=new JLabel("Employee Address : ");
		lower.add(lempadd);
		lempadd.setBounds(120,200,130,20);

		tempadd=new JTextArea();
		lower.add(tempadd);
		tempadd.setBounds(120,220,250,80);
		tempadd.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempadd.setForeground(new Color(150,2,60));
		tempadd.setLineWrap(true);

		JLabel lempmob=new JLabel("Employee Mobile Number :");
		lower.add(lempmob);
		lempmob.setBounds(120,310,180,20);

		tempmob=new JTextField();
		lower.add(tempmob);
		tempmob.setBounds(120,330,250,30);
		tempmob.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempmob.setForeground(new Color(150,2,60));

		JLabel lemptype=new JLabel("Employee Post :");
		lower.add(lemptype);
		lemptype.setBounds(120,370,130,20);

		String type[]={"Manager","Accountant","Sales Executive"};
		cemptype=new JComboBox(type);
		lower.add(cemptype);
		cemptype.setBounds(120,390,250,20);
		cemptype.setBackground(new Color(255,255,255));
		cemptype.setForeground(new Color(150,2,60));
		cemptype.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));

		JSeparator vertical=new JSeparator(SwingConstants.VERTICAL);
		lower.add(vertical);
		vertical.setBounds(450,125,2,300);
		vertical.setForeground(new Color(150,2,60));

		JLabel lempdob=new JLabel("Employee Date of Birth :");
		lower.add(lempdob);
		lempdob.setBounds(510,90,160,20);

		tempdob=new JTextField();
		lower.add(tempdob);
		tempdob.setBounds(510,110,250,30);
		tempdob.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempdob.setForeground(new Color(150,2,60));

		JLabel lempgender=new JLabel("Gender :");
		lower.add(lempgender);
		lempgender.setBounds(510,150,120,20);

		ButtonGroup rgender=new ButtonGroup();
		rmale=new JRadioButton("Male");
		lower.add(rmale);
		rmale.setBounds(510,180,60,20);
		rmale.setContentAreaFilled(false);
		rgender.add(rmale);

		rfemale=new JRadioButton("Female");
		lower.add(rfemale);
		rfemale.setBounds(580,180,70,20);
		rfemale.setContentAreaFilled(false);
		rgender.add(rfemale);
		
		JLabel lempdoj=new JLabel("Date of Joining :");
		lower.add(lempdoj);
		lempdoj.setBounds(510,210,180,20);

		tempdoj=new JTextField();
		lower.add(tempdoj);
		tempdoj.setBounds(510,230,250,30);
		tempdoj.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempdoj.setForeground(new Color(150,2,60));
	
		JLabel lempsal=new JLabel("Employee Salary :");
		lower.add(lempsal);
		lempsal.setBounds(510,270,150,20);

		tempsal=new JTextField();
		lower.add(tempsal);
		tempsal.setBounds(510,290,250,30);
		tempsal.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempsal.setForeground(new Color(150,2,60));

		JLabel lempincen=new JLabel("Employee Incentives :");
		lower.add(lempincen);
		lempincen.setBounds(510,330,180,20);

		tempincen=new JTextField();
		lower.add(tempincen);
		tempincen.setBounds(510,350,250,30);
		tempincen.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tempincen.setForeground(new Color(150,2,60));
	
		JButton add=new JButton("Add");
		lower.add(add);
		add.setBounds(340,430,90,30);
		add.setBorderPainted(true);
		add.setContentAreaFilled(true);
		add.setBackground(new Color(150,2,60));
		add.setForeground(new Color(255,255,255));
		add.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		add.addActionListener(this);

		JButton show=new JButton("Show Details");
		lower.add(show);
		show.setBounds(470,430,90,30);
		show.setBorderPainted(true);
		show.setContentAreaFilled(true);
		show.setBackground(new Color(150,2,60));
		show.setForeground(new Color(255,255,255));
		show.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		show.addActionListener(this);
		
		JButton exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	
		
		logout=new JButton("Home");
		add(logout);
		logout.setBounds(800,20,70,30);
		logout.setBorderPainted(true);
		logout.setContentAreaFilled(true);
		logout.setBackground(new Color(255,255,255));
		logout.setForeground(new Color(150,2,60));
		logout.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	logout.addActionListener(this);	

	
		add(heading);
		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//employee()

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Add")){
		save();
		clear();
		}
		else if(text.equals("Show Details")){
		Details detail=new Details("tbl_employee");
		clear();
		close();
		}
		else if(text.equals("Exit"))
		System.exit(0);
		else if(text.equals("Home"))
		{
			dashboard dash=new dashboard();
			close();
		}
	}
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	public void save()
	{
		Connection conn=null;
		Statement stmt=null;

		if(rmale.isSelected()==true)
			sgender="Male";
		else
			sgender="Female";

		cbox=(String)cemptype.getSelectedItem();
		
		try{

	
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tbl_employee(emp_id,emp_name,emp_addr,emp_mobno,emp_type,emp_gender,emp_doj,emp_dob,emp_salery) values('"+tempid.getText()+"','"+tempname.getText()+"','"+tempadd.getText()+"','"+tempmob.getText()+"','"+cbox+"','"+sgender+"','"+tempdoj.getText()+"','"+tempdob.getText()+"','"+tempsal.getText()+"')");
		
		JOptionPane.showMessageDialog(null,"Successfull!!!");
	
		}//try
		

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error : "+ex);
			//System.out.println("Error : "+ex);
		}//catch
	}

	public void clear()
	{	
			tempid.setText("");
			tempname.setText("");
			tempadd.setText("");			
			tempmob.setText("");
			tempdob.setText("");
			tempdoj.setText("");
			tempincen.setText("");
			tempsal.setText("");
	}
	public static void main(String args[])
	{
		new employee();
	}//main
}//reg class
	
