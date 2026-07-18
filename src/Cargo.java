public class Cargo {
    private String trackingNo, delName, adress;
    private Customer customer;
    private double weight;
    Situation situation;

    public Cargo(String trackingNo, String delName, String adress, Customer customer, double weight, Situation situation) {
        this.trackingNo = trackingNo;
        this.delName = delName;
        this.adress = adress;
        this.customer = customer;
        this.weight = weight;
        this.situation = situation;

    }
public String update(){
return "Shıpped by : "+customer.getName()+
        "\t Tracking No : "+this.trackingNo+
        "\t Recipient"+this.delName+
        "\t Adress : "+this.adress+
        "\t Weight : "+this.weight+
        "\t Situation : "+this.situation;
    }
    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getDelName() {
        return delName;
    }

    public void setDelName(String delName) {
        this.delName = delName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
