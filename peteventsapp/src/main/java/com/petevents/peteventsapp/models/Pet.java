package com.petevents.peteventsapp.models;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Long id;
    private String name;
    private Date birth;
    private PetType type;
    private String owner;    
    
    public enum PetType {
        PERRO("Perro"),
        GATO("Gato"),
        GALLINA("Gallina"),
        CONEJO("Conejo"),
        PEZ("Pez"),
        AVE("Ave");
    
        private final String name;
    
        PetType(String name) {
            this.name = name;
        }
    
        public String getPetType() {
            return name;
        }
    }
}
