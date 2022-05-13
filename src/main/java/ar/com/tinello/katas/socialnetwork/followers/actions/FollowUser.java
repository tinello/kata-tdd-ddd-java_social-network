package ar.com.tinello.katas.socialnetwork.followers.actions;

import ar.com.tinello.katas.socialnetwork.followers.domain.Follow;
import ar.com.tinello.katas.socialnetwork.followers.domain.Followers;

public class FollowUser {

    private Followers followers;

    public FollowUser(Followers followers) {
        this.followers = followers;
    }

    public void execute(String follower, String following) {
        followers.save(new Follow(follower, following));
    }

}
