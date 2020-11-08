package com.example.cs5610fall2020serverjavayuyangsu.controllers;

import com.example.cs5610fall2020serverjavayuyangsu.models.Widget;
import com.example.cs5610fall2020serverjavayuyangsu.services.WidgetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

  @Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable String tid, @RequestBody Widget widget) {
    return service.createWidget(tid, widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable String tid) {
    return service.findWidgetsForTopic(tid);
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable int wid) {
    return service.findWidgetById(wid);
  }

  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable int wid, @RequestBody Widget widget) {
    return service.updateWidget(wid, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public int deleteWidget(@PathVariable int wid) {
    return service.deleteWidget(wid);
  }
}
