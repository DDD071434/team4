package main.project;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import database.dblist.UserProject;
import main.MainFrame;

public class ProjectEventImpl implements ProjectEvent {
	
	private MainFrame mainFrame;
	private int minutes;
	private int hours;
	private double rate;
	private Timer projectTimer = new Timer();
	private TimerTask projcetTask;
	
	public ProjectEventImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public int searchNowProject(List<UserProject> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isProceeding() && !list.get(i).isComplete()) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void projectTimeControll(int time) {
		minutes = Integer.valueOf(mainFrame.getProjectMinute().getText());
		hours = Integer.valueOf(mainFrame.getProjectHour().getText());
		rate = Double.valueOf(mainFrame.getNowRatinglbl().getText());
		
	    projcetTask = new TimerTask() {
			@Override
			public void run() {
				
				if (hours == 0 && minutes == 0) {
					projectTimer.cancel();
				} else if (minutes == 0) {
					hours--;
					minutes = 59;
				} else {
					minutes--;
				}
				rate = 100 - ((double)(hours * 60 + minutes) / (time * 60)) * 100;
				updateTime(minutes, hours, rate);
			}
	    };
		projectTimer.scheduleAtFixedRate(projcetTask, 1, 250);
	}
	
	private void updateTime(int minutes, int hours, double rate) {
		mainFrame.getProjectHour().setText(String.format("%02d", hours));
		mainFrame.getProjectMinute().setText(String.format("%02d", minutes));
		if (rate >= 100.0) {
			mainFrame.getNowRatinglbl().setText("완료");
			projectTimer.cancel();
		} else {
			mainFrame.getNowRatinglbl().setText(String.format("%.02f", rate));
		}
		mainFrame.revalidate();
		mainFrame.repaint();		
    }

	public Timer getProjectTimer() {
		return projectTimer;
	}

	public TimerTask getProjcetTask() {
		return projcetTask;
	}
}
