package sykros.cloud.edacore.internal.am;

public interface MessageHandler {
    void HandleMessage(IIncomingMessage iIncomingMessage) throws Exception;
}
