package com.mp.onlinestore.response;

public class GeneralResponse {

    protected String successMessage;

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public GeneralResponse(String successMessage) {
        this.successMessage = successMessage;
    }

    public GeneralResponse() {}
}
