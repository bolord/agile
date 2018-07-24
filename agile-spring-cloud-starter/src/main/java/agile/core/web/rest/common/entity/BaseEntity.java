package agile.core.web.rest.common.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键值
     * @return
     */
    protected abstract Serializable getPrimaryKeyValue();

}