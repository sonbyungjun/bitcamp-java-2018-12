package ch23.h;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test06 {

  public static void main(String[] args) throws Exception{

    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpGet get = new HttpGet("https://www.naver.com");

    CloseableHttpResponse response = httpClient.execute(get);

    HttpEntity entity = response.getEntity();

    if (entity != null) {
      System.out.printf("응답 데이터 크기 => %d\n", entity.getContentLength());
      System.out.printf("응답 데이터 MIME 타입 => %s\n", entity.getContentType());
      System.out.println("-------------------------------");
      String content = EntityUtils.toString(entity);

      System.out.println(content);
    }
  }

}
