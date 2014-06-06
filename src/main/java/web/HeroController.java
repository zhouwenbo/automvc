package web;

import domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HeroService;
import service.Publisher;

import java.util.List;

/**
 * Created by bob zhou on 14-5-30.
 */

@Controller
@RequestMapping("hero")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @RequestMapping("list")
    String list(Model model) {
        List<Hero> list = heroService.getList();
        model.addAttribute("list", list);
        return "hero/list";
    }

    @RequestMapping(value = "/find/{hid}")
    String find(Model model, @PathVariable("hid") long hero_id) {
        Hero hero = heroService.getHero(hero_id);
        model.addAttribute("hero", hero);
        return "hero/detail";
    }

}
