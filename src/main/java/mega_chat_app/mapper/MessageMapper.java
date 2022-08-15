package mega_chat_app.mapper;


import mega_chat_app.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT count(*) FROM MESSAGES")
    int getCount();

    @Select("SELECT * FROM MESSAGES WHERE messageid = #{id}")
    ChatMessage getMessage(String id);

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext, messagetype) VALUES(#{user}, #{message}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int saveMessage(ChatMessage message);
}