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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PowerSystemStabilizerUserDefined as outlined for the CQRS pattern. All event
 * handling and query handling related to PowerSystemStabilizerUserDefined are invoked here and
 * dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PowerSystemStabilizerUserDefinedAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("powerSystemStabilizerUserDefined")
@Component("powerSystemStabilizerUserDefined-projector")
public class PowerSystemStabilizerUserDefinedProjector
    extends PowerSystemStabilizerUserDefinedEntityProjector {

  // core constructor
  public PowerSystemStabilizerUserDefinedProjector(
      PowerSystemStabilizerUserDefinedRepository repository,
      QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePowerSystemStabilizerUserDefinedEvent
   */
  @EventHandler(payloadType = CreatePowerSystemStabilizerUserDefinedEvent.class)
  public void handle(CreatePowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("handling CreatePowerSystemStabilizerUserDefinedEvent - " + event);
    PowerSystemStabilizerUserDefined entity = new PowerSystemStabilizerUserDefined();
    entity.setPowerSystemStabilizerUserDefinedId(event.getPowerSystemStabilizerUserDefinedId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerUserDefined(entity);
  }

  /*
   * @param	event UpdatePowerSystemStabilizerUserDefinedEvent
   */
  @EventHandler(payloadType = UpdatePowerSystemStabilizerUserDefinedEvent.class)
  public void handle(UpdatePowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("handling UpdatePowerSystemStabilizerUserDefinedEvent - " + event);

    PowerSystemStabilizerUserDefined entity = new PowerSystemStabilizerUserDefined();
    entity.setPowerSystemStabilizerUserDefinedId(event.getPowerSystemStabilizerUserDefinedId());
    entity.setProprietary(event.getProprietary());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerSystemStabilizerUserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerUserDefined(entity);
  }

  /*
   * @param	event DeletePowerSystemStabilizerUserDefinedEvent
   */
  @EventHandler(payloadType = DeletePowerSystemStabilizerUserDefinedEvent.class)
  public void handle(DeletePowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("handling DeletePowerSystemStabilizerUserDefinedEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PowerSystemStabilizerUserDefined entity = delete(event.getPowerSystemStabilizerUserDefinedId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerUserDefined(entity);
  }

  /*
   * @param	event AssignProprietaryToPowerSystemStabilizerUserDefinedEvent
   */
  @EventHandler(payloadType = AssignProprietaryToPowerSystemStabilizerUserDefinedEvent.class)
  public void handle(AssignProprietaryToPowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("handling AssignProprietaryToPowerSystemStabilizerUserDefinedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerSystemStabilizerUserDefined entity =
        assignProprietary(event.getPowerSystemStabilizerUserDefinedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerSystemStabilizerUserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerUserDefined(entity);
  }

  /*
   * @param	event UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent
   */
  @EventHandler(payloadType = UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent.class)
  public void handle(UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent event) {
    LOGGER.info("handling UnAssignProprietaryFromPowerSystemStabilizerUserDefinedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerSystemStabilizerUserDefined entity =
        unAssignProprietary(event.getPowerSystemStabilizerUserDefinedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerSystemStabilizerUserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerUserDefined(entity);
  }

  /**
   * Method to retrieve the PowerSystemStabilizerUserDefined via an
   * PowerSystemStabilizerUserDefinedPrimaryKey.
   *
   * @param id Long
   * @return PowerSystemStabilizerUserDefined
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PowerSystemStabilizerUserDefined handle(FindPowerSystemStabilizerUserDefinedQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPowerSystemStabilizerUserDefinedId());
  }

  /**
   * Method to retrieve a collection of all PowerSystemStabilizerUserDefineds
   *
   * @param query FindAllPowerSystemStabilizerUserDefinedQuery
   * @return List<PowerSystemStabilizerUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PowerSystemStabilizerUserDefined> handle(
      FindAllPowerSystemStabilizerUserDefinedQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPowerSystemStabilizerUserDefined, but only if the id
   * matches
   *
   * @param entity PowerSystemStabilizerUserDefined
   */
  protected void emitFindPowerSystemStabilizerUserDefined(PowerSystemStabilizerUserDefined entity) {
    LOGGER.info("handling emitFindPowerSystemStabilizerUserDefined");

    queryUpdateEmitter.emit(
        FindPowerSystemStabilizerUserDefinedQuery.class,
        query ->
            query
                .getFilter()
                .getPowerSystemStabilizerUserDefinedId()
                .equals(entity.getPowerSystemStabilizerUserDefinedId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPowerSystemStabilizerUserDefined
   *
   * @param entity PowerSystemStabilizerUserDefined
   */
  protected void emitFindAllPowerSystemStabilizerUserDefined(
      PowerSystemStabilizerUserDefined entity) {
    LOGGER.info("handling emitFindAllPowerSystemStabilizerUserDefined");

    queryUpdateEmitter.emit(
        FindAllPowerSystemStabilizerUserDefinedQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerUserDefinedProjector.class.getName());
}
