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
 * Projector for PowerTransformerEnd as outlined for the CQRS pattern. All event handling and query
 * handling related to PowerTransformerEnd are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by PowerTransformerEndAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("powerTransformerEnd")
@Component("powerTransformerEnd-projector")
public class PowerTransformerEndProjector extends PowerTransformerEndEntityProjector {

  // core constructor
  public PowerTransformerEndProjector(
      PowerTransformerEndRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePowerTransformerEndEvent
   */
  @EventHandler(payloadType = CreatePowerTransformerEndEvent.class)
  public void handle(CreatePowerTransformerEndEvent event) {
    LOGGER.info("handling CreatePowerTransformerEndEvent - " + event);
    PowerTransformerEnd entity = new PowerTransformerEnd();
    entity.setPowerTransformerEndId(event.getPowerTransformerEndId());
    entity.setConnectionKind(event.getConnectionKind());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UpdatePowerTransformerEndEvent
   */
  @EventHandler(payloadType = UpdatePowerTransformerEndEvent.class)
  public void handle(UpdatePowerTransformerEndEvent event) {
    LOGGER.info("handling UpdatePowerTransformerEndEvent - " + event);

    PowerTransformerEnd entity = new PowerTransformerEnd();
    entity.setPowerTransformerEndId(event.getPowerTransformerEndId());
    entity.setB(event.getB());
    entity.setB0(event.getB0());
    entity.setConnectionKind(event.getConnectionKind());
    entity.setG(event.getG());
    entity.setG0(event.getG0());
    entity.setPhaseAngleClock(event.getPhaseAngleClock());
    entity.setR(event.getR());
    entity.setR0(event.getR0());
    entity.setRatedS(event.getRatedS());
    entity.setRatedU(event.getRatedU());
    entity.setX(event.getX());
    entity.setX0(event.getX0());
    entity.setPowerTransformerEnd(event.getPowerTransformerEnd());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event DeletePowerTransformerEndEvent
   */
  @EventHandler(payloadType = DeletePowerTransformerEndEvent.class)
  public void handle(DeletePowerTransformerEndEvent event) {
    LOGGER.info("handling DeletePowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PowerTransformerEnd entity = delete(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignBToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignBToPowerTransformerEndEvent.class)
  public void handle(AssignBToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignBToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignB(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignBFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignBFromPowerTransformerEndEvent.class)
  public void handle(UnAssignBFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignBFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignB(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignB0ToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignB0ToPowerTransformerEndEvent.class)
  public void handle(AssignB0ToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignB0ToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignB0(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignB0FromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignB0FromPowerTransformerEndEvent.class)
  public void handle(UnAssignB0FromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignB0FromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignB0(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignGToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignGToPowerTransformerEndEvent.class)
  public void handle(AssignGToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignGToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignG(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignGFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignGFromPowerTransformerEndEvent.class)
  public void handle(UnAssignGFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignGFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignG(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignG0ToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignG0ToPowerTransformerEndEvent.class)
  public void handle(AssignG0ToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignG0ToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignG0(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignG0FromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignG0FromPowerTransformerEndEvent.class)
  public void handle(UnAssignG0FromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignG0FromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignG0(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignPhaseAngleClockToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignPhaseAngleClockToPowerTransformerEndEvent.class)
  public void handle(AssignPhaseAngleClockToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignPhaseAngleClockToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity =
        assignPhaseAngleClock(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignPhaseAngleClockFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignPhaseAngleClockFromPowerTransformerEndEvent.class)
  public void handle(UnAssignPhaseAngleClockFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignPhaseAngleClockFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignPhaseAngleClock(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignRToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignRToPowerTransformerEndEvent.class)
  public void handle(AssignRToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignRToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignR(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignRFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignRFromPowerTransformerEndEvent.class)
  public void handle(UnAssignRFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignRFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignR(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignR0ToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignR0ToPowerTransformerEndEvent.class)
  public void handle(AssignR0ToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignR0ToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignR0(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignR0FromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignR0FromPowerTransformerEndEvent.class)
  public void handle(UnAssignR0FromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignR0FromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignR0(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignRatedSToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignRatedSToPowerTransformerEndEvent.class)
  public void handle(AssignRatedSToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignRatedSToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity =
        assignRatedS(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignRatedSFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignRatedSFromPowerTransformerEndEvent.class)
  public void handle(UnAssignRatedSFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignRatedSFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignRatedS(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignRatedUToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignRatedUToPowerTransformerEndEvent.class)
  public void handle(AssignRatedUToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignRatedUToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity =
        assignRatedU(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignRatedUFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignRatedUFromPowerTransformerEndEvent.class)
  public void handle(UnAssignRatedUFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignRatedUFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignRatedU(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignXToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignXToPowerTransformerEndEvent.class)
  public void handle(AssignXToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignXToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignX(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignXFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignXFromPowerTransformerEndEvent.class)
  public void handle(UnAssignXFromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignXFromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignX(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignX0ToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignX0ToPowerTransformerEndEvent.class)
  public void handle(AssignX0ToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignX0ToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformerEnd entity = assignX0(event.getPowerTransformerEndId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event UnAssignX0FromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = UnAssignX0FromPowerTransformerEndEvent.class)
  public void handle(UnAssignX0FromPowerTransformerEndEvent event) {
    LOGGER.info("handling UnAssignX0FromPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformerEnd entity = unAssignX0(event.getPowerTransformerEndId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event AssignPowerTransformerEndToPowerTransformerEndEvent
   */
  @EventHandler(payloadType = AssignPowerTransformerEndToPowerTransformerEndEvent.class)
  public void handle(AssignPowerTransformerEndToPowerTransformerEndEvent event) {
    LOGGER.info("handling AssignPowerTransformerEndToPowerTransformerEndEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    PowerTransformerEnd entity =
        addToPowerTransformerEnd(event.getPowerTransformerEndId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /*
   * @param	event RemovePowerTransformerEndFromPowerTransformerEndEvent
   */
  @EventHandler(payloadType = RemovePowerTransformerEndFromPowerTransformerEndEvent.class)
  public void handle(RemovePowerTransformerEndFromPowerTransformerEndEvent event) {
    LOGGER.info("handling RemovePowerTransformerEndFromPowerTransformerEndEvent - " + event);

    PowerTransformerEnd entity =
        removeFromPowerTransformerEnd(event.getPowerTransformerEndId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformerEnd(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformerEnd(entity);
  }

  /**
   * Method to retrieve the PowerTransformerEnd via an PowerTransformerEndPrimaryKey.
   *
   * @param id Long
   * @return PowerTransformerEnd
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PowerTransformerEnd handle(FindPowerTransformerEndQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPowerTransformerEndId());
  }

  /**
   * Method to retrieve a collection of all PowerTransformerEnds
   *
   * @param query FindAllPowerTransformerEndQuery
   * @return List<PowerTransformerEnd>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PowerTransformerEnd> handle(FindAllPowerTransformerEndQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPowerTransformerEnd, but only if the id matches
   *
   * @param entity PowerTransformerEnd
   */
  protected void emitFindPowerTransformerEnd(PowerTransformerEnd entity) {
    LOGGER.info("handling emitFindPowerTransformerEnd");

    queryUpdateEmitter.emit(
        FindPowerTransformerEndQuery.class,
        query ->
            query.getFilter().getPowerTransformerEndId().equals(entity.getPowerTransformerEndId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPowerTransformerEnd
   *
   * @param entity PowerTransformerEnd
   */
  protected void emitFindAllPowerTransformerEnd(PowerTransformerEnd entity) {
    LOGGER.info("handling emitFindAllPowerTransformerEnd");

    queryUpdateEmitter.emit(FindAllPowerTransformerEndQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerEndProjector.class.getName());
}
