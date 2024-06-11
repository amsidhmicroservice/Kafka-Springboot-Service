package com.amsidh.mvc.model;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Employee implements Serializable {
    private String id;
    private String name;
    private String emailId;
}
