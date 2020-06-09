package com.taskmanager.taskmanager.controller;



import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.taskmanager.taskmanager.entity.Tasks;
import com.taskmanager.taskmanager.entity.Teams;
import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.service.impl.TasksServiceImpl;
import com.taskmanager.taskmanager.service.impl.TeamsServiceImpl;
import com.taskmanager.taskmanager.service.impl.UsersServiceImpl;



@Controller
public class HomeController {
	@Autowired
	private HttpSession httpSession;
	
	private final UsersServiceImpl users_serviceimpl;
	
	private final TeamsServiceImpl teams_serviceimpl;
	
	private final TasksServiceImpl tasks_serviceimpl;

	public HomeController(UsersServiceImpl users_serviceimpl, TeamsServiceImpl teams_serviceimpl,TasksServiceImpl tasks_serviceimpl) {
		this.users_serviceimpl = users_serviceimpl;
		this.teams_serviceimpl=teams_serviceimpl;
		this.tasks_serviceimpl=tasks_serviceimpl;
	}
	

		
		 @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
		    public ModelAndView clientlist() {
			
			 
		        List<Object[]> liste = users_serviceimpl.getUsersList();	
		        ModelAndView model = new ModelAndView("index");
		        model.addObject("liste",liste);
		        return model;
		        
		        
		    }
		 
			
		 @RequestMapping(value = "/userProfile/{userid}", method = RequestMethod.GET)
		    public ModelAndView clientlistdetail(@PathVariable("userid") Integer userid) {
			
			  Users user = new Users();
			
		        
		        
		        if(userid == null) {
		        	return new ModelAndView("redirect:/index");
		        }
		        if(!(userid == null)) {
		        	 user = users_serviceimpl.getUserDetail(userid);		        
			        
		        }
		        ModelAndView model = new ModelAndView("userdetail");
		        model.addObject("user",user);
		      
		        return model;
		        
		        
		    }
		 
		 @RequestMapping(value = "/teams", method = RequestMethod.GET)
		    public ModelAndView teamslist() {
			
			 
		        List<Teams> liste = teams_serviceimpl.getTeamsList();	
		        ModelAndView model = new ModelAndView("teams");
		        model.addObject("liste",liste);
		        return model;
		        
		        
		    }
		 
		 @RequestMapping(value = "/tasks", method = RequestMethod.GET)
		    public ModelAndView taskslist() {
			
			 
		        List<Tasks> liste = tasks_serviceimpl.getTasksList();	
		        ModelAndView model = new ModelAndView("tasks");
		        model.addObject("liste",liste);
		        return model;
		        
		        
		    }
		 
		 
		 
		 
		

}
