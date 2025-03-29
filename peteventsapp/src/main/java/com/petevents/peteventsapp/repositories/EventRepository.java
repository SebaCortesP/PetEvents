package com.petevents.peteventsapp.repositories;

import com.petevents.peteventsapp.exceptions.ResourceNotFoundException;
import com.petevents.peteventsapp.models.Event;
import com.petevents.peteventsapp.models.EventType;
import com.petevents.peteventsapp.models.Pet;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EventRepository {
    private final List<Event> events = new ArrayList<>();
    private final List<EventType> eventTypes = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Constructor para inicializar el repositorio con eventos de ejemplo
    public EventRepository() {
        try {
            // Poblar algunos tipos de evento
            EventType feria = new EventType(1L, "Feria", "Evento de tipo Feria");
            EventType competition =new EventType(2L, "Competición", "Evento de tipo Competición");
            EventType exhibition =new EventType(3L, "Exhibición", "Evento de tipo Exhibición");
            EventType run = new EventType(4L, "Carrera", "Evento de tipo Carrera");
            EventType duel = new EventType(5L, "Duelo", "Evento de tipo Duelo");
            eventTypes.add(feria);
            eventTypes.add(competition);
            eventTypes.add(exhibition);
            eventTypes.add(run);
            eventTypes.add(duel);
            // Poblar algunas mascotas
            Pet mateo = null;
            Pet cloe = null;
            Pet abdul = null;
             try {
                mateo = new Pet(1L, "Mateo", dateFormat.parse("2020-05-10"), Pet.PetType.PERRO, "Seba Cortés");
                cloe = new Pet(2L, "Cloe", dateFormat.parse("2019-03-15"), Pet.PetType.GATO, "Kathy Rojas");
                abdul = new Pet(3L, "Abdul", dateFormat.parse("2021-07-20"), Pet.PetType.GATO, "Sofy Cortés");
            } catch (ParseException e) {
                e.printStackTrace(); // Imprimir el error para saber qué salió mal
            }
            pets.add(mateo);
            pets.add(cloe);
            pets.add(abdul);
            // Crear eventos de ejemplo
            events.add(new Event(1L, "Feria de Verano", "Evento de tipo feria con actividades para mascotas", feria, List.of(cloe, abdul), dateFormat.parse("2023-07-15")));
            events.add(new Event(2L, "Competición de Perros", "Competición de perros de diversas razas", competition, List.of(mateo, abdul, cloe), dateFormat.parse("2023-08-10")));
            events.add(new Event(3L, "Pelea de perros", "Evento de pelea con actividades para mascotas", duel, List.of(abdul, mateo), dateFormat.parse("2023-07-15")));
            
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones si la fecha es incorrecta
        }
    }

    // Método para obtener todos los eventos
    public List<Event> findAllEvents() {
        return events;
    }

    // Método para encontrar un evento por su ID
    public Event findByIdEvent(Long id) {
         return events.stream()
                     .filter(event -> event.getId().equals(id))
                     .findFirst()
                     .orElseThrow(() -> new ResourceNotFoundException("Event", id));
    }
    public List<EventType> findAllEventType() {
        return eventTypes;
    }

    // Get event by id
    public EventType findByIdEventType(Long id) {
        return eventTypes.stream()
                         .filter(eventType -> eventType.getId().equals(id))
                         .findFirst()
                         .orElseThrow(() -> new ResourceNotFoundException("EventType", id)); // Lanzar excepción si no se encuentra
    }   

    public List<Pet> findAllPets() {
        return pets;
    }

    // Buscar por ID
    public Pet findByIdPet(Long id) {
        return pets.stream()
                   .filter(pet -> pet.getId().equals(id))
                   .findFirst()
                   .orElseThrow(() -> new ResourceNotFoundException("Pet", id)); // Lanzar excepción si no se encuentra
    }
}
