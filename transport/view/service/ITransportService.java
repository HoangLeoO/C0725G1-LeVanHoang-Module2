package transport.view.service;


import java.util.List;

public interface ITransportService<T,ID> {

    List<T> findAllTransport();
    T findByLicensePlate(ID licensePlate);
    void addTransport(T object);
    void editTransport(T object);
    void deleteTransport(ID licensePlate);
}
