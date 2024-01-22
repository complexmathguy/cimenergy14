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
 * Projector for Money as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MoneyAggregate
 *
 * @author your_name_here
 */
@Component("money-entity-projector")
public class MoneyEntityProjector {

  // core constructor
  public MoneyEntityProjector(MoneyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Money
   *
   * @param	entity Money
   */
  public Money create(Money entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Money
   *
   * @param	entity Money
   */
  public Money update(Money entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Money
   *
   * @param	id		UUID
   */
  public Money delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Money entity = repository.findById(id).get();

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
   * @param	assignment 	DecimalProxy
   * @return	Money
   */
  public Money assignValue(UUID parentId, DecimalProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    Money parentEntity = repository.findById(parentId).get();
    assignment = DecimalProxyProjector.find(assignment.getDecimalProxyId());

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
   * @return	Money
   */
  public Money unAssignValue(UUID parentId) {
    Money parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the Money via an FindMoneyQuery
   *
   * @return query FindMoneyQuery
   */
  @SuppressWarnings("unused")
  public Money find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Money - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Moneys
   *
   * @param query FindAllMoneyQuery
   * @return List<Money>
   */
  @SuppressWarnings("unused")
  public List<Money> findAll(FindAllMoneyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Money - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MoneyRepository repository;

  @Autowired
  @Qualifier(value = "decimalProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DecimalProxyEntityProjector
      DecimalProxyProjector;

  @Autowired
  @Qualifier(value = "generatingUnit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .projector.GeneratingUnitEntityProjector
      GeneratingUnitProjector;

  private static final Logger LOGGER = Logger.getLogger(MoneyEntityProjector.class.getName());
}
