package com.example.demo.core.am;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public interface IAmMessageBase {
    String id();
    String name();
    String subject();
    byte[] body();
    Date sentAt();
    Map<String, Objects> metadata();
}
