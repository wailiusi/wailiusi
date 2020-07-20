package com.ding.ding.web.notic;

public interface BaseTask {
    /**
     * 父类使用
     */
    static String BASE_STATUS = "BASE_STATUS";

    /**
     * 资金操作使用
     */
    static String ACCOUNT_STATUS = "ACCOUNT_STATUS";


    /**
     * 其它操作使用
     */
    static String OTHER_STATUS = "OTHER_STATUS";

    void execute();

    void handle();

    void stop();

    Object getLock();

}
