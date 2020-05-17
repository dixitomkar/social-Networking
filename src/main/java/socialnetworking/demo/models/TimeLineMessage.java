package socialnetworking.demo.models;

public class TimeLineMessage {
    private String tweetData;
    private String timePassed;

    public TimeLineMessage() {
    }

    public TimeLineMessage(String tweetData, String timePassed) {
        this.tweetData = tweetData;
        this.timePassed = timePassed;
    }

    @Override
    public String toString() {
        return tweetData +  "(" + timePassed + ")";
    }

    public String getTweetData() {
        return tweetData;
    }

    public void setTweetData(String tweetData) {
        this.tweetData = tweetData;
    }

    public String getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(String timePassed) {
        this.timePassed = timePassed;
    }
}
