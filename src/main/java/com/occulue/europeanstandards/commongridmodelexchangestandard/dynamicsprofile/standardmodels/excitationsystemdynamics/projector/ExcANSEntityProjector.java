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
 * Projector for ExcANS as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcANSAggregate
 *
 * @author your_name_here
 */
@Component("excANS-entity-projector")
public class ExcANSEntityProjector {

  // core constructor
  public ExcANSEntityProjector(ExcANSRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcANS
   *
   * @param	entity ExcANS
   */
  public ExcANS create(ExcANS entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcANS
   *
   * @param	entity ExcANS
   */
  public ExcANS update(ExcANS entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcANS
   *
   * @param	id		UUID
   */
  public ExcANS delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcANS entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Blint
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ExcANS
   */
  public ExcANS assignBlint(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Blint as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the Blint to the parent entity
    // ------------------------------------------
    parentEntity.setBlint(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Blint
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignBlint(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Blint on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Blint on the parent entithy
    // ------------------------------------------
    parentEntity.setBlint(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ifmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcANS
   */
  public ExcANS assignIfmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ifmn as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ifmn to the parent entity
    // ------------------------------------------
    parentEntity.setIfmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ifmn
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignIfmn(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ifmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ifmn on the parent entithy
    // ------------------------------------------
    parentEntity.setIfmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ifmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcANS
   */
  public ExcANS assignIfmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ifmx as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ifmx to the parent entity
    // ------------------------------------------
    parentEntity.setIfmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ifmx
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignIfmx(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ifmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ifmx on the parent entithy
    // ------------------------------------------
    parentEntity.setIfmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcANS
   */
  public ExcANS assignK2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K2 to the parent entity
    // ------------------------------------------
    parentEntity.setK2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K2
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignK2(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K2 on the parent entithy
    // ------------------------------------------
    parentEntity.setK2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K3
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcANS
   */
  public ExcANS assignK3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K3 to the parent entity
    // ------------------------------------------
    parentEntity.setK3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K3
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignK3(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K3 on the parent entithy
    // ------------------------------------------
    parentEntity.setK3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kce
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcANS
   */
  public ExcANS assignKce(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kce as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kce to the parent entity
    // ------------------------------------------
    parentEntity.setKce(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kce
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignKce(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kce on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kce on the parent entithy
    // ------------------------------------------
    parentEntity.setKce(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Krvecc
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ExcANS
   */
  public ExcANS assignKrvecc(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Krvecc as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the Krvecc to the parent entity
    // ------------------------------------------
    parentEntity.setKrvecc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Krvecc
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignKrvecc(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Krvecc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Krvecc on the parent entithy
    // ------------------------------------------
    parentEntity.setKrvecc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kvfif
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ExcANS
   */
  public ExcANS assignKvfif(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Kvfif as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the Kvfif to the parent entity
    // ------------------------------------------
    parentEntity.setKvfif(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kvfif
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignKvfif(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kvfif on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kvfif on the parent entithy
    // ------------------------------------------
    parentEntity.setKvfif(null);

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
   * @return	ExcANS
   */
  public ExcANS assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcANS
   */
  public ExcANS unAssignT1(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

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
   * @return	ExcANS
   */
  public ExcANS assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcANS
   */
  public ExcANS unAssignT2(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

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
   * Assign a T3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcANS
   */
  public ExcANS assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3 to the parent entity
    // ------------------------------------------
    parentEntity.setT3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignT3(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3 on the parent entithy
    // ------------------------------------------
    parentEntity.setT3(null);

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
   * @return	ExcANS
   */
  public ExcANS assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcANS
   */
  public ExcANS unAssignTb(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

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
   * Assign a Vrmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcANS
   */
  public ExcANS assignVrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmn as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmn to the parent entity
    // ------------------------------------------
    parentEntity.setVrmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmn
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignVrmn(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmn on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcANS
   */
  public ExcANS assignVrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmx as " + assignment.toString());

    ExcANS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmx to the parent entity
    // ------------------------------------------
    parentEntity.setVrmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmx
   *
   * @param	parentId		UUID
   * @return	ExcANS
   */
  public ExcANS unAssignVrmx(UUID parentId) {
    ExcANS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmx on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcANS via an FindExcANSQuery
   *
   * @return query FindExcANSQuery
   */
  @SuppressWarnings("unused")
  public ExcANS find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcANS - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcANSs
   *
   * @param query FindAllExcANSQuery
   * @return List<ExcANS>
   */
  @SuppressWarnings("unused")
  public List<ExcANS> findAll(FindAllExcANSQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcANS - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcANSRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

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

  private static final Logger LOGGER = Logger.getLogger(ExcANSEntityProjector.class.getName());
}
