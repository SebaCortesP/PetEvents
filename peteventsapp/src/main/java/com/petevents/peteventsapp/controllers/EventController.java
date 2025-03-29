package com.petevents.peteventsapp.controllers;
import com.petevents.peteventsapp.exceptions.ResourceNotFoundException;
import com.petevents.peteventsapp.models.Event;
import com.petevents.peteventsapp.models.EventType;
import com.petevents.peteventsapp.models.Pet;
import com.petevents.peteventsapp.services.EventService;
import com.petevents.peteventsapp.responses.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Obtener todos los eventos
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Obtener un evento por ID
    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") Long id) {
        try {
            Event event = eventService.getEventById(id);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // Crear una respuesta de error con el mensaje
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // Devuelve 404 con el mensaje de error
        }
    }

    // Obtener todos los tipos de eventos
    @GetMapping("/event_type")
    public List<EventType> getAllEventTypes() {
        return eventService.getAllEventTypes();
    }

    // Obtener un tipo de evento por ID
    @GetMapping("/event_type/{id}")
    public ResponseEntity<?> getEventTypeById(@PathVariable("id") Long id) {
        try {
            EventType eventType = eventService.getEventTypeById(id);
            return new ResponseEntity<>(eventType, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // Crear una respuesta de error con el mensaje
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // Devuelve 404 con el mensaje de error
        }
    }

    // Obtener todas las mascotas
    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return eventService.getAllPets();
    }

    // Obtener una mascota por ID
    @GetMapping("/pets/{id}")
    public ResponseEntity<?> getPetById(@PathVariable("id") Long id) {
        try {
            Pet pet = eventService.getPetById(id);
            return new ResponseEntity<>(pet, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            // Crear una respuesta de error con el mensaje
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // Devuelve 404 con el mensaje de error
        }
    }
}
