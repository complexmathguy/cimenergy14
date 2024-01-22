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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for EquipmentVersion as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquipmentVersionAggregate
 *
 * @author your_name_here
 */
@Component("equipmentVersion-entity-projector")
public class EquipmentVersionEntityProjector {

  // core constructor
  public EquipmentVersionEntityProjector(EquipmentVersionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EquipmentVersion
   *
   * @param	entity EquipmentVersion
   */
  public EquipmentVersion create(EquipmentVersion entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EquipmentVersion
   *
   * @param	entity EquipmentVersion
   */
  public EquipmentVersion update(EquipmentVersion entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EquipmentVersion
   *
   * @param	id		UUID
   */
  public EquipmentVersion delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EquipmentVersion entity = repository.findById(id).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignBaseUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseUML as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignBaseUML(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a BaseURIcore
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignBaseURIcore(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseURIcore as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseURIcore to the parent entity
    // ------------------------------------------
    parentEntity.setBaseURIcore(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseURIcore
   *
   * @param	parentId		UUID
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignBaseURIcore(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseURIcore on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseURIcore on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseURIcore(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BaseURIoperation
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignBaseURIoperation(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseURIoperation as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseURIoperation to the parent entity
    // ------------------------------------------
    parentEntity.setBaseURIoperation(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseURIoperation
   *
   * @param	parentId		UUID
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignBaseURIoperation(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseURIoperation on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseURIoperation on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseURIoperation(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BaseURIshortCircuit
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignBaseURIshortCircuit(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseURIshortCircuit as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the BaseURIshortCircuit to the parent entity
    // ------------------------------------------
    parentEntity.setBaseURIshortCircuit(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseURIshortCircuit
   *
   * @param	parentId		UUID
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignBaseURIshortCircuit(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseURIshortCircuit on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseURIshortCircuit on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseURIshortCircuit(null);

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignDate(UUID parentId, DateProxy assignment) {
    LOGGER.info("assigning Date as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignDate(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignDifferenceModelURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning DifferenceModelURI as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignDifferenceModelURI(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignEntsoeUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeUML as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignEntsoeUML(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignEntsoeURIcore(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURIcore as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignEntsoeURIcore(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignEntsoeURIoperation(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURIoperation as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignEntsoeURIoperation(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a EntsoeURIshortCircuit
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignEntsoeURIshortCircuit(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURIshortCircuit as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeURIshortCircuit to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeURIshortCircuit(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeURIshortCircuit
   *
   * @param	parentId		UUID
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignEntsoeURIshortCircuit(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeURIshortCircuit on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeURIshortCircuit on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeURIshortCircuit(null);

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignModelDescriptionURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ModelDescriptionURI as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignModelDescriptionURI(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignNamespaceRDF(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceRDF as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignNamespaceRDF(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignNamespaceUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceUML as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignNamespaceUML(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * @return	EquipmentVersion
   */
  public EquipmentVersion assignShortName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ShortName as " + assignment.toString());

    EquipmentVersion parentEntity = repository.findById(parentId).get();
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
   * @return	EquipmentVersion
   */
  public EquipmentVersion unAssignShortName(UUID parentId) {
    EquipmentVersion parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the EquipmentVersion via an FindEquipmentVersionQuery
   *
   * @return query FindEquipmentVersionQuery
   */
  @SuppressWarnings("unused")
  public EquipmentVersion find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EquipmentVersion - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EquipmentVersions
   *
   * @param query FindAllEquipmentVersionQuery
   * @return List<EquipmentVersion>
   */
  @SuppressWarnings("unused")
  public List<EquipmentVersion> findAll(FindAllEquipmentVersionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EquipmentVersion - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquipmentVersionRepository repository;

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
      Logger.getLogger(EquipmentVersionEntityProjector.class.getName());
}
