package com.david.duck.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.david.duck.model.Calendar;
import com.david.duck.model.Master;
import com.david.duck.model.Pet;
import com.david.duck.model.User;
import com.david.duck.model.UserRole;
import com.david.duck.repository.CalendarRepository;
import com.david.duck.repository.MasterRepository;
import com.david.duck.repository.PetRepository;
import com.david.duck.repository.RoleRepository;
import com.david.duck.repository.UserRepository;
import com.david.duck.repository.UserRoleRepository;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private MasterRepository masterRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	Neo4jTemplate template;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String getUsers() {

		Iterable<User> results = userRepository.findAll();
		List<User> userList = new ArrayList<User>(IteratorUtil.asCollection(results));
		
		return userList.get(0).toString();
	}
	
	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public @ResponseBody Iterable<Pet> getMaster() {
		Iterable<Master> results = masterRepository.findAll();
		List<Master> masterList = new ArrayList<Master>(IteratorUtil.asCollection(results));
		
		return masterList.get(0).getPets();
	}
		
	
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public @ResponseBody Iterable<Calendar> dateTesting() {
//		Calendar calendar=new Calendar();
//		calendar.setDateLong(new Date());
//		calendar.setDateString(new Date());
//		calendarRepository.save(calendar);
//		
		Iterable<Calendar> results = calendarRepository.findAll(1);
		List<Calendar> calendarList = new ArrayList<Calendar>(IteratorUtil.asCollection(results));
		return calendarList;
	}
}