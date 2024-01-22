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
 * Projector for NonlinearShuntCompensatorPoint as outlined for the CQRS pattern. All event handling
 * and query handling related to NonlinearShuntCompensatorPoint are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by NonlinearShuntCompensatorPointAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("nonlinearShuntCompensatorPoint")
@Component("nonlinearShuntCompensatorPoint-projector")
public class NonlinearShuntCompensatorPointProjector
    extends NonlinearShuntCompensatorPointEntityProjector {

  // core constructor
  public NonlinearShuntCompensatorPointProjector(
      NonlinearShuntCompensatorPointRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = CreateNonlinearShuntCompensatorPointEvent.class)
  public void handle(CreateNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling CreateNonlinearShuntCompensatorPointEvent - " + event);
    NonlinearShuntCompensatorPoint entity = new NonlinearShuntCompensatorPoint();
    entity.setNonlinearShuntCompensatorPointId(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event UpdateNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = UpdateNonlinearShuntCompensatorPointEvent.class)
  public void handle(UpdateNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling UpdateNonlinearShuntCompensatorPointEvent - " + event);

    NonlinearShuntCompensatorPoint entity = new NonlinearShuntCompensatorPoint();
    entity.setNonlinearShuntCompensatorPointId(event.getNonlinearShuntCompensatorPointId());
    entity.setB(event.getB());
    entity.setB0(event.getB0());
    entity.setG(event.getG());
    entity.setG0(event.getG0());
    entity.setSectionNumber(event.getSectionNumber());
    entity.setNonlinearShuntCompensatorPoints(event.getNonlinearShuntCompensatorPoints());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event DeleteNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = DeleteNonlinearShuntCompensatorPointEvent.class)
  public void handle(DeleteNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling DeleteNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity = delete(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event AssignBToNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = AssignBToNonlinearShuntCompensatorPointEvent.class)
  public void handle(AssignBToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling AssignBToNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        assignB(event.getNonlinearShuntCompensatorPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event UnAssignBFromNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = UnAssignBFromNonlinearShuntCompensatorPointEvent.class)
  public void handle(UnAssignBFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling UnAssignBFromNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity = unAssignB(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event AssignB0ToNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = AssignB0ToNonlinearShuntCompensatorPointEvent.class)
  public void handle(AssignB0ToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling AssignB0ToNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        assignB0(event.getNonlinearShuntCompensatorPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event UnAssignB0FromNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = UnAssignB0FromNonlinearShuntCompensatorPointEvent.class)
  public void handle(UnAssignB0FromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling UnAssignB0FromNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity = unAssignB0(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event AssignGToNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = AssignGToNonlinearShuntCompensatorPointEvent.class)
  public void handle(AssignGToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling AssignGToNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        assignG(event.getNonlinearShuntCompensatorPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event UnAssignGFromNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = UnAssignGFromNonlinearShuntCompensatorPointEvent.class)
  public void handle(UnAssignGFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling UnAssignGFromNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity = unAssignG(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event AssignG0ToNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = AssignG0ToNonlinearShuntCompensatorPointEvent.class)
  public void handle(AssignG0ToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling AssignG0ToNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        assignG0(event.getNonlinearShuntCompensatorPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event UnAssignG0FromNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = UnAssignG0FromNonlinearShuntCompensatorPointEvent.class)
  public void handle(UnAssignG0FromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling UnAssignG0FromNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity = unAssignG0(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event AssignSectionNumberToNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = AssignSectionNumberToNonlinearShuntCompensatorPointEvent.class)
  public void handle(AssignSectionNumberToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling AssignSectionNumberToNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        assignSectionNumber(event.getNonlinearShuntCompensatorPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(payloadType = UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent.class)
  public void handle(UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info("handling UnAssignSectionNumberFromNonlinearShuntCompensatorPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        unAssignSectionNumber(event.getNonlinearShuntCompensatorPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(
      payloadType =
          AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent.class)
  public void handle(
      AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info(
        "handling AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent - "
            + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity =
        addToNonlinearShuntCompensatorPoints(
            event.getNonlinearShuntCompensatorPointId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /*
   * @param	event RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent
   */
  @EventHandler(
      payloadType =
          RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent.class)
  public void handle(
      RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent event) {
    LOGGER.info(
        "handling RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent - "
            + event);

    NonlinearShuntCompensatorPoint entity =
        removeFromNonlinearShuntCompensatorPoints(
            event.getNonlinearShuntCompensatorPointId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindNonlinearShuntCompensatorPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllNonlinearShuntCompensatorPoint(entity);
  }

  /**
   * Method to retrieve the NonlinearShuntCompensatorPoint via an
   * NonlinearShuntCompensatorPointPrimaryKey.
   *
   * @param id Long
   * @return NonlinearShuntCompensatorPoint
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public NonlinearShuntCompensatorPoint handle(FindNonlinearShuntCompensatorPointQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getNonlinearShuntCompensatorPointId());
  }

  /**
   * Method to retrieve a collection of all NonlinearShuntCompensatorPoints
   *
   * @param query FindAllNonlinearShuntCompensatorPointQuery
   * @return List<NonlinearShuntCompensatorPoint>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<NonlinearShuntCompensatorPoint> handle(
      FindAllNonlinearShuntCompensatorPointQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindNonlinearShuntCompensatorPoint, but only if the id
   * matches
   *
   * @param entity NonlinearShuntCompensatorPoint
   */
  protected void emitFindNonlinearShuntCompensatorPoint(NonlinearShuntCompensatorPoint entity) {
    LOGGER.info("handling emitFindNonlinearShuntCompensatorPoint");

    queryUpdateEmitter.emit(
        FindNonlinearShuntCompensatorPointQuery.class,
        query ->
            query
                .getFilter()
                .getNonlinearShuntCompensatorPointId()
                .equals(entity.getNonlinearShuntCompensatorPointId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllNonlinearShuntCompensatorPoint
   *
   * @param entity NonlinearShuntCompensatorPoint
   */
  protected void emitFindAllNonlinearShuntCompensatorPoint(NonlinearShuntCompensatorPoint entity) {
    LOGGER.info("handling emitFindAllNonlinearShuntCompensatorPoint");

    queryUpdateEmitter.emit(
        FindAllNonlinearShuntCompensatorPointQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(NonlinearShuntCompensatorPointProjector.class.getName());
}
