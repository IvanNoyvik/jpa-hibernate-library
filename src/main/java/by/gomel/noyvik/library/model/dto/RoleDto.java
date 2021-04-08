package by.gomel.noyvik.library.model.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "usersDto")
@ToString(exclude = "usersDto")
public class RoleDto {

    private Long id;

    private String role;

    private Set<UserDto> usersDto = new HashSet<>();


    public RoleDto(String role) {
        this.role = role;
    }

    public void addUser(UserDto userDto) {
        usersDto.add(userDto);
        userDto.getRolesDto().add(this);
    }

    public void removeUser(UserDto userDto) {
        usersDto.remove(userDto);
        userDto.getRolesDto().remove(this);
    }


}
