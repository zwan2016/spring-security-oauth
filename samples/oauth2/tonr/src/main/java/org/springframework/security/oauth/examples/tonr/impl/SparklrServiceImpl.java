package org.springframework.security.oauth.examples.tonr.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.security.oauth.examples.tonr.SparklrException;
import org.springframework.security.oauth.examples.tonr.SparklrService;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.client.RestOperations;

/**
 * @author Ryan Heaton
 */
public class SparklrServiceImpl implements SparklrService {

	private String sparklrUserURL;
	private String sparklrTrustedMessageURL;
	private String sparklrPhotoURLPattern;
	private RestOperations sparklrRestTemplate;
	private RestOperations trustedClientRestTemplate;

	public JsonObject getSparklrUser() throws SparklrException {
		String userJson = sparklrRestTemplate.getForObject(URI.create(sparklrUserURL), String.class);
		OAuth2RestTemplate o = (OAuth2RestTemplate)sparklrRestTemplate;
		JsonObject jsonObject = new JsonParser().parse(userJson).getAsJsonObject();
		System.out.println(o.getAccessToken());
		System.out.println(o.getOAuth2ClientContext());
		return jsonObject;
	}

	public InputStream loadSparklrPhoto(String id) throws SparklrException {
		return new ByteArrayInputStream(sparklrRestTemplate.getForObject(
				URI.create(String.format(sparklrPhotoURLPattern, id)), byte[].class));
	}

	public String getTrustedMessage() {
		return this.trustedClientRestTemplate.getForObject(URI.create(sparklrTrustedMessageURL), String.class);
	}

	public void setSparklrPhotoURLPattern(String sparklrPhotoURLPattern) {
		this.sparklrPhotoURLPattern = sparklrPhotoURLPattern;
	}

	public void setSparklrUserURL(String sparklrPhotoListURL) {
		this.sparklrUserURL = sparklrPhotoListURL;
	}
	
	public void setSparklrTrustedMessageURL(String sparklrTrustedMessageURL) {
		this.sparklrTrustedMessageURL = sparklrTrustedMessageURL;
	}

	public void setSparklrRestTemplate(RestOperations sparklrRestTemplate) {
		this.sparklrRestTemplate = sparklrRestTemplate;
	}

	public void setTrustedClientRestTemplate(RestOperations trustedClientRestTemplate) {
		this.trustedClientRestTemplate = trustedClientRestTemplate;
	}

}
