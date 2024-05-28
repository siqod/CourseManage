package studymanage;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Manager extends JFrame{
	private static final long serialVersionUID = 17928L;
	public Manager(String username) {
		JLabel[] m=new JLabel[7];
		File fil=new File(username+".txt");
		Font ft1=new Font("宋体",Font.BOLD,16);//字体
		Font ft2=new Font("宋体",Font.BOLD,32);
		JButton addNew=new JButton("添加信息");
		JButton forDelete=new JButton("删除信息");
		AddListener k=new AddListener();
		DeleteListener k2=new DeleteListener();
		int direct=100,secdr=30;
		setLayout(null);
		for(int i=0;i<=6;i++) {
			m[i]=new JLabel();
			m[i]=new JLabel();
			m[i].setFont(ft1);
		}
		m[0].setText("记录号");
		m[1].setText("课程号");
		m[2].setText("课程名称");
		m[3].setText("学分");
		m[4].setText("教室");
		m[5].setText("考试时间");
		m[6].setText("成绩");
		for(int i=0;i<=6;i++) {
			m[i].setBounds(i*direct+15, 10, 85, 20);
			add(m[i]);
		}
		k.setMng(this);
		addNew.setBounds(100, 300, 200, 50);
		addNew.setFont(ft2);
		addNew.addActionListener(k);
		forDelete.setBounds(400, 300, 200, 50);
		forDelete.setFont(ft2);
		forDelete.addActionListener(k2);
		add(addNew);
		add(forDelete);
		k.setUsrname(username);
		k2.setUsrname(username);
		try {
			FileReader filRd=new FileReader(fil);
			BufferedReader bufRd=new BufferedReader(filRd);
			JLabel b[][]=new JLabel [10][7];
			int j=0,l=0;
			for(j=0;j<10;j++) {
				try {
					b[j][0]=new JLabel();
					b[j][0].setText(bufRd.readLine());
				}
				catch(Exception error){
					break;
				}
				if(b[j][0].getText()==null||b[j][0].getText().isEmpty()) {
					break;
				}
				b[j][0].setFont(ft1);
				for(l=1;l<7;l++) {
					b[j][l]=new JLabel();
					b[j][l].setText(bufRd.readLine());
					b[j][l].setFont(ft1);
				}
			}
			for(int p=0;p<j;p++) {
				for(l=0;l<7;l++) {
					b[p][l].setBounds(l*direct+15, 10+(p+1)*secdr, 85, 20);
					add(b[p][l]);
				}
			}
			bufRd.close();
			filRd.close();
		}
		catch(Exception err) {
			try{
				FileWriter filWr=new FileWriter(fil);
				filWr.close();
				System.out.println("ERROR:"+err);
			}
			catch(Exception IMP) {
				System.out.println("WARNING!"+IMP);
			}
		}
	}
}
