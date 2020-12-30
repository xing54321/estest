package top.lbing.test.estest.utils.tcp;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ES Cleint class
 */
public class TcpESClient {
    
    public static Client client;
    
    /**
     * init ES client
     */
    public static void initEsClient() throws UnknownHostException {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        Settings esSettings = Settings.builder().put("cluster.name", "elasticsearch").build();//设置ES实例的名称
        client = new PreBuiltTransportClient(esSettings).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
    }

    /**
     * Close ES client
     */
    public static void closeEsClient() {
        client.close();
    }
    
	
	
	/*
	 * ---------- 9300批量操作↓ ----------
	 */
	public static void add2ES() {
		String indexId = new String(UUID.randomUUID().toString());
		Map<String, Object> infoJson = new HashMap<>();
		Map<String, Object> json = new HashMap<>();
		// 封装入es的数据
		json.put("name", "Jack");
		json.put("age", "25");
		// set hbase family to es
		infoJson.put("info", json);
		System.out.println(json.toString());
		TcpBulkOperator.addUpdateBuilderToBulk(
				TcpESClient.client.prepareUpdate("index111", "doc", indexId).setDocAsUpsert(true).setDoc(json));
		System.out.println("**** postPut success*****");
	}

	public static void del2ES() throws Exception {
		String indexId = new String(UUID.randomUUID().toString());
		Map<String, Object> infoJson = new HashMap<>();
		Map<String, Object> json = new HashMap<>();
		// 封装入es的数据
		json.put("name", "Jack");
		json.put("age", "25");
		// set hbase family to es
		infoJson.put("info", json);
		System.out.println(json.toString());
		TcpBulkOperator.addUpdateBuilderToBulk(
				TcpESClient.client.prepareUpdate("index111", "dmp_ods", indexId).setDocAsUpsert(true).setDoc(json));
		System.out.println("**** postPut success*****");
	}
	/*
	 * ---------- 9300批量操作↑ ----------
	 */
}


