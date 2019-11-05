package ru.kasovsky.edbe.firebird.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kasovsky.edbe.firebird.dto.SmallCreateDto;
import ru.kasovsky.edbe.firebird.dto.SmallDto;
import ru.kasovsky.edbe.firebird.dto.SmallUpdateDto;
import ru.kasovsky.edbe.firebird.entity.SmallEntity;

import java.util.List;

import static org.mapstruct.NullValueMappingStrategy.RETURN_NULL;

@Mapper
public interface SmallMapper {

    SmallMapper MAPPER = Mappers.getMapper(SmallMapper.class);

    SmallDto toDto(SmallEntity model);

    @IterableMapping(nullValueMappingStrategy = RETURN_NULL)
    List<SmallDto> toDto(List<SmallEntity> model);

    //@Mapping(target = "id", ignore = true)
    SmallEntity toEntity(SmallCreateDto model);

    SmallEntity toDto(SmallUpdateDto adapter);
}