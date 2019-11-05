package ru.kasovsky.edbe.firebird.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import ru.kasovsky.edbe.firebird.doc.Consts;
import ru.kasovsky.edbe.firebird.res.SmallResource;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(exclude = "id")
@ApiObject(name = SmallResource.TAG, group = Consts.GROUP_TEST, description = SmallResource.DESC)
public class SmallDto {

    @ApiObjectField
    private long id;

    @ApiObjectField
    private String uuid;

    @ApiObjectField
    private String name;

    @ApiObjectField
    private String data;
}
