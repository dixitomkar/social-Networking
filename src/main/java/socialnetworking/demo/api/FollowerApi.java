package socialnetworking.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socialnetworking.demo.models.Followers;
import socialnetworking.demo.service.FollowersService;

import java.util.List;

@RestController
@RequestMapping(value = "/follower")
public class FollowerApi {

    @Autowired
    private FollowersService followersService;

    @PostMapping
    public Followers addFollower(@RequestBody Followers followers) {
        return this.followersService.addFollower(followers);
    }

}

