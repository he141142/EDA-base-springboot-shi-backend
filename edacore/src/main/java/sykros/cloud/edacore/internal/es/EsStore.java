package sykros.cloud.edacore.internal.es;

public interface EsStore <T extends EsStoreEntity> {
    void Save(T entity) throws Exception;
    T Load(T entity) throws Exception;
}
