package vn.com.seabank.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import vn.com.seabank.service.dto.*;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class RawDataService {

    @Value("${basel.service.uri}")
    private String uri;
    @Value("${basel.service.header.api}")
    private String api;
    @Value("${basel.service.header.apiKey}")
    private String apiKey;
    @Value("${basel.service.header.sender}")
    private String sender;
    @Value("${basel.service.command.getConfigTable}")
    private String commandConfigTable;
    @Value("${basel.service.command.getValueTable}")
    private String commandValueTable;
    @Value("${basel.service.command.changeConfigTable}")
    private String commandChangeConfigTable;
    @Value("${basel.service.command.insertData}")
    private String commandInsertData;


    private RequestHeader requestHeader;

    private final Logger log = LoggerFactory.getLogger(RawDataService.class);

    public Object getTableRawData(BS2GetDataRequest request) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map body = new HashMap<>();
        RequestHeader header = new RequestHeader();
        header.setCommand(commandValueTable);
        header.setApi(api);
        header.setApiKey("");
        header.setSender(sender);
        header.setReq_time(String.valueOf(System.currentTimeMillis()));
        header.setTraceid(GenerateRandom.randomGenarate());
        header.setSessionid("123321");
        Map bodyRequest = new HashMap();
        bodyRequest.put("BS2_GET_DATA", request);

        body.put("header", header);
        body.put("body", bodyRequest);
        log.info("API: "+body.toString());
        HttpEntity<Map> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<BaselResponse> response =
            template.exchange(uri, HttpMethod.POST, requestEntity,
                BaselResponse.class);
        log.info("Response " + response.toString());
        return response.getBody();
    }

    public Object getConfigTable(String tableName) {
        try {
            RestTemplate template = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // tạo header request
            RequestHeader header = new RequestHeader();
            header.setCommand(commandConfigTable);
            header.setApi(api);
            header.setApiKey("");
            header.setSender(sender);
            header.setTraceid(GenerateRandom.randomGenarate());
            header.setReq_time(String.valueOf(System.currentTimeMillis()));

            // tạo body request
            BS2ConfigTblBodyRequest bs2ConfigGrpTblBodyRequest = new BS2ConfigTblBodyRequest();
            bs2ConfigGrpTblBodyRequest.setTbl_name(tableName);
            Map bodyRequest = new HashMap();
            bodyRequest.put("BS2_CONFIG_TBL", bs2ConfigGrpTblBodyRequest);

            //tạo body
            Map body = new HashMap();
            body.put("header", header);
            body.put("body", bodyRequest);
            log.info("API: "+body.toString());
            HttpEntity<Map> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<BaselResponse> response =
                template.exchange(uri, HttpMethod.POST, requestEntity,
                    BaselResponse.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }

    public Object changeConfigTable(BS2ChangeConfigBodyRequest request){
        try {
            RestTemplate template = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // tạo header request
            RequestHeader header = new RequestHeader();
            header.setCommand(commandChangeConfigTable);
            header.setApi(api);
            header.setApiKey("");
            header.setSender(sender);
            header.setTraceid(GenerateRandom.randomGenarate());
            header.setReq_time(String.valueOf(System.currentTimeMillis()));

            // tạo body request

            Map bodyRequest = new HashMap();
            bodyRequest.put("BS2_CHANGE_CONFIG_TBL", request);

            //tạo body
            Map body = new HashMap();
            body.put("header", header);
            body.put("body", bodyRequest);
            log.info("API: "+body.toString());

            HttpEntity<Map> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<BaselResponse> response =
                template.exchange(uri, HttpMethod.POST, requestEntity,
                    BaselResponse.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }

    public Object insertData(BS2InsertDataBodyRequest request){
        try {
            RestTemplate template = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // tạo header request
            RequestHeader header = new RequestHeader();
            header.setCommand(commandInsertData);
            header.setApi(api);
            header.setApiKey("");
            header.setSender(sender);
            header.setTraceid(GenerateRandom.randomGenarate());
            header.setReq_time(String.valueOf(System.currentTimeMillis()));

            // tạo body request

            Map bodyRequest = new HashMap();
            bodyRequest.put("BS2_INSERT_DATA", request);

            //tạo body
            Map body = new HashMap();
            body.put("header", header);
            body.put("body", bodyRequest);


            JsonParser parser = new JsonParser();
            log.info("API: "+parser.parse(body.toString()));


            HttpEntity<Map> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<BaselResponse> response =
                template.exchange(uri, HttpMethod.POST, requestEntity,
                    BaselResponse.class);
            log.info("API RESPONSE"+response.getBody().toString());
                return response.getBody();
        }catch (Exception e){
            throw e;
        }
    }
}
