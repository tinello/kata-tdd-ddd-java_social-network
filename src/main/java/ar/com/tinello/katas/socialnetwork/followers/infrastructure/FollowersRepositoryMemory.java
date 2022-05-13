package ar.com.tinello.katas.socialnetwork.followers.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import ar.com.tinello.katas.socialnetwork.followers.domain.Follow;
import ar.com.tinello.katas.socialnetwork.followers.domain.FollowersRepository;

public class FollowersRepositoryMemory implements FollowersRepository {

    private List<String> followers;
    private final Gson serialization;

    public FollowersRepositoryMemory() {
        super();
        followers = new ArrayList<>();
        serialization = new Gson();
    }

    @Override
    public void save(Follow follow) {
        followers.add(serialization.toJson(follow));
    }

    @Override
    public List<Follow> getByFollower(String follower) {
        return followers.stream()
                .map(follow -> serialization.fromJson(follow, Follow.class))
                .filter(follow -> follow.getFollower().equals(follower))
                .collect(Collectors.toList());
    }

}
