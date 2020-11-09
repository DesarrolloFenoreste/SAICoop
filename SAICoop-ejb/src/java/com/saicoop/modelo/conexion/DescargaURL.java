/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.conexion;

import java.io.BufferedReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author prometeo
 */
public class DescargaURL {

    private String excepcion = null;
    private int estatus = -1;
    private String descripcionEstatus = null;
    private HttpResponse resData;

    public int getEstatus() {
        return estatus;
    }

    public String getDescripcionEstatus() {
        return descripcionEstatus;
    }

    public String getExcepcion() {
        return excepcion;
    }

    private HttpClient getCliente() {
        HttpClient client = null;
        try {
            RequestConfig.Builder requestBuilder = RequestConfig.custom();
            requestBuilder = requestBuilder.setConnectTimeout(360000);
            requestBuilder = requestBuilder.setConnectionRequestTimeout(360000);
            HttpClientBuilder httpCbuilder = HttpClientBuilder.create();
            httpCbuilder.setDefaultRequestConfig(requestBuilder.build());
            client = httpCbuilder.build();
            return client;
        } catch (Exception e) {
            excepcion = excepcion + e.getMessage();
            System.out.println(e);
        }
        return null;
    }

    public HttpURLConnection passmyurl(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            return connection;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private BufferedReader getbufferHttps(String httpsURL, String charset_lectura) {
        try {
            URL myUrl = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection) myUrl.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, Charset.forName(charset_lectura));
            BufferedReader br = new BufferedReader(isr);
            return br;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private BufferedReader getbufferHttp(String httpURL, String charset_lectura) {
        try {
            HttpClient client = getCliente();
            String urlDatos = new URI(httpURL).toASCIIString();
            HttpPost urlData = new HttpPost(urlDatos);
            List<NameValuePair> nvps = new ArrayList<>();
            urlData.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName(charset_lectura)));
            resData = client.execute(urlData);
            BufferedReader br = new BufferedReader(new InputStreamReader(resData.getEntity().getContent(), Charset.forName("ISO-8859-1")));
            return br;
        } catch (IOException | UnsupportedOperationException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> descargaDatosDeURL(String url, String charset_lectura) {
        try {
            BufferedReader br;
            if (url.contains("https")) {
                br = getbufferHttps(url, charset_lectura);
            } else {
                br = getbufferHttp(url, charset_lectura);
            }
            List<String> lineas = new ArrayList<>(0);
            String line = "";
            while ((line = br.readLine()) != null) {
                lineas.add(line);
            }
            return lineas;
        } catch (IOException e) {
            System.out.println(e);
            if (resData != null) {
                estatus = resData.getStatusLine().getStatusCode();
                descripcionEstatus = resData.getStatusLine().getProtocolVersion() + ", " + resData.getStatusLine().getReasonPhrase();
            }
            excepcion = excepcion + e.getMessage();
            return null;
        }
    }
}
