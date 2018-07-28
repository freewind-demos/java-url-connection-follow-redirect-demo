package demo;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

// Can just follow the in the same domain and same schema(`http`, `https`)
public class ClientFollowFails {

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:4567/outside";
        URLConnection conn = new URL(url).openConnection();

        // <http://github.com> will response `301` and redirect to <https://github.com>
        HttpURLConnection.setFollowRedirects(true);

        conn.connect();
        printHeaders(conn);
        printContent(conn);
    }

    private static void printContent(URLConnection connection) throws IOException {
        String content = IOUtils.toString(connection.getInputStream(), Charset.defaultCharset());
        System.out.println(content);
    }

    private static void printHeaders(URLConnection connection) {
        Map<String, List<String>> headers = connection.getHeaderFields();
        System.out.println(headers);
    }


}
