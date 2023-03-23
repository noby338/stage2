package priv.noby.mybatis4.service;

import org.apache.ibatis.session.SqlSession;
import priv.noby.mybatis4.mapper.DepMapper;
import priv.noby.mybatis4.entity.Dep;
import priv.noby.mybatis4.entity.DepExample;
import priv.noby.mybatis4.util.SqlSessionUtil;

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
