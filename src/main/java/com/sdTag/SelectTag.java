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
	 * select标签的id
	 */
	private String id;
	/**
	 * 本select标签sql
	 */
	private String sql;
	
	/**
	 * 被联动select标签sql
	 */
	private String linkSql;
	
	/**
	 * 被联动便签的id
	 */
	private String linkSelectId;
	
	/**
	 * 是否是联动标签
	 */
	private String linking;
	/**
	 * 是否是被联动标签
	 */
	private String linked;
	
	/**
	 * onchange函数名
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
			//--------------------输出select标签--Start------------------------
			String attributes = "id = " + id;//构建select标签的属性
			if("true".equals(linking)){
				attributes += " onchange = \"linkSelect" + id +"(this.value)\"";
			}else 
			if(onChange != null){
				attributes += " onchange = \"" + onChange + "\"";
			}
			
			out.println("<select " + attributes + ">");
			if(!"true".equals(linked)){//如果是被联动标签，则初始化时不显示option列表
				for (Option option : optionList) {
					out.println(String.format("<option value='%s'>%s</option>", option.value, option.detail));
				}
			}
			out.println("</select>");
			//--------------------输出select标签--End------------------------
			
			if("true".equals(linking)){//如果是可联动标签，则构建被联动便签的option列表和相应的script
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
		Connection con = null;// 创建一个数据库连接
        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
        System.out.println("开始尝试连接数据库！");
        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
        String user = "admin";// 用户名,系统默认的账户名
        String password = "admin";// 你安装时选设置的密码
        con = DriverManager.getConnection(url, user, password);// 获取连接
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
