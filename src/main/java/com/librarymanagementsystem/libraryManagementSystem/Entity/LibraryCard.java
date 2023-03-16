package com.librarymanagementsystem.libraryManagementSystem.Entity;

import com.librarymanagementsystem.libraryManagementSystem.Enum.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class LibraryCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String validTill;

    @Enumerated(EnumType.STRING)
    private Status cardStatus;


    @OneToOne
    @JoinColumn
    Student student;
}
