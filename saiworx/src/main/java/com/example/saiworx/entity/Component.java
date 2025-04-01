package com.example.saiworx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "components")
public class Component {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    @NotBlank
    @Size(max = 40, message = "name max 40 znakov")
    private String name;


    @Enumerated(EnumType.STRING)
    private ComponentType type;

    //@CreationTimestamp
    private Date createdAt;

}
