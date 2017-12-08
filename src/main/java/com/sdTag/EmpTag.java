package com.sdTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.jake.Emp;

public class EmpTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Emp emp;

	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			if (emp == null) {

				out.println("No data Found...");

				return SKIP_BODY;

			}
			out.println("<table width='500px' border='3' bordercolor='red' align='center'>");

			out.println("<tr>");

			out.println("<td width='20%'>Emp Id:</td>");

			out.println("<td>" + emp.getEmpId() + "</td>");

			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>Name:</td>");

			out.println("<td>" + emp.getName() + "</td>");

			out.println("</tr>");

			out.println("<tr>");

			out.println("<td>Phone Number:</td>");

			out.println("<td>" + emp.getPhoneNumber() + "</td>");

			out.println("</tr>");

			out.println("</table>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
	
    @Override

    public void release() {

        super.release();

        this.emp = null;

    }

   

    //getter and setters

    public Emp getEmp() {

        return emp;

    }

    public void setEmp(Emp emp) {

        this.emp = emp;

    }

}
