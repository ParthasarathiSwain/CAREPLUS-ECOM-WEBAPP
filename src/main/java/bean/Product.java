package bean;

public class Product {
	private int  pid;
	private String  pname;
	private String  pdesc;
	private String  imgName;
	private int  availability;
	private double  price;
	private String  manufDate;
	private String  expDate;
	private String  createdDate;
	private String  updatedDate;
	private String  status;
	private int  catId;
	private int  comId;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufDate() {
		return manufDate;
	}
	public void setManufDate(String manufDate) {
		this.manufDate = manufDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", imgName=" + imgName
				+ ", availability=" + availability + ", price=" + price + ", manufDate=" + manufDate + ", expDate="
				+ expDate + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", status=" + status
				+ ", catId=" + catId + ", comId=" + comId + "]";
	}
	
}
 