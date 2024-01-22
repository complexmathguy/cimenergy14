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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for AccumulatorLimitSet as outlined for the CQRS pattern. All event handling and query
 * handling related to AccumulatorLimitSet are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by AccumulatorLimitSetAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("accumulatorLimitSet")
@Component("accumulatorLimitSet-projector")
public class AccumulatorLimitSetProjector extends AccumulatorLimitSetEntityProjector {

  // core constructor
  public AccumulatorLimitSetProjector(
      AccumulatorLimitSetRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAccumulatorLimitSetEvent
   */
  @EventHandler(payloadType = CreateAccumulatorLimitSetEvent.class)
  public void handle(CreateAccumulatorLimitSetEvent event) {
    LOGGER.info("handling CreateAccumulatorLimitSetEvent - " + event);
    AccumulatorLimitSet entity = new AccumulatorLimitSet();
    entity.setAccumulatorLimitSetId(event.getAccumulatorLimitSetId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimitSet(entity);
  }

  /*
   * @param	event UpdateAccumulatorLimitSetEvent
   */
  @EventHandler(payloadType = UpdateAccumulatorLimitSetEvent.class)
  public void handle(UpdateAccumulatorLimitSetEvent event) {
    LOGGER.info("handling UpdateAccumulatorLimitSetEvent - " + event);

    AccumulatorLimitSet entity = new AccumulatorLimitSet();
    entity.setAccumulatorLimitSetId(event.getAccumulatorLimitSetId());
    entity.setLimitSets(event.getLimitSets());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimitSet(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimitSet(entity);
  }

  /*
   * @param	event DeleteAccumulatorLimitSetEvent
   */
  @EventHandler(payloadType = DeleteAccumulatorLimitSetEvent.class)
  public void handle(DeleteAccumulatorLimitSetEvent event) {
    LOGGER.info("handling DeleteAccumulatorLimitSetEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AccumulatorLimitSet entity = delete(event.getAccumulatorLimitSetId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimitSet(entity);
  }

  /*
   * @param	event AssignLimitSetsToAccumulatorLimitSetEvent
   */
  @EventHandler(payloadType = AssignLimitSetsToAccumulatorLimitSetEvent.class)
  public void handle(AssignLimitSetsToAccumulatorLimitSetEvent event) {
    LOGGER.info("handling AssignLimitSetsToAccumulatorLimitSetEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    AccumulatorLimitSet entity = addToLimitSets(event.getAccumulatorLimitSetId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimitSet(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimitSet(entity);
  }

  /*
   * @param	event RemoveLimitSetsFromAccumulatorLimitSetEvent
   */
  @EventHandler(payloadType = RemoveLimitSetsFromAccumulatorLimitSetEvent.class)
  public void handle(RemoveLimitSetsFromAccumulatorLimitSetEvent event) {
    LOGGER.info("handling RemoveLimitSetsFromAccumulatorLimitSetEvent - " + event);

    AccumulatorLimitSet entity =
        removeFromLimitSets(event.getAccumulatorLimitSetId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimitSet(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimitSet(entity);
  }

  /**
   * Method to retrieve the AccumulatorLimitSet via an AccumulatorLimitSetPrimaryKey.
   *
   * @param id Long
   * @return AccumulatorLimitSet
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AccumulatorLimitSet handle(FindAccumulatorLimitSetQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAccumulatorLimitSetId());
  }

  /**
   * Method to retrieve a collection of all AccumulatorLimitSets
   *
   * @param query FindAllAccumulatorLimitSetQuery
   * @return List<AccumulatorLimitSet>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AccumulatorLimitSet> handle(FindAllAccumulatorLimitSetQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAccumulatorLimitSet, but only if the id matches
   *
   * @param entity AccumulatorLimitSet
   */
  protected void emitFindAccumulatorLimitSet(AccumulatorLimitSet entity) {
    LOGGER.info("handling emitFindAccumulatorLimitSet");

    queryUpdateEmitter.emit(
        FindAccumulatorLimitSetQuery.class,
        query ->
            query.getFilter().getAccumulatorLimitSetId().equals(entity.getAccumulatorLimitSetId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllAccumulatorLimitSet
   *
   * @param entity AccumulatorLimitSet
   */
  protected void emitFindAllAccumulatorLimitSet(AccumulatorLimitSet entity) {
    LOGGER.info("handling emitFindAllAccumulatorLimitSet");

    queryUpdateEmitter.emit(FindAllAccumulatorLimitSetQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorLimitSetProjector.class.getName());
}
