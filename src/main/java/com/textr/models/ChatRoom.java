package com.textr.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String roomId;

    @Column(nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "chatRoom",cascade = CascadeType.ALL)
    @OrderBy("created_at ASC")
    private List<Message> messages = new ArrayList<>();



    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
