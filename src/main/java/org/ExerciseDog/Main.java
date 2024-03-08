package org.ExerciseDog;

import io.javalin.Javalin;


import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {



        Javalin app = Javalin.create().start(7008);
        DogHandler dogHandler = new DogHandler();

        app.routes(() -> {
            path("api/dog", () -> {
                get("/", ctx -> dogHandler.getAlldogs());
                get("/{id}", ctx -> dogHandler.getDogById());
                post("/create", ctx -> dogHandler.createDog());
                put("/put/{id}", ctx -> dogHandler.updateDog());
                delete("/delete/{id}", ctx -> dogHandler.deleteDog());
            });
        });
    }
}