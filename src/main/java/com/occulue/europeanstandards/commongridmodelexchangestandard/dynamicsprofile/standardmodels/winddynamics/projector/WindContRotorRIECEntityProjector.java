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
 * Projector for WindContRotorRIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindContRotorRIECAggregate
 *
 * @author your_name_here
 */
@Component("windContRotorRIEC-entity-projector")
public class WindContRotorRIECEntityProjector {

  // core constructor
  public WindContRotorRIECEntityProjector(WindContRotorRIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindContRotorRIEC
   *
   * @param	entity WindContRotorRIEC
   */
  public WindContRotorRIEC create(WindContRotorRIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindContRotorRIEC
   *
   * @param	entity WindContRotorRIEC
   */
  public WindContRotorRIEC update(WindContRotorRIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindContRotorRIEC
   *
   * @param	id		UUID
   */
  public WindContRotorRIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindContRotorRIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kirr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignKirr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kirr as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kirr to the parent entity
    // ------------------------------------------
    parentEntity.setKirr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kirr
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignKirr(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kirr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kirr on the parent entithy
    // ------------------------------------------
    parentEntity.setKirr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Komegafilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignKomegafilt(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Komegafilt as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Komegafilt to the parent entity
    // ------------------------------------------
    parentEntity.setKomegafilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Komegafilt
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignKomegafilt(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Komegafilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Komegafilt on the parent entithy
    // ------------------------------------------
    parentEntity.setKomegafilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpfilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignKpfilt(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpfilt as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kpfilt to the parent entity
    // ------------------------------------------
    parentEntity.setKpfilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpfilt
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignKpfilt(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpfilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpfilt on the parent entithy
    // ------------------------------------------
    parentEntity.setKpfilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kprr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignKprr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kprr as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kprr to the parent entity
    // ------------------------------------------
    parentEntity.setKprr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kprr
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignKprr(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kprr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kprr on the parent entithy
    // ------------------------------------------
    parentEntity.setKprr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignRmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rmax as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rmax to the parent entity
    // ------------------------------------------
    parentEntity.setRmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rmax
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignRmax(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rmax on the parent entithy
    // ------------------------------------------
    parentEntity.setRmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignRmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rmin as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rmin to the parent entity
    // ------------------------------------------
    parentEntity.setRmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rmin
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignRmin(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rmin on the parent entithy
    // ------------------------------------------
    parentEntity.setRmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tomegafilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignTomegafilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tomegafilt as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tomegafilt to the parent entity
    // ------------------------------------------
    parentEntity.setTomegafilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tomegafilt
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignTomegafilt(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tomegafilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tomegafilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTomegafilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpfilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC assignTpfilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpfilt as " + assignment.toString());

    WindContRotorRIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpfilt to the parent entity
    // ------------------------------------------
    parentEntity.setTpfilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpfilt
   *
   * @param	parentId		UUID
   * @return	WindContRotorRIEC
   */
  public WindContRotorRIEC unAssignTpfilt(UUID parentId) {
    WindContRotorRIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpfilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpfilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTpfilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindContRotorRIEC via an FindWindContRotorRIECQuery
   *
   * @return query FindWindContRotorRIECQuery
   */
  @SuppressWarnings("unused")
  public WindContRotorRIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindContRotorRIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindContRotorRIECs
   *
   * @param query FindAllWindContRotorRIECQuery
   * @return List<WindContRotorRIEC>
   */
  @SuppressWarnings("unused")
  public List<WindContRotorRIEC> findAll(FindAllWindContRotorRIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindContRotorRIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindContRotorRIECRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindContRotorRIECEntityProjector.class.getName());
}
