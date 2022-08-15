package mega_chat_app.controller;

import mega_chat_app.model.ChatFormBackingObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import mega_chat_app.service.ChatMessageService;

@Controller
public class ChatController {

    ChatMessageService messageService;

    public ChatController(ChatMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute("newChatMessage") ChatFormBackingObject newChatMessage, Model model) {
        model.addAttribute("chatHistory", messageService.getMessageHistoryAsBatch()) ;
        model.addAttribute("currentUser", getCurrentUser());
        return "chat"; // refers to chat.html from templates
    }

    @PostMapping("/chat")
    public String addNewMessage(@ModelAttribute("newChatMessage") ChatFormBackingObject newChatMessage, Model model) {
        messageService.addMessage(getCurrentUser(), newChatMessage.getMessage(), newChatMessage.getType());
        model.addAttribute("chatHistory", messageService.getMessageHistoryAsBatch()) ;
        model.addAttribute("currentUser", getCurrentUser());
        return "chat"; // refers to chat.html from templates
    }

    private String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

}
