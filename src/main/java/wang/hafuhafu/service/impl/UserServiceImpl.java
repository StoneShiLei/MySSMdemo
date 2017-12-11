package wang.hafuhafu.service.impl;

import wang.hafuhafu.dao.IUserDao;
import wang.hafuhafu.model.User;
import wang.hafuhafu.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
