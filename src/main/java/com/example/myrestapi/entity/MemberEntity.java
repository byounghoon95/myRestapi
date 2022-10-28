package com.example.myrestapi.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Table(name = "member")
@Getter
@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_id", unique = true)
    private String memberId;
    private String password;
    private String name;
    private String email;

    @Builder
    public MemberEntity(Long id, String memberId, String password, String name, String email) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
    public MemberEntity() {

    }
}
