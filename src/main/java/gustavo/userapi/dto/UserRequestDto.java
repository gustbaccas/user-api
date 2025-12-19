    package gustavo.userapi.dto;

    import jakarta.validation.constraints.NotBlank;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    public class UserRequestDto {

        @NotBlank(message = "Nome obrigatório!")
        private String name;

        @NotBlank(message = "Email obrigatório!")
        private String email;

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
    }
