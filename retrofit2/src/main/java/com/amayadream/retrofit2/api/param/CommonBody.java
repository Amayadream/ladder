package com.amayadream.retrofit2.api.param;

/**
 * @author :  Amayadream
 * @date :  2017.10.31 22:17
 */
public class CommonBody {

    private String id;
    private String message;

    @Override
    public String toString() {
        return "CommonBody{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
