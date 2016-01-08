package com.david.duck.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.david.duck.model.Master;
import com.david.duck.model.Pet;
import com.david.duck.model.Role;
import com.david.duck.model.User;
import com.david.duck.model.UserRole;
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
	
	Neo4jTemplate template;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody Iterable<User> getUsers() {
//		User user=new User();
//		user.setFirstName("Dennis");
//		user.setLastName("Prasetia");
//		user.setPassword("admin");
//		user.setRole("admin");
//		user.setUsername("dennisbongchan");
//		userRepository.save(user);
//		
//		Role role=new Role();
//		role.setName("Admin");
//		roleRepository.save(role);
//
//		Role role2=new Role();
//		role2.setName("Admin2");
//		roleRepository.save(role2);
//		
//		UserRole userRole=new UserRole(user,role);
//		userRoleRepository.save(userRole);
//		
//		Set<UserRole> listUserRole=new HashSet<UserRole>();
//		listUserRole.add(userRole);
//		
//		
//		user.setRoles(listUserRole);
//		role.setUserRoles(listUserRole);
//		userRepository.save(user);
//		roleRepository.save(role);

		Iterable<User> results = userRepository.findAll();
		
		return results;
	}
	
	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public @ResponseBody Iterable<Master> getMaster() {
		masterRepository.deleteAll();
		petRepository.deleteAll();
		
		
		Master master=new Master();
		master.setName("Vincent");
		masterRepository.save(master);
		
		Pet pet=new Pet();
		pet.setName("Cat");
		pet.setMaster(master);
		petRepository.save(pet);
		
		Set<Pet> pets=new HashSet<Pet>();
		pets.add(pet);
		
		master.setPets(pets);
		masterRepository.save(master);
		Iterable<Master> results = masterRepository.findAll();
		return results;
	}

}