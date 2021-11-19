package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Path("/v1")
public class PetResource {
	List<Pet> globalpets = new ArrayList<Pet>();
	
	@Path("/pets")
	@Produces("application/json")
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	public Response getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		Pet pet1 = new Pet();
		pet1.setPetId(1);
		pet1.setPetAge(3);
		pet1.setPetName("Boola");
		pet1.setPetType("Dog");

		Pet pet2 = new Pet();
		pet2.setPetId(2);
		pet2.setPetAge(4);
		pet2.setPetName("Sudda");
		pet2.setPetType("Cat");

		Pet pet3 = new Pet();
		pet3.setPetId(3);
		pet3.setPetAge(2);
		pet3.setPetName("Peththappu");
		pet3.setPetType("Bird");
		
		Pet pet4 = new Pet();
		pet4.setPetId(4);
		pet4.setPetAge(5);
		pet4.setPetName("Jimmy");
		pet4.setPetType("Dog");
		
		Pet pet5 = new Pet();
		pet5.setPetId(5);
		pet5.setPetAge(6);
		pet5.setPetName("Kit");
		pet5.setPetType("Fish");

		pets.add(pet1);
		pets.add(pet2);
		pets.add(pet3);
		pets.add(pet4);
		pets.add(pet5);
		globalpets = pets;
		return Response.ok(pets).build();
	}
	@GET
    @Path("/pets/{petId}")
    @Produces({ "application/json"})
    @Operation(summary = "Find pet by ID", description = "Returns a single pet")
    @APIResponses(value = { 
        @APIResponse(responseCode = "200", description = "successful pet searchoperation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
        @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
        @APIResponse(responseCode = "404", description = "Pet not found")
    })
	public Response getPet(@PathParam("petId") int petId) {
		Pet pet = new Pet();
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}else {
			
			for(Pet p : globalpets) {
				if(p.getPetId().intValue() == petId) {
					pet = p;
				}
			}
		}
		return Response.ok(pet).build();
		
	}
	/*
	 * ------------------Implementation of the rest of the controller methods -------
	 */
	@POST
    @Path("/pets")
    @Consumes({ "application/json" })
    @Operation(summary = "Add a new pet to the store", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "200", description = "Pet Added successfully"),
        @APIResponse(responseCode = "405", description = "Invalid input")
    })
    public Response addPet(@Valid Pet body) {
		Pet newpet = new Pet();
		newpet = body;
		globalpets.add(newpet);
        return Response.ok().entity(newpet).build();
    }
    @POST
    @Path("/petType")
    @Consumes({ "application/json"})
    @Operation(summary = "Add a new pettype to the store", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "405", description = "Invalid input")
    })
    public Response addPetType(@Valid Pet body) {
        return Response.ok().entity("magic!").build();
    }
    @DELETE
    @Path("/pets/{petId}")
    @Operation(summary = "Deletes a pet", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "200", description = "Pet deleted successfully"),
        @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
        @APIResponse(responseCode = "404", description = "Pet not found")
    })
    public Response deletePet( @PathParam("petId")

    @Parameter(description = "Pet id to delete") Long petId, @HeaderParam("api_key") String apiKey) {
        return Response.ok().entity("magic!").build();
    }
    @DELETE
    @Path("/petType/{petTypeId}")
    @Operation(summary = "Deletes a pet type", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
        @APIResponse(responseCode = "404", description = "PetType not found")
    })
    public Response deletePetType( @PathParam("petTypeId")

    @Parameter(description = "PetType id to delete") Long petTypeId, @HeaderParam("api_key") String apiKey) {
        return Response.ok().entity("magic!").build();
    }
    @GET
    @Path("/pets/search/{petName}")
    @Produces({ "application/json"})
    @Operation(summary = "Find pet by Name", description = "Returns a single pet")
    @APIResponses(value = { 
        @APIResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
        @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
        @APIResponse(responseCode = "404", description = "Pet not found")
    })
    public Response getPetByName( @PathParam("petName")

    @Parameter(description = "name of pet to return") String petName) {
        return Response.ok().entity("magic!").build();
    }
    @GET
    @Path("/petType")
    @Operation(summary = "Get all pets in the store", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "200", description = "get pettypes sucessfully"),
        @APIResponse(responseCode = "404", description = "PetType not found")
    })
    public Response getPetTypes() {
        return Response.ok().entity("magic!").build();
    }
    
    @PUT
    @Path("/pets")
    @Consumes({ "application/json" })
    @Operation(summary = "Update an existing pet", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "200", description = "Pet Updated successfully"),
        @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
        @APIResponse(responseCode = "404", description = "Pet not found"),
        @APIResponse(responseCode = "405", description = "Validation exception")
    })
    public Response updatePet(@Valid Pet body) {
        return Response.ok().entity("magic!").build();
    }
    @PUT
    @Path("/petType")
    @Consumes({ "application/json"})
    @Operation(summary = "Update an existing petType", description = "")
    @APIResponses(value = { 
        @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
        @APIResponse(responseCode = "404", description = "PetType not found"),
        @APIResponse(responseCode = "405", description = "Validation exception")
    })
    public Response updatePetTypes(@Valid Pet body) {
        return Response.ok().entity("magic!").build();
    }}
