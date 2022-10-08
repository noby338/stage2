package note.dao;

import note.entity.Dep;

public interface DepDao {
    Dep selectDepById(int id);
    Dep selectDepById2(int id);
}
