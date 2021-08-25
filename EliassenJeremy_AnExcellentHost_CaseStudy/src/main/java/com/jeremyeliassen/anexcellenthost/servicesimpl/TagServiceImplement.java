package com.jeremyeliassen.anexcellenthost.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremyeliassen.anexcellenthost.models.Tag;
import com.jeremyeliassen.anexcellenthost.repositories.TagRepository;
import com.jeremyeliassen.anexcellenthost.services.TagService;


@Service
public class TagServiceImplement implements TagService {

	private TagRepository tagRepository;
	
	@Autowired
	public TagServiceImplement(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	@Override
	public Tag createTag(Tag tag) {
		// PUT IN A CHECK TO PREVENT DUPLICATE TAGS
		// SPACE DELIMITER IN A LONG TEXT BOX???
		return tagRepository.save(tag);
	}

	@Override
	public void removeTag(Tag tag) {
		tagRepository.delete(tag);		
	}

	@Override
	public Tag findByTerm(String term) {
		
		return tagRepository.findByTerm(term);
	}

	@Override
	public void incrementTag(Tag tag) {
		tag.setVote(tag.getVote()+1);
		
	}

	@Override
	public void decrementTag(Tag tag) {
		tag.setVote(tag.getVote()-1);
		if (tag.getVote() == -2) {
			tagRepository.delete(tag);
		}
		
	}
	
	

}
