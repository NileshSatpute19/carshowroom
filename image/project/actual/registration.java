import java.awt.*;
import javax.swing.*;

class registration extends JFrame
{	
	JPanel p;
	JLabel lfirst,llast,lpost,lgender,lmale,lfemale,lother,laddress,lstate,ldob,lmob,lpass,lcpass;
	JTextField tfirst,tlast,tmob;
	JFormattedTextField tdob;
	JPasswordField tpass,tcpass;
	JRadioButton rmale,rfemale,rother;
	JTextArea taddress;
	JScrollPane sc;
	JComboBox cpost,cstate;
	String Post[]={"Manager","Accountant","SalesPerson"};
	String State[]={"Maharastra","Goa","Madhya Pradesh","Uttar Pradesh","Gujrat","Panjab"};
	JButton bsubmit,breset;
	registration()
	{
		setLayout(null);		
		
		p=new JPanel();
		p.setLayout(null);
		lfirst=new JLabel("First Name :");
		llast=new JLabel("Last Name :");
		lpost=new JLabel("Post :");
		lgender=new JLabel("Gender :");
		lmale=new JLabel("Male :");
		lfemale=new JLabel("Female :");
		lother=new JLabel("Other :");
		laddress=new JLabel("Address :");
		lstate=new JLabel("State :");
		ldob=new JLabel("Date of Birth :");
		lmob=new JLabel("Mobile Number");
		lpass=new JLabel("Choose Password :");
		lcpass=new JLabel("Confirm Password :");

		tfirst=new JTextField();
		tlast=new JTextField();
		tmob=new JTextField();
		tdob=new JFormattedTextField(new java.util.Date());
		tpass=new JPasswordField();
		tcpass=new JPasswordField();

		rmale=new JRadioButton();
		rfemale=new JRadioButton();
		rother=new JRadioButton();

		sc=new JScrollPane(taddress);

		taddress=new JTextArea();

		
		cpost=new JComboBox(Post);
		cstate=new JComboBox(State);

		bsubmit=new JButton("Submit");
		breset=new JButton("Reset");


		p.setSize(1000,600);
		p.setVisible(true);
		p.setBackground(Color.RED);

		add(p);

		p.add(lfirst);
		lfirst.setBounds(20,100,100,10);
		p.add(tfirst);
		tfirst.setBounds(120,95,150,20);

		p.add(llast);
		llast.setBounds(330,95,100,20);
		p.add(tlast);		
		tlast.setBounds(430,95,150,20);
		
		p.add(lgender);
		lgender.setBounds(20,145,100,20);
		
		p.add(lmale);
		lmale.setBounds(20,180,100,20);
		p.add(rmale);
		rmale.setBounds(70,180,20,20);
	
		p.add(lfemale);
		lfemale.setBounds(110,180,100,20);
		p.add(rfemale);
		rfemale.setBounds(180,180,20,20);
		
		p.add(lother);
		lother.setBounds(220,180,100,20);
		p.add(rother);
		rother.setBounds(280,180,20,20);

		p.add(laddress);
		laddress.setBounds(20,230,100,20);
		p.add(taddress);
		taddress.setBounds(120,230,150,50);
		p.add(sc);
		taddress.setLineWrap(true);
		sc.validate();

		p.add(lstate);
		lstate.setBounds(330,255,100,20);
		p.add(cstate);
		cstate.setBounds(430,250,110,20);

		p.add(lpost);
		lpost.setBounds(20,300,100,20);
		p.add(cpost);
		cpost.setBounds(120,300,110,20);

		p.add(ldob);
		ldob.setBounds(20,350,100,20);
		p.add(tdob);
		tdob.setBounds(120,350,100,20);

		p.add(lmob);
		lmob.setBounds(20,400,100,20);
		p.add(tmob);
		tmob.setBounds(120,400,100,20);

		p.add(lpass);
		lpass.setBounds(20,450,100,20);
		p.add(tpass);
		tpass.setBounds(120,450,100,20);
		p.add(lcpass);
		lcpass.setBounds(330,450,100,20);
		p.add(tcpass);
		tcpass.setBounds(430,450,100,20);
		
		p.add(bsubmit);
		bsubmit.setBounds(40,500,100,20);
		p.add(breset);
		breset.setBounds(150,500,100,20);
		
		

		p.setBounds(10,90,1000,600);

		setSize(1080,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new registration();
	}//main
}//class registration	
	
