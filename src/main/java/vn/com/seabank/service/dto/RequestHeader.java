package vn.com.seabank.service.dto;

import org.springframework.beans.factory.annotation.Value;

public class RequestHeader {
    private String api;
    private String apiKey;
    private String command;
    private String sender;

    private String traceid;
    private String sessionid;
    private String req_time;

    public void setApi(String api) {
        this.api = api;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getApi() {
        return api;
    }


    public String getApiKey() {
        return apiKey;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getSender() {
        return sender;
    }

    public String getTraceid() {
        return traceid;
    }

    public void setTraceid(String traceid) {
        this.traceid = traceid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getReq_time() {
        return req_time;
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    public RequestHeader(String api, String apiKey, String command, String sender, String traceid, String sessionid, String req_time) {
        this.api = api;
        this.apiKey = apiKey;
        this.command = command;
        this.sender = sender;
        this.traceid = traceid;
        this.sessionid = sessionid;
        this.req_time = req_time;
    }

    public RequestHeader() {
    }

    @Override
    public String toString() {
        return "{" +
            "api='" + api + '\'' +
            ", apiKey='" + apiKey + '\'' +
            ", command='" + command + '\'' +
            ", sender='" + sender + '\'' +
            ", traceid='" + traceid + '\'' +
            ", sessionid='" + sessionid + '\'' +
            ", req_time='" + req_time + '\'' +
            '}';
    }
}
