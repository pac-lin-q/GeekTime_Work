package qianl.geektime.rpcfx.demo.api.service;

import qianl.geektime.rpcfx.demo.api.model.User;

public interface UserService {
    User findUserById(int id);
}
