package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private String phone;
    private String email;
    private String document;
    private String documentType;
    private Boolean allowNotification;
    private String password;
    private Address address;
}
