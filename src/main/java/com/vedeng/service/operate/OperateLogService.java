
package com.vedeng.service.operate;

import com.vedeng.model.operate.OperateLog;

/**
 * <b>Description:</b><br> 
 * <b>Author: Franlin.wu-吴创连</b>
 * <b>Email: franlin_wu@163.com</b>
 * @fileName OperateLogService.java
 * <br><b>Date: 2019年3月8日 下午3:24:35 </b> 
 *
 */
public interface OperateLogService
{
	
	/**
	 * 
	 * <b>Description: 新增</b><br> 
	 * @param operateLog
	 * <b>Author: Franlin.wu-吴创连</b> 
	 * <b>Email: franlin_wu@163.com</b> 
	 * <br><b>Date: 2019年3月8日 下午3:34:52 </b>
	 */
	void add(OperateLog operateLog);
}

