package by.gomel.noyvik.library.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "userDto")
@ToString(exclude = "userDto")

public class AuthenticateDto {

    private Long id;
    private String login;
    private String password;
    private LocalDate unlockedDate = LocalDate.now();

    private UserDto userDto;

    public AuthenticateDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void addUser(UserDto userDto) {
        this.userDto = userDto;
        userDto.setAuthenticateDto(this);
    }

    public void removeUser() {
        userDto.setAuthenticateDto(null);
        this.setUserDto(null);

    }


}
