package main.minigame.different;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import main.MainFrame;


public class Hide extends JFrame {

	final Hidee center = new Hidee("");
	JLabel click;
	
	
	static int[] imageX = { 240, 500, 368, 568, 430, 220, 580 };
	static int[] imageY = { 408, 350, 143, 340, 405, 350, 520 };
	static final int range = 40;
	
	private MainFrame mainFrame;
	
	public Hide(String string, MainFrame mainFrame) {
		super(string);
		this.mainFrame = mainFrame;
		
		ClassLoader classLoader = getClass().getClassLoader();
		URL clickImg = classLoader.getResource("images/dif_img/check.png");
		URL hiding = classLoader.getResource("images/dif_img/1234.PNG");
		
		center.setBounds(10, 36, 672, 915);
		CustomMouseAdapter cma = new CustomMouseAdapter();
		center.addMouseListener(cma);
		getContentPane().setLayout(null);
		center.setLayout(null);

		click = new JLabel();
		click.setIcon(new ImageIcon(clickImg));
		click.setSize(70, 70);
		center.add(click);

		JLabel leftimg = new JLabel("");
		leftimg.setIcon(new ImageIcon(hiding));
		leftimg.setBounds(29, 22, 631, 883);
		center.add(leftimg);
		


		getContentPane().add(center);
		setBounds(500, 0, 700, 1000);
		setResizable(false);
		setVisible(true);
	}
	
	public void showGUI() {
		setVisible(true);
	}
	
	public boolean isRangeof(int index, Point p) {
	
		int pointX = p.x;

		int pointY = p.y;
	
		return (pointX >= imageX[index] - range) && (pointX <= imageX[index] + range)
				&& (pointY >= imageY[index] - range) && (pointY <= imageY[index] + range);
	}

	
	
	class CustomMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			click.setLocation(x - 20, y - 20);
		}

		public void mouseReleased(MouseEvent e) {
			Point p = e.getPoint();
			if (isRangeof(0, p)) {
				Hidee.f1 = true; //
				center.repaint();


			} else if (isRangeof(1, p)) {
				Hidee.f2 = true;
				center.repaint();


			} else if (isRangeof(2, p)) {
				Hidee.f3 = true;
				center.repaint();


			} else if (isRangeof(3, p)) {
				Hidee.f4 = true;
				center.repaint();


			} else if (isRangeof(4, p)) {
				Hidee.f5 = true;
				center.repaint();

			} else if (isRangeof(5, p)) {
				Hidee.f6 = true;
				center.repaint();
			} else if (isRangeof(6, p)) {
				Hidee.f7 = true;
				center.repaint();
			}

			if (Hidee.f1 == true && Hidee.f2 == true && Hidee.f3 == true && Hidee.f4 == true && Hidee.f5 == true && Hidee.f6 == true && Hidee.f7 == true) {
				JOptionPane.showMessageDialog(null, "축하합니다.");
				Hidee.f1 = false;
				Hidee.f2 = false;
				Hidee.f3 = false;
				Hidee.f4 = false;
				Hidee.f5 = false;
				Hidee.f6 = false;
				Hidee.f7 = false;
				center.repaint();
			}
		}
	}

}// end