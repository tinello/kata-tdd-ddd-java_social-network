package ar.com.tinello.katas.socialnetwork.timeline.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Timeline {

    private TimelineRepository timelineRepository;

    public Timeline(TimelineRepository timelineRepository) {
        super();
        this.timelineRepository = timelineRepository;
    }

    public Publishing save(Publishing publishing) {
        return timelineRepository.save(publishing);
    }

    public List<Publishing> getByUser(String user) {
        return timelineRepository.get().stream().filter(publishing -> publishing.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public List<Publishing> getByUsers(List<String> users) {
        return timelineRepository.get().stream().filter(publishing -> users.contains(publishing.getUser()))
                .collect(Collectors.toList());
    }

}
