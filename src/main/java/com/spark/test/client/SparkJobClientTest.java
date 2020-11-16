package com.spark.test.client;

import java.util.List;
import java.io.File;

import com.bluebreezecf.tools.sparkjobserver.api.ISparkJobServerClient;
import com.bluebreezecf.tools.sparkjobserver.api.SparkJobJarInfo;
import com.bluebreezecf.tools.sparkjobserver.api.SparkJobServerClientException;
import com.bluebreezecf.tools.sparkjobserver.api.SparkJobServerClientFactory;

public class SparkJobClientTest {

	public static void main(String[] args) {
		ISparkJobServerClient client = null;
		try {
			client = SparkJobServerClientFactory.getInstance().createSparkJobServerClient("http://localhost:4567/");

			List<SparkJobJarInfo> jarInfos = client.getJars();
			for (SparkJobJarInfo jarInfo : jarInfos) {
				System.out.println(jarInfo.toString());
			}

			// POST /jars/<appName>
			client.uploadSparkJobJar(
					new File("/Users/guruboya/Desktop/myapp-0.0.1-SNAPSHOT.jar"), null);

			// GET /contexts
			List<String> contexts = client.getContexts();
			System.out.println("Current contexts:");
			for (String cxt : contexts) {
				System.out.println(cxt);
			}
			//client.createContext("hello",null);

		} catch (SparkJobServerClientException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
