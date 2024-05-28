package studymanage;
import java.awt.event.*;
import java.io.*;

public class AddSuringListener implements ActionListener{
	String username;
	Adding k;
	void setUsername(String username) {
		this.username=username;
	}
	void setReg(Adding k) {
		this.k=k;
	}
	public void actionPerformed(ActionEvent e) {
		if(k.jiluhao.getText().isEmpty()||k.jiaoshi.getText().isEmpty()
				||k.kechengmingcheng.getText().isEmpty()||k.kechenghao.getText().isEmpty()
				||k.chengji.getText().isEmpty()||k.xuefen.getText().isEmpty()
				||k.kaoshishijian.getText().isEmpty()) {
			k.WARN.setText("仍有部分未填写！请检查！");
		}
		else {
			k.setVisible(false);
			File fil=new File(username+".txt");
			try {
				FileWriter filWR=new FileWriter(fil,true);
				BufferedWriter bufWR=new BufferedWriter(filWR);
				bufWR.write(k.jiluhao.getText());
				bufWR.newLine();
				bufWR.write(k.kechenghao.getText());
				bufWR.newLine();
				bufWR.write(k.kechengmingcheng.getText());
				bufWR.newLine();
				bufWR.write(k.xuefen.getText());
				bufWR.newLine();
				bufWR.write(k.jiaoshi.getText());
				bufWR.newLine();
				bufWR.write(k.kaoshishijian.getText());
				bufWR.newLine();
				bufWR.write(k.chengji.getText());
				bufWR.newLine();
				bufWR.close();
				filWR.close();
			}
			catch(Exception error) {
				System.out.println("ERROR:"+error);
			}
			System.exit(0);
		}
	}
}
