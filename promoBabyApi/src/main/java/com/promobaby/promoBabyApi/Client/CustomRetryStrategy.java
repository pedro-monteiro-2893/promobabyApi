package com.promobaby.promoBabyApi.Client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import org.apache.hc.client5.http.ConnectTimeoutException;
import org.apache.hc.client5.http.HttpHostConnectException;
import org.apache.hc.client5.http.HttpRequestRetryStrategy;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;

public class CustomRetryStrategy implements HttpRequestRetryStrategy {

	private final int maxRetryCount;
	private final long retryIntervalMillis;
	
	public CustomRetryStrategy(int maxRetryCount, long retryIntervalMillis) {
		this.maxRetryCount = maxRetryCount;
		this.retryIntervalMillis = retryIntervalMillis;
	}
	
	@Override
	public boolean retryRequest(HttpRequest request, IOException exception, int execCount, HttpContext context) {
		if (execCount >= maxRetryCount) {
            return false; // Não tentar mais
        }
        if (exception instanceof InterruptedIOException) {
            return false; // Timeout
        }
        if (exception instanceof UnknownHostException) {
            return false; // Host desconhecido
        }
        return (exception instanceof ConnectTimeoutException || exception instanceof HttpHostConnectException); 
	}

	@Override
	public boolean retryRequest(HttpResponse response, int execCount, HttpContext context) {
		return false;
	}

	@Override
	public TimeValue getRetryInterval(HttpResponse response, int execCount, HttpContext context) {
		
		if (execCount < maxRetryCount) {
			return TimeValue.ofMilliseconds(retryIntervalMillis); // Tempo de espera entre tentativas
		}
		return TimeValue.ZERO_MILLISECONDS;
	}

}
