package utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtil {

    public static void checkBrokenLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400)
                System.out.println(linkUrl + " --> " + httpURLConnection.getResponseCode() +" - " + httpURLConnection.getResponseMessage() + " --> is a broken link");
            else
                System.out.println(linkUrl + " --> " + httpURLConnection.getResponseCode() +" - " + httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}