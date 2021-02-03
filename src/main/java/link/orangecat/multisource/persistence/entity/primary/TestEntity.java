package link.orangecat.multisource.persistence.entity.primary;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("test")
public class TestEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "text", jdbcType = JdbcType.VARCHAR)
    private String text;

    @TableField(value = "hello_msg", jdbcType = JdbcType.VARCHAR)
    private String hello_msg;
}
