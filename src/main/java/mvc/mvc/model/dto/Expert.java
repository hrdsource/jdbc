package mvc.mvc.model.dto;

public class Expert {
	private int id;
	private String name;
	private String gender;
	private String skill;
	private String country;
	private String personalInfo;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	@Override
	public String toString() {
		return "Expert [id=" + id + ", name=" + name + ", gender=" + gender + ", skill=" + skill + ", country="
				+ country + ", personalInfo=" + personalInfo + "]";
	}
	
}
