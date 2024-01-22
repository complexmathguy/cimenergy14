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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for VsConverter as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VsConverterAggregate
 *
 * @author your_name_here
 */
@Component("vsConverter-entity-projector")
public class VsConverterEntityProjector {

  // core constructor
  public VsConverterEntityProjector(VsConverterRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VsConverter
   *
   * @param	entity VsConverter
   */
  public VsConverter create(VsConverter entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VsConverter
   *
   * @param	entity VsConverter
   */
  public VsConverter update(VsConverter entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VsConverter
   *
   * @param	id		UUID
   */
  public VsConverter delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VsConverter entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a MaxModulationIndex
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	VsConverter
   */
  public VsConverter assignMaxModulationIndex(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MaxModulationIndex as " + assignment.toString());

    VsConverter parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MaxModulationIndex to the parent entity
    // ------------------------------------------
    parentEntity.setMaxModulationIndex(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxModulationIndex
   *
   * @param	parentId		UUID
   * @return	VsConverter
   */
  public VsConverter unAssignMaxModulationIndex(UUID parentId) {
    VsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxModulationIndex on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxModulationIndex on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxModulationIndex(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxValveCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	VsConverter
   */
  public VsConverter assignMaxValveCurrent(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning MaxValveCurrent as " + assignment.toString());

    VsConverter parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the MaxValveCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setMaxValveCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxValveCurrent
   *
   * @param	parentId		UUID
   * @return	VsConverter
   */
  public VsConverter unAssignMaxValveCurrent(UUID parentId) {
    VsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxValveCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxValveCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxValveCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the VsConverterDCSides
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	VsConverter
   */
  public VsConverter addToVsConverterDCSides(UUID parentId, VsConverter addTo) {
    LOGGER.info("handling AssignVsConverterDCSidesToVsConverterEvent - ");

    VsConverter parentEntity = repository.findById(parentId).get();
    VsConverter child = VsConverterProjector.find(addTo.getVsConverterId());

    parentEntity.getVsConverterDCSides().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the VsConverterDCSides
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	VsConverter
   */
  public VsConverter removeFromVsConverterDCSides(UUID parentId, VsConverter removeFrom) {
    LOGGER.info("handling RemoveVsConverterDCSidesFromVsConverterEvent ");

    VsConverter parentEntity = repository.findById(parentId).get();
    VsConverter child = VsConverterProjector.find(removeFrom.getVsConverterId());

    parentEntity.getVsConverterDCSides().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VsConverter via an FindVsConverterQuery
   *
   * @return query FindVsConverterQuery
   */
  @SuppressWarnings("unused")
  public VsConverter find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a VsConverter - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VsConverters
   *
   * @param query FindAllVsConverterQuery
   * @return List<VsConverter>
   */
  @SuppressWarnings("unused")
  public List<VsConverter> findAll(FindAllVsConverterQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all VsConverter - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VsConverterRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  @Autowired
  @Qualifier(value = "vsConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .VsConverterEntityProjector
      VsConverterProjector;

  private static final Logger LOGGER = Logger.getLogger(VsConverterEntityProjector.class.getName());
}
