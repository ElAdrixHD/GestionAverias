package es.adrianmmudarra.gestionaverias.data.db.model;

import java.util.Objects;

public class User {
    private int id_user;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private KindUser kindUser = KindUser.NORMAL_USER;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public KindUser getKindUser() {
        return kindUser;
    }

    public void setKindUser(KindUser kindUser) {
        this.kindUser = kindUser;
    }

    public User(int id_user, String name, String email, String password, String birthday, KindUser kindUser) {
        this.id_user = id_user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.kindUser = kindUser;
    }

    public User(String name, String email, String password, String birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(password, email);
    }

}

