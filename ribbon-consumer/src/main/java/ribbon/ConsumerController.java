package ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JDP on 2016/12/15.
 */

@RestController
public class ConsumerController {

    private final String WORD_SERVICE = "ux-eureka-random-word";

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public String getWord() {
        return restTemplate.getForEntity(String.format("http://%s/word", WORD_SERVICE), String.class).getBody() ;
    }
}
