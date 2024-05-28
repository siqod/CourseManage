package studymanage;
import java.awt.event.*;
import java.io.*;
public class TsRg implements ActionListener{//登录的按钮
	RegisterTest k;
	public void setReg(RegisterTest k) {
		this.k=k;//登录页面
	}
	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent e) {
		int flag2018=0;
		String usname=null;//先把两个空String放在这里
		String uspswd=null;
		usname=k.forusername.getText();//然后开始获取信息
		uspswd=k.forpassword.getText();
		if(usname.isEmpty()) {
			k.WARN.setText("WARNING:用户名未输入！");
		}
		else if(uspswd.isEmpty()) {
			k.WARN.setText("WARNING:密码未输入！");
		}
		else {//此处写获取代码，获取账号密码是否匹配或者账号是否存在
			File fil=new File("TestWords.txt");
			try {
				String m;
				FileReader FilRd=new FileReader(fil);
				BufferedReader BufRd=new BufferedReader(FilRd);
				m=BufRd.readLine();
				String passwd = null;
				if(m==null) {//发现文件空的
					k.WARN.setText("还没有人注册！请先注册！");
					BufRd.close();
					FilRd.close();
				}
				else if(!m.equals(usname)) {
					for(;;) {
						m=BufRd.readLine();
						m=BufRd.readLine();
						if(m==null) {
							k.WARN.setText("用户名不存在");
							break;
						}
						else if(m.equals(usname)) {
							break;
						}
					}
					if(m!=null) {
						passwd=BufRd.readLine();//用户名存在，准备开始检测密码是否匹配
					}
					BufRd.close();
					FilRd.close();//读取关闭
					if(m!=null) {
						if(passwd.equals(uspswd)) {
							k.WARN.setText("密码正确，欢迎您"+usname);
							k.setVisible(false);//此处扩展连接展示界面的代码
							Manager k2=new Manager(usname);
							k2.setTitle("个人课程学习管理系统");
							k2.setBounds(333,184,700,400);
							k2.setVisible(true);
						}
						else {
							k.WARN.setText("密码错误");
						}
					}
				}
				else {//第一个就匹配上了
					passwd=BufRd.readLine();
					if(passwd.equals(uspswd)) {
						k.WARN.setText("密码正确，欢迎您"+usname);
						k.setVisible(false);//此处扩展连接展示界面的代码
						Manager k2=new Manager(usname);
						k2.setTitle("个人课程学习管理系统");
						k2.setBounds(333,184,700,400);
						k2.setVisible(true);
					}
					else {
						k.WARN.setText("密码错误");
					}
					BufRd.close();
					FilRd.close();
				}
			}
			catch(Exception error) {//根本没这个文件的话
				flag2018=1;
				System.out.println("ERROR:"+error);
			}

			if(flag2018==1) {
				k.WARN.setText("最高警告！文件不存在！");
			}
		}
	}
}
