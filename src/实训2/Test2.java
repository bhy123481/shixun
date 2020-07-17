package 实训2;
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
					System.out.println("窗体已打开");
				}

				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("窗体已关闭");
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("窗体关闭");
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("窗体最小化了");
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("窗体最小化还原");
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("窗体获得焦点");
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println("窗体失去焦点");
				}
	        	
	        });
	        	
	        frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}
