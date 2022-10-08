package note.dao;

import note.entity.Class;

public interface ClassDao {
    Class selectClassById(int cid);
    Class selectClassById2(int cid);
}
