package com.personal.common.utils;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class HttpClientUtils {
	

	/**
	 * 发送Httppost请求，请求内容为Json格式的字符串
	 * 
	 * @param url
	 *            请求Url
	 * @param sendContext
	 *            请求内容
	 * @param charSet
	 *            字符集编码
	 * @return 响应内容，为Json格式的字符串
	 * @throws IOException
	 */
	public static String PostJson(String url, String sendContext, String charSet)
			throws IOException {
		String resContent = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpost = null;
		try {
			httpost = new HttpPost(url);
			StringEntity stringEntity = new StringEntity(sendContext, charSet);
			stringEntity.setContentType("application/json");
			httpost.setEntity(stringEntity);

			HttpResponse response = httpclient.execute(httpost);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == statusCode) {
				resContent = EntityUtils.toString(responseEntity, charSet);
				// resContent = new
				// String(resContent.getBytes("ISO-8859-1"),"UTF-8");
			}
			if (responseEntity != null) {
				EntityUtils.consume(responseEntity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpost.releaseConnection();
			httpclient.close();
		}
		return resContent;
	}


	/**
	 * Do POST request
	 *
	 * @param url
	 * @param parameterMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String doPost(String url, Map parameterMap) throws Exception {

		/* Translate parameter map to parameter date string */
		StringBuffer parameterBuffer = new StringBuffer();
		if (parameterMap != null) {
			Iterator iterator = parameterMap.keySet().iterator();
			String key = null;
			String value = null;
			while (iterator.hasNext()) {
				key = (String) iterator.next();
				if (parameterMap.get(key) != null) {
					value = (String) parameterMap.get(key);
				} else {
					value = "";
				}

				parameterBuffer.append(key).append("=").append(value);
				if (iterator.hasNext()) {
					parameterBuffer.append("&");
				}
			}
		}

		System.out.println("POST parameter : " + parameterBuffer.toString());

		URL localURL = new URL(url);

		URLConnection connection = openConnection(localURL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));

		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		try {
			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);

			outputStreamWriter.write(parameterBuffer.toString());
			outputStreamWriter.flush();

			if (httpURLConnection.getResponseCode() >= 300) {
				throw new Exception(
						"HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
			}

			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}

		return resultBuffer.toString();
	}


	private static URLConnection openConnection(URL localURL) throws IOException {
		URLConnection connection;
		connection = localURL.openConnection();
		return connection;
	}

	/**
	 * 发送Httppost请求，请求内容为Json格式的字符串
	 *
	 * @param url
	 *            请求Url
	 * @param charSet
	 *            字符集编码
	 * @return 响应内容，为Json格式的字符串
	 * @throws IOException
	 */
	public static String getString(String url, String charSet)
			throws IOException {
		String resContent = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == statusCode) {
				resContent = EntityUtils.toString(responseEntity, charSet);
				// resContent = new
				// String(resContent.getBytes("ISO-8859-1"),"UTF-8");
			}
			if (responseEntity != null) {
				EntityUtils.consume(responseEntity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			httpclient.close();
		}
		return resContent;
	}

	/**
	 * 发送Httppost请求，请求内容为Json格式的字符串，并进行urlencode
	 * 
	 * @param url
	 *            请求Url
	 * @param sendContext
	 *            请求内容
	 * @param charSet
	 *            字符集编码
	 * @return 响应内容，为Json格式的字符串
	 * @throws IOException
	 */
	public static String PostJsonUrlEncode(String url, String sendContext, String charSet)
			throws IOException {
		String resContent = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpost = null;
		try {
			httpost = new HttpPost(url);
			sendContext = URLEncoder.encode(sendContext,charSet);
			StringEntity stringEntity = new StringEntity(sendContext, charSet);
			stringEntity.setContentType("application/json");
			httpost.setEntity(stringEntity);

			HttpResponse response = httpclient.execute(httpost);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == statusCode) {
				resContent = EntityUtils.toString(responseEntity, charSet);
				// resContent = new
				// String(resContent.getBytes("ISO-8859-1"),"UTF-8");
			}
			if (responseEntity != null) {
				EntityUtils.consume(responseEntity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpost.releaseConnection();
			httpclient.close();
		}
		return resContent;
	}



	public static void uploadFile(String url,Map<String,Object> map,String charSet) throws IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
		multipartEntityBuilder.addBinaryBody("cover",new File("/Users/mazongwang/Downloads/1506338473803499926.jpg"));
		multipartEntityBuilder.addTextBody("userId",MapUtils.getString(map,"userId"), ContentType.parse(charSet));
		multipartEntityBuilder.addTextBody("token",MapUtils.getString(map,"token"), ContentType.parse(charSet));
		HttpEntity httpEntity = multipartEntityBuilder.build();
		httpPost.setEntity(httpEntity);
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity responseEntity = httpResponse.getEntity();
		int statusCode= httpResponse.getStatusLine().getStatusCode();
		if(statusCode == 200){
			BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
			StringBuffer buffer = new StringBuffer();
			String str = "";
			while(StringUtils.isNotEmpty(str = reader.readLine())) {
				buffer.append(str);
			}

			System.out.println(buffer.toString());
		}

		httpClient.close();
		if(httpResponse!=null){
			httpResponse.close();
		}
	}

	public static String doGet(String url) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String result = "";
		try {
			// 通过址默认配置创建一个httpClient实例
			httpClient = HttpClients.createDefault();
			// 创建httpGet远程连接实例
			HttpGet httpGet = new HttpGet(url);
			// 设置请求头信息，鉴权
			httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
			// 设置配置请求参数
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
					.setConnectionRequestTimeout(35000)// 请求超时时间
					.setSocketTimeout(60000)// 数据读取超时时间
					.build();
			// 为httpGet实例设置配置
			httpGet.setConfig(requestConfig);
			// 执行get请求得到返回对象
			response = httpClient.execute(httpGet);
			// 通过返回对象获取返回数据
			HttpEntity entity = response.getEntity();
			// 通过EntityUtils中的toString方法将结果转换为字符串
			result = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
