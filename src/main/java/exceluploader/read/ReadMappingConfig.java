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
		// ��ȡ�ļ� ת����Document
		Document document = reader.read(new File("D:\\projects\\CVG2\\SourceCode\\cvg2oss_13012017\\WebApp\\src\\main\\java\\exceluploader\\read\\excel-upload-mappings.xml"));
		// ��ȡ���ڵ�Ԫ�ض���
		Element root = document.getRootElement();

		listNodes(root);
	}
	
	/**
	 * ��֤mapping�ļ�
	 * @param root
	 * @return
	 */
	public boolean validateMappingFile(Element root){
		return true;
	}

	// ������ǰ�ڵ��µ����нڵ�
	public void listNodes(Element node) {
		System.out.println("��ǰ�ڵ�����ƣ�" + node.getName());
		// ���Ȼ�ȡ��ǰ�ڵ���������Խڵ�
/*		List<Attribute> list = node.attributes();
		// �������Խڵ�
		for (Attribute attribute : list) {
			System.out.println("����" + attribute.getName() + ":"
					+ attribute.getValue());
		}*/
		if("object".equals(node.getName())){
			handleObjectNode(node);
		}
		// �����ǰ�ڵ����ݲ�Ϊ�գ������
		/*if (!(node.getTextTrim().equals(""))) {
			System.out.println(node.getName() + "��" + node.getText());
		}*/
		// ͬʱ������ǰ�ڵ�����������ӽڵ�
		// ʹ�õݹ�
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
