package ru.kasovsky.edbe.hsql.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import ru.kasovsky.edbe.hsql.doc.Consts;
import ru.kasovsky.edbe.hsql.res.SmallResource;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(exclude = "id")
@ApiObject(name = SmallResource.TAG, group = Consts.GROUP_TEST, description = SmallResource.DESC)
public class SmallDto {

    @ApiObjectField
    private long id;

    @ApiObjectField
    private UUID uuid;

    @ApiObjectField
    private String name;

    @ApiObjectField
    private String data;
}
