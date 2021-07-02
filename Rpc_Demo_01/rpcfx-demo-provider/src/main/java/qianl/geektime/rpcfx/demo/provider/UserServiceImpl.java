package qianl.geektime.rpcfx.demo.provider;

import qianl.geektime.rpcfx.demo.api.model.User;
import qianl.geektime.rpcfx.demo.api.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(int id) {
        return new User(id,"qianl_geektime"+System.currentTimeMillis());
    }
}
