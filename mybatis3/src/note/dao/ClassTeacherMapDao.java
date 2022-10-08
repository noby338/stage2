package note.dao;

import note.entity.ClassTeacherMap;

public interface ClassTeacherMapDao {
    ClassTeacherMap selectClaTeaByCtid(int ctid);
    ClassTeacherMap selectClaTeaByCtid2(int ctid);
}
