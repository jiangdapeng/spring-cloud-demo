package rank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdp on 2016/12/13.
 */
@RestController
public class RankController {

    @RequestMapping("/")
    public int getRank() {
        int i = (int) Math.round(Math.random() * 300) ;
        return i;
    }
}
