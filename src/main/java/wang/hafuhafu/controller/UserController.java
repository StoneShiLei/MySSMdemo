package wang.hafuhafu.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import wang.hafuhafu.model.User;
import wang.hafuhafu.service.IUserService;
import lombok.Data;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation(value = "查找用户",notes = "根据id查找User对象")
    @ApiImplicitParam(name = "id",value = "用户的id",required = true,paramType = "query",dataType = "long")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public void selectUser(long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = this.userService.selectUser(id);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户",produces = "application/json")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user, HttpServletResponse response) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

}
