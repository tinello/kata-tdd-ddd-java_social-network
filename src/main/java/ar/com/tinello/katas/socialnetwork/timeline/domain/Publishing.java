package ar.com.tinello.katas.socialnetwork.timeline.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Publishing {

    private Integer id;
    private final String user;
    private final String message;
    private LocalDate date;

    public Publishing(String user, String message) {
        this.user = user;
        this.message = message;
        this.date = LocalDate.now();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> askMentions() {
        List<String> mentions = new ArrayList<>();
        Matcher matcher = Pattern.compile("@[A-Za-z0-9_-]*").matcher(message);
        while (matcher.find()) {
            mentions.add(matcher.group().substring(1));
        }
        return mentions;
    }

    public List<String> askLinks() {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("(http://|https://)[A-Za-z0-9-_\\./]*").matcher(message);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
