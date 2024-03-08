package org.ExerciseVeterinarian;

import io.javalin.Javalin;


import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {



        Javalin app = Javalin.create().start(7008);
        AppointmentHandler appointmentHandler = new AppointmentHandler();
        PatientHandler patientHandler = new PatientHandler();
        app.routes(() -> {
            path("api/vet", () -> {
                get("/", ctx -> appointmentHandler.getAllAppointments());
                get("/{id}", ctx -> appointmentHandler.getAppointmentById());

            });
        });
        app.routes(() -> {
            path("api/patient", () -> {
                get("/", ctx -> patientHandler.getAllPatients());
                get("/{id}", ctx -> patientHandler.getPatientById());

            });
        });
    }
}