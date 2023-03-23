package priv.noby.json;

import com.alibaba.fastjson.JSON;
import priv.noby.json.entity.Student;

public class FastJsonNote {
    public static void main(String[] args) {
        //利用fastjson，将java对象、集合转为json字符串
        Student student = new Student("noby", 21, "man");
        String jsonString = JSON.toJSONString(student);
        System.out.println("jsonString = " + jsonString);
        //利用fastjson，将json字符串转为java对象、集合
        Student student1 = JSON.parseObject(jsonString, Student.class);
        System.out.println("student1 = " + student1);
    }
}
