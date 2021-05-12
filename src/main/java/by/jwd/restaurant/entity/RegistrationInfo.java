package by.jwd.restaurant.entity;

public class RegistrationInfo extends User{
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
    private String repeatPassword;
    private Integer roleId;

    public RegistrationInfo() {
    }

    public RegistrationInfo(String name, String surname, String phone, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public RegistrationInfo(String name, String surname, String phone, String email, String password, String repeatPassword) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public RegistrationInfo(String name, String surname, String phone, String email, String password, Integer roleId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationInfo)) return false;

        RegistrationInfo that = (RegistrationInfo) o;

        if (!name.equals(that.name)) return false;
        if (!surname.equals(that.surname)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!email.equals(that.email)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
