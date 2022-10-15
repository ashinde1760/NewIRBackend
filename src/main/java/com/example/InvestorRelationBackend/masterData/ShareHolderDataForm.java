package com.example.InvestorRelationBackend.masterData;

public class ShareHolderDataForm {

	private String id;
	
	private String clientId;
	
	private String portfoliold;
	
	private String folio;
	
	private String shareHolderName;
	
	private String holdingValue;
	
	private String holdingPercentage;
	
	private String minorCode;
	
	private long date;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPortfoliold() {
		return portfoliold;
	}

	public void setPortfoliold(String portfoliold) {
		this.portfoliold = portfoliold;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getShareHolderName() {
		return shareHolderName;
	}

	public void setShareHolderName(String shareHolderName) {
		this.shareHolderName = shareHolderName;
	}

	public String getHoldingValue() {
		return holdingValue;
	}

	public void setHoldingValue(String holdingValue) {
		this.holdingValue = holdingValue;
	}

	public String getHoldingPercentage() {
		return holdingPercentage;
	}

	public void setHoldingPercentage(String holdingPercentage) {
		this.holdingPercentage = holdingPercentage;
	}

	public String getMinorCode() {
		return minorCode;
	}

	public void setMinorCode(String minorCode) {
		this.minorCode = minorCode;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	

	public ShareHolderDataForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ShareHolderDataForm [id=" + id + ", clientId=" + clientId + ", portfoliold=" + portfoliold + ", folio="
				+ folio + ", shareHolderName=" + shareHolderName + ", holdingValue=" + holdingValue
				+ ", holdingPercentage=" + holdingPercentage + ", minorCode=" + minorCode + ", date=" + date + "]";
	}

	public ShareHolderDataForm(String id, String clientId, String portfoliold, String folio, String shareHolderName,
			String holdingValue, String holdingPercentage, String minorCode, long date) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.portfoliold = portfoliold;
		this.folio = folio;
		this.shareHolderName = shareHolderName;
		this.holdingValue = holdingValue;
		this.holdingPercentage = holdingPercentage;
		this.minorCode = minorCode;
		this.date = date;
	}
	
	
	
	
	
	
}
