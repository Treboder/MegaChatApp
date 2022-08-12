package udacity.exercises.MegaChatApp;

public class ChatMessage {

    private String user;
    private String message;
    private String type;

    public ChatMessage(String user, String message, String type) {
        this.user = user;
        this.message = message;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        if(type.equals("shout-mode"))
            return message.toUpperCase();
        else if (type.equals("whisper-mode"))
            return message.toLowerCase();
        return message;
    }

    // not used/necessary, but functioning
    public String getMessageShouted() {
        return message.toUpperCase();
    }

    // not used/necessary, but functioning
    public String getMessageWhispered() {
        return message.toLowerCase();
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
