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
 * Projector for WindPlantReactiveControlIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindPlantReactiveControlIECAggregate
 *
 * @author your_name_here
 */
@Component("windPlantReactiveControlIEC-entity-projector")
public class WindPlantReactiveControlIECEntityProjector {

  // core constructor
  public WindPlantReactiveControlIECEntityProjector(
      WindPlantReactiveControlIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindPlantReactiveControlIEC
   *
   * @param	entity WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC create(WindPlantReactiveControlIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindPlantReactiveControlIEC
   *
   * @param	entity WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC update(WindPlantReactiveControlIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindPlantReactiveControlIEC
   *
   * @param	id		UUID
   */
  public WindPlantReactiveControlIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kiwpx
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignKiwpx(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kiwpx as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kiwpx to the parent entity
    // ------------------------------------------
    parentEntity.setKiwpx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kiwpx
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignKiwpx(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kiwpx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kiwpx on the parent entithy
    // ------------------------------------------
    parentEntity.setKiwpx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpwpx
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignKpwpx(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpwpx as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kpwpx to the parent entity
    // ------------------------------------------
    parentEntity.setKpwpx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpwpx
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignKpwpx(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpwpx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpwpx on the parent entithy
    // ------------------------------------------
    parentEntity.setKpwpx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kwpqu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignKwpqu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kwpqu as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kwpqu to the parent entity
    // ------------------------------------------
    parentEntity.setKwpqu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kwpqu
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignKwpqu(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kwpqu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kwpqu on the parent entithy
    // ------------------------------------------
    parentEntity.setKwpqu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwppf
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignMwppf(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Mwppf as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Mwppf to the parent entity
    // ------------------------------------------
    parentEntity.setMwppf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwppf
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignMwppf(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwppf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwppf on the parent entithy
    // ------------------------------------------
    parentEntity.setMwppf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwpu
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignMwpu(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Mwpu as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Mwpu to the parent entity
    // ------------------------------------------
    parentEntity.setMwpu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwpu
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignMwpu(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwpu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwpu on the parent entithy
    // ------------------------------------------
    parentEntity.setMwpu(null);

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
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignTwppfilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twppfilt as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
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
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignTwppfilt(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a Twpqfilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignTwpqfilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twpqfilt as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twpqfilt to the parent entity
    // ------------------------------------------
    parentEntity.setTwpqfilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twpqfilt
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignTwpqfilt(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twpqfilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twpqfilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTwpqfilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Twpufilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignTwpufilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twpufilt as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twpufilt to the parent entity
    // ------------------------------------------
    parentEntity.setTwpufilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twpufilt
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignTwpufilt(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twpufilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twpufilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTwpufilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Txft
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignTxft(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Txft as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Txft to the parent entity
    // ------------------------------------------
    parentEntity.setTxft(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Txft
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignTxft(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Txft on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Txft on the parent entithy
    // ------------------------------------------
    parentEntity.setTxft(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Txfv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignTxfv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Txfv as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Txfv to the parent entity
    // ------------------------------------------
    parentEntity.setTxfv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Txfv
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignTxfv(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Txfv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Txfv on the parent entithy
    // ------------------------------------------
    parentEntity.setTxfv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uwpqdip
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignUwpqdip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uwpqdip as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uwpqdip to the parent entity
    // ------------------------------------------
    parentEntity.setUwpqdip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uwpqdip
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignUwpqdip(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uwpqdip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uwpqdip on the parent entithy
    // ------------------------------------------
    parentEntity.setUwpqdip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xrefmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignXrefmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xrefmax as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xrefmax to the parent entity
    // ------------------------------------------
    parentEntity.setXrefmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xrefmax
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignXrefmax(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xrefmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xrefmax on the parent entithy
    // ------------------------------------------
    parentEntity.setXrefmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xrefmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC assignXrefmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xrefmin as " + assignment.toString());

    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xrefmin to the parent entity
    // ------------------------------------------
    parentEntity.setXrefmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xrefmin
   *
   * @param	parentId		UUID
   * @return	WindPlantReactiveControlIEC
   */
  public WindPlantReactiveControlIEC unAssignXrefmin(UUID parentId) {
    WindPlantReactiveControlIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xrefmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xrefmin on the parent entithy
    // ------------------------------------------
    parentEntity.setXrefmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindPlantReactiveControlIEC via an FindWindPlantReactiveControlIECQuery
   *
   * @return query FindWindPlantReactiveControlIECQuery
   */
  @SuppressWarnings("unused")
  public WindPlantReactiveControlIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a WindPlantReactiveControlIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindPlantReactiveControlIECs
   *
   * @param query FindAllWindPlantReactiveControlIECQuery
   * @return List<WindPlantReactiveControlIEC>
   */
  @SuppressWarnings("unused")
  public List<WindPlantReactiveControlIEC> findAll(FindAllWindPlantReactiveControlIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindPlantReactiveControlIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindPlantReactiveControlIECRepository repository;

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
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindPlantReactiveControlIECEntityProjector.class.getName());
}
