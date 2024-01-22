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
 * Projector for ApparentPower as outlined for the CQRS pattern. All event handling and query
 * handling related to ApparentPower are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ApparentPowerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("apparentPower")
@Component("apparentPower-projector")
public class ApparentPowerProjector extends ApparentPowerEntityProjector {

  // core constructor
  public ApparentPowerProjector(
      ApparentPowerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateApparentPowerEvent
   */
  @EventHandler(payloadType = CreateApparentPowerEvent.class)
  public void handle(CreateApparentPowerEvent event) {
    LOGGER.info("handling CreateApparentPowerEvent - " + event);
    ApparentPower entity = new ApparentPower();
    entity.setApparentPowerId(event.getApparentPowerId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllApparentPower(entity);
  }

  /*
   * @param	event UpdateApparentPowerEvent
   */
  @EventHandler(payloadType = UpdateApparentPowerEvent.class)
  public void handle(UpdateApparentPowerEvent event) {
    LOGGER.info("handling UpdateApparentPowerEvent - " + event);

    ApparentPower entity = new ApparentPower();
    entity.setApparentPowerId(event.getApparentPowerId());
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
    emitFindApparentPower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllApparentPower(entity);
  }

  /*
   * @param	event DeleteApparentPowerEvent
   */
  @EventHandler(payloadType = DeleteApparentPowerEvent.class)
  public void handle(DeleteApparentPowerEvent event) {
    LOGGER.info("handling DeleteApparentPowerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ApparentPower entity = delete(event.getApparentPowerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllApparentPower(entity);
  }

  /*
   * @param	event AssignValueToApparentPowerEvent
   */
  @EventHandler(payloadType = AssignValueToApparentPowerEvent.class)
  public void handle(AssignValueToApparentPowerEvent event) {
    LOGGER.info("handling AssignValueToApparentPowerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ApparentPower entity = assignValue(event.getApparentPowerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindApparentPower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllApparentPower(entity);
  }

  /*
   * @param	event UnAssignValueFromApparentPowerEvent
   */
  @EventHandler(payloadType = UnAssignValueFromApparentPowerEvent.class)
  public void handle(UnAssignValueFromApparentPowerEvent event) {
    LOGGER.info("handling UnAssignValueFromApparentPowerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ApparentPower entity = unAssignValue(event.getApparentPowerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindApparentPower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllApparentPower(entity);
  }

  /**
   * Method to retrieve the ApparentPower via an ApparentPowerPrimaryKey.
   *
   * @param id Long
   * @return ApparentPower
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ApparentPower handle(FindApparentPowerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getApparentPowerId());
  }

  /**
   * Method to retrieve a collection of all ApparentPowers
   *
   * @param query FindAllApparentPowerQuery
   * @return List<ApparentPower>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ApparentPower> handle(FindAllApparentPowerQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindApparentPower, but only if the id matches
   *
   * @param entity ApparentPower
   */
  protected void emitFindApparentPower(ApparentPower entity) {
    LOGGER.info("handling emitFindApparentPower");

    queryUpdateEmitter.emit(
        FindApparentPowerQuery.class,
        query -> query.getFilter().getApparentPowerId().equals(entity.getApparentPowerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllApparentPower
   *
   * @param entity ApparentPower
   */
  protected void emitFindAllApparentPower(ApparentPower entity) {
    LOGGER.info("handling emitFindAllApparentPower");

    queryUpdateEmitter.emit(FindAllApparentPowerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ApparentPowerProjector.class.getName());
}
