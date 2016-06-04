package com.ayuayu.utils;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {

	public static Document parse(File file) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static Document parse(InputStream is) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	@SuppressWarnings("unchecked")
	private static void printElement(Element element) {
		System.out.println(element.getName() + ":\n\t" + element.getTextTrim());
		// 取得該TAG的Attr
		List<Attribute> attributes = element.attributes();
		for (Attribute attribute : attributes) {
			System.out.println("\tAttr:" + attribute.getName() + ":"
					+ attribute.getValue());
		}
		List<Element> elements = element.elements("context");
		for (Element e : elements)
			printElement(e);
	}

	public static void print(Document document) {
		Element root = document.getRootElement();
		printElement(root);
	}

}