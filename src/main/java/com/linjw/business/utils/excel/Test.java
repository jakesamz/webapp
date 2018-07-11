package com.linjw.business.utils.excel;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class Test {
	
	
	public static void main(String[] args) throws IOException, IntrospectionException {
		String filePath = ExcelUtils.class.getResource("").getPath() + "student-data.xlsx";
		List<Student> list = null;
		try {
			list = ExcelUtils.readExcel(filePath, Student.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotAnExcelFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		
		//ICheckExcel bgtcheck = new BudgetMantianCheck();
		//bgtcheck.check();
		new CheckStudentExcelImpl().doImport(list);
	}
	
	

}
