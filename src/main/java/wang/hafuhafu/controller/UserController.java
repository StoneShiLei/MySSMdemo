package wang.hafuhafu.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wang.hafuhafu.model.User;
import wang.hafuhafu.service.IUserService;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation(value = "查找用户",notes = "根据id查找User对象")
    @ApiImplicitParam(name = "id",value = "用户的id",required = true,paramType = "query",dataType = "long")
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    @ResponseBody
    public User selectUser(long id){
        return this.userService.selectUser(id);
    }


    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户",produces = "application/json")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User createUser1(@RequestBody User user){
        return user;
    }

    @RequestMapping(value = "/freemarker",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView freeMarker(@RequestParam(value = "a",required = false)String a) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("Stone");
        user.setEmail("569812422@qq.com");

        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        String param = a;

        modelAndView.addObject("list",list);
        modelAndView.addObject("user",user);
        modelAndView.addObject("param",param);
        modelAndView.setViewName("freemarker");
        return modelAndView;
    }

}
