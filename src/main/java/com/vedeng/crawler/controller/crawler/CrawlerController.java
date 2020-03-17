package com.vedeng.crawler.controller.crawler;

import com.vedeng.crawler.common.utils.CrawlerUtils;
import com.vedeng.crawler.controller.base.BaseController;
import com.vedeng.crawler.model.*;
import com.vedeng.crawler.service.crawler.CrawlerService;
import com.vedeng.crawler.service.crawler.TaskExecuteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *爬虫控制器
 * @author strange
 * @date $
 */
@RestController
public class CrawlerController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CrawlerUtils crawlerUtils;

    @Autowired
    private TaskExecuteService taskExecuteService;

    @Autowired
    private CrawlerService crawlerService;

    @RequestMapping("/initdata")
    public String initData(){
        return "success";
    }

    @RequestMapping("/init")
    public Integer init(){
        List<Class> classList = new ArrayList<>();
        classList.add(ForeRegister.class);
        classList.add(ForeRecord.class);
        classList.add(ChnRecord.class);
        classList.add(ChnRegister.class);
        taskExecuteService.execute(classList);
        return 0;
    }
    @RequestMapping("/frginit")
    public Integer frginit(Integer pageNum,Integer type){
        boolean flag =  getFlag(type);
        //完结
        Integer num = crawlerUtils.execute(ForeRegister.class, pageNum,flag);
        return num;
    }
    @RequestMapping("/crginit")
    public Integer crginit(Integer pageNum,Integer type){
        boolean flag =  getFlag(type);
        //3878
        Integer num = crawlerUtils.execute(ChnRegister.class, pageNum,flag);
        return num;
    }
    @RequestMapping("/crinit")
    public Integer crinit(Integer pageNum,Integer type){
        boolean flag =  getFlag(type);
        //  2941
        Integer num = crawlerUtils.execute(ChnRecord.class, pageNum,flag);
        return num;
    }
    @RequestMapping("/frinit")
    public Integer frinit(Integer pageNum,Integer type){
        boolean flag =  getFlag(type);
        //完结
        Integer num = crawlerUtils.execute(ForeRecord.class, pageNum,flag);
        return num;
    }
    @RequestMapping("/checkCrawler")
    public void checkCrawler(){
        crawlerService.checkCrawler();
    }
    private boolean getFlag(Integer type) {
        boolean flag = false;
        if(type!= null && type.equals(1)){
            flag = true;
        }
        return flag;
    }
}
