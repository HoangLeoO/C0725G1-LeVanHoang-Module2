package repository.person;

import entity.person.Customer;
import util.ReadAndWriterFile;
import validate.ValidatePerson;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String PATH_FILE = "src/data/customer.csv";


    @Override
    public List<Customer> findAll() {
        List<String> stringList = ReadAndWriterFile.readFile(PATH_FILE);
        List<Customer> customerList = new ArrayList<>();
        try {
            for (String string : stringList) {
                Customer customer = Customer.fromCSV(string);
                try {
                    if (!ValidatePerson.checkCodeCustomer(customer.getCode())) {
                        throw new Exception();
                    }
                    customerList.add(customer);
                } catch (Exception e) {
                    System.out.println(" Lỗi đọc file -> Mã khách hàng không đúng định dạng");
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println(" Lỗi đọc file -> Ngày sinh không đúng định dạng! ");
        } catch (NumberFormatException e) {
            System.out.println(" Lỗi đọc file -> Lương bị sai số!");
        } catch (IllegalArgumentException e) {
            System.out.println(" Lỗi đọc file -> Trình độ và chức vụ không có trong enum!");
        } catch (Exception e) {
            System.out.println(" Lỗi đoc file ! ");
            e.printStackTrace();
        }

        return customerList;

    }

    @Override
    public List<Customer> findFullName(String fullName) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : findAll()) {
            if (customer.getFullName().equalsIgnoreCase(fullName)) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public Customer findCode(String code) {
        List<Customer> customerList = findAll();
        for (Customer customer : customerList) {
            if (customer.getCode().equals(code)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean add(Customer object) {
        if (object == null) return false;
        if (findCode(object.getCode()) != null) {
            return false;
        }
        List<String> stringList = new ArrayList<>();
        stringList.add(object.toCSV());
        ReadAndWriterFile.writerFile(PATH_FILE, stringList, true);
        return true;
    }

    @Override
    public void edit(Customer object) {
        List<Customer> customerList = findAll();
        for (Customer customer : customerList) {
            if (customer.getCode().equals(object.getCode())) {
                customer.updateFrom(object);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.toCSV());
        }
        ReadAndWriterFile.writerFile(PATH_FILE, stringList);
    }

    @Override
    public boolean deleteByCode(String code) {
        if (code != null) {
            List<Customer> customerList = findAll();
            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getCode().equals(code)) {
                    customerList.remove(i);
                    break;
                }
            }
            List<String> stringList = new ArrayList<>();
            for (Customer customer : customerList) {
                stringList.add(customer.toCSV());
            }
            ReadAndWriterFile.writerFile(PATH_FILE, stringList);
            return true;
        } else {
            return false;
        }

    }
}
