package socialnetworking.demo.models;

import java.util.List;

public class WallMessageList {
    private List<WallMessage> wallMessageList;

    public List<WallMessage> getWallMessageList() {
        return wallMessageList;
    }

    public boolean hasMessage(String message) {
        for(WallMessage wallMessage: wallMessageList) {
            if(wallMessage.toString().equals(message))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "WallMessageList{" +
                "wallMessageList=" + wallMessageList +
                '}';
    }

    public void setWallMessageList(List<WallMessage> wallMessageList) {
        this.wallMessageList = wallMessageList;
    }

    public WallMessageList(List<WallMessage> wallMessageList) {
        this.wallMessageList = wallMessageList;
    }

    public WallMessageList() {
    }
}
