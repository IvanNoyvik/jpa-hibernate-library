package by.gomel.noyvik.library.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "userDto")
@ToString(exclude = "userDto")
@Setter
@Getter
public class MessageDto {

    private Long id;
    private LocalDate dateSent;
    private String content;

    private UserDto userDto;

    public void addUser(UserDto userDto) {
        userDto.getMessagesDto().add(this);
        this.setUserDto(userDto);
    }

    public void removeUser() {
        userDto.getMessagesDto().remove(this);
        this.setUserDto(null);
    }




}
