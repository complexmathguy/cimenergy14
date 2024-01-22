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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DiscontinuousExcitationControlDynamics as outlined for the CQRS pattern. All event
 * handling and query handling related to DiscontinuousExcitationControlDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by DiscontinuousExcitationControlDynamicsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("discontinuousExcitationControlDynamics")
@Component("discontinuousExcitationControlDynamics-projector")
public class DiscontinuousExcitationControlDynamicsProjector
    extends DiscontinuousExcitationControlDynamicsEntityProjector {

  // core constructor
  public DiscontinuousExcitationControlDynamicsProjector(
      DiscontinuousExcitationControlDynamicsRepository repository,
      QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDiscontinuousExcitationControlDynamicsEvent
   */
  @EventHandler(payloadType = CreateDiscontinuousExcitationControlDynamicsEvent.class)
  public void handle(CreateDiscontinuousExcitationControlDynamicsEvent event) {
    LOGGER.info("handling CreateDiscontinuousExcitationControlDynamicsEvent - " + event);
    DiscontinuousExcitationControlDynamics entity = new DiscontinuousExcitationControlDynamics();
    entity.setDiscontinuousExcitationControlDynamicsId(
        event.getDiscontinuousExcitationControlDynamicsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscontinuousExcitationControlDynamics(entity);
  }

  /*
   * @param	event UpdateDiscontinuousExcitationControlDynamicsEvent
   */
  @EventHandler(payloadType = UpdateDiscontinuousExcitationControlDynamicsEvent.class)
  public void handle(UpdateDiscontinuousExcitationControlDynamicsEvent event) {
    LOGGER.info("handling UpdateDiscontinuousExcitationControlDynamicsEvent - " + event);

    DiscontinuousExcitationControlDynamics entity = new DiscontinuousExcitationControlDynamics();
    entity.setDiscontinuousExcitationControlDynamicsId(
        event.getDiscontinuousExcitationControlDynamicsId());
    entity.setDiscontinuousExcitationControlDynamics(
        event.getDiscontinuousExcitationControlDynamics());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscontinuousExcitationControlDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscontinuousExcitationControlDynamics(entity);
  }

  /*
   * @param	event DeleteDiscontinuousExcitationControlDynamicsEvent
   */
  @EventHandler(payloadType = DeleteDiscontinuousExcitationControlDynamicsEvent.class)
  public void handle(DeleteDiscontinuousExcitationControlDynamicsEvent event) {
    LOGGER.info("handling DeleteDiscontinuousExcitationControlDynamicsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DiscontinuousExcitationControlDynamics entity =
        delete(event.getDiscontinuousExcitationControlDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscontinuousExcitationControlDynamics(entity);
  }

  /*
   * @param	event AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent
   */
  @EventHandler(
      payloadType =
          AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent
              .class)
  public void handle(
      AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent
          event) {
    LOGGER.info(
        "handling AssignDiscontinuousExcitationControlDynamicsToDiscontinuousExcitationControlDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiscontinuousExcitationControlDynamics entity =
        assignDiscontinuousExcitationControlDynamics(
            event.getDiscontinuousExcitationControlDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscontinuousExcitationControlDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscontinuousExcitationControlDynamics(entity);
  }

  /*
   * @param	event UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent
   */
  @EventHandler(
      payloadType =
          UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent
              .class)
  public void handle(
      UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent
          event) {
    LOGGER.info(
        "handling UnAssignDiscontinuousExcitationControlDynamicsFromDiscontinuousExcitationControlDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiscontinuousExcitationControlDynamics entity =
        unAssignDiscontinuousExcitationControlDynamics(
            event.getDiscontinuousExcitationControlDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiscontinuousExcitationControlDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiscontinuousExcitationControlDynamics(entity);
  }

  /**
   * Method to retrieve the DiscontinuousExcitationControlDynamics via an
   * DiscontinuousExcitationControlDynamicsPrimaryKey.
   *
   * @param id Long
   * @return DiscontinuousExcitationControlDynamics
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DiscontinuousExcitationControlDynamics handle(
      FindDiscontinuousExcitationControlDynamicsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDiscontinuousExcitationControlDynamicsId());
  }

  /**
   * Method to retrieve a collection of all DiscontinuousExcitationControlDynamicss
   *
   * @param query FindAllDiscontinuousExcitationControlDynamicsQuery
   * @return List<DiscontinuousExcitationControlDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DiscontinuousExcitationControlDynamics> handle(
      FindAllDiscontinuousExcitationControlDynamicsQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDiscontinuousExcitationControlDynamics, but only if
   * the id matches
   *
   * @param entity DiscontinuousExcitationControlDynamics
   */
  protected void emitFindDiscontinuousExcitationControlDynamics(
      DiscontinuousExcitationControlDynamics entity) {
    LOGGER.info("handling emitFindDiscontinuousExcitationControlDynamics");

    queryUpdateEmitter.emit(
        FindDiscontinuousExcitationControlDynamicsQuery.class,
        query ->
            query
                .getFilter()
                .getDiscontinuousExcitationControlDynamicsId()
                .equals(entity.getDiscontinuousExcitationControlDynamicsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type
   * FindAllDiscontinuousExcitationControlDynamics
   *
   * @param entity DiscontinuousExcitationControlDynamics
   */
  protected void emitFindAllDiscontinuousExcitationControlDynamics(
      DiscontinuousExcitationControlDynamics entity) {
    LOGGER.info("handling emitFindAllDiscontinuousExcitationControlDynamics");

    queryUpdateEmitter.emit(
        FindAllDiscontinuousExcitationControlDynamicsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(DiscontinuousExcitationControlDynamicsProjector.class.getName());
}
