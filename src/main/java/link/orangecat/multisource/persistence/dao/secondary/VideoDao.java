package link.orangecat.multisource.persistence.dao.secondary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import link.orangecat.multisource.persistence.entity.secondary.VideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface VideoDao extends BaseMapper<VideoEntity> {

    VideoEntity selectVideo(int v_id);
}
