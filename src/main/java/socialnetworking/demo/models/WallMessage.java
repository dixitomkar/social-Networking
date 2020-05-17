package socialnetworking.demo.models;

public class WallMessage extends TimeLineMessage{
    private String userName;

    @Override
    public String toString() {
        return userName + " " + this.getTweetData()+  "(" + this.getTimePassed() + ")";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public WallMessage(String userName) {
        this.userName = userName;
    }

    public WallMessage(String tweetData, String timePassed, String userName) {
        super(tweetData, timePassed);
        this.userName = userName;
    }
}
