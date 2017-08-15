package my.test.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import my.test.bean.DataElement;
import my.test.bean.DataItem;

public class XmlUtil {
	
	/**
	 * 生成数据项的xml元素Item节点
	 *  <Item ItemName="SndBrhNb"
     * 		ItemDesc="发起机构行号"
     * 		ItemType="DataDict"
     * 		TypeName="BRCH_NO"
     * 		ItemDeft=""
     * 		ElemType="No"
     * 		Array="No"
     * 		NodeType="Node"
     * 		Security="No"
     * 		EnumName =""
     * 		EnumKvp =""
     * 		RelateItemName ="">
     *   <ScopeExpr><![CDATA[]]></ScopeExpr>
	 */
	public static Element toDataObjElement(DataItem dataItem){
		Element ele = DocumentHelper.createElement(dataItem.getDataEleName());
		ele.addAttribute("ItemName", dataItem.getAbt_ItemName());
		ele.addAttribute("ItemDesc", dataItem.getAbt_ItemDesc());
		ele.addAttribute("ItemType", dataItem.getAbt_ItemType());
		ele.addAttribute("TypeName", dataItem.getAbt_TypeName());
		ele.addAttribute("ItemDeft", dataItem.getAbt_ItemDeft());
		ele.addAttribute("ElemType", dataItem.getAbt_ElemType());
		ele.addAttribute("Array", dataItem.getAbt_Array());
		ele.addAttribute("NodeType", dataItem.getAbt_NodeType());
		ele.addAttribute("Security", dataItem.getAbt_Security());
		ele.addAttribute("EnumName", dataItem.getAbt_EnumName());
		ele.addAttribute("EnumKvp", dataItem.getAbt_EnumKvp());
		ele.addAttribute("RelateItemName", dataItem.getAbt_RelateItemName());
		
		Element elesub = ele.addElement(dataItem.getSubele_ScopeExpr());
//		elesub.addText("<![CDATA[" + dataItem.getSubele_ScopeExpr_text() == null ? "" : dataItem.getSubele_ScopeExpr_text() + "]]>");
		elesub.addText("<![CDATA[]]>");

		return ele;
	}
	
	/**
	 * 生成数据项的xml元素Item节点
	 * <DataElement DataType="Struct"
			  ElemName="OBJ_IBPSN_CBSMPS0070_RES"
			  ElemDesc="客户信息查询接收报文"
			  NodeClassName="IBPSN"
			  NodeClassDesc="农信银超级网银"
			  XmlNodeName="Document">
	 */
	public static Element toDataElement(DataElement de) throws  Exception	{
		Element ele = DocumentHelper.createElement("DataElement");
		Field[] fields = de.getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			if(!"serialVersionUID".equals(fields[i].getName())) {
				Method m = de.getClass().getDeclaredMethod("get" + firstLetUper(fields[i].getName()));
				ele.addAttribute(fields[i].getName(), (String)m.invoke(de));
			}
		}
		return ele;
	}
	
	private static String firstLetUper(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
	
	public static Element getItemTab(List<Element> eles)	{
		Element ele = DocumentHelper.createElement("ItemTab");
		ele.addAttribute("RecNum", "" + eles.size());
		for(int i=0; i<eles.size(); i++) {
			ele.add(eles.get(i));
		}
		return ele;
	}
	
	
	public static void main(String[] args) throws Exception {
		for(Field f : DataElement.class.getDeclaredFields()) {
			System.out.println(f.getName());
		}
		for(Method m : DataElement.class.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		DataElement de = new DataElement();
		XmlUtil xu = new XmlUtil();
		System.out.println(xu.toDataElement(de).asXML());
	}

}
