package priv.noby.servletsum.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private List<T> list;
    private int pageIndex;//页索引
    private int pageSize;//页大小
    private int recordTotal;//总数据
    private int pageTotal;//总页数
    private int pageStart;//显示的开始
    private int pageEnd;//显示的结束页

    public int getPageTotal() {
        return recordTotal % pageSize == 0 ? recordTotal / pageSize : recordTotal / pageSize + 1;
    }

    public void setStartAndEnd() {
        //默认最多显示10个页码
        if(getPageTotal()<10) {
            pageStart=1;
            pageEnd=getPageTotal();
        }else {
            pageStart=pageIndex-5;
            pageEnd=pageIndex+4;
            //beginPage越界
            if(pageStart<1) {
                pageStart=1;
                pageEnd=10;
            }
            //endPage越界
            if(pageEnd>getPageTotal()) {
                pageStart=getPageTotal()-9;
                pageEnd=getPageTotal();
            }
        }
    }

}
