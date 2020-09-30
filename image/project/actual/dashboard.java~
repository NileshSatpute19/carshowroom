import java.awt.*;
import javax.swing.*;

class dashboard extends JFrame
{
	JPanel loginreg,details,report,bookcancel,account;
	JButton logb,regb,bookb,cancelb,custdetails,empdetails,cardetails,accdetails,repdetails;
	
	dashboard()	
	{
		loginreg=new JPanel();
		details=new JPanel();
		report=new JPanel();
		bookcancel=new JPanel();
		account=new JPanel();
		logb=new JButton(new ImageIcon("/root/Desktop/project/actual/login.png"));
		regb=new JButton(new ImageIcon("/root/Desktop/project/actual/Register.png"));
		bookb=new JButton(new ImageIcon("/root/Desktop/project/actual/book.png"));
		cancelb=new JButton(new ImageIcon("/root/Desktop/project/actual/cancel.png"));
		custdetails=new JButton(new ImageIcon("/root/Desktop/project/actual/customer.png"));
		empdetails=new JButton(new ImageIcon("/root/Desktop/project/actual/empdetails.png"));
		cardetails=new JButton(new ImageIcon("/root/Desktop/project/actual/cardetails.png"));		
		accdetails=new JButton(new ImageIcon("/root/Desktop/project/actual/acc.png"));
		repdetails=new JButton(new ImageIcon("/root/Desktop/project/actual/report.png"));
		setLayout(null);

		loginreg.setVisible(true);
		loginreg.setBounds(300,30,0,0);
		loginreg.setBackground(Color.WHITE);
		loginreg.setForeground(new Color(150,2,60));	
		loginreg.setSize(200,200);
		loginreg.setLayout(null);
		loginreg.add(logb);loginreg.add(regb);

		logb.setBounds(60,10,75,75);
		logb.setOpaque(false);
		logb.setBorderPainted(false);
		logb.setContentAreaFilled(false);

		regb.setBounds(60,105,75,75);
		regb.setOpaque(false);
		regb.setBorderPainted(false);
		regb.setContentAreaFilled(false);


		
		account.setVisible(true);		
		account.setLayout(null);
		account.setBounds(300,470,0,0);
		account.setBackground(Color.BLUE);	
		account.setSize(200,200);
		account.add(accdetails);

		accdetails.setBounds(20,30,150,150);
		accdetails.setOpaque(false);
		accdetails.setBorderPainted(false);
		accdetails.setContentAreaFilled(false);

		
		
		report.setVisible(true);
		report.setLayout(null);
		report.setBounds(510,470,0,0);
		report.setBackground(Color.GREEN);	
		report.setSize(200,200);
		report.add(repdetails);
		
		repdetails.setBounds(60,60,75,75);
		repdetails.setOpaque(false);
		repdetails.setBorderPainted(false);
		repdetails.setContentAreaFilled(false);


		bookcancel.setVisible(true);
		bookcancel.setBounds(510,30,0,0);
		bookcancel.setBackground(Color.RED);	
		bookcancel.setSize(200,200);
		bookcancel.add(bookb);bookcancel.add(cancelb);	

		bookb.setBounds(60,10,75,75);
		bookb.setOpaque(false);
		bookb.setBorderPainted(false);
		bookb.setContentAreaFilled(false);

		cancelb.setBounds(60,105,75,75);
		cancelb.setOpaque(false);
		cancelb.setBorderPainted(false);
		cancelb.setContentAreaFilled(false);


		details.setVisible(true);
		details.setLayout(null);
		details.setBounds(301,250,0,0);
		details.setBackground(new Color(115,115,115));	
		details.setSize(410,200);
		details.add(custdetails);details.add(empdetails);details.add(cardetails);

		custdetails.setBounds(20,10,120,120);
		custdetails.setOpaque(false);
		custdetails.setBorderPainted(false);
		custdetails.setContentAreaFilled(false);

		empdetails.setBounds(140,10,120,120);
		empdetails.setOpaque(false);
		empdetails.setBorderPainted(false);
		empdetails.setContentAreaFilled(false);

		cardetails.setBounds(260,10,120,120);
		cardetails.setOpaque(false);
		cardetails.setBorderPainted(false);
		cardetails.setContentAreaFilled(false);

		
		
		getContentPane().setBackground(Color.BLACK);
		setSize(1080,720);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(loginreg);add(details);add(report);add(bookcancel);
		add(account);
	}

	public static void main(String[] args)
	{
		new dashboard();
	}
}

 
