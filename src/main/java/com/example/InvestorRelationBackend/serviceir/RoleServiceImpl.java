package com.example.InvestorRelationBackend.serviceir;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.InvestorRelationBackend.masterData.BalanceSheetForm;
import com.example.InvestorRelationBackend.masterData.CashFlow;
import com.example.InvestorRelationBackend.masterData.IncomeStatement;
import com.example.InvestorRelationBackend.modelir.RoleModel;
import com.example.InvestorRelationBackend.modelir.User;

@Service
public class RoleServiceImpl implements RoleServiceInterface {

	private final static String url = "jdbc:postgresql://localhost/postgres";
	private final static String user = "postgres";
	private final static String password = "pass";

	@Override
	public String createRole1(RoleModel role) throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "insert into role1 values(?,?,?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			role.setId(id);

//			Array array = conn.createArrayOf("VARCHAR", role.getDashboardAccess().toArray());

			Date date = new Date();
			preparedStatement.setString(1, role.getId());
			preparedStatement.setString(2, role.getRoleName());
			preparedStatement.setString(3, role.getDescription());
			preparedStatement.setString(4, role.getStatus());
			preparedStatement.setString(5, role.getDashboardAccess().toString());
			preparedStatement.setLong(6, date.getTime());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after role creation");

			return role.getRoleName().toString();

		}

	}

	@Override
	public RoleModel updateRole(RoleModel role, String id) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "update role1 set rolename=?, description=?,status=?,dashboard=? where id=?";
			preparedStatement = conn.prepareStatement(query);

			Date date = new Date();
			preparedStatement.setString(1, role.getRoleName());
			preparedStatement.setString(2, role.getDescription());
			preparedStatement.setString(3, role.getStatus());
			preparedStatement.setString(4, role.getDashboardAccess().toString());
			preparedStatement.setString(5, id);

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after role updation");

			return role;
		}
	}

	@Override
	public void createRole(RoleModel model) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String query = "Insert into role1(rolename, description, status, dashboard, createdon)"
					+ "VALUES(?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ArrayList<String> arrdas = new ArrayList<String>();

			Date nowDate = new Date();

//			System.out.println(model.getDashboardAccess());

			pstmt.setString(1, model.getRoleName());
			pstmt.setString(2, model.getDescription());
			pstmt.setString(3, model.getStatus());
			arrdas.addAll(model.getDashboardAccess());
			pstmt.setString(4, arrdas.toString());
			System.out.println("Inside createROle");

			pstmt.setLong(5, nowDate.getTime());
//			pstmt.setDate(7, model.getCreatedOn());
//			pstmt.setDate(8, model.getLastEdit());

			System.out.println(pstmt);
			pstmt.executeUpdate();
		}
	}

	@Override
	public RoleModel getRoleById(String id) throws SQLException {
		PreparedStatement preparedStatement = null;
		RoleModel model = new RoleModel();
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from role1 where id =" + "'" + id + "'";
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> arrdas = new ArrayList<String>();

			while (rs.next()) {
				model.setId(id);
				model.setRoleName(rs.getString(2));
				model.setDescription(rs.getString(3));
				model.setStatus(rs.getString(4));
//				ArrayList<String> dashboard = (ArrayList<String>) rs.getArray(4);
				arrdas.add(rs.getString(5));
				model.setDashboardAccess(arrdas);
				model.setCreatedOn(rs.getLong(6));

//				model.setCreatedOn(query);
//				model.setLastEdit(rs.getString(9));

			}

		}
		return model;

	}

	@Override
	public ArrayList<RoleModel> getAllRoles() throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from role1";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<RoleModel> allRoleList = new ArrayList();
			int count = 0;

			while (rs.next()) {
				ArrayList<String> arrdas = new ArrayList<String>();
//				ArrayList<String> arrinj = new ArrayList();
//				ArrayList<String> arrcon = new ArrayList();

				RoleModel model = new RoleModel();
				model.setId(rs.getString(1));
				model.setRoleName(rs.getString(2));
				model.setDescription(rs.getString(3));
				model.setStatus(rs.getString(4));
//				ArrayList<String> dashboard = (ArrayList<String>) rs.getArray(4);
				arrdas.add(rs.getString(5));
				model.setDashboardAccess(arrdas);
				model.setCreatedOn(rs.getLong(6));
//				model.setCreatedOn(query);
//				model.setLastEdit(rs.getString(9));

				allRoleList.add(model);

				System.out.println("added");
			}
			System.out.println(allRoleList.size());
			return allRoleList;

		}

	}

	// user

	@Override
	public String createuser(User user1) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "insert into user11 values(?,?,?,?,?,?,?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			user1.setId(id);

			Date date = new Date();
			preparedStatement.setString(1, user1.getId());
			preparedStatement.setString(2, user1.getFirstName());
			preparedStatement.setString(3, user1.getLastName());
			preparedStatement.setString(4, user1.getEmail());
			preparedStatement.setString(5, user1.getMobileNumber());
			preparedStatement.setString(6, user1.getDomain());
			preparedStatement.setString(7, user1.getAssignedName());
			preparedStatement.setString(8, user1.getRole());
			preparedStatement.setString(9, user1.getStatus());
			preparedStatement.setLong(10, date.getTime());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after user creation");

			return user1.getId();
		}

