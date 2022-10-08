package note.dao;

import note.entity.Emp;

public interface EmpDao {
    Emp selectEmpById(int eid);
    Emp selectEmpById2(int eid);
}
