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
 * Projector for ExternalNetworkInjection as outlined for the CQRS pattern. All event handling and
 * query handling related to ExternalNetworkInjection are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by ExternalNetworkInjectionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("externalNetworkInjection")
@Component("externalNetworkInjection-projector")
public class ExternalNetworkInjectionProjector extends ExternalNetworkInjectionEntityProjector {

  // core constructor
  public ExternalNetworkInjectionProjector(
      ExternalNetworkInjectionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = CreateExternalNetworkInjectionEvent.class)
  public void handle(CreateExternalNetworkInjectionEvent event) {
    LOGGER.info("handling CreateExternalNetworkInjectionEvent - " + event);
    ExternalNetworkInjection entity = new ExternalNetworkInjection();
    entity.setExternalNetworkInjectionId(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UpdateExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UpdateExternalNetworkInjectionEvent.class)
  public void handle(UpdateExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UpdateExternalNetworkInjectionEvent - " + event);

    ExternalNetworkInjection entity = new ExternalNetworkInjection();
    entity.setExternalNetworkInjectionId(event.getExternalNetworkInjectionId());
    entity.setGovernorSCD(event.getGovernorSCD());
    entity.setIkSecond(event.getIkSecond());
    entity.setMaxInitialSymShCCurrent(event.getMaxInitialSymShCCurrent());
    entity.setMaxP(event.getMaxP());
    entity.setMaxQ(event.getMaxQ());
    entity.setMaxR0ToX0Ratio(event.getMaxR0ToX0Ratio());
    entity.setMaxR1ToX1Ratio(event.getMaxR1ToX1Ratio());
    entity.setMaxZ0ToZ1Ratio(event.getMaxZ0ToZ1Ratio());
    entity.setMinInitialSymShCCurrent(event.getMinInitialSymShCCurrent());
    entity.setMinP(event.getMinP());
    entity.setMinQ(event.getMinQ());
    entity.setMinR0ToX0Ratio(event.getMinR0ToX0Ratio());
    entity.setMinR1ToX1Ratio(event.getMinR1ToX1Ratio());
    entity.setMinZ0ToZ1Ratio(event.getMinZ0ToZ1Ratio());
    entity.setVoltageFactor(event.getVoltageFactor());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event DeleteExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = DeleteExternalNetworkInjectionEvent.class)
  public void handle(DeleteExternalNetworkInjectionEvent event) {
    LOGGER.info("handling DeleteExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExternalNetworkInjection entity = delete(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignGovernorSCDToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignGovernorSCDToExternalNetworkInjectionEvent.class)
  public void handle(AssignGovernorSCDToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignGovernorSCDToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignGovernorSCD(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignGovernorSCDFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignGovernorSCDFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignGovernorSCDFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignGovernorSCDFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignGovernorSCD(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignIkSecondToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignIkSecondToExternalNetworkInjectionEvent.class)
  public void handle(AssignIkSecondToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignIkSecondToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignIkSecond(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignIkSecondFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignIkSecondFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignIkSecondFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignIkSecondFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignIkSecond(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent.class)
  public void handle(AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMaxInitialSymShCCurrentToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMaxInitialSymShCCurrent(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent
   */
  @EventHandler(
      payloadType = UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent event) {
    LOGGER.info(
        "handling UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity =
        unAssignMaxInitialSymShCCurrent(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMaxPToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxPToExternalNetworkInjectionEvent.class)
  public void handle(AssignMaxPToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMaxPToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMaxP(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMaxPFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxPFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMaxPFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxPFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMaxP(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMaxQToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxQToExternalNetworkInjectionEvent.class)
  public void handle(AssignMaxQToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMaxQToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMaxQ(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMaxQFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxQFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMaxQFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxQFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMaxQ(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent.class)
  public void handle(AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMaxR0ToX0RatioToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMaxR0ToX0Ratio(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMaxR0ToX0Ratio(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent.class)
  public void handle(AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMaxR1ToX1RatioToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMaxR1ToX1Ratio(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMaxR1ToX1Ratio(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent.class)
  public void handle(AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMaxZ0ToZ1RatioToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMaxZ0ToZ1Ratio(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMaxZ0ToZ1Ratio(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent.class)
  public void handle(AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMinInitialSymShCCurrentToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMinInitialSymShCCurrent(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent
   */
  @EventHandler(
      payloadType = UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent event) {
    LOGGER.info(
        "handling UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity =
        unAssignMinInitialSymShCCurrent(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMinPToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMinPToExternalNetworkInjectionEvent.class)
  public void handle(AssignMinPToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMinPToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMinP(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMinPFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinPFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMinPFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMinPFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMinP(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMinQToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMinQToExternalNetworkInjectionEvent.class)
  public void handle(AssignMinQToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMinQToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMinQ(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMinQFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinQFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMinQFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMinQFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMinQ(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMinR0ToX0RatioToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMinR0ToX0RatioToExternalNetworkInjectionEvent.class)
  public void handle(AssignMinR0ToX0RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMinR0ToX0RatioToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMinR0ToX0Ratio(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMinR0ToX0RatioFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMinR0ToX0Ratio(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMinR1ToX1RatioToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMinR1ToX1RatioToExternalNetworkInjectionEvent.class)
  public void handle(AssignMinR1ToX1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMinR1ToX1RatioToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMinR1ToX1Ratio(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMinR1ToX1RatioFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMinR1ToX1Ratio(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent.class)
  public void handle(AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignMinZ0ToZ1RatioToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignMinZ0ToZ1Ratio(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignMinZ0ToZ1Ratio(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event AssignVoltageFactorToExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = AssignVoltageFactorToExternalNetworkInjectionEvent.class)
  public void handle(AssignVoltageFactorToExternalNetworkInjectionEvent event) {
    LOGGER.info("handling AssignVoltageFactorToExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExternalNetworkInjection entity =
        assignVoltageFactor(event.getExternalNetworkInjectionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /*
   * @param	event UnAssignVoltageFactorFromExternalNetworkInjectionEvent
   */
  @EventHandler(payloadType = UnAssignVoltageFactorFromExternalNetworkInjectionEvent.class)
  public void handle(UnAssignVoltageFactorFromExternalNetworkInjectionEvent event) {
    LOGGER.info("handling UnAssignVoltageFactorFromExternalNetworkInjectionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExternalNetworkInjection entity = unAssignVoltageFactor(event.getExternalNetworkInjectionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExternalNetworkInjection(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExternalNetworkInjection(entity);
  }

  /**
   * Method to retrieve the ExternalNetworkInjection via an ExternalNetworkInjectionPrimaryKey.
   *
   * @param id Long
   * @return ExternalNetworkInjection
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExternalNetworkInjection handle(FindExternalNetworkInjectionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExternalNetworkInjectionId());
  }

  /**
   * Method to retrieve a collection of all ExternalNetworkInjections
   *
   * @param query FindAllExternalNetworkInjectionQuery
   * @return List<ExternalNetworkInjection>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExternalNetworkInjection> handle(FindAllExternalNetworkInjectionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExternalNetworkInjection, but only if the id matches
   *
   * @param entity ExternalNetworkInjection
   */
  protected void emitFindExternalNetworkInjection(ExternalNetworkInjection entity) {
    LOGGER.info("handling emitFindExternalNetworkInjection");

    queryUpdateEmitter.emit(
        FindExternalNetworkInjectionQuery.class,
        query ->
            query
                .getFilter()
                .getExternalNetworkInjectionId()
                .equals(entity.getExternalNetworkInjectionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExternalNetworkInjection
   *
   * @param entity ExternalNetworkInjection
   */
  protected void emitFindAllExternalNetworkInjection(ExternalNetworkInjection entity) {
    LOGGER.info("handling emitFindAllExternalNetworkInjection");

    queryUpdateEmitter.emit(FindAllExternalNetworkInjectionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(ExternalNetworkInjectionProjector.class.getName());
}
