package com.mypro.beans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    String password;
    String mobile;
    String nickname;
    String avatar;
    String token;
}
