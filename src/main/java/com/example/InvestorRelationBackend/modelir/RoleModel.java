package com.example.InvestorRelationBackend.modelir;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

public class RoleModel {

	
	private String id;
	private String roleName;
	private String description;
	private String status;
	private ArrayList<String> dashboardAccess;
	
	private Map<String, String> dashboard;
	
	
	private Long createdOn;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<String> getDashboardAccess() {
		return dashboardAccess;
	}

	public void setDashboardAccess(ArrayList<String> dashboardAccess) {
		this.dashboardAccess = dashboardAccess;
	}

	

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public RoleModel(String id, String roleName, String description, String status, Long createdOn) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.status = status;
		this.createdOn = createdOn;
	}

	public RoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
