package io.github.ahogek.mall.listener;

import com.google.gson.Gson;
import io.github.ahogek.mall.pojo.PayInfo;
import io.github.ahogek.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 关于PayInfo的正确使用方式不应该是复制，而是通过pay项目提供一个jar包让mall项目引入 相关可通过学习SpringCloud微服物熟悉使用
 */
@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMsgListener {

    @Autowired
    IOrderService orderService;

    @RabbitHandler
    public void process(String msg) {
        log.info("[Pay Message] => {}", msg);
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        orderService.paid(payInfo.getOrderNo());
    }
}
