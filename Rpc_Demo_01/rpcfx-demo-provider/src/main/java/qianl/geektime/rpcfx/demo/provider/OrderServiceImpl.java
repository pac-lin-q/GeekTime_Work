package qianl.geektime.rpcfx.demo.provider;

import qianl.geektime.rpcfx.demo.api.model.Order;
import qianl.geektime.rpcfx.demo.api.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order findOrderById(int id) {
        return new Order(id, "qianl_geektime"+ System.currentTimeMillis(),100.00f);
    }
}
