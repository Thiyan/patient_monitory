package yanmakes.patient_iot.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import yanmakes.patient_iot.exception.ExStatus;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CusResponse<T> {

    private String statusCode;
    private String statusDescription;
    private T content;

    public CusResponse(){
        this.statusCode= ExStatus.ERROR.getStatusCode();
        this.statusDescription=ExStatus.ERROR.getStatusDescription();

    }

    public CusResponse(String statusCode,String statusDescription){
        this.statusCode=statusCode;
        this.statusDescription=statusDescription;

    }

    public CusResponse(ExStatus agStatus) {
        this.statusCode = agStatus.getStatusCode();
        this.statusDescription = agStatus.getStatusDescription();
    }

    public CusResponse(T content) {
        this.statusCode = ExStatus.SUCCESS.getStatusCode();
        this.statusDescription = ExStatus.SUCCESS.getStatusDescription();
        this.content=content;
    }

    public CusResponse(String s) {
        this.statusCode = ExStatus.SUCCESS.getStatusCode();
        this.statusDescription = ExStatus.SUCCESS.getStatusDescription();
        this.content=null;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean hasContent(){
        return this.content!=null;
    }
}
