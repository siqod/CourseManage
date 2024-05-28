package studymanage;
import java.awt.*;
import javax.swing.*;

public class Deleting extends JFrame{
	private static final long serialVersionUID = 26709L;
	JLabel ask=new JLabel("您需要删除的记录号是？");
	JTextField ins=new JTextField();
	JButton sure=new JButton("确定");
	JLabel WARN=new JLabel();
	DeleteSuringListener lisn=new DeleteSuringListener();
	public Deleting(String username){
		lisn.setReg(this);
		lisn.setUsrname(username);
		setLayout(null);
		Font ft1=new Font("宋体",Font.BOLD,24);
		Font ft2=new Font("宋体",Font.BOLD,28);
		ask.setFont(ft1);
		ins.setFont(ft1);
		sure.setFont(ft2);
		ask.setBounds(15, 15, 280, 30);
		ins.setBounds(110, 60, 80, 30);
		WARN.setFont(ft2);
		WARN.setBounds(15, 100, 280, 30);
		sure.setBounds(90, 150, 120, 45);
		sure.addActionListener(lisn);
		add(ask);
		add(ins);
		add(WARN);
		add(sure);
	}
}
