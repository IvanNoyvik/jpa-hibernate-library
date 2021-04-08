package by.gomel.noyvik.library.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"authenticateDto", "rolesDto", "ordersDto", "messagesDto", "statusDto"})
@ToString(exclude = {"authenticateDto", "rolesDto", "ordersDto", "messagesDto", "statusDto"})
public class UserDto {

    private Long id;
    private String name;
    private String email;

    private AuthenticateDto authenticateDto;

    private Set<RoleDto> rolesDto = new HashSet<>();


    private StatusDto statusDto;

    private List<MessageDto> messagesDto = new ArrayList<>();

    private Set<OrderDto> ordersDto = new HashSet<>();


    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public void addAuthenticate(AuthenticateDto authenticateDto) {
        this.authenticateDto = authenticateDto;
        authenticateDto.setUserDto(this);
    }

    public void removeAuthenticate() {
        authenticateDto.setUserDto(null);
        this.setAuthenticateDto(null);

    }

    public void addRole(RoleDto roleDto) {
        rolesDto.add(roleDto);
        roleDto.getUsersDto().add(this);
    }

    public void removeRole(RoleDto roleDto) {
        rolesDto.remove(roleDto);
        roleDto.getUsersDto().remove(this);
    }

    public void addStatus(StatusDto statusDto) {
        this.setStatusDto(statusDto);
        statusDto.getUsersDto().add(this);
    }

    public void removeStatus() {
        this.setStatusDto(null);
        statusDto.getUsersDto().remove(this);
    }

    public void addMessage(MessageDto messageDto) {
        messagesDto.add(messageDto);
        messageDto.setUserDto(this);
    }

    public void removeMessage(MessageDto messageDto) {
        messagesDto.remove(messageDto);
        messageDto.setUserDto(null);
    }

    public void addOrder(OrderDto orderDto) {
        ordersDto.add(orderDto);
        orderDto.setUserDto(this);
    }

    public void removeOrder(OrderDto orderDto) {
        ordersDto.remove(orderDto);
        orderDto.setUserDto(null);
    }

}
