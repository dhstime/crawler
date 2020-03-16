package com.test.crawler;

import com.vedeng.crawler.common.annotation.Extract;
import com.vedeng.crawler.common.annotation.SeleniumDocument;
import com.vedeng.crawler.model.ChnRegister;
import com.vedeng.crawler.model.ForeRegister;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class seleniumTest {

   @Test
    public void Test() throws Exception{
        // 加载驱动
        System.setProperty("webdriver.gecko.driver", "/Users/dhs/Downloads/geckodriver");
//        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
       Class<ChnRegister> clazz = ChnRegister.class;
       SeleniumDocument annotation = clazz.getAnnotation(SeleniumDocument.class);
       String cssQuery = annotation.cssQuery();
       String domain = annotation.domain();
       String targetUrl = annotation.targetUrl();
       //页面加载超时时间设置为 5s
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // 访问登陆页面
       driver.get(domain);
       //定位对象时给 5s 的时间, 如果 5s 内还定位不到则抛出异常
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //国产医疗器械产品（注册）
       List<WebElement> elements = driver.findElementsByClassName(cssQuery);
       for (WebElement element : elements) {
           if(element.getText().contains(targetUrl)) {
               WebElement element1 = element.findElement(By.tagName("a"));
               onClick(element1,driver);
               System.out.println(element1.getText());
               System.out.println(element1.getAttribute("href"));
           }
       }
//      Integer pageNmber =  getPageNumber(driver);
//       int i = 2;
//       while (i < pageNmber){
////           ArrayList<String>  childPage = getChildPage(driver,clazz);
//           nextPage(driver,i);
//           i++;
//       }

//        Thread.sleep(5000L);
//        driver.quit();
    }


    private ArrayList<String> getChildPage(FirefoxDriver driver, Class clazz) throws IllegalAccessException, InstantiationException {
        //子页面表格
        ArrayList<String> countList = new ArrayList<>();
        List<WebElement> list = driver.findElementsByPartialLinkText("械注");
        for (WebElement webElement : list) {
//            System.out.println(webElement.getAttribute("href"));
            countList.add(webElement.getAttribute("href"));
        }
        for (String title : countList) {
            //跳转详情页
            driver.executeScript(title);
            //获取字段数据
            ChnRegister object = (ChnRegister) clazz.newInstance();
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
                    } else {
                        //如果存在1和2以外的值,抛异常
                        throw new RuntimeException("字段" + field.getName() + "contentType属性类型只能是1或者2");
                    }
                }
            }
//            try {
//
//            queueGenerationService.addData(chnRegister);
//        }catch (Exception e){
//
//        }
            System.out.println(object.getChnRegisterNumber());
            //回退
            rollback(driver);
//            i++;
//            if(i> 0)
//                break;
        }

        return countList;
    }
    /**
    *跳转下一页
    * @Author:strange
    * @Date:15:42 2020-03-09
    */
    private FirefoxDriver nextPage(FirefoxDriver driver,Integer num)  {
        driver.executeScript("javascript:devPage("+num+")");
        return  driver;
    }
    /**
    *回退列表页
    * @Author:strange
    * @Date:15:43 2020-03-09
    */
    private void rollback(FirefoxDriver driver) {
        driver.executeScript("javascript:viewList()");
    }
    /**
    * 点击事件
    * @Author:strange
    * @Date:15:43 2020-03-09
    */
    private JavascriptExecutor onClick(WebElement webElement,JavascriptExecutor JsExecutor) {
        JsExecutor.executeScript("arguments[0].click();",webElement);
        return JsExecutor;
    }

    private Integer getPageNumber(FirefoxDriver driver) {
        WebElement element = driver.findElementByCssSelector("#content > div > table:nth-child(4) > tbody > tr > td");
        String text = element.getText();
        String[] split = text.split("/共");
        String[] split1 = split[1].split("页");
        return Integer.valueOf(split1[0]);
    }
}
