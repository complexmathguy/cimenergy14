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
 * Projector for OperationalLimitSet as outlined for the CQRS pattern. All event handling and query
 * handling related to OperationalLimitSet are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by OperationalLimitSetAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("operationalLimitSet")
@Component("operationalLimitSet-projector")
public class OperationalLimitSetProjector extends OperationalLimitSetEntityProjector {

  // core constructor
  public OperationalLimitSetProjector(
      OperationalLimitSetRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateOperationalLimitSetEvent
   */
  @EventHandler(payloadType = CreateOperationalLimitSetEvent.class)
  public void handle(CreateOperationalLimitSetEvent event) {
    LOGGER.info("handling CreateOperationalLimitSetEvent - " + event);
    OperationalLimitSet entity = new OperationalLimitSet();
    entity.setOperationalLimitSetId(event.getOperationalLimitSetId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOperationalLimitSet(entity);
  }

  /*
   * @param	event UpdateOperationalLimitSetEvent
   */
  @EventHandler(payloadType = UpdateOperationalLimitSetEvent.class)
  public void handle(UpdateOperationalLimitSetEvent event) {
    LOGGER.info("handling UpdateOperationalLimitSetEvent - " + event);

    OperationalLimitSet entity = new OperationalLimitSet();
    entity.setOperationalLimitSetId(event.getOperationalLimitSetId());
    entity.setOperationalLimitSet(event.getOperationalLimitSet());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOperationalLimitSet(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOperationalLimitSet(entity);
  }

  /*
   * @param	event DeleteOperationalLimitSetEvent
   */
  @EventHandler(payloadType = DeleteOperationalLimitSetEvent.class)
  public void handle(DeleteOperationalLimitSetEvent event) {
    LOGGER.info("handling DeleteOperationalLimitSetEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    OperationalLimitSet entity = delete(event.getOperationalLimitSetId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOperationalLimitSet(entity);
  }

  /*
   * @param	event AssignOperationalLimitSetToOperationalLimitSetEvent
   */
  @EventHandler(payloadType = AssignOperationalLimitSetToOperationalLimitSetEvent.class)
  public void handle(AssignOperationalLimitSetToOperationalLimitSetEvent event) {
    LOGGER.info("handling AssignOperationalLimitSetToOperationalLimitSetEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    OperationalLimitSet entity =
        addToOperationalLimitSet(event.getOperationalLimitSetId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOperationalLimitSet(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOperationalLimitSet(entity);
  }

  /*
   * @param	event RemoveOperationalLimitSetFromOperationalLimitSetEvent
   */
  @EventHandler(payloadType = RemoveOperationalLimitSetFromOperationalLimitSetEvent.class)
  public void handle(RemoveOperationalLimitSetFromOperationalLimitSetEvent event) {
    LOGGER.info("handling RemoveOperationalLimitSetFromOperationalLimitSetEvent - " + event);

    OperationalLimitSet entity =
        removeFromOperationalLimitSet(event.getOperationalLimitSetId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOperationalLimitSet(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOperationalLimitSet(entity);
  }

  /**
   * Method to retrieve the OperationalLimitSet via an OperationalLimitSetPrimaryKey.
   *
   * @param id Long
   * @return OperationalLimitSet
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public OperationalLimitSet handle(FindOperationalLimitSetQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getOperationalLimitSetId());
  }

  /**
   * Method to retrieve a collection of all OperationalLimitSets
   *
   * @param query FindAllOperationalLimitSetQuery
   * @return List<OperationalLimitSet>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<OperationalLimitSet> handle(FindAllOperationalLimitSetQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindOperationalLimitSet, but only if the id matches
   *
   * @param entity OperationalLimitSet
   */
  protected void emitFindOperationalLimitSet(OperationalLimitSet entity) {
    LOGGER.info("handling emitFindOperationalLimitSet");

    queryUpdateEmitter.emit(
        FindOperationalLimitSetQuery.class,
        query ->
            query.getFilter().getOperationalLimitSetId().equals(entity.getOperationalLimitSetId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllOperationalLimitSet
   *
   * @param entity OperationalLimitSet
   */
  protected void emitFindAllOperationalLimitSet(OperationalLimitSet entity) {
    LOGGER.info("handling emitFindAllOperationalLimitSet");

    queryUpdateEmitter.emit(FindAllOperationalLimitSetQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitSetProjector.class.getName());
}
