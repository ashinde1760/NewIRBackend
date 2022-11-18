package com.example.InvestorRelationBackend.serviceir;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.InvestorRelationBackend.configuration.InvestorDatabaseUtill;
//import com.example.InvestorRelationBackend.configuration.InvestorDatabaseUtill1;
//import com.example.InvestorRelationBackend.configuration.InvestorDatabaseUtill;
import com.example.InvestorRelationBackend.masterData.BalanceSheetForm;
import com.example.InvestorRelationBackend.masterData.CashFlow;
import com.example.InvestorRelationBackend.masterData.FinancialRatio;
import com.example.InvestorRelationBackend.masterData.IncomeStatement;
import com.example.InvestorRelationBackend.masterData.ShareHolderContactDetailsForm;
import com.example.InvestorRelationBackend.masterData.ShareHolderDataForm;
import com.example.InvestorRelationBackend.masterData.ShareholderMeetingDetailsForm;
import com.example.InvestorRelationBackend.modelir.RoleModel;
import com.example.InvestorRelationBackend.modelir.User;

@Service
public class RoleServiceImpl implements RoleServiceInterface {

//	private final static String url = "jdbc:postgresql://localhost/postgres";
//	private final static String user = "postgres";
//	private final static String password = "Shiv";

	@Override
	public String createRole1(RoleModel role) throws SQLException {

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.rolemodel values(?,?,?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			role.setId(id);

//			Array array = conn.createArrayOf("VARCHAR", role.getDashboardAccess().toArray());

			Date date = new Date();
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, role.getRoleName());
			preparedStatement.setString(3, role.getDescription());
			preparedStatement.setString(4, role.getStatus());
			preparedStatement.setString(5, role.getDashboardAccess().toString());
			preparedStatement.setLong(6, date.getTime());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after role creation");

			return role.getId().toString();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public RoleModel updateRole(RoleModel role, String id) throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "update InvestorDB.dbo.rolemodel set rolename=?, description=?,status=?,dashboardAccess=? where id=?";
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	/*
	 * @Override public void createRole(RoleModel model) throws SQLException { try
	 * (Connection conn = DriverManager.getConnection(url, user, password)) { String
	 * query =
	 * "Insert into role1(rolename, description, status, dashboard, createdon)" +
	 * "VALUES(?,?,?,?,?)";
	 * 
	 * PreparedStatement pstmt = conn.prepareStatement(query,
	 * Statement.RETURN_GENERATED_KEYS);
	 * 
	 * ArrayList<String> arrdas = new ArrayList<String>();
	 * 
	 * Date nowDate = new Date();
	 * 
	 * // System.out.println(model.getDashboardAccess());
	 * 
	 * pstmt.setString(1, model.getRoleName()); pstmt.setString(2,
	 * model.getDescription()); pstmt.setString(3, model.getStatus());
	 * arrdas.addAll(model.getDashboardAccess()); pstmt.setString(4,
	 * arrdas.toString()); System.out.println("Inside createROle");
	 * 
	 * pstmt.setLong(5, nowDate.getTime()); // pstmt.setDate(7,
	 * model.getCreatedOn()); // pstmt.setDate(8, model.getLastEdit());
	 * 
	 * System.out.println(pstmt); pstmt.executeUpdate(); } }
	 */
	/*
	 * @Override public RoleModel getRoleById(String id) throws SQLException {
	 * PreparedStatement preparedStatement = null; RoleModel model = new
	 * RoleModel(); try (Connection conn = DriverManager.getConnection(url, user,
	 * password)) { Statement stmt = conn.createStatement();
	 * 
	 * String query = "Select * from role1 where id =" + "'" + id + "'"; ResultSet
	 * rs = stmt.executeQuery(query); ArrayList<String> arrdas = new
	 * ArrayList<String>();
	 * 
	 * while (rs.next()) { model.setId(id); model.setRoleName(rs.getString(2));
	 * model.setDescription(rs.getString(3)); model.setStatus(rs.getString(4)); //
	 * ArrayList<String> dashboard = (ArrayList<String>) rs.getArray(4);
	 * arrdas.add(rs.getString(5)); model.setDashboardAccess(arrdas);
	 * model.setCreatedOn(rs.getLong(6));
	 * 
	 * // model.setCreatedOn(query); // model.setLastEdit(rs.getString(9));
	 * 
	 * }
	 * 
	 * } return model;
	 * 
	 * }
	 */

	@Override
	public List<RoleModel> getAllRoles() throws SQLException {

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.rolemodel";
			ResultSet rs = stmt.executeQuery(query);

			List<RoleModel> allRoleList = new ArrayList<>();
			int count = 0;

			while (rs.next()) {

				RoleModel model = new RoleModel();
				model.setId(rs.getString(1));
				model.setRoleName(rs.getString(2));
				model.setDescription(rs.getString(3));
				model.setStatus(rs.getString(4));
				ArrayList<String> vta=new ArrayList<>();
				vta.add(rs.getString(5));
				model.setDashboardAccess(vta);
//				model.setDashboardAccess(rs.getArray(5));
				model.setCreatedOn(rs.getLong(6));
 
				String[] dash = new String[10];
				List<String> dashboard = new ArrayList<>();

//	  ArrayList<String> vta = new ArrayList<>();
				dashboard.add(rs.getString(1));
//		roles.setVendorTemplateAccess(vta);

				Collections.addAll(dashboard, dash);

//	  model.setDashboardAccess(dashboard); 	 

				allRoleList.add(model);

				System.out.println("added");
			}
			System.out.println(allRoleList.size());
			return allRoleList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// user

	@Override
	public String createuser(User user1) throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.user1 values(?,?,?,?,?,?,?,?,?,?)";

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.user1";
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteRole(String id) throws SQLException {

		PreparedStatement preparedStatement = null;

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "delete from InvestorDB.dbo.rolemodel where id = ?";
//			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Before deletion");
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, id);
			System.out.println("after deletion");
			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate);
			System.out.println("after execution");
			return executeUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.user1";
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<User> getUserByRoleId(String role) throws SQLException {
		User model = new User();
		try  {
			Connection conn = InvestorDatabaseUtill.getConnection();
//			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = null;

			List<User> users = new ArrayList<>();

			String query = "Select * from InvestorDB.dbo.user1 where role=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, role);

			ResultSet rs = pstmt.executeQuery();
//			System.out.println("executing the query+++++++++++++++++++" + rs.toString());

			while (rs.next()) {
				System.out.println("getting the result+++++++++++++++++++" + rs.toString());
				User buildUser = buildUser(rs);
				users.add(buildUser);
				System.out.println(buildUser.toString());
				return users;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
		System.out.println(model.toString());
		return model;
	}

	@Override
	public User getUserById(String id) throws SQLException {

		PreparedStatement preparedStatement = null;
		User model = new User();
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.user1 where userid =" + "'" + id + "'";
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public String updateUser(User user1, String id) throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "update InvestorDB.dbo.user1 set firstName=?, lastName=?, email=?, mobilenumber=?,domain=?,assignedname=?,role=?,status=?,createdOn=? where userid=?";
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void deleteUser(String id) throws SQLException {
		PreparedStatement preparedStatement = null;

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
//			Statement stmt = conn.createStatement();

			String query = "delete from InvestorDB.dbo.user1 where userid = ?";

			preparedStatement = conn.prepareStatement(query);
//			preparedStatement.executeUpdate(query);
//			preparedStatement = conn.prepareStatement("delete from role1 where id = ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<RoleModel> getRoleByStatus() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
//			PreparedStatement pstmt = null;

			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.rolemodel where status=" + "'Active'";
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String createBalanceSheetForm(BalanceSheetForm balanceSheetForm) throws SQLException {

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.balanceSheetFrom values(?,?,?,?)";

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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<BalanceSheetForm> getBalanceSheetData() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.balanceSheetFrom";
			ResultSet rs = stmt.executeQuery(query);

			List<BalanceSheetForm> sheet = new ArrayList<>();
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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String createIncomeForm(IncomeStatement incomeStatement) throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.incomestatement values(?,?,?,?)";

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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<IncomeStatement> getIncomeData() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.incomestatement";
			ResultSet rs = stmt.executeQuery(query);

			List<IncomeStatement> incomeData = new ArrayList<>();
			int count = 0;

			while (rs.next()) {
				IncomeStatement balanceSheetForm = new IncomeStatement();
				balanceSheetForm.setId(rs.getString(1));
				balanceSheetForm.setLineItem(rs.getString(2));
				balanceSheetForm.setAlternativeName(rs.getString(3));
				balanceSheetForm.setType(rs.getString(4));

				incomeData.add(balanceSheetForm);

			}
			System.out.println("List of balance Sheet form");
			System.out.println(incomeData.size());
			return incomeData;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String createCashFlow(CashFlow cashFlow) throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.cashflow values(?,?,?,?)";

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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CashFlow> getCashFlowData() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {
			Statement stmt = conn.createStatement();

			String query = "Select * from InvestorDB.dbo.cashflow";
			ResultSet rs = stmt.executeQuery(query);

			List<CashFlow> cashflow = new ArrayList<>();
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
			sysout
			return cashflow;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String createShareHolderData(ShareHolderDataForm dataForm) throws SQLException {
		System.out.println(dataForm + " data to be added");
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.shareholderdataform values(?,?,?,?,?,?,?,?,?)";

			Date date = new Date();

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			dataForm.setId(id);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, dataForm.getClientId());
			preparedStatement.setString(3, dataForm.getPortfolioId());
			preparedStatement.setString(4, dataForm.getFolio());
			preparedStatement.setString(5, dataForm.getShareholderName());
			preparedStatement.setString(6, dataForm.getHoldingValue());
			preparedStatement.setString(7, dataForm.getHoldingPercentage());
			preparedStatement.setString(8, dataForm.getMinorcode());
			preparedStatement.setString(9, dataForm.getDate());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after Shareholder creation");

			return dataForm.getClientId().toString();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShareHolderDataForm> getShareHolderData() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			Statement statement = conn.createStatement();

			String query = "select * from InvestorDB.dbo.shareholderdataform";

			ResultSet rs = statement.executeQuery(query);

			List<ShareHolderDataForm> holder = new ArrayList<>();
			while (rs.next()) {
				ShareHolderDataForm form = new ShareHolderDataForm();
				form.setId(rs.getString(1));
				form.setClientId(rs.getString(2));
				form.setPortfolioId(rs.getString(3));
				form.setFolio(rs.getString(4));
				form.setShareholderName(rs.getString(5));
				form.setHoldingValue(rs.getString(6));
				form.setHoldingPercentage(rs.getString(7));
				form.setMinorcode(rs.getString(8));
				form.setDate(rs.getString(9));

				holder.add(form);

			}
			System.out.println("ShareHolderList" + holder);
			System.out.println(holder.size());
			return holder;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String createContact(ShareHolderContactDetailsForm detailsForm) throws SQLException {

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.shareholdercontact values(?,?,?,?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String clientId = UUID.randomUUID().toString();
			detailsForm.setId(clientId);
			preparedStatement.setString(1, clientId);
			preparedStatement.setString(2, detailsForm.getName());
			preparedStatement.setString(3, detailsForm.getPoc());
			preparedStatement.setString(4, detailsForm.getEmail());
			preparedStatement.setString(5, detailsForm.getMinorcode());
			preparedStatement.setString(6, detailsForm.getAddress());
			preparedStatement.setString(7, detailsForm.getContact());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " Contact creation");

			return detailsForm.getId().toString();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShareHolderContactDetailsForm> getContactDetails() throws SQLException {

		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			Statement statement = conn.createStatement();

			String query = "select * from InvestorDB.dbo.shareholdercontact";

			ResultSet rs = statement.executeQuery(query);

			List<ShareHolderContactDetailsForm> contact = new ArrayList<>();
			while (rs.next()) {
				ShareHolderContactDetailsForm form = new ShareHolderContactDetailsForm();
				form.setId(rs.getString(1));
				form.setName(rs.getString(2));
				form.setPoc(rs.getString(3));
				form.setEmail(rs.getString(4));
				form.setMinorcode(rs.getString(5));
				form.setAddress(rs.getString(6));
				form.setContact(rs.getString(7));

				contact.add(form);

			}
			System.out.println("Contact details " + contact);
			System.out.println(contact.size());
			return contact;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String createMeetingDetails(ShareholderMeetingDetailsForm form) throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.shareholdermeeting values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			Date date = new Date();

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			form.setId(id);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, form.getDate());
			preparedStatement.setString(3, form.getStartTime());
			preparedStatement.setString(4, form.getEndTime());
			preparedStatement.setString(5, form.getOrganisation());
			preparedStatement.setString(6, form.getStakeholderType());
			preparedStatement.setString(7, form.getMeetingType());
			preparedStatement.setString(8, form.getSubject());
			preparedStatement.setString(9, form.getLocation());
			preparedStatement.setString(10, form.getStatus());
			preparedStatement.setString(11, form.getComments());
			preparedStatement.setString(12, form.getParticipants());
			preparedStatement.setString(13, form.getFeedback());
			preparedStatement.setString(14, form.getBroker());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after meeting data creation");

			return form.getId().toString();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShareholderMeetingDetailsForm> getAllMeetingData() throws SQLException {
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			Statement statement = conn.createStatement();

			String query = "select * from InvestorDB.dbo.shareholdermeeting";

			ResultSet rs = statement.executeQuery(query);

			List<ShareholderMeetingDetailsForm> meeting = new ArrayList<>();
			while (rs.next()) {
				ShareholderMeetingDetailsForm form = new ShareholderMeetingDetailsForm();
				form.setId(rs.getString(1));
				form.setDate(rs.getString(2));
				form.setStartTime(rs.getString(3));
				form.setEndTime(rs.getString(4));
				form.setOrganisation(rs.getString(5));
				form.setStakeholderType(rs.getString(6));
				form.setMeetingType(rs.getString(7));
				form.setSubject(rs.getString(8));
				form.setLocation(rs.getString(9));
				form.setStatus(rs.getString(10));
				form.setComments(rs.getString(11));
				form.setParticipants(rs.getString(12));
				form.setFeedback(rs.getString(13));
				form.setBroker(rs.getString(14));

				meeting.add(form);

			}
			System.out.println("Meeting data" + meeting);
			System.out.println(meeting.size());
			return meeting;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String createRatio(FinancialRatio ratio) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			PreparedStatement preparedStatement = null;
			String query = "insert into InvestorDB.dbo.financialRatio values(?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			String id = UUID.randomUUID().toString();
			ratio.setId(id);

//			Array array = conn.createArrayOf("VARCHAR", role.getDashboardAccess().toArray());

			Date date = new Date();
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, ratio.getFormulaName());
			preparedStatement.setString(3, ratio.getFormulaType());
			preparedStatement.setString(4, ratio.getFormula());

			int executeUpdate = preparedStatement.executeUpdate();
			System.out.println(executeUpdate + " after role creation");

			return ratio.getId().toString();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<FinancialRatio> getFinacialRatio() throws SQLException {
		// TODO Auto-generated method stub
		try (Connection conn = InvestorDatabaseUtill.getConnection()) {

			Statement statement = conn.createStatement();

			String query = "select * from InvestorDB.dbo.financialRatio";

			ResultSet rs = statement.executeQuery(query);

			List<FinancialRatio> holder = new ArrayList<>();
			while (rs.next()) {
				FinancialRatio form = new FinancialRatio();
				form.setId(rs.getString(1));
				form.setFormulaName(rs.getString(2));
				form.setFormulaType(rs.getString(3));
				form.setFormula(rs.getString(4));

				holder.add(form);

			}
			System.out.println("ShareHolderList" + holder);
			System.out.println(holder.size());
			return holder;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
