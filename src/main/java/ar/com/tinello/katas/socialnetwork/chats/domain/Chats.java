package ar.com.tinello.katas.socialnetwork.chats.domain;

import java.util.List;

public class Chats {

    private ChatsRepository chatsRepository;

    public Chats(ChatsRepository chatsRepository) {
        this.chatsRepository = chatsRepository;
    }

    public List<Message> get(String userFrom, String userTo) {
        return chatsRepository.get(userFrom, userTo);
    }

    public void save(Message message) {
        chatsRepository.save(message);
    }

}
