package me.nimkoes;

import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor())
            .addPathPatterns("/hi")
            .order(0);
        registry.addInterceptor(new AnotherInterceptor()).order(-1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")            // 어떤 패턴의 요청을 처리할지 정의
            .addResourceLocations("classpath:/m/", "file:/Users/nimkoes/files/", "/myStatic/")  // 리소스를 찾을 위치
            .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));  // 리소스가 변경되지 않은 동안 캐싱을 유지할 시간
    }
}
