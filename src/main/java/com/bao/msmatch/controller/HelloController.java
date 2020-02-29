package com.bao.msmatch.controller;

import com.bao.msmatch.common.Constants;
import com.bao.msmatch.model.User;
import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author baocy
 * @Description //TODO
 * @Date 2020/2/26 20:56
 **/
@Controller
public class HelloController {


    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("uid", "123456789");
        model.addAttribute("name", "Jerry");
        return "show";
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public String memberShow(Model model) {

        Constants.initData();
        model.addAttribute("mem", Constants.u);
        model.addAttribute("member1", Constants.u);
        model.addAttribute("member2", Constants.u);

        model.addAttribute("member3", Constants.afterList);
        return "show";
    }

    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public String match(Model model) {
        Pair<User, User> pair = Constants.match();
        model.addAttribute("mem", Constants.u);
        model.addAttribute("member1", pair.getKey());
        model.addAttribute("member2", pair.getValue());

        model.addAttribute("member3", Constants.afterList);
        return "show";
    }

    @RequestMapping(value = "/match", params = {"reset"}, method = RequestMethod.POST)
    public String memberReset(Model model) {

        Constants.initData();
        model.addAttribute("mem", Constants.u);
        model.addAttribute("member1", Constants.u);
        model.addAttribute("member2", Constants.u);

        model.addAttribute("member3", Constants.afterList);
        return "show";
    }

}
