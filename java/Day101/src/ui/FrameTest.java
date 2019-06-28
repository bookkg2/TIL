package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest  {//WindowAdapter :Window에 이벤트 처리
	Frame f;
	
	Button b;
	public FrameTest() {
		makeUi();
	}
	public void makeUi() {
	f = new Frame();
	b = new Button("Click");
	f.add(b);
	f.setSize(300, 300);
	f.setVisible(true);
	f.addWindowListener(new MyWindow());//Frame에 윈도우 이벤트가 발생하면 (누가) 처리하겠냐
	b.addActionListener(new ActionListener() {//이름없는 클래스 : 어나미머스 클래스
		
		@Override
		public void actionPerformed(ActionEvent e) {
			b.setBackground(Color.red);
			
		}
	});	
	}
	class MyWindow extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {//Inner누르면 밖에 있는 변수를 마음대로 쓸 수 있음.
			super.windowClosing(e);
			f.setVisible(false);
			System.exit(0);
		}
		
	}
	public static void main(String a[]) {
		new FrameTest();
	}
}
