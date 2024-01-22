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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcST6B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcST6B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcST6BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excST6B")
@Component("excST6B-projector")
public class ExcST6BProjector extends ExcST6BEntityProjector {

  // core constructor
  public ExcST6BProjector(ExcST6BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcST6BEvent
   */
  @EventHandler(payloadType = CreateExcST6BEvent.class)
  public void handle(CreateExcST6BEvent event) {
    LOGGER.info("handling CreateExcST6BEvent - " + event);
    ExcST6B entity = new ExcST6B();
    entity.setExcST6BId(event.getExcST6BId());
    entity.setOelin(event.getOelin());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UpdateExcST6BEvent
   */
  @EventHandler(payloadType = UpdateExcST6BEvent.class)
  public void handle(UpdateExcST6BEvent event) {
    LOGGER.info("handling UpdateExcST6BEvent - " + event);

    ExcST6B entity = new ExcST6B();
    entity.setExcST6BId(event.getExcST6BId());
    entity.setIlr(event.getIlr());
    entity.setK1(event.getK1());
    entity.setKcl(event.getKcl());
    entity.setKff(event.getKff());
    entity.setKg(event.getKg());
    entity.setKia(event.getKia());
    entity.setKlr(event.getKlr());
    entity.setKm(event.getKm());
    entity.setKpa(event.getKpa());
    entity.setKvd(event.getKvd());
    entity.setOelin(event.getOelin());
    entity.setTg(event.getTg());
    entity.setTs(event.getTs());
    entity.setTvd(event.getTvd());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
    entity.setVilim(event.getVilim());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVmult(event.getVmult());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setXc(event.getXc());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event DeleteExcST6BEvent
   */
  @EventHandler(payloadType = DeleteExcST6BEvent.class)
  public void handle(DeleteExcST6BEvent event) {
    LOGGER.info("handling DeleteExcST6BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcST6B entity = delete(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignIlrToExcST6BEvent
   */
  @EventHandler(payloadType = AssignIlrToExcST6BEvent.class)
  public void handle(AssignIlrToExcST6BEvent event) {
    LOGGER.info("handling AssignIlrToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignIlr(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignIlrFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignIlrFromExcST6BEvent.class)
  public void handle(UnAssignIlrFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignIlrFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignIlr(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignK1ToExcST6BEvent
   */
  @EventHandler(payloadType = AssignK1ToExcST6BEvent.class)
  public void handle(AssignK1ToExcST6BEvent event) {
    LOGGER.info("handling AssignK1ToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignK1(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignK1FromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignK1FromExcST6BEvent.class)
  public void handle(UnAssignK1FromExcST6BEvent event) {
    LOGGER.info("handling UnAssignK1FromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignK1(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKclToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKclToExcST6BEvent.class)
  public void handle(AssignKclToExcST6BEvent event) {
    LOGGER.info("handling AssignKclToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKcl(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKclFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKclFromExcST6BEvent.class)
  public void handle(UnAssignKclFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKclFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKcl(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKffToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKffToExcST6BEvent.class)
  public void handle(AssignKffToExcST6BEvent event) {
    LOGGER.info("handling AssignKffToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKff(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKffFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKffFromExcST6BEvent.class)
  public void handle(UnAssignKffFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKffFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKff(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKgToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKgToExcST6BEvent.class)
  public void handle(AssignKgToExcST6BEvent event) {
    LOGGER.info("handling AssignKgToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKg(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKgFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKgFromExcST6BEvent.class)
  public void handle(UnAssignKgFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKgFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKg(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKiaToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKiaToExcST6BEvent.class)
  public void handle(AssignKiaToExcST6BEvent event) {
    LOGGER.info("handling AssignKiaToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKia(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKiaFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKiaFromExcST6BEvent.class)
  public void handle(UnAssignKiaFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKiaFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKia(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKlrToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKlrToExcST6BEvent.class)
  public void handle(AssignKlrToExcST6BEvent event) {
    LOGGER.info("handling AssignKlrToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKlr(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKlrFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKlrFromExcST6BEvent.class)
  public void handle(UnAssignKlrFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKlrFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKlr(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKmToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKmToExcST6BEvent.class)
  public void handle(AssignKmToExcST6BEvent event) {
    LOGGER.info("handling AssignKmToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKm(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKmFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKmFromExcST6BEvent.class)
  public void handle(UnAssignKmFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKmFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKm(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKpaToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKpaToExcST6BEvent.class)
  public void handle(AssignKpaToExcST6BEvent event) {
    LOGGER.info("handling AssignKpaToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKpa(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKpaFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKpaFromExcST6BEvent.class)
  public void handle(UnAssignKpaFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKpaFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKpa(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignKvdToExcST6BEvent
   */
  @EventHandler(payloadType = AssignKvdToExcST6BEvent.class)
  public void handle(AssignKvdToExcST6BEvent event) {
    LOGGER.info("handling AssignKvdToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignKvd(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignKvdFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignKvdFromExcST6BEvent.class)
  public void handle(UnAssignKvdFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignKvdFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignKvd(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignTgToExcST6BEvent
   */
  @EventHandler(payloadType = AssignTgToExcST6BEvent.class)
  public void handle(AssignTgToExcST6BEvent event) {
    LOGGER.info("handling AssignTgToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignTg(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignTgFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignTgFromExcST6BEvent.class)
  public void handle(UnAssignTgFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignTgFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignTg(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignTsToExcST6BEvent
   */
  @EventHandler(payloadType = AssignTsToExcST6BEvent.class)
  public void handle(AssignTsToExcST6BEvent event) {
    LOGGER.info("handling AssignTsToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignTs(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignTsFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignTsFromExcST6BEvent.class)
  public void handle(UnAssignTsFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignTsFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignTs(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignTvdToExcST6BEvent
   */
  @EventHandler(payloadType = AssignTvdToExcST6BEvent.class)
  public void handle(AssignTvdToExcST6BEvent event) {
    LOGGER.info("handling AssignTvdToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignTvd(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignTvdFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignTvdFromExcST6BEvent.class)
  public void handle(UnAssignTvdFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignTvdFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignTvd(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVamaxToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcST6BEvent.class)
  public void handle(AssignVamaxToExcST6BEvent event) {
    LOGGER.info("handling AssignVamaxToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVamax(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcST6BEvent.class)
  public void handle(UnAssignVamaxFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVamax(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVaminToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVaminToExcST6BEvent.class)
  public void handle(AssignVaminToExcST6BEvent event) {
    LOGGER.info("handling AssignVaminToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVamin(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcST6BEvent.class)
  public void handle(UnAssignVaminFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVamin(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVilimToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVilimToExcST6BEvent.class)
  public void handle(AssignVilimToExcST6BEvent event) {
    LOGGER.info("handling AssignVilimToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVilim(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVilimFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVilimFromExcST6BEvent.class)
  public void handle(UnAssignVilimFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVilimFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVilim(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVimaxToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcST6BEvent.class)
  public void handle(AssignVimaxToExcST6BEvent event) {
    LOGGER.info("handling AssignVimaxToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVimax(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcST6BEvent.class)
  public void handle(UnAssignVimaxFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVimax(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignViminToExcST6BEvent
   */
  @EventHandler(payloadType = AssignViminToExcST6BEvent.class)
  public void handle(AssignViminToExcST6BEvent event) {
    LOGGER.info("handling AssignViminToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVimin(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignViminFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcST6BEvent.class)
  public void handle(UnAssignViminFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignViminFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVimin(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVmultToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVmultToExcST6BEvent.class)
  public void handle(AssignVmultToExcST6BEvent event) {
    LOGGER.info("handling AssignVmultToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVmult(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVmultFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVmultFromExcST6BEvent.class)
  public void handle(UnAssignVmultFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVmultFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVmult(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcST6BEvent.class)
  public void handle(AssignVrmaxToExcST6BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVrmax(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcST6BEvent.class)
  public void handle(UnAssignVrmaxFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVrmax(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignVrminToExcST6BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcST6BEvent.class)
  public void handle(AssignVrminToExcST6BEvent event) {
    LOGGER.info("handling AssignVrminToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignVrmin(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcST6BEvent.class)
  public void handle(UnAssignVrminFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignVrmin(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event AssignXcToExcST6BEvent
   */
  @EventHandler(payloadType = AssignXcToExcST6BEvent.class)
  public void handle(AssignXcToExcST6BEvent event) {
    LOGGER.info("handling AssignXcToExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST6B entity = assignXc(event.getExcST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /*
   * @param	event UnAssignXcFromExcST6BEvent
   */
  @EventHandler(payloadType = UnAssignXcFromExcST6BEvent.class)
  public void handle(UnAssignXcFromExcST6BEvent event) {
    LOGGER.info("handling UnAssignXcFromExcST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST6B entity = unAssignXc(event.getExcST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST6B(entity);
  }

  /**
   * Method to retrieve the ExcST6B via an ExcST6BPrimaryKey.
   *
   * @param id Long
   * @return ExcST6B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcST6B handle(FindExcST6BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcST6BId());
  }

  /**
   * Method to retrieve a collection of all ExcST6Bs
   *
   * @param query FindAllExcST6BQuery
   * @return List<ExcST6B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcST6B> handle(FindAllExcST6BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcST6B, but only if the id matches
   *
   * @param entity ExcST6B
   */
  protected void emitFindExcST6B(ExcST6B entity) {
    LOGGER.info("handling emitFindExcST6B");

    queryUpdateEmitter.emit(
        FindExcST6BQuery.class,
        query -> query.getFilter().getExcST6BId().equals(entity.getExcST6BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcST6B
   *
   * @param entity ExcST6B
   */
  protected void emitFindAllExcST6B(ExcST6B entity) {
    LOGGER.info("handling emitFindAllExcST6B");

    queryUpdateEmitter.emit(FindAllExcST6BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcST6BProjector.class.getName());
}
