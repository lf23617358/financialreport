package com.ayuayu.utils;

import java.io.InputStream;

public class TesterUtils {
	public static InputStream getInputStream(String fileName) {
		return ClassLoader.getSystemResourceAsStream("stocks/" + fileName);
	}
}
