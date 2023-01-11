package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import database.dblist.CigaLog;
import database.dblist.Project;
import database.dblist.Rank;
import database.dblist.SkillList;
import database.dblist.User;
import database.dblist.UserInfo;
import database.dblist.UserProject;
import database.dblist.UserSkill;
import guiDesign.ImagePanel;
import guiDesign.Methods;
import login.LoginFrame;
import main.active.ActiveDialog;
import main.active.ActiveEventImpl;
import main.minigame.GameDialog;
import main.project.ProjectDialog;
import main.project.ProjectEventImpl;
import main.ranking.RankingDialog;
import main.setting.SettingDialog;
import main.store.StoreDialog;
import progressbar.ProgressbarEvent;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// 메인페널
	private ImagePanel Mainpnl;
	
	// 사운드
	private static Clip clip;
	private JButton soundbtn;
	
	// 활동버튼
	private ActiveEventImpl activeEventImpl = new ActiveEventImpl(this);
	private JButton activitybtn;
	
	// 메인시간
	private GameControllerImpl gameControllerImpl = new GameControllerImpl(this);
	private JLabel datelbl;
	private JLabel hourlbl;
	private JLabel minutelbl;
	
	// 상점
	private StoreDialog storeFrame = null;
	
	// 프로젝트
	private ProjectDialog projectFrame = null;
	private ProjectEventImpl projectEventImpl = new ProjectEventImpl(this);
	private JLabel nowRatinglbl;
	private JLabel nowProjectlbl;
	private JLabel projectHour;
	private JLabel projectMinute;
	private int nowProjectId = 0;
	private int projectTime;
	
	// 정보
	private JLabel levellbl;
	private JLabel numOfcigalbl;
	
	// progressbar
	private ProgressbarEvent pb = new ProgressbarEvent(this);
	private JProgressBar hpbar;
	private JProgressBar expbar;
	private JProgressBar stressbar;
	private JProgressBar healthbar;
	
	// DB
	private List<UserInfo> userInfoList;
	private List<SkillList> skillList;
	private List<UserSkill> userSkillList;
	private List<Project> projectList;
	private List<UserProject> userProjectList;
	private List<User> userList;
	private List<CigaLog> cigaLogList;
	private List<Rank> userRankList;
	private UserInfo userInfo;
	private Rank userRank;
	private int infoId;
	private int userId;
	private int ciga;
	private int usedCiga;
	private int score;

	public MainFrame(int userId) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gameControllerImpl.timeController();

		ClassLoader classLoader = getClass().getClassLoader();
		URL URLmix = classLoader.getResource("music/mix.wav");
		sound(URLmix);

		setBounds(100, 100, 1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainpnl = new ImagePanel(Methods.converImage(getClass(), "images/back_img/background.png"));
		Mainpnl.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Mainpnl);
		Mainpnl.setLayout(null);

		activeEventImpl.getCharacters().defaultCharacter();
		
		ImageIcon sound = Methods.convertToResizeIcon(getClass(), "images/btn_img/sound.png", 50, 50);
		ImageIcon mute = Methods.convertToResizeIcon(getClass(), "images/btn_img/mute.png", 50, 50);
		soundbtn = new JButton(sound);
		soundbtn.setBounds(978, 28, 50, 50);
		soundbtn.setBackground(new Color(0, 0, 0, 0));
		soundbtn.setOpaque(false);
		soundbtn.setFocusable(false);
		getContentPane().add(soundbtn);
		soundbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (soundbtn.getIcon() == sound) {
					soundbtn.setIcon(mute);
					clip.stop();
				} else if (soundbtn.getIcon() == mute) {
					soundbtn.setIcon(sound);
					clip.start();				
				}
			}
		});

		expbar = new JProgressBar();
		expbar.setValue(20);
		expbar.setStringPainted(true);
		expbar.setForeground(new Color(30, 144, 255));
		expbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		expbar.setBounds(50, 735, 827, 20);
		Mainpnl.add(expbar);

		JLabel lblNewLabel_2 = new JLabel("exp");
		lblNewLabel_2.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		lblNewLabel_2.setBounds(12, 728, 37, 29);
		Mainpnl.add(lblNewLabel_2);

		JPanel date = new JPanel();
		date.setBounds(12, 10, 135, 45);
		Mainpnl.add(date);
		date.setLayout(null);
		date.setOpaque(false);

		datelbl = new JLabel("00일차");
		datelbl.setHorizontalAlignment(SwingConstants.CENTER);
		datelbl.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		datelbl.setBounds(0, 0, 135, 45);
		date.add(datelbl);

		JPanel currentTime = new JPanel();
		currentTime.setBounds(147, 10, 135, 45);
		Mainpnl.add(currentTime);
