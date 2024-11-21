package com.example.demo.core.cqs;

public interface CommandHandler<P, C extends Command<P>> {
    P HandleCommand(C cmd) throws Exception;
}
