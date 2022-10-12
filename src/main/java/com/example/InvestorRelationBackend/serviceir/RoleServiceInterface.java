package com.example.InvestorRelationBackend.serviceir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.InvestorRelationBackend.modelir.RoleModel;
import com.example.InvestorRelationBackend.modelir.User;

public interface RoleServiceInterface {

	String createRole1(RoleModel model) throws SQLException;

	RoleModel getRoleById(String id) throws SQLException;

	List<User> getAllUsers() throws SQLException;

	void createRole(RoleModel model) throws SQLException;

	RoleModel updateRole(RoleModel model, String id) throws SQLException;

	String createuser(User userModel) throws SQLException;

	User getAllU() throws SQLException;
	
	

	List<User> getUserByRoleId(String id) throws SQLException;
	
	User getUserById(String id)throws SQLException;
	
	String updateUser(User user,String id) throws SQLException;
	
//	Role operations
	int deleteRole(String id) throws SQLException;

	ArrayList<RoleModel> getAllRoles() throws SQLException;
	
	void deleteUser(String id) throws SQLException;
	
	List<RoleModel> getRoleByStatus() throws SQLException;

}
