package com.cvrest.cv;

import org.json.JSONObject;
import org.json.XML;

public class TestJsonToXML {
  public static void main(String[] args) {
    String jsonStr = "{\r\n" + "   employee : {\r\n" + "     \"emp_id\":1,\r\n" + "     \"name\":\"Jhon\",\r\n"
        + "     \"cmpName\":\"TATA\"\r\n" + " }\r\n" + "}";

    JSONObject json = new JSONObject(jsonStr);

    System.out.println(XML.toString(json));
    System.out.println(XML.toJSONObject(XML.toString(json)));

  }
}
