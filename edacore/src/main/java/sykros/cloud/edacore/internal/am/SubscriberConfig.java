package sykros.cloud.edacore.internal.am;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

@Getter
@Builder
public class SubscriberConfig {
    List<String> MessageFilters;
    String GroupName;
    Duration AckTimeout;
    String name;
}
