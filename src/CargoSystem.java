import java.sql.Driver;
import java.util.*;

public class CargoSystem {
    private HashMap<String, Cargo> cargoMap = new HashMap<>();
    private LinkedList<Cargo> cargoList = new LinkedList<>();
    private HashSet<String> cargoSet = new HashSet<>();
    private HashMap<String, Car> carMap = new HashMap<>();
    private HashMap<String, ArrayList<Cargo>> customerMap = new HashMap<>();
    private HashSet<String> plateSet = new HashSet<>();
    private LinkedList<Car> carList = new LinkedList<>();

    public void addCargo(Cargo cargo) {
        if (cargoSet.contains(cargo.getTrackingNo())) {
            System.out.println("Cargo already exists");
            return;
        }
        cargoMap.put(cargo.getTrackingNo(), cargo);
        cargoList.add(cargo);
        cargoSet.add(cargo.getTrackingNo());


        String customerId = cargo.getCustomer().getId();
        if (!customerMap.containsKey(customerId)) {
            customerMap.put(customerId, new ArrayList<>());
              }
        customerMap.get(customerId).add(cargo);
        System.out.println("Customer " + cargo.getCustomer().getId() + " has been added");
            for (Cargo c : cargoMap.values()) {
                System.out.println(c.update());

            }





    }

    public void deleteCargo(String trackingNo) {
        Cargo cargo = cargoMap.get(trackingNo);

        if (!cargoMap.containsKey(trackingNo)) {
            System.out.println("Cargo not found");
            return;
        }
        cargoMap.remove(trackingNo);
        cargoSet.remove(trackingNo);
        cargoList.remove(cargo);

        for (Car car : carList) {
            car.removeCargo(trackingNo);
        }

        String customerId = cargo.getCustomer().getId();
        ArrayList<Cargo> customerList = customerMap.get(customerId);

        if (!customerMap.containsKey(customerId)) {
            System.out.println("Cargo not found");
            return;
        }
        customerList.remove(cargo);
        System.out.println("Customer " + cargo.getCustomer().getId() + " has been deleted");
        for (Car car : carList) {
            car.removeCargo(trackingNo);
        }

    }

    public void listofCargos() {

        if (cargoList.isEmpty()) {
            System.out.println("No cargos");
            return;
        }
        for (Cargo c : cargoList) {
            System.out.println(c.update());
        }
    }

    public void updateSt(String trackingNo, Situation situation) {
        if (!cargoMap.containsKey(trackingNo)) {
            System.out.println("Cargo not found");
            return;
        }
        Cargo cargo = cargoMap.get(trackingNo);
        cargo.setSituation(situation);
        System.out.println("Situation " + situation + " has been updated");

    }

    public void findCargobyId(String Id) {
        ArrayList<Cargo> customerId = customerMap.get(Id);
        if (customerId.isEmpty() || customerId==null) {
            System.out.println("Not Found");
            return;
        }
        for (Cargo c : customerId) {
            System.out.println(c.update());
        }


    }

    public Cargo findCargobyTracking(String trackingNo) {
        Cargo cargo = cargoMap.get(trackingNo);
        if (!cargoMap.containsKey(trackingNo)) {
            System.out.println("Cargo not found");
            return null;
        }
        System.out.println(cargo.update());
        return cargo;
    }

    public void addCar(Car car) {
        String plate = car.getPlate();
        if (plateSet.contains(plate)) {
            System.out.println("Car already exists");
            return;
        }
        plateSet.add(plate);
        carMap.put(car.getPlate(), car);
        carList.add(car);


        System.out.println("Car has been added  " + plate);


    }

    public void listofCars() {

        if (carList.isEmpty()) {
            System.out.println("No cars");
            return;
        }
        for (Car c : carList) {
            System.out.println("Cars : "+c.getPlate());

        }
    }

    public void assignCar(String plate, String trackingNo) {
        Cargo cargo = cargoMap.get(trackingNo);
        if (!cargoMap.containsKey(trackingNo)) {
            System.out.println("Cargo not found");
            return;
        }
        Car car = carMap.get(plate);
        if (!carMap.containsKey(plate)) {
            System.out.println("Car not found");
            return;
        }

        for (Car assignedCar : carList) {
            if (assignedCar.containsCargo(trackingNo)) {
                if (assignedCar.getPlate().equals(plate)) {
                    System.out.println("Cargo is already in this vehicle");
                } else {
                    System.out.println("Cargo is already assigned to vehicle  " + assignedCar.getPlate());
                }
                return;
            }
        }

        car.addCargo(cargo);
        System.out.println("Cargo has been added to vehicle  " + plate);
        cargo.setSituation(Situation.SHIPPED);
        System.out.println("Situation : " + cargo.getSituation());


    }

    public void listCargosInCar(String plate) {
        Car car = carMap.get(plate);
        if (!carMap.containsKey(plate)) {
            System.out.println("Car not found");
            return;
        }
        System.out.println("List of Cargos In The Car : ");
        car.listCargosInCar();

    }

    public void checkCar(String plate) {
        Car car = carMap.get(plate);
        if (!carMap.containsKey(plate)) {
            System.out.println("Car not found");
            return;
        }
        System.out.println("Car found : " + car.getPlate());


    }
    public void removeCar(String plate) {
        Car car = carMap.remove(plate);
        if (car== null) {System.out.println("Car not found");
            return;


        }
        carList.remove(car);
        plateSet.remove(plate);

        System.out.println("Car has been removed");



    }

}
