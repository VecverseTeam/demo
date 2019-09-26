package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc  //不接管MVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean //组件要注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("login.html").setViewName("login");
                registry.addViewController("main.html").setViewName("offcanvas");
                registry.addViewController("register.html").setViewName("register");
                registry.addViewController("dashboard.html").setViewName("dashboard");
                registry.addViewController("product.html").setViewName("product");
/*                registry.addViewController("/user/register.html").setViewName("login");*/
            }
            //注册拦截器
            /*@Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/","/user/login","/user/register","/user/register/done","/*.css");
            }*/
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();

    }
}
