package staff.model;

public class Schedule {

	private int scheduleid;
	private String scheduledate;
	
	private int prayerid;
	private Prayer prayer;
	
	private int imamid;
	private int bilalid;
	private Staff staff;
	
	private int adminid;
	
	public Schedule() {
		
	}
	
	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}
	
	public int getScheduleid() {
		return scheduleid;
	}
	
	public void setScheduledate(String scheduledate) {
		this.scheduledate = scheduledate;
	}
	
	public String getScheduledate() {
		return scheduledate;
	}

	


	public int getPrayerid() {
		return prayerid;
	}

	public void setPrayerid(int prayerid) {
		this.prayerid = prayerid;
	}

	public Prayer getPrayer() {
		return prayer;
	}

	public void setPrayer(Prayer prayer) {
		this.prayer = prayer;
	}


	public int getImamid() {
		return imamid;
	}

	public void setImamid(int imamid) {
		this.imamid = imamid;
	}

	public int getBilalid() {
		return bilalid;
	}

	public void setBilalid(int bilalid) {
		this.bilalid = bilalid;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	
	
}
