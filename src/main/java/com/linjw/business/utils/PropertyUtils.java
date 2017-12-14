package com.linjw.business.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyUtils {
    static{
        loadProps();
    }
    private static Properties props;
    synchronized static private void loadProps(){
        props = new Properties();
        InputStream in = null;
        try {
        	in = PropertyUtils.class.getClassLoader().getResourceAsStream("system_config.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
    
    public static void main(String[] args) {
	}
}