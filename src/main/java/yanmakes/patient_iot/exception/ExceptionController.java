package yanmakes.patient_iot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import yanmakes.patient_iot.utils.CusResponse;


//@RestController
@ControllerAdvice
class ExceptionController {

    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionController.class);


    @ResponseBody
    @ExceptionHandler(value = CustException.class)
    public CusResponse customExceptionHandler(CustException ex){
        LOGGER.error("In Exception handler");
//        ex.printStackTrace();
        CusResponse response=new CusResponse(ex.getStatus());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CustException ExceptionHandler(Exception ex){
        System.out.println("In Exception handler");
//        ex.printStackTrace();
        CustException response=new CustException(ExStatus.ERROR);
        return response;
    }
}
