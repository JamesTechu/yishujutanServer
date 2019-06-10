//package com.studio.yishujutan.controller.tool;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.web.servlet.ErrorPage;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//
//@Configuration
//public class ErrorConfig {
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//                ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/401.html");
//                ErrorPage error404Page=new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
//                ErrorPage error500Page=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.xml");
//
//                configurableEmbeddedServletContainer.addErrorPages(error401Page,error404Page,error500Page);
//            }
//        };
//    }
//}
