package ʵѵ2;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
public class Test2 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        JFrame frame =new JFrame();
	        frame.setSize(550,550);
	        frame.addWindowListener(new WindowListener(){

				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("�����Ѵ�");
				}

				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("�����ѹر�");
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("����ر�");
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("������С����");
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("������С����ԭ");
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("�����ý���");
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("����ʧȥ����");
				}
	        	
	        });
	        	
	        frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}
