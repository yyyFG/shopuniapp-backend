package cn.demo_text3.controller;

import cn.demo_text3.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo3")
public class TestController {

    @GetMapping("/text")
    public R test(){
        return R.ok("nb 666");
    }
}
