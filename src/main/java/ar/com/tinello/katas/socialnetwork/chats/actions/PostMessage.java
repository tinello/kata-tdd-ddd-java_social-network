package ar.com.tinello.katas.socialnetwork.chats.actions;

import ar.com.tinello.katas.socialnetwork.chats.domain.Chats;
import ar.com.tinello.katas.socialnetwork.chats.domain.Message;

public class PostMessage {

    private Chats chats;

    public PostMessage(Chats chats) {
        this.chats = chats;
    }

    public void execute(Message message) {
        chats.save(message);
    }

}
