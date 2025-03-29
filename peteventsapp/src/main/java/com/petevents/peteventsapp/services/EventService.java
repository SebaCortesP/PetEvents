package com.petevents.peteventsapp.services;
import com.petevents.peteventsapp.models.Event;
import com.petevents.peteventsapp.models.EventType;
import com.petevents.peteventsapp.models.Pet;
import com.petevents.peteventsapp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Obtener todos los eventos
    public List<Event> getAllEvents() {
        return eventRepository.findAllEvents();
    }

    // Obtener un evento por ID
    public Event getEventById(Long id) {
        return eventRepository.findByIdEvent(id);
    }

    // Obtener todos los tipos de eventos
    public List<EventType> getAllEventTypes() {
        return eventRepository.findAllEventType();
    }

    // Obtener un tipo de evento por ID
    public EventType getEventTypeById(Long id) {
        return eventRepository.findByIdEventType(id);
    }

    // Obtener todas las mascotas
    public List<Pet> getAllPets() {
        return eventRepository.findAllPets();
    }

    // Obtener una mascota por ID
    public Pet getPetById(Long id) {
        return eventRepository.findByIdPet(id);
    }
}
