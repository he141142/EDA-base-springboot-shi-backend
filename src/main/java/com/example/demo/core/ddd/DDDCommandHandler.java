package com.example.demo.core.ddd;

import com.example.demo.core.am.AmReplyMessage;
import com.example.demo.core.cqs.Command;

public interface DDDCommandHandler<T extends Command<?>> {
    AmReplyMessage Handle(T command) throws Exception;
}
