package industree.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import industree.Database.DBConnection;
import industree.Model.Employee;
import industree.Model.User;



@Controller
@RequestMapping("/")
public class HomeController {

	private DBConnection dbConnection;
	
	public HomeController()
	{
		dbConnection=new DBConnection();
	}
	
	@GetMapping("/home")
	public String home(Model model)
	{
		return "homePage";
	}
	
	@GetMapping("/login")
	public String login(Model model) 
	{
		return "loginPage";
	}
	
	@RequestMapping(value="processCredentials", method = RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String userName, @RequestParam("password")String password) {
		
		User user = dbConnection.validateLoginUser(userName, password);
		Employee employee=new Employee();
		if(user!=null)
		{
			employee=dbConnection.getEmployeeProfile(user.getUserId());
			return new ModelAndView("userProfilePage","employee", employee);
		}
		else
		{
			return new ModelAndView("loginPage", "message", "Invalid UserName or Password. Please try again!");
		}
	}
	
}
