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
 * Projector for ExcIEEEAC7B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC7B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC7BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC7B")
@Component("excIEEEAC7B-projector")
public class ExcIEEEAC7BProjector extends ExcIEEEAC7BEntityProjector {

  // core constructor
  public ExcIEEEAC7BProjector(
      ExcIEEEAC7BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC7BEvent.class)
  public void handle(CreateExcIEEEAC7BEvent event) {
    LOGGER.info("handling CreateExcIEEEAC7BEvent - " + event);
    ExcIEEEAC7B entity = new ExcIEEEAC7B();
    entity.setExcIEEEAC7BId(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC7BEvent.class)
  public void handle(UpdateExcIEEEAC7BEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC7BEvent - " + event);

    ExcIEEEAC7B entity = new ExcIEEEAC7B();
    entity.setExcIEEEAC7BId(event.getExcIEEEAC7BId());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKdr(event.getKdr());
    entity.setKe(event.getKe());
    entity.setKf1(event.getKf1());
    entity.setKf2(event.getKf2());
    entity.setKf3(event.getKf3());
    entity.setKia(event.getKia());
    entity.setKir(event.getKir());
    entity.setKl(event.getKl());
    entity.setKp(event.getKp());
    entity.setKpa(event.getKpa());
    entity.setKpr(event.getKpr());
    entity.setSeve1(event.getSeve1());
    entity.setSeve2(event.getSeve2());
    entity.setTdr(event.getTdr());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
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
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC7BEvent.class)
  public void handle(DeleteExcIEEEAC7BEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC7B entity = delete(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC7BEvent.class)
  public void handle(AssignKcToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKc(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKc(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEAC7BEvent.class)
  public void handle(AssignKdToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKd(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKdFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKd(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKdrToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKdrToExcIEEEAC7BEvent.class)
  public void handle(AssignKdrToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKdrToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKdr(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKdrFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKdrFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKdrFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKdrFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKdr(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC7BEvent.class)
  public void handle(AssignKeToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKe(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKe(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKf1ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKf1ToExcIEEEAC7BEvent.class)
  public void handle(AssignKf1ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKf1ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKf1(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKf1FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKf1FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKf1FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKf1FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKf1(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKf2ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKf2ToExcIEEEAC7BEvent.class)
  public void handle(AssignKf2ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKf2ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKf2(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKf2FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKf2FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKf2FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKf2FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKf2(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKf3ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKf3ToExcIEEEAC7BEvent.class)
  public void handle(AssignKf3ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKf3ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKf3(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKf3FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKf3FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKf3FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKf3FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKf3(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKiaToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKiaToExcIEEEAC7BEvent.class)
  public void handle(AssignKiaToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKiaToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKia(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKiaFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKiaFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKiaFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKiaFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKia(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKirToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKirToExcIEEEAC7BEvent.class)
  public void handle(AssignKirToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKirToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKir(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKirFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKirFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKirFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKirFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKir(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKlToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKlToExcIEEEAC7BEvent.class)
  public void handle(AssignKlToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKlToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKl(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKlFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKlFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKlFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKlFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKl(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKpToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKpToExcIEEEAC7BEvent.class)
  public void handle(AssignKpToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKpToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKp(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKpFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKpFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKpFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKp(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKpaToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKpaToExcIEEEAC7BEvent.class)
  public void handle(AssignKpaToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKpaToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKpa(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKpaFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKpaFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKpaFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKpaFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKpa(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignKprToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignKprToExcIEEEAC7BEvent.class)
  public void handle(AssignKprToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignKprToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignKpr(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignKprFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignKprFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignKprFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignKprFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignKpr(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignSeve1ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcIEEEAC7BEvent.class)
  public void handle(AssignSeve1ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignSeve1ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignSeve1(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignSeve1FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignSeve1(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignSeve2ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcIEEEAC7BEvent.class)
  public void handle(AssignSeve2ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignSeve2ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignSeve2(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignSeve2FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignSeve2(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignTdrToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignTdrToExcIEEEAC7BEvent.class)
  public void handle(AssignTdrToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignTdrToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignTdr(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignTdrFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignTdrFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignTdrFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignTdrFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignTdr(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC7BEvent.class)
  public void handle(AssignTeToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignTe(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignTe(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEAC7BEvent.class)
  public void handle(AssignTfToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignTf(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignTfFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignTf(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEAC7BEvent.class)
  public void handle(AssignVamaxToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVamax(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVamax(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEAC7BEvent.class)
  public void handle(AssignVaminToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVamin(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVaminFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVamin(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVe1ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcIEEEAC7BEvent.class)
  public void handle(AssignVe1ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVe1ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVe1(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVe1FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVe1(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVe2ToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcIEEEAC7BEvent.class)
  public void handle(AssignVe2ToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVe2ToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVe2(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVe2FromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVe2(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVeminToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVeminToExcIEEEAC7BEvent.class)
  public void handle(AssignVeminToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVeminToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVemin(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVeminFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVeminFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVeminFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVeminFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVemin(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVfemaxToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcIEEEAC7BEvent.class)
  public void handle(AssignVfemaxToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVfemaxToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVfemax(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVfemaxFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVfemax(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC7BEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVrmax(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVrmax(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC7BEvent.class)
  public void handle(AssignVrminToExcIEEEAC7BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC7B entity = assignVrmin(event.getExcIEEEAC7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC7BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC7BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC7BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC7B entity = unAssignVrmin(event.getExcIEEEAC7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC7B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC7B via an ExcIEEEAC7BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC7B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC7B handle(FindExcIEEEAC7BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC7BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC7Bs
   *
   * @param query FindAllExcIEEEAC7BQuery
   * @return List<ExcIEEEAC7B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC7B> handle(FindAllExcIEEEAC7BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC7B, but only if the id matches
   *
   * @param entity ExcIEEEAC7B
   */
  protected void emitFindExcIEEEAC7B(ExcIEEEAC7B entity) {
    LOGGER.info("handling emitFindExcIEEEAC7B");

    queryUpdateEmitter.emit(
        FindExcIEEEAC7BQuery.class,
        query -> query.getFilter().getExcIEEEAC7BId().equals(entity.getExcIEEEAC7BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC7B
   *
   * @param entity ExcIEEEAC7B
   */
  protected void emitFindAllExcIEEEAC7B(ExcIEEEAC7B entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC7B");

    queryUpdateEmitter.emit(FindAllExcIEEEAC7BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC7BProjector.class.getName());
}
