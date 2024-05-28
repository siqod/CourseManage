package studymanage;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
//import java.sql.*;

public class ListenerForRegister implements ActionListener{//注册账号
	WindowForRegister k;
	RegisterTest k2;
	File test=new File("TestWords.txt");
	void setReg(WindowForRegister k) {
		this.k=k;
	}
	void setReg2(RegisterTest k) {
		this.k2=k;
	}
	ListenerForRegister vop() {
		return this;
	}
	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent e) {
		String password=null;
		String username=null;
		username=k.forusername.getText();
		password=k.forpassword.getText();
		if(username.isEmpty()) {
			k.WARN.setText("请输入用户名");
		}
		else if(password.isEmpty()) {
			k.WARN.setText("请输入密码");
		}
		else if(username.length()>15) {
			k.WARN.setText("请注意！用户名不能超过15个字符！");
		}
		else if(password.length()<6||password.length()>20) {
			k.WARN.setText("密码需要是6-20位");
		}
		else {//在这里需要写入存储器当中去，是用户的注册，此处是文件操作
			k.setVisible(false);
			k.WARN.setText(null);
			try {
				FileWriter FileWR=new FileWriter(test,true);
				BufferedWriter BufWR=new BufferedWriter(FileWR);
				FileReader FilRd=new FileReader(test);
				BufferedReader BufRd=new BufferedReader(FilRd);
				String m=null;
				String n=null;
				int flag=0;
				m=BufRd.readLine();
				n=m;
				for(;;) {
					if(m==null) {
						break;
					}
					else if(m.equals(username)) {
						flag=1;
						break;
					}
					else {
						m=BufRd.readLine();
						m=BufRd.readLine();
					}
				}
				BufRd.close();
				FilRd.close();
				if(flag==0) {
					if(n!=null) {
						BufWR.newLine();
					}
					BufWR.write(username);
					BufWR.newLine();
					BufWR.write(password);
					k2.WARN.setText(username+"，您已成功注册！");
					k2.reg.setText("前往注册");
				}
				else {
					k2.WARN.setText("用户名已被注册！");
					k2.reg.setText("重新前往注册");
				}
				BufWR.close();
				FileWR.close();
				k.forpassword.setText(null);
				k.forusername.setText(null);
			}
			catch(Exception error) {
				System.out.println("ERROR:"+error);
			}
			/*try {
				Driver driver;
				Connection con;
				Statement sql;
				ResultSet rs;
				String usernm="root";
				String passwd="on1rsuAb601";
				String uri="jdbc:mysql:192.168.100.1:3306/studentlesson?"+
				" useSSL=false&serverTimezone=GMT";
				con=DriverManager.getConnection(uri,usernm,passwd);
				try {
					sql=con.createStatement();
					rs=sql.executeQuery("SELECT * FROM studentlesson");
					if(rs.next()) {
						String usn=rs.getString(1);
						String psw=rs.getString(2);
						System.out.println(usn+' '+psw);
					}
					con.close();
				}
				catch(Exception error) {
					System.out.println("ERROR:"+error);
				}
			}
			catch(Exception error) {
				System.out.println("ERROR:"+error);
			}*/
			try{
				TimeUnit.MILLISECONDS.sleep(500);//给程序500ms时间缓冲
			}
			catch(InterruptedException err){
				System.out.println("ERROR:"+err);
			}
			k2.setVisible(true);
		}
	}
}
