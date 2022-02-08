package com.olsmca.SalesChannel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Client {
    private Integer dni;
    private String firsName;
    private String lastName;
    private String birthDate;
    private String email;
    private boolean criminalRecord;
    private String description;
}
