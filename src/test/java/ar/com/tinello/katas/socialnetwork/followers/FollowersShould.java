package ar.com.tinello.katas.socialnetwork.followers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import ar.com.tinello.katas.socialnetwork.followers.actions.FollowUser;
import ar.com.tinello.katas.socialnetwork.followers.domain.Follow;
import ar.com.tinello.katas.socialnetwork.followers.domain.Followers;
import ar.com.tinello.katas.socialnetwork.followers.domain.FollowersRepository;
import ar.com.tinello.katas.socialnetwork.followers.infrastructure.FollowersRepositoryMemory;

public class FollowersShould {

    @Test
    public void a_user_can_subscribe_to_other_user_follow() {
        FollowersRepository followersRepository = new FollowersRepositoryMemory();
        Followers followers = new Followers(followersRepository);


        FollowUser followUser = new FollowUser(followers);
        followUser.execute("bob", "alice");
        followUser.execute("charlie", "bob");

        List<Follow> folowed = followers.get("charlie");
        assertThat(folowed.get(0)).isEqualToComparingFieldByField(new Follow("charlie", "bob"));
    }

}
