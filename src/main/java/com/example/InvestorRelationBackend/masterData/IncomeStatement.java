package com.example.InvestorRelationBackend.masterData;

public class IncomeStatement {
	
private String id;
	
	private String lineItem;
	
	private String alternativeName;
	
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLineItem() {
		return lineItem;
	}

	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "IncomeStatement [id=" + id + ", lineItem=" + lineItem + ", alternativeName=" + alternativeName
				+ ", type=" + type + "]";
	}

	public IncomeStatement(String id, String lineItem, String alternativeName, String type) {
		super();
		this.id = id;
		this.lineItem = lineItem;
		this.alternativeName = alternativeName;
		this.type = type;
	}

	public IncomeStatement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
