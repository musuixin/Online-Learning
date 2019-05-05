package top.musuixin.Config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.musuixin.Interceptor.MyInterceptorLogin;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-03-30 21:32
 */
@Configuration
@EnableCaching
public class SpringMVCConfig implements WebMvcConfigurer {
    @Autowired
    MyInterceptorLogin myInterceptorLogin;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/newsList").setViewName("newsList.html");
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/courseList").setViewName("courseList.html");
        registry.addViewController("/study").setViewName("study.html");
        registry.addViewController("/user").setViewName("user.html");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterceptorLogin).addPathPatterns("/index","/newsList","/courseList","/courseList","/","/study","/user");
        registry.addInterceptor(myInterceptorLogin).addPathPatterns("/api/*").excludePathPatterns("/api/Login","/error");


    }

    @Bean
    @Scope("prototype")
    public HashMap<String, Object> hashMap() {
        return new HashMap<String, Object>();
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }


}
