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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for TieFlow as outlined for the CQRS pattern. All event handling and query handling
 * related to TieFlow are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by TieFlowAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("tieFlow")
@Component("tieFlow-projector")
public class TieFlowProjector extends TieFlowEntityProjector {

  // core constructor
  public TieFlowProjector(TieFlowRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTieFlowEvent
   */
  @EventHandler(payloadType = CreateTieFlowEvent.class)
  public void handle(CreateTieFlowEvent event) {
    LOGGER.info("handling CreateTieFlowEvent - " + event);
    TieFlow entity = new TieFlow();
    entity.setTieFlowId(event.getTieFlowId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /*
   * @param	event UpdateTieFlowEvent
   */
  @EventHandler(payloadType = UpdateTieFlowEvent.class)
  public void handle(UpdateTieFlowEvent event) {
    LOGGER.info("handling UpdateTieFlowEvent - " + event);

    TieFlow entity = new TieFlow();
    entity.setTieFlowId(event.getTieFlowId());
    entity.setPositiveFlowIn(event.getPositiveFlowIn());
    entity.setTieFlow(event.getTieFlow());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTieFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /*
   * @param	event DeleteTieFlowEvent
   */
  @EventHandler(payloadType = DeleteTieFlowEvent.class)
  public void handle(DeleteTieFlowEvent event) {
    LOGGER.info("handling DeleteTieFlowEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TieFlow entity = delete(event.getTieFlowId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /*
   * @param	event AssignPositiveFlowInToTieFlowEvent
   */
  @EventHandler(payloadType = AssignPositiveFlowInToTieFlowEvent.class)
  public void handle(AssignPositiveFlowInToTieFlowEvent event) {
    LOGGER.info("handling AssignPositiveFlowInToTieFlowEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TieFlow entity = assignPositiveFlowIn(event.getTieFlowId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTieFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /*
   * @param	event UnAssignPositiveFlowInFromTieFlowEvent
   */
  @EventHandler(payloadType = UnAssignPositiveFlowInFromTieFlowEvent.class)
  public void handle(UnAssignPositiveFlowInFromTieFlowEvent event) {
    LOGGER.info("handling UnAssignPositiveFlowInFromTieFlowEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TieFlow entity = unAssignPositiveFlowIn(event.getTieFlowId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTieFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /*
   * @param	event AssignTieFlowToTieFlowEvent
   */
  @EventHandler(payloadType = AssignTieFlowToTieFlowEvent.class)
  public void handle(AssignTieFlowToTieFlowEvent event) {
    LOGGER.info("handling AssignTieFlowToTieFlowEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    TieFlow entity = addToTieFlow(event.getTieFlowId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTieFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /*
   * @param	event RemoveTieFlowFromTieFlowEvent
   */
  @EventHandler(payloadType = RemoveTieFlowFromTieFlowEvent.class)
  public void handle(RemoveTieFlowFromTieFlowEvent event) {
    LOGGER.info("handling RemoveTieFlowFromTieFlowEvent - " + event);

    TieFlow entity = removeFromTieFlow(event.getTieFlowId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTieFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTieFlow(entity);
  }

  /**
   * Method to retrieve the TieFlow via an TieFlowPrimaryKey.
   *
   * @param id Long
   * @return TieFlow
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TieFlow handle(FindTieFlowQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTieFlowId());
  }

  /**
   * Method to retrieve a collection of all TieFlows
   *
   * @param query FindAllTieFlowQuery
   * @return List<TieFlow>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TieFlow> handle(FindAllTieFlowQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTieFlow, but only if the id matches
   *
   * @param entity TieFlow
   */
  protected void emitFindTieFlow(TieFlow entity) {
    LOGGER.info("handling emitFindTieFlow");

    queryUpdateEmitter.emit(
        FindTieFlowQuery.class,
        query -> query.getFilter().getTieFlowId().equals(entity.getTieFlowId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTieFlow
   *
   * @param entity TieFlow
   */
  protected void emitFindAllTieFlow(TieFlow entity) {
    LOGGER.info("handling emitFindAllTieFlow");

    queryUpdateEmitter.emit(FindAllTieFlowQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(TieFlowProjector.class.getName());
}
