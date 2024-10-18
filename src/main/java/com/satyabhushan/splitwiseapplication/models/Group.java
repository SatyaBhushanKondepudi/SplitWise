package com.satyabhushan.splitwiseapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "groups_table")
public class Group extends BaseModel {
    private String name ;
    private String description ;
    @ManyToOne
    private User createdByUser ;
    @ManyToMany
    private List<User> members ;
}