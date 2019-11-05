package ru.kasovsky.edbe.firebird.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kasovsky.edbe.firebird.entity.SmallEntity;

public interface SmallRepo extends CrudRepository<SmallEntity, Long> {
}
