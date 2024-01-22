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
 * Projector for DiagramObject as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiagramObjectAggregate
 *
 * @author your_name_here
 */
@Component("diagramObject-entity-projector")
public class DiagramObjectEntityProjector {

  // core constructor
  public DiagramObjectEntityProjector(DiagramObjectRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiagramObject
   *
   * @param	entity DiagramObject
   */
  public DiagramObject create(DiagramObject entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiagramObject
   *
   * @param	entity DiagramObject
   */
  public DiagramObject update(DiagramObject entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiagramObject
   *
   * @param	id		UUID
   */
  public DiagramObject delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiagramObject entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a DrawingOrder
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	DiagramObject
   */
  public DiagramObject assignDrawingOrder(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning DrawingOrder as " + assignment.toString());

    DiagramObject parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the DrawingOrder to the parent entity
    // ------------------------------------------
    parentEntity.setDrawingOrder(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the DrawingOrder
   *
   * @param	parentId		UUID
   * @return	DiagramObject
   */
  public DiagramObject unAssignDrawingOrder(UUID parentId) {
    DiagramObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning DrawingOrder on " + parentEntity.toString());

    // ------------------------------------------
    // null out the DrawingOrder on the parent entithy
    // ------------------------------------------
    parentEntity.setDrawingOrder(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PolygonFlag
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	DiagramObject
   */
  public DiagramObject assignPolygonFlag(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning PolygonFlag as " + assignment.toString());

    DiagramObject parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the PolygonFlag to the parent entity
    // ------------------------------------------
    parentEntity.setPolygonFlag(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PolygonFlag
   *
   * @param	parentId		UUID
   * @return	DiagramObject
   */
  public DiagramObject unAssignPolygonFlag(UUID parentId) {
    DiagramObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PolygonFlag on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PolygonFlag on the parent entithy
    // ------------------------------------------
    parentEntity.setPolygonFlag(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OffsetX
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	DiagramObject
   */
  public DiagramObject assignOffsetX(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning OffsetX as " + assignment.toString());

    DiagramObject parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the OffsetX to the parent entity
    // ------------------------------------------
    parentEntity.setOffsetX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OffsetX
   *
   * @param	parentId		UUID
   * @return	DiagramObject
   */
  public DiagramObject unAssignOffsetX(UUID parentId) {
    DiagramObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OffsetX on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OffsetX on the parent entithy
    // ------------------------------------------
    parentEntity.setOffsetX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OffsetY
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	DiagramObject
   */
  public DiagramObject assignOffsetY(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning OffsetY as " + assignment.toString());

    DiagramObject parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the OffsetY to the parent entity
    // ------------------------------------------
    parentEntity.setOffsetY(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OffsetY
   *
   * @param	parentId		UUID
   * @return	DiagramObject
   */
  public DiagramObject unAssignOffsetY(UUID parentId) {
    DiagramObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OffsetY on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OffsetY on the parent entithy
    // ------------------------------------------
    parentEntity.setOffsetY(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rotation
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	DiagramObject
   */
  public DiagramObject assignRotation(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Rotation as " + assignment.toString());

    DiagramObject parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the Rotation to the parent entity
    // ------------------------------------------
    parentEntity.setRotation(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rotation
   *
   * @param	parentId		UUID
   * @return	DiagramObject
   */
  public DiagramObject unAssignRotation(UUID parentId) {
    DiagramObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rotation on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rotation on the parent entithy
    // ------------------------------------------
    parentEntity.setRotation(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the StyledObjects
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DiagramObject
   */
  public DiagramObject addToStyledObjects(UUID parentId, DiagramObject addTo) {
    LOGGER.info("handling AssignStyledObjectsToDiagramObjectEvent - ");

    DiagramObject parentEntity = repository.findById(parentId).get();
    DiagramObject child = DiagramObjectProjector.find(addTo.getDiagramObjectId());

    parentEntity.getStyledObjects().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the StyledObjects
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DiagramObject
   */
  public DiagramObject removeFromStyledObjects(UUID parentId, DiagramObject removeFrom) {
    LOGGER.info("handling RemoveStyledObjectsFromDiagramObjectEvent ");

    DiagramObject parentEntity = repository.findById(parentId).get();
    DiagramObject child = DiagramObjectProjector.find(removeFrom.getDiagramObjectId());

    parentEntity.getStyledObjects().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the DiagramElements
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DiagramObject
   */
  public DiagramObject addToDiagramElements(UUID parentId, DiagramObject addTo) {
    LOGGER.info("handling AssignDiagramElementsToDiagramObjectEvent - ");

    DiagramObject parentEntity = repository.findById(parentId).get();
    DiagramObject child = DiagramObjectProjector.find(addTo.getDiagramObjectId());

    parentEntity.getDiagramElements().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DiagramElements
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DiagramObject
   */
  public DiagramObject removeFromDiagramElements(UUID parentId, DiagramObject removeFrom) {
    LOGGER.info("handling RemoveDiagramElementsFromDiagramObjectEvent ");

    DiagramObject parentEntity = repository.findById(parentId).get();
    DiagramObject child = DiagramObjectProjector.find(removeFrom.getDiagramObjectId());

    parentEntity.getDiagramElements().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the DiagramObjects
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DiagramObject
   */
  public DiagramObject addToDiagramObjects(UUID parentId, DiagramObject addTo) {
    LOGGER.info("handling AssignDiagramObjectsToDiagramObjectEvent - ");

    DiagramObject parentEntity = repository.findById(parentId).get();
    DiagramObject child = DiagramObjectProjector.find(addTo.getDiagramObjectId());

    parentEntity.getDiagramObjects().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DiagramObjects
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DiagramObject
   */
  public DiagramObject removeFromDiagramObjects(UUID parentId, DiagramObject removeFrom) {
    LOGGER.info("handling RemoveDiagramObjectsFromDiagramObjectEvent ");

    DiagramObject parentEntity = repository.findById(parentId).get();
    DiagramObject child = DiagramObjectProjector.find(removeFrom.getDiagramObjectId());

    parentEntity.getDiagramObjects().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiagramObject via an FindDiagramObjectQuery
   *
   * @return query FindDiagramObjectQuery
   */
  @SuppressWarnings("unused")
  public DiagramObject find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DiagramObject - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiagramObjects
   *
   * @param query FindAllDiagramObjectQuery
   * @return List<DiagramObject>
   */
  @SuppressWarnings("unused")
  public List<DiagramObject> findAll(FindAllDiagramObjectQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DiagramObject - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiagramObjectRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  @Autowired
  @Qualifier(value = "diagramObject-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .projector.DiagramObjectEntityProjector
      DiagramObjectProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DiagramObjectEntityProjector.class.getName());
}
