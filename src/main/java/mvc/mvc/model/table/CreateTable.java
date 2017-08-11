package mvc.mvc.model.table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;

import mvc.mvc.configuration.datasource.Database;
import mvc.mvc.model.dto.Expert;

public class CreateTable {

	public static void createExpertTable(Expert expert){
		Connection conn=null;
		Statement stm=null;
		try{
			
			conn=Database.getInstance().getConnection();
			Field[] fields=expert.getClass().getDeclaredFields();
			for(Field field:fields){
				field.setAccessible(true);
				System.out.println(field.getName());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public String[] getJavaObjectFieldAsString(Object object){
		String [] stringFields=null;
		
		Field[] fields=object.getClass().getDeclaredFields();
		
		for(Field field:fields){
			field.setAccessible(true);
			System.out.println(field.getName());
		}
		
		return null;
	}
}
