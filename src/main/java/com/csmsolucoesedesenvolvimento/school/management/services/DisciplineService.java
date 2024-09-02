package com.csmsolucoesedesenvolvimento.school.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.csmsolucoesedesenvolvimento.school.management.entities.Discipline;
import com.csmsolucoesedesenvolvimento.school.management.exceptions.DatabaseException;
import com.csmsolucoesedesenvolvimento.school.management.exceptions.ResourceNotFoundException;
import com.csmsolucoesedesenvolvimento.school.management.repositories.DisciplineRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class DisciplineService {

	@Autowired
	private DisciplineRepository repository;

	public List<Discipline> findAll() {
		return repository.findAll();
	}

	public Discipline findById(Long id) {
		Optional<Discipline> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Discipline insert(Discipline obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Discipline update(Long id, Discipline obj) {
		try {
			Discipline entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Discipline entity, Discipline obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
	}
}