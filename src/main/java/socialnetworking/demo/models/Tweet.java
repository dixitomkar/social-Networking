package socialnetworking.demo.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Tweet {

    private String username;
    private String tweetData;
    private LocalDateTime time;


    public Tweet(String username, String tweetData) {
        this.username = username;
        this.tweetData = tweetData;
        this.time = LocalDateTime.now();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "username='" + username + '\'' +
                ", tweetData='" + tweetData + '\'' +
                ", time=" + time +
                '}';
    }

    public String getTweetData() {
        return tweetData;
    }

    public void setTweetData(String tweetData) {
        this.tweetData = tweetData;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


}
