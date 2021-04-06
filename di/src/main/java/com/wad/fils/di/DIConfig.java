//package com.wad.fils.di;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Profile({"prod"})
//@Configuration
//public class DIConfig {
//
//  @Bean
//  public MessageService service(){
//    return new MessageServiceImpl();
//  }
//
//  @Bean
//  public DiConsumer diConsumer(MessageService service){
//    return new DiConsumer(service);
//  }
//}
