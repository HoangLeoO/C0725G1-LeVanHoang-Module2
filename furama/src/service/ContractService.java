package service;

import entity.Contract;
import repository.BookingRepository;
import repository.ContractRepository;
import repository.IBookingRepository;
import repository.IContractRepository;

import java.util.List;

public class ContractService implements IContractService{
    private IContractRepository contractRepository = new ContractRepository();
    @Override
    public Contract findCode(String code) {
        return contractRepository.findCode(code);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public boolean add(Contract object) {
        return contractRepository.add(object) ;
    }

    @Override
    public void edit(Contract object) {
        contractRepository.edit(object);
    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }
}
