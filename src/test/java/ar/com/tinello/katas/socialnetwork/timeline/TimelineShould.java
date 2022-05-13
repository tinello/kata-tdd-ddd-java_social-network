package ar.com.tinello.katas.socialnetwork.timeline;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.com.tinello.katas.socialnetwork.timeline.actions.GetUserTimeline;
import ar.com.tinello.katas.socialnetwork.timeline.actions.GetUsersTimeline;
import ar.com.tinello.katas.socialnetwork.timeline.actions.PostPublishing;
import ar.com.tinello.katas.socialnetwork.timeline.domain.Publishing;
import ar.com.tinello.katas.socialnetwork.timeline.domain.Timeline;
import ar.com.tinello.katas.socialnetwork.timeline.domain.TimelineRepository;
import ar.com.tinello.katas.socialnetwork.timeline.infrastructure.TimelineRepositoryMemory;

public class TimelineShould {

    private TimelineRepository timelineRepository;
    private Timeline timeline;

    @Before
    public void setUp() {
        timelineRepository = new TimelineRepositoryMemory();
        timeline = new Timeline(timelineRepository);
    }

    @Test
    public void a_user_this_can_publish_message() {
        PostPublishing postPublishing = new PostPublishing(timeline);
        Publishing publishing = new Publishing("alice", "Un mensaje.");

        Publishing newPublishing = postPublishing.execute(publishing);
        publishing.setId(0);

        assertThat(newPublishing).isEqualToComparingFieldByField(publishing);
    }

    @Test
    public void can_view_any_user_messages() {
        String userAlice = "alice";
        timeline.save(new Publishing(userAlice, "Un mensaje."));

        GetUserTimeline getUserPublishing = new GetUserTimeline(timeline);
        List<Publishing> allicePublishing = getUserPublishing.execute(userAlice);

        assertThat(allicePublishing.get(0).getUser()).isEqualTo(userAlice);
    }

    @Test
    public void a_user_can_view_a_messages_list_of_users() {
        timeline.save(new Publishing("alice", "Un mensaje de Alice."));
        timeline.save(new Publishing("bob", "Un mensaje de Bob."));
        timeline.save(new Publishing("alice", "Otro mensaje de Alice."));
        timeline.save(new Publishing("joe", "Un mensaje de Joe."));
        timeline.save(new Publishing("bob", "Otro mensaje de Bob."));

        GetUsersTimeline getUsersPublishing = new GetUsersTimeline(timeline);
        List<String> users = Arrays.asList("bob", "alice");
        List<Publishing> publishing = getUsersPublishing.execute(users);

        assertThat(publishing.size()).isEqualTo(4);
    }

    @Test
    public void a_user_can_mention_to_other_user() {
        Publishing publishing = new Publishing("bob", "Un mensaje para @charlie.");
        List<String> mentions = publishing.askMentions();
        assertThat(mentions.get(0)).isEqualTo("charlie");
    }


    @Test
    public void a_user_can_linked_to_web_resources() {
        Publishing publishing = new Publishing("alice", "Un link de http://www.tinello.com.ar/t/gus-moco.jpg .");
        List<String> links = publishing.askLinks();
        assertThat(links.get(0)).isEqualTo("http://www.tinello.com.ar/t/gus-moco.jpg");
    }

}
