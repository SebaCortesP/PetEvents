package com.petevents.peteventsapp.models;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String description;
    private EventType eventType;
    private List<Pet> pets;
    private Date date;
}
