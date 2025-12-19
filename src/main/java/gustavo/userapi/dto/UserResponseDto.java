package gustavo.userapi.dto;

import gustavo.userapi.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

public class UserResponseDto {
    private Integer id;
    private String name;
    private String email;
    private Boolean active;

    public UserResponseDto(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.active = user.getActive();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
