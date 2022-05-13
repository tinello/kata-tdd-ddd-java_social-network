package ar.com.tinello.katas.socialnetwork.chats.domain;

import java.util.List;

public interface ChatsRepository {

    List<Message> get(String userFrom, String userTo);

    void save(Message message);

}
