package yanmakes.patient_iot.code;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "device")
public class Device {

    @Id
    private String number;
    private double heartRate;
    private boolean sleep;
    private boolean fall;
    private String indoor;
    private String location;



    public Device() {
    }

    public Device(String number, double heartRate, boolean sleep, boolean fall, String indoor, String location) {
        this.number = number;
        this.heartRate = heartRate;
        this.sleep = sleep;
        this.fall = fall;
        this.indoor = indoor;
        this.location = location;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isFall() {
        return fall;
    }

    public void setFall(boolean fall) {
        this.fall = fall;
    }

    public String getIndoor() {
        return indoor;
    }

    public void setIndoor(String indoor) {
        this.indoor = indoor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Device{" +
                "number=" + number +
                ", heartRate='" + heartRate + '\'' +
                ", sleep=" + sleep +
                ", fall=" + fall +
                ", indoor='" + indoor + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
