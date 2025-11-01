package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Data
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue
    Long id;
//    @NotNull
  @NotEmpty
    String title;

    String description;
    Boolean isCompleted;
    @NotEmpty
    String email;
}

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }
//
//    public Boolean getCompleted() {
//        return isCompleted;
//    }
//
//    public void setCompleted(Boolean completed) {
//        isCompleted = completed;
//    }

