package com.example;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Introspected
@MappedEntity(value = "demo")
public record DemoEntity(
    @Id @GeneratedValue @Nullable Integer id,
    @TypeDef(type = DataType.JSON) List<String> data,
    @DateCreated @Nullable Instant created,
    @DateUpdated @Nullable Instant updated) {

  @Creator
  public DemoEntity {
    if (data == null) {
      data = new ArrayList<>();
    } else {
      data = new ArrayList<>(data);
    }
  }

  public DemoEntity(List<String> data) {
    this(null, data, null, null);
  }
}
