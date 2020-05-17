package socialnetworking.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socialnetworking.demo.models.TimeLineMessage;
import socialnetworking.demo.models.Tweet;
import socialnetworking.demo.models.WallMessage;
import socialnetworking.demo.models.WallMessageList;
import socialnetworking.demo.service.TweetService;
import socialnetworking.demo.service.WallService;

import java.util.List;

@RestController
@RequestMapping(value = "/wall")
public class WallApi {

    @Autowired
    private WallService wallService;

    @GetMapping(value = "/{username}")
    public WallMessageList getWallForUser(@PathVariable String username) {
        return this.wallService.getWall(username);
    }
}
