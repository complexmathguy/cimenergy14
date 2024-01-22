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
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ActivePowerPerFrequency as outlined for the CQRS pattern. All event handling and
 * query handling related to ActivePowerPerFrequency are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by ActivePowerPerFrequencyAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("activePowerPerFrequency")
@Component("activePowerPerFrequency-projector")
public class ActivePowerPerFrequencyProjector extends ActivePowerPerFrequencyEntityProjector {

  // core constructor
  public ActivePowerPerFrequencyProjector(
      ActivePowerPerFrequencyRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateActivePowerPerFrequencyEvent
   */
  @EventHandler(payloadType = CreateActivePowerPerFrequencyEvent.class)
  public void handle(CreateActivePowerPerFrequencyEvent event) {
    LOGGER.info("handling CreateActivePowerPerFrequencyEvent - " + event);
    ActivePowerPerFrequency entity = new ActivePowerPerFrequency();
    entity.setActivePowerPerFrequencyId(event.getActivePowerPerFrequencyId());
    entity.setDenominatorMultiplier(event.getDenominatorMultiplier());
    entity.setDenominatorUnit(event.getDenominatorUnit());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerPerFrequency(entity);
  }

  /*
   * @param	event UpdateActivePowerPerFrequencyEvent
   */
  @EventHandler(payloadType = UpdateActivePowerPerFrequencyEvent.class)
  public void handle(UpdateActivePowerPerFrequencyEvent event) {
    LOGGER.info("handling UpdateActivePowerPerFrequencyEvent - " + event);

    ActivePowerPerFrequency entity = new ActivePowerPerFrequency();
    entity.setActivePowerPerFrequencyId(event.getActivePowerPerFrequencyId());
    entity.setDenominatorMultiplier(event.getDenominatorMultiplier());
    entity.setDenominatorUnit(event.getDenominatorUnit());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());
    entity.setValue(event.getValue());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindActivePowerPerFrequency(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerPerFrequency(entity);
  }

  /*
   * @param	event DeleteActivePowerPerFrequencyEvent
   */
  @EventHandler(payloadType = DeleteActivePowerPerFrequencyEvent.class)
  public void handle(DeleteActivePowerPerFrequencyEvent event) {
    LOGGER.info("handling DeleteActivePowerPerFrequencyEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ActivePowerPerFrequency entity = delete(event.getActivePowerPerFrequencyId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerPerFrequency(entity);
  }

  /*
   * @param	event AssignValueToActivePowerPerFrequencyEvent
   */
  @EventHandler(payloadType = AssignValueToActivePowerPerFrequencyEvent.class)
  public void handle(AssignValueToActivePowerPerFrequencyEvent event) {
    LOGGER.info("handling AssignValueToActivePowerPerFrequencyEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ActivePowerPerFrequency entity =
        assignValue(event.getActivePowerPerFrequencyId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindActivePowerPerFrequency(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerPerFrequency(entity);
  }

  /*
   * @param	event UnAssignValueFromActivePowerPerFrequencyEvent
   */
  @EventHandler(payloadType = UnAssignValueFromActivePowerPerFrequencyEvent.class)
  public void handle(UnAssignValueFromActivePowerPerFrequencyEvent event) {
    LOGGER.info("handling UnAssignValueFromActivePowerPerFrequencyEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ActivePowerPerFrequency entity = unAssignValue(event.getActivePowerPerFrequencyId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindActivePowerPerFrequency(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllActivePowerPerFrequency(entity);
  }

  /**
   * Method to retrieve the ActivePowerPerFrequency via an ActivePowerPerFrequencyPrimaryKey.
   *
   * @param id Long
   * @return ActivePowerPerFrequency
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ActivePowerPerFrequency handle(FindActivePowerPerFrequencyQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getActivePowerPerFrequencyId());
  }

  /**
   * Method to retrieve a collection of all ActivePowerPerFrequencys
   *
   * @param query FindAllActivePowerPerFrequencyQuery
   * @return List<ActivePowerPerFrequency>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ActivePowerPerFrequency> handle(FindAllActivePowerPerFrequencyQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindActivePowerPerFrequency, but only if the id matches
   *
   * @param entity ActivePowerPerFrequency
   */
  protected void emitFindActivePowerPerFrequency(ActivePowerPerFrequency entity) {
    LOGGER.info("handling emitFindActivePowerPerFrequency");

    queryUpdateEmitter.emit(
        FindActivePowerPerFrequencyQuery.class,
        query ->
            query
                .getFilter()
                .getActivePowerPerFrequencyId()
                .equals(entity.getActivePowerPerFrequencyId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllActivePowerPerFrequency
   *
   * @param entity ActivePowerPerFrequency
   */
  protected void emitFindAllActivePowerPerFrequency(ActivePowerPerFrequency entity) {
    LOGGER.info("handling emitFindAllActivePowerPerFrequency");

    queryUpdateEmitter.emit(FindAllActivePowerPerFrequencyQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(ActivePowerPerFrequencyProjector.class.getName());
}
