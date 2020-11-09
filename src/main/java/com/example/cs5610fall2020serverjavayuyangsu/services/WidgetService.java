package com.example.cs5610fall2020serverjavayuyangsu.services;

import com.example.cs5610fall2020serverjavayuyangsu.models.Widget;
import com.example.cs5610fall2020serverjavayuyangsu.repositories.WidgetRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

//  private List<Widget> widgets = new ArrayList<>();
//
//  {
//    widgets.add(new Widget("Widget 123", "Heading 1", 1, 123, "5f8b90ca706e280017fbba79", "Heading", 0));
//    widgets.add(new Widget("Widget 234", "Paragraph 1", 1, 234, "5f8b90ca706e280017fbba79", "Paragraph", 1));
//    widgets.add(new Widget("Widget 345", "Heading 3", 3, 345, "5f8b90ca706e280017fbba79", "Heading", 2));
//  }

  public Widget createWidget(String tid, Widget widget) {

    widget.setTid(tid);

    return widgetRepository.save(widget);
  }

  public List<Widget> findWidgetsForTopic(String tid) {

    List<Widget> result = widgetRepository.findWidgetsForTopic(tid);

    Collections.sort(result);

    return result;
  }

  public Widget findWidgetById(int wid) {

    Optional<Widget> widget = widgetRepository.findById(wid);

    return widget.orElse(null);
  }

  public int updateWidget(int wid, Widget widget) {

    Optional<Widget> old = widgetRepository.findById(wid);

    if(old.isPresent()) {

      Widget newWidget = old.get();
      newWidget.setSize(widget.getSize());
      newWidget.setText(widget.getText());
      newWidget.setName(widget.getName());
      newWidget.setType(widget.getType());
      newWidget.setOrderType(widget.getOrderType());
      newWidget.setWidgetOrder(widget.getWidgetOrder());

      widgetRepository.save(newWidget);

      return 1;
    }

    return 0;

  }

  public int deleteWidget(int wid) {

    try{

      widgetRepository.deleteById(wid);
      return 1;

    } catch(Exception e) {

      return 0;

    }

  }
}
