package com.sdTag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class SelectTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * select��ǩ��id
	 */
	private String id;
	/**
	 * ��select��ǩsql
	 */
	private String sql;
	
	/**
	 * ������select��ǩsql
	 */
	private String linkSql;
	
	/**
	 * ��������ǩ��id
	 */
	private String linkSelectId;
	
	/**
	 * �Ƿ���������ǩ
	 */
	private String linking;
	/**
	 * �Ƿ��Ǳ�������ǩ
	 */
	private String linked;
	
	/**
	 * onchange������
	 */
	private String onChange;
	
	
	

	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		
		List<Option> optionList = getLinkingOptionList();
		
		List<Option> linkedOptionList = new ArrayList<Option>();
		
		if(linkSql != null){
			linkedOptionList = getLinkedOptionList();
		}
		
		
		try {
			//--------------------���select��ǩ--Start------------------------
			String attributes = "id = " + id;//����select��ǩ������
			if("true".equals(linking)){
				attributes += " onchange = \"linkSelect" + id +"(this.value)\"";
			}else 
			if(onChange != null){
				attributes += " onchange = \"" + onChange + "\"";
			}
			
			out.println("<select " + attributes + ">");
			if(!"true".equals(linked)){//����Ǳ�������ǩ�����ʼ��ʱ����ʾoption�б�
				for (Option option : optionList) {
					out.println(String.format("<option value='%s'>%s</option>", option.value, option.detail));
				}
			}
			out.println("</select>");
			//--------------------���select��ǩ--End------------------------
			
			if("true".equals(linking)){//����ǿ�������ǩ���򹹽���������ǩ��option�б����Ӧ��script
				out.println("<script type=\"text/javascript\">");
				out.println("function linkSelect" + id + "(value){");
				out.println("	var linkedSelect = document.getElementById('" + linkSelectId + "')");
				out.println("	linkedSelect.options.length=0");
				out.println("	var op=document.createElement('option');");
				for (Option option : linkedOptionList) {
					out.println("	op.setAttribute('value','" + option.value + "');");
					out.println("	op.appendChild(document.createTextNode('" + option.detail +"'));");
					out.println("	linkedSelect.appendChild(op);");
				}
				out.println("}");
				out.println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
	
    @Override

    public void release() {

        super.release();

    }
    
    private class Option{
    	private String value;
    	private String detail;
    	
    	public Option(String value, String detail) {
			this.value = value;
			this.detail = detail;
		}
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getLinkSelectId() {
		return linkSelectId;
	}

	public void setLinkSelectId(String linkSelectId) {
		this.linkSelectId = linkSelectId;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getLinkSql() {
		return linkSql;
	}

	public void setLinkSql(String linkSql) {
		this.linkSql = linkSql;
	}

	public String getLinking() {
		return linking;
	}

	public void setLinking(String linking) {
		this.linking = linking;
	}

	public String getLinked() {
		return linked;
	}

	public void setLinked(String linked) {
		this.linked = linked;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection con = null;// ����һ�����ݿ�����
        Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
        System.out.println("��ʼ�����������ݿ⣡");
        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
        String user = "admin";// �û���,ϵͳĬ�ϵ��˻���
        String password = "admin";// �㰲װʱѡ���õ�����
        con = DriverManager.getConnection(url, user, password);// ��ȡ����
        return con;
	}
	
	public List<Option> getLinkingOptionList() {
		Connection con;
		List<Option> list = new ArrayList<SelectTag.Option>();
		/*try {
			con = getConnection();
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(this.sql);
			while (set.next()) {
				Option o = new Option(set.getString(1), set.getString(2));
				list.add(o);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		return list;
	}
	
	public List<Option> getLinkedOptionList() {
		Connection con;
		List<Option> list = new ArrayList<SelectTag.Option>();
		/*try {
			con = getConnection();
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(this.linkSql);
			while (set.next()) {
				Option o = new Option(set.getString(1), set.getString(2));
				list.add(o);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		return list;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		
		Statement s = con.createStatement();
		ResultSet set = s.executeQuery("select * from address");
		
		while (set.next()) {
			System.out.println(set.getString(1));;
			System.out.println(set.getString(2));;
			System.out.println(set.getString(3));;
		}
	}
}
