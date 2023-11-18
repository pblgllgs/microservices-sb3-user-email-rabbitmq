package com.pblgllgs.email.entity;

import com.pblgllgs.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmailModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_id")
    private UUID emailId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "email_from")
    private String emailFrom;
    @Column(name = "email_to")
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column(name = "send_date_email")
    private LocalDateTime sendDateEmail;
    @Column(name = "status_email")
    private StatusEmail statusEmail;
}
