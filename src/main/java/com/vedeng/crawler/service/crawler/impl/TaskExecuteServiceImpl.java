package com.vedeng.crawler.service.crawler.impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.vedeng.crawler.common.utils.CrawlerUtils;
import com.vedeng.crawler.model.CrawlerErrorLog;
import com.vedeng.crawler.service.crawler.CrawlerService;
import com.vedeng.crawler.service.crawler.TaskExecuteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.*;

/**
 *  任务执行
 * @author strange
 * @date $
 */
@Service
public class TaskExecuteServiceImpl implements TaskExecuteService {

    private static final Logger log = LoggerFactory.getLogger(TaskExecuteServiceImpl.class);

    @Autowired
    private CrawlerUtils crawlerUtils;

    @Autowired
    private CrawlerService crawlerService;

    private ExecutorService service = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,  new LinkedBlockingQueue<Runnable>(1024),
            new ThreadFactoryBuilder().setNameFormat("TaskExecute-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());
    /**
     *检查服务是否运行
     * @Author:strange
     * @Date:21:37 2020-03-07
     */
    private volatile boolean running = true;
    /**
     *   线程状态
     * @Author:strange
     * @Date:21:37 2020-03-07
     */
    private Future<?> serviceThreadStatus = null;
    @Override
    public void execute(List<Class> classList) {
        if(!CollectionUtils.isEmpty(classList)) {
            for (Class aClass : classList) {
                serviceThreadStatus = service.submit(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Integer pageNum = 0;
                        try{
                            pageNum = crawlerUtils.execute(aClass, 1, false);
                        }catch (Exception e){
                            log.error("TaskExecuteService pageNum:{},class:{},error:{}",pageNum,aClass.getName(),e);
                            CrawlerErrorLog crawlerErrorLog = new CrawlerErrorLog(aClass.getName(),pageNum,2);
                            crawlerService.saveCrawlerErrorLog(crawlerErrorLog);
                        }
                    }
                }),"TaskExecute thread");
            }

            Thread thread = new DaemonT();
            thread.setDaemon(true);
            thread.start();
        }
    }
    public class DaemonT extends Thread{
        @Override
        public void run() {
            try {
                while (checkServiceRun()){
                    Thread.sleep(600000L);
                    log.info("DaemonT++++"+checkServiceRun());
                }
            }catch (Exception e){
                log.error("DaemonT error:{}",e);
            }
        }
    }
    public boolean checkServiceRun() {
        return running && !service.isShutdown() && !serviceThreadStatus.isDone();
    }

    @PreDestroy
    public void destory() {
        running = false;
        service.shutdownNow();
    }
}
