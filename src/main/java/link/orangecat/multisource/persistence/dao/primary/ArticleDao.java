package link.orangecat.multisource.persistence.dao.primary;

import link.orangecat.multisource.persistence.entity.primary.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ArticleDao {

    List<ArticleEntity> selectArticle();
}
