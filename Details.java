package carshowroom;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.awt.event.*;


class Details extends JFrame implements ActionListener
{
	JPanel upper,lower,sublower;
	JTable table;

	String tablename=null;
	JButton update,delete,exit,logout;
	
	Details(String name)
	{
		tablename=name;
		setLayout(null);
		upper=new JPanel();
		upper.setSize(1080,450);
		upper.setBackground(new Color(150,2,60));
		upper.setBounds(0,270,1080,450);

		lower=new JPanel();
		lower.setLayout(null);
		lower.setSize(250,600);
		lower.setBackground(new Color(255,255,255));
		lower.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));
		lower.setBounds(60,110,900,500);
		
		sublower=new JPanel();
		sublower.setLayout(null);
		sublower.setBackground(new Color(150,2,60));
		sublower.setBounds(0,0,900,60);
	

		JLabel subheading=new JLabel("Login into System");
		subheading.setFont(new Font("Arial Black",Font.BOLD,20));
		subheading.setForeground(new Color(255,255,255));
		subheading.setBounds(30,10,200,30);
		sublower.add(subheading);

		update=new JButton("Update");
		sublower.add(update);
		update.setBounds(670,10,100,30);
		update.setBorderPainted(true);
		update.setContentAreaFilled(true);
		update.setBackground(new Color(255,255,255));
		update.setForeground(new Color(150,2,60));
		update.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));		
		update.addActionListener(this);

		delete=new JButton("Delete");
		sublower.add(delete);
		delete.setBounds(780,10,100,30);
		delete.setBorderPainted(true);
		delete.setContentAreaFilled(true);
		delete.setBackground(new Color(255,255,255));
		delete.setForeground(new Color(150,2,60));
		delete.setBorder(BorderFactory.createLineBorder(new Color(150,2,60),1));		
		delete.addActionListener(this);


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

		lower.add(sublower);
	
		JLabel heading=new JLabel("Car Showroom Management System");
		heading.setForeground(new Color(150,2,60));
		heading.setFont(new Font("Arial Black",Font.BOLD,25));
		heading.setBounds(55,30,500,50);
		add(heading);

		table=new JTable();	
		table.setDefaultEditor(Object.class,null);

		JScrollPane pane=new JScrollPane(table);
		lower.add(pane);
		setUndecorated(true);
		pane.setBounds(0,60,900,440);

		display(tablename);		

		add(lower);
		add(upper);
	
		getContentPane().setBackground(new Color(255,255,255));

		setSize(1080,720);
		setUndecorated(true);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);

	}//UI()


	public void actionPerformed(ActionEvent e)
	{
		String text=(String)e.getActionCommand();
		try
		{
			if(text.equals("Update"))
			{
				updateRow();
			}//if
		
			else if(text.equals("Delete"))
			{
				//deleteRow();
			}//if
			else if(text.equals("Exit"))
			{
				System.exit(0);
			}//if
			else if(text.equals("Home"))
			{	
				dashboard dash=new dashboard();
				close();
			}
		}//try
		catch(IOException io){}

	
	}//actionPerformed

	public void display(String tablename)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		String q="select * from "+tablename;
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");

			ps=con.prepareStatement(q);
			rs=ps.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();	
		}//try

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
		}//catch
		
		

	}//display

	

	public void updateRow() throws IOException
	{
			String q=null;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Connection con=null;
			PreparedStatement ps2=null;

			try
			{
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1/carshowroom","postgres","");
			}
			catch(Exception sql){System.out.println(sql);}
				
												
			if(tablename.equals("tbl_car"))
			{
				
				int cid=Integer.parseInt(JOptionPane.showInputDialog("Enter CarID : "));
				String cname=JOptionPane.showInputDialog("Enter New Car Name : ");
				String ctype=JOptionPane.showInputDialog("Enter Car Type : ");
				String csubtype=JOptionPane.showInputDialog("Enter Car Sub Type : ");
				float cprice=Float.parseFloat(JOptionPane.showInputDialog("Enter Car Price : "));
				String ccolor=JOptionPane.showInputDialog("Enter Car Colour : ");
				long cchasisno=Long.parseLong(JOptionPane.showInputDialog("Enter Chasis Number : "));
				long cengineno=Long.parseLong(JOptionPane.showInputDialog("Enter Engine Number : "));

				q="update tbl_car set car_name=?,car_type=?,car_subtype=?,car_price=?,car_color=?,chassis_no=?,engine_no=? where car_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(8,cid);
					ps2.setString(1,cname);
					ps2.setString(2,ctype);
					ps2.setString(3,csubtype);
					ps2.setFloat(4,cprice);
					ps2.setString(5,ccolor);
					ps2.setLong(6,cchasisno);
					ps2.setLong(7,cengineno);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");	
					display("tbl_car");		
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//if
			else if(tablename.equals("tbl_accessories"))
			{
				int pid=Integer.parseInt(JOptionPane.showInputDialog("Enter ProductID : "));
				String pname=JOptionPane.showInputDialog("Enter New Product Name : ");
				String ptype=JOptionPane.showInputDialog("Enter Product Type : ");
				float pprice=Float.parseFloat(JOptionPane.showInputDialog("Enter Product Price : "));

				q="update tbl_accessories set prod_name=?,prod_type=?,prod_price=? where prod_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(4,pid);
					ps2.setString(1,pname);
					ps2.setString(2,ptype);
					ps2.setFloat(3,pprice);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");			
					display("tbl_accessories");
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
			}//else if
			else if(tablename.equals("tbl_customer"))
			{
				int custid=Integer.parseInt(JOptionPane.showInputDialog("Enter Customer ID : "));
				String custname=JOptionPane.showInputDialog("Enter New Customer Name : ");
				String custaddr=JOptionPane.showInputDialog("Enter Customer Address : ");
				long custmob=Long.parseLong(JOptionPane.showInputDialog("Enter Customer Mobile No. : "));
				String custgender=JOptionPane.showInputDialog("Enter Customer Gender : ");
				String custdob=JOptionPane.showInputDialog("Enter Customer DOB: ");
				
				q="update tbl_customer set cust_name=?,cust_addr=?,cust_mobno=?,cust_gender=?,cust_dob=? where cust_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(6,custid);
					ps2.setString(1,custname);
					ps2.setString(2,custaddr);
					ps2.setLong(3,custmob);
					ps2.setString(4,custgender);
					ps2.setString(5,custdob);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");			
					display("tbl_customer");
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_employee"))
			{
				int empid=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID : "));
				String empname=JOptionPane.showInputDialog("Enter New Employee Name : ");
				String empaddr=JOptionPane.showInputDialog("Enter Employee Address :");
				long empmob=Long.parseLong(JOptionPane.showInputDialog("Enter Employee Mobile No. : "));
				String emptype=JOptionPane.showInputDialog("Enter Employee Type : ");
				String empgender=JOptionPane.showInputDialog("Enter Employee Gender : ");
				String empdoj=JOptionPane.showInputDialog("Enter Employee's Date of Joining : ");
				String empdob=JOptionPane.showInputDialog("Enter Employee's Date of Birth : ");
				float empsal=Float.parseFloat(JOptionPane.showInputDialog("Enter Employee Salary :"));

				q="update tbl_employee set emp_name=?,emp_addr=?,emp_mobno=?,emp_type=?,emp_gender=?,emp_doj=?,emp_dob=?,emp_salery=? where emp_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(9,empid);
					ps2.setString(1,empname);
					ps2.setString(2,empaddr);
					ps2.setLong(3,empmob);
					ps2.setString(4,emptype);
					ps2.setString(5,empgender);
					ps2.setString(6,empdoj);
					ps2.setString(7,empdob);
					ps2.setFloat(8,empsal);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");			
					display("tbl_employee");
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_booking"))
			{
				int bookid=Integer.parseInt(JOptionPane.showInputDialog("Enter Booking ID : "));
				String bookdate=JOptionPane.showInputDialog("Enter Booking Date : ");
				int prodquantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Product Quantity : "));
				int prodid=Integer.parseInt(JOptionPane.showInputDialog("Enter Produict ID : "));
				int custid=Integer.parseInt(JOptionPane.showInputDialog("Enter Customer ID : "));
				int carid=Integer.parseInt(JOptionPane.showInputDialog("Enter Car ID: "));
				
				q="update tbl_booking set book_date=?,prod_quantity=?,prod_id=?,cust_id=?,car_id=? where book_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(6,bookid);
					ps2.setString(1,bookdate);
					ps2.setInt(2,prodquantity);
					ps2.setInt(3,prodid);
					ps2.setInt(4,custid);
					ps2.setInt(5,carid);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");			
					display("tbl_booking");
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_empsalery"))
			{
				int empsalid=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Salery ID : "));
				int empid=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID : "));
				float empsalamt=Float.parseFloat(JOptionPane.showInputDialog("Enter Employee Salery : "));
				String empsaldate=JOptionPane.showInputDialog("Enter Employee Salery Date : ");
				float empince=Float.parseFloat(JOptionPane.showInputDialog("Enter Employee Incentives : "));
				
				q="update tbl_empsalery set emp_sal_amt=?,emp_sal_date=?,emp_ince=? where emp_id=? and empsal_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(5,empsalid);
					ps2.setInt(4,empid);
					ps2.setFloat(1,empsalamt);
					ps2.setString(2,empsaldate);
					ps2.setFloat(3,empince);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");
					display("tbl_empsalery");			
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_supplier"))
			{
				int supid=Integer.parseInt(JOptionPane.showInputDialog("Enter Supplier ID : "));
				String supname=JOptionPane.showInputDialog("Enter Supplier Name : ");
				String supofaddr=JOptionPane.showInputDialog("Enter Supplier Office Address : ");
				long supmobno=Long.parseLong(JOptionPane.showInputDialog("Enter Supplier Mobile Number : "));
				long supofphoneno=Long.parseLong(JOptionPane.showInputDialog("Enter Supplier Office Phone Number : "));
				
				q="update tbl_supplier set sup_name=?,sup_off_addr=?,sup_mobno=?,sup_off_phoneno=? where sup_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(5,supid);
					ps2.setString(1,supname);
					ps2.setString(2,supofaddr);
					ps2.setLong(3,supmobno);
					ps2.setLong(4,supofphoneno);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");
					display("tbl_supplier");			
				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_supbill"))
			{
				int supbillid=Integer.parseInt(JOptionPane.showInputDialog("Enter Supplier Bill ID : "));
				String supbilldate=JOptionPane.showInputDialog("Enter Supplier Bill Date : ");
				float supbilltotamt=Float.parseFloat(JOptionPane.showInputDialog("Total Amount : "));
				int poid=Integer.parseInt(JOptionPane.showInputDialog("Enter Purchase Order ID : "));
				int supid=Integer.parseInt(JOptionPane.showInputDialog("Enter Supplier ID : "));
				q="update tbl_supbill set supbill_date=?,supbill_totamt=?,po_id=?,sup_id=? where supbill_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(5,supbillid);
					ps2.setString(1,supbilldate);
					ps2.setFloat(2,supbilltotamt);
					ps2.setInt(3,poid);
					ps2.setInt(4,supid);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");
					display("tbl_supbill");			

				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_PO"))
			{
				int poid=Integer.parseInt(JOptionPane.showInputDialog("Enter Purchase Ordert ID : "));
				String podate=JOptionPane.showInputDialog("Enter Purchase Order Date : ");
				int poqty=Integer.parseInt(JOptionPane.showInputDialog("Enter Enter Quantity : "));
				int prodid=Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID : "));
				int supid=Integer.parseInt(JOptionPane.showInputDialog("Enter Supplier ID : "));
				int carid=Integer.parseInt(JOptionPane.showInputDialog("Enter Car ID :"));
				
				q="update tbl_PO set po_date=?,po_qty=?,prod_id=?,sup_id=?,car_id=? where po_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(6,poid);
					ps2.setString(1,podate);
					ps2.setInt(2,poqty);
					ps2.setInt(3,prodid);
					ps2.setInt(4,supid);
					ps2.setInt(5,carid);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");
					display("tbl_PO");			

				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
			else if(tablename.equals("tbl_customerbill"))
			{
				int custbillid=Integer.parseInt(JOptionPane.showInputDialog("Enter Customer Bill ID : "));
				int bookid=Integer.parseInt(JOptionPane.showInputDialog("Enter Booking ID : "));
				int prodqty=Integer.parseInt(JOptionPane.showInputDialog("Enter Product Quantity : "));
				String custbilldate=JOptionPane.showInputDialog("Enter Customer Bill Date : ");
				int prodid=Integer.parseInt(JOptionPane.showInputDialog("Enter Product ID : "));
				int carid=Integer.parseInt(JOptionPane.showInputDialog("Enter Car ID :"));
				
				q="update tbl_customerbill set book_id=?,prod_quantity=?,custbill_date=?,prod_id=?,car_id=? where custbill_id=?";
				try
				{
					ps2=con.prepareStatement(q);
					ps2.setInt(6,custbillid);
					ps2.setInt(1,bookid);
					ps2.setInt(2,prodqty);
					ps2.setString(3,custbilldate);
					ps2.setInt(4,prodid);
					ps2.setInt(5,carid);
					
					ps2.executeUpdate();

					JOptionPane.showMessageDialog(null,"Update Successfull");
					display("tbl_customerbill");		

				}//try

				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);			
				}//catch
				
			}//else if
					
	}//updateRow
	public void close()
	{
  WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}


	

/*	public static void main(String args[]) 
	{
		new Details(name);
	}//main*/
}//reg class
	
