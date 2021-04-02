package quiz;
/* Welcome to my Quiz Generator. It is already in description so i will go straigth to code. You need to create a database QuizJava in mysql 
password is India@123, plz make changes as necessary,mysql must be installed.*/

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;

public class quiz1 extends JFrame {//main class

	private JPanel contentPane,contentPane1;
	private JButton btnNewButtonk,btnNewButtonexit,btnNewButtonn,J;
	private JFrame f;
	private JTextField textFieldk[];
	private JLabel lblNewLabelk,lblNewLabelA;
	private JTextField lblNewLabelC;
	private JTextField lblNewLabelq;
	private String a1,a2,a3,a4,a="no";
	private int x=2,n=0,qq=0,choice=0,k=0,kk=0,nn=0;
	private JTextField textFieldkg;
	private JPanel content;
	private String rightch;
	private ArrayList<Data> arr,arr1;
	private JLabel A,B,C,D,E,F,G,I,I2,lblNewLabelQ,k2,lblNewLabelB,I21;
	private Container H;
	private JTextField I1;
	private ArrayList<String> answer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quiz1 frame = new quiz1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	class Data//datatype created to store data
	{
	String a,b,c,d,e,f,g;
	Data(String a,String b, String c,String d,String e,String f,String g)
	{
	this.a=a;
	this.b=b;
	this.c=c;
	this.d=d;
	this.e=e;
	this.f=f;
	this.g=g;
	}
	}
	
