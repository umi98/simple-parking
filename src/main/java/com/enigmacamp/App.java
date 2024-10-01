package com.enigmacamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    HashMap<String, Vehicle> parking = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void play() {
        int menu = 0;
        System.out.println("PARKING");
        System.out.print("Enter number of slot first: ");
        int size = sc.nextInt();
        sc.nextLine();
        createParking(size);
        while (menu != 10) {
            menu();
            System.out.print("Your choice: ");
            menu = sc.nextInt();
            sc.nextLine();
            chooseMenu(menu);
        }
    }

    public void menu() {
        System.out.println("MENU");
        System.out.println("1. Allocate Parking");
        System.out.println("2. Leave Parking");
        System.out.println("3. Status");
        System.out.println("4. Number of motor");
        System.out.println("5. Number of car");
        System.out.println("6. Vehicle with even registration number");
        System.out.println("7. Vehicle with odd registration number");
        System.out.println("8. Vehicle with certain colour");
        System.out.println("9. Check location with registration number");
        System.out.println("10. Exit");
    }

    public void chooseMenu(int choice) {
        if (choice == 1) {
            initVehicle();
        } else if (choice == 2) {
            leave(1);
        } else if (choice == 3) {
            status();
        } else if (choice == 4) {
            countTypeOfVehicle("motor");
        } else if (choice == 5) {
            countTypeOfVehicle("mobil");
        } else if (choice == 6) {
            registerNumberEven();
        } else if (choice == 7) {
            registerNumberOdd();
        } else if (choice == 8) {
            vehicleColour();
        } else if (choice == 9) {
            findByRegistrationNum();
        } else if (choice == 10) {
            System.out.println("exiting program ...");
//            System.exit(0);
        } else {
            System.out.println("invalid choice");
        }
    }

    public void createParking(int size) {
        for (int i = 0; i < size; i++) {
            parking.put(String.valueOf(i), new Vehicle());
        }
        System.out.println("Allocated " + size + " parking slots.");
    }

    public void initVehicle() {
        int num = 0;
        for (Vehicle vehicle : parking.values()) {
            if (vehicle.getRegistrationNum() == null){
                System.out.print("Registration number: ");
                String registrationNum = sc.nextLine();
                System.out.print("Type of vehicle: ");
                String type = sc.nextLine();
                System.out.print("Vehicle colour: ");
                String colour = sc.nextLine();

                Vehicle currentVehicle = new Vehicle(
                        registrationNum,
                        type,
                        colour
                );
                parking.put(String.valueOf(num), currentVehicle);
                System.out.println("Allocated to slot no." + (num+1));
                break;
            } else {
                System.out.println("Parking full");
            }
            num++;
        }
    }

    public void status() {
        int num = 1;
        for (Vehicle vehicle : parking.values()) {
            System.out.println(num++);
            System.out.println(vehicle.getRegistrationNum());
            System.out.println(vehicle.getType());
            System.out.println(vehicle.getColour());
            System.out.println("-".repeat(100));
        }
    }

    public void leave(int num) {
        System.out.print("Emptied slot: ");
        int slot = sc.nextInt();
        slot -= 1;
        sc.nextLine();
        parking.put(String.valueOf(slot), new Vehicle());
    }

    public void countTypeOfVehicle(String type) {
        int count = 0;
        for (Vehicle vehicle : parking.values()) {
            if (vehicle.getType().equals(type.toLowerCase())) {
                count++;
            }
        }
        System.out.println("Number of " + type + ": " + count);
    }

    public void registerNumberOdd() {
        List<String> numberList = new ArrayList<>();
        for (Vehicle vehicle : parking.values()) {
            int getNumber = Integer.parseInt(vehicle.getRegistrationNum().replaceAll("[^0-9]",""));
            if (getNumber%2!=0) {
                numberList.add(vehicle.getRegistrationNum());
            }
        }
        if (!numberList.isEmpty()) numberList.forEach(System.out::println);
        else System.out.println("Not exist");
    }

    public void registerNumberEven() {
        List<String> numberList = new ArrayList<>();
        for (Vehicle vehicle : parking.values()) {
            int getNumber = Integer.parseInt(vehicle.getRegistrationNum().replaceAll("[^0-9]",""));
            if (getNumber%2==0) {
                numberList.add(vehicle.getRegistrationNum());
            }
        }
        if (!numberList.isEmpty()) numberList.forEach(System.out::println);
        else System.out.println("Not exist");
    }

    public void vehicleColour() {
        System.out.print("Enter colour: ");
        String colour = sc.nextLine();
        List<Integer> numberList = new ArrayList<>();
        int num = 0;
        for (Vehicle vehicle : parking.values()) {
            if (vehicle.getColour().equals(colour.toLowerCase())) {
                numberList.add(num + 1);
            }
            num++;
        }
//        for (int i = 0; i < parking.size(); i++) {
//            if (parking.get(i).getColour().equals(colour)) {
//                numberList.add(i);
//            }
//        }
        System.out.println("Vehicle with " + colour + ": " +numberList);
    }

    public void findByRegistrationNum() {
        System.out.print("Enter registration number: ");
        String vehicleNum = sc.nextLine();
        int num = 0;
        for (Vehicle vehicle : parking.values()) {
            if (vehicle.getRegistrationNum().equals(vehicleNum)) {
                num+=1;
                break;
            }
            num++;
        }
        System.out.println( num !=0 ? num : "Not Found");
    }
}
