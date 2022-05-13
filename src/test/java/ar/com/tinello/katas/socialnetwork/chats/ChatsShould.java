package ar.com.tinello.katas.socialnetwork.chats;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.com.tinello.katas.socialnetwork.chats.actions.GetChat;
import ar.com.tinello.katas.socialnetwork.chats.actions.PostMessage;
import ar.com.tinello.katas.socialnetwork.chats.domain.Chats;
import ar.com.tinello.katas.socialnetwork.chats.domain.ChatsRepository;
import ar.com.tinello.katas.socialnetwork.chats.domain.Message;
import ar.com.tinello.katas.socialnetwork.chats.infrastructure.ChatsRepositoryMemory;

public class ChatsShould {

    private ChatsRepository chatsRepository;
    private Chats chats;

    @Before
    public void setUp() {
        chatsRepository = new ChatsRepositoryMemory();
        chats = new Chats(chatsRepository);
    }

    @Test
    public void a_user_send_messages_to_other_user() {
        PostMessage postMessage = new PostMessage(chats);

        Message message = new Message("mallory", "alice", "Hi friend!");
        postMessage.execute(message);

        List<Message> messages = chats.get("mallory", "alice");
        assertThat(messages.get(0)).isEqualToComparingFieldByField(message);
    }

    @Test
    public void get_chat_between_two_users() {
        PostMessage postMessage = new PostMessage(chats);
        postMessage.execute(new Message("mallory", "alice", "Hi Alice!"));
        postMessage.execute(new Message("alice", "jeo", "Hi Joe!"));
        postMessage.execute(new Message("alice", "mallory", "Hi Mallory!"));


        GetChat getChat = new GetChat(chats);
        List<Message> messages = getChat.execute("mallory", "alice");

        assertThat(messages.size()).isEqualTo(2);
    }
}
