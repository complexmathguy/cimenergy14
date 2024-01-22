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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for StateVariablesVersion as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by StateVariablesVersionAggregate
 *
 * @author your_name_here
 */
@Component("stateVariablesVersion-entity-projector")
public class StateVariablesVersionEntityProjector {

  // core constructor
  public StateVariablesVersionEntityProjector(StateVariablesVersionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a StateVariablesVersion
   *
   * @param	entity StateVariablesVersion
   */
  public StateVariablesVersion create(StateVariablesVersion entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a StateVariablesVersion
   *
   * @param	entity StateVariablesVersion
   */
  public StateVariablesVersion update(StateVariablesVersion entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a StateVariablesVersion
   *
   * @param	id		UUID
   */
  public StateVariablesVersion delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    StateVariablesVersion entity = repository.findById(id).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignBaseUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseUML as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignBaseUML(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignBaseURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseURI as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignBaseURI(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignDate(UUID parentId, DateProxy assignment) {
    LOGGER.info("assigning Date as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignDate(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignDifferenceModelURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning DifferenceModelURI as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignDifferenceModelURI(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignEntsoeUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeUML as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignEntsoeUML(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a EntsoeURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignEntsoeURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeURI as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EntsoeURI to the parent entity
    // ------------------------------------------
    parentEntity.setEntsoeURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EntsoeURI
   *
   * @param	parentId		UUID
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignEntsoeURI(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EntsoeURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EntsoeURI on the parent entithy
    // ------------------------------------------
    parentEntity.setEntsoeURI(null);

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignModelDescriptionURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ModelDescriptionURI as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignModelDescriptionURI(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignNamespaceRDF(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceRDF as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignNamespaceRDF(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignNamespaceUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceUML as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignNamespaceUML(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion assignShortName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ShortName as " + assignment.toString());

    StateVariablesVersion parentEntity = repository.findById(parentId).get();
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
   * @return	StateVariablesVersion
   */
  public StateVariablesVersion unAssignShortName(UUID parentId) {
    StateVariablesVersion parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the StateVariablesVersion via an FindStateVariablesVersionQuery
   *
   * @return query FindStateVariablesVersionQuery
   */
  @SuppressWarnings("unused")
  public StateVariablesVersion find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a StateVariablesVersion - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all StateVariablesVersions
   *
   * @param query FindAllStateVariablesVersionQuery
   * @return List<StateVariablesVersion>
   */
  @SuppressWarnings("unused")
  public List<StateVariablesVersion> findAll(FindAllStateVariablesVersionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all StateVariablesVersion - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final StateVariablesVersionRepository repository;

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
      Logger.getLogger(StateVariablesVersionEntityProjector.class.getName());
}
