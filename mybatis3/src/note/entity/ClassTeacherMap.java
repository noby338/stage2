package note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassTeacherMap {
    private Integer id;
    private Integer avrScore;
    private Class aClass;
    private Teacher teacher;
}
