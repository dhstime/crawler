package com.vedeng.crawler.service.crawler.impl;

import com.vedeng.crawler.mapper.*;
import com.vedeng.crawler.model.*;
import com.vedeng.crawler.service.crawler.CrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class CrawlerServiceImpl implements CrawlerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ChnRegisterMapper chnRegisterMapper;

    @Resource
    private ChnRecordMapper chnRecordMapper;

    @Resource
    private ForeRecordMapper foreRecordMapper;

    @Resource
    private ForeRegisterMapper foreRegisterMapper;

    @Resource
    private CrawlerErrorLogMapper crawlerErrorLogMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveChnRecord(ChnRecord chnRecord) {
        int i = 0;
        try {
            ChnRecord old = chnRecordMapper.getChnRecordByNumber(chnRecord);
            if(old == null){
                i = chnRecordMapper.insert(chnRecord);
            }else{
                chnRecord.setChnRecordId(old.getChnRecordId());
                i = chnRecordMapper.updateByPrimaryKeySelective(chnRecord);
            }
            return i;
        }catch (Exception e){
            logger.error("saveChnRecord Number:{},error:{}",chnRecord.getChnRecordNumber(),e);
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveChnRegister(ChnRegister chnRegister) {
        int i = 0;
        try {
            ChnRegister old =  chnRegisterMapper.getChnRegisterByNumber(chnRegister);
        if(old == null){
            i = chnRegisterMapper.insert(chnRegister);
        }else{
            chnRegister.setChnRegisterId(old.getChnRegisterId());
            i = chnRegisterMapper.updateByPrimaryKeySelective(chnRegister);
        }
        }catch (Exception e){
            logger.error("saveChnRegister Number:{},error:{]",chnRegister.getChnRegisterNumber(),e);

        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveForeRecord(ForeRecord foreRecord) {
        int i = 0;
        try {
            ForeRecord old =  foreRecordMapper.getForeRecordByNumber(foreRecord);
            if(old == null){
            i = foreRecordMapper.insert(foreRecord);
        }else{
            foreRecord.setForeRecordId(old.getForeRecordId());
            i = foreRecordMapper.updateByPrimaryKeySelective(foreRecord);
        }
        }catch (Exception e){
            logger.error("saveForeRecordd number:{},error:{}",foreRecord.getForeRecordNumber(),e);
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveForeRegister(ForeRegister foreRegister) {
        int i = 0;
        try {
            ForeRegister old = foreRegisterMapper.getForeRegisterByNumber(foreRegister);
        if(old == null){
            i = foreRegisterMapper.insert(foreRegister);
        }else{
            foreRegister.setForeRegisterId(old.getForeRegisterId());
            i = foreRegisterMapper.updateByPrimaryKeySelective(foreRegister);
        }
        }catch (Exception e){
            logger.error("saveForeRegister number:{},error:{}",foreRegister.getForeRegisterNumber(),e);
        }
        return i;
    }

    @Override
    public Integer saveCrawlerErrorLog(CrawlerErrorLog crawlerErrorLog) {
        return crawlerErrorLogMapper.insertSelective(crawlerErrorLog);
    }

    @Override
    public void checkCrawler() {

    }

}
