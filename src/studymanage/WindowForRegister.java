package studymanage;
import javax.swing.*;
import java.awt.*;

public class WindowForRegister extends JFrame{//注册页面
	private static final long serialVersionUID = 31767L;
	JButton reg=new JButton("注册");
	JLabel username=new JLabel("用户名：");
	JLabel password=new JLabel("密码：");
	JTextField forusername=new JTextField();
	JTextField forpassword=new JTextField();
	JLabel WARN=new JLabel();
	JLabel hints1=new JLabel("注意：用户名是不超过15位的字符");
	JLabel hints2=new JLabel("密码是6-20位的");
	ListenerForRegister jianting=new ListenerForRegister();
	public WindowForRegister() {
		setLayout(null);
		Font k=new Font("宋体",Font.BOLD,32);
		Font word=new Font("宋体",Font.BOLD,28);
		Font inser2=new Font("宋体",Font.BOLD,26);
		Font inser=new Font("Arial",Font.BOLD,26);
		Font word2=new Font("宋体",Font.CENTER_BASELINE,14);
		jianting.setReg(this);
		username.setFont(word);
		username.setBounds(40, 40, 125,35);
		password.setFont(word);
		password.setBounds(40, 110, 125,35);
		forusername.setFont(inser2);
		forusername.setBounds(175, 40, 285, 35);
		forpassword.setFont(inser);
		forpassword.setBounds(175, 110, 285, 35);
		reg.setFont(k);
		reg.setBounds(100, 280, 300, 50);
		reg.addActionListener(jianting);
		hints1.setFont(word2);
		hints1.setBounds(40, 80, 300, 25);
		hints2.setFont(word2);
		hints2.setBounds(40, 150, 300, 25);
		WARN.setFont(inser2);
		WARN.setBounds(40, 180, 440, 65);
		add(username);
		add(password);
		add(forusername);
		add(forpassword);
		add(hints1);
		add(hints2);
		add(WARN);
		add(reg);
	}
}
