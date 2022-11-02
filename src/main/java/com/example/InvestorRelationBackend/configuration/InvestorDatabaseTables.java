package com.example.InvestorRelationBackend.configuration;

public class InvestorDatabaseTables {
	
	public static final String DATA_BASE_PLACE_HOLDER="#$dataBaseName#$";
	
	public static final String CREATE_ROLEMODEL_TABLE="CREATE TABLE #$dataBaseName#$.dbo.rolemodel(id uniqueidentifier NOT NULL,roleName varchar(255) NOT NULL,	 varchar(255) NOT NULL,status varchar(255) NOT NULL,dashboardAccess varchar(255) NOT NULL,createdOn bigint NOT NULL,CONSTRAINT PK_id PRIMARY KEY CLUSTERED(id))";

	public static final String CREATE_USER_TABLE="CREATE TABLE #$dataBaseName#$.dbo.user1(userid uniqueidentifier NOT NULL,firstName varchar(255) NOT NULL,lastName varchar(255) NOT NULL,email varchar(255) NOT NULL,mobileNumber varchar(255) NOT NULL,domain varchar(255) NOT NULL,assignedName varchar(255) NOT NULL,role varchar(255) NOT NULL,status varchar(255) NOT NULL,createdOn bigint NOT NULL,CONSTRAINT userid PRIMARY KEY CLUSTERED(userid))";

    public static final String CREATE_BALANCESHEETFORM_TABLE="CREATE TABLE #$dataBaseName#$.dbo.balanceSheetFrom(balanceid uniqueidentifier NOT NULL,lineItem varchar(255) NOT NULL,alternativeName varchar(255) NOT NULL,type varchar(255) NOT NULL,CONSTRAINT balanceid PRIMARY KEY CLUSTERED(balanceid))";

    public static final String CREATE_INCOMESTATEMENT_TABLE="CREATE TABLE #$dataBaseName#$.dbo.incomestatement(incomeid uniqueidentifier NOT NULL,lineItem varchar(255) NOT NULL,alternativeName varchar(255) NOT NULL,type varchar(255) NOT NULL,CONSTRAINT incomeid PRIMARY KEY CLUSTERED(incomeid))";
    
    public static final String CREATE_CASHFLOW_TABLE="CREATE TABLE #$dataBaseName#$.dbo.cashflow(cashid uniqueidentifier NOT NULL,lineItem varchar(255) NOT NULL,alternativeName varchar(255) NOT NULL,type varchar(255) NOT NULL,CONSTRAINT cashid PRIMARY KEY CLUSTERED(cashid))";
   
    public static final String CREATE_SHAREHOLDERDATAFORM_TABLE="CREATE TABLE #$dataBaseName#$.dbo.shareholderdataform(shareid uniqueidentifier NOT NULL,clientId varchar(255) NOT NULL,portfolioId varchar(255) NOT NULL,folio varchar(255) NOT NULL,shareholderName varchar(255) NOT NULL,holdingValue varchar(255) NOT NULL,holdingPercentage varchar(255) NOT NULL,minorcode varchar(255) NOT NULL,date varchar(255) NOT NULL,CONSTRAINT shareid PRIMARY KEY CLUSTERED(shareid))";
   
    public static final String CREATE_SHAREHOLDERCONTACT_TABLE="CREATE TABLE #$dataBaseName#$.dbo.shareholdercontact(contactid uniqueidentifier NOT NULL,name varchar(255) NOT NULL,poc varchar(255) NOT NULL,email varchar(255) NOT NULL,minorcode varchar(255) NOT NULL,address varchar(255) NOT NULL,contact varchar(255) NOT NULL,CONSTRAINT contactid PRIMARY KEY CLUSTERED(contactid))";

    public static final String CREATE_SHAREHOLDER_MEETING_TABLE="CREATE TABLE #$dataBaseName#$.dbo.shareholdermeeting(holderid uniqueidentifier NOT NULL,date varchar(255) NOT NULL,startTime varchar(255) NOT NULL,endTime varchar(255) NOT NULL,organisation varchar(255) NOT NULL,stakeholderType varchar(255) NOT NULL,meetingType varchar(255) NOT NULL,subject varchar(255) NOT NULL,broker varchar(255) NOT NULL,location varchar(255) NOT NULL,status varchar(255) NOT NULL,comments varchar(255) NOT NULL,participants varchar(255) NOT NULL,feedback varchar(255) NOT NULL,CONSTRAINT holderid PRIMARY KEY CLUSTERED(holderid))";

    public static final String CREATE_FINANCIAL_RATIO_TABLE="CREATE TABLE #$dataBaseName#$.dbo.financialRatio(financialid uniqueidentifier NOT NULL,formulaName varchar(255) NOT NULL,formulaType varchar(255) NOT NULL,formula varchar(255) NOT NULL,CONSTRAINT financialid PRIMARY KEY CLUSTERED(financialid))";
}
