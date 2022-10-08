package priv.note.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.note.entity.Dep;
import priv.note.entity.DepExample;

public interface DepMapper {
    int countByExample(DepExample example);

    int deleteByExample(DepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dep record);

    int insertSelective(Dep record);

    List<Dep> selectByExample(DepExample example);

    Dep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByExample(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
}