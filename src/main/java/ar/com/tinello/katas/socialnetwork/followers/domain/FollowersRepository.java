package ar.com.tinello.katas.socialnetwork.followers.domain;

import java.util.List;

public interface FollowersRepository {

    void save(Follow follow);

    List<Follow> getByFollower(String follower);

}
