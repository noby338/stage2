package note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Boolean gender;
    private Date birthday;

    public Student(String name,Boolean gender,Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
}
