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
 * Projector for ExcIEEEAC8B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC8B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC8BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC8B")
@Component("excIEEEAC8B-projector")
public class ExcIEEEAC8BProjector extends ExcIEEEAC8BEntityProjector {

  // core constructor
  public ExcIEEEAC8BProjector(
      ExcIEEEAC8BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC8BEvent.class)
  public void handle(CreateExcIEEEAC8BEvent event) {
    LOGGER.info("handling CreateExcIEEEAC8BEvent - " + event);
    ExcIEEEAC8B entity = new ExcIEEEAC8B();
    entity.setExcIEEEAC8BId(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC8BEvent.class)
  public void handle(UpdateExcIEEEAC8BEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC8BEvent - " + event);

    ExcIEEEAC8B entity = new ExcIEEEAC8B();
    entity.setExcIEEEAC8BId(event.getExcIEEEAC8BId());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKdr(event.getKdr());
    entity.setKe(event.getKe());
    entity.setKir(event.getKir());
    entity.setKpr(event.getKpr());
    entity.setSeve1(event.getSeve1());
    entity.setSeve2(event.getSeve2());
    entity.setTa(event.getTa());
    entity.setTdr(event.getTdr());
    entity.setTe(event.getTe());
    entity.setVe1(event.getVe1());
    entity.setVe2(event.getVe2());
    entity.setVemin(event.getVemin());
    entity.setVfemax(event.getVfemax());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC8BEvent.class)
  public void handle(DeleteExcIEEEAC8BEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC8B entity = delete(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC8BEvent.class)
  public void handle(AssignKaToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKa(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKa(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC8BEvent.class)
  public void handle(AssignKcToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKc(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKc(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEAC8BEvent.class)
  public void handle(AssignKdToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKd(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKdFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKd(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKdrToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKdrToExcIEEEAC8BEvent.class)
  public void handle(AssignKdrToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKdrToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKdr(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKdrFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKdrFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKdrFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKdrFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKdr(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC8BEvent.class)
  public void handle(AssignKeToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKe(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKe(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKirToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKirToExcIEEEAC8BEvent.class)
  public void handle(AssignKirToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKirToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKir(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKirFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKirFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKirFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKirFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKir(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignKprToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignKprToExcIEEEAC8BEvent.class)
  public void handle(AssignKprToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignKprToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignKpr(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignKprFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignKprFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignKprFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignKprFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignKpr(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignSeve1ToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcIEEEAC8BEvent.class)
  public void handle(AssignSeve1ToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignSeve1ToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignSeve1(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcIEEEAC8BEvent.class)
  public void handle(UnAssignSeve1FromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignSeve1(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignSeve2ToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcIEEEAC8BEvent.class)
  public void handle(AssignSeve2ToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignSeve2ToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignSeve2(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcIEEEAC8BEvent.class)
  public void handle(UnAssignSeve2FromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignSeve2(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC8BEvent.class)
  public void handle(AssignTaToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignTa(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignTa(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignTdrToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignTdrToExcIEEEAC8BEvent.class)
  public void handle(AssignTdrToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignTdrToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignTdr(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignTdrFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTdrFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignTdrFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignTdrFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignTdr(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC8BEvent.class)
  public void handle(AssignTeToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignTe(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignTe(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignVe1ToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcIEEEAC8BEvent.class)
  public void handle(AssignVe1ToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignVe1ToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignVe1(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcIEEEAC8BEvent.class)
  public void handle(UnAssignVe1FromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignVe1(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignVe2ToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcIEEEAC8BEvent.class)
  public void handle(AssignVe2ToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignVe2ToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignVe2(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcIEEEAC8BEvent.class)
  public void handle(UnAssignVe2FromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignVe2(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignVeminToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignVeminToExcIEEEAC8BEvent.class)
  public void handle(AssignVeminToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignVeminToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignVemin(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignVeminFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVeminFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignVeminFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignVeminFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignVemin(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignVfemaxToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcIEEEAC8BEvent.class)
  public void handle(AssignVfemaxToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignVfemaxToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignVfemax(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignVfemaxFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignVfemax(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC8BEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignVrmax(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignVrmax(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC8BEvent.class)
  public void handle(AssignVrminToExcIEEEAC8BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC8B entity = assignVrmin(event.getExcIEEEAC8BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC8BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC8BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC8BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC8BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC8B entity = unAssignVrmin(event.getExcIEEEAC8BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC8B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC8B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC8B via an ExcIEEEAC8BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC8B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC8B handle(FindExcIEEEAC8BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC8BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC8Bs
   *
   * @param query FindAllExcIEEEAC8BQuery
   * @return List<ExcIEEEAC8B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC8B> handle(FindAllExcIEEEAC8BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC8B, but only if the id matches
   *
   * @param entity ExcIEEEAC8B
   */
  protected void emitFindExcIEEEAC8B(ExcIEEEAC8B entity) {
    LOGGER.info("handling emitFindExcIEEEAC8B");

    queryUpdateEmitter.emit(
        FindExcIEEEAC8BQuery.class,
        query -> query.getFilter().getExcIEEEAC8BId().equals(entity.getExcIEEEAC8BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC8B
   *
   * @param entity ExcIEEEAC8B
   */
  protected void emitFindAllExcIEEEAC8B(ExcIEEEAC8B entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC8B");

    queryUpdateEmitter.emit(FindAllExcIEEEAC8BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC8BProjector.class.getName());
}
