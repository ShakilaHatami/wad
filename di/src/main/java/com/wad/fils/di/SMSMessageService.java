package com.wad.fils.di;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"prod"})
@Service
public class SMSMessageService implements MessageService {
  @Override
  public void sendMessage(String msg, String rec) {
    System.out.println("SMS sent to "+rec+ " with Message="+msg);}}

