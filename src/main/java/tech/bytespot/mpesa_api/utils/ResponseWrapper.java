/**
 * @author Eli Muraya
 */
package tech.bytespot.mpesa_api.utils;


import java.io.Serializable;

/**
 * This class is used to standardise the response format for all API responses.
 */
public class ResponseWrapper<T> implements Serializable {

    private int code;
    private boolean status;
    private String message;
    private T data;

    public ResponseWrapper() {
    }

    public ResponseWrapper(int code, boolean status, String message, T data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return " {" +
                "code :" + code +
                ", status :" + status +
                ", message : '" + message + '\'' +
                ", data : " + data +
                '}';
    }
}
