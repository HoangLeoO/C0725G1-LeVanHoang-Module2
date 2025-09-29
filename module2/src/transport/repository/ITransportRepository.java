package transport.repository;



import java.util.List;

public interface ITransportRepository<T,ID> {
    List<T> findAllTransport();
    T findByLicensePlate(ID licensePlate);
    void addTransport(T object);
    void editTransport(T object);
    void deleteTransport(ID licensePlate);
}
