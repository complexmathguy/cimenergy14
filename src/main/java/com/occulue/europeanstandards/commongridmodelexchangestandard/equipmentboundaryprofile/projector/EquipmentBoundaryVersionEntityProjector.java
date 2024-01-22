/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for EquipmentBoundaryVersion as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquipmentBoundaryVersionAggregate
 *
 * @author your_name_here
 */
@Component("equipmentBoundaryVersion-entity-projector")
public class EquipmentBoundaryVersionEntityProjector {

  // core constructor
  public EquipmentBoundaryVersionEntityProjector(EquipmentBoundaryVersionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EquipmentBoundaryVersion
   *
   * @param	entity EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion create(EquipmentBoundaryVersion entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EquipmentBoundaryVersion
   *
   * @param	entity EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion update(EquipmentBoundaryVersion entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EquipmentBoundaryVersion
   *
   * @param	id		UUID
   */
  public EquipmentBoundaryVersion delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EquipmentBoundaryVersion entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BaseUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignBaseUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseUML as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseUML to the parent entity
    // ------------------------------------------
    parentEntity.setBaseUML(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseUML
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignBaseUML(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseUML on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseUML on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseUML(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BaseURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignBaseURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseURI as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseURI to the parent entity
    // ------------------------------------------
    parentEntity.setBaseURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseURI
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignBaseURI(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseURI on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Date
   *
   * @param	parentId	UUID
   * @param	assignment 	DateProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignDate(UUID parentId, DateProxy assignment) {
    LOGGER.info("assigning Date as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = DateProxyProjector.find(assignment.getDateProxyId());

    // ------------------------------------------
    // assign the Date to the parent entity
    // ------------------------------------------
    parentEntity.setDate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Date
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignDate(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Date on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Date on the parent entithy
    // ------------------------------------------
    parentEntity.setDate(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a DifferenceModelURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignDifferenceModelURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning DifferenceModelURI as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the DifferenceModelURI to the parent entity
    // ------------------------------------------
    parentEntity.setDifferenceModelURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the DifferenceModelURI
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignDifferenceModelURI(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning DifferenceModelURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the DifferenceModelURI on the parent entithy
    // ------------------------------------------
    parentEntity.setDifferenceModelURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EntsoeUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignEntsoeUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeUML as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeUML to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeUML(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeUML
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignEntsoeUML(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeUML on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeUML on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeUML(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EntsoeURIcore
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignEntsoeURIcore(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURIcore as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeURIcore to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeURIcore(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeURIcore
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignEntsoeURIcore(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeURIcore on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeURIcore on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeURIcore(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EntsoeURIoperation
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignEntsoeURIoperation(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURIoperation as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeURIoperation to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeURIoperation(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeURIoperation
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignEntsoeURIoperation(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeURIoperation on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeURIoperation on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeURIoperation(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ModelDescriptionURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignModelDescriptionURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ModelDescriptionURI as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ModelDescriptionURI to the parent entity
    // ------------------------------------------
    parentEntity.setModelDescriptionURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ModelDescriptionURI
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignModelDescriptionURI(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ModelDescriptionURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ModelDescriptionURI on the parent entithy
    // ------------------------------------------
    parentEntity.setModelDescriptionURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NamespaceRDF
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignNamespaceRDF(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceRDF as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the NamespaceRDF to the parent entity
    // ------------------------------------------
    parentEntity.setNamespaceRDF(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NamespaceRDF
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignNamespaceRDF(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NamespaceRDF on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NamespaceRDF on the parent entithy
    // ------------------------------------------
    parentEntity.setNamespaceRDF(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NamespaceUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignNamespaceUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceUML as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the NamespaceUML to the parent entity
    // ------------------------------------------
    parentEntity.setNamespaceUML(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NamespaceUML
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignNamespaceUML(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NamespaceUML on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NamespaceUML on the parent entithy
    // ------------------------------------------
    parentEntity.setNamespaceUML(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ShortName
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion assignShortName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ShortName as " + assignment.toString());

    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ShortName to the parent entity
    // ------------------------------------------
    parentEntity.setShortName(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ShortName
   *
   * @param	parentId		UUID
   * @return	EquipmentBoundaryVersion
   */
  public EquipmentBoundaryVersion unAssignShortName(UUID parentId) {
    EquipmentBoundaryVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ShortName on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ShortName on the parent entithy
    // ------------------------------------------
    parentEntity.setShortName(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EquipmentBoundaryVersion via an FindEquipmentBoundaryVersionQuery
   *
   * @return query FindEquipmentBoundaryVersionQuery
   */
  @SuppressWarnings("unused")
  public EquipmentBoundaryVersion find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a EquipmentBoundaryVersion - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EquipmentBoundaryVersions
   *
   * @param query FindAllEquipmentBoundaryVersionQuery
   * @return List<EquipmentBoundaryVersion>
   */
  @SuppressWarnings("unused")
  public List<EquipmentBoundaryVersion> findAll(FindAllEquipmentBoundaryVersionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all EquipmentBoundaryVersion - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquipmentBoundaryVersionRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  @Autowired
  @Qualifier(value = "dateProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DateProxyEntityProjector
      DateProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(EquipmentBoundaryVersionEntityProjector.class.getName());
}
