package ar.com.tinello.katas.socialnetwork.followers.domain;

import java.util.List;

public class Followers {

    FollowersRepository followersRepository;

    public Followers(FollowersRepository followersRepository) {
        this.followersRepository = followersRepository;
    }

    public void save(Follow follow) {
        followersRepository.save(follow);
    }

    public List<Follow> get(String follower) {
        return followersRepository.getByFollower(follower);
    }

}
