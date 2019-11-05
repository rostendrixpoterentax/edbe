package ru.kasovsky.edbe.sqlite.doc;

import org.jsondoc.core.annotation.flow.ApiFlow;
import org.jsondoc.core.annotation.flow.ApiFlowSet;
import org.jsondoc.core.annotation.flow.ApiFlowStep;
import ru.kasovsky.edbe.sqlite.res.SmallResource;

@ApiFlowSet
public class Flows {

    @ApiFlow(
            name = "CRUD test flow",
            description = "This flow test sql insert/select/update/delete using REST CRUD API",
            steps = {
                    @ApiFlowStep(apimethodid = SmallResource.METHOD_POST),
                    @ApiFlowStep(apimethodid = SmallResource.METHOD_LIST),
                    @ApiFlowStep(apimethodid = SmallResource.METHOD_PUT),
                    @ApiFlowStep(apimethodid = SmallResource.METHOD_GET),
                    @ApiFlowStep(apimethodid = SmallResource.METHOD_DELETE)
            }
    )

    public void Flows() {

    }
}
