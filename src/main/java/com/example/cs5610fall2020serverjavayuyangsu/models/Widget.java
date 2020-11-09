package com.example.cs5610fall2020serverjavayuyangsu.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="widgets")
public class Widget implements Comparable<Widget> {

  @Id
  @JsonProperty("_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private String tid;

  private String type;

  private int widgetOrder;

  private String text;

  private int size;

  private String orderType;

  //  private String url;
  //  private int width;
  //  private int height;
  //  private String cssClass;
  //  private String style;
  //  private String value;

  public Widget() {

  }

  public Widget(String name, String text, int size, int id, String tid, String type,
      int widgetOrder, String orderType) {
    this.name = name;
    this.id = id;
    this.tid = tid;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.size = size;
    this.text = text;
    this.orderType = orderType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @Override
  public int compareTo(Widget widget) {
    return this.getWidgetOrder() - widget.getWidgetOrder();
  }

}
