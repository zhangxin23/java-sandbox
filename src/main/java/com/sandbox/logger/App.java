package com.sandbox.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        System.out.println("#########################");

        logger.info("----------begin------------");
        System.out.println( "Hello World!" );
        logger.info("-----------end-------------");
    }
}
