package se.peterhenell.cm.releasenotes;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.peterhenell.cm.Logging;

public class JsonReleaseNotesProducer implements ReleaseNotesProducer {

	@Override
	public void Produce(List<ReleaseNoteDTO> notes) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("c:/temp/test.json"), notes);
		} catch (JsonGenerationException e) {
			Logging.getLog().error(e.getMessage());
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			Logging.getLog().error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logging.getLog().error(e.getMessage());
		}
		
	}

}