	void attempt12(Data j) {//result checked display
		f.dispose();
		f=new JFrame();
		JPanel con=new JPanel();
		con.setLayout(null);
		A= new JLabel(j.a);
		A.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		A.setBounds(90, 11, 289, 64);
		con.add(A);
		
		B = new JLabel("1");
		B.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		B.setBounds(90, 110, 15, 14);
		con.add(B);
		
		C = new JLabel(j.b);
		C.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		C.setBounds(146, 110, 266, 14);
		con.add(C);
		
		D= new JLabel("2");
		D.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		D.setBounds(90, 135, 15, 14);
		con.add(D);
		
		E = new JLabel("3");
		E.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		E.setBounds(90, 160, 15, 14);
		con.add(E);
		
		F = new JLabel("4");
		F.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		F.setBounds(90, 185, 15, 14);
		con.add(F);
		
		G = new JLabel(j.c);
		G.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		G.setBounds(146, 135, 266, 14);
		con.add(G);
		
		H= new JLabel(j.d);
		H.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		H.setBounds(146, 160, 266, 14);
		con.add(H);
		
		I = new JLabel(j.e);
		I.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		I.setBounds(146, 185, 266, 14);
		con.add(I);
		String st="Your answer="+answer.get(nn);
		if (j.f.compareTo(answer.get(nn))==0) 
			st =st+" , Correct";
		else
			st=st+" , Incorrect , Answer="+j.f;	
		k2=new JLabel(st);
		k2.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		k2.setBounds(20,185, 200, 100);
		con.add(k2);
		J = new JButton("Next");
		J.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		J.setBounds(307, 227, 89, 23);
		con.add(J);
		f.add(con);
		f.setVisible(true);
		f.setSize(450,300);
		J.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			if (I1.getText().compareTo("1")==0 || I1.getText().compareTo("2")==0 || I1.getText().compareTo("3")==0 || I1.getText().compareTo("")==0 ){
			answer.add(I1.getText());

			if ((nn+1)==arr.size()) {
				nn=0;
				f.dispose();
				}
			else {
				nn+=1;
				attempt12(arr.get(nn));
			}}
			else {
				I21 = new JLabel("Incorrect\n Entry");
				I21.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
				I21.setBounds(20, 130, 180, 14);
				con.add(I21);
			}
		}});
	}
	
	void result() {//display of result
		f.dispose();
		f=new JFrame();
		JPanel con=new JPanel();
		con.setLayout(null);
		JLabel f1= new JLabel("Result");
		f1.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		f1.setBounds(90, 50, 150, 14);
		con.add(f1);
		int marks=0,p=0;
		for (String j:answer) {
			if (j.compareTo(arr.get(p).f)==0)
				marks+=1;
			p+=1;
		}
		JLabel f2= new JLabel(String.valueOf(marks)+"/"+String.valueOf(p));
		f2.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		f2.setBounds(90, 100, 150, 14);
		con.add(f2);
		JButton ne=new JButton("Check Result");
		ne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				attempt12(arr.get(0));
			}});
		ne.setBounds(307, 150,120, 23);
		con.add(ne);
		f.add(con);
		f.setVisible(true);
		f.setSize(450,300);
	}
	void attempt1(Data j) {//attempting quiz
		f.dispose();
		f=new JFrame();
		JPanel con=new JPanel();
		con.setLayout(null);
		A= new JLabel(j.a);
		A.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		A.setBounds(90, 11, 289, 64);
		con.add(A);
		
		B = new JLabel("1");
		B.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		B.setBounds(90, 110, 15, 14);
		con.add(B);
		
		C = new JLabel(j.b);
		C.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		C.setBounds(146, 110, 266, 14);
		con.add(C);
		D= new JLabel("2");
		D.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		D.setBounds(90, 135, 15, 14);
		con.add(D);
		E = new JLabel("3");
		E.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		E.setBounds(90, 160, 15, 14);
		con.add(E);
		F = new JLabel("4");
		F.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		F.setBounds(90, 185, 15, 14);
		con.add(F);
		G = new JLabel(j.c);
		G.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		G.setBounds(146, 135, 266, 14);
		con.add(G);
		
		H= new JLabel(j.d);
		H.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		H.setBounds(146, 160, 266, 14);
		con.add(H);
		
		I = new JLabel(j.e);
		I.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		I.setBounds(146, 185, 266, 14);
		con.add(I);
		I2 = new JLabel("Answer No.");
		I2.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		I2.setBounds(20, 80, 266, 14);
		con.add(I2);
		I1 = new JTextField();
		I1.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
		I1.setBounds(20,110, 50, 23);
		con.add(I1);
		J = new JButton("Next");
		J.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 14));
		J.setBounds(307, 227, 89, 23);
		con.add(J);
		f.add(con);
		f.setVisible(true);
		f.setSize(450,300);
		J.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			if (I1.getText().compareTo("1")==0 || I1.getText().compareTo("2")==0 || I1.getText().compareTo("3")==0 || I1.getText().compareTo("")==0 ){
			answer.add(I1.getText());

			if ((n+1)==arr.size()) {
				n=0;
				result();}
			else {
				n+=1;
				attempt1(arr.get(n));
			}}
			else {
				I21 = new JLabel("Incorrect\n Entry");
				I21.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 11));
				I21.setBounds(20, 130, 180, 14);
				con.add(I21);
			}
		}});
	}
	void attempt() {//working while attemptng
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/QuizJava?user=root&password=India@123");
			String ch="select * from "+rightch;
			PreparedStatement p=cn.prepareStatement(ch);
			ResultSet rs1=p.executeQuery();
			arr=new ArrayList<>();
			arr1=new ArrayList<>();
			answer=new ArrayList<>();
			while(rs1.next()!=false) {
				Data dd=new Data(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7));
				arr1.add(dd);
			}
			Random rand=new Random();
			ArrayList<Integer> aq=new ArrayList<>();
			int pp1,pp=0;
			for (int ii=0;ii<(Integer.parseInt(arr1.get(0).g ));ii++) {
				while(true) {
					pp1=rand.nextInt(arr1.size() );
					for (int iii=0;iii<aq.size();iii++) {
						pp=iii;
						if (aq.get(iii)==pp1)
							break;
					}
					if (pp==aq.size()) {
						arr.add(arr1.get(pp1));
						break;
					}
				}
			}
			cn.close();
			attempt1(arr.get(n));
			}
		catch(Exception be) {
		}
	}
	void input() {//finding id
		f=new JFrame();
		content = new JPanel();
		JLabel lblNewLabel111 = new JLabel("Enter Id");
		lblNewLabel111.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel111.setBounds(164, 100, 86, 14);
		content.add(lblNewLabel111);
		content.setLayout(null);
		textFieldkg = new JTextField();
		textFieldkg.setBounds(141, 130, 138, 20);
		content.add(textFieldkg);
		textFieldkg.setColumns(10);
		JButton sub = new JButton("Enter");
		sub.addActionListener(new ActionListener(){
		

			public void actionPerformed(ActionEvent e) {
				try {
					Connection cn5=DriverManager.getConnection("jdbc:mysql://localhost/QuizJava?user=root&password=India@123");
					
					String sk="show tables";
					PreparedStatement p19=cn5.prepareStatement(sk);
					ResultSet rs=p19.executeQuery();
					ArrayList<String> aaa=new ArrayList<String>();
					while (rs.next()!=false) {
						
						aaa.add(rs.getString(1));	
						}
					int i=0;
						for(i=0;i<aaa.size();i++) {
							if (aaa.get(i).compareTo(textFieldkg.getText())==0)
								break;
							}
					if (i==aaa.size()) {
						JLabel lblNewLabel111 = new JLabel("Incorrect Entry");
						lblNewLabel111.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
						lblNewLabel111.setBounds(164, 150, 200, 14);
						content.add(lblNewLabel111);
					}
					else {
						rightch=aaa.get(i);
						attempt();
					}
					}
				catch(Exception be) {}
			}});
		sub.setBounds(141, 180, 89, 23);
		content.add(sub);
		f.add(content);
		f.setVisible(true);
		f.setSize(450,300);
	}
	
	void next() {//moving to next Question
		try {
			if (qq!=0) 
				f.dispose();
			qq=1;
			f=new JFrame();
			textFieldk=new JTextField[4];
			textFieldk[0] = new JTextField();
			textFieldk[1] = new JTextField();
			textFieldk[2] = new JTextField();
			textFieldk[3] = new JTextField();
			x=2;
			contentPane1 = new JPanel();
			contentPane1.setLayout(null);
			
			textFieldk[0] = new JTextField();
			textFieldk[0].setBounds(201, 60, 86, 20);
			contentPane1.add(textFieldk[0]);
			textFieldk[0].setColumns(10);
			lblNewLabelA = new JLabel("1");
			lblNewLabelA.setFont(new Font("Arial Black", Font.BOLD, 16));
			lblNewLabelA.setBounds(89, 60, 46, 14);
			contentPane1.add(lblNewLabelA);
			
			
			btnNewButtonn.setFont(new Font("Arial Black", Font.BOLD, 16));
			btnNewButtonn.setBounds(290, 230, 110, 23);
			contentPane1.add(btnNewButtonn);
			lblNewLabelB = new JLabel("Enter Question");
			lblNewLabelB.setBounds(24, 11, 100, 23);
			lblNewLabelB.setFont(new Font("Arial Black", Font.BOLD, 11));
			contentPane1.add(lblNewLabelB);
			
			lblNewLabelC = new JTextField();
			lblNewLabelC.setBounds(139, 11, 259, 23);
			contentPane1.add(lblNewLabelC);
			btnNewButtonexit.setBounds(160, 230, 110, 23);
			btnNewButtonexit.setFont(new Font("Arial Black", Font.BOLD, 16));
			contentPane1.add(btnNewButtonexit);
			btnNewButtonk.setBounds(30, 230, 110, 23);
			btnNewButtonk.setFont(new Font("Arial Black", Font.BOLD, 16));
			contentPane1.add(btnNewButtonk);
			lblNewLabelQ = new JLabel("Enter Answer Number");
			lblNewLabelQ.setBounds(24, 190, 150, 23);
			lblNewLabelQ.setFont(new Font("Arial Black", Font.BOLD, 11));
			contentPane1.add(lblNewLabelQ);
			
			lblNewLabelq = new JTextField();
			lblNewLabelq.setBounds(180, 190, 50, 23);
			contentPane1.add(lblNewLabelq);
		f.getContentPane().add(contentPane1);
		f.setSize(450,300);
		f.setVisible(true);
		}
		catch(Exception be) {
		}
	}
	void next1() {//storing data
		try {
		String w=lblNewLabelC.getText();
		if (w.compareTo("")!=0) {
			String q=lblNewLabelq.getText();
			if (q.compareTo("")!=0 && Integer.parseInt(q)<=x){
				kk=0;	
				if (textFieldk[0].getText()==null)
					a1="";
				else
					a1=textFieldk[0].getText();
				if (textFieldk[1].getText()==null)
					a2="";
				else
					a2=textFieldk[1].getText();

				if (textFieldk[2].getText()==null)
					a3="";
				else
					a3=textFieldk[2].getText();
					
				if (textFieldk[3].getText()==null)
					a4="";
				else
					a4=textFieldk[3].getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/QuizJava?user=root&password=India@123");
				String s="create table if not exists "+a+"(question varchar(1000),ch1 char(50),ch2 char(50),ch3 char(50),ch4 char(50),answer char(50),qno char(50))";
				String s1="insert into "+a+"(question,ch1,ch2,ch3,ch4,answer) values(\'"+lblNewLabelC.getText()+"\',\'"+textFieldk[0].getText()+"\',\'"+textFieldk[1].getText()+"\',\'"+textFieldk[2].getText()+"\',\'"+textFieldk[3].getText()+"\',\'"+lblNewLabelq.getText()+"\')";
				
				PreparedStatement p=cn.prepareStatement(s);
				p.executeUpdate();
				PreparedStatement p1=cn.prepareStatement(s1);
				p1.executeUpdate();
				cn.close();
				next();
				
			} 
			else {
				JLabel lblNewLabe = new JLabel("Answer no must be there or less than choices");
				lblNewLabe.setBounds(24, 210, 300, 14);
				lblNewLabe.setFont(new Font("Arial Black", Font.BOLD, 10));
				contentPane1.add(lblNewLabe);
				kk=1;
			}
		}
	
		else {
				JLabel lblNewLab = new JLabel("Question must be here");
				lblNewLab.setBounds(24, 30, 150, 14);
				lblNewLab.setFont(new Font("Arial Black", Font.BOLD, 10));
				contentPane1.add(lblNewLab);
				kk=1;
				
		}
		}
		catch(Exception be) {
		}
	}
	public quiz1() {//main class constructor
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Enter Id");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					input();
			}
		});
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton.setBounds(82, 117, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButtonk = new JButton("New");
		btnNewButtonexit = new JButton("Finish");
		JButton btnNewButton_1 = new JButton("Create Id");
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cn5=DriverManager.getConnection("jdbc:mysql://localhost/QuizJava?user=root&password=India@123");
					
					String sk="show tables";
					PreparedStatement p19=cn5.prepareStatement(sk);
					ResultSet rs=p19.executeQuery();
					ArrayList<String> aaa=new ArrayList<String>();
					while (rs.next()!=false) {
						
						aaa.add(rs.getString(1));	
						}
					
					int i=0;
					while(true) {
						a="id"+String.valueOf(choice);
						for(i=0;i<aaa.size();i++) {
							if (aaa.get(i).compareTo(a)==0)
								break;
							
						}
						if (i==aaa.size()) {
							break;
						}
						else
							choice+=1;
					}
					
				
				next();}
				catch(Exception be) {
				}
				}});
		btnNewButtonk.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent e) {
				if (x<5) {
				
				textFieldk[x-1].setBounds(201,60+((x-1)*30), 86, 20);
				contentPane1.add(textFieldk[x-1]);
				textFieldk[x-1].setColumns(10);
				lblNewLabelk = new JLabel(String.valueOf(x));
				lblNewLabelk.setFont(new Font("Arial Black", Font.BOLD, 16));
				lblNewLabelk.setBounds(89,60+((x-1)*30), 46, 14);
				contentPane1.add(lblNewLabelk);
				}
				x+=1;
			}});
		btnNewButtonn = new JButton("Next");
		btnNewButtonn.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				next1();
				}});
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnNewButton_1.setBounds(245, 117, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButtonexit.addActionListener(new ActionListener(){
			private int count;

			public void actionPerformed(ActionEvent e) {
				next1();
				if (kk==0) {
				try {
				
				String u=javax.swing.JOptionPane.showInputDialog(null,"Enter no of Question each time.");
				
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn1=DriverManager.getConnection("jdbc:mysql://localhost/QuizJava?user=root&password=India@123");
					
					String s="select * from "+a;
					PreparedStatement p=cn1.prepareStatement(s);
					ResultSet rs=p.executeQuery();
					while (rs.next()!=false) {
						count+=1;
						}
					while(Integer.parseInt(u)>count && Integer.parseInt(u)>0)
						u=javax.swing.JOptionPane.showInputDialog(null,"Enter no of Question each time.(must be less than total questions)");
					String s13="update "+a+" set qno='"+u+"\'";
					PreparedStatement p3=cn1.prepareStatement(s13);
					p3.executeUpdate();
					cn1.close();
				}
				catch(Exception be) {}
				javax.swing.JOptionPane.showMessageDialog(null,"ID is "+a);
				count=0;
				f.dispose();
				qq=0;
				k=0;
				}
				
			}});
		JLabel lblNewLabel = new JLabel("Quiz Engine");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(163, 57, 101, 34);
		contentPane.add(lblNewLabel);
	
	}}
