package ar.com.tinello.katas.socialnetwork.timeline.actions;

import ar.com.tinello.katas.socialnetwork.timeline.domain.Publishing;
import ar.com.tinello.katas.socialnetwork.timeline.domain.Timeline;

public class PostPublishing {

    private Timeline timeline;

    public PostPublishing(Timeline timeline) {
        super();
        this.timeline = timeline;
    }

    public Publishing execute(Publishing publishing) {
        return this.timeline.save(publishing);
    }

}
