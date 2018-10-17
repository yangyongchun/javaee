package dao;

public class Emp {
	private String username;
	private String password;
	private String createTime;
	private int power;
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Emp [username=" + username + ", password=" + password + ", createTime=" + createTime + ", power="
				+ power + "]";
	}

}
