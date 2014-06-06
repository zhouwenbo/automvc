package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.Reactor;

import static reactor.event.selector.Selectors.$;

/**
 * Created by bob zhou on 14-6-3.
 */
@Service
public class ReactorService implements CommandLineRunner {

    @Autowired
    private Reactor reactor;

    @Autowired
    private NewsReceiver newsReceiver;

    @Autowired
    private TechService techService;

    @Override
    public void run(String... strings) throws Exception {
        reactor.on($("news"), newsReceiver);
        reactor.on($("tech"), techService);
    }



}
