package wang.hafuhafu.dao;

import wang.hafuhafu.model.User;

public interface IUserDao {
    User selectUser(long id);
}
