package ITCompany.Entity;

import java.util.Objects;

public class Guest {

    private int id;
    private String login;
    private String password;
    private String name;
    private String email;
    private String role;

    public Guest(int anID, String aLogin, String aPassword, String aName, String anEmail, String arole) {
        id = anID;
        login =aLogin;
        password = aPassword;
        name = aName;
        email = anEmail;
        role = arole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return id == guest.id &&
                Objects.equals(login, guest.login) &&
                Objects.equals(password, guest.password) &&
                Objects.equals(name, guest.name) &&
                Objects.equals(email, guest.email) &&
                Objects.equals(role, guest.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, email, role);
    }

    @Override
    public String toString() {
        return "Guest (" +
                " id = " + id +
                ", login = '" + login + '\'' +
                ", password = '" + password + '\'' +
                ", name = '" + name + '\'' +
                ", email = '" + email + '\'' +
                ", role = '" + role + '\'' +
                ')';
    }
}
