package link.orangecat.multisource.persistence.entity.primary;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("article")
public class ArticleEntity {

    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer a_id;

    @TableField(value = "a_name", jdbcType = JdbcType.VARCHAR)
    private String a_name;
}
