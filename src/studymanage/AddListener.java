package studymanage;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AddListener implements ActionListener{
	Manager k;
	String username=null;
	void setMng(Manager k) {
		this.k=k;
	}
	void setUsrname(String username) {
		this.username=username;
	}
	public void actionPerformed(ActionEvent e) {
		File fil=new File("Lessons.txt");
		try {
			FileWriter filWR=new FileWriter(fil,true);
			BufferedWriter bufWR=new BufferedWriter(filWR);
			Adding t=new Adding(username);
			bufWR.close();
			t.setTitle("添加信息管理");
			t.setBounds(433, 154, 500, 460);
			t.setVisible(true);
			t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(Exception error) {
			System.out.println(error);
		}
	}
}
