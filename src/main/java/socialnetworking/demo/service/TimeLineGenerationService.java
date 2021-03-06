package socialnetworking.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socialnetworking.demo.models.TimeLineMessage;
import socialnetworking.demo.models.TimeLineMessages;
import socialnetworking.demo.models.Tweet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TimeLineGenerationService {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private FollowersService followersService;

    public TimeLineMessages getTimeLine(String username) {

        List<TimeLineMessage> timeLineMessages = new ArrayList<>();

        List<Tweet> tweets = tweetService.getTweetsForUser(username);

        for(Tweet tweet: tweets) {
            String message = tweet.getTweetData();
            LocalDateTime tweetTime = tweet.getTime();
            LocalDateTime now = LocalDateTime.now();

            Duration duration = Duration.between(tweetTime,now);

            String tweetElapsedTime = "";

            if(duration.toMinutes() == 0)
                tweetElapsedTime = duration.toSeconds() + " seconds ago";
            else
                tweetElapsedTime = duration.toMinutes() + " minutes ago";

            TimeLineMessage timeLineMessage = new TimeLineMessage(message,tweetElapsedTime);
            timeLineMessages.add(timeLineMessage);

        }

        TimeLineMessages timeLineMessagesList = new TimeLineMessages(timeLineMessages);
        return timeLineMessagesList;

    }
}
