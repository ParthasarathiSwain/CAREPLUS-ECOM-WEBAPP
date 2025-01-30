package bean;

public class Category {
	private int catId;
	private String catName;
	//setter & getter
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + "]";
	}
	
}
