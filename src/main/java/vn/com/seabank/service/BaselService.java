package vn.com.seabank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import vn.com.seabank.service.dto.BS2ConfigGrpTblBodyRequest;
import vn.com.seabank.service.dto.BaselResponse;
import vn.com.seabank.service.dto.RequestHeader;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class BaselService {

    @Value("${basel.service.header.api}")
    private String api;
    @Value("${basel.service.header.apiKey}")
    private String apiKey;
    @Value("${basel.service.header.sender}")
    private String sender;
    @Value("${basel.service.command.getNameTable}")
    private String command;
    @Value("${basel.service.uri}")
    private String uri;

    private final Logger log = LoggerFactory.getLogger(BaselService.class);

    public Object getNameTable(String id) {
        try {
            RestTemplate template = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // tạo header request
            RequestHeader header = new RequestHeader();
            header.setCommand(command);
            header.setApi(api);
            header.setApiKey("");
            header.setSender(sender);
            header.setTraceid(GenerateRandom.randomGenarate());
            header.setReq_time(String.valueOf(System.currentTimeMillis()));

            // tạo body request
            BS2ConfigGrpTblBodyRequest bs2ConfigGrpTblBodyRequest = new BS2ConfigGrpTblBodyRequest();
            bs2ConfigGrpTblBodyRequest.setGroup_code(id);
            Map bodyRequest = new HashMap();
            bodyRequest.put("BS2_CONFIG_GRP_TBL", bs2ConfigGrpTblBodyRequest);

            //tạo body
            Map body = new HashMap();
            body.put("header", header);
            body.put("body", bodyRequest);

            HttpEntity<Map> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<BaselResponse> response =
                template.exchange(uri, HttpMethod.POST, requestEntity,
                    BaselResponse.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }
}
