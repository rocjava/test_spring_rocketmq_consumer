package com.penn.springrocketmqconsumer.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 2019/1/2.
 */
@Controller
public class IndexController {
    final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping("/home")
    public String index() {
        logger.info("greeting request is coming.");
        return "index";
    }

}
