package com.example.cs5610fall2020serverjavayuyangsu.services;

import com.example.cs5610fall2020serverjavayuyangsu.models.Widget;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WidgetService {

  private List<Widget> widgets = new ArrayList<>();

  {
    widgets.add(new Widget("Widget 123", "Heading 1", 1, "123", "5f8b90ca706e280017fbba79", "Heading", 0));
    widgets.add(new Widget("Widget 234", "Paragraph 1", 1, "234", "5f8b90ca706e280017fbba79", "Paragraph", 1));
    widgets.add(new Widget("Widget 345", "Heading 3", 3, "345", "5f8b90ca706e280017fbba79", "Heading", 2));
  }

  public Widget createWidget(String tid, Widget widget) {
    widget.setTid(tid);
    widget.setId((new Date()).toString());
    widgets.add(widget);
    System.out.println(widgets.toString());
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> result = new ArrayList<>();
    for(Widget w : widgets) {
      if(w.getTid().equals(tid)) {
        result.add(w);
      }
    }
    Collections.sort(result);
    System.out.println(result.toString());
    return result;
  }

  public Widget findWidgetById(String wid) {
    for(Widget w : widgets) {
      if(w.getId().equals(wid)) {
        return w;
      }
    }
    return null;
  }

  public int updateWidget(String wid, Widget widget) {
    for(Widget w : widgets) {
      if(w.getId().equals(wid)) {
        w.setSize(widget.getSize());
        w.setText(widget.getText());
        w.setName(widget.getName());
        w.setType(widget.getType());
        w.setWidgetOrder(widget.getWidgetOrder());
        return 1;
      }
    }
    System.out.println(widgets.toString());
    return 0;
  }

  public int deleteWidget(String wid) {
    for(Widget w : widgets) {
      if(w.getId().equals(wid)) {
        widgets.remove(w);
        return 1;
      }
    }
    System.out.println(widgets.toString());
    return 0;
  }
}
