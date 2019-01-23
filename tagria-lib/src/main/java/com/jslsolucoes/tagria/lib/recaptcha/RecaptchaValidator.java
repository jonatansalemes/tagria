package com.jslsolucoes.tagria.lib.recaptcha;

import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RecaptchaValidator {

	private String secret;
	private String response;

	private RecaptchaValidator() {

	}

	public static RecaptchaValidator newBuilder() {
		return new RecaptchaValidator();
	}


	

	public RecaptchaValidator withSecret(String secret) {
		this.secret = secret;
		return this;
	}

	public RecaptchaValidator withResponse(String response) {
		this.response = response;
		return this;
	}

	public RecaptchaResponse validate() throws Exception {
		CloseableHttpClient httpclient = client();

		HttpPost httpPost = new HttpPost("https://www.google.com/recaptcha/api/siteverify");

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.setCharset(Charset.forName("UTF-8"));
		builder.addPart("secret", new StringBody(secret, ContentType.TEXT_PLAIN));
		builder.addPart("response", new StringBody(response, ContentType.TEXT_PLAIN));

		HttpEntity entity = builder.build();
		httpPost.setEntity(entity);

		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpclient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				Gson gson = gson();
				return gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), RecaptchaResponse.class);
			} else {
				throw new Exception("Status code não esperado " + httpResponse.getStatusLine().getStatusCode());
			}
		} finally {
			if (httpResponse != null) {
				httpResponse.close();
			}
			httpclient.close();
		}
	}

	private Gson gson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
	}

	private CloseableHttpClient client() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(10000).build();
		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		return HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).setSSLSocketFactory(sslsf).build();
	}
}
