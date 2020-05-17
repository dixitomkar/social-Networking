package socialnetworking.demo.models;

import java.util.List;

public class TimeLineMessages {
    private List<TimeLineMessage> timeLineMessageList;

    public TimeLineMessages() {

    }
    public TimeLineMessages(List<TimeLineMessage> timeLineMessages) {
        this.timeLineMessageList = timeLineMessages;
    }

    @Override
    public String toString() {
        return "TimeLineMessages{" +
                "timeLineMessageList=" + timeLineMessageList +
                '}';
    }

    public List<TimeLineMessage> getTimeLineMessageList() {
        return timeLineMessageList;
    }

    public void setTimeLineMessageList(List<TimeLineMessage> timeLineMessageList) {
        this.timeLineMessageList = timeLineMessageList;
    }
}
