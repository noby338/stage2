package note.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description 用于分页查询的实体类
 * @Author Noby
 * @Date 2023/3/21 12:22
 */
@Data
public class Page {
    private int pageNum;//当前页
    private int pageSize;//每页的大小
    private int pages;//总页数
    private int total;//总条数
    private List<Student> data;//当前页的数据

}
