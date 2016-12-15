package feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JDP on 2016/12/15.
 */

@RestController
public class ConsumerController {

    @Autowired
    WordClient wordClient;

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public String getWord() {
        return wordClient.getWord();
    }
}
