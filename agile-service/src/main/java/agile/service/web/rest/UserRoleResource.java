package agile.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agile.core.web.rest.common.controller.AgileRestController;
import agile.service.entity.UserRole;
import agile.service.service.UserRoleService;

import io.swagger.annotations.Api;

/**
 * <p>
 * 用户角色 API 控制器
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@Api(value = "UserRole API", description = "用户角色 API")
@RestController
@RequestMapping("/api/userRole")
public class UserRoleResource extends AgileRestController<UserRole, UserRoleService> {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected UserRoleService getService() {
        return this.userRoleService;
    }

}
