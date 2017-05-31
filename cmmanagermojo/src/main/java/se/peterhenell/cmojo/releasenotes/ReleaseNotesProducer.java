package se.peterhenell.cmojo.releasenotes;

import java.util.List;

public interface ReleaseNotesProducer {

	void Produce(List<ReleaseNoteDTO> notes);

}
