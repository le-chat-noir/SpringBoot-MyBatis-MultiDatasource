package link.orangecat.multisource.persistence.entity.secondary;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("video")
public class VideoEntity {

    @TableId(value = "v_id", type = IdType.AUTO)
    private Integer v_id;

    @TableField(value = "v_name", jdbcType = JdbcType.VARCHAR)
    private String v_name;
}
