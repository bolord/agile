package agile.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agile.core.web.rest.common.controller.AgileRestController;
import agile.service.entity.Role;
import agile.service.service.RoleService;

import io.swagger.annotations.Api;

/**
 * <p>
 * 角色 API 控制器
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@Api(value = "Role API", description = "角色 API")
@RestController
@RequestMapping("/api/role")
public class RoleResource extends AgileRestController<Role, RoleService> {

    @Autowired
    private RoleService roleService;

    @Override
    protected RoleService getService() {
        return this.roleService;
    }

}
