package org.example.Lab_6.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "social_media")
@NoArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "socialMedia", fetch = FetchType.LAZY)
    private List<Event> events;

    public SocialMedia(String name) {
        this.name = name;
    }
}
