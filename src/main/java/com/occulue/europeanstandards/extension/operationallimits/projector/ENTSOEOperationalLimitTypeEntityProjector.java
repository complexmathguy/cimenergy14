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
package com.occulue.europeanstandards.extension.operationallimits.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.operationallimits.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ENTSOEOperationalLimitType as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ENTSOEOperationalLimitTypeAggregate
 *
 * @author your_name_here
 */
@Component("eNTSOEOperationalLimitType-entity-projector")
public class ENTSOEOperationalLimitTypeEntityProjector {

  // core constructor
  public ENTSOEOperationalLimitTypeEntityProjector(
      ENTSOEOperationalLimitTypeRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ENTSOEOperationalLimitType
   *
   * @param	entity ENTSOEOperationalLimitType
   */
  public ENTSOEOperationalLimitType create(ENTSOEOperationalLimitType entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ENTSOEOperationalLimitType
   *
   * @param	entity ENTSOEOperationalLimitType
   */
  public ENTSOEOperationalLimitType update(ENTSOEOperationalLimitType entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ENTSOEOperationalLimitType
   *
   * @param	id		UUID
   */
  public ENTSOEOperationalLimitType delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ENTSOEOperationalLimitType entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the ENTSOEOperationalLimitType via an FindENTSOEOperationalLimitTypeQuery
   *
   * @return query FindENTSOEOperationalLimitTypeQuery
   */
  @SuppressWarnings("unused")
  public ENTSOEOperationalLimitType find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a ENTSOEOperationalLimitType - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ENTSOEOperationalLimitTypes
   *
   * @param query FindAllENTSOEOperationalLimitTypeQuery
   * @return List<ENTSOEOperationalLimitType>
   */
  @SuppressWarnings("unused")
  public List<ENTSOEOperationalLimitType> findAll(FindAllENTSOEOperationalLimitTypeQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ENTSOEOperationalLimitType - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ENTSOEOperationalLimitTypeRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(ENTSOEOperationalLimitTypeEntityProjector.class.getName());
}
