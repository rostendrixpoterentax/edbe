package ru.kasovsky.edbe.sqlite.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kasovsky.edbe.sqlite.entity.SmallEntity;

public interface SmallRepo extends CrudRepository<SmallEntity, Long> {
}
