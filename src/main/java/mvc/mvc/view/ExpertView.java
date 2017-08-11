package mvc.mvc.view;

import java.util.List;

import mvc.mvc.model.dto.Expert;

public class ExpertView {
	
	public ExpertView(){
	}
	
	public void updateExpertView(Expert expert){
		System.out.println(expert);
	}
	
	public void updateAllExperts(List<Expert> list){
		list.forEach(expert-> {
			System.out.println("------------------");
			System.out.println("Id ->" +expert.getId());
			System.out.println("Name ->" +expert.getName());
			System.out.println("Gender ->" +expert.getGender());
			System.out.println("Skill ->" +expert.getSkill());
			System.out.println("Personal Information ->" +expert.getPersonalInfo());
		});
	}
}
