package ru.inno.stc14.entity;

import java.util.Date;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private Date birthDate;
    private String login;
    private String password;
    private String email;
    private String telephone;

    private Person(Builder builder) {
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.telephone = builder.telephone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private Date birthDate;
        private String login;
        private String password;
        private String email;
        private String telephone;

        public Builder() {
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            this.telephone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
