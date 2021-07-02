package qianl.geektime.rpcfx.demo.api.service;

import qianl.geektime.rpcfx.demo.api.model.Order;

public interface OrderService {
    Order findOrderById(int id);
}
