package mega_chat_app.service;

import mega_chat_app.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChatMessageService {

    private ArrayList<ChatMessage> chatHistoryObjects = new ArrayList<>();

    public ChatMessageService() {
        chatHistoryObjects.add(new ChatMessage("System", "Wtf, who are you?", "say"));
    }

    public void addMessage(String user, String message, String type) {
        chatHistoryObjects.add(new ChatMessage(user, message, type));
    }

    public ArrayList<ChatMessage> getMessageHistory() {
        return chatHistoryObjects;
    }

}
