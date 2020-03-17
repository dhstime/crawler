package com.vedeng.crawler.common.utils;

import com.vedeng.crawler.common.annotation.Extract;
import com.vedeng.crawler.common.annotation.SeleniumDocument;
import com.vedeng.crawler.common.queue.QueueGenerationService;
import com.vedeng.crawler.common.queue.QueueTaskHandler;
import com.vedeng.crawler.model.ChnRegister;
import com.vedeng.crawler.model.CrawlerErrorLog;
import com.vedeng.crawler.service.crawler.CrawlerService;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 爬虫工具类
 *
 * @author strange
 * @date $
 */
@Component
public class CrawlerUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Value("${engine_path}")
//    protected String enginePath;

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private QueueGenerationService queueGenerationService;

    /**
    *获取连接
    * @Author:strange
    * @Date:13:05 2020-03-01
    */
    @Bean
    @Scope(value = "prototype")
    private   OperaDriver creatConnect(String url){
        System.setProperty("webdriver.opera.driver","/Users/dhs/Downloads/operadriver");
        OperaOptions options = new OperaOptions();
//        System.setProperty("webdriver.gecko.driver","/Users/dhs/Downloads/geckodriver");
//        FirefoxOptions options = new FirefoxOptions();
//        System.setProperty("webdriver.chrome.driver","/Users/dhs/Downloads/chromedriver");
//        ChromeOptions options = new ChromeOptions();
        List<String> optionList = new ArrayList<>();
        optionList.add("enable-automation");
        options.addArguments("start-maximized");
////        options.addPreference("excludeSwitches","enable-automation");
////        options.addPreference("useAutomationExtension",false);
        options.setExperimentalOption("excludeSwitches",optionList);
        options.setExperimentalOption("useAutomationExtension",false);
//        ChromeDriver driver = new ChromeDriver(options);
//        FirefoxDriver driver = new FirefoxDriver(options);
        OperaDriver driver = new OperaDriver(options);
        //页面加载超时时间设置为 10s
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(url);
        //定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

//    private void webSrc(ChromeDriver driver) {
//        driver.executeScript("Object.defineProperties(navigator, {webdriver:{get:()=>undefined}});");
//    }


    /**
    *执行爬虫程序
     * @return i 取值到第几页
    * @Author:strange
    * @Date:16:31 2020-03-01
    */
    public Integer execute(Class<?> clazz , Integer statrNum,Boolean nextFlag) {
        SeleniumDocument seleniumDocument = clazz.getAnnotation(SeleniumDocument.class);
        String pageNumberCss = seleniumDocument.pageNumberCss();
        if(seleniumDocument == null){
            throw new RuntimeException("该实体类不是爬虫实体类");
        }
        String url = seleniumDocument.domain();
        if(StringUtils.isBlank(url)){
            throw new RuntimeException("未指定爬取目标url");
        }
        Integer nowpageNumber = 1;
        OperaDriver driver = creatConnect(url);
        try {
//           // 获取类上的css选择器
//            String cssQuery = seleniumDocument.cssQuery();
//            String targetUrl = seleniumDocument.targetUrl();
//            List<WebElement> elements = driver.findElementsByClassName(cssQuery);
//            for (WebElement element : elements) {
//                if(element.getText().contains(targetUrl)) {
//                    WebElement element1 = element.findElement(By.tagName("a"));
//                    onClick(element1,driver);
//                }
//            }
        Integer pageNumber = getPageNumber(driver,pageNumberCss);
        if(statrNum != null && statrNum > 0){
            nowpageNumber = statrNum;
        }
            while (nowpageNumber <= pageNumber){
                long l = System.currentTimeMillis();
                nextPage(driver,nowpageNumber);
                ArrayList<String> childPageList = getChildPage(driver,clazz,seleniumDocument,nowpageNumber);
                long l1 = System.currentTimeMillis();
                if(!CollectionUtils.isEmpty(childPageList)) {
                    logger.info(seleniumDocument.clazzName() + ":" + (nowpageNumber) + "页耗时: " + (l1 - l) + " 总计:" + childPageList.size() + "条");
                }
                if(nextFlag){
                    break;
                }
                nowpageNumber++;

            }
        }catch (Exception e){
            logger.error("execute className:{},pageNum:{},error:{}",clazz.getName(),nowpageNumber,e);
            CrawlerErrorLog crawlerErrorLog = new CrawlerErrorLog(clazz.getName(),nowpageNumber,2);
            crawlerService.saveCrawlerErrorLog(crawlerErrorLog);
        }finally {
            driver.quit();
            return nowpageNumber;
        }
    }
    private ArrayList<String> getChildPage(OperaDriver driver, Class<?> clazz,SeleniumDocument seleniumDocument,Integer nowpageNumber) {
        String rollBackCss = seleniumDocument.rollBackCss();
        String partTitle = seleniumDocument.partTitle();
        //子页面表格
        ArrayList<String> countList = new ArrayList<>();
        try {
        List<WebElement> list = driver.findElementsByPartialLinkText(partTitle);
        for (WebElement webElement : list) {
            countList.add(webElement.getAttribute("href"));
        }
        for (String title : countList) {
            //跳转详情页
            driver.executeScript(title);
            //获取字段数据
            Object object = clazz.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Extract extract = field.getAnnotation(Extract.class);
                if(extract != null) {
                    String cssQuery = extract.cssQuery();
                    WebElement fieldElements = driver.findElementByCssSelector(cssQuery);
                    int contentType = extract.contentType();
                    if (contentType == 1) {
                        //执行text
                        String text = fieldElements.getText();
                        field.set(object, text);
                    } else if (contentType == 2) {
                        String html = fieldElements.getTagName();
                        field.set(object, html);
                    }
                }
            }
            try {
                queueGenerationService.addData((QueueTaskHandler)object);
            }catch (Exception e){
                logger.error("addData error:{]",e);
            }
            //回退
            rollback(driver,rollBackCss);
        }
        }catch (Exception e){
            logger.error("getChildPage className:{},pageNumber:{},error:{}",clazz.getName(),nowpageNumber,e);
            CrawlerErrorLog crawlerErrorLog = new CrawlerErrorLog(clazz.getName(),nowpageNumber,1);
            crawlerService.saveCrawlerErrorLog(crawlerErrorLog);
        }
        return countList;
    }
    /**
     *跳转下一页
     * @Author:strange
     * @Date:15:42 2020-03-09
     */
    private OperaDriver nextPage(OperaDriver driver,Integer num)  {
        driver.executeScript("javascript:devPage("+num+")");
        return  driver;
    }
    /**
     *回退列表页
     * @Author:strange
     * @Date:15:43 2020-03-09
     */
    private void rollback(OperaDriver driver,String jsc) {
        driver.executeScript(jsc);
    }
    /**
     * 点击事件
     * @Author:strange
     * @Date:15:43 2020-03-09
     */
    private JavascriptExecutor onClick(WebElement webElement, JavascriptExecutor JsExecutor) {
        JsExecutor.executeScript("arguments[0].click();",webElement);
        return JsExecutor;
    }

    private Integer getPageNumber(OperaDriver driver,String jsc) {
        WebElement element = driver.findElementByCssSelector(jsc);
        String text = element.getText();
        String[] split = text.split("/共");
        String[] split1 = split[1].split("页");
        return Integer.valueOf(split1[0]);
    }

    public List<Integer> execute(Class<?> clazz, List<CrawlerErrorLog> crgList,List<Integer> idList) {
        SeleniumDocument seleniumDocument = clazz.getAnnotation(SeleniumDocument.class);
        if(seleniumDocument == null){
            throw new RuntimeException("该实体类不是爬虫实体类");
        }
        String url = seleniumDocument.domain();
        if(StringUtils.isBlank(url)){
            throw new RuntimeException("未指定爬取目标url");
        }
        OperaDriver driver = creatConnect(url);
        try {
            Thread.sleep(2000L);
        }catch (Exception e){

        }
        for (CrawlerErrorLog crawlerErrorLog : crgList) {
            long l = System.currentTimeMillis();
            ArrayList<String> childPageList = new ArrayList<>();
            try {
                nextPage(driver,crawlerErrorLog.getPageNum());
                childPageList = getChildPage(driver,clazz,seleniumDocument,crawlerErrorLog.getPageNum());
            }catch (Exception e){
                logger.error("补偿失败 className:{},pageNumber:{},error:{}",clazz.getName(),crawlerErrorLog.getPageNum(),e);
            }

            if(!CollectionUtils.isEmpty(childPageList)){
                idList.add(crawlerErrorLog.getCrawlerErrorLogId());
            }
            long l1 = System.currentTimeMillis();
            if(!CollectionUtils.isEmpty(childPageList)) {
                logger.info(seleniumDocument.clazzName() + ":" + (crawlerErrorLog.getPageNum()) + "页耗时: " + (l1 - l) + " 总计:" + childPageList.size() + "条");
            }
        }
        driver.quit();
        return idList;
    }

    /**
     *将内容写入指定文档
     * @Author:strange
     * @Date:17:22 2020-02-29
     */
    public static void write(String body,String fileName) throws Exception {
        File dir = new File("/Users/dhs/Documents/jsoup");
        File file = new File(dir,fileName);

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
//        String file="abc/pw.txt";
        FileOutputStream fos=new FileOutputStream(file);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        OutputStreamWriter osw =new OutputStreamWriter(bos, "utf-8");
        //PrintWriter：是高级流，扩展了println方法和print
        // true 自动清理缓存功能，每个println方法之后会执行一个flush方法
        PrintWriter out=new PrintWriter(osw, true);
        out.println(body);
        out.close();

    }
}



