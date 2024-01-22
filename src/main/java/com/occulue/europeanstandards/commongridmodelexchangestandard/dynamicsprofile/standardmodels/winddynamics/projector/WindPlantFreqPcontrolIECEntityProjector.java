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
 * Projector for WindPlantFreqPcontrolIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindPlantFreqPcontrolIECAggregate
 *
 * @author your_name_here
 */
@Component("windPlantFreqPcontrolIEC-entity-projector")
public class WindPlantFreqPcontrolIECEntityProjector {

  // core constructor
  public WindPlantFreqPcontrolIECEntityProjector(WindPlantFreqPcontrolIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindPlantFreqPcontrolIEC
   *
   * @param	entity WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC create(WindPlantFreqPcontrolIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindPlantFreqPcontrolIEC
   *
   * @param	entity WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC update(WindPlantFreqPcontrolIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindPlantFreqPcontrolIEC
   *
   * @param	id		UUID
   */
  public WindPlantFreqPcontrolIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindPlantFreqPcontrolIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dprefmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignDprefmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dprefmax as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dprefmax to the parent entity
    // ------------------------------------------
    parentEntity.setDprefmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dprefmax
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignDprefmax(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dprefmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dprefmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDprefmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dprefmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignDprefmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dprefmin as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dprefmin to the parent entity
    // ------------------------------------------
    parentEntity.setDprefmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dprefmin
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignDprefmin(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dprefmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dprefmin on the parent entithy
    // ------------------------------------------
    parentEntity.setDprefmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kiwpp
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignKiwpp(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kiwpp as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kiwpp to the parent entity
    // ------------------------------------------
    parentEntity.setKiwpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kiwpp
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignKiwpp(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kiwpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kiwpp on the parent entithy
    // ------------------------------------------
    parentEntity.setKiwpp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpwpp
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignKpwpp(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpwpp as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kpwpp to the parent entity
    // ------------------------------------------
    parentEntity.setKpwpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpwpp
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignKpwpp(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpwpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpwpp on the parent entithy
    // ------------------------------------------
    parentEntity.setKpwpp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Prefmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignPrefmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Prefmax as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Prefmax to the parent entity
    // ------------------------------------------
    parentEntity.setPrefmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Prefmax
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignPrefmax(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Prefmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Prefmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPrefmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Prefmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignPrefmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Prefmin as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Prefmin to the parent entity
    // ------------------------------------------
    parentEntity.setPrefmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Prefmin
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignPrefmin(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Prefmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Prefmin on the parent entithy
    // ------------------------------------------
    parentEntity.setPrefmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpft
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignTpft(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpft as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpft to the parent entity
    // ------------------------------------------
    parentEntity.setTpft(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpft
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignTpft(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpft on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpft on the parent entithy
    // ------------------------------------------
    parentEntity.setTpft(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpfv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignTpfv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpfv as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpfv to the parent entity
    // ------------------------------------------
    parentEntity.setTpfv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpfv
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignTpfv(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpfv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpfv on the parent entithy
    // ------------------------------------------
    parentEntity.setTpfv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Twpffilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignTwpffilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twpffilt as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twpffilt to the parent entity
    // ------------------------------------------
    parentEntity.setTwpffilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twpffilt
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignTwpffilt(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twpffilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twpffilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTwpffilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Twppfilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC assignTwppfilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twppfilt as " + assignment.toString());

    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twppfilt to the parent entity
    // ------------------------------------------
    parentEntity.setTwppfilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twppfilt
   *
   * @param	parentId		UUID
   * @return	WindPlantFreqPcontrolIEC
   */
  public WindPlantFreqPcontrolIEC unAssignTwppfilt(UUID parentId) {
    WindPlantFreqPcontrolIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twppfilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twppfilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTwppfilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindPlantFreqPcontrolIEC via an FindWindPlantFreqPcontrolIECQuery
   *
   * @return query FindWindPlantFreqPcontrolIECQuery
   */
  @SuppressWarnings("unused")
  public WindPlantFreqPcontrolIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a WindPlantFreqPcontrolIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindPlantFreqPcontrolIECs
   *
   * @param query FindAllWindPlantFreqPcontrolIECQuery
   * @return List<WindPlantFreqPcontrolIEC>
   */
  @SuppressWarnings("unused")
  public List<WindPlantFreqPcontrolIEC> findAll(FindAllWindPlantFreqPcontrolIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindPlantFreqPcontrolIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindPlantFreqPcontrolIECRepository repository;

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
      Logger.getLogger(WindPlantFreqPcontrolIECEntityProjector.class.getName());
}
