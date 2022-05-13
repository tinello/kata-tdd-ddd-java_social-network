package ar.com.tinello.katas.socialnetwork.timeline.infrastructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import ar.com.tinello.katas.socialnetwork.timeline.domain.Publishing;
import ar.com.tinello.katas.socialnetwork.timeline.domain.TimelineRepository;

public class TimelineRepositoryMemory implements TimelineRepository {

    private final Map<Integer, String> publications = new LinkedHashMap<>();
    private final Gson serialization = new Gson();

    @Override
    public Publishing save(Publishing publishing) {
        publishing.setId(publications.size());
        String serializedPublishing = serialization.toJson(publishing);
        publications.put(publishing.getId(), serializedPublishing);

        return serialization.fromJson(serializedPublishing, Publishing.class);
    }

    @Override
    public List<Publishing> get() {
        return publications.entrySet().stream()
                .map(publishing -> serialization.fromJson(publishing.getValue(), Publishing.class))
                .collect(Collectors.toList());
    }

}
