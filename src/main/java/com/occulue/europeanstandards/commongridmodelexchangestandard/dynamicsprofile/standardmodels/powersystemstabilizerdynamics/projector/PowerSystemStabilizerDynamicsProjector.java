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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PowerSystemStabilizerDynamics as outlined for the CQRS pattern. All event handling
 * and query handling related to PowerSystemStabilizerDynamics are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by PowerSystemStabilizerDynamicsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("powerSystemStabilizerDynamics")
@Component("powerSystemStabilizerDynamics-projector")
public class PowerSystemStabilizerDynamicsProjector
    extends PowerSystemStabilizerDynamicsEntityProjector {

  // core constructor
  public PowerSystemStabilizerDynamicsProjector(
      PowerSystemStabilizerDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePowerSystemStabilizerDynamicsEvent
   */
  @EventHandler(payloadType = CreatePowerSystemStabilizerDynamicsEvent.class)
  public void handle(CreatePowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info("handling CreatePowerSystemStabilizerDynamicsEvent - " + event);
    PowerSystemStabilizerDynamics entity = new PowerSystemStabilizerDynamics();
    entity.setPowerSystemStabilizerDynamicsId(event.getPowerSystemStabilizerDynamicsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerDynamics(entity);
  }

  /*
   * @param	event UpdatePowerSystemStabilizerDynamicsEvent
   */
  @EventHandler(payloadType = UpdatePowerSystemStabilizerDynamicsEvent.class)
  public void handle(UpdatePowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info("handling UpdatePowerSystemStabilizerDynamicsEvent - " + event);

    PowerSystemStabilizerDynamics entity = new PowerSystemStabilizerDynamics();
    entity.setPowerSystemStabilizerDynamicsId(event.getPowerSystemStabilizerDynamicsId());
    entity.setPowerSystemStabilizerDynamics(event.getPowerSystemStabilizerDynamics());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerSystemStabilizerDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerDynamics(entity);
  }

  /*
   * @param	event DeletePowerSystemStabilizerDynamicsEvent
   */
  @EventHandler(payloadType = DeletePowerSystemStabilizerDynamicsEvent.class)
  public void handle(DeletePowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info("handling DeletePowerSystemStabilizerDynamicsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PowerSystemStabilizerDynamics entity = delete(event.getPowerSystemStabilizerDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerDynamics(entity);
  }

  /*
   * @param	event AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent
   */
  @EventHandler(
      payloadType = AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent.class)
  public void handle(
      AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info(
        "handling AssignPowerSystemStabilizerDynamicsToPowerSystemStabilizerDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerSystemStabilizerDynamics entity =
        assignPowerSystemStabilizerDynamics(
            event.getPowerSystemStabilizerDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerSystemStabilizerDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerDynamics(entity);
  }

  /*
   * @param	event UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent
   */
  @EventHandler(
      payloadType =
          UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent.class)
  public void handle(
      UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignPowerSystemStabilizerDynamicsFromPowerSystemStabilizerDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerSystemStabilizerDynamics entity =
        unAssignPowerSystemStabilizerDynamics(event.getPowerSystemStabilizerDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerSystemStabilizerDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerSystemStabilizerDynamics(entity);
  }

  /**
   * Method to retrieve the PowerSystemStabilizerDynamics via an
   * PowerSystemStabilizerDynamicsPrimaryKey.
   *
   * @param id Long
   * @return PowerSystemStabilizerDynamics
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PowerSystemStabilizerDynamics handle(FindPowerSystemStabilizerDynamicsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPowerSystemStabilizerDynamicsId());
  }

  /**
   * Method to retrieve a collection of all PowerSystemStabilizerDynamicss
   *
   * @param query FindAllPowerSystemStabilizerDynamicsQuery
   * @return List<PowerSystemStabilizerDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PowerSystemStabilizerDynamics> handle(FindAllPowerSystemStabilizerDynamicsQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPowerSystemStabilizerDynamics, but only if the id
   * matches
   *
   * @param entity PowerSystemStabilizerDynamics
   */
  protected void emitFindPowerSystemStabilizerDynamics(PowerSystemStabilizerDynamics entity) {
    LOGGER.info("handling emitFindPowerSystemStabilizerDynamics");

    queryUpdateEmitter.emit(
        FindPowerSystemStabilizerDynamicsQuery.class,
        query ->
            query
                .getFilter()
                .getPowerSystemStabilizerDynamicsId()
                .equals(entity.getPowerSystemStabilizerDynamicsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPowerSystemStabilizerDynamics
   *
   * @param entity PowerSystemStabilizerDynamics
   */
  protected void emitFindAllPowerSystemStabilizerDynamics(PowerSystemStabilizerDynamics entity) {
    LOGGER.info("handling emitFindAllPowerSystemStabilizerDynamics");

    queryUpdateEmitter.emit(FindAllPowerSystemStabilizerDynamicsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerDynamicsProjector.class.getName());
}
