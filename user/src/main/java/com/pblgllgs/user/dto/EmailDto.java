package com.pblgllgs.user.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
