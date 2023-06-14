package com.BlogAppApis.payload;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Name must be minimum of 4 charactors or above !!")
    private String name;

    @Email(message = "Email address are not valid !!")
    @NotEmpty(message = "Email is required !!")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 8, message = "Password must be 4-8 charactors !!")
    // @Pattern(regexp = ) //you are create your password pattern in your program...
    private String password;

    @NotEmpty
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
