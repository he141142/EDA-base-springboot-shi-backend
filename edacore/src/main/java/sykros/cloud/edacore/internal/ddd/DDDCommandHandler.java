package sykros.cloud.edacore.internal.ddd;

public interface DDDCommandHandler <T extends Command> {
    Reply  HandleCommand(T cmd) throws Exception;
}
