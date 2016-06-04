package com.ayuayu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ReadWebUtil {
	public static String readWebContentByPost(String url,
			Map<String, String> formData, String charset) {
		HttpPost post = prepareData(url, formData);
		return executeHttp(post, charset);
	}

	public static String readWebContentByGet(String url, String charset) {
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-Type", "text/html; charset=" + charset);
		return executeHttp(get, charset);
	}

	public static String fileDownload(String url, String filePath,
			Map<String, String> formData, String charset) {
		HttpPost post = prepareData(url, formData);
		return executeHttp(post, filePath, charset);
	}

	private static HttpPost prepareData(String url, Map<String, String> formData) {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.155 Safari/537.36");
		try {
			List<NameValuePair> pairList = new ArrayList<NameValuePair>();
			for (String key : formData.keySet())
				pairList.add(new BasicNameValuePair(key, formData.get(key)));
			HttpEntity httpEntity;
			httpEntity = new StringEntity(URLEncodedUtils.format(pairList,
					"UTF-8"));
			post.setEntity(httpEntity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return post;
	}

	private static String executeHttp(HttpUriRequest request, String charset) {
		return executeHttp(request, null, charset);
	}

	private static String executeHttp(HttpUriRequest request, String filePath,
			String charset) {
		String result = null;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				if (!StringUtils.isEmpty(filePath) && isDownload(response)) {
					return fileDownload(response, filePath);
				}
				result = EntityUtils.toString(response.getEntity(), charset);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static boolean isDownload(HttpResponse response) {
		boolean result = false;
		if (response.containsHeader("Content-disposition")) {
			Header[] header = response.getHeaders("Content-disposition");
			if (header[0].getValue().contains("attachment"))
				result = true;
		}
		return result;
	}

	private static String fileDownload(HttpResponse response, String filePath) {
		Header[] header = response.getHeaders("Content-disposition");
		File file = new File(filePath);
		if (!file.exists())
			file.mkdir();
		if (!file.isDirectory())
			throw new RuntimeException(file.getName() + " is not dir");
		String fileName = StringUtils.substringBetween(header[0].getValue(),
				"\"");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			bw = new BufferedWriter(new FileWriter(new File(filePath
					+ File.separator + fileName)));
			String line = null;
			while ((line = br.readLine()) != null)
				bw.write(line + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(bw);
		}
		return fileName;
	}
}