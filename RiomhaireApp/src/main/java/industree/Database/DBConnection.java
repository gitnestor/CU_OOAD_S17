package industree.Database;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import industree.Model.*;

public class DBConnection implements IDBConnection {

	private Session beginSession()
	{
		SessionFactory sessionFactory = HibernateInitializer.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		return session;
	}

	@Override
	public industree.Model.User validateLoginUser(String userName, String password) {
		Session session = beginSession();
		String queried = "from User where username = :username and password = :password";
		Query query = session.createQuery(queried);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		List<User> ls = (List<User>)query.list();
		
		if(ls==null || ls.isEmpty())
		{
			return null;
		}
		return ls.get(0);
		
	}
	
	@Override
	public Employee getEmployeeProfile(int userId){
		
		Session session = beginSession();
		String queried="from Employee e where e.userId = :userId";
		Query query = session.createQuery(queried);
		query.setParameter("userId", userId);
		List<Employee> ls = query.list();
		
		if(ls == null || ls.isEmpty())
		{
			return null;
		}
		
		return ls.get(0);
		
	}

	@Override
	public WorkingLineStatus getWorkingMachineLineStatus(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeLeaves> getEmployeeLeaves(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeClaim> getEmployeeClaims(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingLineStatus> getWorkingMachineLinesStatuses(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeLeaves getemployeeLeaves(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeClaims getemployeeClaims(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployeeProfile(Employee employeeProfile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAppliedLeave(EmployeeLeave employeeLeave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAppliedClaim(EmployeeClaim employeeClaim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveApprovedLeaves(List<EmployeeLeave> employeeLeaves) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveApprovedClaims(List<EmployeeClaim> employeeClaims) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> searchForEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> searchForEmployeeByDepartmentAndName(String name, String Department) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
