package com.ahmethkaya.issuemanagement.entity;

import lombok.*;
import org.springframework.core.codec.StringDecoder;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "issue_history")
@Data
@NoArgsConstructor //içi boş constructor
@AllArgsConstructor //içinde tüm değişken tanımlarını içeren constructor
@ToString           //nesnenin tostringini oluşturuyo
@EqualsAndHashCode //equals ve hash code implemet edildi
public class IssueHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "issue_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

}
