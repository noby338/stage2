package note.dao;

import note.entity.Emp;

public interface EmpDao {
    Emp selectEmpById(int id);
    Emp selectEmpById2(int id);
}
