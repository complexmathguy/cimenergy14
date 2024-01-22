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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcELIN1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcELIN1Aggregate
 *
 * @author your_name_here
 */
@Component("excELIN1-entity-projector")
public class ExcELIN1EntityProjector {

  // core constructor
  public ExcELIN1EntityProjector(ExcELIN1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcELIN1
   *
   * @param	entity ExcELIN1
   */
  public ExcELIN1 create(ExcELIN1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcELIN1
   *
   * @param	entity ExcELIN1
   */
  public ExcELIN1 update(ExcELIN1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcELIN1
   *
   * @param	id		UUID
   */
  public ExcELIN1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcELIN1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dpnf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignDpnf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dpnf as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dpnf to the parent entity
    // ------------------------------------------
    parentEntity.setDpnf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dpnf
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignDpnf(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dpnf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dpnf on the parent entithy
    // ------------------------------------------
    parentEntity.setDpnf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignEfmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efmax as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efmax to the parent entity
    // ------------------------------------------
    parentEntity.setEfmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efmax
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignEfmax(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efmax on the parent entithy
    // ------------------------------------------
    parentEntity.setEfmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignEfmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efmin as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efmin to the parent entity
    // ------------------------------------------
    parentEntity.setEfmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efmin
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignEfmin(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efmin on the parent entithy
    // ------------------------------------------
    parentEntity.setEfmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignKs1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks1 as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks1 to the parent entity
    // ------------------------------------------
    parentEntity.setKs1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks1
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignKs1(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignKs2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks2 as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks2 to the parent entity
    // ------------------------------------------
    parentEntity.setKs2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks2
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignKs2(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Smax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignSmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Smax as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Smax to the parent entity
    // ------------------------------------------
    parentEntity.setSmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Smax
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignSmax(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Smax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Smax on the parent entithy
    // ------------------------------------------
    parentEntity.setSmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tfi
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN1
   */
  public ExcELIN1 assignTfi(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tfi as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tfi to the parent entity
    // ------------------------------------------
    parentEntity.setTfi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tfi
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignTfi(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tfi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tfi on the parent entithy
    // ------------------------------------------
    parentEntity.setTfi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tnu
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN1
   */
  public ExcELIN1 assignTnu(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tnu as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tnu to the parent entity
    // ------------------------------------------
    parentEntity.setTnu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tnu
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignTnu(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tnu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tnu on the parent entithy
    // ------------------------------------------
    parentEntity.setTnu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN1
   */
  public ExcELIN1 assignTs1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts1 as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts1 to the parent entity
    // ------------------------------------------
    parentEntity.setTs1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts1
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignTs1(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN1
   */
  public ExcELIN1 assignTs2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts2 as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts2 to the parent entity
    // ------------------------------------------
    parentEntity.setTs2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts2
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignTs2(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tsw
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN1
   */
  public ExcELIN1 assignTsw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tsw as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tsw to the parent entity
    // ------------------------------------------
    parentEntity.setTsw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tsw
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignTsw(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tsw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tsw on the parent entithy
    // ------------------------------------------
    parentEntity.setTsw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vpi
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignVpi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vpi as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vpi to the parent entity
    // ------------------------------------------
    parentEntity.setVpi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vpi
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignVpi(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vpi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vpi on the parent entithy
    // ------------------------------------------
    parentEntity.setVpi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vpnf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignVpnf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vpnf as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vpnf to the parent entity
    // ------------------------------------------
    parentEntity.setVpnf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vpnf
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignVpnf(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vpnf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vpnf on the parent entithy
    // ------------------------------------------
    parentEntity.setVpnf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vpu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignVpu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vpu as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vpu to the parent entity
    // ------------------------------------------
    parentEntity.setVpu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vpu
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignVpu(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vpu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vpu on the parent entithy
    // ------------------------------------------
    parentEntity.setVpu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xe
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN1
   */
  public ExcELIN1 assignXe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xe as " + assignment.toString());

    ExcELIN1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xe to the parent entity
    // ------------------------------------------
    parentEntity.setXe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xe
   *
   * @param	parentId		UUID
   * @return	ExcELIN1
   */
  public ExcELIN1 unAssignXe(UUID parentId) {
    ExcELIN1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xe on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xe on the parent entithy
    // ------------------------------------------
    parentEntity.setXe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcELIN1 via an FindExcELIN1Query
   *
   * @return query FindExcELIN1Query
   */
  @SuppressWarnings("unused")
  public ExcELIN1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcELIN1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcELIN1s
   *
   * @param query FindAllExcELIN1Query
   * @return List<ExcELIN1>
   */
  @SuppressWarnings("unused")
  public List<ExcELIN1> findAll(FindAllExcELIN1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcELIN1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcELIN1Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcELIN1EntityProjector.class.getName());
}
