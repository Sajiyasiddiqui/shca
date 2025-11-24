package com.hms.User.dto;
import com.hms.User.constant.Roles;
import com.hms.User.entity.UserEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
      private Long id;
      @NotBlank(message="Name is mandatory")
      private String name;
      @NotBlank(message="Email is mandatory")
      @Email(message="Email should valid")
      private String email;
      @NotBlank(message="password is mandatory")
      private String password;
      private Roles role;

     public UserEntity toEntity()
     {
    	 return new UserEntity(this.id,this.name,this.email,this.password,this.role);
     }
}