//		currentTime.setBorder(new LineBorder(Color.BLACK, 2));
		currentTime.setOpaque(false);
		currentTime.setBackground(new Color(255, 0, 0, 0));
		currentTime.setLayout(null);

		hourlbl = new JLabel("07");
		hourlbl.setHorizontalAlignment(SwingConstants.CENTER);

		hourlbl.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		hourlbl.setBounds(0, 0, 60, 45);
		currentTime.add(hourlbl);

		minutelbl = new JLabel("00");
		minutelbl.setHorizontalAlignment(SwingConstants.CENTER);
		minutelbl.setFont(new Font("HY목각파임B", Font.BOLD, 28));
		minutelbl.setBounds(75, 0, 60, 45);
		currentTime.add(minutelbl);

		JLabel colonlbl = new JLabel(":");
		colonlbl.setHorizontalAlignment(SwingConstants.CENTER);
		colonlbl.setFont(new Font("Algerian", Font.BOLD, 30));
		colonlbl.setBounds(60, 0, 15, 45);
		currentTime.add(colonlbl);

		JPanel statuspnl = new JPanel();
		statuspnl.setBounds(12, 608, 877, 114);
		Mainpnl.add(statuspnl);
		statuspnl.setLayout(null);
		statuspnl.setBackground(new Color(255, 255, 255, 100));

		JPanel currentcigapnl = new JPanel();
		currentcigapnl.setBounds(22, 10, 225, 42);
		statuspnl.add(currentcigapnl);
		currentcigapnl.setOpaque(false);
		currentcigapnl.setLayout(null);

		JLabel currentcigalbl = new JLabel("담배  X");
		currentcigalbl.setIcon(Methods.convertToIcon(getClass(), "images/rank_img/ciga.png"));
		
		currentcigalbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		currentcigalbl.setBounds(12, 0, 117, 43);
		currentcigapnl.add(currentcigalbl);

		numOfcigalbl = new JLabel("10");
		numOfcigalbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		numOfcigalbl.setBounds(124, 5, 89, 33);
		currentcigapnl.add(numOfcigalbl);

		JPanel stresspnl = new JPanel();
		stresspnl.setBounds(294, 40, 571, 30);
		statuspnl.add(stresspnl);
		stresspnl.setOpaque(false);
		stresspnl.setLayout(null);

		JLabel stresslbl = new JLabel("스트레스");
		stresslbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		stresslbl.setBounds(12, 5, 64, 22);
		stresspnl.add(stresslbl);

		stressbar = new JProgressBar();
		stressbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		stressbar.setValue(10);
		stressbar.setStringPainted(true);
		stressbar.setForeground(new Color(139, 0, 0));
		stressbar.setBounds(80, 5, 480, 22);
		stresspnl.add(stressbar);

		JPanel developlvpnl = new JPanel();
		developlvpnl.setBounds(22, 62, 225, 42);
		statuspnl.add(developlvpnl);
		developlvpnl.setOpaque(false);
		developlvpnl.setLayout(null);

		JLabel lblNewLabel = new JLabel("개발능력Lv");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 5, 110, 32);
		developlvpnl.add(lblNewLabel);

		levellbl = new JLabel("10");
		levellbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		levellbl.setBounds(124, 5, 89, 33);
		developlvpnl.add(levellbl);

		JPanel healthpnl = new JPanel();
		healthpnl.setLayout(null);
		healthpnl.setOpaque(false);
		healthpnl.setBounds(294, 75, 571, 30);
		statuspnl.add(healthpnl);

		JLabel healthlbl = new JLabel("건강");
		healthlbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		healthlbl.setBounds(12, 5, 54, 22);
		healthpnl.add(healthlbl);

		healthbar = new JProgressBar();
		healthbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		healthbar.setValue(100);
		healthbar.setStringPainted(true);
		healthbar.setForeground(new Color(0, 128, 0));
		healthbar.setBounds(80, 5, 480, 22);
		healthpnl.add(healthbar);

		JPanel hppnl = new JPanel();
		hppnl.setBounds(294, 5, 571, 30);
		statuspnl.add(hppnl);
		hppnl.setOpaque(false);
		hppnl.setBackground(new Color(255, 0, 0, 0));
		hppnl.setLayout(null);

		JLabel hplbl = new JLabel("HP");
		hplbl.setFont(new Font("휴먼편지체", Font.BOLD, 20));
		hplbl.setBounds(12, 5, 57, 22);
		hppnl.add(hplbl);

		hpbar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		hpbar.setFont(new Font("휴먼편지체", Font.PLAIN, 12));
		hpbar.setForeground(Color.RED);
		hpbar.setStringPainted(true);
		hpbar.setValue(100);
		hpbar.setBounds(80, 5, 480, 22);
		hppnl.add(hpbar);

		JButton rankingbtn = new JButton();
		rankingbtn.setBounds(1051, 140, 90, 89);
		rankingbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/rankBtnImage.png"));
		Mainpnl.add(rankingbtn);
		rankingbtn.setBorderPainted(false);
		rankingbtn.setOpaque(false);
		rankingbtn.setBackground(new Color(255, 0, 0, 0));
		rankingbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RankingDialog rankingFrame = new RankingDialog(MainFrame.this.getX(), MainFrame.this.getY(), MainFrame.this);
				gameControllerImpl.getTimerTask().cancel();
				gameControllerImpl.stopProjectTime();
				
				rankingFrame.showGUI();
			}
		});

		JButton settingbtn = new JButton();
		settingbtn.setBounds(1051, 10, 90, 89);
		settingbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/settingBtnImage.png"));
		Mainpnl.add(settingbtn);
		settingbtn.setOpaque(false);
		settingbtn.setBorderPainted(false);
		settingbtn.setBackground(new Color(255, 0, 0, 0));
		settingbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SettingDialog settingFrame = new SettingDialog(MainFrame.this.getX(), MainFrame.this.getY(), MainFrame.this);
				gameControllerImpl.getTimerTask().cancel();
				gameControllerImpl.stopProjectTime();
				settingFrame.showGUI();
				if (settingFrame.getLoginFrame()) {
					gameControllerImpl.getTimerTask().cancel();
					gameControllerImpl.stopProjectTime();
					new LoginFrame();
					dispose();
				}
			}
		});

		JButton storebtn = new JButton();
		storebtn.setBounds(1051, 275, 90, 89);
		storebtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/StoreBtnImage.png"));
		Mainpnl.add(storebtn);
		storebtn.setOpaque(false);
		storebtn.setBackground(new Color(255, 0, 0, 0));
		storebtn.setBorderPainted(false);
		storebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (storeFrame == null) {
					storeFrame = new StoreDialog(MainFrame.this);
				}
				storeFrame.setBounds(MainFrame.this.getX() + 7, MainFrame.this.getY() + 30, 1185, 762);
				gameControllerImpl.getTimerTask().cancel();
				gameControllerImpl.stopProjectTime();
				storeFrame.showGUI();
			}
		});

		JButton gamebtn = new JButton();
		gamebtn.setBounds(1051, 395, 90, 81);
		gamebtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/miniGameBtnImage.png"));
		Mainpnl.add(gamebtn);
		gamebtn.setOpaque(false);
		gamebtn.setBorderPainted(false);
		gamebtn.setBackground(new Color(255, 0, 0, 0));
		gamebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameDialog gameDialog = new GameDialog(MainFrame.this.getX(), MainFrame.this.getY(), MainFrame.this);
				gameControllerImpl.getTimerTask().cancel();
				gameControllerImpl.stopProjectTime();
				gameDialog.showGUI();
			}
		});

		JButton taskbtn = new JButton();
		taskbtn.setHorizontalAlignment(SwingConstants.LEFT);
		taskbtn.setBounds(1042, 525, 99, 81);
		;
		taskbtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/projectBtnImage.png"));
		taskbtn.setOpaque(false);
		taskbtn.setBackground(new Color(255, 0, 0, 0));
		taskbtn.setBorderPainted(false);
		taskbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				projectFrame = new ProjectDialog(MainFrame.this);
				projectFrame.setBounds(MainFrame.this.getX() + 7, MainFrame.this.getY() + 30, 1185, 762);
				gameControllerImpl.getTimerTask().cancel();
				gameControllerImpl.stopProjectTime();
				projectFrame.showGUI();
			}
		});
		Mainpnl.add(taskbtn);

		activitybtn = new JButton();
		activitybtn.setBounds(1058, 633, 83, 89);
		activitybtn.setIcon(Methods.convertToIcon(getClass(), "images/btn_img/activeBtnImage.png"));
		Mainpnl.add(activitybtn);
		activitybtn.setOpaque(false);
		activitybtn.setBorderPainted(false);
		activitybtn.setBackground(new Color(255, 0, 0, 0));
		activitybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ActiveDialog activeFrame = new ActiveDialog(MainFrame.this.getX(), MainFrame.this.getY(),
						activeEventImpl);
				activeFrame.showGUI();
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 50));
		panel.setBounds(12, 207, 263, 137);
		Mainpnl.add(panel);
		panel.setLayout(null);

		JLabel prjectTitlelbl = new JLabel("<현재 진행중인 Project>");
		prjectTitlelbl.setBounds(18, 10, 227, 24);
		prjectTitlelbl.setFont(new Font("HY목각파임B", Font.BOLD, 16));
		panel.add(prjectTitlelbl);

		nowProjectlbl = new JLabel("");
		nowProjectlbl.setFont(new Font("HY엽서L", Font.BOLD, 14));
		nowProjectlbl.setBounds(18, 44, 227, 24);
		panel.add(nowProjectlbl);

		JLabel ratingText = new JLabel("진행률 : ");
		ratingText.setFont(new Font("HY엽서L", Font.BOLD, 14));
		ratingText.setBounds(18, 78, 72, 15);
		panel.add(ratingText);

		nowRatinglbl = new JLabel("0");
		nowRatinglbl.setFont(new Font("HY엽서L", Font.BOLD, 14));
		nowRatinglbl.setHorizontalAlignment(SwingConstants.CENTER);
		nowRatinglbl.setBounds(84, 78, 58, 15);
		panel.add(nowRatinglbl);

		JLabel lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.BOLD, 14));
		lblNewLabel_1.setBounds(154, 78, 21, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("남은 시간: ");
		lblNewLabel_3.setFont(new Font("HY엽서L", Font.BOLD, 14));
		lblNewLabel_3.setBounds(18, 105, 83, 15);
		panel.add(lblNewLabel_3);

		projectHour = new JLabel("00");
		projectHour.setFont(new Font("HY엽서L", Font.BOLD, 14));
		projectHour.setBounds(113, 103, 29, 17);
		panel.add(projectHour);

		JLabel lblNewLabel_4 = new JLabel(":");
		lblNewLabel_4.setFont(new Font("HY엽서L", Font.BOLD, 14));
		lblNewLabel_4.setBounds(143, 103, 11, 15);
		panel.add(lblNewLabel_4);

		projectMinute = new JLabel("00");
		projectMinute.setFont(new Font("HY엽서L", Font.BOLD, 14));
		projectMinute.setBounds(154, 103, 29, 17);
		panel.add(projectMinute);
		
		gameControllerImpl.readyGame(userId);
		gameControllerImpl.applyDB();
		pb.controllPB_default();
	}

	public void showGUI() {
		setVisible(true);
	}

	public void sound(URL file) {
		try {
			AudioInputStream ais1 = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais1);
			clip.start();
			clip.loop(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JButton getActivitybtn() {
		return activitybtn;
	}

	public void stopSound() {
		clip.stop();
		clip.close();
	}

	public JLabel getHourlbl() {
		return hourlbl;
	}

	public JLabel getMinutelbl() {
		return minutelbl;
	}

	public JLabel getDatelbl() {
		return datelbl;
	}

	public JLabel getNowProjectlbl() {
		return nowProjectlbl;
	}

	public JLabel getNowRatinglbl() {
		return nowRatinglbl;
	}

	public JLabel getProjectHour() {
		return projectHour;
	}

	public JLabel getProjectMinute() {
		return projectMinute;
	}

	public JProgressBar getHpbar() {
		return hpbar;
	}

	public JProgressBar getExpbar() {
		return expbar;
	}

	public JProgressBar getStessbar() {
		return stressbar;
	}

	public JProgressBar getHealthbar() {
		return healthbar;
	}

	public ProgressbarEvent getPb() {
		return pb;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List<UserSkill> getUserSkillList() {
		return userSkillList;
	}
	
	public List<SkillList> getSkillList() {
		return skillList;
	}

	public void setUserSkillList(List<UserSkill> userSkillList) {
		this.userSkillList = userSkillList;
	}

	public List<UserProject> getUserProjectList() {
		return userProjectList;
	}

	public void setUserProjectList(List<UserProject> userProjectList) {
		this.userProjectList = userProjectList;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public void setCigaLogList(List<CigaLog> cigaLogList) {
		this.cigaLogList = cigaLogList;
	}

	public JLabel getLevellbl() {
		return levellbl;
	}

	public JLabel getNumOfcigalbl() {
		return numOfcigalbl;
	}

	public int getUsedCiga() {
		return usedCiga;
	}

	public void setUsedCiga(int usedCiga) {
		this.usedCiga = usedCiga;
	}

	public void setSkillList(List<SkillList> skillList) {
		this.skillList = skillList;
	}

	public JProgressBar getStressbar() {
		return stressbar;
	}

	public ProjectEventImpl getProjectEventImpl() {
		return projectEventImpl;
	}
	
	public int getCiga() {
		return ciga;
	}

	public void setCiga(int ciga) {
		this.ciga = ciga;
	}

	public int getNowProjectId() {
		return nowProjectId;
	}

	public void setNowProjectId(int nowProjectId) {
		this.nowProjectId = nowProjectId;
	}
	
	public List<Rank> getUserRankList() {
		return userRankList;
	}

	public void setUserRankList(List<Rank> userRankList) {
		this.userRankList = userRankList;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Rank getUserRank() {
		return userRank;
	}

	public void setUserRank(Rank userRank) {
		this.userRank = userRank;
	}

	public GameControllerImpl getGameControllerImpl() {
		return gameControllerImpl;
	}

	public int getProjectTime() {
		return projectTime;
	}

	public void setProjectTime(int projectTime) {
		this.projectTime = projectTime;
	}
}
