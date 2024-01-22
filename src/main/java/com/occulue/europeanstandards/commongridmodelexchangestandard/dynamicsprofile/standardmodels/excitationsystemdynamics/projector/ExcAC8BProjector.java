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
 * Projector for ExcAC8B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC8B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC8BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC8B")
@Component("excAC8B-projector")
public class ExcAC8BProjector extends ExcAC8BEntityProjector {

  // core constructor
  public ExcAC8BProjector(ExcAC8BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC8BEvent
   */
  @EventHandler(payloadType = CreateExcAC8BEvent.class)
  public void handle(CreateExcAC8BEvent event) {
    LOGGER.info("handling CreateExcAC8BEvent - " + event);
    ExcAC8B entity = new ExcAC8B();
    entity.setExcAC8BId(event.getExcAC8BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UpdateExcAC8BEvent
   */
  @EventHandler(payloadType = UpdateExcAC8BEvent.class)
  public void handle(UpdateExcAC8BEvent event) {
    LOGGER.info("handling UpdateExcAC8BEvent - " + event);

    ExcAC8B entity = new ExcAC8B();
    entity.setExcAC8BId(event.getExcAC8BId());
    entity.setInlim(event.getInlim());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKdr(event.getKdr());
    entity.setKe(event.getKe());
    entity.setKir(event.getKir());
    entity.setKpr(event.getKpr());
    entity.setKs(event.getKs());
    entity.setPidlim(event.getPidlim());
    entity.setSeve1(event.getSeve1());
    entity.setSeve2(event.getSeve2());
    entity.setTa(event.getTa());
    entity.setTdr(event.getTdr());
    entity.setTe(event.getTe());
    entity.setTelim(event.getTelim());
    entity.setVe1(event.getVe1());
    entity.setVe2(event.getVe2());
    entity.setVemin(event.getVemin());
    entity.setVfemax(event.getVfemax());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVpidmax(event.getVpidmax());
    entity.setVpidmin(event.getVpidmin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setVtmult(event.getVtmult());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event DeleteExcAC8BEvent
   */
  @EventHandler(payloadType = DeleteExcAC8BEvent.class)
  public void handle(DeleteExcAC8BEvent event) {
    LOGGER.info("handling DeleteExcAC8BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC8B entity = delete(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignInlimToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignInlimToExcAC8BEvent.class)
  public void handle(AssignInlimToExcAC8BEvent event) {
    LOGGER.info("handling AssignInlimToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignInlim(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignInlimFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignInlimFromExcAC8BEvent.class)
  public void handle(UnAssignInlimFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignInlimFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignInlim(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKaToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC8BEvent.class)
  public void handle(AssignKaToExcAC8BEvent event) {
    LOGGER.info("handling AssignKaToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKa(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC8BEvent.class)
  public void handle(UnAssignKaFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKa(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKcToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKcToExcAC8BEvent.class)
  public void handle(AssignKcToExcAC8BEvent event) {
    LOGGER.info("handling AssignKcToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKc(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKcFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcAC8BEvent.class)
  public void handle(UnAssignKcFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKcFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKc(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKdToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKdToExcAC8BEvent.class)
  public void handle(AssignKdToExcAC8BEvent event) {
    LOGGER.info("handling AssignKdToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKd(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKdFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcAC8BEvent.class)
  public void handle(UnAssignKdFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKdFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKd(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKdrToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKdrToExcAC8BEvent.class)
  public void handle(AssignKdrToExcAC8BEvent event) {
    LOGGER.info("handling AssignKdrToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKdr(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKdrFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKdrFromExcAC8BEvent.class)
  public void handle(UnAssignKdrFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKdrFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKdr(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKeToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKeToExcAC8BEvent.class)
  public void handle(AssignKeToExcAC8BEvent event) {
    LOGGER.info("handling AssignKeToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKe(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcAC8BEvent.class)
  public void handle(UnAssignKeFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKeFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKe(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKirToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKirToExcAC8BEvent.class)
  public void handle(AssignKirToExcAC8BEvent event) {
    LOGGER.info("handling AssignKirToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKir(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKirFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKirFromExcAC8BEvent.class)
  public void handle(UnAssignKirFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKirFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKir(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKprToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKprToExcAC8BEvent.class)
  public void handle(AssignKprToExcAC8BEvent event) {
    LOGGER.info("handling AssignKprToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKpr(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKprFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKprFromExcAC8BEvent.class)
  public void handle(UnAssignKprFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKprFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKpr(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignKsToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignKsToExcAC8BEvent.class)
  public void handle(AssignKsToExcAC8BEvent event) {
    LOGGER.info("handling AssignKsToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignKs(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignKsFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcAC8BEvent.class)
  public void handle(UnAssignKsFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignKsFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignKs(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignPidlimToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignPidlimToExcAC8BEvent.class)
  public void handle(AssignPidlimToExcAC8BEvent event) {
    LOGGER.info("handling AssignPidlimToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignPidlim(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignPidlimFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignPidlimFromExcAC8BEvent.class)
  public void handle(UnAssignPidlimFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignPidlimFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignPidlim(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignSeve1ToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcAC8BEvent.class)
  public void handle(AssignSeve1ToExcAC8BEvent event) {
    LOGGER.info("handling AssignSeve1ToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignSeve1(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcAC8BEvent.class)
  public void handle(UnAssignSeve1FromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignSeve1(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignSeve2ToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcAC8BEvent.class)
  public void handle(AssignSeve2ToExcAC8BEvent event) {
    LOGGER.info("handling AssignSeve2ToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignSeve2(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcAC8BEvent.class)
  public void handle(UnAssignSeve2FromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignSeve2(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignTaToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC8BEvent.class)
  public void handle(AssignTaToExcAC8BEvent event) {
    LOGGER.info("handling AssignTaToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignTa(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC8BEvent.class)
  public void handle(UnAssignTaFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignTa(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignTdrToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignTdrToExcAC8BEvent.class)
  public void handle(AssignTdrToExcAC8BEvent event) {
    LOGGER.info("handling AssignTdrToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignTdr(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignTdrFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTdrFromExcAC8BEvent.class)
  public void handle(UnAssignTdrFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignTdrFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignTdr(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignTeToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignTeToExcAC8BEvent.class)
  public void handle(AssignTeToExcAC8BEvent event) {
    LOGGER.info("handling AssignTeToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignTe(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcAC8BEvent.class)
  public void handle(UnAssignTeFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignTeFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignTe(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignTelimToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignTelimToExcAC8BEvent.class)
  public void handle(AssignTelimToExcAC8BEvent event) {
    LOGGER.info("handling AssignTelimToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignTelim(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignTelimFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTelimFromExcAC8BEvent.class)
  public void handle(UnAssignTelimFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignTelimFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignTelim(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVe1ToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcAC8BEvent.class)
  public void handle(AssignVe1ToExcAC8BEvent event) {
    LOGGER.info("handling AssignVe1ToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVe1(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcAC8BEvent.class)
  public void handle(UnAssignVe1FromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVe1(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVe2ToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcAC8BEvent.class)
  public void handle(AssignVe2ToExcAC8BEvent event) {
    LOGGER.info("handling AssignVe2ToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVe2(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcAC8BEvent.class)
  public void handle(UnAssignVe2FromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVe2(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVeminToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVeminToExcAC8BEvent.class)
  public void handle(AssignVeminToExcAC8BEvent event) {
    LOGGER.info("handling AssignVeminToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVemin(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVeminFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVeminFromExcAC8BEvent.class)
  public void handle(UnAssignVeminFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVeminFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVemin(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVfemaxToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcAC8BEvent.class)
  public void handle(AssignVfemaxToExcAC8BEvent event) {
    LOGGER.info("handling AssignVfemaxToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVfemax(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcAC8BEvent.class)
  public void handle(UnAssignVfemaxFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVfemax(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVimaxToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcAC8BEvent.class)
  public void handle(AssignVimaxToExcAC8BEvent event) {
    LOGGER.info("handling AssignVimaxToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVimax(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcAC8BEvent.class)
  public void handle(UnAssignVimaxFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVimax(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignViminToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignViminToExcAC8BEvent.class)
  public void handle(AssignViminToExcAC8BEvent event) {
    LOGGER.info("handling AssignViminToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVimin(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignViminFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcAC8BEvent.class)
  public void handle(UnAssignViminFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignViminFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVimin(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVpidmaxToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVpidmaxToExcAC8BEvent.class)
  public void handle(AssignVpidmaxToExcAC8BEvent event) {
    LOGGER.info("handling AssignVpidmaxToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVpidmax(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVpidmaxFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVpidmaxFromExcAC8BEvent.class)
  public void handle(UnAssignVpidmaxFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVpidmaxFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVpidmax(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVpidminToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVpidminToExcAC8BEvent.class)
  public void handle(AssignVpidminToExcAC8BEvent event) {
    LOGGER.info("handling AssignVpidminToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVpidmin(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVpidminFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVpidminFromExcAC8BEvent.class)
  public void handle(UnAssignVpidminFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVpidminFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVpidmin(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcAC8BEvent.class)
  public void handle(AssignVrmaxToExcAC8BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVrmax(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcAC8BEvent.class)
  public void handle(UnAssignVrmaxFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVrmax(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVrminToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcAC8BEvent.class)
  public void handle(AssignVrminToExcAC8BEvent event) {
    LOGGER.info("handling AssignVrminToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVrmin(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcAC8BEvent.class)
  public void handle(UnAssignVrminFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVrmin(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event AssignVtmultToExcAC8BEvent
   */
  @EventHandler(payloadType = AssignVtmultToExcAC8BEvent.class)
  public void handle(AssignVtmultToExcAC8BEvent event) {
    LOGGER.info("handling AssignVtmultToExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC8B entity = assignVtmult(event.getExcAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /*
   * @param	event UnAssignVtmultFromExcAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVtmultFromExcAC8BEvent.class)
  public void handle(UnAssignVtmultFromExcAC8BEvent event) {
    LOGGER.info("handling UnAssignVtmultFromExcAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC8B entity = unAssignVtmult(event.getExcAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC8B(entity);
  }

  /**
   * Method to retrieve the ExcAC8B via an ExcAC8BPrimaryKey.
   *
   * @param id Long
   * @return ExcAC8B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC8B handle(FindExcAC8BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC8BId());
  }

  /**
   * Method to retrieve a collection of all ExcAC8Bs
   *
   * @param query FindAllExcAC8BQuery
   * @return List<ExcAC8B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC8B> handle(FindAllExcAC8BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC8B, but only if the id matches
   *
   * @param entity ExcAC8B
   */
  protected void emitFindExcAC8B(ExcAC8B entity) {
    LOGGER.info("handling emitFindExcAC8B");

    queryUpdateEmitter.emit(
        FindExcAC8BQuery.class,
        query -> query.getFilter().getExcAC8BId().equals(entity.getExcAC8BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC8B
   *
   * @param entity ExcAC8B
   */
  protected void emitFindAllExcAC8B(ExcAC8B entity) {
    LOGGER.info("handling emitFindAllExcAC8B");

    queryUpdateEmitter.emit(FindAllExcAC8BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC8BProjector.class.getName());
}
