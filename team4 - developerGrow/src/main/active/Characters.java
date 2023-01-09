package main.active;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import guiDesign.Methods;
import main.MainFrame;

public class Characters extends JLabel {
	private ImageIcon defaultImage = Methods.convertToIcon(getClass(), "character\\character.gif");
	private ImageIcon smokeImage = Methods.convertToIcon(getClass(), "character\\smokecharacter.gif");
	private ImageIcon sleepImage = Methods.convertToIcon(getClass(), "active_image/sleep.png");
	private ImageIcon bedsleepImage = Methods.convertToIcon(getClass(), "active_image/bedsleep.png");
	private ImageIcon playgameImage = Methods.convertToIcon(getClass(), "active_image/playgame.gif");
	private ImageIcon coupangImage = Methods.convertToIcon(getClass(), "active_image/coupang.gif");
	private ImageIcon eatImage = Methods.convertToIcon(getClass(), "active_image/eat.gif");
	private ImageIcon resumeImage = Methods.convertToIcon(getClass(), "active_image/resume.gif");
	
	private MainFrame mainFrame = null;
	private JLabel characterlbl;
	private JLabel activelbl;
	
	public Characters(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void defaultCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(getDefaultImage());
		characterlbl.setBounds(211, 392, 210, 300);
		setCharacterlbl(characterlbl);
		setActivelbl(activelbl);
		mainFrame.add(characterlbl);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void smokeCharacter() {	
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(smokeImage);
		characterlbl.setBounds(211, 392, 210, 300);
		mainFrame.add(characterlbl);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void sleepCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(sleepImage);
		characterlbl.setBounds(211, 392, 210, 300);
		mainFrame.add(characterlbl);	
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void bedsleepCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(bedsleepImage);
		characterlbl.setBounds(597, 382, 446, 240);
		mainFrame.add(characterlbl);	
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void playgameCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(playgameImage);
		activelbl.setBounds(331, 47, 408, 335);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);		
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void eatCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(eatImage);
		activelbl.setBounds(331, 47, 408, 335);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);		
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void resumeCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(resumeImage);
		activelbl.setBounds(331, 47, 408, 335);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);	
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void coupangCharacter() {
		characterlbl = new JLabel();
		activelbl = new JLabel();
		characterlbl.setIcon(defaultImage);
		characterlbl.setBounds(211, 392, 210, 300);
		activelbl.setIcon(coupangImage);
		activelbl.setBounds(306, 0, 490, 418);
		mainFrame.add(characterlbl);
		mainFrame.add(activelbl);
		mainFrame.getActivitybtn().setEnabled(false);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public JLabel getCharacterlbl() {
		return characterlbl;
	}
	public void setCharacterlbl(JLabel characterlbl) {
		this.characterlbl = characterlbl;
	}
	public JLabel getActivelbl() {
		return activelbl;
	}
	public void setActivelbl(JLabel activelbl) {
		this.activelbl = activelbl;
	}

	public ImageIcon getDefaultImage() {
		return defaultImage;
	}
}