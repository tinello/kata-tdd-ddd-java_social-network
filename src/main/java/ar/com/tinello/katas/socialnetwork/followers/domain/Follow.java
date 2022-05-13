package ar.com.tinello.katas.socialnetwork.followers.domain;

public class Follow {

    private final String follower;
    private final String following;

    public Follow(String follower, String following) {
        super();
        this.follower = follower;
        this.following = following;
    }

    public String getFollower() {
        return follower;
    }

    public String getFollowing() {
        return following;
    }

}
