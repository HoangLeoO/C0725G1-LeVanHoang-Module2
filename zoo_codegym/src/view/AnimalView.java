package view;

import entity.Animal;
import entity.Bird;
import entity.Carnivore;
import entity.Herbivore;
import util.ValidateAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalView {
    private static final Scanner sc = new Scanner(System.in);


    public static void showAll(List<Animal> animals) {
        List<Carnivore> carnivores = new ArrayList<>();
        List<Herbivore> herbivores = new ArrayList<>();
        List<Bird> birds = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal instanceof Carnivore) {
                carnivores.add((Carnivore) animal);
            }
            if (animal instanceof Herbivore) {
                herbivores.add((Herbivore) animal);
            }
            if (animal instanceof Bird) {
                birds.add((Bird) animal);
            }
        }

        System.out.println(" Danh sách động vật ăn thịt");
        for (Carnivore carnivore : carnivores) {
            System.out.println(carnivore);
        }
        System.out.println(" Danh sách động vật ăn cỏ");
        for (Herbivore herbivore : herbivores) {
            System.out.println(herbivore);
        }
        System.out.println(" Danh sách chim");
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }


    public static Animal showFormAdd() {
        boolean running = true;
        while (running) {
            System.out.println(" Chức năng thêm động vật");
            System.out.println(" 1. Thêm động vật ăn thịt");
            System.out.println(" 2. Thêm động vật ăn cỏ");
            System.out.println(" 3. Thêm chim");
            System.out.println(" 4. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    return showFormAddCarnivore();
                }
                case "2" -> {
                    return showFormAddHerbivore();
                }
                case "3" -> {
                    return showFormAddBird();
                }
                default -> {
                    running = false;
                }
            }
        }
        return null;
    }

    public static Animal showFormAddCarnivore() {
        System.out.print("Nhập mã (C-XXXX): ");
        String code = inputId();
        String name = inputName();
        int year = inputBirthYear();
        String cage = inputCage();
        String favoritePrey = inputFavoriteMeat();
        return (Animal) new Carnivore(code, name, year, cage, favoritePrey);
    }

    public static Animal showFormAddHerbivore() {
        System.out.print("Nhập mã (H-XXXX): ");
        String code = inputId();
        String name = inputName();
        int year = inputBirthYear();
        String cage = inputCage();
        String favoritePrey = inputFavoritePlant();
        return (Animal) new Herbivore(code, name, year, cage, favoritePrey);
    }

    public static Animal showFormAddBird() {
        System.out.print("Nhập mã (B-XXXX): ");
        String code = inputId();
        String name = inputName();
        int year = inputBirthYear();
        String cage = inputCage();
        double wingSpan = inputWingSpan();
        boolean canSpeak = inputCanTalk();
        return (Animal) new Bird(code, name, year, cage, wingSpan, canSpeak);
    }

    public static boolean showFormDelete(Animal animal) {
        if (animal == null){
            System.out.println(" Không tìm thấy mã!");
            return false;
        }
        System.out.println(" Bạn có muốn xóa : " + " động vật : " + animal.getName() + " có mã : " + animal.getId());
        System.out.print("(true/false): ");
        return Boolean.parseBoolean(sc.nextLine());
    }

    public static void showListSearch(List<Animal> animals) {
        System.out.println(" Danh sách tìm kiếm!");
        if (animals.isEmpty()){
            System.out.println(" Không tìm thấy!");
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static String inputId() {
        String code;
        do {
            code = sc.nextLine();
            if (!ValidateAnimal.checkCode(code)){
                System.out.println(" Sai định dạng : C|H|B-(1 đén 4 chữ số)");
            }
        } while (!ValidateAnimal.checkCode(code));
        return code;
    }

    public static String inputName() {
        String name;
        do {
            System.out.println(" Nhập tên động vật : ");
            name = sc.nextLine();
            if (!ValidateAnimal.checkName(name)){
                System.out.println(" Nhập sai định dạng tên (tên bắt đàu với chữ cái in hoa)!");
            }
        } while (!ValidateAnimal.checkName(name));
        return name;
    }

    public static int inputBirthYear() {
        String year;
        do {
            System.out.println(" Nhập năm sinh: ");
            year = sc.nextLine();
            if (!ValidateAnimal.checkYear(year)){
                System.out.println(" Nhập sai định dạng năm (XXXX)!");
            }
        } while (!ValidateAnimal.checkYear(year));
        return Integer.parseInt(year);
    }

    public static String inputCage() {
        System.out.print("Nhập chuồng (gõ 'riêng' nếu là chuồng riêng biệt): ");
        return sc.nextLine();
    }

    public static String inputFavoriteMeat() {
        System.out.print("Nhập loại mồi ưa thích: ");
        return sc.nextLine();
    }

    public static String inputFavoritePlant() {
        System.out.print("Nhập loại cỏ/rau ưa thích: ");
        return sc.nextLine();
    }

    public static double inputWingSpan() {
        String wingSpan;
        do {
            System.out.print("Nhập độ dài sải cánh: ");
            wingSpan = sc.nextLine();

            if (!ValidateAnimal.isDouble(wingSpan)) {
                System.out.println("Nhập sai định dạng (chỉ nhập số)!");
                continue;
            }

            double ws = Double.parseDouble(wingSpan.replace(",", "."));

            if (ws <= 0 || ws >= 10) {
                System.out.println("Giá trị phải lớn hơn 0 và nhỏ hơn 10!");
                continue;
            }

            return ws;

        } while (true);
    }

    public static boolean inputCanTalk() {
        String canTalk;
        do {
            System.out.print("Có biết nói không(Y or N) hoặc(y or n)?: ");
            canTalk = sc.nextLine();

            if (!ValidateAnimal.checkCanTalk(canTalk)) {
                System.out.println("Nhập sai định dạng !");
                continue;
            }

            return ValidateAnimal.checkCanTalk(canTalk);

        } while (true);
    }
}
