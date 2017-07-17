package com.happy.job;

import org.apache.log4j.Logger;

/**
 * Created by lirongbo on 2017/7/6.
 */
public class TestJob {

    private Logger logger = Logger.getLogger(getClass());

    public void execute(){
        logger.error(System.currentTimeMillis());
    }

}
