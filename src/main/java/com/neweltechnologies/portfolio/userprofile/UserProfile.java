package com.neweltechnologies.portfolio.userprofile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neweltechnologies.portfolio.base.BaseEntity;
import com.neweltechnologies.portfolio.users.User;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@AttributeOverride(name = "id", column = @Column(name = "userprofile_id"))
public class UserProfile extends BaseEntity {

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name = "user")
    @JsonBackReference
    private User user;

}
