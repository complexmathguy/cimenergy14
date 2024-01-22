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
package com.occulue.europeanstandards.extension.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExtensionVersion as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExtensionVersionAggregate
 *
 * @author your_name_here
 */
@Component("extensionVersion-entity-projector")
public class ExtensionVersionEntityProjector {

  // core constructor
  public ExtensionVersionEntityProjector(ExtensionVersionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExtensionVersion
   *
   * @param	entity ExtensionVersion
   */
  public ExtensionVersion create(ExtensionVersion entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExtensionVersion
   *
   * @param	entity ExtensionVersion
   */
  public ExtensionVersion update(ExtensionVersion entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExtensionVersion
   *
   * @param	id		UUID
   */
  public ExtensionVersion delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExtensionVersion entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Date
   *
   * @param	parentId	UUID
   * @param	assignment 	DateProxy
   * @return	ExtensionVersion
   */
  public ExtensionVersion assignDate(UUID parentId, DateProxy assignment) {
    LOGGER.info("assigning Date as " + assignment.toString());

    ExtensionVersion parentEntity = repository.findById(parentId).get();
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
   * @return	ExtensionVersion
   */
  public ExtensionVersion unAssignDate(UUID parentId) {
    ExtensionVersion parentEntity = repository.findById(parentId).get();

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
   * Assign a NamespaceURI
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	ExtensionVersion
   */
  public ExtensionVersion assignNamespaceURI(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning NamespaceURI as " + assignment.toString());

    ExtensionVersion parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the NamespaceURI to the parent entity
    // ------------------------------------------
    parentEntity.setNamespaceURI(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NamespaceURI
   *
   * @param	parentId		UUID
   * @return	ExtensionVersion
   */
  public ExtensionVersion unAssignNamespaceURI(UUID parentId) {
    ExtensionVersion parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NamespaceURI on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NamespaceURI on the parent entithy
    // ------------------------------------------
    parentEntity.setNamespaceURI(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExtensionVersion via an FindExtensionVersionQuery
   *
   * @return query FindExtensionVersionQuery
   */
  @SuppressWarnings("unused")
  public ExtensionVersion find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExtensionVersion - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExtensionVersions
   *
   * @param query FindAllExtensionVersionQuery
   * @return List<ExtensionVersion>
   */
  @SuppressWarnings("unused")
  public List<ExtensionVersion> findAll(FindAllExtensionVersionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExtensionVersion - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExtensionVersionRepository repository;

  @Autowired
  @Qualifier(value = "dateProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DateProxyEntityProjector
      DateProxyProjector;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ExtensionVersionEntityProjector.class.getName());
}
