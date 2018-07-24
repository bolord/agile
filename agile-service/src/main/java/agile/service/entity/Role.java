package agile.service.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import agile.common.entity.AuditingEntity;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@TableName("sys_role")
public class Role extends AuditingEntity<Role> {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String comment;

    /**
     * 排序
     */
    private Integer rank;

    /**
     * 状态
     */
    @TableLogic
    private Integer status;


    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 代码
     */
    public String getCode() {
        return code;
    }

    public Role setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 备注
     */
    public String getComment() {
        return comment;
    }

    public Role setComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * 排序
     */
    public Integer getRank() {
        return rank;
    }

    public Role setRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    /**
     * 状态
     */
    public Integer getStatus() {
        return status;
    }

    public Role setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    protected Serializable getPrimaryKeyValue() {
        return this.id;
    }

}
