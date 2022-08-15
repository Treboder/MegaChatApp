package mega_chat_app.service;

import mega_chat_app.mapper.MessageMapper;
import mega_chat_app.model.ChatMessage;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {

    private int lastID = 0;
    // ToDo: mapper should return auto-incremented number, which currently does not (except the first time from 0 to 1),
    //  albeit the messageid is indeed incremented every tim a new record is written

    private final MessageMapper messageMapper;

    public ChatMessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
        //lastID = messageMapper.saveMessage(new ChatMessage("System", "Wtf, who are you?", "say"));
    }

    public void addMessage(String user, String message, String type) {
        ChatMessage newMessage = new ChatMessage(user, message, type);
        lastID = messageMapper.saveMessage(newMessage);
    }

    public List<ChatMessage> getMessageHistoryAsBatch() {
        return messageMapper.getAllMessages();
    }

    public List<ChatMessage> getMessageHistorySequentially() {
        List<ChatMessage> chatHistoryObjects = new ArrayList<>();
        int count = messageMapper.getCount();
        for(int i =1; i<count+1; i++) {
            ChatMessage msg = messageMapper.getMessage(String.valueOf(i));
            chatHistoryObjects.add(msg);
        }
        return chatHistoryObjects;
    }

}
