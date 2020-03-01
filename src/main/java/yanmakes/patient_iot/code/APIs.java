package yanmakes.patient_iot.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yanmakes.patient_iot.utils.CusResponse;

@RestController
@CrossOrigin(origins = "*")
public class APIs {

    @Autowired
    private DeviceRepository repo;

    @GetMapping("/")
    public CusResponse getDevice(){

        return new CusResponse(repo.findAll());

    }

    @GetMapping("/add")
    public CusResponse addDevice(){

        return new CusResponse(repo.save(new Device("001",90.8,false,false,"Kitchen","House")));

    }

}
