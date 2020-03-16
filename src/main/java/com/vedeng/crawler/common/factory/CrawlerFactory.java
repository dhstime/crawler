package com.vedeng.crawler.common.factory;

import com.vedeng.crawler.model.ChnRecord;
import com.vedeng.crawler.model.ChnRegister;
import com.vedeng.crawler.model.ForeRecord;
import com.vedeng.crawler.model.ForeRegister;
import com.vedeng.crawler.service.crawler.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  工厂类实现
 * @author strange
 * @date $
 */
@Component
public class CrawlerFactory implements IfCrawlerFactory{
    @Autowired
    private CrawlerService crawlerService;
    @Override
    public Integer saveCrawlerInfo(Object object) {
        Integer i = 0;
        if(object instanceof ChnRecord){

             i = crawlerService.saveChnRecord((ChnRecord)object);

        }else if(object instanceof ChnRegister){

             i = crawlerService.saveChnRegister((ChnRegister)object);

        }else if(object instanceof ForeRegister){

            i = crawlerService.saveForeRegister((ForeRegister)object);

        }else if(object instanceof ForeRecord){

            i = crawlerService.saveForeRecord((ForeRecord)object);

        }
        return i;
    }
}
