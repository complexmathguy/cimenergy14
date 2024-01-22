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
 * Projector for ExcIEEEDC1A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEDC1AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEDC1A-entity-projector")
public class ExcIEEEDC1AEntityProjector {

  // core constructor
  public ExcIEEEDC1AEntityProjector(ExcIEEEDC1ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEDC1A
   *
   * @param	entity ExcIEEEDC1A
   */
  public ExcIEEEDC1A create(ExcIEEEDC1A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEDC1A
   *
   * @param	entity ExcIEEEDC1A
   */
  public ExcIEEEDC1A update(ExcIEEEDC1A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEDC1A
   *
   * @param	id		UUID
   */
  public ExcIEEEDC1A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEDC1A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efd1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignEfd1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd1 as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd1 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignEfd1(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efd2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignEfd2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd2 as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd2 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignEfd2(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Exclim
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignExclim(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Exclim as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Exclim to the parent entity
    // ------------------------------------------
    parentEntity.setExclim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Exclim
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignExclim(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Exclim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Exclim on the parent entithy
    // ------------------------------------------
    parentEntity.setExclim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignKa(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ke to the parent entity
    // ------------------------------------------
    parentEntity.setKe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignKe(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke on the parent entithy
    // ------------------------------------------
    parentEntity.setKe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf to the parent entity
    // ------------------------------------------
    parentEntity.setKf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignKf(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf on the parent entithy
    // ------------------------------------------
    parentEntity.setKf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seefd1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignSeefd1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seefd1 as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seefd1 to the parent entity
    // ------------------------------------------
    parentEntity.setSeefd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seefd1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignSeefd1(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seefd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seefd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeefd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seefd2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignSeefd2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seefd2 as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seefd2 to the parent entity
    // ------------------------------------------
    parentEntity.setSeefd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seefd2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignSeefd2(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seefd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seefd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeefd2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ta to the parent entity
    // ------------------------------------------
    parentEntity.setTa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ta
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignTa(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ta on the parent entithy
    // ------------------------------------------
    parentEntity.setTa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb to the parent entity
    // ------------------------------------------
    parentEntity.setTb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignTb(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb on the parent entithy
    // ------------------------------------------
    parentEntity.setTb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc to the parent entity
    // ------------------------------------------
    parentEntity.setTc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignTc(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc on the parent entithy
    // ------------------------------------------
    parentEntity.setTc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignTe(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf to the parent entity
    // ------------------------------------------
    parentEntity.setTf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignTf(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf on the parent entithy
    // ------------------------------------------
    parentEntity.setTf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uelin
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignUelin(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Uelin as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Uelin to the parent entity
    // ------------------------------------------
    parentEntity.setUelin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uelin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignUelin(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uelin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uelin on the parent entithy
    // ------------------------------------------
    parentEntity.setUelin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmax to the parent entity
    // ------------------------------------------
    parentEntity.setVrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignVrmax(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmin to the parent entity
    // ------------------------------------------
    parentEntity.setVrmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC1A
   */
  public ExcIEEEDC1A unAssignVrmin(UUID parentId) {
    ExcIEEEDC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcIEEEDC1A via an FindExcIEEEDC1AQuery
   *
   * @return query FindExcIEEEDC1AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEDC1A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEDC1A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC1As
   *
   * @param query FindAllExcIEEEDC1AQuery
   * @return List<ExcIEEEDC1A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEDC1A> findAll(FindAllExcIEEEDC1AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEDC1A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEDC1ARepository repository;

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
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC1AEntityProjector.class.getName());
}
