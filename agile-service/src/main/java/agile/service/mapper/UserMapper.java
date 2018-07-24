package agile.service.mapper;

import org.springframework.stereotype.Repository;

import agile.service.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 用户 Mapper 接口
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}