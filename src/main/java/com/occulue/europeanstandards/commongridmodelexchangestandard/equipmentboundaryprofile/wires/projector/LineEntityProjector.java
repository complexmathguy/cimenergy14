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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Line as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LineAggregate
 *
 * @author your_name_here
 */
@Component("line-entity-projector")
public class LineEntityProjector {

  // core constructor
  public LineEntityProjector(LineRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Line
   *
   * @param	entity Line
   */
  public Line create(Line entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Line
   *
   * @param	entity Line
   */
  public Line update(Line entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Line
   *
   * @param	id		UUID
   */
  public Line delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Line entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the Lines
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Line
   */
  public Line addToLines(UUID parentId, Line addTo) {
    LOGGER.info("handling AssignLinesToLineEvent - ");

    Line parentEntity = repository.findById(parentId).get();
    Line child = LineProjector.find(addTo.getLineId());

    parentEntity.getLines().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Lines
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Line
   */
  public Line removeFromLines(UUID parentId, Line removeFrom) {
    LOGGER.info("handling RemoveLinesFromLineEvent ");

    Line parentEntity = repository.findById(parentId).get();
    Line child = LineProjector.find(removeFrom.getLineId());

    parentEntity.getLines().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Line via an FindLineQuery
   *
   * @return query FindLineQuery
   */
  @SuppressWarnings("unused")
  public Line find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Line - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Lines
   *
   * @param query FindAllLineQuery
   * @return List<Line>
   */
  @SuppressWarnings("unused")
  public List<Line> findAll(FindAllLineQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Line - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LineRepository repository;

  @Autowired
  @Qualifier(value = "line-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires
          .projector.LineEntityProjector
      LineProjector;

  private static final Logger LOGGER = Logger.getLogger(LineEntityProjector.class.getName());
}
