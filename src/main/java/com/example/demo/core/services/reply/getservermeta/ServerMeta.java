package com.example.demo.core.services.reply.getservermeta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerMeta {
    @JsonProperty("server_name")
    String serverName;
    @JsonProperty("server_version")
    String serverVersion;

    @JsonProperty("server_description")
    String serverDescription;

    @JsonProperty("server_ip")
    String serverIp;
}
