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
 * Projector for WindPitchContEmulIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindPitchContEmulIECAggregate
 *
 * @author your_name_here
 */
@Component("windPitchContEmulIEC-entity-projector")
public class WindPitchContEmulIECEntityProjector {

  // core constructor
  public WindPitchContEmulIECEntityProjector(WindPitchContEmulIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindPitchContEmulIEC
   *
   * @param	entity WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC create(WindPitchContEmulIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindPitchContEmulIEC
   *
   * @param	entity WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC update(WindPitchContEmulIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindPitchContEmulIEC
   *
   * @param	id		UUID
   */
  public WindPitchContEmulIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindPitchContEmulIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kdroop
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignKdroop(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kdroop as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kdroop to the parent entity
    // ------------------------------------------
    parentEntity.setKdroop(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdroop
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignKdroop(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdroop on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdroop on the parent entithy
    // ------------------------------------------
    parentEntity.setKdroop(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kipce
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignKipce(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kipce as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kipce to the parent entity
    // ------------------------------------------
    parentEntity.setKipce(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kipce
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignKipce(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kipce on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kipce on the parent entithy
    // ------------------------------------------
    parentEntity.setKipce(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Komegaaero
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignKomegaaero(UUID parentId, PU assignment) {
    LOGGER.info("assigning Komegaaero as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Komegaaero to the parent entity
    // ------------------------------------------
    parentEntity.setKomegaaero(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Komegaaero
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignKomegaaero(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Komegaaero on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Komegaaero on the parent entithy
    // ------------------------------------------
    parentEntity.setKomegaaero(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kppce
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignKppce(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kppce as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kppce to the parent entity
    // ------------------------------------------
    parentEntity.setKppce(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kppce
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignKppce(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kppce on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kppce on the parent entithy
    // ------------------------------------------
    parentEntity.setKppce(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omegaref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignOmegaref(UUID parentId, PU assignment) {
    LOGGER.info("assigning Omegaref as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Omegaref to the parent entity
    // ------------------------------------------
    parentEntity.setOmegaref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omegaref
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignOmegaref(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omegaref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omegaref on the parent entithy
    // ------------------------------------------
    parentEntity.setOmegaref(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignPimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pimax as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pimax to the parent entity
    // ------------------------------------------
    parentEntity.setPimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pimax
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignPimax(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pimax on the parent entithy
    // ------------------------------------------
    parentEntity.setPimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignPimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pimin as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pimin to the parent entity
    // ------------------------------------------
    parentEntity.setPimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pimin
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignPimin(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pimin on the parent entithy
    // ------------------------------------------
    parentEntity.setPimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1 to the parent entity
    // ------------------------------------------
    parentEntity.setT1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignT1(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1 on the parent entithy
    // ------------------------------------------
    parentEntity.setT1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T2 to the parent entity
    // ------------------------------------------
    parentEntity.setT2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T2
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignT2(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T2 on the parent entithy
    // ------------------------------------------
    parentEntity.setT2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpe
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC assignTpe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpe as " + assignment.toString());

    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpe to the parent entity
    // ------------------------------------------
    parentEntity.setTpe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpe
   *
   * @param	parentId		UUID
   * @return	WindPitchContEmulIEC
   */
  public WindPitchContEmulIEC unAssignTpe(UUID parentId) {
    WindPitchContEmulIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpe on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpe on the parent entithy
    // ------------------------------------------
    parentEntity.setTpe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindPitchContEmulIEC via an FindWindPitchContEmulIECQuery
   *
   * @return query FindWindPitchContEmulIECQuery
   */
  @SuppressWarnings("unused")
  public WindPitchContEmulIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindPitchContEmulIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindPitchContEmulIECs
   *
   * @param query FindAllWindPitchContEmulIECQuery
   * @return List<WindPitchContEmulIEC>
   */
  @SuppressWarnings("unused")
  public List<WindPitchContEmulIEC> findAll(FindAllWindPitchContEmulIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindPitchContEmulIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindPitchContEmulIECRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindPitchContEmulIECEntityProjector.class.getName());
}
