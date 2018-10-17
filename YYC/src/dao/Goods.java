package dao;

public class Goods {

	private String name;
	private String pic;
	private String introduce;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", pic=" + pic + ", introduce=" + introduce + "]";
	}
	
}
