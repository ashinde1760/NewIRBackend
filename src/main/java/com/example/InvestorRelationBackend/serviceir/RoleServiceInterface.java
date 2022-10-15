package com.example.InvestorRelationBackend.serviceir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.InvestorRelationBackend.masterData.BalanceSheetForm;
import com.example.InvestorRelationBackend.masterData.CashFlow;
import com.example.InvestorRelationBackend.masterData.IncomeStatement;
import com.example.InvestorRelationBackend.masterData.ShareHolderContactDetailsForm;
import com.example.InvestorRelationBackend.masterData.ShareHolderDataForm;
import com.example.InvestorRelationBackend.masterData.ShareholderMeetingDetailsForm;
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

	
//	code by shubham

	List<BalanceSheetForm> getBalanceSheetData() throws SQLException;

	String createBalanceSheetForm(BalanceSheetForm balanceSheetForm) throws SQLException;

	String createIncomeForm(IncomeStatement incomeStatement) throws SQLException;

	List<BalanceSheetForm> getIncomeData() throws SQLException;

	String createCashFlow(CashFlow cashFlow) throws SQLException;

	List<CashFlow> getCashFlowData() throws SQLException;

	String createShareHolderData(ShareHolderDataForm dataForm) throws SQLException;

	List<ShareHolderDataForm> getShareHolderData() throws SQLException;

	String createContact(ShareHolderContactDetailsForm detailsForm) throws SQLException;

	List<ShareHolderContactDetailsForm> getContactDetails() throws SQLException;

	String createMeetingDetails(ShareholderMeetingDetailsForm form) throws SQLException;

	List<ShareholderMeetingDetailsForm> getAllMeetingData() throws SQLException;

	

	

}
