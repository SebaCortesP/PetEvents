package com.petevents.peteventsapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventType {
    private Long id;
    private String name;
    private String description;
}
