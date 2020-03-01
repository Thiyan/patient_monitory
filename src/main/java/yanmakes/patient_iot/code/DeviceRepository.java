package yanmakes.patient_iot.code;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {

    Device findByNumber(String number);
}
