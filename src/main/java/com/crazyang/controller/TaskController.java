package com.crazyang.controller;

import com.crazyang.core.utils.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TaskController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 上午9:56.
 */

@RestController
@RequestMapping("/tasks")
public class TaskController {

    Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping
    public String listTasks() {
        return "任务列表";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String newTasks(HttpServletRequest request, HttpServletResponse response) {


        String token =request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        logger.info(token);
        return "创建了一个新的任务";
    }

    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId") Integer id) {
        return "更新了一下id为:" + id + "的任务";
    }

    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId") Integer id) {
        return "删除了id为:" + id + "的任务";
    }
}
