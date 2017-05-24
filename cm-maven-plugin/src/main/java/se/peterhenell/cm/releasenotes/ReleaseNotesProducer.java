package se.peterhenell.cm.releasenotes;

import java.util.List;

public interface ReleaseNotesProducer {

	void Produce(List<ReleaseNoteDTO> notes);

}
