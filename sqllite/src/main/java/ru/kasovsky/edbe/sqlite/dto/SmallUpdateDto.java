package ru.kasovsky.edbe.sqlite.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import ru.kasovsky.edbe.sqlite.doc.Consts;
import ru.kasovsky.edbe.sqlite.res.SmallResource;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(exclude = "id")
@ApiObject(name = SmallResource.TAG, group = Consts.GROUP_TEST, description = SmallResource.DESC)
public class SmallUpdateDto {

    @ApiObjectField(required = true, order = 1)
    private long id;

    @ApiObjectField(required = true, order = 2)
    private UUID uuid;


    @ApiObjectField(required = true, order = 3)
    private String name;

    @ApiObjectField(required = true, order = 4)
    private String data;
}
