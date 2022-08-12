package mega_chat_app.controller;

import mega_chat_app.model.ChatFormBackingObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import mega_chat_app.service.ChatMessageService;

@Controller
public class ChatController {

    ChatMessageService messageService = new ChatMessageService();

    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute("newChatMessage") ChatFormBackingObject newChatMessage, Model model) {
        model.addAttribute("chatHistory", messageService.getMessageHistory()) ;
        return "chat"; // refers to chat.html from templates
    }

    @PostMapping("/chat")
    public String addNewMessage(@ModelAttribute("newChatMessage") ChatFormBackingObject newChatMessage, Model model) {
        messageService.addMessage(newChatMessage.getUser(), newChatMessage.getMessage(), newChatMessage.getType());
        model.addAttribute("chatHistory", messageService.getMessageHistory()) ;
        //System.out.println("--> " + newChatMessage.getMessage());
        return "chat"; // refers to chat.html from templates
    }

}
