package mega_chat_app.model;

public class ChatMessage {



    private int messageid;
    private String username;
    private String messagetext;
    private String messagetype;

    public ChatMessage(String user, String message, String type) {
        this.username = user;
        this.messagetext = message;
        this.messagetype = type;
    }

    // called by MessageMapper when inserting/creating a new record in db (setter not required),
    // but also called by Thymeleaf in order to feed chat.html
    public String getUser() {
        return username;
    }

    // called by MessageMapper when inserting/creating a new record in db (setter not required)
    // but also called by Thymeleaf in order to feed chat.html
    public String getMessage() {
        if(messagetype.equals("shout-mode"))
            return messagetext.toUpperCase();
        else if (messagetype.equals("whisper-mode"))
            return messagetext.toLowerCase();
        return messagetext;
    }

    public String getType() {
        return messagetype;
    }




}
