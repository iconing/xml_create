package my.test.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import my.test.util.ExcelUtil;
import org.dom4j.Element;

import my.test.bean.DataElement;
import my.test.bean.DataItem;
import my.test.util.XmlUtil;

public class XmlTest {
	/**
	 * 	 * 生成数据项的xml元素Item节点
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
	public static void main(String[] args) throws Exception {
		String excelFilePath = "C:\\Users\\Administrator\\Desktop\\test.xlsx";
		Map<String, String> map = ExcelUtil.getMap(excelFilePath);

		List<Element> itemeles = new LinkedList<Element>();
		for(Entry<String, String> e : map.entrySet()) {
			DataItem di = new DataItem();
			di.setAbt_ItemName(e.getKey());
			di.setAbt_ItemDesc(e.getValue());
			di.setAbt_TypeName("BRCH_NO");
			itemeles.add(XmlUtil.toDataObjElement(di));
		}
		DataElement de = new DataElement();
		de.setElemName("OBJ_IBPSN_CBSMPS0160_REQ");
		de.setElemDesc("对账通知请求报文");
		de.setXmlNodeName("Document");
		Element dataEle = XmlUtil.toDataElement(de);
		dataEle.add(XmlUtil.getItemTab(itemeles));

		String path = "C:\\Users\\Administrator\\Desktop\\bbbb.xml";
		OutputStream os = new FileOutputStream(new File(path));
		os.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
		os.write("<DataElementTab RecNum=\"1\">".getBytes());
		os.write(dataEle.asXML()
				.replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">")
				.getBytes());
		os.write("</DataElementTab>".getBytes());
		os.flush();
		os.close();
		
		System.out.println(dataEle.asXML());
		System.out.println("success");
	}

}
