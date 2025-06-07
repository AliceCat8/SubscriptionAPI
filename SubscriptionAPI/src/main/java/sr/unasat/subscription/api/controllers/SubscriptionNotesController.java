package sr.unasat.subscription.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.subscription.api.dto.SubscriptionNotesDTO;
import sr.unasat.subscription.api.entity.SubscriptionNotes;
import sr.unasat.subscription.api.services.SubscriptionNotesService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

@Path("/subscription-notes")
public class SubscriptionNotesController {
    private final SubscriptionNotesService service = new SubscriptionNotesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubscriptionNotesDTO> getAllSubscriptionNotes() {
        return service.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubscriptionNote(@PathParam("id") int id) {
        SubscriptionNotes note = service.findById(id);
        if (note != null) {
            return Response.ok(toDTO(note)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSubscriptionNote(SubscriptionNotesDTO dto) {
        try {
            SubscriptionNotes note = toEntity(dto);
            SubscriptionNotes saved = service.save(note);
            return Response.status(Response.Status.CREATED).entity(toDTO(saved)).build();
        } catch (ConstraintViolationException e) {
            return buildValidationErrorResponse(e.getConstraintViolations());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSubscriptionNote(@PathParam("id") int id, SubscriptionNotesDTO dto) {
        try {
            SubscriptionNotes existing = service.findById(id);
            if (existing != null) {
                existing.setSubscriptionId(dto.getSubscriptionId());
                existing.setNote(dto.getNote());
                SubscriptionNotes updated = service.update(existing);
                return Response.ok(toDTO(updated)).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (ConstraintViolationException e) {
            return buildValidationErrorResponse(e.getConstraintViolations());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSubscriptionNote(@PathParam("id") int id) {
        SubscriptionNotes existing = service.findById(id);
        if (existing != null) {
            service.delete(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    private SubscriptionNotesDTO toDTO(SubscriptionNotes note) {
        return new SubscriptionNotesDTO(
                note.getId(),
                note.getSubscriptionId(),
                note.getNote()
        );
    }

    private SubscriptionNotes toEntity(SubscriptionNotesDTO dto) {
        return new SubscriptionNotes(
                dto.getSubscriptionId(),
                dto.getNote()
        );
    }

    private Response buildValidationErrorResponse(Set<ConstraintViolation<?>> violations) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> v : violations) {
            String field = v.getPropertyPath().toString();
            errors.put(field, v.getMessage());
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errors)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
