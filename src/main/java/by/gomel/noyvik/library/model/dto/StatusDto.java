package by.gomel.noyvik.library.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "usersDto")
@ToString(exclude = "usersDto")
public class StatusDto {

    private Long id;
    private String status;

    private Set<UserDto> usersDto = new HashSet<>();

    public StatusDto() {
    }

    public void addUser(UserDto userDto) {
        usersDto.add(userDto);
        userDto.setStatusDto(this);
    }

    public void removeUser(UserDto userDto) {
        usersDto.remove(userDto);
        userDto.setStatusDto(null);
    }




}
