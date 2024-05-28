package studymanage;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class TestForRegister implements ActionListener{//这是个前往注册按钮监听器
	RegisterTest k;
	WindowForRegister k2;//注册页面
	void setReg(RegisterTest k) {
		this.k=k;//传参
	}
	void setReg2(WindowForRegister k) {
		this.k2=k;//这个比较神奇，传参位置是主函数
	}
	public void actionPerformed(ActionEvent e) {
		k.setVisible(false);//你要注册，那登陆页面就要去掉了
		k.forpassword.setText(null);
		k.forusername.setText(null);
		k.WARN.setText(null);//把所有信息栏清空
		try{
			TimeUnit.MILLISECONDS.sleep(500);//给程序500ms时间缓冲
		}
		catch(InterruptedException err){
			System.out.println("ERROR:"+err);
		}
		try {
			k2.setVisible(true);//设注册页面可见
		}
		catch(Exception error) {
			System.out.println("ERROR:"+error);//debug用的函数
		}
	}
}
