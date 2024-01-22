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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RatioTapChangerTablePoint as outlined for the CQRS pattern. All event handling and
 * query handling related to RatioTapChangerTablePoint are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by RatioTapChangerTablePointAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("ratioTapChangerTablePoint")
@Component("ratioTapChangerTablePoint-projector")
public class RatioTapChangerTablePointProjector extends RatioTapChangerTablePointEntityProjector {

  // core constructor
  public RatioTapChangerTablePointProjector(
      RatioTapChangerTablePointRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRatioTapChangerTablePointEvent
   */
  @EventHandler(payloadType = CreateRatioTapChangerTablePointEvent.class)
  public void handle(CreateRatioTapChangerTablePointEvent event) {
    LOGGER.info("handling CreateRatioTapChangerTablePointEvent - " + event);
    RatioTapChangerTablePoint entity = new RatioTapChangerTablePoint();
    entity.setRatioTapChangerTablePointId(event.getRatioTapChangerTablePointId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRatioTapChangerTablePoint(entity);
  }

  /*
   * @param	event UpdateRatioTapChangerTablePointEvent
   */
  @EventHandler(payloadType = UpdateRatioTapChangerTablePointEvent.class)
  public void handle(UpdateRatioTapChangerTablePointEvent event) {
    LOGGER.info("handling UpdateRatioTapChangerTablePointEvent - " + event);

    RatioTapChangerTablePoint entity = new RatioTapChangerTablePoint();
    entity.setRatioTapChangerTablePointId(event.getRatioTapChangerTablePointId());
    entity.setRatioTapChangerTablePoint(event.getRatioTapChangerTablePoint());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRatioTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRatioTapChangerTablePoint(entity);
  }

  /*
   * @param	event DeleteRatioTapChangerTablePointEvent
   */
  @EventHandler(payloadType = DeleteRatioTapChangerTablePointEvent.class)
  public void handle(DeleteRatioTapChangerTablePointEvent event) {
    LOGGER.info("handling DeleteRatioTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RatioTapChangerTablePoint entity = delete(event.getRatioTapChangerTablePointId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRatioTapChangerTablePoint(entity);
  }

  /*
   * @param	event AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent
   */
  @EventHandler(payloadType = AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent.class)
  public void handle(AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent event) {
    LOGGER.info(
        "handling AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    RatioTapChangerTablePoint entity =
        addToRatioTapChangerTablePoint(event.getRatioTapChangerTablePointId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRatioTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRatioTapChangerTablePoint(entity);
  }

  /*
   * @param	event RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent
   */
  @EventHandler(
      payloadType = RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent.class)
  public void handle(RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent event) {
    LOGGER.info(
        "handling RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent - " + event);

    RatioTapChangerTablePoint entity =
        removeFromRatioTapChangerTablePoint(
            event.getRatioTapChangerTablePointId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRatioTapChangerTablePoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRatioTapChangerTablePoint(entity);
  }

  /**
   * Method to retrieve the RatioTapChangerTablePoint via an RatioTapChangerTablePointPrimaryKey.
   *
   * @param id Long
   * @return RatioTapChangerTablePoint
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RatioTapChangerTablePoint handle(FindRatioTapChangerTablePointQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRatioTapChangerTablePointId());
  }

  /**
   * Method to retrieve a collection of all RatioTapChangerTablePoints
   *
   * @param query FindAllRatioTapChangerTablePointQuery
   * @return List<RatioTapChangerTablePoint>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RatioTapChangerTablePoint> handle(FindAllRatioTapChangerTablePointQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRatioTapChangerTablePoint, but only if the id matches
   *
   * @param entity RatioTapChangerTablePoint
   */
  protected void emitFindRatioTapChangerTablePoint(RatioTapChangerTablePoint entity) {
    LOGGER.info("handling emitFindRatioTapChangerTablePoint");

    queryUpdateEmitter.emit(
        FindRatioTapChangerTablePointQuery.class,
        query ->
            query
                .getFilter()
                .getRatioTapChangerTablePointId()
                .equals(entity.getRatioTapChangerTablePointId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRatioTapChangerTablePoint
   *
   * @param entity RatioTapChangerTablePoint
   */
  protected void emitFindAllRatioTapChangerTablePoint(RatioTapChangerTablePoint entity) {
    LOGGER.info("handling emitFindAllRatioTapChangerTablePoint");

    queryUpdateEmitter.emit(FindAllRatioTapChangerTablePointQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerTablePointProjector.class.getName());
}
