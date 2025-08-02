package xyz.chaobei.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author mrc
 * @since 2025-08-02
 */
@Getter
@Setter
@ToString
@TableName("tb_user")
@Schema(name = "TbUserDO", description = "")
public class TbUserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 用户名
     */
    @TableField("username")
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    @Schema(description = "密码")
    private String password;

    /**
     * 手机号
     */
    @TableField("phone")
    @Schema(description = "手机号")
    private String phone;
}
