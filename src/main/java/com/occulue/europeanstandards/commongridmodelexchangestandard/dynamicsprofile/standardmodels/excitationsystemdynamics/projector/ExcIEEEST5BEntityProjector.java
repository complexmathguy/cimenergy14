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
 * Projector for ExcIEEEST5B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEST5BAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEST5B-entity-projector")
public class ExcIEEEST5BEntityProjector {

  // core constructor
  public ExcIEEEST5BEntityProjector(ExcIEEEST5BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEST5B
   *
   * @param	entity ExcIEEEST5B
   */
  public ExcIEEEST5B create(ExcIEEEST5B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEST5B
   *
   * @param	entity ExcIEEEST5B
   */
  public ExcIEEEST5B update(ExcIEEEST5B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEST5B
   *
   * @param	id		UUID
   */
  public ExcIEEEST5B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEST5B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kc to the parent entity
    // ------------------------------------------
    parentEntity.setKc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kc
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignKc(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kc on the parent entithy
    // ------------------------------------------
    parentEntity.setKc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignKr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kr as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kr to the parent entity
    // ------------------------------------------
    parentEntity.setKr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignKr(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kr on the parent entithy
    // ------------------------------------------
    parentEntity.setKr(null);

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
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignT1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

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
   * Assign a Tb1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTb1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb1 to the parent entity
    // ------------------------------------------
    parentEntity.setTb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTb1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTb1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTb2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb2 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb2 to the parent entity
    // ------------------------------------------
    parentEntity.setTb2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTb2(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTb2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTc1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc1 to the parent entity
    // ------------------------------------------
    parentEntity.setTc1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTc1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTc1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTc2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc2 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc2 to the parent entity
    // ------------------------------------------
    parentEntity.setTc2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTc2(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTc2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tob1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTob1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tob1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tob1 to the parent entity
    // ------------------------------------------
    parentEntity.setTob1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tob1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTob1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tob1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tob1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTob1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tob2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTob2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tob2 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tob2 to the parent entity
    // ------------------------------------------
    parentEntity.setTob2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tob2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTob2(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tob2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tob2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTob2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Toc1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignToc1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Toc1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Toc1 to the parent entity
    // ------------------------------------------
    parentEntity.setToc1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Toc1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignToc1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Toc1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Toc1 on the parent entithy
    // ------------------------------------------
    parentEntity.setToc1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Toc2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignToc2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Toc2 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Toc2 to the parent entity
    // ------------------------------------------
    parentEntity.setToc2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Toc2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignToc2(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Toc2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Toc2 on the parent entithy
    // ------------------------------------------
    parentEntity.setToc2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tub1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTub1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tub1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tub1 to the parent entity
    // ------------------------------------------
    parentEntity.setTub1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tub1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTub1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tub1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tub1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTub1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tub2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTub2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tub2 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tub2 to the parent entity
    // ------------------------------------------
    parentEntity.setTub2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tub2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTub2(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tub2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tub2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTub2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuc1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTuc1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tuc1 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tuc1 to the parent entity
    // ------------------------------------------
    parentEntity.setTuc1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuc1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTuc1(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuc1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuc1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTuc1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuc2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignTuc2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tuc2 as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tuc2 to the parent entity
    // ------------------------------------------
    parentEntity.setTuc2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuc2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignTuc2(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuc2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuc2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTuc2(null);

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
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignVrmax(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEST5B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST5B
   */
  public ExcIEEEST5B unAssignVrmin(UUID parentId) {
    ExcIEEEST5B parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcIEEEST5B via an FindExcIEEEST5BQuery
   *
   * @return query FindExcIEEEST5BQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEST5B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEST5B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST5Bs
   *
   * @param query FindAllExcIEEEST5BQuery
   * @return List<ExcIEEEST5B>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEST5B> findAll(FindAllExcIEEEST5BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEST5B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEST5BRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST5BEntityProjector.class.getName());
}
