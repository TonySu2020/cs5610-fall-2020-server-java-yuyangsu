package com.example.cs5610fall2020serverjavayuyangsu.repositories;

import com.example.cs5610fall2020serverjavayuyangsu.models.Widget;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  @Query(value = "select widget from Widget widget where tid=:tid")
  List<Widget> findWidgetsForTopic(@Param("tid") String tid);
}

