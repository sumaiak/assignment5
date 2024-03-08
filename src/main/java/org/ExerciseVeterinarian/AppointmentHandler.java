package org.ExerciseVeterinarian;

import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentHandler {


    private List<Appointment> appointments;

    public AppointmentHandler() {
        appointments = new ArrayList<>();
        // Add initial appointments
        appointments.add(new Appointment(1, new Date(), "blood test", 1));
        appointments.add(new Appointment(2, new Date(), "pregnant checkup", 2));
        appointments.add(new Appointment(3, new Date(), "Surgery", 3));
    }
    public Handler getAllAppointments() {
        return ctx -> {
            ctx.json(appointments);
        };
    }

    public Handler getAppointmentById() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Appointment appointment = appointments.get(id);
            if (appointment != null) {
                ctx.json(appointment);
            } else {
                ctx.status(404).result("error not found");
            }
        };
    }
}
