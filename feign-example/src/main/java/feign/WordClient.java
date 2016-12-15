package feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JDP on 2016/12/15.
 */

@FeignClient("ux-eureka-random-word")
public interface WordClient {

    @RequestMapping(method = RequestMethod.GET, value="/word")
    String getWord();
}
