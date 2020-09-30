import java.awt.*;
import javax.swing.*;

public class login extends JFrame
{
	JPanel panel;
	JLabel uid,upass,heading,mainheading;
	JTextField tid;
	JPasswordField tpass;
	JButton login,exit,signup;
	JSeparator hr;

	login()
	{
		panel=new JPanel();
		uid=new JLabel("Username : ");
		upass=new JLabel("Password : ");
		heading=new JLabel("Login & Registration");
		mainheading=new JLabel("Car Showroom System",JLabel.CENTER);
		hr=new JSeparator();

		tid=new JTextField();
		tpass=new JPasswordField();
		
		login=new JButton("Login");
		signup=new JButton("SignUp");
		exit=new JButton("Exit");
		
		setContentPane(new JLabel(new ImageIcon("/root/Desktop/car/car2.png")));
		setVisible(true);
		setSize(1080,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//getContentPane().setBackground(new Color(253,124,9));
		setLayout(null);
		
		add(panel);add(mainheading);//add(back);
		mainheading.setFont(new Font("URW Chancery L",Font.BOLD,40));
		mainheading.setForeground(new Color(236,0,0));
		mainheading.setBackground(new Color(217,28,28));
		mainheading.setBounds(2,20,1000,50);		
		panel.setBackground(new Color(253,124,9));
		panel.setBounds(115,135,0,0);
		panel.setSize(800,400);
		panel.setBackground(new Color(0,0,0,64));
		panel.add(heading);panel.add(uid);panel.add(hr);
		panel.add(tid);panel.add(upass);panel.add(tpass);
		panel.add(login);panel.add(signup);panel.add(exit);
		panel.setBorder(BorderFactory.createLineBorder(new Color(208,6,78),8));
		panel.setLayout(null);

		heading.setFont(new Font("URW Chancery L",Font.PLAIN,25));
		heading.setForeground(new Color(253,124,9));
		hr.setForeground(Color.RED);
		heading.setBounds(325,10,1000,50);
		hr.setBounds(0,70,10000,1);
		
		uid.setBounds(250,70,100,100);
		tid.setBounds(350,105,228,25);
		upass.setBounds(250,130,100,100);
		tpass.setBounds(350,165,228,25);
		login.setBounds(251,225,100,25);
		signup.setBounds(366,225,100,25);
		exit.setBounds(478,225,100,25);

	}
	

	public static void main(String[] args)
	{
		new login();
	}//main
}//frame class
	
