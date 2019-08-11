package org.item.jurisdiction.util;


public class JsonResult {
    private String status;
    private String message;
    private Object data;

    public String getStatus() {
        return this.status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getMessage() {
        return this.message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public Object getData() {
        return this.data;
    }


    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public JsonResult(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}