package kz.bitlab.springboot.sprint2.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    Long id;
    String userName;
    String courseName;
    String commentary;
    String phone;
    boolean handled;
}
