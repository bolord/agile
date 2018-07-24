package agile.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agile.service.entity.User;
import agile.service.service.UserService;

import io.swagger.annotations.Api;

import agile.common.controller.AgileRestController;

/**
 * <p>
 * 用户 API 控制器
 * </p>
 *
 * @author Alex
 * @since 2018-07-05
 */
@Api(value = "User API", description = "用户 API")
@RestController
@RequestMapping("/api/user")
public class UserResource extends AgileRestController<User, UserService> {

    @Autowired
    private UserService userService;

    @Override
    protected UserService getService() {
        return this.userService;
    }

}
