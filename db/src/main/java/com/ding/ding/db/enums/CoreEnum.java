package com.ding.ding.db.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoreEnum {

    /**
     * 启用禁用
     */
    ENABLE(1, "启用"),
    DISABLE(0, "禁用"),

    /**
     * 是否
     */
    YES(1, "是"),
    NO(0, "否"),


    /**
     * 时间单位
     */
    YEAR(1, "年"),
    MONTH(2, "月"),
    DAY(3, "日"),

    /**
     * 是否删除
     */
    DELETE_YES(1, "已删除"),
    DELETE_NO(0, "未删除");

    private Integer code;
    private String name;

}
