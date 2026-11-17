package com.bungalow.app.view.controller;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class viewMainController {

    @GetMapping("")
    public String viewMain(Model model) {
        // 화면 확인용 예시 데이터이며 추후 실제 객실 정보로 교체합니다.
        List<Map<String, String>> rooms = List.of(
            Map.of("number", "01", "status", "이용 가능", "statusClass", "available"),
            Map.of("number", "02", "status", "이용 중", "statusClass", "occupied"),
            Map.of("number", "03", "status", "이용 가능", "statusClass", "available"),
            Map.of("number", "04", "status", "이용 중", "statusClass", "occupied"),
            Map.of("number", "05", "status", "점검 중", "statusClass", "maintenance"),
            Map.of("number", "06", "status", "이용 가능", "statusClass", "available")
        );
        model.addAttribute("rooms", rooms);
        model.addAttribute("totalCount", rooms.size());
        model.addAttribute("availableCount", rooms.stream().filter(room -> "available".equals(room.get("statusClass"))).count());
        model.addAttribute("occupiedCount", rooms.stream().filter(room -> "occupied".equals(room.get("statusClass"))).count());
        model.addAttribute("maintenanceCount", rooms.stream().filter(room -> "maintenance".equals(room.get("statusClass"))).count());
        return "bungalow/app/contents/main";
    }
}
