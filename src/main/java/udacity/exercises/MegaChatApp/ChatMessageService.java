package udacity.exercises.MegaChatApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChatMessageService {

    private ArrayList<ChatMessage> chatHistoryObjects = new ArrayList<>();

    public ChatMessageService() {
        chatHistoryObjects.add(new ChatMessage("system", "initial message", "say"));
    }

    public void addMessage(String user, String message, String type) {
        chatHistoryObjects.add(new ChatMessage(user, message, type));
    }

    public ArrayList<ChatMessage> getMessageHistory() {
        return chatHistoryObjects;
    }

}
