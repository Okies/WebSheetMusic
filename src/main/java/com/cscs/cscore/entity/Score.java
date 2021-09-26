package com.cscs.cscore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Score extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String notation;

    @Column(nullable = false)
    private String writer;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeNotation(String notation) {
        this.notation = notation;
    }
}
