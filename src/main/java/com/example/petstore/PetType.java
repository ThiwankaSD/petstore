package com.example.petstore;

import java.util.Objects;

import javax.validation.Valid;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "PetType")
public class PetType{

  @Schema(required = true, description = "PetType id")
  @JsonProperty("id")
  private Long id = null;

  @Schema(required = true, description = "PetType name")
  @JsonProperty("name")
  private String name = null;


  public PetType id(Long id) {
    this.id = id;
    return this;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public PetType name(String name) {
    this.name = name;
    return this;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

//
//  @Override
//  public boolean equals(java.lang.Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    PetType petType = (PetType) o;
//    return Objects.equals(id, petType.id) &&
//        Objects.equals(name, petType.name);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id, name);
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb.append("class PetType {\n");
//    
//    sb.append("    id: ").append(toIndentedString(id)).append("\n");
//    sb.append("    name: ").append(toIndentedString(name)).append("\n");
//    sb.append("}");
//    return sb.toString();
//  }
//
//  /**
//   * Convert the given object to string with each line indented by 4 spaces
//   * (except the first line).
//   */
//  private String toIndentedString(java.lang.Object o) {
//    if (o == null) {
//      return "null";
//    }
//    return o.toString().replace("\n", "\n    ");
//  }
}
