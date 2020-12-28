package top.lbing.test.estest.utils.rhl;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * ES Cleint class
 */
public class RHLESClient {
    
    public static RestHighLevelClient  client;
    
    /**
     * init ES client
     */
    public static void initEsClient() throws UnknownHostException {
    	client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));
    }

    /**
     * Close ES client
     * @throws IOException 
     */
    public static void closeEsClient() throws IOException {
        client.close();
    }
}


