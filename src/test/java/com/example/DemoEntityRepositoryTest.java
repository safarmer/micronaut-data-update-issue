package com.example;

import static org.assertj.core.api.Assertions.*;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.Test;

@MicronautTest
public class DemoEntityRepositoryTest {
  @Inject DemoEntityRepository repository;

  @Test
  public void createEntity() {
    var result = repository.save(new DemoEntity(List.of("data-1", "data-2")));
    assertThat(result.id()).isGreaterThan(0);
    assertThat(result.data()).containsExactly("data-1", "data-2");
  }

  @Test
  public void updateEntity() {
    var entity = repository.save(new DemoEntity(List.of("data-1", "data-2")));

    var updated = new DemoEntity(entity.id(), entity.data(), null, null);
    updated.data().add("updated-1");

    var result = repository.update(updated);

    assertThat(result.id()).isEqualTo(entity.id());
    assertThat(result.data()).containsExactly("data-1", "data-2", "updated-1");
  }
}
