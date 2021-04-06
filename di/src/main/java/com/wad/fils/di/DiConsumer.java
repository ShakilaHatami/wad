package com.wad.fils.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DiConsumer {
  private final MessageService service;
  public DiConsumer(MessageService service){
    this.service=service;}
  public void processMessages(String msg, String rec){
    //do some msg validation, manipulation logic etc
    this.service.sendMessage(msg, rec);}}


