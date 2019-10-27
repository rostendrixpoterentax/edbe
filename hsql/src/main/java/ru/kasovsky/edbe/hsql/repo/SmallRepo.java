package ru.kasovsky.edbe.hsql.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kasovsky.edbe.hsql.entity.SmallEntity;

public interface SmallRepo extends CrudRepository<SmallEntity, Long> {
}
