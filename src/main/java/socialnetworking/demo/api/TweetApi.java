package socialnetworking.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socialnetworking.demo.models.Tweet;
import socialnetworking.demo.service.TweetService;

import java.util.List;

@RestController
@RequestMapping(value = "/tweet")
public class TweetApi {

    @Autowired
    private TweetService tweetService;

    @PostMapping
    public Tweet addTweet(@RequestBody Tweet tweet) {
        return this.tweetService.addTweet(tweet);
    }

    @GetMapping
    public List<Tweet> getTweets() {
        return this.tweetService.getTweets();
    }
}
