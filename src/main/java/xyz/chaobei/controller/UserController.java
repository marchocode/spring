package xyz.chaobei.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import xyz.chaobei.entity.TUser;
import xyz.chaobei.service.ITUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Baomidou
 * @since 2025-07-17
 */
@Controller
@RequestMapping("/api/user")
@Tag(name = "用户接口", description = "用户管理相关接口")
public class UserController {

    private final ITUserService userService;

    public UserController(ITUserService userService) {
        this.userService = userService;
    }

    @PutMapping
    @Operation(summary = "保存一个用户")
    public ResponseEntity save(@RequestBody TUser tUser) {
        userService.save(tUser);
        return ResponseEntity.ok().build();
    }


}
