package com.taskmanager.taskmanager.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.taskmanager.taskmanager.entity.Role;
import com.taskmanager.taskmanager.payload.UserRequest;
import com.taskmanager.taskmanager.service.ProjectsService;
import com.taskmanager.taskmanager.service.RoleService;
import com.taskmanager.taskmanager.service.TasksService;
import com.taskmanager.taskmanager.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.entity.Projects;
import com.taskmanager.taskmanager.entity.Tasks;
import com.taskmanager.taskmanager.entity.Users;


@RestController
public class HomeController {


    @Autowired
    private HttpSession httpSession;

    @Autowired
    private final UsersService usersService;

    @Autowired
    private final ProjectsService projectsService;

    @Autowired
    private final TasksService tasksService;

    @Autowired
    private final RoleService roleService;

    public HomeController(UsersService usersService, ProjectsService projectsService, TasksService tasksService, RoleService roleService) {
        this.usersService = usersService;
        this.projectsService = projectsService;
        this.tasksService = tasksService;
        this.roleService = roleService;
    }


    @RequestMapping(value = {"/getAllUsers"}, method = RequestMethod.GET)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'MANAGER')")
    public List<Object[]> getAllUsers() {

        List<Object[]> usersList = usersService.getUsersList();

        return usersList;

    }

    @RequestMapping(value = "/userProfile/{userid}", method = RequestMethod.GET)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'USER')")
    public Users clientlistdetail(@PathVariable("userid") Long userid) {
        Users usersList = usersService.getUserDetail(userid);
        return usersList;
    }


    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String addUserPost(@RequestBody UserRequest users) {

        Users user = new Users();
        user.setName(users.getName());
        user.setSurname(users.getSurname());
        user.setUsername(users.getUsername());
        user.setPassword(users.getPassword());
        user.setEmail(users.getEmail());

        try {
            usersService.addUsers(user);
            return "ok";
        } catch (Exception ex) {
            return "error";
        }
    }


    @RequestMapping(value = "/deleteUsers/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String delete(@PathVariable Long id) {
        try {
            usersService.delete(id);
            return "ok";
        } catch (Exception ex) {
            return "error";
        }
    }


    @RequestMapping(value = "/editusers/{id}", method = RequestMethod.POST)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'USER')")
    public String updateUsers(@PathVariable Long id, @RequestBody UserRequest usr, Model m) {
        Users users = usersService.getById(id);

        users.setName(usr.getName());
        users.setSurname(usr.getSurname());
        users.setUsername(usr.getUsername());
        users.setPassword(usr.getPassword());
        users.setEmail(usr.getEmail());
        usersService.update(users);

        return "ok";
    }

    @RequestMapping(value = {"/getAllProjects"}, method = RequestMethod.GET)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'MANAGER')")
    public List<Object[]> getAllProjects() {
   

        List<Object[]> usersList = projectsService.getProjectsList();

        return usersList;

    }

    @RequestMapping(value = "/projectProfile/{id}", method = RequestMethod.GET)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'USER')")
    public Projects projectlistdetail(@PathVariable("id") Integer id) {
        Projects projects = projectsService.getProjectsDetail(id);
        return projects;
    }


    @RequestMapping(value = "/addProjects", method = RequestMethod.POST)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String addProjectsPost(@RequestBody Projects projects) {

        Projects project = new Projects();

        project.setName(projects.getName());
        project.setAuthor_id(projects.getAuthor_id());
        project.setDescription(projects.getDescription());
        project.setStart_date(projects.getStart_date());
        project.setEnd_date(projects.getEnd_date());

        try {
            projectsService.addProjects(projects);
            return "ok";
        } catch (Exception ex) {
            return "error";
        }
    }

    @RequestMapping(value = "/editProjects/{id}", method = RequestMethod.POST)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String updateProjects(@PathVariable Integer id, @RequestBody Projects prj, Model m) {
        Projects projects = projectsService.getById(id);
        projects.setName(prj.getName());
        projects.setAuthor_id(prj.getAuthor_id());
        projects.setDescription(prj.getDescription());
        projects.setStart_date(prj.getStart_date());
        projects.setEnd_date(prj.getEnd_date());
        projectsService.update(projects);
        return "ok";
    }

    @RequestMapping(value = "/deleteProjects/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String deleteProjects(@PathVariable Integer id) {
        try {
            projectsService.delete(id);
            return "ok";
        } catch (Exception ex) {
            return "error";
        }
    }


    @RequestMapping(value = "/getTasksList", method = RequestMethod.GET)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'MANAGER')")
    public List<Object[]> getTasksList() {
        List<Object[]> tasksList = tasksService.getTasksList();
        return tasksList;
    }

    @RequestMapping(value = "/taskProfile/{id}", method = RequestMethod.GET)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'USER')")
    public Tasks tasklistdetail(@PathVariable("id") Integer id) {
        Tasks tasks = tasksService.getTasksDetail(id);
        return tasks;
    }

    @RequestMapping(value = "/addTasks", method = RequestMethod.POST)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String addTasksPost(@RequestBody Tasks tasks) {

        Tasks task = new Tasks();

        task.setTitle(tasks.getTitle());
        task.setDescription(tasks.getDescription());
        task.setProject_id(tasks.getProject_id());
        task.setUser_id(tasks.getUser_id());
        task.setOpen_date(tasks.getOpen_date());
        task.setClose_date(tasks.getClose_date());

        try {
            tasksService.addTasks(tasks);
            return "ok";
        } catch (Exception ex) {
            return "error";
        }
    }

    @RequestMapping(value = "/editTasks/{id}", method = RequestMethod.POST)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'ADMIN')")
    public String updateTasks(@PathVariable Integer id, @RequestBody Tasks tsk, Model m) {
        Tasks tasks = tasksService.getById(id);
        tasks.setTitle(tsk.getTitle());
        tasks.setDescription(tsk.getTitle());
        tasks.setProject_id(tsk.getProject_id());
        tasks.setUser_id(tsk.getUser_id());
        tasks.setOpen_date(tsk.getOpen_date());
        tasks.setClose_date(tsk.getClose_date());
        tasksService.update(tasks);
        return "ok";
    }

    @RequestMapping(value = "/deleteTasks/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("@mySecurityService.hasPermission(authentication, 'USER')")
    public String deleteTasks(@PathVariable Integer id) {
        try {
            tasksService.delete(id);
            return "ok";
        } catch (Exception ex) {
            return "error";
        }
    }

}
