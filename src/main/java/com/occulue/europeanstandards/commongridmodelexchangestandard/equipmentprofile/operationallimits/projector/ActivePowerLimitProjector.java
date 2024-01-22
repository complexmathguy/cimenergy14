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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ActivePowerLimit as outlined for the CQRS pattern. All event handling and query
 * handling related to ActivePowerLimit are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ActivePowerLimitAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("activePowerLimit")
@Component("activePowerLimit-projector")
public class ActivePowerLimitProjector extends ActivePowerLimitEntityProjector {

  // core constructor
  public ActivePowerLimitProjector(
      ActivePowerLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateActivePowerLimitEvent
   */
  @EventHandler(payloadType = CreateActivePowerLimitEvent.class)
  public void handle(CreateActivePowerLimitEvent event) {
    LOGGER.info("handling CreateActivePowerLimitEvent - " + event);
    ActivePowerLimit entity = new ActivePowerLimit();
    entity.setActivePowerLimitId(event.getActivePowerLimitId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerLimit(entity);
  }

  /*
   * @param	event UpdateActivePowerLimitEvent
   */
  @EventHandler(payloadType = UpdateActivePowerLimitEvent.class)
  public void handle(UpdateActivePowerLimitEvent event) {
    LOGGER.info("handling UpdateActivePowerLimitEvent - " + event);

    ActivePowerLimit entity = new ActivePowerLimit();
    entity.setActivePowerLimitId(event.getActivePowerLimitId());
    entity.setValue(event.getValue());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindActivePowerLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerLimit(entity);
  }

  /*
   * @param	event DeleteActivePowerLimitEvent
   */
  @EventHandler(payloadType = DeleteActivePowerLimitEvent.class)
  public void handle(DeleteActivePowerLimitEvent event) {
    LOGGER.info("handling DeleteActivePowerLimitEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ActivePowerLimit entity = delete(event.getActivePowerLimitId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerLimit(entity);
  }

  /*
   * @param	event AssignValueToActivePowerLimitEvent
   */
  @EventHandler(payloadType = AssignValueToActivePowerLimitEvent.class)
  public void handle(AssignValueToActivePowerLimitEvent event) {
    LOGGER.info("handling AssignValueToActivePowerLimitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ActivePowerLimit entity = assignValue(event.getActivePowerLimitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindActivePowerLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerLimit(entity);
  }

  /*
   * @param	event UnAssignValueFromActivePowerLimitEvent
   */
  @EventHandler(payloadType = UnAssignValueFromActivePowerLimitEvent.class)
  public void handle(UnAssignValueFromActivePowerLimitEvent event) {
    LOGGER.info("handling UnAssignValueFromActivePowerLimitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ActivePowerLimit entity = unAssignValue(event.getActivePowerLimitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindActivePowerLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerLimit(entity);
  }

  /**
   * Method to retrieve the ActivePowerLimit via an ActivePowerLimitPrimaryKey.
   *
   * @param id Long
   * @return ActivePowerLimit
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ActivePowerLimit handle(FindActivePowerLimitQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getActivePowerLimitId());
  }

  /**
   * Method to retrieve a collection of all ActivePowerLimits
   *
   * @param query FindAllActivePowerLimitQuery
   * @return List<ActivePowerLimit>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ActivePowerLimit> handle(FindAllActivePowerLimitQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindActivePowerLimit, but only if the id matches
   *
   * @param entity ActivePowerLimit
   */
  protected void emitFindActivePowerLimit(ActivePowerLimit entity) {
    LOGGER.info("handling emitFindActivePowerLimit");

    queryUpdateEmitter.emit(
        FindActivePowerLimitQuery.class,
        query -> query.getFilter().getActivePowerLimitId().equals(entity.getActivePowerLimitId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllActivePowerLimit
   *
   * @param entity ActivePowerLimit
   */
  protected void emitFindAllActivePowerLimit(ActivePowerLimit entity) {
    LOGGER.info("handling emitFindAllActivePowerLimit");

    queryUpdateEmitter.emit(FindAllActivePowerLimitQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ActivePowerLimitProjector.class.getName());
}
