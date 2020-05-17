package socialnetworking.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialnetworking.demo.models.TimeLineMessage;
import socialnetworking.demo.models.TimeLineMessages;
import socialnetworking.demo.models.Tweet;
import socialnetworking.demo.service.TimeLineGenerationService;

import java.util.List;

@RestController
@RequestMapping(value = "/timeLine")
public class TimeLineApi {

    @Autowired
    private TimeLineGenerationService timeLineGenerationService;

    @GetMapping(value = "/{username}")
    public TimeLineMessages getTimeLineForUser(@PathVariable String username) {
        return this.timeLineGenerationService.getTimeLine(username);
    }
}
