package sykros.cloud.edacore.internal.am.command;

import sykros.cloud.edacore.internal.ddd.Command;

public interface CommandPublisher
{
    void Publish(String topic, Command command) throws Exception;
}
