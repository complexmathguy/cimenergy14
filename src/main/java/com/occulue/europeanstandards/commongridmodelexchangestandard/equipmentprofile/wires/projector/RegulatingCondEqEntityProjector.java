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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RegulatingCondEq as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RegulatingCondEqAggregate
 *
 * @author your_name_here
 */
@Component("regulatingCondEq-entity-projector")
public class RegulatingCondEqEntityProjector {

  // core constructor
  public RegulatingCondEqEntityProjector(RegulatingCondEqRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RegulatingCondEq
   *
   * @param	entity RegulatingCondEq
   */
  public RegulatingCondEq create(RegulatingCondEq entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RegulatingCondEq
   *
   * @param	entity RegulatingCondEq
   */
  public RegulatingCondEq update(RegulatingCondEq entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RegulatingCondEq
   *
   * @param	id		UUID
   */
  public RegulatingCondEq delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RegulatingCondEq entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the RegulatingCondEq
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	RegulatingCondEq
   */
  public RegulatingCondEq addToRegulatingCondEq(UUID parentId, RegulatingCondEq addTo) {
    LOGGER.info("handling AssignRegulatingCondEqToRegulatingCondEqEvent - ");

    RegulatingCondEq parentEntity = repository.findById(parentId).get();
    RegulatingCondEq child = RegulatingCondEqProjector.find(addTo.getRegulatingCondEqId());

    parentEntity.getRegulatingCondEq().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the RegulatingCondEq
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	RegulatingCondEq
   */
  public RegulatingCondEq removeFromRegulatingCondEq(UUID parentId, RegulatingCondEq removeFrom) {
    LOGGER.info("handling RemoveRegulatingCondEqFromRegulatingCondEqEvent ");

    RegulatingCondEq parentEntity = repository.findById(parentId).get();
    RegulatingCondEq child = RegulatingCondEqProjector.find(removeFrom.getRegulatingCondEqId());

    parentEntity.getRegulatingCondEq().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RegulatingCondEq via an FindRegulatingCondEqQuery
   *
   * @return query FindRegulatingCondEqQuery
   */
  @SuppressWarnings("unused")
  public RegulatingCondEq find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RegulatingCondEq - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RegulatingCondEqs
   *
   * @param query FindAllRegulatingCondEqQuery
   * @return List<RegulatingCondEq>
   */
  @SuppressWarnings("unused")
  public List<RegulatingCondEq> findAll(FindAllRegulatingCondEqQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RegulatingCondEq - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RegulatingCondEqRepository repository;

  @Autowired
  @Qualifier(value = "regulatingCondEq-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .RegulatingCondEqEntityProjector
      RegulatingCondEqProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RegulatingCondEqEntityProjector.class.getName());
}
