package com.shiya.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonTest {
	static final Logger log = Logger.getLogger(JsonTest.class);
//	static String jsonDemo = "{\"subject\":\"test_89123\",\"from\":\"shuang234@state。com\",\"id\":\"test_id\",\"type\":\"EMAIL\""
//			+ ",\"body\":\"test_id\\\\{sdf&w $}dsfsd dfgwqe  test @AML test:tger, \n \\\\{sdfwe\\\\:\"}";
	static String jsonDemo ="{\"subject\":\"test_89123\",\"from\":\"shuang234@state。com\",\"id\":\"test_id\",\"type\":\"EMAIL\""
			+ ",\"body\":\"test_id:\\\\{sdf&w $}dsfsd df\\\\:gwqe  test @AML test:tger, \n \\\\{sdfwe\\\\:\"}";
	/**
	 * @param args
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @{@link Deprecated generate json string is different with typing string, \n exactly is \\n.jsonMapper auto using transfer}
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		JavaType javaTypeList =TypeFactory.defaultInstance().constructParametricType(List.class, String.class); 
		// JavaType javaTypeMap =
		// TypeFactory.defaultInstance().constructParametrizedType(Map.class,String.class,
		// Object.class);
		TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>() {
		};
		System.out.println("jsonDemo is :" + jsonDemo);
		System.out.println("jsonDemo replace : "+jsonDemo.replaceAll("\\\\", "^"));
//		System.out.println("\\\\gregdbn\reerwafab\nv &%^^^");
		JSONObject jsonObj = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
//		mapper.readValue(jsonDemo, Map.class);
		
		Map list = new HashMap();
		list.put("id", "test_id");
		list.put("subject", "test_89123");
		list.put("from", "shuang234@state。com");
		list.put("type", "EMAIL");
		list.put("body", "test_id:\\{sdf&w $}dsfsd df\\:gwqe  test @AML test:tger, \n \\{sdfwe\\:");
		String jsonStr = mapper.writeValueAsString(list);
		System.out.println("jsonStr is :"+jsonStr);
		System.out.println("replace 2: "+jsonStr.replaceAll("\\\\", "^"));
		System.out.println("------------");
		Map<String, Object>  readValue = mapper.readValue(jsonStr, Map.class);
		for (Map.Entry<String, Object> entry : readValue.entrySet()) {
			 System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
		}
	}
		
		
//		{"subject":"test_89123","from":"shuang234@state。com","id":"test_id","type":"EMAIL","body":"test_id\\{sdf&w $}dsfsd dfgwqe  test @AML test:tger, \n \\{sdfwe\\:"}
//		"{\"subject\":\"test_89123\",\"from\":\"shuang234@state。com\",\"id\":\"test_id\",\"type\":\"EMAIL\",\"body\":\"test_id\\\\{sdf&w $}dsfsd dfgwqe  test @AML test:tger, \\n \\\\{sdfwe\\\\:\"}"
}
