package exceluploader.read;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadMappingConfig {

	
	
	public void read() throws DocumentException {

		SAXReader reader = new SAXReader();
		// 读取文件 转换成Document
		Document document = reader.read(new File("D:\\projects\\CVG2\\SourceCode\\cvg2oss_13012017\\WebApp\\src\\main\\java\\exceluploader\\read\\excel-upload-mappings.xml"));
		// 获取根节点元素对象
		Element root = document.getRootElement();

		listNodes(root);
	}
	
	/**
	 * 验证mapping文件
	 * @param root
	 * @return
	 */
	public boolean validateMappingFile(Element root){
		return true;
	}

	// 遍历当前节点下的所有节点
	public void listNodes(Element node) {
		System.out.println("当前节点的名称：" + node.getName());
		// 首先获取当前节点的所有属性节点
/*		List<Attribute> list = node.attributes();
		// 遍历属性节点
		for (Attribute attribute : list) {
			System.out.println("属性" + attribute.getName() + ":"
					+ attribute.getValue());
		}*/
		if("object".equals(node.getName())){
			handleObjectNode(node);
		}
		// 如果当前节点内容不为空，则输出
		/*if (!(node.getTextTrim().equals(""))) {
			System.out.println(node.getName() + "：" + node.getText());
		}*/
		// 同时迭代当前节点下面的所有子节点
		// 使用递归
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			listNodes(e);
		}
	}
	
	public void handleObjectNode(Element node){
		
		Attribute nameAttribute = node.attribute("name");
		
		Attribute classAttribute = node.attribute("class");
		
		System.out.println(nameAttribute.getText().trim());;
		
		System.out.println(nameAttribute.getText().trim());;
		
	}
	
	public Object initObject(String name){
		return null;
	}
	
	
	
	
	public static void main(String[] args) throws DocumentException {
		new ReadMappingConfig().read();
	}

}
