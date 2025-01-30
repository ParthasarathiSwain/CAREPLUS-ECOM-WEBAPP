package bean;

public class Company {
	private int comId;
	private String comName;
	private String comEmail;
	private String comPass;
	private String comPhone;
	private String comAdd;
	private String createdDate;
	private String updatedDate;
	private String status;
	
	
	public String getComEmail() {
		return comEmail;
	}
	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}
	public String getComPass() {
		return comPass;
	}
	public void setComPass(String comPass) {
		this.comPass = comPass;
	}
	public String getComPhone() {
		return comPhone;
	}
	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}
	public String getComAdd() {
		return comAdd;
	}
	public void setComAdd(String comAdd) {
		this.comAdd = comAdd;
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
	//getter & setter
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	@Override
	public String toString() {
		return "Company [comId=" + comId + ", comName=" + comName + ", comEmail=" + comEmail + ", comPass=" + comPass
				+ ", comPhone=" + comPhone + ", comAdd=" + comAdd + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", status=" + status + "]";
	}
	
}
