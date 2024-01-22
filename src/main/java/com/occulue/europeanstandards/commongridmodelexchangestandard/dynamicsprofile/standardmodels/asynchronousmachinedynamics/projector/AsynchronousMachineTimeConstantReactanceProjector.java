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
 * Projector for AsynchronousMachineTimeConstantReactance as outlined for the CQRS pattern. All
 * event handling and query handling related to AsynchronousMachineTimeConstantReactance are invoked
 * here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by AsynchronousMachineTimeConstantReactanceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("asynchronousMachineTimeConstantReactance")
@Component("asynchronousMachineTimeConstantReactance-projector")
public class AsynchronousMachineTimeConstantReactanceProjector
    extends AsynchronousMachineTimeConstantReactanceEntityProjector {

  // core constructor
  public AsynchronousMachineTimeConstantReactanceProjector(
      AsynchronousMachineTimeConstantReactanceRepository repository,
      QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = CreateAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(CreateAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling CreateAsynchronousMachineTimeConstantReactanceEvent - " + event);
    AsynchronousMachineTimeConstantReactance entity =
        new AsynchronousMachineTimeConstantReactance();
    entity.setAsynchronousMachineTimeConstantReactanceId(
        event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UpdateAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UpdateAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UpdateAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UpdateAsynchronousMachineTimeConstantReactanceEvent - " + event);

    AsynchronousMachineTimeConstantReactance entity =
        new AsynchronousMachineTimeConstantReactance();
    entity.setAsynchronousMachineTimeConstantReactanceId(
        event.getAsynchronousMachineTimeConstantReactanceId());
    entity.setTpo(event.getTpo());
    entity.setTppo(event.getTppo());
    entity.setXp(event.getXp());
    entity.setXpp(event.getXpp());
    entity.setXs(event.getXs());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event DeleteAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = DeleteAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(DeleteAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling DeleteAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        delete(event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTpoToAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTpoToAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTpoToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTpoToAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        assignTpo(event.getAsynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignTpoFromAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        unAssignTpo(event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignTppoToAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignTppoToAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignTppoToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignTppoToAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        assignTppo(event.getAsynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "handling UnAssignTppoFromAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        unAssignTppo(event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXpToAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignXpToAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXpToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignXpToAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        assignXp(event.getAsynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignXpFromAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        unAssignXp(event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXppToAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignXppToAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXppToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignXppToAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        assignXpp(event.getAsynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignXppFromAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        unAssignXpp(event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event AssignXsToAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = AssignXsToAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(AssignXsToAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling AssignXsToAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        assignXs(event.getAsynchronousMachineTimeConstantReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /*
   * @param	event UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent
   */
  @EventHandler(payloadType = UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent.class)
  public void handle(UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("handling UnAssignXsFromAsynchronousMachineTimeConstantReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity =
        unAssignXs(event.getAsynchronousMachineTimeConstantReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineTimeConstantReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineTimeConstantReactance(entity);
  }

  /**
   * Method to retrieve the AsynchronousMachineTimeConstantReactance via an
   * AsynchronousMachineTimeConstantReactancePrimaryKey.
   *
   * @param id Long
   * @return AsynchronousMachineTimeConstantReactance
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AsynchronousMachineTimeConstantReactance handle(
      FindAsynchronousMachineTimeConstantReactanceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAsynchronousMachineTimeConstantReactanceId());
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineTimeConstantReactances
   *
   * @param query FindAllAsynchronousMachineTimeConstantReactanceQuery
   * @return List<AsynchronousMachineTimeConstantReactance>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AsynchronousMachineTimeConstantReactance> handle(
      FindAllAsynchronousMachineTimeConstantReactanceQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAsynchronousMachineTimeConstantReactance, but only if
   * the id matches
   *
   * @param entity AsynchronousMachineTimeConstantReactance
   */
  protected void emitFindAsynchronousMachineTimeConstantReactance(
      AsynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("handling emitFindAsynchronousMachineTimeConstantReactance");

    queryUpdateEmitter.emit(
        FindAsynchronousMachineTimeConstantReactanceQuery.class,
        query ->
            query
                .getFilter()
                .getAsynchronousMachineTimeConstantReactanceId()
                .equals(entity.getAsynchronousMachineTimeConstantReactanceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type
   * FindAllAsynchronousMachineTimeConstantReactance
   *
   * @param entity AsynchronousMachineTimeConstantReactance
   */
  protected void emitFindAllAsynchronousMachineTimeConstantReactance(
      AsynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("handling emitFindAllAsynchronousMachineTimeConstantReactance");

    queryUpdateEmitter.emit(
        FindAllAsynchronousMachineTimeConstantReactanceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineTimeConstantReactanceProjector.class.getName());
}
