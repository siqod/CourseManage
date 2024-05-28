package studymanage;
import javax.swing.*;
import java.awt.*;

public class RegisterTest extends JFrame{//用于建造注册登录窗口
	private static final long serialVersionUID = 29042L;
	TsRg lisn=new TsRg();
	TestForRegister lisn2=new TestForRegister();
	JButton reg=new JButton("前往注册");
	JButton log=new JButton("登录");
	JLabel username=new JLabel("用户名：");
	JLabel password=new JLabel("密码：");
	JLabel forwan=new JLabel("提示信息");
	JTextField forusername=new JTextField();
	JTextField forpassword=new JTextField();
	JLabel WARN=new JLabel();
	JLabel hints1=new JLabel("注意：用户名是不超过15位的字符");
	JLabel hints2=new JLabel("密码是6-20位的");
	public RegisterTest() {
		setLayout(null);
		lisn.setReg(this);
		lisn2.setReg(this);
		Font k=new Font("宋体",Font.BOLD,24);
		Font k2=new Font("宋体",Font.BOLD,30);
		Font word=new Font("宋体",Font.BOLD,28);
		Font inser2=new Font("宋体",Font.BOLD,26);//设置字体
		Font inser=new Font("Arial",Font.BOLD,26);
		Font word2=new Font("宋体",Font.CENTER_BASELINE,14);
		username.setFont(word);
		username.setBounds(40, 40, 125,35);
		password.setFont(word);
		password.setBounds(40, 110, 125,35);
		forusername.setFont(inser2);
		forusername.setBounds(175, 40, 285, 35);
		forpassword.setFont(inser);
		forpassword.setBounds(175, 110, 285, 35);
		reg.setFont(k);//注册
		reg.setBounds(25, 300, 200, 50);
		reg.addActionListener(lisn2);//监听器2
		log.setFont(k);//登录
		log.setBounds(275, 300, 200, 50);
		log.addActionListener(lisn);//监听器1
		hints1.setFont(word2);
		hints1.setBounds(40, 80, 300, 25);
		hints2.setFont(word2);
		hints2.setBounds(40, 150, 300, 25);
		WARN.setFont(inser2);
		WARN.setBounds(40, 210, 400, 65);
		forwan.setFont(k2);
		forwan.setBounds(40, 170, 135, 40);
		add(username);
		add(password);
		add(forusername);
		add(forpassword);
		add(hints1);
		add(hints2);
		add(WARN);
		add(reg);
		add(forwan);
		add(log);//全部展示出来
	}
}