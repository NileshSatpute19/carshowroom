package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class CarDetails extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JRadioButton rmale,rfemale;
	JTextField tcarid,tcarsubtype,
			tcarprice,tcarcolor,tchassisno,tengineno;
	JTextArea tempadd;
	JComboBox ccarname,ccartype,ccarcolor;
	String action_carname,action_cartype,action_carcolor;
	JButton exit,logout;
	CarDetails()
	{
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);
		upper.setLayout(null);

		lower=new JPanel();
		lower.setLayout(null);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(580,30,250,630);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,1000,60);
		JLabel subheading=new JLabel("Car Details");
		subheading.setFont(new Font("Arial Black",Font.BOLD,20));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(30,10,200,30);
		sublower.add(subheading);
		lower.add(sublower);
	
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,30,500,50);

		JLabel lcarid=new JLabel("CarID :");
		lower.add(lcarid);
		lcarid.setBounds(30,100,100,20);

		tcarid=new JTextField();
		lower.add(tcarid);
		tcarid.setBounds(30,120,200,30);
		tcarid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarid.setForeground(new Color(150,2,60));

		JLabel lcarname=new JLabel("Car Name :");
		lower.add(lcarname);
		lcarname.setBounds(30,160,100,20);
		
		String type[]={"i10","i20","EON","Eliantra"};
		ccarname=new JComboBox(type);
		lower.add(ccarname);
		ccarname.setBounds(30,180,200,30);
		ccarname.setBackground(new Color(255,255,255));
		ccarname.setForeground(new Color(150,2,60));
		ccarname.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));

		JLabel lcartype=new JLabel("Car Type : ");
		lower.add(lcartype);
		lcartype.setBounds(30,220,100,20);

		String cartype[]={"Luxari","Sports","Hashback"};
		ccartype=new JComboBox(cartype);
		lower.add(ccartype);
		ccartype.setBounds(30,240,200,30);
		ccartype.setBackground(new Color(255,255,255));
		ccartype.setForeground(new Color(150,2,60));
		ccartype.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		

		JLabel lcarsubtype=new JLabel("Car SubType :");
		lower.add(lcarsubtype);
		lcarsubtype.setBounds(30,280,100,20);

		tcarsubtype=new JTextField();
		lower.add(tcarsubtype);
		tcarsubtype.setBounds(30,300,200,30);
		tcarsubtype.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarsubtype.setForeground(new Color(150,2,60));

		JLabel lcarprice=new JLabel("Car Price :");
		lower.add(lcarprice);
		lcarprice.setBounds(30,340,100,20);

		tcarprice=new JTextField();
		lower.add(tcarprice);
		tcarprice.setBounds(30,360,200,30);
		tcarprice.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarprice.setForeground(new Color(150,2,60));

		JLabel lcarcolor=new JLabel("Car Color :");
		lower.add(lcarcolor);
		lcarcolor.setBounds(30,400,100,20);

		String colortype[]={"Silver","Red","White"};
		ccarcolor=new JComboBox(colortype);
		lower.add(ccarcolor);
		ccarcolor.setBounds(30,420,200,30);
		ccarcolor.setBackground(new Color(255,255,255));
		ccarcolor.setForeground(new Color(150,2,60));
		ccarcolor.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		

		JLabel lchassisno=new JLabel("Chassis No:");
		lower.add(lchassisno);
		lchassisno.setBounds(30,460,100,20);

		tchassisno=new JTextField();
		lower.add(tchassisno);
		tchassisno.setBounds(30,480,200,30);
		tchassisno.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tchassisno.setForeground(new Color(150,2,60));

		JLabel lengineno=new JLabel("Engine No :");
		lower.add(lengineno);
		lengineno.setBounds(30,520,100,20);

		tengineno=new JTextField();
		lower.add(tengineno);
		tengineno.setBounds(30,540,200,30);
		tengineno.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tengineno.setForeground(new Color(150,2,60));
	
		
		JButton add=new JButton("Add");
		lower.add(add);
		add.setBounds(30,580,95,30);
		add.setBorderPainted(true);
		add.setContentAreaFilled(true);
		add.setBackground(new Color(150,2,60));
		add.setForeground(new Color(255,255,255));
		add.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		add.addActionListener(this);

		JButton show=new JButton("Show Details");
		lower.add(show);
		show.setBounds(135,580,95,30);
		show.setBorderPainted(true);
		show.setContentAreaFilled(true);
		show.setBackground(new Color(150,2,60));
		show.setForeground(new Color(255,255,255));
		show.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		show.addActionListener(this);
		
		exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	
			
		JLabel llogo=new JLabel(new ImageIcon("/root/Documents/MyFiles/Project/Nileshproject/image/log1.png"));
		upper.add(llogo);
		llogo.setBounds(30,60,500,130);

		logout=new JButton("Home");
		add(logout);
		logout.setBounds(836,20,70,30);
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

	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Add")){
		save();
		//clear();
		}
		else if(text.equals("Show Details")){
		Details detail=new Details("tbl_car");
		close();
		//clear();
		}
		else if(text.equals("Exit"))
			System.exit(0);
		else if(text.equals("Home"))
		{
			dashboard dash=new dashboard();
			close();
		}
	}
	public void save()
	{
		Connection conn=null;
		Statement stmt=null;

		action_carname=(String)ccarname.getSelectedItem();
		action_cartype=(String)ccartype.getSelectedItem();
		action_carcolor=(String)ccarcolor.getSelectedItem();
		
		try{

	
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tbl_car(car_id,car_name,car_type,car_subtype,car_price,car_color,chassis_no,engine_no) values('"+tcarid.getText()+"','"+action_carname+"','"+action_cartype+"','"+tcarsubtype.getText()+"','"+tcarprice.getText()+"','"+action_carcolor+"','"+tchassisno.getText()+"','"+tengineno.getText()+"')");
		
	
	
		}//try
		

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error : "+ex);
			//System.out.println("Error : "+ex);
		}//catch
	}

	/*public void clear()
	{	
			tempid.setText("");
			tempname.setText("");
			tempadd.setText("");			
			tempmob.setText("");
			tempdob.setText("");
			tempdoj.setText("");
			tempincen.setText("");
			tempsal.setText("");
	}*/
	public static void main(String args[])
	{
		new CarDetails();
	}//main
}//reg class
	
