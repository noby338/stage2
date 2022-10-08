package priv.note.service;

import org.apache.ibatis.session.SqlSession;
import priv.note.entity.Dep;
import priv.note.entity.DepExample;
import priv.note.mapper.DepMapper;
import priv.note.util.SqlSessionUtil;

import java.util.List;

public class DepService {
    private SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    private DepMapper mapper = sqlSession.getMapper(DepMapper.class);
    public List<Dep> selectAll() {
        DepExample depExample = new DepExample();
        List<Dep> deps = mapper.selectByExample(depExample);
        sqlSession.close();
        return deps;
    }
    public Dep selectById(int id) {
        Dep dep = mapper.selectByPrimaryKey(id);
        sqlSession.close();
        return dep;
    }
}
