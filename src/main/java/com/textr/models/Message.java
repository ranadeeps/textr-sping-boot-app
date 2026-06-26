package com.textr.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "messages")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("messages")
    private ChatRoom chatRoom;

}
