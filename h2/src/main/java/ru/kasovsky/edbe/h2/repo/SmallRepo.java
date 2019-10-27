package ru.kasovsky.edbe.h2.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kasovsky.edbe.h2.entity.SmallEntity;

public interface SmallRepo extends CrudRepository<SmallEntity, Long> {
}
