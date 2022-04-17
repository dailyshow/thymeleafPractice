package com.example.thymeleaf1.model;

import lombok.*;

//@Data 를 사용하면 @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 를 한번에 다 설정해줌
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {
    private String id;
    private String name;
    private String phone;
    private String address;
}
