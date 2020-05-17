package socialnetworking.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socialnetworking.demo.models.TimeLineMessage;
import socialnetworking.demo.models.Tweet;
import socialnetworking.demo.models.WallMessage;
import socialnetworking.demo.models.WallMessageList;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class WallService {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private FollowersService followersService;

    public WallMessageList getWall(String username) {

        List<WallMessage> wallMessages = new ArrayList<>();

        List<String> follows = followersService.getFollowersForUser(username);
        List<Tweet> tweetsForUser = new ArrayList<>();
        tweetsForUser.addAll(tweetService.getTweetsForUser(username));

        for(String follow: follows)
            tweetsForUser.addAll(tweetService.getTweetsForUser(follow));

        for(Tweet tweet: tweetsForUser) {
            String message = tweet.getTweetData();
            LocalDateTime tweetTime = tweet.getTime();
            LocalDateTime now = LocalDateTime.now();

            Duration duration = Duration.between(tweetTime,now);

            String tweetElapsedTime = "";

            if(duration.toMinutes() == 0)
                tweetElapsedTime = duration.toSeconds() + " seconds ago";
            else
                tweetElapsedTime = duration.toMinutes() + " minutes ago";

            WallMessage wallMessage = new WallMessage(message,tweetElapsedTime, tweet.getUsername());
            wallMessages.add(wallMessage);

        }

        WallMessageList wallMessageList = new WallMessageList(wallMessages);
        return wallMessageList;
    }

}
