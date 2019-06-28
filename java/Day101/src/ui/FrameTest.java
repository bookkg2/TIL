package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest  {//WindowAdapter :Window�� �̺�Ʈ ó��
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
	f.addWindowListener(new MyWindow());//Frame�� ������ �̺�Ʈ�� �߻��ϸ� (����) ó���ϰڳ�
	b.addActionListener(new ActionListener() {//�̸����� Ŭ���� : ��̸ӽ� Ŭ����
		
		@Override
		public void actionPerformed(ActionEvent e) {
			b.setBackground(Color.red);
			
		}
	});	
	}
	class MyWindow extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {//Inner������ �ۿ� �ִ� ������ ������� �� �� ����.
			super.windowClosing(e);
			f.setVisible(false);
			System.exit(0);
		}
		
	}
	public static void main(String a[]) {
		new FrameTest();
	}
}
