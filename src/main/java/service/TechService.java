package service;

import org.springframework.stereotype.Service;
import reactor.event.Event;
import reactor.function.Consumer;

/**
 * Created by Administrator on 14-6-4.
 */
@Service
public class TechService implements Consumer<Event<Long>> {

    @Override
    public void accept(Event<Long> event) {
        long hero_id = event.getData();
        handler(hero_id);
    }

    private void handler(long hero_id) {
        System.out.println("hero_id : "+hero_id);
    }

}
