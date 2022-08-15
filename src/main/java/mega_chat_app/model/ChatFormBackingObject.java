package mega_chat_app.model;

public class ChatFormBackingObject {

    private String user;
    private String message;
    private String type;

    // getter setter link lets the ChatController get the form input from chat.html,
    // then passes the fields to the MessageService creating the message object

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
