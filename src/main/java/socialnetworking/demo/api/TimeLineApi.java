package socialnetworking.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialnetworking.demo.models.Tweet;
import socialnetworking.demo.service.TimeLineGenerationService;

import java.util.List;

@RestController
@RequestMapping(value = "/tweet")
public class TimeLineApi {

    @Autowired
    private TimeLineGenerationService timeLineGenerationService;

    public List<Tweet> getTimeLineForUser(String username) {
        return this.timeLineGenerationService.getTimeLine(username);
    }
}
