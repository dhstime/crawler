
package com.vedeng.main;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;




/**
 * <b>Description: springboot项目启动类</b><br> 
 * <b>Author: Franlin.wu-吴创连</b>
 * @fileName AppStart.java
 * <br><b>Date: 2019年3月8日 下午1:43:00 </b> 
 */
@Configuration
@ComponentScan(basePackages = "com.vedeng.config,com.vedeng.controller,com.vedeng.service")
@MapperScan("com.vedeng.dao")
@EnableAutoConfiguration
public class AppStart
{
	/**
	 * 日志
	 */
	private static final Logger log = LoggerFactory.getLogger(AppStart.class);
	
	/**
	 * 
	 * <b>Description: 启动入口</b><br> 
	 * @param args
	 * <b>Author: Franlin.wu-吴创连</b> 
	 * <b>Email: franlin_wu@163.com</b> 
	 * <br><b>Date: 2019年3月8日 下午1:54:10 </b>
	 */
	public static void main( String[] args )
    {
    	SpringApplication.run(AppStart.class, args);
    	
    	log.info("===========================================================================");
    	log.info("spring boot 启动结束 ...                                                    ||");
    	log.info("------------------------------- run  successful----------------------------");
    	log.info("===========================================================================");
    }
}

