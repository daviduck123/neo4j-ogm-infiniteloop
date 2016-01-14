package com.david.duck.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.david.duck.model.Calendar;

public interface CalendarRepository  extends GraphRepository<Calendar>{

}
