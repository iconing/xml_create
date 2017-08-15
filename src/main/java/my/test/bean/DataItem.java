package my.test.bean;

import java.io.Serializable;

public class DataItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dataEleName = "Item";
	private String abt_ItemName;
	private String abt_ItemDesc;
	private String abt_ItemType = "DataDict";
	private String abt_TypeName;
	private String abt_ItemDeft = "";
	private String abt_ElemType = "No";
	private String abt_Array = "No";
	private String abt_NodeType = "Node";
	private String abt_Security = "No";
	private String abt_EnumName = "";
	private String abt_EnumKvp = "";
	private String abt_RelateItemName = "";
	private String subele_ScopeExpr = "ScopeExpr";
	private String subele_ScopeExpr_text;
	
	public String getSubele_ScopeExpr_text() {
		return subele_ScopeExpr_text;
	}
	public void setSubele_ScopeExpr_text(String subele_ScopeExpr_text) {
		this.subele_ScopeExpr_text = subele_ScopeExpr_text;
	}
	public String getDataEleName() {
		return dataEleName;
	}
	public void setDataEleName(String dataEleName) {
		this.dataEleName = dataEleName;
	}
	public String getAbt_ItemName() {
		return abt_ItemName;
	}
	public void setAbt_ItemName(String abt_ItemName) {
		this.abt_ItemName = abt_ItemName;
	}
	public String getAbt_ItemDesc() {
		return abt_ItemDesc;
	}
	public void setAbt_ItemDesc(String abt_ItemDesc) {
		this.abt_ItemDesc = abt_ItemDesc;
	}
	public String getAbt_ItemType() {
		return abt_ItemType;
	}
	public void setAbt_ItemType(String abt_ItemType) {
		this.abt_ItemType = abt_ItemType;
	}
	public String getAbt_TypeName() {
		return abt_TypeName;
	}
	public void setAbt_TypeName(String abt_TypeName) {
		this.abt_TypeName = abt_TypeName;
	}
	public String getSubele_ScopeExpr() {
		return subele_ScopeExpr;
	}
	public void setSubele_ScopeExpr(String subele_ScopeExpr) {
		this.subele_ScopeExpr = subele_ScopeExpr;
	}
	public String getAbt_ItemDeft() {
		return abt_ItemDeft;
	}
	public void setAbt_ItemDeft(String abt_ItemDeft) {
		this.abt_ItemDeft = abt_ItemDeft;
	}
	public String getAbt_ElemType() {
		return abt_ElemType;
	}
	public void setAbt_ElemType(String abt_ElemType) {
		this.abt_ElemType = abt_ElemType;
	}
	public String getAbt_Array() {
		return abt_Array;
	}
	public void setAbt_Array(String abt_Array) {
		this.abt_Array = abt_Array;
	}
	public String getAbt_NodeType() {
		return abt_NodeType;
	}
	public void setAbt_NodeType(String abt_NodeType) {
		this.abt_NodeType = abt_NodeType;
	}
	public String getAbt_Security() {
		return abt_Security;
	}
	public void setAbt_Security(String abt_Security) {
		this.abt_Security = abt_Security;
	}
	public String getAbt_EnumName() {
		return abt_EnumName;
	}
	public void setAbt_EnumName(String abt_EnumName) {
		this.abt_EnumName = abt_EnumName;
	}
	public String getAbt_EnumKvp() {
		return abt_EnumKvp;
	}
	public void setAbt_EnumKvp(String abt_EnumKvp) {
		this.abt_EnumKvp = abt_EnumKvp;
	}
	public String getAbt_RelateItemName() {
		return abt_RelateItemName;
	}
	public void setAbt_RelateItemName(String abt_RelateItemName) {
		this.abt_RelateItemName = abt_RelateItemName;
	}
	@Override
	public String toString() {
		return "DataObj [dataEleName=" + dataEleName + ", abt_ItemName=" + abt_ItemName + ", abt_ItemDesc="
				+ abt_ItemDesc + ", abt_ItemType=" + abt_ItemType + ", abt_TypeName=" + abt_TypeName
				+ ", subele_ScopeExpr=" + subele_ScopeExpr + "]";
	}

}
