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
 * Projector for AsynchronousMachineDynamics as outlined for the CQRS pattern. All event handling
 * and query handling related to AsynchronousMachineDynamics are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by AsynchronousMachineDynamicsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("asynchronousMachineDynamics")
@Component("asynchronousMachineDynamics-projector")
public class AsynchronousMachineDynamicsProjector
    extends AsynchronousMachineDynamicsEntityProjector {

  // core constructor
  public AsynchronousMachineDynamicsProjector(
      AsynchronousMachineDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAsynchronousMachineDynamicsEvent
   */
  @EventHandler(payloadType = CreateAsynchronousMachineDynamicsEvent.class)
  public void handle(CreateAsynchronousMachineDynamicsEvent event) {
    LOGGER.info("handling CreateAsynchronousMachineDynamicsEvent - " + event);
    AsynchronousMachineDynamics entity = new AsynchronousMachineDynamics();
    entity.setAsynchronousMachineDynamicsId(event.getAsynchronousMachineDynamicsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineDynamics(entity);
  }

  /*
   * @param	event UpdateAsynchronousMachineDynamicsEvent
   */
  @EventHandler(payloadType = UpdateAsynchronousMachineDynamicsEvent.class)
  public void handle(UpdateAsynchronousMachineDynamicsEvent event) {
    LOGGER.info("handling UpdateAsynchronousMachineDynamicsEvent - " + event);

    AsynchronousMachineDynamics entity = new AsynchronousMachineDynamics();
    entity.setAsynchronousMachineDynamicsId(event.getAsynchronousMachineDynamicsId());
    entity.setAsynchronousMachineDynamics(event.getAsynchronousMachineDynamics());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineDynamics(entity);
  }

  /*
   * @param	event DeleteAsynchronousMachineDynamicsEvent
   */
  @EventHandler(payloadType = DeleteAsynchronousMachineDynamicsEvent.class)
  public void handle(DeleteAsynchronousMachineDynamicsEvent event) {
    LOGGER.info("handling DeleteAsynchronousMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AsynchronousMachineDynamics entity = delete(event.getAsynchronousMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineDynamics(entity);
  }

  /*
   * @param	event AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent
   */
  @EventHandler(
      payloadType = AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent.class)
  public void handle(AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent event) {
    LOGGER.info(
        "handling AssignAsynchronousMachineDynamicsToAsynchronousMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachineDynamics entity =
        assignAsynchronousMachineDynamics(
            event.getAsynchronousMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent
   */
  @EventHandler(
      payloadType = UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent.class)
  public void handle(
      UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignAsynchronousMachineDynamicsFromAsynchronousMachineDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachineDynamics entity =
        unAssignAsynchronousMachineDynamics(event.getAsynchronousMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachineDynamics(entity);
  }

  /**
   * Method to retrieve the AsynchronousMachineDynamics via an
   * AsynchronousMachineDynamicsPrimaryKey.
   *
   * @param id Long
   * @return AsynchronousMachineDynamics
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AsynchronousMachineDynamics handle(FindAsynchronousMachineDynamicsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAsynchronousMachineDynamicsId());
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineDynamicss
   *
   * @param query FindAllAsynchronousMachineDynamicsQuery
   * @return List<AsynchronousMachineDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AsynchronousMachineDynamics> handle(FindAllAsynchronousMachineDynamicsQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAsynchronousMachineDynamics, but only if the id
   * matches
   *
   * @param entity AsynchronousMachineDynamics
   */
  protected void emitFindAsynchronousMachineDynamics(AsynchronousMachineDynamics entity) {
    LOGGER.info("handling emitFindAsynchronousMachineDynamics");

    queryUpdateEmitter.emit(
        FindAsynchronousMachineDynamicsQuery.class,
        query ->
            query
                .getFilter()
                .getAsynchronousMachineDynamicsId()
                .equals(entity.getAsynchronousMachineDynamicsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllAsynchronousMachineDynamics
   *
   * @param entity AsynchronousMachineDynamics
   */
  protected void emitFindAllAsynchronousMachineDynamics(AsynchronousMachineDynamics entity) {
    LOGGER.info("handling emitFindAllAsynchronousMachineDynamics");

    queryUpdateEmitter.emit(FindAllAsynchronousMachineDynamicsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineDynamicsProjector.class.getName());
}
