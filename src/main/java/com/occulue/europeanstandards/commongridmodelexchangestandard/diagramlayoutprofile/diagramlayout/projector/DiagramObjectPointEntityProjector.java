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
 * Projector for DiagramObjectPoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiagramObjectPointAggregate
 *
 * @author your_name_here
 */
@Component("diagramObjectPoint-entity-projector")
public class DiagramObjectPointEntityProjector {

  // core constructor
  public DiagramObjectPointEntityProjector(DiagramObjectPointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiagramObjectPoint
   *
   * @param	entity DiagramObjectPoint
   */
  public DiagramObjectPoint create(DiagramObjectPoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiagramObjectPoint
   *
   * @param	entity DiagramObjectPoint
   */
  public DiagramObjectPoint update(DiagramObjectPoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiagramObjectPoint
   *
   * @param	id		UUID
   */
  public DiagramObjectPoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiagramObjectPoint entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a SequenceNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint assignSequenceNumber(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning SequenceNumber as " + assignment.toString());

    DiagramObjectPoint parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the SequenceNumber to the parent entity
    // ------------------------------------------
    parentEntity.setSequenceNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SequenceNumber
   *
   * @param	parentId		UUID
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint unAssignSequenceNumber(UUID parentId) {
    DiagramObjectPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SequenceNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SequenceNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setSequenceNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XPosition
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint assignXPosition(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning XPosition as " + assignment.toString());

    DiagramObjectPoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the XPosition to the parent entity
    // ------------------------------------------
    parentEntity.setXPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XPosition
   *
   * @param	parentId		UUID
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint unAssignXPosition(UUID parentId) {
    DiagramObjectPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XPosition on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XPosition on the parent entithy
    // ------------------------------------------
    parentEntity.setXPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a YPosition
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint assignYPosition(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning YPosition as " + assignment.toString());

    DiagramObjectPoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the YPosition to the parent entity
    // ------------------------------------------
    parentEntity.setYPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the YPosition
   *
   * @param	parentId		UUID
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint unAssignYPosition(UUID parentId) {
    DiagramObjectPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning YPosition on " + parentEntity.toString());

    // ------------------------------------------
    // null out the YPosition on the parent entithy
    // ------------------------------------------
    parentEntity.setYPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ZPosition
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint assignZPosition(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning ZPosition as " + assignment.toString());

    DiagramObjectPoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the ZPosition to the parent entity
    // ------------------------------------------
    parentEntity.setZPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ZPosition
   *
   * @param	parentId		UUID
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint unAssignZPosition(UUID parentId) {
    DiagramObjectPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ZPosition on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ZPosition on the parent entithy
    // ------------------------------------------
    parentEntity.setZPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the DiagramObjectPoints
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint addToDiagramObjectPoints(UUID parentId, DiagramObjectPoint addTo) {
    LOGGER.info("handling AssignDiagramObjectPointsToDiagramObjectPointEvent - ");

    DiagramObjectPoint parentEntity = repository.findById(parentId).get();
    DiagramObjectPoint child = DiagramObjectPointProjector.find(addTo.getDiagramObjectPointId());

    parentEntity.getDiagramObjectPoints().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DiagramObjectPoints
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DiagramObjectPoint
   */
  public DiagramObjectPoint removeFromDiagramObjectPoints(
      UUID parentId, DiagramObjectPoint removeFrom) {
    LOGGER.info("handling RemoveDiagramObjectPointsFromDiagramObjectPointEvent ");

    DiagramObjectPoint parentEntity = repository.findById(parentId).get();
    DiagramObjectPoint child =
        DiagramObjectPointProjector.find(removeFrom.getDiagramObjectPointId());

    parentEntity.getDiagramObjectPoints().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiagramObjectPoint via an FindDiagramObjectPointQuery
   *
   * @return query FindDiagramObjectPointQuery
   */
  @SuppressWarnings("unused")
  public DiagramObjectPoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DiagramObjectPoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiagramObjectPoints
   *
   * @param query FindAllDiagramObjectPointQuery
   * @return List<DiagramObjectPoint>
   */
  @SuppressWarnings("unused")
  public List<DiagramObjectPoint> findAll(FindAllDiagramObjectPointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DiagramObjectPoint - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiagramObjectPointRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "diagramObjectPoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .projector.DiagramObjectPointEntityProjector
      DiagramObjectPointProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DiagramObjectPointEntityProjector.class.getName());
}
