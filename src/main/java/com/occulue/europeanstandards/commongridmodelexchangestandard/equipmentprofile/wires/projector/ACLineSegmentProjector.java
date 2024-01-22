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
 * Projector for ACLineSegment as outlined for the CQRS pattern. All event handling and query
 * handling related to ACLineSegment are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ACLineSegmentAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("aCLineSegment")
@Component("aCLineSegment-projector")
public class ACLineSegmentProjector extends ACLineSegmentEntityProjector {

  // core constructor
  public ACLineSegmentProjector(
      ACLineSegmentRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateACLineSegmentEvent
   */
  @EventHandler(payloadType = CreateACLineSegmentEvent.class)
  public void handle(CreateACLineSegmentEvent event) {
    LOGGER.info("handling CreateACLineSegmentEvent - " + event);
    ACLineSegment entity = new ACLineSegment();
    entity.setACLineSegmentId(event.getACLineSegmentId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UpdateACLineSegmentEvent
   */
  @EventHandler(payloadType = UpdateACLineSegmentEvent.class)
  public void handle(UpdateACLineSegmentEvent event) {
    LOGGER.info("handling UpdateACLineSegmentEvent - " + event);

    ACLineSegment entity = new ACLineSegment();
    entity.setACLineSegmentId(event.getACLineSegmentId());
    entity.setB0ch(event.getB0ch());
    entity.setBch(event.getBch());
    entity.setG0ch(event.getG0ch());
    entity.setGch(event.getGch());
    entity.setR(event.getR());
    entity.setR0(event.getR0());
    entity.setShortCircuitEndTemperature(event.getShortCircuitEndTemperature());
    entity.setX(event.getX());
    entity.setX0(event.getX0());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event DeleteACLineSegmentEvent
   */
  @EventHandler(payloadType = DeleteACLineSegmentEvent.class)
  public void handle(DeleteACLineSegmentEvent event) {
    LOGGER.info("handling DeleteACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ACLineSegment entity = delete(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignB0chToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignB0chToACLineSegmentEvent.class)
  public void handle(AssignB0chToACLineSegmentEvent event) {
    LOGGER.info("handling AssignB0chToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignB0ch(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignB0chFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignB0chFromACLineSegmentEvent.class)
  public void handle(UnAssignB0chFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignB0chFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignB0ch(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignBchToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignBchToACLineSegmentEvent.class)
  public void handle(AssignBchToACLineSegmentEvent event) {
    LOGGER.info("handling AssignBchToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignBch(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignBchFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignBchFromACLineSegmentEvent.class)
  public void handle(UnAssignBchFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignBchFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignBch(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignG0chToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignG0chToACLineSegmentEvent.class)
  public void handle(AssignG0chToACLineSegmentEvent event) {
    LOGGER.info("handling AssignG0chToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignG0ch(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignG0chFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignG0chFromACLineSegmentEvent.class)
  public void handle(UnAssignG0chFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignG0chFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignG0ch(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignGchToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignGchToACLineSegmentEvent.class)
  public void handle(AssignGchToACLineSegmentEvent event) {
    LOGGER.info("handling AssignGchToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignGch(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignGchFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignGchFromACLineSegmentEvent.class)
  public void handle(UnAssignGchFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignGchFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignGch(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignRToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignRToACLineSegmentEvent.class)
  public void handle(AssignRToACLineSegmentEvent event) {
    LOGGER.info("handling AssignRToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignR(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignRFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignRFromACLineSegmentEvent.class)
  public void handle(UnAssignRFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignRFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignR(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignR0ToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignR0ToACLineSegmentEvent.class)
  public void handle(AssignR0ToACLineSegmentEvent event) {
    LOGGER.info("handling AssignR0ToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignR0(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignR0FromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignR0FromACLineSegmentEvent.class)
  public void handle(UnAssignR0FromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignR0FromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignR0(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignShortCircuitEndTemperatureToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignShortCircuitEndTemperatureToACLineSegmentEvent.class)
  public void handle(AssignShortCircuitEndTemperatureToACLineSegmentEvent event) {
    LOGGER.info("handling AssignShortCircuitEndTemperatureToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity =
        assignShortCircuitEndTemperature(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent.class)
  public void handle(UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignShortCircuitEndTemperatureFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignShortCircuitEndTemperature(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignXToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignXToACLineSegmentEvent.class)
  public void handle(AssignXToACLineSegmentEvent event) {
    LOGGER.info("handling AssignXToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignX(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignXFromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignXFromACLineSegmentEvent.class)
  public void handle(UnAssignXFromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignXFromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignX(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event AssignX0ToACLineSegmentEvent
   */
  @EventHandler(payloadType = AssignX0ToACLineSegmentEvent.class)
  public void handle(AssignX0ToACLineSegmentEvent event) {
    LOGGER.info("handling AssignX0ToACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACLineSegment entity = assignX0(event.getACLineSegmentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /*
   * @param	event UnAssignX0FromACLineSegmentEvent
   */
  @EventHandler(payloadType = UnAssignX0FromACLineSegmentEvent.class)
  public void handle(UnAssignX0FromACLineSegmentEvent event) {
    LOGGER.info("handling UnAssignX0FromACLineSegmentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACLineSegment entity = unAssignX0(event.getACLineSegmentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACLineSegment(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACLineSegment(entity);
  }

  /**
   * Method to retrieve the ACLineSegment via an ACLineSegmentPrimaryKey.
   *
   * @param id Long
   * @return ACLineSegment
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ACLineSegment handle(FindACLineSegmentQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getACLineSegmentId());
  }

  /**
   * Method to retrieve a collection of all ACLineSegments
   *
   * @param query FindAllACLineSegmentQuery
   * @return List<ACLineSegment>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ACLineSegment> handle(FindAllACLineSegmentQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindACLineSegment, but only if the id matches
   *
   * @param entity ACLineSegment
   */
  protected void emitFindACLineSegment(ACLineSegment entity) {
    LOGGER.info("handling emitFindACLineSegment");

    queryUpdateEmitter.emit(
        FindACLineSegmentQuery.class,
        query -> query.getFilter().getACLineSegmentId().equals(entity.getACLineSegmentId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllACLineSegment
   *
   * @param entity ACLineSegment
   */
  protected void emitFindAllACLineSegment(ACLineSegment entity) {
    LOGGER.info("handling emitFindAllACLineSegment");

    queryUpdateEmitter.emit(FindAllACLineSegmentQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ACLineSegmentProjector.class.getName());
}
