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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TextDiagramObject as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TextDiagramObjectAggregate
 *
 * @author your_name_here
 */
@Component("textDiagramObject-entity-projector")
public class TextDiagramObjectEntityProjector {

  // core constructor
  public TextDiagramObjectEntityProjector(TextDiagramObjectRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TextDiagramObject
   *
   * @param	entity TextDiagramObject
   */
  public TextDiagramObject create(TextDiagramObject entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TextDiagramObject
   *
   * @param	entity TextDiagramObject
   */
  public TextDiagramObject update(TextDiagramObject entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TextDiagramObject
   *
   * @param	id		UUID
   */
  public TextDiagramObject delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TextDiagramObject entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Text
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	TextDiagramObject
   */
  public TextDiagramObject assignText(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning Text as " + assignment.toString());

    TextDiagramObject parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the Text to the parent entity
    // ------------------------------------------
    parentEntity.setText(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Text
   *
   * @param	parentId		UUID
   * @return	TextDiagramObject
   */
  public TextDiagramObject unAssignText(UUID parentId) {
    TextDiagramObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Text on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Text on the parent entithy
    // ------------------------------------------
    parentEntity.setText(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TextDiagramObject via an FindTextDiagramObjectQuery
   *
   * @return query FindTextDiagramObjectQuery
   */
  @SuppressWarnings("unused")
  public TextDiagramObject find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TextDiagramObject - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TextDiagramObjects
   *
   * @param query FindAllTextDiagramObjectQuery
   * @return List<TextDiagramObject>
   */
  @SuppressWarnings("unused")
  public List<TextDiagramObject> findAll(FindAllTextDiagramObjectQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TextDiagramObject - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TextDiagramObjectRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(TextDiagramObjectEntityProjector.class.getName());
}
