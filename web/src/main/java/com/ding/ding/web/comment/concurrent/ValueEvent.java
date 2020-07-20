package com.ding.ding.web.comment.concurrent;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ValueEvent {
    /**
     * 操作
     */
    private String handle;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 订单号
     */
    private String tradeId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 备注
     */
    private String remark;
    /**
     * 结果标志
     */
    private String resultFlag;


}
