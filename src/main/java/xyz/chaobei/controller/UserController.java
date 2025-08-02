package xyz.chaobei.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import xyz.chaobei.mapping.UserMapping;
import xyz.chaobei.pojo.UserDTO;
import xyz.chaobei.service.ITbUserService;

import javax.validation.Valid;

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
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserMapping userMapping;
    private final ITbUserService userService;

    @PostMapping
    @Operation(summary = "保存一个用户")
    public ResponseEntity<Object> save(@RequestBody @Valid UserDTO dto) {

        log.info("request to save user: {}", dto);

        userService.save(userMapping.toUser(dto));
        return ResponseEntity.ok().build();
    }


}
