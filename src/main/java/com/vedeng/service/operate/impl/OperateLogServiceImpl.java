
package com.vedeng.service.operate.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedeng.dao.operate.OperateLogMapper;
import com.vedeng.model.operate.OperateLog;
import com.vedeng.service.base.impl.BaseServiceImpl;
import com.vedeng.service.operate.OperateLogService;

/**
 * <b>Description:</b><br> 
 * <b>Author: Franlin.wu-吴创连</b>
 * <b>Email: franlin_wu@163.com</b>
 * @fileName OperateLogServiceImpl.java
 * <br><b>Date: 2019年3月8日 下午3:24:54 </b> 
 *
 */
@Service("operateLogService")
public class OperateLogServiceImpl extends BaseServiceImpl implements OperateLogService
{
	@Autowired
	private OperateLogMapper operateLogMapper;

	// TODO 事务  测试代码
	@Override
	public void add(OperateLog operateLog)
	{
		operateLogMapper.insertSelective(operateLog);
	}

}

