package feign;

import org.springframework.stereotype.Component;

/**
 * Created by JDP on 2016/12/15.
 */

@Component
public class WordClientHystrix implements WordClient {

    @Override
    public String getWord() {
        return "-1";
    }
}
