package link.orangecat.multisource.persistence.dao.primary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import link.orangecat.multisource.persistence.entity.primary.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {

    List<ArticleEntity> selectArticle();
}
