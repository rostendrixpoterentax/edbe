package ru.kasovsky.edbe.derby.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kasovsky.edbe.derby.entity.SmallEntity;

public interface SmallRepo extends CrudRepository<SmallEntity, Long> {
}
