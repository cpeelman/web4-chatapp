package caro.domain;


public class Message {

    private String messageId;
    private String senderId;
    private String receiverId;
    private String message;
    private long timeStamp;

    public Message(String messageId, String senderId, String receiverId, String message, long timeStamp) {
        setMessageId(messageId);
        setSenderId(senderId);
        setReceiverId(receiverId);
        setMessage(message);
        setTimeStamp(timeStamp);
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
