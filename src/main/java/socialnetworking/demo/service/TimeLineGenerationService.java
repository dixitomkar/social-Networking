package socialnetworking.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socialnetworking.demo.models.Followers;
import socialnetworking.demo.models.Tweet;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimeLineGenerationService {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private FollowersService followersService;

    public List<Tweet> getTimeLine(String username) {
        List<String> follows = followersService.getFollowersForUser(username);
        List<Tweet> tweetsForUser = new ArrayList<>();
        tweetsForUser.addAll(tweetService.getTweetsForUser(username));

        for(String follow: follows)
            tweetsForUser.addAll(tweetService.getTweetsForUser(follow));

        return tweetsForUser;
    }
}
