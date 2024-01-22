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
 * Projector for VisibilityLayer as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VisibilityLayerAggregate
 *
 * @author your_name_here
 */
@Component("visibilityLayer-entity-projector")
public class VisibilityLayerEntityProjector {

  // core constructor
  public VisibilityLayerEntityProjector(VisibilityLayerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VisibilityLayer
   *
   * @param	entity VisibilityLayer
   */
  public VisibilityLayer create(VisibilityLayer entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VisibilityLayer
   *
   * @param	entity VisibilityLayer
   */
  public VisibilityLayer update(VisibilityLayer entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VisibilityLayer
   *
   * @param	id		UUID
   */
  public VisibilityLayer delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VisibilityLayer entity = repository.findById(id).get();

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
   * @return	VisibilityLayer
   */
  public VisibilityLayer assignDrawingOrder(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning DrawingOrder as " + assignment.toString());

    VisibilityLayer parentEntity = repository.findById(parentId).get();
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
   * @return	VisibilityLayer
   */
  public VisibilityLayer unAssignDrawingOrder(UUID parentId) {
    VisibilityLayer parentEntity = repository.findById(parentId).get();

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
   * Add to the VisibilityLayers
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	VisibilityLayer
   */
  public VisibilityLayer addToVisibilityLayers(UUID parentId, VisibilityLayer addTo) {
    LOGGER.info("handling AssignVisibilityLayersToVisibilityLayerEvent - ");

    VisibilityLayer parentEntity = repository.findById(parentId).get();
    VisibilityLayer child = VisibilityLayerProjector.find(addTo.getVisibilityLayerId());

    parentEntity.getVisibilityLayers().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the VisibilityLayers
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	VisibilityLayer
   */
  public VisibilityLayer removeFromVisibilityLayers(UUID parentId, VisibilityLayer removeFrom) {
    LOGGER.info("handling RemoveVisibilityLayersFromVisibilityLayerEvent ");

    VisibilityLayer parentEntity = repository.findById(parentId).get();
    VisibilityLayer child = VisibilityLayerProjector.find(removeFrom.getVisibilityLayerId());

    parentEntity.getVisibilityLayers().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VisibilityLayer via an FindVisibilityLayerQuery
   *
   * @return query FindVisibilityLayerQuery
   */
  @SuppressWarnings("unused")
  public VisibilityLayer find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a VisibilityLayer - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VisibilityLayers
   *
   * @param query FindAllVisibilityLayerQuery
   * @return List<VisibilityLayer>
   */
  @SuppressWarnings("unused")
  public List<VisibilityLayer> findAll(FindAllVisibilityLayerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all VisibilityLayer - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VisibilityLayerRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "visibilityLayer-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout
          .projector.VisibilityLayerEntityProjector
      VisibilityLayerProjector;

  private static final Logger LOGGER =
      Logger.getLogger(VisibilityLayerEntityProjector.class.getName());
}
