package socialnetworking.demo.service;

import org.springframework.stereotype.Component;
import socialnetworking.demo.models.Tweet;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Component
public class TweetService {

    private List<Tweet> tweets = new CopyOnWriteArrayList<>();

    public Tweet addTweet(Tweet tweet) {
        tweets.add(tweet);
        return tweet;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Tweet> getTweetsForUser(String username) {
        return tweets.stream().filter(tweet -> tweet.getUsername().equals(username)).collect(Collectors.toList());
    }

}
