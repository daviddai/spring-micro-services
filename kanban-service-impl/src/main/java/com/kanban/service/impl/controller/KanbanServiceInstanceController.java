package com.kanban.service.impl.controller;

import com.micro.service.common.controller.ServiceInstanceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kanban")
public class KanbanServiceInstanceController extends ServiceInstanceController {}