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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for AsynchronousMachineEquivalentCircuit as outlined for the CQRS pattern. All event
 * handling and query handling related to AsynchronousMachineEquivalentCircuit are invoked here and
 * dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by AsynchronousMachineEquivalentCircuitAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("asynchronousMachineEquivalentCircuit")
@Component("asynchronousMachineEquivalentCircuit-projector")
public class AsynchronousMachineEquivalentCircuitProjector
    extends AsynchronousMachineEquivalentCircuitEntityProjector {

  // core constructor
  public AsynchronousMachineEquivalentCircuitProjector(
      AsynchronousMachineEquivalentCircuitRepository repository,
      QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = CreateAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(CreateAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling CreateAsynchronousMachineEquivalentCircuitEvent - " + event);
    AsynchronousMachineEquivalentCircuit entity = new AsynchronousMachineEquivalentCircuit();
    entity.setAsynchronousMachineEquivalentCircuitId(
        event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UpdateAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UpdateAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UpdateAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UpdateAsynchronousMachineEquivalentCircuitEvent - " + event);

    AsynchronousMachineEquivalentCircuit entity = new AsynchronousMachineEquivalentCircuit();
    entity.setAsynchronousMachineEquivalentCircuitId(
        event.getAsynchronousMachineEquivalentCircuitId());
    entity.setRr1(event.getRr1());
    entity.setRr2(event.getRr2());
    entity.setXlr1(event.getXlr1());
    entity.setXlr2(event.getXlr2());
    entity.setXm(event.getXm());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event DeleteAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = DeleteAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(DeleteAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling DeleteAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        delete(event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignRr1ToAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignRr1ToAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignRr1ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignRr1ToAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        assignRr1(event.getAsynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignRr1FromAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        unAssignRr1(event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignRr2ToAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignRr2ToAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignRr2ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignRr2ToAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        assignRr2(event.getAsynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignRr2FromAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        unAssignRr2(event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXlr1ToAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        assignXlr1(event.getAsynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXlr1FromAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        unAssignXlr1(event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXlr2ToAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        assignXlr2(event.getAsynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXlr2FromAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        unAssignXlr2(event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event AssignXmToAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = AssignXmToAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(AssignXmToAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling AssignXmToAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        assignXm(event.getAsynchronousMachineEquivalentCircuitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /*
   * @param	event UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent
   */
  @EventHandler(payloadType = UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent.class)
  public void handle(UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent event) {
    LOGGER.info("handling UnAssignXmFromAsynchronousMachineEquivalentCircuitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity =
        unAssignXm(event.getAsynchronousMachineEquivalentCircuitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineEquivalentCircuit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineEquivalentCircuit(entity);
  }

  /**
   * Method to retrieve the AsynchronousMachineEquivalentCircuit via an
   * AsynchronousMachineEquivalentCircuitPrimaryKey.
   *
   * @param id Long
   * @return AsynchronousMachineEquivalentCircuit
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AsynchronousMachineEquivalentCircuit handle(
      FindAsynchronousMachineEquivalentCircuitQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAsynchronousMachineEquivalentCircuitId());
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineEquivalentCircuits
   *
   * @param query FindAllAsynchronousMachineEquivalentCircuitQuery
   * @return List<AsynchronousMachineEquivalentCircuit>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AsynchronousMachineEquivalentCircuit> handle(
      FindAllAsynchronousMachineEquivalentCircuitQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAsynchronousMachineEquivalentCircuit, but only if the
   * id matches
   *
   * @param entity AsynchronousMachineEquivalentCircuit
   */
  protected void emitFindAsynchronousMachineEquivalentCircuit(
      AsynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("handling emitFindAsynchronousMachineEquivalentCircuit");

    queryUpdateEmitter.emit(
        FindAsynchronousMachineEquivalentCircuitQuery.class,
        query ->
            query
                .getFilter()
                .getAsynchronousMachineEquivalentCircuitId()
                .equals(entity.getAsynchronousMachineEquivalentCircuitId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type
   * FindAllAsynchronousMachineEquivalentCircuit
   *
   * @param entity AsynchronousMachineEquivalentCircuit
   */
  protected void emitFindAllAsynchronousMachineEquivalentCircuit(
      AsynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("handling emitFindAllAsynchronousMachineEquivalentCircuit");

    queryUpdateEmitter.emit(
        FindAllAsynchronousMachineEquivalentCircuitQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineEquivalentCircuitProjector.class.getName());
}
