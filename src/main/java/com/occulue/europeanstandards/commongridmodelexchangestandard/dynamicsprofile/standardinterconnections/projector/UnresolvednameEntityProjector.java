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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Unresolvedname as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by UnresolvednameAggregate
 *
 * @author your_name_here
 */
@Component("unresolvedname-entity-projector")
public class UnresolvednameEntityProjector {

  // core constructor
  public UnresolvednameEntityProjector(UnresolvednameRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Unresolvedname
   *
   * @param	entity Unresolvedname
   */
  public Unresolvedname create(Unresolvedname entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Unresolvedname
   *
   * @param	entity Unresolvedname
   */
  public Unresolvedname update(Unresolvedname entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Unresolvedname
   *
   * @param	id		UUID
   */
  public Unresolvedname delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Unresolvedname entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the Unresolvedname via an FindUnresolvednameQuery
   *
   * @return query FindUnresolvednameQuery
   */
  @SuppressWarnings("unused")
  public Unresolvedname find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Unresolvedname - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Unresolvednames
   *
   * @param query FindAllUnresolvednameQuery
   * @return List<Unresolvedname>
   */
  @SuppressWarnings("unused")
  public List<Unresolvedname> findAll(FindAllUnresolvednameQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Unresolvedname - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final UnresolvednameRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(UnresolvednameEntityProjector.class.getName());
}
