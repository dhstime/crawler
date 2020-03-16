package com.vedeng.crawler.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  标识爬虫该类用来接收爬虫爬取的结果
 * @author strange
 * @date $
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SeleniumDocument {
    /**
    *目标网站的域名
    * @Author:strange
    * @Date:12:35 2020-03-01
    */
    String domain();
    
    /**
    * 目标url
     * 如果设置了targetUrl ,那么爬取的目标url以targetUrl为主
    * @Author:strange
    * @Date:12:35 2020-03-01
    */
    String targetUrl() default "";

    /**
    *  CSS选择器
    * @Author:strange
    * @Date:12:37 2020-03-01
    */
    String cssQuery() default "";

    /**
    *获取对象中哪个属性
    * @Author:strange
    * @Date:08:38 2020-03-02
    */
    String hrefAttr() default "";

    /**
    *  部分文本定位
    * @Author:strange
    * @Date:09:58 2020-03-10
    */
    String partTitle() default "";
    /**
    *回退css
    * @Author:strange
    * @Date:10:10 2020-03-10
    */
    String rollBackCss() default "";
    /**
    *总页数css
    * @Author:strange
    * @Date:10:11 2020-03-10
    */
    String pageNumberCss() default "";

    /**
    *标识名
    * @Author:strange
    * @Date:10:33 2020-03-14
    */
    String clazzName() default "";
}
