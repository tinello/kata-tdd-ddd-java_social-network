package ar.com.tinello.katas.socialnetwork.chats.infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.tinello.katas.socialnetwork.chats.domain.ChatsRepository;
import ar.com.tinello.katas.socialnetwork.chats.domain.Message;

public class ChatsRepositoryMemory implements ChatsRepository {

    private List<Message> chats;

    public ChatsRepositoryMemory() {
        chats = new ArrayList<>();
    }

    @Override
    public List<Message> get(String userFrom, String userTo) {
        List<String> users = Arrays.asList(userFrom, userTo);
        return chats.stream()
                .filter(message -> users.contains(message.getUserFrom()) && users.contains(message.getUserTo()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Message message) {
        chats.add(message);
    }

}
