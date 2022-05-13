package ar.com.tinello.katas.socialnetwork.chats.domain;

public class Message {

    private final String userFrom;
    private final String userTo;
    private final String text;

    public Message(String userFrom, String userTo, String text) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.text = text;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public String getText() {
        return text;
    }

}
