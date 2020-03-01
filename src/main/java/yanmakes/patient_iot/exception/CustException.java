package yanmakes.patient_iot.exception;

public class CustException extends Exception {

    private static final long serialVersionUID = 1L;

    private ExStatus status;

    public CustException(ExStatus status){

        super(status.getStatusDescription());
        this.status=status;
    }

    public ExStatus getStatus() {
        return status;
    }

    public void setStatus(ExStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AGException{" +
                "status=" + status +
                '}';
    }
}
