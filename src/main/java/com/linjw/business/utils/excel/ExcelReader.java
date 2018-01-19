package com.linjw.business.utils.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * Interface that reads excel.
 * @author Administrator
 *
 */
public interface ExcelReader {

	List<Object> read(String filePath, Class<?> clazz)
			throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, TemplateFormatException, NoSuchMethodException, SecurityException;

}
