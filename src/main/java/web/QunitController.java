package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 14-6-3.
 */
@Controller
public class QunitController {

    @RequestMapping("test")
    public String qunit(){
        return "jstest/qunit";
    }
}
