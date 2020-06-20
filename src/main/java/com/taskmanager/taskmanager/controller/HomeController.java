package com.taskmanager.taskmanager.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.taskmanager.taskmanager.entity.Projects;
import com.taskmanager.taskmanager.entity.Tasks;
import com.taskmanager.taskmanager.entity.Teams;
import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.service.impl.ProjectsServiceImpl;
import com.taskmanager.taskmanager.service.impl.TasksServiceImpl;
import com.taskmanager.taskmanager.service.impl.TeamsServiceImpl;
import com.taskmanager.taskmanager.service.impl.UsersServiceImpl;



@RestController
public class HomeController {
	
	
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private final UsersServiceImpl users_serviceimpl;
	
	@Autowired
	private final TeamsServiceImpl teams_serviceimpl;
	
	@Autowired
	private final TasksServiceImpl tasks_serviceimpl;
	
	@Autowired
	private final ProjectsServiceImpl projects_serviceimpl;
	
	

	public HomeController(UsersServiceImpl users_serviceimpl, TeamsServiceImpl teams_serviceimpl,TasksServiceImpl tasks_serviceimpl,ProjectsServiceImpl projects_serviceimpl) {
		this.users_serviceimpl = users_serviceimpl;
		this.teams_serviceimpl=teams_serviceimpl;
		this.tasks_serviceimpl=tasks_serviceimpl;
		this.projects_serviceimpl=projects_serviceimpl;
	}
	

		
	
	 @RequestMapping(value = {"/getAllUsers","/"}, method = RequestMethod.GET)
	    public List<Object[]> getAllUsers() {
		
		 
	        List<Object[]> liste = users_serviceimpl.getUsersList();	
	       
	        return liste;
	        
	    }
	  
		 @RequestMapping(value = "/userProfile/{userid}", method = RequestMethod.GET)
		 public Users clientlistdetail(@PathVariable("userid") Integer userid) {
			 Users liste = users_serviceimpl.getUserDetail(userid);	
			 return liste;
		 }
		
		

		    @RequestMapping(value="/addUsers",method = RequestMethod.POST)
		    public String addUserPost(@RequestBody Users users) {

		        Users user = new Users();
		        user.setName(users.getName());
		        user.setSurname(users.getSurname());
		        user.setUser_name(users.getUser_name());
		        user.setPassword(users.getPassword());
		        user.setBirthday(users.getBirthday());
		        user.setCreate_date(users.getCreate_date());
		        user.setColor_theme(users.getColor_theme());
		        user.setEmail(users.getEmail());
		        user.setPhone(users.getPhone());
		        user.setRole(users.getRole());
		        user.setSkype_name(users.getSkype_name());
		        user.setSrc(users.getSrc());
		        user.setStatus_id(users.getStatus_id());
		        user.setDepartment_id(users.getDepartment_id());
		        
		
		     
		        try {
		            users_serviceimpl.addUsers(users);
	                return "ok";
	            }catch(Exception ex){
		            return "error";
	            }
		    }
		 
		 
		 
		
		    @RequestMapping(value="/deleteUsers/{id}",method = RequestMethod.DELETE)
		    public String delete(@PathVariable Integer id){
		        try {
		    	    users_serviceimpl.delete(id);
		            return "ok";
		        }catch(Exception ex) {
		        	return "error";
		        }
		    }
		   
		    
           
            @RequestMapping(value="/editusers/{id}",method= RequestMethod.POST)
		    public String updateUsers(@PathVariable Integer id,@RequestBody Users usr, Model m){
            	Users users = users_serviceimpl.getById(id);
		        
		        users.setName(usr.getName());
		        users.setSurname(usr.getSurname());
		        users.setUser_name(usr.getUser_name());
		        users.setPassword(usr.getPassword());
		        users.setBirthday(usr.getBirthday());
		        users.setCreate_date(usr.getCreate_date());
		        users.setColor_theme(usr.getColor_theme());
		        users.setEmail(usr.getEmail());
		        users.setPhone(usr.getPhone());
		        users.setRole(usr.getRole());
		        users.setSkype_name(usr.getSkype_name());
		        users.setSrc(usr.getSrc());
		        users.setStatus_id(usr.getStatus_id());
		        users.setDepartment_id(usr.getDepartment_id());
		        
		        
		        users_serviceimpl.update(users);
		        //m.addAttribute("command",users);
		        return "ok";
		    }
          
		 @RequestMapping(value = {"/getAllProjects","/"}, method = RequestMethod.GET)
		    public List<Object[]> getAllProjects() {
			
			 
		        List<Object[]> liste = projects_serviceimpl.getProjectsList();	
		       
		        return liste;
		        
		    }
		    @RequestMapping(value = "/projectProfile/{id}", method = RequestMethod.GET)
			 public Projects projectlistdetail(@PathVariable("id") Integer id) {
				 Projects liste = projects_serviceimpl.getProjectsDetail(id);	
				 return liste;
			 }
		    
		    

		  @RequestMapping(value="/addProjects",method = RequestMethod.POST)
		     public String addProjectsPost(@RequestBody Projects projects) {

		        Projects project = new Projects();
		        
		        project.setName(projects.getName());
		        project.setStart_date(projects.getStart_date());
		        project.setCreated_by(projects.getCreated_by());
		        project.setCreated_time(projects.getCreated_time());
		        project.setDeadline_hour(projects.getDeadline_hour());
		        project.setEnd_date(projects.getEnd_date());
		        project.setNotes(projects.getNotes());
		        project.setPriority_id(projects.getPriority_id());
		        project.setTeam_id(projects.getTeam_id());
		
		     
		        try {
		            projects_serviceimpl.addProjects(projects);
	                return "ok";
	            }catch(Exception ex){
		            return "error";
	            }
		    }  
		  
		  @RequestMapping(value="/editProjects/{id}",method=RequestMethod.POST)
		  public String updateProjects(@PathVariable Integer id, @RequestBody Projects prj, Model m) {
			  Projects projects = projects_serviceimpl.getById(id);
			  projects.setName(prj.getName());
			  projects.setStart_date(prj.getStart_date());
			  projects.setCreated_by(prj.getCreated_by());
			  projects.setCreated_time(prj.getCreated_time());
			  projects.setDeadline_hour(prj.getDeadline_hour());
			  projects.setEnd_date(prj.getEnd_date());
			  projects.setNotes(prj.getNotes());
			  projects.setPriority_id(prj.getPriority_id());
			  projects.setTeam_id(prj.getTeam_id());
			  projects_serviceimpl.update(projects);
			  return "ok";
		  }
		 
		  @RequestMapping(value="/deleteProjects/{id}",method = RequestMethod.DELETE)
		    public String deleteProjects(@PathVariable Integer id){
		        try {
		    	    projects_serviceimpl.delete(id);
		            return "ok";
		        }catch(Exception ex) {
		        	return "error";
		        }
		    }
		  
		  
		  @RequestMapping(value="/getTeamsList",method = RequestMethod.GET)
			 public List<Teams> getTeamsList(){
				 List<Teams> liste = teams_serviceimpl.getTeamsList();	
			       
			        return liste;
			 }
		  
		  @RequestMapping(value = "/getTasksList",method = RequestMethod.GET)
			 public List<Object[]> getTasksList(){
				 List<Object[]> liste = tasks_serviceimpl.getTasksList();
				 return liste;
			 }
			 
		
}
