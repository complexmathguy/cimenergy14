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
 * Projector for ExcSK as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcSK are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcSKAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excSK")
@Component("excSK-projector")
public class ExcSKProjector extends ExcSKEntityProjector {

  // core constructor
  public ExcSKProjector(ExcSKRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcSKEvent
   */
  @EventHandler(payloadType = CreateExcSKEvent.class)
  public void handle(CreateExcSKEvent event) {
    LOGGER.info("handling CreateExcSKEvent - " + event);
    ExcSK entity = new ExcSK();
    entity.setExcSKId(event.getExcSKId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UpdateExcSKEvent
   */
  @EventHandler(payloadType = UpdateExcSKEvent.class)
  public void handle(UpdateExcSKEvent event) {
    LOGGER.info("handling UpdateExcSKEvent - " + event);

    ExcSK entity = new ExcSK();
    entity.setExcSKId(event.getExcSKId());
    entity.setEfdmax(event.getEfdmax());
    entity.setEfdmin(event.getEfdmin());
    entity.setEmax(event.getEmax());
    entity.setEmin(event.getEmin());
    entity.setK(event.getK());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setKc(event.getKc());
    entity.setKce(event.getKce());
    entity.setKd(event.getKd());
    entity.setKgob(event.getKgob());
    entity.setKp(event.getKp());
    entity.setKqi(event.getKqi());
    entity.setKqob(event.getKqob());
    entity.setKqp(event.getKqp());
    entity.setNq(event.getNq());
    entity.setQconoff(event.getQconoff());
    entity.setQz(event.getQz());
    entity.setRemote(event.getRemote());
    entity.setSbase(event.getSbase());
    entity.setTc(event.getTc());
    entity.setTe(event.getTe());
    entity.setTi(event.getTi());
    entity.setTp(event.getTp());
    entity.setTr(event.getTr());
    entity.setUimax(event.getUimax());
    entity.setUimin(event.getUimin());
    entity.setUrmax(event.getUrmax());
    entity.setUrmin(event.getUrmin());
    entity.setVtmax(event.getVtmax());
    entity.setVtmin(event.getVtmin());
    entity.setYp(event.getYp());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event DeleteExcSKEvent
   */
  @EventHandler(payloadType = DeleteExcSKEvent.class)
  public void handle(DeleteExcSKEvent event) {
    LOGGER.info("handling DeleteExcSKEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcSK entity = delete(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcSKEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcSKEvent.class)
  public void handle(AssignEfdmaxToExcSKEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignEfdmax(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcSKEvent.class)
  public void handle(UnAssignEfdmaxFromExcSKEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignEfdmax(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignEfdminToExcSKEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcSKEvent.class)
  public void handle(AssignEfdminToExcSKEvent event) {
    LOGGER.info("handling AssignEfdminToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignEfdmin(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcSKEvent.class)
  public void handle(UnAssignEfdminFromExcSKEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignEfdmin(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignEmaxToExcSKEvent
   */
  @EventHandler(payloadType = AssignEmaxToExcSKEvent.class)
  public void handle(AssignEmaxToExcSKEvent event) {
    LOGGER.info("handling AssignEmaxToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignEmax(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignEmaxFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignEmaxFromExcSKEvent.class)
  public void handle(UnAssignEmaxFromExcSKEvent event) {
    LOGGER.info("handling UnAssignEmaxFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignEmax(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignEminToExcSKEvent
   */
  @EventHandler(payloadType = AssignEminToExcSKEvent.class)
  public void handle(AssignEminToExcSKEvent event) {
    LOGGER.info("handling AssignEminToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignEmin(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignEminFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignEminFromExcSKEvent.class)
  public void handle(UnAssignEminFromExcSKEvent event) {
    LOGGER.info("handling UnAssignEminFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignEmin(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKToExcSKEvent
   */
  @EventHandler(payloadType = AssignKToExcSKEvent.class)
  public void handle(AssignKToExcSKEvent event) {
    LOGGER.info("handling AssignKToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignK(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKFromExcSKEvent.class)
  public void handle(UnAssignKFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignK(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignK1ToExcSKEvent
   */
  @EventHandler(payloadType = AssignK1ToExcSKEvent.class)
  public void handle(AssignK1ToExcSKEvent event) {
    LOGGER.info("handling AssignK1ToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignK1(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignK1FromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignK1FromExcSKEvent.class)
  public void handle(UnAssignK1FromExcSKEvent event) {
    LOGGER.info("handling UnAssignK1FromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignK1(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignK2ToExcSKEvent
   */
  @EventHandler(payloadType = AssignK2ToExcSKEvent.class)
  public void handle(AssignK2ToExcSKEvent event) {
    LOGGER.info("handling AssignK2ToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignK2(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignK2FromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignK2FromExcSKEvent.class)
  public void handle(UnAssignK2FromExcSKEvent event) {
    LOGGER.info("handling UnAssignK2FromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignK2(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKcToExcSKEvent
   */
  @EventHandler(payloadType = AssignKcToExcSKEvent.class)
  public void handle(AssignKcToExcSKEvent event) {
    LOGGER.info("handling AssignKcToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKc(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKcFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcSKEvent.class)
  public void handle(UnAssignKcFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKcFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKc(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKceToExcSKEvent
   */
  @EventHandler(payloadType = AssignKceToExcSKEvent.class)
  public void handle(AssignKceToExcSKEvent event) {
    LOGGER.info("handling AssignKceToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKce(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKceFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKceFromExcSKEvent.class)
  public void handle(UnAssignKceFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKceFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKce(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKdToExcSKEvent
   */
  @EventHandler(payloadType = AssignKdToExcSKEvent.class)
  public void handle(AssignKdToExcSKEvent event) {
    LOGGER.info("handling AssignKdToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKd(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKdFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcSKEvent.class)
  public void handle(UnAssignKdFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKdFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKd(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKgobToExcSKEvent
   */
  @EventHandler(payloadType = AssignKgobToExcSKEvent.class)
  public void handle(AssignKgobToExcSKEvent event) {
    LOGGER.info("handling AssignKgobToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKgob(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKgobFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKgobFromExcSKEvent.class)
  public void handle(UnAssignKgobFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKgobFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKgob(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKpToExcSKEvent
   */
  @EventHandler(payloadType = AssignKpToExcSKEvent.class)
  public void handle(AssignKpToExcSKEvent event) {
    LOGGER.info("handling AssignKpToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKp(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKpFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcSKEvent.class)
  public void handle(UnAssignKpFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKpFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKp(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKqiToExcSKEvent
   */
  @EventHandler(payloadType = AssignKqiToExcSKEvent.class)
  public void handle(AssignKqiToExcSKEvent event) {
    LOGGER.info("handling AssignKqiToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKqi(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKqiFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKqiFromExcSKEvent.class)
  public void handle(UnAssignKqiFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKqiFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKqi(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKqobToExcSKEvent
   */
  @EventHandler(payloadType = AssignKqobToExcSKEvent.class)
  public void handle(AssignKqobToExcSKEvent event) {
    LOGGER.info("handling AssignKqobToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKqob(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKqobFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKqobFromExcSKEvent.class)
  public void handle(UnAssignKqobFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKqobFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKqob(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignKqpToExcSKEvent
   */
  @EventHandler(payloadType = AssignKqpToExcSKEvent.class)
  public void handle(AssignKqpToExcSKEvent event) {
    LOGGER.info("handling AssignKqpToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignKqp(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignKqpFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignKqpFromExcSKEvent.class)
  public void handle(UnAssignKqpFromExcSKEvent event) {
    LOGGER.info("handling UnAssignKqpFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignKqp(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignNqToExcSKEvent
   */
  @EventHandler(payloadType = AssignNqToExcSKEvent.class)
  public void handle(AssignNqToExcSKEvent event) {
    LOGGER.info("handling AssignNqToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignNq(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignNqFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignNqFromExcSKEvent.class)
  public void handle(UnAssignNqFromExcSKEvent event) {
    LOGGER.info("handling UnAssignNqFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignNq(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignQconoffToExcSKEvent
   */
  @EventHandler(payloadType = AssignQconoffToExcSKEvent.class)
  public void handle(AssignQconoffToExcSKEvent event) {
    LOGGER.info("handling AssignQconoffToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignQconoff(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignQconoffFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignQconoffFromExcSKEvent.class)
  public void handle(UnAssignQconoffFromExcSKEvent event) {
    LOGGER.info("handling UnAssignQconoffFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignQconoff(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignQzToExcSKEvent
   */
  @EventHandler(payloadType = AssignQzToExcSKEvent.class)
  public void handle(AssignQzToExcSKEvent event) {
    LOGGER.info("handling AssignQzToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignQz(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignQzFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignQzFromExcSKEvent.class)
  public void handle(UnAssignQzFromExcSKEvent event) {
    LOGGER.info("handling UnAssignQzFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignQz(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignRemoteToExcSKEvent
   */
  @EventHandler(payloadType = AssignRemoteToExcSKEvent.class)
  public void handle(AssignRemoteToExcSKEvent event) {
    LOGGER.info("handling AssignRemoteToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignRemote(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignRemoteFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignRemoteFromExcSKEvent.class)
  public void handle(UnAssignRemoteFromExcSKEvent event) {
    LOGGER.info("handling UnAssignRemoteFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignRemote(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignSbaseToExcSKEvent
   */
  @EventHandler(payloadType = AssignSbaseToExcSKEvent.class)
  public void handle(AssignSbaseToExcSKEvent event) {
    LOGGER.info("handling AssignSbaseToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignSbase(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignSbaseFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignSbaseFromExcSKEvent.class)
  public void handle(UnAssignSbaseFromExcSKEvent event) {
    LOGGER.info("handling UnAssignSbaseFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignSbase(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignTcToExcSKEvent
   */
  @EventHandler(payloadType = AssignTcToExcSKEvent.class)
  public void handle(AssignTcToExcSKEvent event) {
    LOGGER.info("handling AssignTcToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignTc(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignTcFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcSKEvent.class)
  public void handle(UnAssignTcFromExcSKEvent event) {
    LOGGER.info("handling UnAssignTcFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignTc(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignTeToExcSKEvent
   */
  @EventHandler(payloadType = AssignTeToExcSKEvent.class)
  public void handle(AssignTeToExcSKEvent event) {
    LOGGER.info("handling AssignTeToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignTe(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignTeFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcSKEvent.class)
  public void handle(UnAssignTeFromExcSKEvent event) {
    LOGGER.info("handling UnAssignTeFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignTe(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignTiToExcSKEvent
   */
  @EventHandler(payloadType = AssignTiToExcSKEvent.class)
  public void handle(AssignTiToExcSKEvent event) {
    LOGGER.info("handling AssignTiToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignTi(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignTiFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignTiFromExcSKEvent.class)
  public void handle(UnAssignTiFromExcSKEvent event) {
    LOGGER.info("handling UnAssignTiFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignTi(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignTpToExcSKEvent
   */
  @EventHandler(payloadType = AssignTpToExcSKEvent.class)
  public void handle(AssignTpToExcSKEvent event) {
    LOGGER.info("handling AssignTpToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignTp(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignTpFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignTpFromExcSKEvent.class)
  public void handle(UnAssignTpFromExcSKEvent event) {
    LOGGER.info("handling UnAssignTpFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignTp(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignTrToExcSKEvent
   */
  @EventHandler(payloadType = AssignTrToExcSKEvent.class)
  public void handle(AssignTrToExcSKEvent event) {
    LOGGER.info("handling AssignTrToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignTr(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignTrFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignTrFromExcSKEvent.class)
  public void handle(UnAssignTrFromExcSKEvent event) {
    LOGGER.info("handling UnAssignTrFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignTr(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignUimaxToExcSKEvent
   */
  @EventHandler(payloadType = AssignUimaxToExcSKEvent.class)
  public void handle(AssignUimaxToExcSKEvent event) {
    LOGGER.info("handling AssignUimaxToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignUimax(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignUimaxFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignUimaxFromExcSKEvent.class)
  public void handle(UnAssignUimaxFromExcSKEvent event) {
    LOGGER.info("handling UnAssignUimaxFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignUimax(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignUiminToExcSKEvent
   */
  @EventHandler(payloadType = AssignUiminToExcSKEvent.class)
  public void handle(AssignUiminToExcSKEvent event) {
    LOGGER.info("handling AssignUiminToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignUimin(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignUiminFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignUiminFromExcSKEvent.class)
  public void handle(UnAssignUiminFromExcSKEvent event) {
    LOGGER.info("handling UnAssignUiminFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignUimin(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignUrmaxToExcSKEvent
   */
  @EventHandler(payloadType = AssignUrmaxToExcSKEvent.class)
  public void handle(AssignUrmaxToExcSKEvent event) {
    LOGGER.info("handling AssignUrmaxToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignUrmax(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignUrmaxFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignUrmaxFromExcSKEvent.class)
  public void handle(UnAssignUrmaxFromExcSKEvent event) {
    LOGGER.info("handling UnAssignUrmaxFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignUrmax(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignUrminToExcSKEvent
   */
  @EventHandler(payloadType = AssignUrminToExcSKEvent.class)
  public void handle(AssignUrminToExcSKEvent event) {
    LOGGER.info("handling AssignUrminToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignUrmin(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignUrminFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignUrminFromExcSKEvent.class)
  public void handle(UnAssignUrminFromExcSKEvent event) {
    LOGGER.info("handling UnAssignUrminFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignUrmin(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignVtmaxToExcSKEvent
   */
  @EventHandler(payloadType = AssignVtmaxToExcSKEvent.class)
  public void handle(AssignVtmaxToExcSKEvent event) {
    LOGGER.info("handling AssignVtmaxToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignVtmax(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignVtmaxFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignVtmaxFromExcSKEvent.class)
  public void handle(UnAssignVtmaxFromExcSKEvent event) {
    LOGGER.info("handling UnAssignVtmaxFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignVtmax(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignVtminToExcSKEvent
   */
  @EventHandler(payloadType = AssignVtminToExcSKEvent.class)
  public void handle(AssignVtminToExcSKEvent event) {
    LOGGER.info("handling AssignVtminToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignVtmin(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignVtminFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignVtminFromExcSKEvent.class)
  public void handle(UnAssignVtminFromExcSKEvent event) {
    LOGGER.info("handling UnAssignVtminFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignVtmin(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event AssignYpToExcSKEvent
   */
  @EventHandler(payloadType = AssignYpToExcSKEvent.class)
  public void handle(AssignYpToExcSKEvent event) {
    LOGGER.info("handling AssignYpToExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSK entity = assignYp(event.getExcSKId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /*
   * @param	event UnAssignYpFromExcSKEvent
   */
  @EventHandler(payloadType = UnAssignYpFromExcSKEvent.class)
  public void handle(UnAssignYpFromExcSKEvent event) {
    LOGGER.info("handling UnAssignYpFromExcSKEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSK entity = unAssignYp(event.getExcSKId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSK(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSK(entity);
  }

  /**
   * Method to retrieve the ExcSK via an ExcSKPrimaryKey.
   *
   * @param id Long
   * @return ExcSK
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcSK handle(FindExcSKQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcSKId());
  }

  /**
   * Method to retrieve a collection of all ExcSKs
   *
   * @param query FindAllExcSKQuery
   * @return List<ExcSK>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcSK> handle(FindAllExcSKQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcSK, but only if the id matches
   *
   * @param entity ExcSK
   */
  protected void emitFindExcSK(ExcSK entity) {
    LOGGER.info("handling emitFindExcSK");

    queryUpdateEmitter.emit(
        FindExcSKQuery.class,
        query -> query.getFilter().getExcSKId().equals(entity.getExcSKId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcSK
   *
   * @param entity ExcSK
   */
  protected void emitFindAllExcSK(ExcSK entity) {
    LOGGER.info("handling emitFindAllExcSK");

    queryUpdateEmitter.emit(FindAllExcSKQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcSKProjector.class.getName());
}
