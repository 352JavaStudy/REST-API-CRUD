<<<<<<<< HEAD:study/src/main/java/com/rest/study/User/entity/User.java
package com.rest.study.User.entity;
========
package com.rest.study.user.entity;
>>>>>>>> main:study/src/main/java/com/rest/study/user/entity/User.java

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
<<<<<<<< HEAD:study/src/main/java/com/rest/study/User/entity/User.java
========
@Table(name = "\"USER\"")
>>>>>>>> main:study/src/main/java/com/rest/study/user/entity/User.java
public class User {
    @Id
    private String userId;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @CreationTimestamp
    private Date enrollDate;

}
