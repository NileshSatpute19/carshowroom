package carshowroom;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import carshowroom.*;
import java.awt.*;
import javax.swing.*;

class splash extends JFrame
{
	JProgressBar bar;
	JLabel per;
	JPanel pan;
	splash()
	{
		getContentPane().setBackground(new Color(150,2,60));
		setSize(700,500);
		setLocationRelativeTo(null);
		setUndecorated(true);

		setLayout(null);		

		/*JLabel logo=new JLabel(new ImageIcon("G:/package/image/unique.png"));
		logo.setBounds(100,10,500,300);
		add(logo);*/
		
		JLabel sample=new JLabel(new ImageIcon("G:/package/image/unique.png"));
		sample.setBounds(100,10,500,300);
		add(sample);
		
		per=new JLabel("100%");
		per.setBounds(300,410,100,30);
		per.setForeground(Color.WHITE);
		add(per);

		bar=new JProgressBar();
		bar.setBounds(10,460,680,20);
		//bar.setContentAreaFilled(false);
		bar.setBorderPainted(false);
		bar.setForeground(Color.BLACK);
		add(bar);
		setVisible(true);

		try
		{
			for(int i=0;i<=100;i++)
			{
				Thread.sleep(25);
				per.setText("Loading... "+i+"%");
				bar.setValue(i);
			}//for
					close();
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}//try
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}//catch
		
		

	}//splash

	public void close()
	{
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	public static void main(String args[])
	{
		new splash();	
		
	}//main	

}//class
