package com.ding.ding.web.notic.task;

import com.ding.ding.web.notic.BaseTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTaskImpl implements BaseTask {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public Thread task = new Thread("Task") {

        private boolean isRun = true;

        @Override
        public void run() {
            while (isRun) {
                if (logger.isDebugEnabled()) {
                    logger.debug(this.getName() + " Running!");
                }
                handle();
                doWait();
            }
        }

        @SuppressWarnings("unused")
        public void stopThread() {
            isRun = false;
        }

    };

    public BaseTaskImpl() {
        task.start();
        if (logger.isDebugEnabled()) {
            logger.debug(task.getName() + "线程启动...");
        }
    }


    @Override
    public void execute() {
        if (logger.isDebugEnabled()) {
            logger.debug("task.execute()");
        }
        Object lock = getLock();
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void handle() {
        if (logger.isDebugEnabled()) {
            logger.debug("BaseTaskImp 开始");
        }
    }

    public void doWait() {
        Object lock = this.getLock();
        synchronized (getLock()) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getLock() {
        return BaseTask.BASE_STATUS;
    }
}
