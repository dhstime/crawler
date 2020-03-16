package com.vedeng.beetl;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

/**
 * <b>Description: beetl配置</b><br>
 * <b>Author: Franlin.wu</b>
 * 
 * @fileName BeetlConfig.java <br>
 *           <b>Date: 2019年3月12日 下午1:17:55 </b>
 *
 */
@Configuration
public class IbeetlConfig
{
	/**
	 * 日志
	 */
	private static final Logger log = LoggerFactory.getLogger(IbeetlConfig.class);

	/**
	 * 配置beetl.properties路径
	 */
	@Value("${beetl.configPath}")
	String beetlConfigPath;

	/**
	 * 返回配置
	 */
	@Value("${beetl.contentType}")
	String beetlContentType;

	/**
	 * 设置后缀
	 */
	@Value("${beetl.suffix}")
	String beetlSuffix;

	/**
	 * 
	 * <b>Description: beetl初始化配置</b><br> 
	 * @return
	 * <b>Author: Franlin.wu</b>  
	 * <br><b>Date: 2019年3月12日 下午1:54:50 </b>
	 */
	@Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() 
	{
		log.info("beetl 启动开始 ...");
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        // 使用加载beetl.jar的classloader，以及默认root为根目录
        ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader();
        // Beetl资源加载器，如果未指定，会自动依据ApplicationContext和配置文件识别
        beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
        // 配置加载beetl.properties
        ResourcePatternResolver resouce = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        beetlGroupUtilConfiguration.setConfigFileResource(resouce.getResource(beetlConfigPath));
        log.info("beetl 加载配置文件路径:{}", beetlConfigPath);
        log.info("beetl 启动结束 ...");
        return beetlGroupUtilConfiguration;
    }

	/**
	 * 
	 * <b>Description: 页面view配置</b><br> 
	 * @param beetlGroupUtilConfiguration
	 * @return
	 * <b>Author: Franlin.wu</b>  
	 * <br><b>Date: 2019年3月12日 下午2:01:18 </b>
	 */
	@Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) 
	{
		log.info("beetlViewResolver 启动开始 ...");
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        log.info("设置view的返回ContentType:{}", beetlContentType);
        log.info("设置view的后缀suffix:{}", beetlSuffix);
        beetlSpringViewResolver.setContentType(beetlContentType);
        
        //不启用 springMvc 的 前缀。。使用 beetl自带 的 RESOURCE.root
        beetlSpringViewResolver.setSuffix(beetlSuffix);
        beetlSpringViewResolver.setOrder(0);
        
        // 配置
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        
        log.info("beetlViewResolver 启动结束 ...");
        return beetlSpringViewResolver;
    }
}
