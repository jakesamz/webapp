package com.linjw.web.attacks.xss;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.JavaScriptUtils;


/**
 * Controller for Cross-site scripting(XXS) Testing.
 * @author ¡÷º”Œ∞
 *
 */

@Controller
public class XssController {

	@RequestMapping(value="xxsPage")
	public void xxsPage(HttpServletRequest request, String xssInput) {
	}
	
	@RequestMapping(value="submitXXS", method=RequestMethod.POST)
	public String submitXXS(HttpServletRequest request, String xssInput) {
		request.setAttribute("xssInput", StringEscapeUtils.escapeHtml4(xssInput));
		return "xxsPage";
	}
	
	
}
