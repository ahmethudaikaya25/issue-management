package com.ahmethkaya.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor //içi boş constructor
@AllArgsConstructor //içinde tüm değişken tanımlarını içeren constructor
@ToString           //nesnenin tostringini oluşturuyo
@EqualsAndHashCode //equals ve hash code implemet edildi
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_code", length = 30)
    private String projectCode;

    @Column(name = "project_name", length = 300)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;

}
