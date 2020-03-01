package yanmakes.patient_iot.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleMqttCallBack implements MqttCallback {
    private MqttClient client;
    String N,S;


    public void connectionLost(Throwable throwable) {

        System.out.println(throwable + "Connection to MQTT broker lost!");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            subscribe();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        String message = new String(mqttMessage.getPayload()); //Pick the payload String
        System.out.println(message);

        String[] devices=message.split(";");



    }


    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }


//    @PostConstruct
    public void subscribe() throws MqttException {

        System.out.println("== START SUBSCRIBER ==");

        //client=new MqttClient("tcp://localhost:1883", "Thiyan");
        client = new MqttClient("tcp://mqtt.senzmate.com:1883", "atno14");
        client.connect();
        client.subscribe("SenzMate/D2S/incubator-A");

        client.setCallback(this);
    }
}


