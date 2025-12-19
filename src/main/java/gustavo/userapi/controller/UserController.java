package gustavo.userapi.controller;

import gustavo.userapi.dto.UserRequestDto;
import gustavo.userapi.dto.UserResponseDto;
import gustavo.userapi.entity.UserEntity;
import gustavo.userapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto dto) {
        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        UserEntity created = service.create(user);

        UserResponseDto response = new UserResponseDto(created);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserResponseDto> list = service.findAll()
                .stream()
                .map(UserResponseDto::new)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(new UserResponseDto(service.findById(id)));
    }

    @PutMapping("{id}/desactivate")
    public ResponseEntity<UserResponseDto> desactivateById(@PathVariable("id") Integer id) {
        UserEntity updated = service.desactivate(id);
        return ResponseEntity.ok(new UserResponseDto(updated));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> userDelete(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



