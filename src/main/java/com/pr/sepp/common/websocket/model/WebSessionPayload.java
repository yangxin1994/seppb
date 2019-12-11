package com.pr.sepp.common.websocket.model;

import lombok.Data;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;

@Data
public class WebSessionPayload {

    private List<MessageType> messageTypes;
    private String message;
    private AlertPage alertPage;
    private MessagePage messagePage;
    private Integer userId;
    private Integer productId;

    @Data
    public static class AlertPage {
        private Integer pageNum;
        private Integer pageSize;
    }

    @Data
    public static class MessagePage {
        private Integer pageNum;
        private Integer pageSize;
    }

    public static WebSessionPayload apply(String payload) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(payload, WebSessionPayload.class);
    }
}
