package com.example.InvestorRelationBackend.masterData;

public class ShareHolderDataForm {

	private String id;

	private String clientId;

	private String portfolioId;

	private String folio;

	private String shareholderName;

	private String holdingValue;

	private String holdingPercentage;

	private String minorcode;

	private String date;

	public ShareHolderDataForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShareHolderDataForm(String id, String clientId, String portfolioId, String folio, String shareholderName,
			String holdingValue, String holdingPercentage, String minorcode, String date) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.portfolioId = portfolioId;
		this.folio = folio;
		this.shareholderName = shareholderName;
		this.holdingValue = holdingValue;
		this.holdingPercentage = holdingPercentage;
		this.minorcode = minorcode;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getShareholderName() {
		return shareholderName;
	}

	public void setShareholderName(String shareholderName) {
		this.shareholderName = shareholderName;
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

	public String getMinorcode() {
		return minorcode;
	}

	public void setMinorcode(String minorcode) {
		this.minorcode = minorcode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ShareHolderDataForm [id=" + id + ", clientId=" + clientId + ", portfolioId=" + portfolioId + ", folio="
				+ folio + ", shareholderName=" + shareholderName + ", holdingValue=" + holdingValue
				+ ", holdingPercentage=" + holdingPercentage + ", minorcode=" + minorcode + ", date=" + date + "]";
	}

	
}
