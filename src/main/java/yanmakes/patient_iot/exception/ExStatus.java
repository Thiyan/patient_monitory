package yanmakes.patient_iot.exception;

public enum ExStatus {

    SUCCESS("S1000", "Success"),

    ERROR("E1000", "Unknown error occurred in operation"),
    DB_ERROR("E1002", "Unknown error occurred in database operation"),
    NO_ENTRY_FOUND("E1003", "Empty results from database"),
    MISSING_REQUIRED_PARAMS("E1004", "One or more required parameters are missing"),
    EMPTY_FILE("E1005","Uploaded file is empty"),
    PARTIALLY_STORED1("E1006","Images are parlially uploaded.Unknown error occurred in database operation"),
    PARTIALLY_STORED2("E1007","Images are parlially uploaded.One or more required parameters are missing"),
    EMAIL_ALREDY_EXIST("E1008","The email you entered alredy has an account "),
    USER_NOT_FOUND("E1009","The email id is not registered, must create a account" ),
    AWS_ERROR("E1010","Some error occurred with AWS server" ),
    FILE_CONVERTION_ERROR("E1011","Unknown error occurred while converting a file" ),
    DEVICE_CONFIGURATION_ERROR("E1012","Unknown error occurred while configuring the device" );

    private final String statusCode;
    private final String statusDescription;


    ExStatus(String statusCode, String successDescription) {
        this.statusCode = statusCode;
        this.statusDescription = successDescription;
    }

    public static ExStatus getCCStatus(String statusCode) {
        for (ExStatus ccStatus : ExStatus.values()) {
            if (ccStatus.statusCode.equals(statusCode)) {
                return ccStatus;
            }
        }
        return SUCCESS;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public boolean isSuccess() {
        return this.statusCode.equals(ExStatus.SUCCESS.statusCode);
    }
}
