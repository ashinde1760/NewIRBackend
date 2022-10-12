package com.example.InvestorRelationBackend.controllerir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InvestorRelationBackend.modelir.RoleModel;
import com.example.InvestorRelationBackend.modelir.User;
import com.example.InvestorRelationBackend.serviceir.RoleServiceInterface;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	RoleServiceInterface roleInterface;
	
	
	@PostMapping("/createRole")
	public void createRole(@RequestBody RoleModel model) throws SQLException {
		System.out.println("got req to store from frontend");
		roleInterface.createRole1(model);
	}
	
	@GetMapping("/getRoleById/{id}")
	public RoleModel getROleById(@PathVariable String id) throws SQLException {
		return roleInterface.getRoleById(id);
	}
	
	@GetMapping("/getAllRoles")
	public List<RoleModel> getAllRoles() throws SQLException{
		return roleInterface.getAllRoles();
	}
	
	@DeleteMapping("/deleteRoleById/{id}")
	public void deleteRole(@PathVariable("id") String id) throws SQLException {
		System.out.println(id+"  id which will get deleted");
		roleInterface.deleteRole(id);
	}
	
	@PutMapping("/update/{id}")
	public  ResponseEntity<String> update(@RequestBody RoleModel role, @PathVariable String id) throws SQLException {
		System.out.println("got update req in controller");
		  roleInterface.updateRole(role, id);
		 return ResponseEntity.ok("role updated successfully");
	}
	
	@GetMapping("/getRoleByStatus")
	public List<RoleModel> getRoleByStatus() throws SQLException{
		return roleInterface.getRoleByStatus();
	}
	
	
	
	
//User creation
	@PostMapping("/createUser")
	public void createnewUser(@RequestBody User user) throws SQLException {
		roleInterface.createuser(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() throws SQLException{
		System.out.println("inside get all users");
		return roleInterface.getAllUsers();
	}
	
	@GetMapping("/getallu")
	public User getallU() throws SQLException {
		System.out.println("inside get all users1");

		return roleInterface.getAllU();
	}
	
	@GetMapping("/getUserByRoleName/{id}")
	public List<User> getUserByRoleId(@PathVariable String id) throws SQLException {
		return roleInterface.getUserByRoleId(id);
		
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable String id) throws SQLException {
		return roleInterface.getUserById(id);
	}
	
	
	@PutMapping("/updateUser/{id}")
	public String updateUser(@RequestBody User user, @PathVariable String id) throws SQLException {
		System.out.println("got update req in controller");
		 return roleInterface.updateUser(user, id);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUser(@PathVariable("id") String id) throws SQLException {
		System.out.println(id+"  id which will get deleted");
		roleInterface.deleteUser(id);
	}
	
	
}
