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
 * Projector for Diagram as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiagramAggregate
 *
 * @author your_name_here
 */
@Component("diagram-entity-projector")
public class DiagramEntityProjector {

  // core constructor
  public DiagramEntityProjector(DiagramRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Diagram
   *
   * @param	entity Diagram
   */
  public Diagram create(Diagram entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Diagram
   *
   * @param	entity Diagram
   */
  public Diagram update(Diagram entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Diagram
   *
   * @param	id		UUID
   */
  public Diagram delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Diagram entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a X1InitialView
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Diagram
   */
  public Diagram assignX1InitialView(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning X1InitialView as " + assignment.toString());

    Diagram parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the X1InitialView to the parent entity
    // ------------------------------------------
    parentEntity.setX1InitialView(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X1InitialView
   *
   * @param	parentId		UUID
   * @return	Diagram
   */
  public Diagram unAssignX1InitialView(UUID parentId) {
    Diagram parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X1InitialView on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X1InitialView on the parent entithy
    // ------------------------------------------
    parentEntity.setX1InitialView(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X2InitialView
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Diagram
   */
  public Diagram assignX2InitialView(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning X2InitialView as " + assignment.toString());

    Diagram parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the X2InitialView to the parent entity
    // ------------------------------------------
    parentEntity.setX2InitialView(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X2InitialView
   *
   * @param	parentId		UUID
   * @return	Diagram
   */
  public Diagram unAssignX2InitialView(UUID parentId) {
    Diagram parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X2InitialView on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X2InitialView on the parent entithy
    // ------------------------------------------
    parentEntity.setX2InitialView(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Y1InitialView
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Diagram
   */
  public Diagram assignY1InitialView(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Y1InitialView as " + assignment.toString());

    Diagram parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Y1InitialView to the parent entity
    // ------------------------------------------
    parentEntity.setY1InitialView(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Y1InitialView
   *
   * @param	parentId		UUID
   * @return	Diagram
   */
  public Diagram unAssignY1InitialView(UUID parentId) {
    Diagram parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Y1InitialView on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Y1InitialView on the parent entithy
    // ------------------------------------------
    parentEntity.setY1InitialView(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Y2InitialView
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Diagram
   */
  public Diagram assignY2InitialView(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Y2InitialView as " + assignment.toString());

    Diagram parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Y2InitialView to the parent entity
    // ------------------------------------------
    parentEntity.setY2InitialView(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Y2InitialView
   *
   * @param	parentId		UUID
   * @return	Diagram
   */
  public Diagram unAssignY2InitialView(UUID parentId) {
    Diagram parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Y2InitialView on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Y2InitialView on the parent entithy
    // ------------------------------------------
    parentEntity.setY2InitialView(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the Diagram
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Diagram
   */
  public Diagram addToDiagram(UUID parentId, Diagram addTo) {
    LOGGER.info("handling AssignDiagramToDiagramEvent - ");

    Diagram parentEntity = repository.findById(parentId).get();
    Diagram child = DiagramProjector.find(addTo.getDiagramId());

    parentEntity.getDiagram().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Diagram
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Diagram
   */
  public Diagram removeFromDiagram(UUID parentId, Diagram removeFrom) {
    LOGGER.info("handling RemoveDiagramFromDiagramEvent ");

    Diagram parentEntity = repository.findById(parentId).get();
    Diagram child = DiagramProjector.find(removeFrom.getDiagramId());

    parentEntity.getDiagram().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Diagram via an FindDiagramQuery
   *
   * @return query FindDiagramQuery
   */
  @SuppressWarnings("unused")
  public Diagram find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Diagram - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Diagrams
   *
   * @param query FindAllDiagramQuery
   * @return List<Diagram>
   */
  @SuppressWarnings("unused")
  public List<Diagram> findAll(FindAllDiagramQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Diagram - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiagramRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "diagram-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .projector.DiagramEntityProjector
      DiagramProjector;

  private static final Logger LOGGER = Logger.getLogger(DiagramEntityProjector.class.getName());
}
