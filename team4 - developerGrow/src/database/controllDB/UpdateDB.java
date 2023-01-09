package database.controllDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import database.dblist.UserInfo;
import database.dblist.UserProject;
import database.dblist.UserSkill;
import database.util.ConnectionProvider;

public class UpdateDB {
	
	public int[] updateUserInfo(UserInfo userInfo) {
		String sql = "UPDATE userInfo SET date =?, time = ?, level = ?, exp = ?"
				+ ", hp = ?, health = ?, stress = ?, ciga = ?, usedCiga = ?, gameover = ? "
				+ "WHERE userId = ? AND infoId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, userInfo.getDate());
				stmt.setInt(2, userInfo.getTime());
				stmt.setInt(3, userInfo.getLevel());
				stmt.setInt(4, userInfo.getExp());
				stmt.setInt(5, userInfo.getHp());
				stmt.setInt(6, userInfo.getHealth());
				stmt.setInt(7, userInfo.getStress());
				stmt.setInt(8, userInfo.getCiga());
				stmt.setInt(9, userInfo.getUsedCiga());
				stmt.setBoolean(10, userInfo.isGameover());
				stmt.setInt(11, userInfo.getUserId());
				stmt.setInt(12, userInfo.getInfoId());
				
				stmt.addBatch();
			
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int[] updateUserProject(List<UserProject> list) {
		String sql = "UPDATE userProject SET proceeding = ?, complete = ?, lastHour = ?, lastMin = ? WHERE userId = ? AND infoId = ? AND projectId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserProject elem : list) {
				stmt.setBoolean(1, elem.isProceeding());
				stmt.setBoolean(2, elem.isComplete());
				stmt.setInt(3, elem.getLastHour());
				stmt.setInt(4, elem.getLastMin());
				stmt.setInt(5, elem.getUserId());
				stmt.setInt(6, elem.getInfoId());
				stmt.setInt(7, elem.getProjectId());
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int[] updateUserSkill(List<UserSkill> list) {
		String sql = "UPDATE userSkill SET skillLevel = ? WHERE userId = ? AND infoId = ? AND skillId = ?";
		try (Connection conn = ConnectionProvider.makeConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (UserSkill elem : list) {
				stmt.setInt(1, elem.getSkillLevel());
				stmt.setInt(2, elem.getUserId());
				stmt.setInt(3, elem.getInfoId());
				stmt.setInt(4, elem.getSkillId());
				
				stmt.addBatch();
			}
			return stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
