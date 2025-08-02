package xyz.chaobei.mapping;

import org.mapstruct.Mapper;
import xyz.chaobei.entity.TbUserDO;
import xyz.chaobei.pojo.UserDTO;

/**
 * @author mrc
 */
@Mapper(componentModel = "spring")
public interface UserMapping {

    /**
     * DTO to DO
     * @param dto dto
     * @return DO
     */
    TbUserDO toUser(UserDTO dto);

}
