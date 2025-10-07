package repository;

import entity.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private static final List<Contract> listContract = new ArrayList<>();

    @Override
    public Contract findCode(String code) {
        for (Contract contract : listContract) {
            if (contract.getContractNumber().equals(code)) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public List<Contract> findAll() {
        return listContract;
    }

    @Override
    public boolean add(Contract object) {
        return listContract.add(object);
    }

    @Override
    public void edit(Contract object) {
        for (Contract contract : listContract) {
            if (contract.getContractNumber().equals(object.getContractNumber())) {
                contract.setBookingCode(object.getBookingCode());
                contract.setDeposit(object.getDeposit());
                contract.setTotalPayment(object.getTotalPayment());
            }
        }
    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }
}
