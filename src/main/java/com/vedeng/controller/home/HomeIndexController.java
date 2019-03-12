
package com.vedeng.controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedeng.controller.base.BaseController;
import com.vedeng.model.operate.OperateLog;
import com.vedeng.service.operate.OperateLogService;

/**
 * <b>Description:</b><br> 
 * <b>Author: Franlin.wu-吴创连</b>
 * @fileName HomeIndexController.java
 * <br><b>Date: 2019年3月8日 下午3:29:17 </b> 
 *
 */
@RestController
public class HomeIndexController extends BaseController
{
	/**
	 * 记录日志
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OperateLogService operateLogService;
	
	/**
	 * 
	 * <b>Description: 测试</b><br> 
	 * @param var
	 * @param version
	 * @return
	 * <b>Author: Franlin.wu-吴创连</b> 
	 * <b>Email: franlin_wu@163.com</b> 
	 * <br><b>Date: 2019年3月8日 下午3:31:57 </b>
	 */
	@RequestMapping("/{var}")
	public OperateLog test(@PathVariable String var, // PathVariable : 路径上的变量参数 
			@RequestHeader(value = "version", required = true, defaultValue = "v1") String version, // RequestHeader : 请求头的字段参数
			HttpServletRequest request, HttpServletResponse response
	)
	{
		log.info("测试接口,入参:{}", var);
		log.info("新增一条记录 开始...");
		OperateLog operateLog = new OperateLog();
		operateLog.setOperateLogName(var);
		operateLog.setAccessUa(request.getHeader("User-Agent"));
		operateLog.setAccessTime(System.currentTimeMillis());
		operateLogService.add(operateLog);
		log.info("新增一条记录 结束...");
		
		return operateLog;
	}

}

