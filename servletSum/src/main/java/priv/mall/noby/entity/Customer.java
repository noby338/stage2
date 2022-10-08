package priv.mall.noby.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer cid;
    private String cname;
    private String gender;
    private String birthday;
    private String cellphone;
    private String email;
    private String profession;
}
