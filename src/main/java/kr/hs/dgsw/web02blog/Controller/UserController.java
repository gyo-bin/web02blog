package kr.hs.dgsw.web02blog.Controller;

import kr.hs.dgsw.web02blog.Protocol.ResponseFormat;
import kr.hs.dgsw.web02blog.Protocol.ResponseType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public ResponseFormat list(){
        return new ResponseFormat(ResponseType.POST_ADD,(Object)"Hello");
    }


}
