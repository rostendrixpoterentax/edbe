package ru.kasovsky.edbe.h2.doc;

import org.jsondoc.core.annotation.global.ApiChangelog;
import org.jsondoc.core.annotation.global.ApiChangelogSet;

@ApiChangelogSet(
	changlogs = {
		@ApiChangelog(changes = { "Changelog #5", "Changelog #6" }, version = "0.3"),
		@ApiChangelog(changes = { "Changelog #2", "Changelog #3", "Changelog #4" }, version = "0.2"),
		@ApiChangelog(changes = { "Changelog #1" }, version = "0.1")
	}
)		
public class Changelogs {

}
