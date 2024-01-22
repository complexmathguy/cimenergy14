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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindDynamicsLookupTable as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindDynamicsLookupTableAggregate
 *
 * @author your_name_here
 */
@Component("windDynamicsLookupTable-entity-projector")
public class WindDynamicsLookupTableEntityProjector {

  // core constructor
  public WindDynamicsLookupTableEntityProjector(WindDynamicsLookupTableRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindDynamicsLookupTable
   *
   * @param	entity WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable create(WindDynamicsLookupTable entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindDynamicsLookupTable
   *
   * @param	entity WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable update(WindDynamicsLookupTable entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindDynamicsLookupTable
   *
   * @param	id		UUID
   */
  public WindDynamicsLookupTable delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindDynamicsLookupTable entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Input
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable assignInput(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Input as " + assignment.toString());

    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Input to the parent entity
    // ------------------------------------------
    parentEntity.setInput(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Input
   *
   * @param	parentId		UUID
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable unAssignInput(UUID parentId) {
    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Input on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Input on the parent entithy
    // ------------------------------------------
    parentEntity.setInput(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Output
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable assignOutput(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Output as " + assignment.toString());

    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Output to the parent entity
    // ------------------------------------------
    parentEntity.setOutput(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Output
   *
   * @param	parentId		UUID
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable unAssignOutput(UUID parentId) {
    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Output on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Output on the parent entithy
    // ------------------------------------------
    parentEntity.setOutput(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Sequence
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable assignSequence(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Sequence as " + assignment.toString());

    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the Sequence to the parent entity
    // ------------------------------------------
    parentEntity.setSequence(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Sequence
   *
   * @param	parentId		UUID
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable unAssignSequence(UUID parentId) {
    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Sequence on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Sequence on the parent entithy
    // ------------------------------------------
    parentEntity.setSequence(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the WindDynamicsLookupTable
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable addToWindDynamicsLookupTable(
      UUID parentId, WindDynamicsLookupTable addTo) {
    LOGGER.info("handling AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent - ");

    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();
    WindDynamicsLookupTable child =
        WindDynamicsLookupTableProjector.find(addTo.getWindDynamicsLookupTableId());

    parentEntity.getWindDynamicsLookupTable().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the WindDynamicsLookupTable
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	WindDynamicsLookupTable
   */
  public WindDynamicsLookupTable removeFromWindDynamicsLookupTable(
      UUID parentId, WindDynamicsLookupTable removeFrom) {
    LOGGER.info("handling RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent ");

    WindDynamicsLookupTable parentEntity = repository.findById(parentId).get();
    WindDynamicsLookupTable child =
        WindDynamicsLookupTableProjector.find(removeFrom.getWindDynamicsLookupTableId());

    parentEntity.getWindDynamicsLookupTable().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindDynamicsLookupTable via an FindWindDynamicsLookupTableQuery
   *
   * @return query FindWindDynamicsLookupTableQuery
   */
  @SuppressWarnings("unused")
  public WindDynamicsLookupTable find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindDynamicsLookupTable - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindDynamicsLookupTables
   *
   * @param query FindAllWindDynamicsLookupTableQuery
   * @return List<WindDynamicsLookupTable>
   */
  @SuppressWarnings("unused")
  public List<WindDynamicsLookupTable> findAll(FindAllWindDynamicsLookupTableQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindDynamicsLookupTable - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindDynamicsLookupTableRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "windDynamicsLookupTable-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindDynamicsLookupTableEntityProjector
      WindDynamicsLookupTableProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindDynamicsLookupTableEntityProjector.class.getName());
}
