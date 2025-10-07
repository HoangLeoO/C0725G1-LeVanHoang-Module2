package controller;

import entity.Contract;
import service.ContractService;
import service.IContractService;

import java.util.List;

public class ContractController {
    private static IContractService contractService = new ContractService();

    public static boolean add(Contract contract) {
        return contractService.add(contract);
    }

    public static List<Contract> showList() {
        return contractService.findAll();
    }

    public static Contract getContract(String code) {
        return contractService.findCode(code);
    }

    public static void editContract(Contract contract) {
        contractService.edit(contract);
    }
}
