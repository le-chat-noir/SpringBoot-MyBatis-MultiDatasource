package link.orangecat.multisource.persistence.dao.primary;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import link.orangecat.multisource.persistence.entity.primary.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TestDao extends BaseMapper<TestEntity> {

    TestEntity selectTest(int id);
}
