package top.lbing.test.estest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import top.lbing.test.estest.utils.transport.ESClient;
import top.lbing.test.estest.utils.transport.ElasticSearchBulkOperator;

public class App {
	public static void main(String[] args) {
		// 测试9200插入10000000条数据耗费的时间
		/*long t1 = System.currentTimeMillis();
		try {
			// 初始化ES
			ESClient.initEsClient();
			for (int i = 0; i < 10000000; i++)
				add2ES1();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ESClient.closeEsClient();
			System.out.println("tack time:" + (System.currentTimeMillis() - t1));
		}*/
		
		// 测试9300插入10000000条数据耗费的时间
		
	}

	/*
	 * ---------- 9200crud↓ ----------
	 */
	public static void add2ES1() {
		String indexId = new String(UUID.randomUUID().toString());
		Map<String, Object> infoJson = new HashMap<>();
		Map<String, Object> json = new HashMap<>();
		// 封装入es的数据
		json.put("name", "Jack");
		json.put("age", "25");
		// set hbase family to es
		infoJson.put("info", json);
		System.out.println(json.toString());
		ElasticSearchBulkOperator.addUpdateBuilderToBulk(
				ESClient.client.prepareUpdate("index111", "doc", indexId).setDocAsUpsert(true).setDoc(json));
		System.out.println("**** postPut success*****");
	}

	public static void del2ES1() throws Exception {
		String indexId = new String(UUID.randomUUID().toString());
		Map<String, Object> infoJson = new HashMap<>();
		Map<String, Object> json = new HashMap<>();
		// 封装入es的数据
		json.put("name", "Jack");
		json.put("age", "25");
		// set hbase family to es
		infoJson.put("info", json);
		System.out.println(json.toString());
		ElasticSearchBulkOperator.addUpdateBuilderToBulk(
				ESClient.client.prepareUpdate("index111", "dmp_ods", indexId).setDocAsUpsert(true).setDoc(json));
		System.out.println("**** postPut success*****");
	}
	/*
	 * ---------- 9200crud↑ ----------
	 */
	
	/*
	 * ---------- 9300crud↓ ----------
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
		ElasticSearchBulkOperator.addUpdateBuilderToBulk(
				ESClient.client.prepareUpdate("index111", "doc", indexId).setDocAsUpsert(true).setDoc(json));
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
		ElasticSearchBulkOperator.addUpdateBuilderToBulk(
				ESClient.client.prepareUpdate("index111", "dmp_ods", indexId).setDocAsUpsert(true).setDoc(json));
		System.out.println("**** postPut success*****");
	}
	/*
	 * ---------- 9300crud↑ ----------
	 */
}

// 走9300端口。PreBuiltTransportClient客户端，批量插入每10000条提交一次，1000w数据，耗时564342 ms。
// 走9200端口，
