package com.satyabhushan.splitwiseapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user ;
    @ManyToOne
    private Expense expense ;
    private int amount ;
    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType ;

}
/*
Expense - User
Expense - Group
Group - CreatedByUser
Group - List:Users-members
User - List:Group(members)
UserExpense - User

 */