package service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.Environment;
import reactor.core.composable.Composable;
import reactor.event.Event;
import reactor.function.Consumer;

import java.util.Arrays;

/**
 * Created by bob zhou on 14-6-3.
 */
@Service
public class NewsReceiver implements Consumer<Event<String>> {

    @Override
    public void accept(Event<String> event) {
        String s = event.getData();
        if (!StringUtils.isEmpty(s)) {
            handle(s);
        }
    }

    private void handle(String s) {
        JSONObject obj = JSONObject.parseObject(s);
        System.out.println(obj.toJSONString());
    }


}
