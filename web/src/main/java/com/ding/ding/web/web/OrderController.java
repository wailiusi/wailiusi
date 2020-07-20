package com.ding.ding.web.web;

import com.ding.ding.db.vo.response.ResponseResult;
import com.ding.ding.web.comment.concurrent.ValueEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/wx/order")
@RestController("V100AccountController")
@Api(value = "订单", description = "订单")
public class OrderController {

    @ApiOperation(value = "购物下单")
    @ApiImplicitParam(name = "X-Litemall-Token", value = "登录返回的token", required = false, paramType = "header", dataType = "String")
    @PostMapping("submitOrder")
    public ResponseResult shopping() {
        ValueEvent event = new ValueEvent();
        event.setHandle("submit");
        event.setResultFlag(System.currentTimeMillis() + "" + Math.random() * 10000);
        event.setMoney(BigDecimal.ONE);
        event.setUserId(1550);
        event.setTradeId("202002171433");
        //JobQueue.getGameRewardInstance().offer(event);
        return null;
    }

}
