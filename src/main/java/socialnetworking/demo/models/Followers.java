package socialnetworking.demo.models;

public class Followers {

    private String follower;
    private String follows;

    public String getFollower() {
        return follower;
    }

    public Followers(String follower, String follows) {
        this.follower = follower;
        this.follows = follows;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }
}
