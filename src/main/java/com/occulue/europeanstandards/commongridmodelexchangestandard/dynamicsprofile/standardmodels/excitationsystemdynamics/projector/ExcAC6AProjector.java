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
 * Projector for ExcAC6A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC6A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC6AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC6A")
@Component("excAC6A-projector")
public class ExcAC6AProjector extends ExcAC6AEntityProjector {

  // core constructor
  public ExcAC6AProjector(ExcAC6ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC6AEvent
   */
  @EventHandler(payloadType = CreateExcAC6AEvent.class)
  public void handle(CreateExcAC6AEvent event) {
    LOGGER.info("handling CreateExcAC6AEvent - " + event);
    ExcAC6A entity = new ExcAC6A();
    entity.setExcAC6AId(event.getExcAC6AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UpdateExcAC6AEvent
   */
  @EventHandler(payloadType = UpdateExcAC6AEvent.class)
  public void handle(UpdateExcAC6AEvent event) {
    LOGGER.info("handling UpdateExcAC6AEvent - " + event);

    ExcAC6A entity = new ExcAC6A();
    entity.setExcAC6AId(event.getExcAC6AId());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKh(event.getKh());
    entity.setKs(event.getKs());
    entity.setSeve1(event.getSeve1());
    entity.setSeve2(event.getSeve2());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTe(event.getTe());
    entity.setTh(event.getTh());
    entity.setTj(event.getTj());
    entity.setTk(event.getTk());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
    entity.setVe1(event.getVe1());
    entity.setVe2(event.getVe2());
    entity.setVfelim(event.getVfelim());
    entity.setVhmax(event.getVhmax());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event DeleteExcAC6AEvent
   */
  @EventHandler(payloadType = DeleteExcAC6AEvent.class)
  public void handle(DeleteExcAC6AEvent event) {
    LOGGER.info("handling DeleteExcAC6AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC6A entity = delete(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignKaToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC6AEvent.class)
  public void handle(AssignKaToExcAC6AEvent event) {
    LOGGER.info("handling AssignKaToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignKa(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC6AEvent.class)
  public void handle(UnAssignKaFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignKa(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignKcToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignKcToExcAC6AEvent.class)
  public void handle(AssignKcToExcAC6AEvent event) {
    LOGGER.info("handling AssignKcToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignKc(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcAC6AEvent.class)
  public void handle(UnAssignKcFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignKc(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignKdToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignKdToExcAC6AEvent.class)
  public void handle(AssignKdToExcAC6AEvent event) {
    LOGGER.info("handling AssignKdToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignKd(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcAC6AEvent.class)
  public void handle(UnAssignKdFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignKd(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignKeToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignKeToExcAC6AEvent.class)
  public void handle(AssignKeToExcAC6AEvent event) {
    LOGGER.info("handling AssignKeToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignKe(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcAC6AEvent.class)
  public void handle(UnAssignKeFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignKe(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignKhToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignKhToExcAC6AEvent.class)
  public void handle(AssignKhToExcAC6AEvent event) {
    LOGGER.info("handling AssignKhToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignKh(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignKhFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcAC6AEvent.class)
  public void handle(UnAssignKhFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignKhFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignKh(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignKsToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignKsToExcAC6AEvent.class)
  public void handle(AssignKsToExcAC6AEvent event) {
    LOGGER.info("handling AssignKsToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignKs(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcAC6AEvent.class)
  public void handle(UnAssignKsFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignKs(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcAC6AEvent.class)
  public void handle(AssignSeve1ToExcAC6AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignSeve1(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcAC6AEvent.class)
  public void handle(UnAssignSeve1FromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignSeve1(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcAC6AEvent.class)
  public void handle(AssignSeve2ToExcAC6AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignSeve2(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcAC6AEvent.class)
  public void handle(UnAssignSeve2FromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignSeve2(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignTaToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC6AEvent.class)
  public void handle(AssignTaToExcAC6AEvent event) {
    LOGGER.info("handling AssignTaToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTa(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC6AEvent.class)
  public void handle(UnAssignTaFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTa(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignTbToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignTbToExcAC6AEvent.class)
  public void handle(AssignTbToExcAC6AEvent event) {
    LOGGER.info("handling AssignTbToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTb(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcAC6AEvent.class)
  public void handle(UnAssignTbFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTb(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignTcToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignTcToExcAC6AEvent.class)
  public void handle(AssignTcToExcAC6AEvent event) {
    LOGGER.info("handling AssignTcToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTc(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcAC6AEvent.class)
  public void handle(UnAssignTcFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTc(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignTeToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignTeToExcAC6AEvent.class)
  public void handle(AssignTeToExcAC6AEvent event) {
    LOGGER.info("handling AssignTeToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTe(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcAC6AEvent.class)
  public void handle(UnAssignTeFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTe(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignThToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignThToExcAC6AEvent.class)
  public void handle(AssignThToExcAC6AEvent event) {
    LOGGER.info("handling AssignThToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTh(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignThFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignThFromExcAC6AEvent.class)
  public void handle(UnAssignThFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignThFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTh(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignTjToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignTjToExcAC6AEvent.class)
  public void handle(AssignTjToExcAC6AEvent event) {
    LOGGER.info("handling AssignTjToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTj(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignTjFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTjFromExcAC6AEvent.class)
  public void handle(UnAssignTjFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignTjFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTj(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignTkToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignTkToExcAC6AEvent.class)
  public void handle(AssignTkToExcAC6AEvent event) {
    LOGGER.info("handling AssignTkToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignTk(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignTkFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTkFromExcAC6AEvent.class)
  public void handle(UnAssignTkFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignTkFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignTk(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVamaxToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcAC6AEvent.class)
  public void handle(AssignVamaxToExcAC6AEvent event) {
    LOGGER.info("handling AssignVamaxToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVamax(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcAC6AEvent.class)
  public void handle(UnAssignVamaxFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVamax(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVaminToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcAC6AEvent.class)
  public void handle(AssignVaminToExcAC6AEvent event) {
    LOGGER.info("handling AssignVaminToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVamin(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcAC6AEvent.class)
  public void handle(UnAssignVaminFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVamin(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVe1ToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcAC6AEvent.class)
  public void handle(AssignVe1ToExcAC6AEvent event) {
    LOGGER.info("handling AssignVe1ToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVe1(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcAC6AEvent.class)
  public void handle(UnAssignVe1FromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVe1(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVe2ToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcAC6AEvent.class)
  public void handle(AssignVe2ToExcAC6AEvent event) {
    LOGGER.info("handling AssignVe2ToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVe2(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcAC6AEvent.class)
  public void handle(UnAssignVe2FromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVe2(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVfelimToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVfelimToExcAC6AEvent.class)
  public void handle(AssignVfelimToExcAC6AEvent event) {
    LOGGER.info("handling AssignVfelimToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVfelim(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVfelimFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVfelimFromExcAC6AEvent.class)
  public void handle(UnAssignVfelimFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVfelimFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVfelim(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVhmaxToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVhmaxToExcAC6AEvent.class)
  public void handle(AssignVhmaxToExcAC6AEvent event) {
    LOGGER.info("handling AssignVhmaxToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVhmax(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVhmaxFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVhmaxFromExcAC6AEvent.class)
  public void handle(UnAssignVhmaxFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVhmaxFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVhmax(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcAC6AEvent.class)
  public void handle(AssignVrmaxToExcAC6AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVrmax(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcAC6AEvent.class)
  public void handle(UnAssignVrmaxFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVrmax(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event AssignVrminToExcAC6AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcAC6AEvent.class)
  public void handle(AssignVrminToExcAC6AEvent event) {
    LOGGER.info("handling AssignVrminToExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC6A entity = assignVrmin(event.getExcAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcAC6AEvent.class)
  public void handle(UnAssignVrminFromExcAC6AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC6A entity = unAssignVrmin(event.getExcAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC6A(entity);
  }

  /**
   * Method to retrieve the ExcAC6A via an ExcAC6APrimaryKey.
   *
   * @param id Long
   * @return ExcAC6A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC6A handle(FindExcAC6AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC6AId());
  }

  /**
   * Method to retrieve a collection of all ExcAC6As
   *
   * @param query FindAllExcAC6AQuery
   * @return List<ExcAC6A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC6A> handle(FindAllExcAC6AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC6A, but only if the id matches
   *
   * @param entity ExcAC6A
   */
  protected void emitFindExcAC6A(ExcAC6A entity) {
    LOGGER.info("handling emitFindExcAC6A");

    queryUpdateEmitter.emit(
        FindExcAC6AQuery.class,
        query -> query.getFilter().getExcAC6AId().equals(entity.getExcAC6AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC6A
   *
   * @param entity ExcAC6A
   */
  protected void emitFindAllExcAC6A(ExcAC6A entity) {
    LOGGER.info("handling emitFindAllExcAC6A");

    queryUpdateEmitter.emit(FindAllExcAC6AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC6AProjector.class.getName());
}
