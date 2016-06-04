package com.ayuayu.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map.Entry;

import org.apache.commons.lang3.reflect.MethodUtils;

import com.ayuayu.bean.Report;

public class MappingUtils {
	public static <T> T mappingAttr(Report report, Class<T> objClass) {
		T obj = null;
		try {
			obj = objClass.newInstance();
			MethodUtils.invokeMethod(obj, "setStockId", report.getStockId());
			MethodUtils.invokeMethod(obj, "setYear", report.getYear());
			MethodUtils.invokeMethod(obj, "setSeason", report.getSeason());
			for (Entry<String, Number> entry : report.getAllDatas().entrySet()) {
				System.out.println("key:" + entry.getKey() + " value:"
						+ entry.getValue());
				String methodName = "set" + entry.getKey();
				Number number = entry.getValue();
				try {
					if (number.toString().matches("[0-9]+\\.[0-9]+")) {
						MethodUtils.invokeMethod(obj, methodName,
								number.doubleValue());

					} else {
						MethodUtils.invokeMethod(obj, methodName,
								number.longValue());
					}
				} catch (NoSuchMethodException e) {
					System.out.println("no such method: "+methodName +". SKIP...");
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
