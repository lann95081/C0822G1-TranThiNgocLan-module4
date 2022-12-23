package com.example.validation_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;

    @NotBlank(message = "Không được để trống.")
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu 5 kí tự, tối đa 45 kí tự.")
    private String firstName;

    @NotBlank(message = "Không được để trống.")
    @Size(min = 5, max = 45, message = "Tên có độ dài tối thiểu 5 kí tự, tối đa 45 kí tự.")
    private String lastName;

    @NotBlank(message = "SĐT không được bỏ trống")
    @Pattern(regexp = "^0\\d{9}$", message = "SĐT phải có 10 số, và bắt đầu bằng số 0.")
    private String phoneNumber;

    @NotBlank(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18.")
    private String age;

    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Email phải đúng định dạng.")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
    }
}
