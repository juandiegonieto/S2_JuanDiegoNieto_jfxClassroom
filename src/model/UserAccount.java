package model;

public class UserAccount {
	
	private String name;
	private String password;
	private String gender;
	private String career;	
	private String birthday;
	private String favBrowser;
	
	public UserAccount(String name, String password, String gender, String career, String birthday, String favBrowser) {
		this.name = name;
		this.setPassword(password);
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.favBrowser = favBrowser;
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
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getFavBrowser() {
		return favBrowser;
	}
	public void setFavBrowser(String favBrowser) {
		this.favBrowser = favBrowser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
