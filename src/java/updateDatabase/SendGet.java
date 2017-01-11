/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updateDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author ZENBOOK
 */
public class SendGet {
    private final String USER_AGENT = "Mango M2M HTTP Sender publisher";

    public void sendGet() throws Exception {

//		String url = "https://172.31.0.99/api/im";
                String url = "https://nbtcrehab.eng.psu.ac.th/api/im";

		URL obj = new URL(url);
                ///////////////////////////////////
                
                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        public java.security.cert.X509Certificate[] getAcceptedIssuers()
                        {
                            return null;
                        }
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                            //No need to implement.
                        }
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                            //No need to implement.
                        }
                    }
            };

            // Install the all-trusting trust manager
            try 
            {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
                
                
                
                ///////////////////////////////////
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
}
