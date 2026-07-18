import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    CargoSystem cargoSystem = new CargoSystem();

    public void menu1() {
        System.out.println("************** SUPER CARGO ************** ");

        System.out.println("1- Create New Cargo ");
        System.out.println("2- List All Cargos ");
        System.out.println("3- Track Cargo by Tracking Number ");
        System.out.println("4- Update Cargo Situation ");
        System.out.println("5- Track Cargo by Customer Id");
        System.out.println("6- Add New Vehicle");
        System.out.println("7- Check Vehicle");
        System.out.println("8- Assign Vehicle");
        System.out.println("9- List of Vehicles ");
        System.out.println("10- Remove Vehicle");
        System.out.println("11- Remove Cargo");
        System.out.println("12- List of Cargos In The Vehicle");
        System.out.println("0- Quit");
        System.out.println("Please Select a  Option :");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                createCargo();
                break;
            case 2:
                listCargo();
                break;
            case 3:
                trackbyTrackingNumber();
                break;
            case 4:
                updateSituation();
                break;
            case 5:
                trackbyId();
                break;
            case 6:
                addVehicle();
                break;
            case 7:
                checkVehicle();
                break;
            case 8:
                assignVehicle();
                break;
            case 9:
                listvehicle();
                break;
            case 10:
                removeVehicle();
                break;
            case 11:
                removeCargo();
                break;
            case 12:
                listofCargosInVehicle();
                break;
            case 0:
                System.out.println("Good Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Input");
                break;


        }



    }

    public void createCargo() {
        System.out.println("Customer Name : ");
        String name = readNonBlank(sc);
        System.out.println("Phone : ");
        String phone = readNonBlank(sc);
        System.out.println("Id :");
        String Id = readNonBlank(sc);
        Customer customer = new Customer(name, phone, Id);
        System.out.println("Track Number : ");
        String trackNo = readNonBlank(sc);
        System.out.println("Recipient Name");
        String recipient = readNonBlank(sc);
        System.out.println("Recipient Adress : ");
        String adress = readNonBlank(sc);
        System.out.println("Weight : ");
        double weight = readNonBlankDouble(sc);


        Cargo cargo = new Cargo(trackNo, recipient, adress, customer, weight, Situation.PREPARING);
        cargoSystem.addCargo(cargo);


    }

    public void listCargo() {
        cargoSystem.listofCargos();

    }

    public void listofCargosInVehicle() {
        System.out.println("Write the Plate");
        String plate = readNonBlank(sc);

        cargoSystem.listCargosInCar(plate);

    }

    public void assignVehicle() {
        System.out.println("Write Vehicle Plate :");
        String plate = sc.nextLine();
        System.out.println("Write Tracking Number :");
        String track = sc.nextLine();
        cargoSystem.assignCar(plate, track);

    }

    public void removeVehicle() {
        System.out.println("Write Plate : ");
        String plate = sc.nextLine();
        cargoSystem.removeCar(plate);


    }

    public void removeCargo() {
        System.out.println("Write Tracking Number : ");
        String trackNo = sc.nextLine();
        cargoSystem.deleteCargo(trackNo);


    }

    public void addVehicle() {
        System.out.println("Write Plate ");
        String plate = sc.nextLine();
        System.out.println("Write Driver Name ");
        String driver = sc.nextLine();
        Car car = new Car(plate, driver);
        cargoSystem.addCar(car);


    }

    public void updateSituation() {
        System.out.println("Write Tracking Number : ");
        String trackNo = sc.nextLine();

        System.out.println("Select New Situation :");
        System.out.println("1- PREPARING");
        System.out.println("2- SHIPPED");
        System.out.println("3- DELIVERED");
        System.out.println("4- CANCELLED");
        System.out.println("5- ON_THE_WAY");
        System.out.println("0- Quit");
        int sec = sc.nextInt();
        switch (sec) {
            case 1:
                cargoSystem.updateSt(trackNo, Situation.PREPARING);
                break;
            case 2:
                cargoSystem.updateSt(trackNo, Situation.SHIPPED);
                break;
            case 3:
                cargoSystem.updateSt(trackNo, Situation.DELIVERED);
                break;
            case 4:
                cargoSystem.updateSt(trackNo, Situation.CANCELLED);
                break;
            case 5:
                cargoSystem.updateSt(trackNo, Situation.ON_THE_WAY);
                break;
            case 0:
                System.out.println("Good Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;

        }

    }

    public void listvehicle() {
        cargoSystem.listofCars();
    }

    public void checkVehicle() {
        System.out.println("Write Vehicle Plate :");
        String plate = sc.nextLine();
        cargoSystem.checkCar(plate);
    }

    public void trackbyTrackingNumber() {
        System.out.println("Write Tracking Number : ");
        String trackNo = sc.nextLine();
        cargoSystem.findCargobyTracking(trackNo);

    }

    public void trackbyId() {
        System.out.println("Write Id Number : ");
        String id = sc.nextLine();
        cargoSystem.findCargobyId(id);


    }

    public static String readNonBlank(Scanner sc) {
        while (true) {

            String value = sc.nextLine().trim();
            if (!value.isBlank()) {
                return value;
            }

            System.out.println("Please Enter Valid Value");
        }


    }

    public static double readNonBlankDouble(Scanner sc) {
        while (true) {

            String input = sc.nextLine().trim().replace(',', '.');

            if (input.isBlank()) {
                System.out.println("Please Enter Valid Value");
                continue;
            }

            try {
                double value = Double.parseDouble(input);

                if (value <= 0) {
                    System.out.println("Please Enter Valid Value");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please Enter Valid Value");
            }
        }
    }

}