//		public ArrayList<User> getAllUsers() throws SQLException {
//
//			try (Connection conn = DriverManager.getConnection(url, user, password)) {
//				Statement stmt = conn.createStatement();
//
//				String query = "Select * from role1";
//				ResultSet rs = stmt.executeQuery(query);
//
//				ArrayList<RoleModel> allUsersList = new ArrayList();
//				int count = 0;
//
//				while (rs.next()) {
//					ArrayList<String> arrdas = new ArrayList<String>();
//					ArrayList<String> arrinj = new ArrayList();
//					ArrayList<String> arrcon = new ArrayList();
//
//					RoleModel model = new RoleModel();
//					model.setId(rs.getString(1));
//					model.setRoleName(rs.getString(2));
//					model.setDescription(rs.getString(3));
//					model.setStatus(rs.getString(4));
////					ArrayList<String> dashboard = (ArrayList<String>) rs.getArray(4);
//					arrdas.add(rs.getString(5));
//					model.setDashboardAccess(arrdas);
//					model.setCreatedOn(rs.getLong(6));
////					model.setCreatedOn(query);
////					model.setLastEdit(rs.getString(9));
//
//					allUsersList.add(model);
//
//					System.out.println("added");
//				}
//				System.out.println(allUsersList.size());
//				return allUsersList;
//
//			}
//
//		}
	}

	@Override
	public User getAllU() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from user11";
			ResultSet rs = stmt.executeQuery(query);

			User userModel = new User();

			while (rs.next()) {
				userModel.setId(rs.getString(1));
				userModel.setFirstName(rs.getString(2));
				userModel.setLastName(rs.getString(3));
				userModel.setEmail(rs.getString(4));
				userModel.setMobileNumber(rs.getString(5));
				userModel.setDomain(rs.getString(6));
				userModel.setAssignedName(rs.getString(7));
				userModel.setRole(rs.getString(8));
				userModel.setStatus(rs.getString(9));
				userModel.setCreatedOn(rs.getLong(10));
			}

			return userModel;
		}
	}

	@Override
	public int deleteRole(String id) throws SQLException {

		PreparedStatement preparedStatement = null;

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "delete from role1 where id = ?";
//			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Before deletion");
			preparedStatement = conn.prepareStatement("delete from role1 where id = ?");
			preparedStatement.setString(1, id);
			System.out.println("after deletion");
			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate);
			System.out.println("after execution");
			return executeUpdate;
		}

	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from user11";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<User> allUsersList1 = new ArrayList();
			int count = 0;

			while (rs.next()) {
				User model = new User();
				model.setId(rs.getString(1));
				model.setFirstName(rs.getString(2));
				model.setLastName(rs.getString(3));
				model.setEmail(rs.getString(4));
				model.setMobileNumber(rs.getString(5));
				model.setDomain(rs.getString(6));
				model.setAssignedName(rs.getString(7));
				model.setRole(rs.getString(8));
				model.setStatus(rs.getString(9));
				model.setCreatedOn(rs.getLong(10));

				allUsersList1.add(model);

				System.out.println("added");
			}
			System.out.println(allUsersList1.size());
			return allUsersList1;

		}

	}

	@Override
	public List<User> getUserByRoleId(String id) throws SQLException {
		User model = new User();
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
//			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = null;

			List<User> users = new ArrayList<>();

			String query = "Select * from user11 where role=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				User buildUser = buildUser(rs);
				users.add(buildUser);

			}
			return users;

		}

	}

	private User buildUser(ResultSet rs) throws SQLException {
		User model = new User();
		model.setId(rs.getString(UserConstants.ID));
		model.setFirstName(rs.getString(UserConstants.FIRST_NAME));
		model.setLastName(rs.getString(UserConstants.LAST_NAME));
		model.setEmail(rs.getString(UserConstants.EMAIL));
		model.setMobileNumber(rs.getString(UserConstants.MOBILE));
		model.setDomain(rs.getString(UserConstants.DOMAIN));
		model.setAssignedName(rs.getString(UserConstants.ASSIGNEDNAME));
		model.setRole(rs.getString(UserConstants.ROLE));
		model.setStatus(rs.getString(UserConstants.STATUS));
		model.setCreatedOn(rs.getLong(10));
		return model;
	}

	@Override
	public User getUserById(String id) throws SQLException {

		PreparedStatement preparedStatement = null;
		User model = new User();
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from user11 where id =" + "'" + id + "'";
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> arrdas = new ArrayList<String>();

			while (rs.next()) {
				model.setId(id);
				model.setFirstName(rs.getString(2));
				model.setLastName(rs.getString(3));
				model.setEmail(rs.getString(4));
				model.setMobileNumber(rs.getString(5));
				model.setDomain(rs.getString(6));
				model.setAssignedName(rs.getString(7));
				model.setRole(rs.getString(8));
				model.setStatus(rs.getString(9));
				model.setCreatedOn(rs.getLong(10));
			}

		}
		return model;
	}

	@Override
	public String updateUser(User user1, String id) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "update user11 set firstName=?, lastName=?, email=?, mobilenumber=?,domain=?,assignedname=?,role=?,status=?,date=? where id=?";
			preparedStatement = conn.prepareStatement(query);

			Date date = new Date();
			preparedStatement.setString(1, user1.getFirstName());
			preparedStatement.setString(2, user1.getLastName());
			preparedStatement.setString(3, user1.getEmail());
			preparedStatement.setString(4, user1.getMobileNumber());
			preparedStatement.setString(5, user1.getDomain());
			preparedStatement.setString(6, user1.getAssignedName());
			preparedStatement.setString(7, user1.getRole());
			preparedStatement.setString(8, user1.getStatus());
			preparedStatement.setLong(9, user1.getCreatedOn());
			preparedStatement.setString(10, id);

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after User updation");

			return user1.getId();
		}
	}

	@Override
	public void deleteUser(String id) throws SQLException {
		PreparedStatement preparedStatement = null;

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
//			Statement stmt = conn.createStatement();

			String query = "delete from user11 where id = ?";

			preparedStatement = conn.prepareStatement(query);
//			preparedStatement.executeUpdate(query);
//			preparedStatement = conn.prepareStatement("delete from role1 where id = ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		}

	}

	@Override
	public List<RoleModel> getRoleByStatus() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
