package top.lbing.test.estest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import top.lbing.test.estest.util.http.HttpESClient;
import top.lbing.test.estest.util.http.Test;

public class App {
	public static void main(String[] args) {
		// tcp
		// 判断索引是否存在，若不存在则创建索引
		// String indexName="index1";
		// String mapping="{\"properties\":{\"message\": {\"type\":\"text\"}}}";
		// try {
		// HttpESClient.initEsClient();
		// if(App.isIndexExist(indexName)) {
		// System.out.println(indexName+" exist");
		// }else {
		// App.createIndex(indexName,mapping);
		// }
		// HttpESClient.closeEsClient();
		// } catch (UnknownHostException e) {
		// e.printStackTrace();
		// }catch (IOException e) {
		// e.printStackTrace();
		// }fin
		
		
		String indexName = "index1";
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("message", "trying out Elasticsearch");
		try {
			HttpESClient.initEsClient();
			Test.insert(indexName, jsonMap);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				HttpESClient.closeEsClient();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
