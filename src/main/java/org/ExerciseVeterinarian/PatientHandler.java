package org.ExerciseVeterinarian;

import io.javalin.http.Handler;

import java.util.List;

public class PatientHandler {
    List<Patient> patients  = List.of(
          new Patient(1, "Fluffy", "Cat", "None", "Painkillers"),
          new Patient(2, "Rex", "Dog", "None", "Antibiotics"),
          new Patient(3, "Bubbles", "Fish", "None", "None")



    );

    public Handler getPatientById() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Patient patient = patients.get(id);
            if (patient != null) {
                ctx.json(patient);
                ctx.status(200);
            } else {
                ctx.status(404);
            }
        };
    }

    public Handler getAllPatients() {
        return ctx -> {
            ctx.json(patients);
            ctx.status(200);
        };
    }
}
