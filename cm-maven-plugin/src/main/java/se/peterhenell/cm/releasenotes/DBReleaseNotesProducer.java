package se.peterhenell.cm.releasenotes;

import java.util.List;

public class DBReleaseNotesProducer implements ReleaseNotesProducer {

	@Override
	public void Produce(List<ReleaseNoteDTO> notes) {
		for (ReleaseNoteDTO releaseNoteDTO : notes) {
			System.out.println(releaseNoteDTO.toString());
		}
		
	}

}
