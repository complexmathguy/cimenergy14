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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DomainVersion as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DomainVersionAggregate
 *
 * @author your_name_here
 */
@Component("domainVersion-entity-projector")
public class DomainVersionEntityProjector {

  // core constructor
  public DomainVersionEntityProjector(DomainVersionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DomainVersion
   *
   * @param	entity DomainVersion
   */
  public DomainVersion create(DomainVersion entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DomainVersion
   *
   * @param	entity DomainVersion
   */
  public DomainVersion update(DomainVersion entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DomainVersion
   *
   * @param	id		UUID
   */
  public DomainVersion delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DomainVersion entity = repository.findById(id).get();

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
   * @return	DomainVersion
   */
  public DomainVersion assignBaseUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning BaseUML as " + assignment.toString());

    DomainVersion parentEntity = repository.findById(parentId).get();
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
   * @return	DomainVersion
   */
  public DomainVersion unAssignBaseUML(UUID parentId) {
    DomainVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a Date
   *
   * @param	parentId	UUID
   * @param	assignment 	DateProxy
   * @return	DomainVersion
   */
  public DomainVersion assignDate(UUID parentId, DateProxy assignment) {
    LOGGER.info("assigning Date as " + assignment.toString());

    DomainVersion parentEntity = repository.findById(parentId).get();
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
   * @return	DomainVersion
   */
  public DomainVersion unAssignDate(UUID parentId) {
    DomainVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a EntsoeUML
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	DomainVersion
   */
  public DomainVersion assignEntsoeUML(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EntsoeUML as " + assignment.toString());

    DomainVersion parentEntity = repository.findById(parentId).get();
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
   * @return	DomainVersion
   */
  public DomainVersion unAssignEntsoeUML(UUID parentId) {
    DomainVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a Version
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	DomainVersion
   */
  public DomainVersion assignVersion(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning Version as " + assignment.toString());

    DomainVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the Version to the parent entity
    // ------------------------------------------
    parentEntity.setVersion(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Version
   *
   * @param	parentId		UUID
   * @return	DomainVersion
   */
  public DomainVersion unAssignVersion(UUID parentId) {
    DomainVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Version on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Version on the parent entithy
    // ------------------------------------------
    parentEntity.setVersion(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DomainVersion via an FindDomainVersionQuery
   *
   * @return query FindDomainVersionQuery
   */
  @SuppressWarnings("unused")
  public DomainVersion find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DomainVersion - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DomainVersions
   *
   * @param query FindAllDomainVersionQuery
   * @return List<DomainVersion>
   */
  @SuppressWarnings("unused")
  public List<DomainVersion> findAll(FindAllDomainVersionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DomainVersion - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DomainVersionRepository repository;

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
      Logger.getLogger(DomainVersionEntityProjector.class.getName());
}
