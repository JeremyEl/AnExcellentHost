package com.jeremyeliassen.anexcellenthost.services;

import com.jeremyeliassen.anexcellenthost.models.Tag;

public interface TagService {
	Tag createTag(Tag tag);
	void removeTag(Tag tag);
	Tag findByTerm(String term);
	void incrementTag(Tag tag);
	void decrementTag(Tag tag);

}
