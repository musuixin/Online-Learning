package top.musuixin.Config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/studentTable").setViewName("studentTable.html");
        registry.addViewController("/teacherTable").setViewName("teacherTable.html");
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/register").setViewName("register.html");
        registry.addViewController("/courseTable").setViewName("courseTable.html");
        registry.addViewController("/selectionTable").setViewName("selectionTable.html");
        registry.addViewController("/news").setViewName("news.html");
        registry.addViewController("/newsTable").setViewName("newsTable.html");


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptorLogin()).addPathPatterns("/studentTable", "/index",
                "/teacherTable", "/api/**", "/courseTable", "/selectionTable", "/news");
    }

    @Bean
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
