package agile.service.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import agile.common.entity.AuditingEntity;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@TableName("sys_user_role")
public class UserRole extends AuditingEntity<UserRole> {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 状态
     */
    @TableLogic
    private Integer status;


    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    public UserRole setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    public UserRole setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    /**
     * 状态
     */
    public Integer getStatus() {
        return status;
    }

    public UserRole setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    protected Serializable getPrimaryKeyValue() {
        return this.id;
    }

}
