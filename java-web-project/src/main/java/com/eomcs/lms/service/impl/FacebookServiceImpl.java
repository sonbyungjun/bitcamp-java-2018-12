package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eomcs.lms.service.FacebookService;

@Service
public class FacebookServiceImpl implements FacebookService {
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Map getLoginUser(String accessToken) {
    

    // Facebook의 Graph API 실행하기
    // => HTTP 요청을 할 때 스프링에서 제공하는 RestTemplate을 사용하라! 
    // 
    RestTemplate restTemplate = new RestTemplate();
    
    
    HashMap<String,String> values = new HashMap<>();
    values.put("v1", accessToken);
    values.put("v2", "id,name,email");
    
    
    // 원격 서버에서 보낸 JSON 문자열을 Map 객체로 자동 변환하려면
    // JSON 문자열을 처리하는 라이브러리를 추가해 둬야 한다.
    // 따로 코드를 추가할 필요는 없다.
    // => Gson 또는 Jackson 라이브러리
    //
    Map response = restTemplate.getForObject(
        "https://graph.facebook.com/v3.3/me?access_token={v1}&fields={v2}", 
        Map.class,
        values);
        //accessToken,
        //"id,name,email");
        //vars); // 값을 개별적으로 넘기지 않고 맵에 담아 넘길 수도 있다.
  
    // Facebook 사용자의 이메일로 현재 서버의 사용자 정보를 찾는다.
    
    return response;
  }
  
}
