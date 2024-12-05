package com.example.demo.core.services.reply.pingcosec;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PringCosec {
    public static final String REPLY_NAME = "PingCosec";
    @JsonProperty("server_name")
    public String serverName;
    @JsonProperty("server_version")
    public String serverVersion;
    @JsonProperty("status")
    public String status;
}
