package staff.model;

public class Reschedule {
	
	private int rescheduleid;
	private String rescheduledate;
	
	private int staffid;
	private Staff staff;
	
	private int scheduleid;
	private Schedule schedule;
	
	private int rescheduleprayerid;
	private Prayer prayer;
	

	public int getRescheduleid() {
		return rescheduleid;
	}

	public void setRescheduleid(int rescheduleid) {
		this.rescheduleid = rescheduleid;
	}

	public int getStaffID() {
		return staffid;
	}

	public void setStaffID(int staffid) {
		this.staffid = staffid;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getRescheduleprayerid() {
		return rescheduleprayerid;
	}

	public void setRescheduleprayerid(int rescheduleprayerid) {
		this.rescheduleprayerid = rescheduleprayerid;
	}


	public String getRescheduledate() {
		return rescheduledate;
	}

	public void setRescheduledate(String rescheduledate) {
		this.rescheduledate = rescheduledate;
	}

	public Prayer getPrayer() {
		return prayer;
	}

	public void setPrayer(Prayer prayer) {
		this.prayer = prayer;
	}
	
	
}