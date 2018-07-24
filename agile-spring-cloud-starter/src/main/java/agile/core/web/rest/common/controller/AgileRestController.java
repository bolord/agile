package agile.core.web.rest.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import agile.core.web.rest.common.result.PageResult;
import agile.core.web.rest.common.result.Result;
import agile.core.web.rest.common.result.builder.ResponseEntityBuilder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

public abstract class AgileRestController<E, T extends IService<E>> {

    protected abstract T getService();

    /**
     * 分页查询，支持基本条件筛选
     * @param current   当前页码
     * @param size      每页数据量
     * @param entity    筛选条件
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "current", value = "当前页码", required = false, defaultValue = "1", dataType = "int", paramType = "query"),
    	@ApiImplicitParam(name = "size", value = "每页数据量", required = false, defaultValue = "10", dataType = "int", paramType = "query"),
    })
    public ResponseEntity<PageResult> page(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            E entity,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        return ResponseEntityBuilder
                .build(getService().selectPage(new Page<E>(current, size), new EntityWrapper<E>(entity)));
    }

    /**
     * 查询单个，根据 ID 查询
     * @param id    ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询单个", notes = "查询单个，根据 ID 查询")
    public ResponseEntity<Result> all(@PathVariable long id) {
        return ResponseEntityBuilder.build(true, getService().selectById(id));
    }

    /**
     * 查询全部，支持基本条件筛选
     * @param entity    筛选条件
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部", notes = "查询全部，支持基本条件筛选")
    public ResponseEntity<Result> all(E entity) {
        return ResponseEntityBuilder.build(getService().selectList(new EntityWrapper<E>(entity)));
    }

    /**
     * 查询总数，支持基本条件筛选
     * @param entity    筛选条件
     * @return
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询总数", notes = "查询总数，支持基本条件筛选")
    public ResponseEntity<Result> count(E entity) {
        return ResponseEntityBuilder.build(getService().selectCount(new EntityWrapper<E>(entity)));
    }

    /**
     * 新建
     * @param entity    数据实体
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "新建", notes = "新建，返回结果包含生成的 ID")
    public ResponseEntity<Result> create(@RequestBody E entity) {
        return ResponseEntityBuilder.build(getService().insert(entity), entity);
    }

    /**
     * 根据 ID 更新
     * @param entity    数据实体
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新", notes = "根据 ID 更新")
    public ResponseEntity<Result> update(@RequestBody E entity) {
        return ResponseEntityBuilder.build(getService().updateById(entity));
    }

    /**
     * 根据 ID 逻辑删除
     * @param id    ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "逻辑删除", notes = "根据 ID 逻辑删除")
    public ResponseEntity<Result> remove(@PathVariable long id) {
        return ResponseEntityBuilder.build(getService().deleteById(id));
    }

    /**
     * 根据 ID 强制删除
     * @param id    ID
     * @return
     */
    @RequestMapping(value = "/{id}/force", method = RequestMethod.DELETE)
    @ApiOperation(value = "强制删除", notes = "根据 ID 强制删除")
    public ResponseEntity<Result> delete(@PathVariable long id) {
        return ResponseEntityBuilder.build(getService().deleteById(id));
    }

}
