package com.ahmethkaya.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor //içi boş constructor
@AllArgsConstructor //içinde tüm değişken tanımlarını içeren constructor
@ToString           //nesnenin tostringini oluşturuyo
@EqualsAndHashCode //equals ve hash code implemet edildi
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;
    //optional:true assigneeyi vermesen de olur
    // lazy: assignee çağırılınca select edilir eagle: her seferinde getirilir
}
