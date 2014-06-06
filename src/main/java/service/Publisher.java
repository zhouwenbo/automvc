package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Reactor;
import reactor.event.Event;

/**
 * Created by bob zhou on 14-6-3.
 */
@Service
public class Publisher {

    @Autowired
    private Reactor reactor;

    public void publishNews() {
        String news = "{body:'hello',keyword:'spc',num:18}";
        for (int i = 0; i < 10; i++) {
            reactor.notify("news", Event.wrap(news));
        }
    }

}
