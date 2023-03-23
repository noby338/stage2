package note.dao;

import note.entity.ClassTeacherMap;

public interface ClassTeacherMapDao {
    ClassTeacherMap selectClaTeaById(int id);
    ClassTeacherMap selectClaTeaById2(int id);
}
