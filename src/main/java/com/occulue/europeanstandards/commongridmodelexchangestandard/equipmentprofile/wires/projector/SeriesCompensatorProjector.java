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
 * Projector for SeriesCompensator as outlined for the CQRS pattern. All event handling and query
 * handling related to SeriesCompensator are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by SeriesCompensatorAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("seriesCompensator")
@Component("seriesCompensator-projector")
public class SeriesCompensatorProjector extends SeriesCompensatorEntityProjector {

  // core constructor
  public SeriesCompensatorProjector(
      SeriesCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSeriesCompensatorEvent
   */
  @EventHandler(payloadType = CreateSeriesCompensatorEvent.class)
  public void handle(CreateSeriesCompensatorEvent event) {
    LOGGER.info("handling CreateSeriesCompensatorEvent - " + event);
    SeriesCompensator entity = new SeriesCompensator();
    entity.setSeriesCompensatorId(event.getSeriesCompensatorId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UpdateSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UpdateSeriesCompensatorEvent.class)
  public void handle(UpdateSeriesCompensatorEvent event) {
    LOGGER.info("handling UpdateSeriesCompensatorEvent - " + event);

    SeriesCompensator entity = new SeriesCompensator();
    entity.setSeriesCompensatorId(event.getSeriesCompensatorId());
    entity.setR(event.getR());
    entity.setR0(event.getR0());
    entity.setVaristorPresent(event.getVaristorPresent());
    entity.setVaristorRatedCurrent(event.getVaristorRatedCurrent());
    entity.setVaristorVoltageThreshold(event.getVaristorVoltageThreshold());
    entity.setX(event.getX());
    entity.setX0(event.getX0());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event DeleteSeriesCompensatorEvent
   */
  @EventHandler(payloadType = DeleteSeriesCompensatorEvent.class)
  public void handle(DeleteSeriesCompensatorEvent event) {
    LOGGER.info("handling DeleteSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SeriesCompensator entity = delete(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignRToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignRToSeriesCompensatorEvent.class)
  public void handle(AssignRToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignRToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity = assignR(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignRFromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignRFromSeriesCompensatorEvent.class)
  public void handle(UnAssignRFromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignRFromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignR(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignR0ToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignR0ToSeriesCompensatorEvent.class)
  public void handle(AssignR0ToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignR0ToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity = assignR0(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignR0FromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignR0FromSeriesCompensatorEvent.class)
  public void handle(UnAssignR0FromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignR0FromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignR0(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignVaristorPresentToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignVaristorPresentToSeriesCompensatorEvent.class)
  public void handle(AssignVaristorPresentToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignVaristorPresentToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity =
        assignVaristorPresent(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignVaristorPresentFromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignVaristorPresentFromSeriesCompensatorEvent.class)
  public void handle(UnAssignVaristorPresentFromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignVaristorPresentFromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignVaristorPresent(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignVaristorRatedCurrentToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignVaristorRatedCurrentToSeriesCompensatorEvent.class)
  public void handle(AssignVaristorRatedCurrentToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignVaristorRatedCurrentToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity =
        assignVaristorRatedCurrent(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent.class)
  public void handle(UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignVaristorRatedCurrentFromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignVaristorRatedCurrent(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignVaristorVoltageThresholdToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignVaristorVoltageThresholdToSeriesCompensatorEvent.class)
  public void handle(AssignVaristorVoltageThresholdToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignVaristorVoltageThresholdToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity =
        assignVaristorVoltageThreshold(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent.class)
  public void handle(UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignVaristorVoltageThresholdFromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignVaristorVoltageThreshold(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignXToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignXToSeriesCompensatorEvent.class)
  public void handle(AssignXToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignXToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity = assignX(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignXFromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignXFromSeriesCompensatorEvent.class)
  public void handle(UnAssignXFromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignXFromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignX(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event AssignX0ToSeriesCompensatorEvent
   */
  @EventHandler(payloadType = AssignX0ToSeriesCompensatorEvent.class)
  public void handle(AssignX0ToSeriesCompensatorEvent event) {
    LOGGER.info("handling AssignX0ToSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SeriesCompensator entity = assignX0(event.getSeriesCompensatorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /*
   * @param	event UnAssignX0FromSeriesCompensatorEvent
   */
  @EventHandler(payloadType = UnAssignX0FromSeriesCompensatorEvent.class)
  public void handle(UnAssignX0FromSeriesCompensatorEvent event) {
    LOGGER.info("handling UnAssignX0FromSeriesCompensatorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SeriesCompensator entity = unAssignX0(event.getSeriesCompensatorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSeriesCompensator(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSeriesCompensator(entity);
  }

  /**
   * Method to retrieve the SeriesCompensator via an SeriesCompensatorPrimaryKey.
   *
   * @param id Long
   * @return SeriesCompensator
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SeriesCompensator handle(FindSeriesCompensatorQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSeriesCompensatorId());
  }

  /**
   * Method to retrieve a collection of all SeriesCompensators
   *
   * @param query FindAllSeriesCompensatorQuery
   * @return List<SeriesCompensator>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SeriesCompensator> handle(FindAllSeriesCompensatorQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSeriesCompensator, but only if the id matches
   *
   * @param entity SeriesCompensator
   */
  protected void emitFindSeriesCompensator(SeriesCompensator entity) {
    LOGGER.info("handling emitFindSeriesCompensator");

    queryUpdateEmitter.emit(
        FindSeriesCompensatorQuery.class,
        query -> query.getFilter().getSeriesCompensatorId().equals(entity.getSeriesCompensatorId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSeriesCompensator
   *
   * @param entity SeriesCompensator
   */
  protected void emitFindAllSeriesCompensator(SeriesCompensator entity) {
    LOGGER.info("handling emitFindAllSeriesCompensator");

    queryUpdateEmitter.emit(FindAllSeriesCompensatorQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(SeriesCompensatorProjector.class.getName());
}
