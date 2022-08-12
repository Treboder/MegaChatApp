package mega_chat_app.mapper;


import mega_chat_app.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    ChatMessage getMessage(String username);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{user}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int saveMessage(ChatMessage message);
}