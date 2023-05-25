package com.example.blogprojecrwithrepoandexeptions.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.GeneratedColumn;
@Data
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @Column(columnDefinition = "Varchar(20) check( category='health' or category='education' or category='programming')")
    private String category;
    @Size(max = 300)
    private String body;

@Column(columnDefinition = "varchar(20) not null check (isPublished ='false)")
    private boolean isPublished=false;
}
