package studymanage;
import java.awt.event.*;
import javax.swing.*;

public class DeleteListener implements ActionListener{
	Manager k;
	String username;
	void setMng(Manager k2) {
		this.k=k2;
	}
	void setUsrname(String username) {
		this.username=username;
	}
	public void actionPerformed(ActionEvent e) {
		try{
			Deleting t=new Deleting(username);
			t.setBounds(503, 269, 310, 250);
			t.setTitle("删除信息管理");
			t.setVisible(true);
			t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(Exception err) {
			System.out.println("ERROR:"+err);
		}
	}
}