//			PreparedStatement pstmt = null;

			Statement stmt = conn.createStatement();

			String query = "Select * from role1 where status=" + "'Active'";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<RoleModel> roleData = new ArrayList();

			while (rs.next()) {
				RoleModel model = new RoleModel();
				model.setId(rs.getString(1));
				model.setRoleName(rs.getString(2));
				model.setStatus(rs.getString(3));

				roleData.add(model);

				System.out.println("added");
			}
			System.out.println(roleData.size());
			return roleData;

		}

	}

	@Override
	public String createBalanceSheetForm(BalanceSheetForm balanceSheetForm) throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "insert into balanceSheet values(?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			balanceSheetForm.setId(id);
			preparedStatement.setString(1, balanceSheetForm.getId());
			preparedStatement.setString(2, balanceSheetForm.getLineItem());
			preparedStatement.setString(3, balanceSheetForm.getAlternativeName());
			preparedStatement.setString(4, balanceSheetForm.getType());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after sheet creation");

			return balanceSheetForm.getId().toString();

		}

	}

	@Override
	public List<BalanceSheetForm> getBalanceSheetData() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from balanceSheet";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<BalanceSheetForm> sheet = new ArrayList<>();
			int count = 0;

			while (rs.next()) {
				BalanceSheetForm balanceSheetForm = new BalanceSheetForm();
				balanceSheetForm.setId(rs.getString(1));
				balanceSheetForm.setLineItem(rs.getString(2));
				balanceSheetForm.setAlternativeName(rs.getString(3));
				balanceSheetForm.setType(rs.getString(4));

				sheet.add(balanceSheetForm);

				
			}
			System.out.println("List of balance Sheet form");
			System.out.println(sheet.size());
			return sheet;

		}

	}

	@Override
	public String createIncomeForm(IncomeStatement incomeStatement) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "insert into incomeStatement values(?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			incomeStatement.setId(id);
			preparedStatement.setString(1, incomeStatement.getId());
			preparedStatement.setString(2, incomeStatement.getLineItem());
			preparedStatement.setString(3, incomeStatement.getAlternativeName());
			preparedStatement.setString(4, incomeStatement.getType());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after Income Statement creation");

			return incomeStatement.getId().toString();

		}

	}

	@Override
	public List<BalanceSheetForm> getIncomeData() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from incomeStatement";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<BalanceSheetForm> income = new ArrayList<>();
			int count = 0;

			while (rs.next()) {
				BalanceSheetForm balanceSheetForm = new BalanceSheetForm();
				balanceSheetForm.setId(rs.getString(1));
				balanceSheetForm.setLineItem(rs.getString(2));
				balanceSheetForm.setAlternativeName(rs.getString(3));
				balanceSheetForm.setType(rs.getString(4));

				income.add(balanceSheetForm);

				
			}
			System.out.println("List of balance Sheet form");
			System.out.println(income.size());
			return income;

		}
		
	}

	@Override
	public String createCashFlow(CashFlow cashFlow) throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = null;
			String query = "insert into cashFlow values(?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			cashFlow.setId(id);
			preparedStatement.setString(1, cashFlow.getId());
			preparedStatement.setString(2, cashFlow.getLineItem());
			preparedStatement.setString(3, cashFlow.getAlternativeName());
			preparedStatement.setString(4, cashFlow.getType());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after Income Statement creation");

			return cashFlow.getId().toString();

		}
	}

	@Override
	public List<CashFlow> getCashFlowData() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();

			String query = "Select * from cashFlow";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<CashFlow> cashflow = new ArrayList<>();
			int count = 0;

			while (rs.next()) {
				CashFlow cashFlowNew = new CashFlow();
				cashFlowNew.setId(rs.getString(1));
				cashFlowNew.setLineItem(rs.getString(2));
				cashFlowNew.setAlternativeName(rs.getString(3));
				cashFlowNew.setType(rs.getString(4));

				cashflow.add(cashFlowNew);

			}
			
			System.out.println("List of balance Sheet form");
			System.out.println(cashflow.size());
			
			 return cashflow;

		}
		
	}

	

	

	

	

}
