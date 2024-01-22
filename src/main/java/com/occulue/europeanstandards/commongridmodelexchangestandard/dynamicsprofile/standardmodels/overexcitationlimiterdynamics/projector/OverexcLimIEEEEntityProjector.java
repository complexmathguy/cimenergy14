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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for OverexcLimIEEE as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OverexcLimIEEEAggregate
 *
 * @author your_name_here
 */
@Component("overexcLimIEEE-entity-projector")
public class OverexcLimIEEEEntityProjector {

  // core constructor
  public OverexcLimIEEEEntityProjector(OverexcLimIEEERepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OverexcLimIEEE
   *
   * @param	entity OverexcLimIEEE
   */
  public OverexcLimIEEE create(OverexcLimIEEE entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OverexcLimIEEE
   *
   * @param	entity OverexcLimIEEE
   */
  public OverexcLimIEEE update(OverexcLimIEEE entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OverexcLimIEEE
   *
   * @param	id		UUID
   */
  public OverexcLimIEEE delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OverexcLimIEEE entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Hyst
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE assignHyst(UUID parentId, PU assignment) {
    LOGGER.info("assigning Hyst as " + assignment.toString());

    OverexcLimIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Hyst to the parent entity
    // ------------------------------------------
    parentEntity.setHyst(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Hyst
   *
   * @param	parentId		UUID
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE unAssignHyst(UUID parentId) {
    OverexcLimIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Hyst on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Hyst on the parent entithy
    // ------------------------------------------
    parentEntity.setHyst(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ifdlim
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE assignIfdlim(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ifdlim as " + assignment.toString());

    OverexcLimIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ifdlim to the parent entity
    // ------------------------------------------
    parentEntity.setIfdlim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ifdlim
   *
   * @param	parentId		UUID
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE unAssignIfdlim(UUID parentId) {
    OverexcLimIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ifdlim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ifdlim on the parent entithy
    // ------------------------------------------
    parentEntity.setIfdlim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ifdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE assignIfdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ifdmax as " + assignment.toString());

    OverexcLimIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ifdmax to the parent entity
    // ------------------------------------------
    parentEntity.setIfdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ifdmax
   *
   * @param	parentId		UUID
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE unAssignIfdmax(UUID parentId) {
    OverexcLimIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ifdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ifdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setIfdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Itfpu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE assignItfpu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Itfpu as " + assignment.toString());

    OverexcLimIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Itfpu to the parent entity
    // ------------------------------------------
    parentEntity.setItfpu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Itfpu
   *
   * @param	parentId		UUID
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE unAssignItfpu(UUID parentId) {
    OverexcLimIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Itfpu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Itfpu on the parent entithy
    // ------------------------------------------
    parentEntity.setItfpu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kcd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE assignKcd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kcd as " + assignment.toString());

    OverexcLimIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kcd to the parent entity
    // ------------------------------------------
    parentEntity.setKcd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kcd
   *
   * @param	parentId		UUID
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE unAssignKcd(UUID parentId) {
    OverexcLimIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kcd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kcd on the parent entithy
    // ------------------------------------------
    parentEntity.setKcd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kramp
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE assignKramp(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kramp as " + assignment.toString());

    OverexcLimIEEE parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kramp to the parent entity
    // ------------------------------------------
    parentEntity.setKramp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kramp
   *
   * @param	parentId		UUID
   * @return	OverexcLimIEEE
   */
  public OverexcLimIEEE unAssignKramp(UUID parentId) {
    OverexcLimIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kramp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kramp on the parent entithy
    // ------------------------------------------
    parentEntity.setKramp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the OverexcLimIEEE via an FindOverexcLimIEEEQuery
   *
   * @return query FindOverexcLimIEEEQuery
   */
  @SuppressWarnings("unused")
  public OverexcLimIEEE find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a OverexcLimIEEE - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OverexcLimIEEEs
   *
   * @param query FindAllOverexcLimIEEEQuery
   * @return List<OverexcLimIEEE>
   */
  @SuppressWarnings("unused")
  public List<OverexcLimIEEE> findAll(FindAllOverexcLimIEEEQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all OverexcLimIEEE - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OverexcLimIEEERepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimIEEEEntityProjector.class.getName());
}
