package com.example.InvestorRelationBackend.masterData;

public class FinancialRatio {
	private String id;

	private String formulaName;

	private String formulaType;

	private String formula;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormulaName() {
		return formulaName;
	}

	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}

	public String getFormulaType() {
		return formulaType;
	}

	public void setFormulaType(String formulaType) {
		this.formulaType = formulaType;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "FinancialRatio [id=" + id + ", formulaName=" + formulaName + ", formulaType=" + formulaType
				+ ", formula=" + formula + "]";
	}

	public FinancialRatio(String id, String formulaName, String formulaType, String formula) {
		super();
		this.id = id;
		this.formulaName = formulaName;
		this.formulaType = formulaType;
		this.formula = formula;
	}

	public FinancialRatio() {
		super();
	}
	
	

}