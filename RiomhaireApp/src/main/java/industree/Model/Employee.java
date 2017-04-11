package industree.Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import industree.Common.Constants.Departments;
import industree.Common.Constants.Positions;

@Entity
@Table(name="Employee_tbl")
public class Employee {

	@Id
	@Column(name="employeeId")
	private String employeeId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="position")
	private String position;
	
	@Enumerated
	@Transient
	private Positions standardPosition;
	
	@Column(name="workemailAddress")
	private String workemailAddress;
	
	@Column(name="dateOfJoining")
	private Date dateOfJoining;
	
	@Column(name="workContact")
	private String workContact;
	
	@Column(name="department")
	private String department;
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWorkemailAddress() {
		return workemailAddress;
	}
	public void setWorkemailAddress(String workemailAddress) {
		this.workemailAddress = workemailAddress;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name="managerId")
	private int managerId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailAddress() {
		return workemailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.workemailAddress = emailAddress;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getWorkContact() {
		return workContact;
	}
	public void setWorkContact(String workContact) {
		this.workContact = workContact;
	}
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	@Transient
	protected static List<String> menuItems;	
	
	public List<String> getMenuItems()
	{
		return this.menuItems;
	}
	
	public void setMenuItems(List<String> menuItems)
	{
		this.menuItems=menuItems;
	}
	
	public Employee()
	{
		this.setDesignation("FactoryEmployee");
		this.menuItems=new ArrayList<String>();
		menuItems.add("Dashboard");
		menuItems.add("Employee Search");
		menuItems.add("My Line");
		menuItems.add("My Leaves & Claims");
	}
	
}
