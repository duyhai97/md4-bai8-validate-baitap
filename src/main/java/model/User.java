package model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 30, message = "Tu 5 den 30 ki tu")
    private String firstName;

    @Size(min = 5, max = 30, message = "Tu 5 den 30 ki tu")
    private String lastName;

    @Pattern(regexp = "^[A-Za-z0-9_.]{6,32}@([a-zA-Z0-9]{2,12})(.[a-zA-Z]{2,12})+$", message = "khong hop le")
    private String email;


    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{7}", message = "khong hop le")
    private String phoneNumber;

    @Min(value = 18,message = "tu 18 tuoi tro len")
    private int age;


    public User(Long id, @Size(min = 5, max = 30) String firstName, @Size(min = 5, max = 30) String lastName, @Pattern(regexp = "^[A-Za-z0-9_.]{6,32}@([a-zA-Z0-9]{2,12})(.[a-zA-Z]{2,12})+$") String email, @Pattern(regexp = "\\d{3}-\\d{2}-\\d{7}") String phoneNumber, @Min(18) int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public User() {
    }

    public User(@Size(min = 5, max = 30) String firstName, @Size(min = 5, max = 30) String lastName, @Pattern(regexp = "^[A-Za-z0-9_.]{6,32}@([a-zA-Z0-9]{2,12})(.[a-zA-Z]{2,12})+$") String email, @Pattern(regexp = "\\d{3}-\\d{2}-\\d{7}") String phoneNumber, @Min(18) int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
