package ru.kasovsky.edbe.h2.doc;

import org.jsondoc.core.annotation.global.ApiMigration;
import org.jsondoc.core.annotation.global.ApiMigrationSet;

@ApiMigrationSet(
	migrations = {
		@ApiMigration(fromversion = "0.2", steps = { "Step #3" }, toversion = "0.3"),
		@ApiMigration(fromversion = "0.1", steps = { "Step #1", "Step #2" }, toversion = "0.2")
	}
)
public class Migrations {

}
