package es.adrianmmudarra.gestionaverias.data.db.model;

public class Breakdown {
    private int id;
    private String code;
    private String city;
    private String data;
    private String description;

    private int id_user;

    public Breakdown(int id, String code, String city, String data, String description, int id_user) {
        this.id = id;
        this.code = code;
        this.city = city;
        this.data = data;
        this.description = description;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
