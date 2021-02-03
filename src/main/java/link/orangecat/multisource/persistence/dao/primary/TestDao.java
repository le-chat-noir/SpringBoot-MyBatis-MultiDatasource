package link.orangecat.multisource.persistence.dao.primary;

import link.orangecat.multisource.persistence.entity.primary.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TestDao {

    TestEntity selectBlog(int id);
}
