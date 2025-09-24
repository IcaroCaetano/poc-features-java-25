package com.myprojecticaro.poc_features_java_25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocFeaturesJava25Application {

	public static void main(String[] args) throws Exception {
		System.out.println("POC Java 25 - Running examples\n");


		System.out.println("-> Structured concurrency example");
		StructuredConcurrency.runExample();


		System.out.println("\n-> Scoped values example");
		ScopedValues.runExample();


		System.out.println("\n-> Flexible constructor example");
		FlexibleConstructor demo = new FlexibleConstructor(42);
		System.out.println(" instance created with value = " + demo.getValue());


		System.out.println("\n-> Primitive pattern example");
		PrimitivePattern.runExample();


		System.out.println("\n-> Vector API example (if module available)");
		VectorApiExample.runExample();


		System.out.println("\n-> PEM utilities example (simple wrapper)");
		String pem = PemUtils.wrapPem("TEST-KEY", "abc123");
		System.out.println(pem);


		System.out.println("\nPOC finished.");
	}

}
