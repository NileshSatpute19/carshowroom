package carshowroom;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



class Access_spearpart extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTextField tprodid,tprodname,tprodtype,tprodprice,tcarid;
	JButton save,signup,exit,logout;

	Access_spearpart()
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
		JLabel subheading=new JLabel("Acceseries & Spearpart");
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
		llogo.setBounds(20,40,500,100);


		JLabel lprodid=new JLabel("ProductID :");
		lprodid.setBounds(30,90,150,20);
		lower.add(lprodid);
	
		tprodid=new JTextField();
		lower.add(tprodid);
		tprodid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tprodid.setForeground(new Color(150,2,60));
		tprodid.setBounds(30,110,200,30);

		JLabel lprodname=new JLabel("Product Name :");
		lower.add(lprodname);
		lprodname.setBounds(30,150,100,20);

		tprodname=new JTextField();
		lower.add(tprodname);
		tprodname.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tprodname.setForeground(new Color(150,2,60));
		tprodname.setBounds(30,170,200,30);

		JLabel lprodtype=new JLabel("Product Type :");
		lower.add(lprodtype);
		lprodtype.setBounds(30,210,100,20);

		tprodtype=new JTextField();
		lower.add(tprodtype);
		tprodtype.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tprodtype.setForeground(new Color(150,2,60));
		tprodtype.setBounds(30,230,200,30);

		JLabel lprodprice=new JLabel("Product Price :");
		lower.add(lprodprice);
		lprodprice.setBounds(30,270,100,20);
		
		tprodprice=new JTextField();
		lower.add(tprodprice);
		tprodprice.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tprodprice.setForeground(new Color(150,2,60));
		tprodprice.setBounds(30,290,200,30);

		JLabel lcarid=new JLabel("CarID :");
		lower.add(lcarid);
		lcarid.setBounds(30,330,100,20);

		tcarid=new JTextField();
		lower.add(tcarid);
		tcarid.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		tcarid.setForeground(new Color(150,2,60));
		tcarid.setBounds(30,350,200,30);

		save=new JButton("Save");
		lower.add(save);
		save.setBounds(30,390,90,30);
		save.setBorderPainted(true);
		save.setContentAreaFilled(true);
		save.setBackground(new Color(150,2,60));
		save.setForeground(new Color(255,255,255));
		save.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		save.addActionListener(this);

		signup=new JButton("Show Details");
		lower.add(signup);
		signup.setBounds(140,390,90,30);
		signup.setBorderPainted(true);
		signup.setContentAreaFilled(true);
		signup.setBackground(new Color(150,2,60));
		signup.setForeground(new Color(255,255,255));
		signup.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		signup.addActionListener(this);
		
		exit=new JButton("Exit");
		add(exit);
		exit.setBounds(910,20,70,30);
		exit.setBorderPainted(true);
		exit.setContentAreaFilled(true);
		exit.setBackground(new Color(255,255,255));
		exit.setForeground(new Color(150,2,60));
		exit.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));	exit.addActionListener(this);	
		

		logout=new JButton("Home");
		add(logout);
		logout.setBounds(820,20,70,30);
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
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//accesssories
	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		if(text.equals("Save"))
		{
			save();
		}
		else if(text.equals("Show Details"))
		{
			clear();
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
		try{
			Connection conn=null;
			Statement stmt=null;

			
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into tbl_accessories(prod_id,prod_name,prod_type,prod_price,car_id) values('"+tprodid.getText()+"','"+tprodname.getText()+"','"+tprodtype.getText()+"','"+tprodprice.getText()+"','"+tcarid.getText()+"')");


//			stmt.executeUpdate("Alter table tbl_accessories add expiry varchar(20)");
//			stmt.executeUpdate("Alter table tbl_accessories modify expiry varchar(20)");
			JOptionPane.showMessageDialog(null,"Successfull!!!");
		}
		catch(Exception ex)
		{
			//JOptionPane.showMessageDialog(null,"NILESH:---"+ex);
			System.out.println("NILESH:-"+ex);
		}
	}
	public void clear()
	{	
			tprodid.setText("");
			tprodname.setText("");
			tprodtype.setText("");			
			tcarid.setText("");
			
	}
	public static void main(String args[])
	{
		new Access_spearpart();
	}//main
}//reg class
	
