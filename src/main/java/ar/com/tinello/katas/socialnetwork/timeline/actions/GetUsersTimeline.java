package ar.com.tinello.katas.socialnetwork.timeline.actions;

import java.util.List;

import ar.com.tinello.katas.socialnetwork.timeline.domain.Timeline;
import ar.com.tinello.katas.socialnetwork.timeline.domain.Publishing;

public class GetUsersTimeline {

    private Timeline timeline;

    public GetUsersTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public List<Publishing> execute(List<String> users) {
        return timeline.getByUsers(users);
    }

}
