package com.wad.fils.di;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Profile({"dev"})
@Service
public class EmailMessageService implements MessageService {
  @Override
  public void sendMessage(String msg, String rec) {
    System.out.println("Email sent to "+rec+ " with Message="+msg);}}
