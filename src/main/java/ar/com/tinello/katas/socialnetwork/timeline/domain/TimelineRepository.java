package ar.com.tinello.katas.socialnetwork.timeline.domain;

import java.util.List;

public interface TimelineRepository {

    Publishing save(Publishing publishing);

    List<Publishing> get();

}
