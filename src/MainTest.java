package studymanage;
import javax.swing.*;

public class MainTest {//主程序测试
	public static void main(String [] Args) {
		WindowMake wind=new WindowMake();
		wind.windowRegist.setTitle("注册/登录");
		wind.windowRegist.setBounds(433, 184, 500, 400);//设置框体大小
		wind.windowRegist.setVisible(true);//登录页面一开始可见
		wind.windowRegist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wind.windowRegist.lisn2.setReg2(wind.Regist);//代码调整
		wind.Regist.jianting.setReg2(wind.windowRegist);
		wind.Regist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wind.Regist.setTitle("注册");
		wind.Regist.setBounds(433, 184, 500, 400);
		wind.Regist.setVisible(false);//注册窗口一开始不可见
	}
}
