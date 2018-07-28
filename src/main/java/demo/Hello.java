package demo;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class Hello {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://github.com");
        URLConnection connection = url.openConnection();
        connection.connect();

        printHeaders(connection);
        printContent(connection);

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
