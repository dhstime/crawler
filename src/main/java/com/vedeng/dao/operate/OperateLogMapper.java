
package com.vedeng.dao.operate;

import com.vedeng.model.operate.OperateLog;

/**
 * <b>Description:</b><br> 
 * <b>Author: Franlin.wu-吴创连</b>
 * <b>Email: franlin_wu@163.com</b>
 * @fileName OperateLogDao.java
 * <br><b>Date: 2019年3月7日 下午4:11:05 </b> 
 *
 */
public interface OperateLogMapper
{
	
	/**
	 * 
	 * <b>Description: 插入</b><br> 
	 * @param operateLog
	 * @return
	 * <b>Author: Franlin.wu-吴创连</b> 
	 * <b>Email: franlin_wu@163.com</b> 
	 * <br><b>Date: 2019年3月7日 下午4:17:14 </b>
	 */
	int insertSelective(OperateLog operateLog);

	/**
	 * 
	 * <b>Description: 查询</b><br> 
	 * @param operateLogId
	 * @return
	 * <b>Author: Franlin.wu-吴创连</b> 
	 * <b>Email: franlin_wu@163.com</b> 
	 * <br><b>Date: 2019年3月7日 下午4:18:10 </b>
	 */
	OperateLog selectByPrimaryKey(int operateLogId);
	
	/**
	 * 
	 * <b>Description: 更新</b><br> 
	 * @param operateLog
	 * @return
	 * <b>Author: Franlin.wu</b>  
	 * <br><b>Date: 2019年3月12日 上午10:00:00 </b>
	 */
	int updateByPrimaryKeySelective(OperateLog operateLog);
}

