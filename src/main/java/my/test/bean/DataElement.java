package my.test.bean;

import java.io.Serializable;

public class DataElement implements Serializable{
	private static final long serialVersionUID = 1L;

	private String DataType = "Struct";
	private String ElemName = "OBJ_IBPSN_CBSMPS0070_RES";
	private String ElemDesc = "客户信息查询接收报文";
	private String NodeClassName = "IBPSN";
	private String NodeClassDesc = "农信银超级网银";
	private String XmlNodeName = "Document";
	public String getDataType() {
		return DataType;
	}
	public void setDataType(String dataType) {
		DataType = dataType;
	}
	public String getElemName() {
		return ElemName;
	}
	public void setElemName(String elemName) {
		ElemName = elemName;
	}
	public String getElemDesc() {
		return ElemDesc;
	}
	public void setElemDesc(String elemDesc) {
		ElemDesc = elemDesc;
	}
	public String getNodeClassName() {
		return NodeClassName;
	}
	public void setNodeClassName(String nodeClassName) {
		NodeClassName = nodeClassName;
	}
	public String getNodeClassDesc() {
		return NodeClassDesc;
	}
	public void setNodeClassDesc(String nodeClassDesc) {
		NodeClassDesc = nodeClassDesc;
	}
	public String getXmlNodeName() {
		return XmlNodeName;
	}
	public void setXmlNodeName(String xmlNodeName) {
		XmlNodeName = xmlNodeName;
	}

}
