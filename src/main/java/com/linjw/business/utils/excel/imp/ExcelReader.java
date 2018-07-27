package com.linjw.business.utils.excel.imp;

import java.beans.IntrospectionException;
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

	<T> List<T> read(String filePath, Class<T> clazz)
			throws FileNotFoundException, InstantiationException, IllegalAccessException,
			InvocationTargetException, IOException, TemplateFormatException, NoSuchMethodException, SecurityException, IllegalArgumentException, IntrospectionException;

}
