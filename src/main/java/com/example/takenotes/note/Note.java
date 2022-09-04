package com.example.takenotes.note;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "note")
    private String note;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at;

    public Note() {}

    public Note(long id, String title, String note, LocalDateTime created_at) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.created_at = created_at;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
}
