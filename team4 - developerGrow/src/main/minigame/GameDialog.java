package main.minigame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import main.MainFrame;
import main.minigame.different.BulletGame;
import main.minigame.different.Hide;
import main.minigame.different.ToryMain;
import main.minigame.du.dugame;

public class GameDialog extends JDialog {
	int score;
	
	public GameDialog(int x, int y, MainFrame mainFrame) {
		
		ClassLoader classloader = getClass().getClassLoader();
		
		setUndecorated(true);
		setModal(true);
		setBounds(x + 7, y + 30, 1185, 762);
		
		setBackground(new Color(0, 0, 0, 80));
		getContentPane().setLayout(null);
		
		JButton firstGameBtn = new JButton();
		URL first = classloader.getResource("images/btn_img/dodoBtn.png");
		ImageIcon firstGame = new ImageIcon(first);
		URL firstPush = classloader.getResource("images/btn_img/dodoPush.png");
		ImageIcon firstPushGame = new ImageIcon(firstPush);
		firstGameBtn.setIcon(firstGame);
		firstGameBtn.setPressedIcon(firstPushGame);
		firstGameBtn.setBorderPainted(false);
		firstGameBtn.setContentAreaFilled(false);
		firstGameBtn.setBackground(new Color(255, 0, 0, 0));
		firstGameBtn.setBounds(400, 200, 100, 50);
		firstGameBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dugame dugame = new dugame("", mainFrame);
				dispose();
				dugame.showGUI();
			}
		});
		getContentPane().add(firstGameBtn);
		
		JButton secondGameBtn = new JButton();
		URL second = classloader.getResource("images/btn_img/difPictureBtn.png");
		ImageIcon secondGame = new ImageIcon(second);
		URL secondPush = classloader.getResource("images/btn_img/difPicturePushBtn.png");
		ImageIcon secondPushGame = new ImageIcon(secondPush);
		secondGameBtn.setIcon(secondGame);
		secondGameBtn.setPressedIcon(secondPushGame);
		secondGameBtn.setBorderPainted(false);
		secondGameBtn.setContentAreaFilled(false);
		secondGameBtn.setBackground(new Color(255, 0, 0, 0));
		secondGameBtn.setBounds(700, 200, 100, 50);
		secondGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ToryMain torymain = new ToryMain("", mainFrame);
				
				dispose();
				torymain.showGUI();			
			}
		});
		getContentPane().add(secondGameBtn);
		
		
		
		
		
		JButton thirdGameBtn = new JButton();
		URL third = classloader.getResource("images/btn_img/hideBtn.png");
		ImageIcon thirdGame = new ImageIcon(third);
		URL thirdPush = classloader.getResource("images/btn_img/hideBtnpush.png");
		ImageIcon thirdPushGame = new ImageIcon(thirdPush);
		thirdGameBtn.setIcon(thirdGame);
		thirdGameBtn.setPressedIcon(thirdPushGame);
		thirdGameBtn.setBorderPainted(false);
		thirdGameBtn.setContentAreaFilled(false);
		thirdGameBtn.setBackground(new Color(255, 0, 0, 0));
		thirdGameBtn.setBounds(400, 400, 100, 50);
		thirdGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Hide hide = new Hide("", mainFrame);
				dispose();
				hide.showGUI();
			}
		});
		getContentPane().add(thirdGameBtn);
		
		
		
		
		
		JButton forthGameBtn = new JButton();
		URL forth = classloader.getResource("images/btn_img/gunBtn.png");
		ImageIcon forthGame = new ImageIcon(forth);
		URL forthPush = classloader.getResource("images/btn_img/gunBtnpush.png");
		ImageIcon forthPushGame = new ImageIcon(forthPush);
		forthGameBtn.setIcon(forthGame);
		forthGameBtn.setPressedIcon(forthPushGame);
		forthGameBtn.setBorderPainted(false);
		forthGameBtn.setContentAreaFilled(false);
		forthGameBtn.setBackground(new Color(255, 0, 0, 0));
		forthGameBtn.setBounds(700, 400, 100, 50);
		forthGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BulletGame bulletGame = new BulletGame(GameDialog.this, mainFrame);
				dispose();
				bulletGame.setVisible(true);
				System.out.println(score);
			}
		});
		getContentPane().add(forthGameBtn);
		
		
		
		JButton closeButton = new JButton();
		URL close = classloader.getResource("images/btn_img/closeBtnImage.png");
		ImageIcon closeImage = new ImageIcon(close);
		URL closePush = classloader.getResource("images/btn_img/closeBtnPushImage.png");
		ImageIcon closePushImage = new ImageIcon(closePush);
		closeButton.setBounds(500, 550, 200, 50);
		closeButton.setBackground(new Color(255, 0, 0, 0));
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setIcon(closeImage);
		closeButton.setPressedIcon(closePushImage);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getGameControllerImpl().timeController();
				mainFrame.getGameControllerImpl().runProjectTime();
				dispose();
			}
		});
		getContentPane().add(closeButton);
		
	}
	
	public void showGUI() {
		setVisible(true);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
