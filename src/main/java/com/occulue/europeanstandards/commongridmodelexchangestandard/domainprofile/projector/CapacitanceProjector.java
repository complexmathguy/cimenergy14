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
 * Projector for Capacitance as outlined for the CQRS pattern. All event handling and query handling
 * related to Capacitance are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by CapacitanceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("capacitance")
@Component("capacitance-projector")
public class CapacitanceProjector extends CapacitanceEntityProjector {

  // core constructor
  public CapacitanceProjector(
      CapacitanceRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateCapacitanceEvent
   */
  @EventHandler(payloadType = CreateCapacitanceEvent.class)
  public void handle(CreateCapacitanceEvent event) {
    LOGGER.info("handling CreateCapacitanceEvent - " + event);
    Capacitance entity = new Capacitance();
    entity.setCapacitanceId(event.getCapacitanceId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitance(entity);
  }

  /*
   * @param	event UpdateCapacitanceEvent
   */
  @EventHandler(payloadType = UpdateCapacitanceEvent.class)
  public void handle(UpdateCapacitanceEvent event) {
    LOGGER.info("handling UpdateCapacitanceEvent - " + event);

    Capacitance entity = new Capacitance();
    entity.setCapacitanceId(event.getCapacitanceId());
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
    emitFindCapacitance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitance(entity);
  }

  /*
   * @param	event DeleteCapacitanceEvent
   */
  @EventHandler(payloadType = DeleteCapacitanceEvent.class)
  public void handle(DeleteCapacitanceEvent event) {
    LOGGER.info("handling DeleteCapacitanceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Capacitance entity = delete(event.getCapacitanceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitance(entity);
  }

  /*
   * @param	event AssignValueToCapacitanceEvent
   */
  @EventHandler(payloadType = AssignValueToCapacitanceEvent.class)
  public void handle(AssignValueToCapacitanceEvent event) {
    LOGGER.info("handling AssignValueToCapacitanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Capacitance entity = assignValue(event.getCapacitanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCapacitance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitance(entity);
  }

  /*
   * @param	event UnAssignValueFromCapacitanceEvent
   */
  @EventHandler(payloadType = UnAssignValueFromCapacitanceEvent.class)
  public void handle(UnAssignValueFromCapacitanceEvent event) {
    LOGGER.info("handling UnAssignValueFromCapacitanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Capacitance entity = unAssignValue(event.getCapacitanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCapacitance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCapacitance(entity);
  }

  /**
   * Method to retrieve the Capacitance via an CapacitancePrimaryKey.
   *
   * @param id Long
   * @return Capacitance
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Capacitance handle(FindCapacitanceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getCapacitanceId());
  }

  /**
   * Method to retrieve a collection of all Capacitances
   *
   * @param query FindAllCapacitanceQuery
   * @return List<Capacitance>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Capacitance> handle(FindAllCapacitanceQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindCapacitance, but only if the id matches
   *
   * @param entity Capacitance
   */
  protected void emitFindCapacitance(Capacitance entity) {
    LOGGER.info("handling emitFindCapacitance");

    queryUpdateEmitter.emit(
        FindCapacitanceQuery.class,
        query -> query.getFilter().getCapacitanceId().equals(entity.getCapacitanceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllCapacitance
   *
   * @param entity Capacitance
   */
  protected void emitFindAllCapacitance(Capacitance entity) {
    LOGGER.info("handling emitFindAllCapacitance");

    queryUpdateEmitter.emit(FindAllCapacitanceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(CapacitanceProjector.class.getName());
}
