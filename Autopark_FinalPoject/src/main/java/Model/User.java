package Model;

import java.util.Objects;

public class User {

    private String userName;
    private String userEmail;
    private String userRole;

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public class Builder {

        private Builder() {}

        public Builder setUserName(String aUserName) {
            userName = aUserName;
            return this;
        }

        public Builder setUserEmail(String anEmail) {
            userEmail = anEmail;
            return this;
        }

        public Builder setUserRole(String aUseRole) {
            userRole = aUseRole;
            return this;
        }

        public User build() {
            return User.this;
        }
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userEmail, userRole);
    }

    @Override
    public String toString() {
        return "User (" +
                " userName = '" + userName + '\'' +
                ", userEmail = '" + userEmail + '\'' +
                ", userRole = '" + userRole + '\'' +
                ')';
    }
}
