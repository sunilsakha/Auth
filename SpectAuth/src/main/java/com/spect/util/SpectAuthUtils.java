package com.spect.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class SpectAuthUtils {

	public static ServiceResponse sendPostWithExtraParamToCSC(String url, String urlParameters, String authkey) {
		ServiceResponse serviceResponse = new ServiceResponse();

		HttpHeaders detailsTokenHeader = new HttpHeaders();
		detailsTokenHeader.setContentType(MediaType.APPLICATION_JSON);
		detailsTokenHeader.set("Authorization", "Basic " + authkey);
		detailsTokenHeader.add("Accept", "application/json;charset=utf-8");
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(urlParameters, detailsTokenHeader);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = rest.exchange(url, HttpMethod.POST, httpEntity, String.class);
			serviceResponse.setData(responseEntity.getBody());
			serviceResponse.setStatus(200);
		} catch (HttpClientErrorException ce) {
			if (ce.getStatusCode().equals(HttpStatus.CONFLICT)) {
				serviceResponse.setStatus(409);
			}
			if (ce.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				serviceResponse.setStatus(400);
			}
			if (ce.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
				serviceResponse.setStatus(Constants.HTTP_STATUS_CODE_SESSION_EXPIRED);
			}
		} catch (HttpServerErrorException es) {
			if (es.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				serviceResponse.setData(es.getResponseBodyAsString());
				serviceResponse.setStatus(500);
			}
			if (es.getStatusCode().equals(HttpStatus.NOT_IMPLEMENTED)) {
				serviceResponse.setData(es.getResponseBodyAsString());
				serviceResponse.setStatus(501);
			}
		} catch (Exception e) {

			serviceResponse.setStatus(500);
		}
		return serviceResponse;
	}
}
