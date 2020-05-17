package socialnetworking.demo.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import socialnetworking.demo.models.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FeedsApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    Tweet tweet1 = new Tweet("Alice","I love the weather today.");
    Tweet tweet2 = new Tweet("Bob","Darn! We lost!");
    Tweet tweet3 = new Tweet("Bob","Good game though.");
    Tweet tweet4 = new Tweet("Charlie","I'm in New York today! Anyone wants to have a coffee?");

    List<Tweet> tweets = new ArrayList<>();

    @LocalServerPort
    int randomServerPort;

    @BeforeEach
    void init()  throws URISyntaxException {
        initializeItems();
    }

    @Test
    public void checkAliceTimeLine() throws URISyntaxException
    {
        String timeLineUrl = "http://localhost:"+randomServerPort+"/timeLine/Alice";
        URI uri = new URI(timeLineUrl);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<TimeLineMessages> result = this.testRestTemplate.getForEntity(uri, TimeLineMessages.class);
        TimeLineMessages timeLineMessages = result.getBody();

        assertEquals("TimeLine for 1 message should return correct data", "I love the weather today.(2 minutes ago)",timeLineMessages.getTimeLineMessageList().get(0).toString());
    }

    @Test
    public void checkBobTimeLine() throws URISyntaxException
    {
        String timeLineUrl = "http://localhost:"+randomServerPort+"/timeLine/Bob";
        URI uri = new URI(timeLineUrl);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<TimeLineMessages> result = this.testRestTemplate.getForEntity(uri, TimeLineMessages.class);
        TimeLineMessages timeLineMessages = result.getBody();

        assertEquals("TimeLine for 2 message should return correct data", "Darn! We lost!(3 minutes ago)",timeLineMessages.getTimeLineMessageList().get(0).toString());
        assertEquals("TimeLine for 2 message should return correct data", "Good game though.(4 minutes ago)",timeLineMessages.getTimeLineMessageList().get(1).toString());
    }

    @Test
    public void checkCharlieWall() throws URISyntaxException
    {
        String timeLineUrl = "http://localhost:"+randomServerPort+"/wall/Charlie";
        URI uri = new URI(timeLineUrl);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<WallMessageList> result = this.testRestTemplate.getForEntity(uri, WallMessageList.class);
        WallMessageList wallMessageList = result.getBody();

        System.out.println(wallMessageList);
        assertTrue(wallMessageList.hasMessage("Charlie I\'m in New York today! Anyone wants to have a coffee?(1 minutes ago)"));
        assertTrue(wallMessageList.hasMessage("Alice I love the weather today.(2 minutes ago)"));
        assertTrue(wallMessageList.hasMessage("Bob Darn! We lost!(3 minutes ago)"));
        assertTrue(wallMessageList.hasMessage("Bob Good game though.(4 minutes ago)"));

    }



    void initializeItems() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();

        String tweetUrl = "http://localhost:"+randomServerPort+"/tweet/";
        URI uri = new URI(tweetUrl);

        tweet1.setTime(LocalDateTime.now().minusMinutes(2));
        tweet2.setTime(LocalDateTime.now().minusMinutes(3));
        tweet3.setTime(LocalDateTime.now().minusMinutes(4));
        tweet4.setTime(LocalDateTime.now().minusMinutes(1));


        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);
        tweets.add(tweet4);

        for(Tweet tweet: tweets) {
            HttpEntity<Tweet> request = new HttpEntity<>(tweet, headers);
            ResponseEntity<Tweet> result = this.testRestTemplate.postForEntity(uri, request, Tweet.class);
        }

        String followerUrl = "http://localhost:"+randomServerPort+"/follower/";
        URI uriFollower = new URI(followerUrl);

        Followers follower1= new Followers("Charlie","Alice");
        Followers follower2 = new Followers("Charlie","Bob");

        HttpEntity<Followers> request = new HttpEntity<>(follower1, headers);
        this.testRestTemplate.postForEntity(uriFollower, request, Followers.class);

        request = new HttpEntity<>(follower2, headers);
        this.testRestTemplate.postForEntity(uriFollower, request, Followers.class);
    }

}
