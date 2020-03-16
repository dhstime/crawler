package com.vedeng.crawler.service.crawler;

import com.vedeng.crawler.model.*;

public interface CrawlerService {
    /**
    *保存国产备案信息
    * @Author:strange
    * @Date:15:54 2020-03-07
    */
   public Integer  saveChnRecord(ChnRecord chnRecord);
    /**
     *保存国产注册信息
     * @Author:strange
     * @Date:15:54 2020-03-07
     */
   public Integer  saveChnRegister(ChnRegister chnRegister);
    /**
     *保存进口备案信息
     * @Author:strange
     * @Date:15:54 2020-03-07
     */
   public Integer  saveForeRecord(ForeRecord foreRecord);
    /**
     *保存进口注册信息
     * @Author:strange
     * @Date:15:54 2020-03-07
     */
   public Integer  saveForeRegister(ForeRegister foreRegister);

    /**
    *保存爬虫错误日志
    * @Author:strange
    * @Date:12:49 2020-03-14
    */
    public Integer saveCrawlerErrorLog(CrawlerErrorLog crawlerErrorLog);
    /**
    *检验爬虫错误
    * @Author:strange
    * @Date:16:21 2020-03-14
    */
    void checkCrawler();
}
