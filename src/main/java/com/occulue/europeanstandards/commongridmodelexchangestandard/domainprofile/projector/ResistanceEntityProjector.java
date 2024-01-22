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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Resistance as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ResistanceAggregate
 *
 * @author your_name_here
 */
@Component("resistance-entity-projector")
public class ResistanceEntityProjector {

  // core constructor
  public ResistanceEntityProjector(ResistanceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Resistance
   *
   * @param	entity Resistance
   */
  public Resistance create(Resistance entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Resistance
   *
   * @param	entity Resistance
   */
  public Resistance update(Resistance entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Resistance
   *
   * @param	id		UUID
   */
  public Resistance delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Resistance entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	Resistance
   */
  public Resistance assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    Resistance parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	Resistance
   */
  public Resistance unAssignValue(UUID parentId) {
    Resistance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Resistance via an FindResistanceQuery
   *
   * @return query FindResistanceQuery
   */
  @SuppressWarnings("unused")
  public Resistance find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Resistance - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Resistances
   *
   * @param query FindAllResistanceQuery
   * @return List<Resistance>
   */
  @SuppressWarnings("unused")
  public List<Resistance> findAll(FindAllResistanceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Resistance - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ResistanceRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "aCDCConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .ACDCConverterEntityProjector
      ACDCConverterProjector;

  @Autowired
  @Qualifier(value = "dCGround-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCGroundEntityProjector
      DCGroundProjector;

  @Autowired
  @Qualifier(value = "dCLineSegment-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCLineSegmentEntityProjector
      DCLineSegmentProjector;

  @Autowired
  @Qualifier(value = "aCLineSegment-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .ACLineSegmentEntityProjector
      ACLineSegmentProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "transformerEnd-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .TransformerEndEntityProjector
      TransformerEndProjector;

  @Autowired
  @Qualifier(value = "equivalentBranch-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents
          .projector.EquivalentBranchEntityProjector
      EquivalentBranchProjector;

  @Autowired
  @Qualifier(value = "equivalentInjection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents
          .projector.EquivalentInjectionEntityProjector
      EquivalentInjectionProjector;

  private static final Logger LOGGER = Logger.getLogger(ResistanceEntityProjector.class.getName());
}
