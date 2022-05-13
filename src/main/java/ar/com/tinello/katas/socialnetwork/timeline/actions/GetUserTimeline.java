package ar.com.tinello.katas.socialnetwork.timeline.actions;

import java.util.List;

import ar.com.tinello.katas.socialnetwork.timeline.domain.Publishing;
import ar.com.tinello.katas.socialnetwork.timeline.domain.Timeline;

public class GetUserTimeline {

    private Timeline timeline;

    public GetUserTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public List<Publishing> execute(String user) {
        return timeline.getByUser(user);
    }

}
