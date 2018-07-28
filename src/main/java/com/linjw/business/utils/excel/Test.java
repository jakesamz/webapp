package com.linjw.business.utils.excel;

import java.util.ArrayList;
import java.util.List;

import com.linjw.business.utils.excel.export.AbstractExcelExportConfig;
import com.linjw.business.utils.excel.export.impl.Course;
import com.linjw.business.utils.excel.export.impl.CourseExportConfig;
import com.linjw.business.utils.excel.imp.impl.CheckStudentExcelImpl;
import com.linjw.business.utils.excel.imp.impl.Student;


public class Test {
	
	
	public static void main(String[] args) throws Exception {
		testExportExcel();
	}
	
	public static void testImportExcel() {
		String filePath = ExcelUtils.class.getResource("").getPath() + "student-data.xlsx";
		List<Student> list = null;
		try {
			list = ExcelUtils.readExcel(filePath, Student.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		
		//ICheckExcel bgtcheck = new BudgetMantianCheck();
		//bgtcheck.check();
		new CheckStudentExcelImpl().doImport(list);
	}
	
	public static void testExportExcel() throws Exception {
		Course c1 = new Course("WSDFERHI_43DFG", "Math");
		Course c2 = new Course("DFOIDOIH_345IS", "Mandarin");
		List<Course> ca = new ArrayList<>();
		ca.add(c1);
		ca.add(c2);
		//ex.setPrintHeader(false);
		//ex.setStartRowIndex(1);
		ExcelUtils.export(ca, new CourseExportConfig());
	}
	
	

}
