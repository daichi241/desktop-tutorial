package samplearc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import samplearc.character.BattleCharacter;

public class ArcDao {
	private final String URL = "jdbc:postgresql://localhost:5432/arcDB";
	private final String ID = "sakamotodaichi";
	private final String PASS = "pass";
	public BattleCharacter selectCharacter(int character_id) {
		BattleCharacter battlechar = null;
		String sql = "select character_id,character_name,character_hp,character_attack,character_agile "
				+ "from public.character_table ct "
				+ "where ct.character_id = " + character_id;
		try(Connection conn = DriverManager.getConnection(URL,ID,PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				battlechar = new BattleCharacter(rs.getInt("character_id"));
				battlechar.setName(rs.getString("character_name"));
				battlechar.setHp(rs.getInt("character_hp"));
				battlechar.setAttack(rs.getInt("character_attack"));
				battlechar.setAgile(rs.getInt("character_agile"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return battlechar;
	}
}
