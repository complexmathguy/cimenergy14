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
 * Projector for PowerTransformer as outlined for the CQRS pattern. All event handling and query
 * handling related to PowerTransformer are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by PowerTransformerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("powerTransformer")
@Component("powerTransformer-projector")
public class PowerTransformerProjector extends PowerTransformerEntityProjector {

  // core constructor
  public PowerTransformerProjector(
      PowerTransformerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePowerTransformerEvent
   */
  @EventHandler(payloadType = CreatePowerTransformerEvent.class)
  public void handle(CreatePowerTransformerEvent event) {
    LOGGER.info("handling CreatePowerTransformerEvent - " + event);
    PowerTransformer entity = new PowerTransformer();
    entity.setPowerTransformerId(event.getPowerTransformerId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UpdatePowerTransformerEvent
   */
  @EventHandler(payloadType = UpdatePowerTransformerEvent.class)
  public void handle(UpdatePowerTransformerEvent event) {
    LOGGER.info("handling UpdatePowerTransformerEvent - " + event);

    PowerTransformer entity = new PowerTransformer();
    entity.setPowerTransformerId(event.getPowerTransformerId());
    entity.setBeforeShCircuitHighestOperatingCurrent(
        event.getBeforeShCircuitHighestOperatingCurrent());
    entity.setBeforeShCircuitHighestOperatingVoltage(
        event.getBeforeShCircuitHighestOperatingVoltage());
    entity.setBeforeShortCircuitAnglePf(event.getBeforeShortCircuitAnglePf());
    entity.setHighSideMinOperatingU(event.getHighSideMinOperatingU());
    entity.setPartOfGeneratorUnitFlag(event.getPartOfGeneratorUnitFlag());
    entity.setOperationalValuesConsidered(event.getOperationalValuesConsidered());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event DeletePowerTransformerEvent
   */
  @EventHandler(payloadType = DeletePowerTransformerEvent.class)
  public void handle(DeletePowerTransformerEvent event) {
    LOGGER.info("handling DeletePowerTransformerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PowerTransformer entity = delete(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent
   */
  @EventHandler(
      payloadType = AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent.class)
  public void handle(AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent event) {
    LOGGER.info(
        "handling AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformer entity =
        assignBeforeShCircuitHighestOperatingCurrent(
            event.getPowerTransformerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent
   */
  @EventHandler(
      payloadType = UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent.class)
  public void handle(
      UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent event) {
    LOGGER.info(
        "handling UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformer entity =
        unAssignBeforeShCircuitHighestOperatingCurrent(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent
   */
  @EventHandler(
      payloadType = AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent.class)
  public void handle(AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent event) {
    LOGGER.info(
        "handling AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformer entity =
        assignBeforeShCircuitHighestOperatingVoltage(
            event.getPowerTransformerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent
   */
  @EventHandler(
      payloadType = UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent.class)
  public void handle(
      UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent event) {
    LOGGER.info(
        "handling UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformer entity =
        unAssignBeforeShCircuitHighestOperatingVoltage(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event AssignBeforeShortCircuitAnglePfToPowerTransformerEvent
   */
  @EventHandler(payloadType = AssignBeforeShortCircuitAnglePfToPowerTransformerEvent.class)
  public void handle(AssignBeforeShortCircuitAnglePfToPowerTransformerEvent event) {
    LOGGER.info("handling AssignBeforeShortCircuitAnglePfToPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformer entity =
        assignBeforeShortCircuitAnglePf(event.getPowerTransformerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent
   */
  @EventHandler(payloadType = UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent.class)
  public void handle(UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent event) {
    LOGGER.info("handling UnAssignBeforeShortCircuitAnglePfFromPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformer entity = unAssignBeforeShortCircuitAnglePf(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event AssignHighSideMinOperatingUToPowerTransformerEvent
   */
  @EventHandler(payloadType = AssignHighSideMinOperatingUToPowerTransformerEvent.class)
  public void handle(AssignHighSideMinOperatingUToPowerTransformerEvent event) {
    LOGGER.info("handling AssignHighSideMinOperatingUToPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformer entity =
        assignHighSideMinOperatingU(event.getPowerTransformerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UnAssignHighSideMinOperatingUFromPowerTransformerEvent
   */
  @EventHandler(payloadType = UnAssignHighSideMinOperatingUFromPowerTransformerEvent.class)
  public void handle(UnAssignHighSideMinOperatingUFromPowerTransformerEvent event) {
    LOGGER.info("handling UnAssignHighSideMinOperatingUFromPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformer entity = unAssignHighSideMinOperatingU(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event AssignPartOfGeneratorUnitFlagToPowerTransformerEvent
   */
  @EventHandler(payloadType = AssignPartOfGeneratorUnitFlagToPowerTransformerEvent.class)
  public void handle(AssignPartOfGeneratorUnitFlagToPowerTransformerEvent event) {
    LOGGER.info("handling AssignPartOfGeneratorUnitFlagToPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformer entity =
        assignPartOfGeneratorUnitFlag(event.getPowerTransformerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent
   */
  @EventHandler(payloadType = UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent.class)
  public void handle(UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent event) {
    LOGGER.info("handling UnAssignPartOfGeneratorUnitFlagFromPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformer entity = unAssignPartOfGeneratorUnitFlag(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event AssignOperationalValuesConsideredToPowerTransformerEvent
   */
  @EventHandler(payloadType = AssignOperationalValuesConsideredToPowerTransformerEvent.class)
  public void handle(AssignOperationalValuesConsideredToPowerTransformerEvent event) {
    LOGGER.info("handling AssignOperationalValuesConsideredToPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PowerTransformer entity =
        assignOperationalValuesConsidered(event.getPowerTransformerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /*
   * @param	event UnAssignOperationalValuesConsideredFromPowerTransformerEvent
   */
  @EventHandler(payloadType = UnAssignOperationalValuesConsideredFromPowerTransformerEvent.class)
  public void handle(UnAssignOperationalValuesConsideredFromPowerTransformerEvent event) {
    LOGGER.info("handling UnAssignOperationalValuesConsideredFromPowerTransformerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PowerTransformer entity = unAssignOperationalValuesConsidered(event.getPowerTransformerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPowerTransformer(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPowerTransformer(entity);
  }

  /**
   * Method to retrieve the PowerTransformer via an PowerTransformerPrimaryKey.
   *
   * @param id Long
   * @return PowerTransformer
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PowerTransformer handle(FindPowerTransformerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPowerTransformerId());
  }

  /**
   * Method to retrieve a collection of all PowerTransformers
   *
   * @param query FindAllPowerTransformerQuery
   * @return List<PowerTransformer>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PowerTransformer> handle(FindAllPowerTransformerQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPowerTransformer, but only if the id matches
   *
   * @param entity PowerTransformer
   */
  protected void emitFindPowerTransformer(PowerTransformer entity) {
    LOGGER.info("handling emitFindPowerTransformer");

    queryUpdateEmitter.emit(
        FindPowerTransformerQuery.class,
        query -> query.getFilter().getPowerTransformerId().equals(entity.getPowerTransformerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPowerTransformer
   *
   * @param entity PowerTransformer
   */
  protected void emitFindAllPowerTransformer(PowerTransformer entity) {
    LOGGER.info("handling emitFindAllPowerTransformer");

    queryUpdateEmitter.emit(FindAllPowerTransformerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PowerTransformerProjector.class.getName());
}
