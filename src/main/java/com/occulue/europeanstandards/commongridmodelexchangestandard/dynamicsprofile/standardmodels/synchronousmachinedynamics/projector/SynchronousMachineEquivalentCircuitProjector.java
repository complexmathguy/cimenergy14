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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachineEquivalentCircuit as outlined for the CQRS pattern. All event
 * handling and query handling related to SynchronousMachineEquivalentCircuit are invoked here and
 * dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SynchronousMachineEquivalentCircuitAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("synchronousMachineEquivalentCircuit")
@Component("synchronousMachineEquivalentCircuit-projector")
public class SynchronousMachineEquivalentCircuitProjector
    extends SynchronousMachineEquivalentCircuitEntityProjector {

  // core constructor
  public SynchronousMachineEquivalentCircuitProjector(
      SynchronousMachineEquivalentCircuitRepository repository,
      QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = CreateSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(CreateSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling CreateSynchronousMachineEquivalentCircuitEvent - " + event);
    SynchronousMachineEquivalentCircuit entity = new SynchronousMachineEquivalentCircuit();
    entity.setSynchronousMachineEquivalentCircuitId(
        event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UpdateSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UpdateSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UpdateSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UpdateSynchronousMachineEquivalentCircuitEvent - " + event);

    SynchronousMachineEquivalentCircuit entity = new SynchronousMachineEquivalentCircuit();
    entity.setSynchronousMachineEquivalentCircuitId(
        event.getSynchronousMachineEquivalentCircuitId());
    entity.setR1d(event.getR1d());
    entity.setR1q(event.getR1q());
    entity.setR2q(event.getR2q());
    entity.setRfd(event.getRfd());
    entity.setX1d(event.getX1d());
    entity.setX1q(event.getX1q());
    entity.setX2q(event.getX2q());
    entity.setXad(event.getXad());
    entity.setXaq(event.getXaq());
    entity.setXf1d(event.getXf1d());
    entity.setXfd(event.getXfd());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event DeleteSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = DeleteSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(DeleteSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling DeleteSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        delete(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignR1dToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignR1dToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignR1dToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignR1dToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignR1d(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignR1dFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignR1d(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignR1qToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignR1qToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignR1qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignR1qToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignR1q(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignR1qFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignR1q(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignR2qToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignR2qToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignR2qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignR2qToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignR2q(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignR2qFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignR2q(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignRfdToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignRfdToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignRfdToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignRfdToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignRfd(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignRfdFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignRfd(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignX1dToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignX1dToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignX1dToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignX1dToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignX1d(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignX1dFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignX1d(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignX1qToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignX1qToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignX1qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignX1qToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignX1q(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignX1qFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignX1q(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignX2qToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignX2qToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignX2qToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignX2qToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignX2q(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignX2qFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignX2q(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXadToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXadToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXadToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXadToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignXad(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXadFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXadFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXadFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXadFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignXad(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXaqToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXaqToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXaqToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXaqToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignXaq(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXaqFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignXaq(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXf1dToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXf1dToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXf1dToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXf1dToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignXf1d(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXf1dFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignXf1d(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXfdToSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXfdToSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXfdToSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXfdToSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        assignXfd(event.getSynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXfdFromSynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity =
        unAssignXfd(event.getSynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineEquivalentCircuit(entity);
  }

  /**
   * Method to retrieve the SynchronousMachineEquivalentCircuit via an
   * SynchronousMachineEquivalentCircuitPrimaryKey.
   *
   * @param id Long
   * @return SynchronousMachineEquivalentCircuit
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SynchronousMachineEquivalentCircuit handle(
      FindSynchronousMachineEquivalentCircuitQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSynchronousMachineEquivalentCircuitId());
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineEquivalentCircuits
   *
   * @param query FindAllSynchronousMachineEquivalentCircuitQuery
   * @return List<SynchronousMachineEquivalentCircuit>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SynchronousMachineEquivalentCircuit> handle(
      FindAllSynchronousMachineEquivalentCircuitQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSynchronousMachineEquivalentCircuit, but only if the
   * id matches
   *
   * @param entity SynchronousMachineEquivalentCircuit
   */
  protected void emitFindSynchronousMachineEquivalentCircuit(
      SynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("handling emitFindSynchronousMachineEquivalentCircuit");

    queryUpdateEmitter.emit(
        FindSynchronousMachineEquivalentCircuitQuery.class,
        query ->
            query
                .getFilter()
                .getSynchronousMachineEquivalentCircuitId()
                .equals(entity.getSynchronousMachineEquivalentCircuitId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSynchronousMachineEquivalentCircuit
   *
   * @param entity SynchronousMachineEquivalentCircuit
   */
  protected void emitFindAllSynchronousMachineEquivalentCircuit(
      SynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("handling emitFindAllSynchronousMachineEquivalentCircuit");

    queryUpdateEmitter.emit(
        FindAllSynchronousMachineEquivalentCircuitQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineEquivalentCircuitProjector.class.getName());
}
