package com.example.petstore;

import java.util.Objects;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "Pet")
public class Pet {

	@Schema(required = true, description = "Pet id")
	@JsonProperty("pet_id")
	private Integer petId;

	@Schema(required = true, description = "Pet type")
	@JsonProperty("pet_type")
	private String petType;

	@Schema(required = true, description = "Pet petName")
	@JsonProperty("pet_petName")
	private String petName;

	@JsonProperty("pet_petAge")
	private Integer petAge;

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Integer getPetAge() {
		return petAge;
	}

	public void setPetAge(Integer petAge) {
		this.petAge = petAge;
	}
	
//	@Override
//	  public boolean equals(java.lang.Object o) {
//	    if (this == o) {
//	      return true;
//	    }
//	    if (o == null || getClass() != o.getClass()) {
//	      return false;
//	    }
//	    Pet pet = (Pet) o;
//	    return Objects.equals(petId, pet.petId) &&
//	        Objects.equals(petType, pet.petType) &&
//	        Objects.equals(petName, pet.petName) &&
//	        Objects.equals(petAge, pet.petAge);
//	  }
//
//	  @Override
//	  public int hashCode() {
//	    return Objects.hash(petId, petType, petName, petAge);
//	  }
//
//	  @Override
//	  public String toString() {
//	    StringBuilder sb = new StringBuilder();
//	    sb.append("class Pet {\n");
//	    
//	    sb.append("    id: ").append(toIndentedString(petId)).append("\n");
//	    sb.append("    petType: ").append(toIndentedString(petType)).append("\n");
//	    sb.append("    petName: ").append(toIndentedString(petName)).append("\n");
//	    sb.append("    petAge: ").append(toIndentedString(petAge)).append("\n");
//	    sb.append("}");
//	    return sb.toString();
//	  }
//
//	  /**
//	   * Convert the given object to string with each line indented by 4 spaces
//	   * (except the first line).
//	   */
//	  private String toIndentedString(java.lang.Object o) {
//	    if (o == null) {
//	      return "null";
//	    }
//	    return o.toString().replace("\n", "\n    ");
//	  }
}
