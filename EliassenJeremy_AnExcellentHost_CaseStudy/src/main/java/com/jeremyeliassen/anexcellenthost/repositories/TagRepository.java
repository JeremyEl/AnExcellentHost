package com.jeremyeliassen.anexcellenthost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremyeliassen.anexcellenthost.models.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {
	Tag findByTerm(String term);

}