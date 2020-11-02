package com.example.cs5610fall2020serverjavayuyangsu.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Widget implements Comparable<Widget> {

  private String name;

  @JsonProperty("_id")
  private String id;

  private String tid;

  private String type;

  private int widgetOrder;

  private String text;

  private int size;

  //  private String url;
  //  private int width;
  //  private int height;
  //  private String cssClass;
  //  private String style;
  //  private String value;

  public Widget() {

  }

  public Widget(String name, String text, int size, String id, String tid, String type, int widgetOrder) {
    this.name = name;
    this.id = id;
    this.tid = tid;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.size = size;
    this.text = text;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(int widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getSize() {

    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public int compareTo(Widget widget) {
    return this.getWidgetOrder() - widget.getWidgetOrder();
  }

  @Override
  public String toString() {
    return "Widget{" +
        "name='" + name + '\'' +
        ", id='" + id + '\'' +
        ", tid='" + tid + '\'' +
        ", type='" + type + '\'' +
        ", widgetOrder=" + widgetOrder +
        ", text='" + text + '\'' +
        ", size=" + size +
        '}';
  }
}
