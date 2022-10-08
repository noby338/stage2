package note.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page {//该类用于分页查询的实体类
    private int pageNum;//当前页
    private int pageSize;//每页的大小
    private int pages;//总页数
    private int total;//总条数
    private List<Student> data;//当前页的数据

}
