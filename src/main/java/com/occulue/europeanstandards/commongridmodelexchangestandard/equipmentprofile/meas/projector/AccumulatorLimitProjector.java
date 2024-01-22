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
 * Projector for AccumulatorLimit as outlined for the CQRS pattern. All event handling and query
 * handling related to AccumulatorLimit are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by AccumulatorLimitAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("accumulatorLimit")
@Component("accumulatorLimit-projector")
public class AccumulatorLimitProjector extends AccumulatorLimitEntityProjector {

  // core constructor
  public AccumulatorLimitProjector(
      AccumulatorLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAccumulatorLimitEvent
   */
  @EventHandler(payloadType = CreateAccumulatorLimitEvent.class)
  public void handle(CreateAccumulatorLimitEvent event) {
    LOGGER.info("handling CreateAccumulatorLimitEvent - " + event);
    AccumulatorLimit entity = new AccumulatorLimit();
    entity.setAccumulatorLimitId(event.getAccumulatorLimitId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /*
   * @param	event UpdateAccumulatorLimitEvent
   */
  @EventHandler(payloadType = UpdateAccumulatorLimitEvent.class)
  public void handle(UpdateAccumulatorLimitEvent event) {
    LOGGER.info("handling UpdateAccumulatorLimitEvent - " + event);

    AccumulatorLimit entity = new AccumulatorLimit();
    entity.setAccumulatorLimitId(event.getAccumulatorLimitId());
    entity.setValue(event.getValue());
    entity.setLimits(event.getLimits());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /*
   * @param	event DeleteAccumulatorLimitEvent
   */
  @EventHandler(payloadType = DeleteAccumulatorLimitEvent.class)
  public void handle(DeleteAccumulatorLimitEvent event) {
    LOGGER.info("handling DeleteAccumulatorLimitEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AccumulatorLimit entity = delete(event.getAccumulatorLimitId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /*
   * @param	event AssignValueToAccumulatorLimitEvent
   */
  @EventHandler(payloadType = AssignValueToAccumulatorLimitEvent.class)
  public void handle(AssignValueToAccumulatorLimitEvent event) {
    LOGGER.info("handling AssignValueToAccumulatorLimitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AccumulatorLimit entity = assignValue(event.getAccumulatorLimitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /*
   * @param	event UnAssignValueFromAccumulatorLimitEvent
   */
  @EventHandler(payloadType = UnAssignValueFromAccumulatorLimitEvent.class)
  public void handle(UnAssignValueFromAccumulatorLimitEvent event) {
    LOGGER.info("handling UnAssignValueFromAccumulatorLimitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AccumulatorLimit entity = unAssignValue(event.getAccumulatorLimitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /*
   * @param	event AssignLimitsToAccumulatorLimitEvent
   */
  @EventHandler(payloadType = AssignLimitsToAccumulatorLimitEvent.class)
  public void handle(AssignLimitsToAccumulatorLimitEvent event) {
    LOGGER.info("handling AssignLimitsToAccumulatorLimitEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    AccumulatorLimit entity = addToLimits(event.getAccumulatorLimitId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /*
   * @param	event RemoveLimitsFromAccumulatorLimitEvent
   */
  @EventHandler(payloadType = RemoveLimitsFromAccumulatorLimitEvent.class)
  public void handle(RemoveLimitsFromAccumulatorLimitEvent event) {
    LOGGER.info("handling RemoveLimitsFromAccumulatorLimitEvent - " + event);

    AccumulatorLimit entity =
        removeFromLimits(event.getAccumulatorLimitId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAccumulatorLimit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAccumulatorLimit(entity);
  }

  /**
   * Method to retrieve the AccumulatorLimit via an AccumulatorLimitPrimaryKey.
   *
   * @param id Long
   * @return AccumulatorLimit
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AccumulatorLimit handle(FindAccumulatorLimitQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAccumulatorLimitId());
  }

  /**
   * Method to retrieve a collection of all AccumulatorLimits
   *
   * @param query FindAllAccumulatorLimitQuery
   * @return List<AccumulatorLimit>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AccumulatorLimit> handle(FindAllAccumulatorLimitQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAccumulatorLimit, but only if the id matches
   *
   * @param entity AccumulatorLimit
   */
  protected void emitFindAccumulatorLimit(AccumulatorLimit entity) {
    LOGGER.info("handling emitFindAccumulatorLimit");

    queryUpdateEmitter.emit(
        FindAccumulatorLimitQuery.class,
        query -> query.getFilter().getAccumulatorLimitId().equals(entity.getAccumulatorLimitId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllAccumulatorLimit
   *
   * @param entity AccumulatorLimit
   */
  protected void emitFindAllAccumulatorLimit(AccumulatorLimit entity) {
    LOGGER.info("handling emitFindAllAccumulatorLimit");

    queryUpdateEmitter.emit(FindAllAccumulatorLimitQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(AccumulatorLimitProjector.class.getName());
}
