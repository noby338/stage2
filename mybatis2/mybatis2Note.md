
* 映射文件中使用动态SQL
  ```sql
      <where>
        <if test=""></if>
      </where>
      
      <choose>
        <when test=""></when>
        <when test=""></when>
        <otherwise></otherwise>
      </choose>
      
      <foreach collection="array" item="id" open="(" close=")" separator=",">
        #{id}
      </foreach>
      
      <sql id="res">
        id,name,gender
      </sql>
      
      <bind name="pageIndex" value="(pageNum - 1) * pageSize"></bind>
      ```
* 字符的实体引用
* 标签语言中的CDATA区
      
     
      