package ar.com.tinello.katas.socialnetwork.chats.actions;

import java.util.List;

import ar.com.tinello.katas.socialnetwork.chats.domain.Chats;
import ar.com.tinello.katas.socialnetwork.chats.domain.Message;

public class GetChat {

    private Chats chats;

    public GetChat(Chats chats) {
        this.chats = chats;
    }

    public List<Message> execute(String userFrom, String userTo) {
        return chats.get(userFrom, userTo);
    }

}
