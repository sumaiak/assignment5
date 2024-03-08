package org.ExerciseDog;

import io.javalin.http.Handler;

import java.util.Map;

public class DogHandler {
    Map<Integer, DogDTO> dogs = Map.of(
            1, new DogDTO(1, "jaden", "Golden Retriever", "male", 3),
            2, new DogDTO(2, "max", "Golden Retriever", "female", 5),
            3, new DogDTO(3, "messy", "Golden Retriever", "male", 2)
    );


    public Handler getAlldogs() {
        return ctx -> {
            ctx.json(dogs);
        };


    }

    public Handler getDogById() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            DogDTO dog = dogs.get(id);
            if (dog != null) {
                ctx.json(dog);
            } else {
                ctx.status(404).result("error not found");
            }
        };
    }


    public Handler createDog() {
        return ctx -> {
            DogDTO dog = ctx.bodyAsClass(DogDTO.class);
            dogs.put(dog.getId(), dog);
            ctx.status(201).result("the content has been created");
        };
    }

    public Handler updateDog() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            DogDTO dog = ctx.bodyAsClass(DogDTO.class);
            dogs.put(id, dog);
            ctx.status(204).result("the content has been updated");
        };

    }


    public Handler deleteDog() {
        return ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));
                if (dogs.containsKey(id)) {
                    dogs.remove(id);
                    ctx.status(204);
                } else {
                    ctx.status(404).result("Dog not found");
                }
            } catch (NumberFormatException e) {
                ctx.status(400).result("Invalid ID format");
            }
        };
    }
}