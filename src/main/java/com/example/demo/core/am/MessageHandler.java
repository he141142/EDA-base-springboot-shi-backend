package com.example.demo.core.am;

public interface MessageHandler {
   void HandleMessage(AmInComingMessage message) throws Exception;
}
