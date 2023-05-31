package kz.bitlab.springboot.sprint2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="t_requests")
@Getter
@Setter
public class RequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="userName")
    private String userName;

    @Column(name="courseName")
    private String courseName;

    @Column(name="commentary")
    private String commentary;

    @Column(name="phone")
    private String phone;

    @Column(name="handled")
    private boolean handled;


}
