package service;

import domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Reactor;
import reactor.event.Event;
import repo.HeroRepo;

import java.util.List;

/**
 * Created by bob zhou on 14-6-3.
 */
@Service
public class HeroService {

    @Autowired
    private HeroRepo heroRepo;

    @Autowired
    private Publisher publisher;

    @Autowired
    private Reactor reactor;

    public List<Hero> getList(){
        //publisher.publishNews();
        String news = "{body:'hello',keyword:'spc',num:18}";
        for (int i = 0; i < 10; i++) {
            reactor.notify("news", Event.wrap(news));
        }
        return heroRepo.getList();
    }

    public Hero getHero(long hero_id){
        reactor.notify("tech", Event.wrap(hero_id));
        return heroRepo.getHero(hero_id);
    }


}
