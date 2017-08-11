package mvc.mvc.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import mvc.mvc.configuration.datasource.Database;
import mvc.mvc.model.dto.Expert;import sun.security.util.PropertyExpander.ExpandException;

public class ExpertDao {

	public boolean createExpert(Expert expert){
		String sql="INSERT INTO expert(name,gender,skill,country,personal_info)"
				+ "values("
				+ expert.getName()+","
				+ expert.getGender()+","
				+ expert.getSkill()+","
				+ expert.getCountry()+","
				+ expert.getPersonalInfo()
				+ ");";
	
		Connection conn=null;
		Statement stm=null;
		int effected=0;
		boolean rt=false;
		try{
			conn=Database.getInstance().getConnection();
			stm=conn.createStatement();
			effected=stm.executeUpdate(sql);
			if(effected>0){
				rt=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rt;
	}
	
	public boolean editExpert(Expert expert){
		Connection conn=null;
		PreparedStatement  pstm=null;
		int effected=0;
		boolean rt=false;
		String sql="UPDATE expert SET "
				+ "name=COALESCE(?, name) ,"
				+ "gender=COALESCE(?,gender),"
				+ "skill=COALESCE(?,skill),"
				+ "country=COALESCE(?,country),"
				+ "personal_info=COALESCE(?,personal_info) where id =?;";
		
		try{
			conn=Database.getInstance().getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, expert.getName());
			pstm.setString(2, expert.getGender());
			pstm.setString(3, expert.getSkill());
			pstm.setString(4, expert.getCountry());
			pstm.setString(5, expert.getPersonalInfo());
			pstm.setInt(6, expert.getId());
			
			effected=pstm.executeUpdate();
			if(effected>0) rt=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rt;
	}
	
	public List<Expert> getExperts(){
		PreparedStatement pstm=null;
		ResultSet resultSet=null;
		Connection conn=null;
		List<Expert> list=new ArrayList<Expert>();
		try{
			conn=Database.getInstance().getConnection();
			pstm=conn.prepareStatement("select * from  f_get_experts();");
		
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				Expert expert=new Expert();
				expert.setId(resultSet.getInt("id"));
				expert.setName(resultSet.getString("name"));
				expert.setGender(resultSet.getString("gender"));
				expert.setSkill(resultSet.getString("skill"));
				expert.setCountry(resultSet.getString("country"));
				expert.setPersonalInfo(resultSet.getString("personal_info"));
				list.add(expert);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Expert getExpert(int id){
		PreparedStatement pstm=null;
		ResultSet resultSet=null;
		Connection conn=null;
		Expert expert=new Expert();
		try{
			conn=Database.getInstance().getConnection();
			pstm=conn.prepareStatement("select * from f_get_expert(?);");
			pstm.setInt(1, id);
			resultSet=pstm.executeQuery();
			while(resultSet.next()){
				expert.setId(resultSet.getInt("id"));
				expert.setName(resultSet.getString("name"));
				expert.setGender(resultSet.getString("gender"));
				expert.setSkill(resultSet.getString("skill"));
				expert.setCountry(resultSet.getString("country"));
				expert.setPersonalInfo(resultSet.getString("personal_info"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return expert;
	}
}
