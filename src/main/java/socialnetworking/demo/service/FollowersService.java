package socialnetworking.demo.service;

import org.springframework.stereotype.Component;
import socialnetworking.demo.models.Followers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class FollowersService {

    private List<Followers> followers = new CopyOnWriteArrayList<>();

    public  Followers addFollower(Followers follower) {
        followers.add(follower);
        return follower;
    }

    public List<String> getFollowersForUser(String username) {
        List<String> follows = new ArrayList<>();
        for(Followers follower: this.followers) {
            if(follower.getFollower().equals(username))
                follows.add(follower.getFollows());
        }
        return follows;
    }

}
