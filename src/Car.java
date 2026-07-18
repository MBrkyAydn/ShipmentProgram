import java.util.ArrayList;

public class Car {
    private String plate, driver;
    ArrayList<Cargo> cargosInCar;

    public Car(String plate, String driver) {
        this.plate = plate;
        this.driver = driver;
        this.cargosInCar = new ArrayList<>();

    }

    public void addCargo(Cargo cargo) {
        boolean alreadyAdded = cargosInCar.stream().anyMatch(c -> c.getTrackingNo().equals(cargo.getTrackingNo()));

        if (alreadyAdded) {
            System.out.println("Cargo already exists  " + cargo.getTrackingNo());
            return;
        }
        cargosInCar.add(cargo);
        System.out.println("Cargo Shipped the vehicle. " + cargo.getTrackingNo());


    }

    public boolean containsCargo(String trackingNo) {

        return cargosInCar.stream().anyMatch(c -> c.getTrackingNo().equals(trackingNo));


    }
    public boolean removeCargo(String trackingNo) {
        return cargosInCar.removeIf(cargo ->
                cargo.getTrackingNo().equals(trackingNo));
    }



    public void listCargosInCar() {
        if (!cargosInCar.isEmpty()) {
            for (Cargo c : cargosInCar) {
                System.out.println(c.getTrackingNo() + " " + c.getAdress() + " " + c.getDelName());

            }
        } else {
            System.out.println("There is no cargos");

        }

    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public ArrayList<Cargo> getCargosInCar() {
        return cargosInCar;
    }

    public void setCargosInCar(ArrayList<Cargo> cargosInCar) {
        this.cargosInCar = cargosInCar;
    }
}
