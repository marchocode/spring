package xyz.chaobei.service.impl;

import xyz.chaobei.entity.TUser;
import xyz.chaobei.mapper.TUserMapper;
import xyz.chaobei.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Baomidou
 * @since 2025-07-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
