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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SvShuntCompensatorSections as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SvShuntCompensatorSectionsAggregate
 *
 * @author your_name_here
 */
@Component("svShuntCompensatorSections-entity-projector")
public class SvShuntCompensatorSectionsEntityProjector {

  // core constructor
  public SvShuntCompensatorSectionsEntityProjector(
      SvShuntCompensatorSectionsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SvShuntCompensatorSections
   *
   * @param	entity SvShuntCompensatorSections
   */
  public SvShuntCompensatorSections create(SvShuntCompensatorSections entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SvShuntCompensatorSections
   *
   * @param	entity SvShuntCompensatorSections
   */
  public SvShuntCompensatorSections update(SvShuntCompensatorSections entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SvShuntCompensatorSections
   *
   * @param	id		UUID
   */
  public SvShuntCompensatorSections delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SvShuntCompensatorSections entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Sections
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SvShuntCompensatorSections
   */
  public SvShuntCompensatorSections assignSections(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Sections as " + assignment.toString());

    SvShuntCompensatorSections parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Sections to the parent entity
    // ------------------------------------------
    parentEntity.setSections(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Sections
   *
   * @param	parentId		UUID
   * @return	SvShuntCompensatorSections
   */
  public SvShuntCompensatorSections unAssignSections(UUID parentId) {
    SvShuntCompensatorSections parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Sections on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Sections on the parent entithy
    // ------------------------------------------
    parentEntity.setSections(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SvShuntCompensatorSections
   *
   * @param	parentId	UUID
   * @param	assignment 	SvShuntCompensatorSections
   * @return	SvShuntCompensatorSections
   */
  public SvShuntCompensatorSections assignSvShuntCompensatorSections(
      UUID parentId, SvShuntCompensatorSections assignment) {
    LOGGER.info("assigning SvShuntCompensatorSections as " + assignment.toString());

    SvShuntCompensatorSections parentEntity = repository.findById(parentId).get();
    assignment =
        SvShuntCompensatorSectionsProjector.find(assignment.getSvShuntCompensatorSectionsId());

    // ------------------------------------------
    // assign the SvShuntCompensatorSections to the parent entity
    // ------------------------------------------
    parentEntity.setSvShuntCompensatorSections(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SvShuntCompensatorSections
   *
   * @param	parentId		UUID
   * @return	SvShuntCompensatorSections
   */
  public SvShuntCompensatorSections unAssignSvShuntCompensatorSections(UUID parentId) {
    SvShuntCompensatorSections parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SvShuntCompensatorSections on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SvShuntCompensatorSections on the parent entithy
    // ------------------------------------------
    parentEntity.setSvShuntCompensatorSections(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SvShuntCompensatorSections via an FindSvShuntCompensatorSectionsQuery
   *
   * @return query FindSvShuntCompensatorSectionsQuery
   */
  @SuppressWarnings("unused")
  public SvShuntCompensatorSections find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a SvShuntCompensatorSections - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SvShuntCompensatorSectionss
   *
   * @param query FindAllSvShuntCompensatorSectionsQuery
   * @return List<SvShuntCompensatorSections>
   */
  @SuppressWarnings("unused")
  public List<SvShuntCompensatorSections> findAll(FindAllSvShuntCompensatorSectionsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all SvShuntCompensatorSections - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SvShuntCompensatorSectionsRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "svShuntCompensatorSections-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .projector.SvShuntCompensatorSectionsEntityProjector
      SvShuntCompensatorSectionsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SvShuntCompensatorSectionsEntityProjector.class.getName());
}
