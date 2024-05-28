package studymanage;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class DeleteSuringListener implements ActionListener{
	Deleting k;
	String username;
	void setReg(Deleting k) {
		this.k=k;
	}
	void setUsrname(String username) {
		this.username=username;
	}
	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent e) {
		String del=k.ins.getText();
		File fil=new File(username+".txt");	
		if(del==null||del.isEmpty()) {
			k.WARN.setText("请输入课程号");
		}
		else {
			try {
				FileReader filRd = new FileReader(fil);
				BufferedReader bufRd=new BufferedReader(filRd);
				String a;
				int j,flag=0;
				for(;;) {
					a=bufRd.readLine();
					if(a==null||a.isEmpty()) {
						break;
					}
					else if(a.equals(del)) {
						flag=1;
						break;
					}
					for(j=0;j<6;j++) {
						bufRd.readLine();
					}
				}
				if(flag==0) {
					k.WARN.setText("不存在此记录号");
				}
				bufRd.close();
				filRd.close();
				if(flag==1) {
					k.WARN.setText(null);
					FileReader filRead = new FileReader(fil);
					BufferedReader bufRead=new BufferedReader(filRead);
					LinkedList <String> lik=new LinkedList <String>();
					for(;;) {
						String k=bufRead.readLine();
						if(k!=null) {
							lik.add(k);
						}
						else {
							break;
						}
					}
					bufRead.close();
					filRead.close();
					FileWriter filWR=new FileWriter(username+".txt");
					BufferedWriter bufWR=new BufferedWriter(filWR);
					int place=lik.indexOf(del);
					for(int i=0;i<7;i++) {
						lik.remove(place);
					}
					System.out.print('\n');
					for(;;) {
						if(lik.isEmpty()||lik.getFirst()==null) {
							break;
						}
						bufWR.write(lik.getFirst());
						bufWR.newLine();
						lik.removeFirst();
					}
					bufWR.close();
					filWR.close();
					System.exit(0);
				}
			}
			catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}

}
