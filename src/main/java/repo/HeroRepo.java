package repo;

import domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by bob zho on 14-6-3.
 */
@Repository
public class HeroRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hero> getList() {
        List<Hero> list = new ArrayList<Hero>();
        List rows = jdbcTemplate.queryForList("select * from tb_hero");
        Iterator it = rows.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            Hero hero = new Hero();
            long hero_id =Long.parseLong(map.get("hero_id").toString());
            hero.setHero_id(hero_id);
            hero.setName(map.get("name").toString());
            hero.setAge(Integer.parseInt(map.get("age").toString()));
            hero.setFrom(map.get("from").toString());
            hero.setSkill(map.get("skill").toString());
            list.add(hero);
        }
        return list;
    }

    public Hero getHero(long hero_id){
        Map map = jdbcTemplate.queryForMap("select * from tb_hero where hero_id= "+hero_id);
        Hero hero = new Hero();
        hero.setHero_id(hero_id);
        hero.setName(map.get("name").toString());
        hero.setAge(Integer.parseInt(map.get("age").toString()));
        hero.setFrom(map.get("from").toString());
        hero.setSkill(map.get("skill").toString());
        return hero;
    }

}
