package progressbar;

import java.util.Timer;
import java.util.TimerTask;

import gui.DeathDialog;
import main.MainFrame;

public class ProgressbarEvent {
	
	MainFrame mainFrame;
	Timer timeHp = null;
	Timer timeStress = null;
	Timer timeHealth = null;
	
	private int hp;
	private int stress;
	private int health;
	private TimerTask hpTask;

	public ProgressbarEvent(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void controllPB_default() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 20000 + (level * 500) + (energydrink * 100) + (bed * 100);
		int speedStress = 8000 + (level * 500) + (energydrink * 100) + (bed * 100);
		int speedHealth = 10000 + (level * 500) + (energydrink * 100) + (bed * 100);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarDecreas(speedHp);
		stressbarIncrease(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_ciga() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
		
		int speedHp = 15000 + (level * 500) + (energydrink * 100) + (bed * 100) + (elecciga * 150);
		int speedStress = 6000 - (level * 500) - (energydrink * 100) - (bed * 100) - (elecciga * 300);
		int speedHealth = 7500 + (level * 500) + (energydrink * 100) + (bed * 100) + (elecciga * 150);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarDecreas(speedHp);
		stressbarDecreas(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_coupang() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
								
		int speedHp = 10000 + (level * 500) + (energydrink * 100) + (bed * 100);
		int speedStress = 4000 + (level * 500) + (energydrink * 100) + (bed * 100);
		int speedHealth = 5000 + (level * 500) + (energydrink * 100) + (bed * 100);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarDecreas(speedHp);
		stressbarIncrease(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_game() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 15000 + (level * 500) + (energydrink * 100) + (bed * 100) + (elecciga * 100) + (computer * 300);
		int speedStress = 6000 - (level * 500) - (energydrink * 100) - (bed * 100) - (elecciga * 100) - (computer * 300);
		int speedHealth = 7500 + (level * 500) + (energydrink * 100) + (bed * 100) + (elecciga * 100) + (computer * 300);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarDecreas(speedHp);
		stressbarDecreas(speedStress);
		healthbarDecreas(speedHealth);
	}
	
	public void controllPB_sleep() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 10000 - (level * 500) - (bed * 300);
		int speedStress = 4000 - (level * 500) - (bed * 300);
		int speedHealth = 5000 - (level * 500) - (bed * 300);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarIncrease(speedHp);
		stressbarDecreas(speedStress);
		healthbarIncrease(speedHealth);
	}
	
	public void controllPB_eat() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
					
		int speedHp = 10000 - (level * 500) - (energydrink * 100) - (bed * 100);
		int speedStress = 8000 - (level * 500) - (energydrink * 100) - (bed * 100);
		int speedHealth = 5000 - (level * 500) - (energydrink * 100) - (bed * 100);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarIncrease(speedHp);
		stressbarDecreas(speedStress);
		healthbarIncrease(speedHealth);
	}
	
	public void controllPB_resume() {
		int level = mainFrame.getUserInfo().getLevel();
		int bed = mainFrame.getUserSkillList().get(0).getSkillLevel();
		int energydrink = mainFrame.getUserSkillList().get(1).getSkillLevel();
		int computer = mainFrame.getUserSkillList().get(2).getSkillLevel();
		int elecciga = mainFrame.getUserSkillList().get(3).getSkillLevel();
		int mac = mainFrame.getUserSkillList().get(4).getSkillLevel();
						
		int speedHp = 15000 + (level * 500) + (energydrink * 100) + (bed * 100) + (mac * 150);
		int speedStress = 6000 - (level * 500) - (energydrink * 100) - (bed * 100) - (mac * 300);
		int speedHealth = 7500 + (level * 500) + (energydrink * 100) + (bed * 100) + (mac * 150);
		
		if (speedHp < 250) {
			speedHp = 250;
		}
		if (speedStress < 250) {
			speedStress = 250;
		}
		if (speedHealth < 250) {
			speedHealth = 250;
		}
		
		hpbarDecreas(speedHp);
		stressbarIncrease(speedStress);
		healthbarDecreas(speedHealth);
	}
	

	private void hpbarDecreas(int speed) {
		if (timeHp != null) {
			timeHp.cancel();
		}
		timeHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		hpTask = new TimerTask() {
			@Override
			public void run() {
				if (hp <= 0) {
					System.out.println("you die");
					DeathDialog deathDialog = new DeathDialog(mainFrame.getX(), mainFrame.getY(), mainFrame);
					deathDialog.showGUI();
				} else if (hp > 0) {
					hp--;
				}
				mainFrame.getHpbar().setValue(hp);
			}
		};
		timeHp.scheduleAtFixedRate(hpTask, 0, speed);		
	}
	
	private void hpbarIncrease(int speed) {
		if (timeHp != null) {
			timeHp.cancel();
		}
		timeHp = new Timer();
		hp = mainFrame.getHpbar().getValue();
		TimerTask hpTask = new TimerTask() {
			@Override
			public void run() {
				if (hp == 0) {
					System.out.println("you die");
					DeathDialog deathDialog = new DeathDialog(mainFrame.getX(), mainFrame.getY(), mainFrame);
					deathDialog.showGUI();
				}
				if (hp < 100){
					hp++;
				}
				mainFrame.getHpbar().setValue(hp);
			}
		};
		timeHp.scheduleAtFixedRate(hpTask, 0, speed);		
	}	
	
	private void stressbarDecreas(int speed) {
		if (timeStress != null) {
			timeStress.cancel();
		}
		timeStress = new Timer();
		stress = mainFrame.getStessbar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				if (stress == 0) {
					System.out.println("you are happy");
				} else if (stress > 0) {
					stress--;
				}
				mainFrame.getStessbar().setValue(stress);
			}
		};
		timeStress.scheduleAtFixedRate(stressTask, 0, speed);		
	}
	
	private void stressbarIncrease(int speed) {
		if (timeStress != null) {
			timeStress.cancel();
		}
		timeStress = new Timer();
		stress = mainFrame.getStessbar().getValue();
		TimerTask stressTask = new TimerTask() {
			@Override
			public void run() {
				if (stress < 100) {
					stress++;
				}
				mainFrame.getStessbar().setValue(stress);
			}
		};
		timeStress.scheduleAtFixedRate(stressTask, 0, speed);		
	}		
	
	private void healthbarDecreas(int speed) {
		if (timeHealth != null) {
			timeHealth.cancel();
		}
		timeHealth = new Timer();
		health = mainFrame.getHealthbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
				if (health == 0) {
					System.out.println("you are ill");
				} else if (health > 0) {
					health--;
				}
				mainFrame.getHealthbar().setValue(health);
			}
		};
		timeHealth.scheduleAtFixedRate(healthTask, 0, speed);		
	}
	
	private void healthbarIncrease(int speed) {
		if (timeHealth != null) {
			timeHealth.cancel();
		}
		timeHealth = new Timer();
		health = mainFrame.getHealthbar().getValue();
		TimerTask healthTask = new TimerTask() {
			@Override
			public void run() {
				if (health < 100) {
					health++;
				}
				mainFrame.getHealthbar().setValue(health);
			}
		};
		timeHealth.scheduleAtFixedRate(healthTask, 0, speed);		
	}

	public Timer getTimeHp() {
		return timeHp;
	}

	public Timer getTimeStress() {
		return timeStress;
	}

	public Timer getTimeHealth() {
		return timeHealth;
	}	
	
	
}