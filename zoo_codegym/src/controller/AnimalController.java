package controller;

import entity.Animal;
import service.AnimalService;
import service.IAnimalService;
import view.AnimalView;

import java.util.List;
import java.util.Scanner;

public class AnimalController {
    private static IAnimalService<Animal> animalService = new AnimalService();

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println(" Menu chức năng");
            System.out.println(" 1. Thêm động vật");
            System.out.println(" 2. Hiển thị danh sách động vật theo loại");
            System.out.println(" 3. Xóa động vật bằng mã số");
            System.out.println(" 4. Tìm kiếm động vật gần đúng tên");
            System.out.println(" 5. Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    animalService.add(AnimalView.showFormAdd());
                }
                case "2" -> {
                    AnimalView.showAll(animalService.findAll());
                }
                case "3" -> {
                    System.out.println(" Nhập mã động vật bạn muốn xóa!");
                    String code = scanner.nextLine();
                    if(AnimalView.showFormDelete(animalService.findByCode(code))){
                        animalService.deleteByCode(code);
                    }
                }
                case "4" -> {
                    System.out.println(" Nhập tên động vật bạn muốn tìm!");
                    String name = scanner.nextLine();
                    AnimalView.showListSearch(animalService.findByName(name));
                }
                default -> {
                    running = false;
                }
            }
        }
    }

}
