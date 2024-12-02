package sykros.cloud.edacore.internal.cqs;

import sykros.cloud.edacore.internal.ddd.Command;

public interface CommandHandler<P, C extends Command> {
    P HandleCommand(C cmd) throws Exception;
}
