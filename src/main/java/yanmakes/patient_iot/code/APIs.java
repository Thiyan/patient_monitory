package yanmakes.patient_iot.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yanmakes.patient_iot.exception.CustException;
import yanmakes.patient_iot.exception.ExStatus;
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

    @GetMapping("/device")
    public CusResponse oneDevice(@RequestParam String number) throws CustException {

        Device device=repo.findByNumber(number);

        if (device==null)
            throw  new CustException(ExStatus.NO_ENTRY_FOUND);

        return new CusResponse(device);

    }

}
