package industree.Database;

import java.util.List;

import industree.Model.*;


public interface IDBConnection {

	public User validateLoginUser(String userName, String password);
	public Employee getEmployeeProfile(int userId);
	public WorkingLineStatus getWorkingMachineLineStatus(int userId);
	public List<EmployeeLeaves> getEmployeeLeaves(int employeeId);
	public List<EmployeeClaim> getEmployeeClaims(int employeeId);
	public List<WorkingLineStatus> getWorkingMachineLinesStatuses(int employeeId);
	public EmployeeLeaves getemployeeLeaves(int employeeId);
	public EmployeeClaims getemployeeClaims(int employeeId);
	public void saveEmployeeProfile(Employee employeeProfile);
	public void saveAppliedLeave(EmployeeLeave employeeLeave);
	public void saveAppliedClaim(EmployeeClaim employeeClaim);
	public void saveApprovedLeaves(List<EmployeeLeave> employeeLeaves);
	public void saveApprovedClaims(List<EmployeeClaim> employeeClaims);
	public List<Employee> searchForEmployeeByName(String name);
	public List<Employee> searchForEmployeeByDepartmentAndName(String name, String Department);
	
}
