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
 * Projector for ExcIEEEAC6A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC6A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC6AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC6A")
@Component("excIEEEAC6A-projector")
public class ExcIEEEAC6AProjector extends ExcIEEEAC6AEntityProjector {

  // core constructor
  public ExcIEEEAC6AProjector(
      ExcIEEEAC6ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC6AEvent.class)
  public void handle(CreateExcIEEEAC6AEvent event) {
    LOGGER.info("handling CreateExcIEEEAC6AEvent - " + event);
    ExcIEEEAC6A entity = new ExcIEEEAC6A();
    entity.setExcIEEEAC6AId(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC6AEvent.class)
  public void handle(UpdateExcIEEEAC6AEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC6AEvent - " + event);

    ExcIEEEAC6A entity = new ExcIEEEAC6A();
    entity.setExcIEEEAC6AId(event.getExcIEEEAC6AId());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKh(event.getKh());
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
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC6AEvent.class)
  public void handle(DeleteExcIEEEAC6AEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC6A entity = delete(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC6AEvent.class)
  public void handle(AssignKaToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignKa(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignKa(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC6AEvent.class)
  public void handle(AssignKcToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignKc(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignKc(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEAC6AEvent.class)
  public void handle(AssignKdToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignKd(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignKdFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignKd(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC6AEvent.class)
  public void handle(AssignKeToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignKe(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignKe(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignKhToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignKhToExcIEEEAC6AEvent.class)
  public void handle(AssignKhToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignKhToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignKh(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignKhFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignKhFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignKhFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignKh(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcIEEEAC6AEvent.class)
  public void handle(AssignSeve1ToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignSeve1(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcIEEEAC6AEvent.class)
  public void handle(UnAssignSeve1FromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignSeve1(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcIEEEAC6AEvent.class)
  public void handle(AssignSeve2ToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignSeve2(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcIEEEAC6AEvent.class)
  public void handle(UnAssignSeve2FromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignSeve2(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC6AEvent.class)
  public void handle(AssignTaToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTa(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTa(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEAC6AEvent.class)
  public void handle(AssignTbToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTb(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignTbFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTb(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEAC6AEvent.class)
  public void handle(AssignTcToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTc(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignTcFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTc(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC6AEvent.class)
  public void handle(AssignTeToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTe(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTe(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignThToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignThToExcIEEEAC6AEvent.class)
  public void handle(AssignThToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignThToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTh(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignThFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignThFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignThFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignThFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTh(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignTjToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignTjToExcIEEEAC6AEvent.class)
  public void handle(AssignTjToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignTjToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTj(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignTjFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTjFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignTjFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignTjFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTj(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignTkToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignTkToExcIEEEAC6AEvent.class)
  public void handle(AssignTkToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignTkToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignTk(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignTkFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignTkFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignTkFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignTkFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignTk(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEAC6AEvent.class)
  public void handle(AssignVamaxToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVamax(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVamax(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEAC6AEvent.class)
  public void handle(AssignVaminToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVamin(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVaminFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVamin(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVe1ToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcIEEEAC6AEvent.class)
  public void handle(AssignVe1ToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVe1ToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVe1(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVe1FromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVe1(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVe2ToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcIEEEAC6AEvent.class)
  public void handle(AssignVe2ToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVe2ToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVe2(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVe2FromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVe2(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVfelimToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVfelimToExcIEEEAC6AEvent.class)
  public void handle(AssignVfelimToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVfelimToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVfelim(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVfelimFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVfelimFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVfelimFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVfelimFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVfelim(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVhmaxToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVhmaxToExcIEEEAC6AEvent.class)
  public void handle(AssignVhmaxToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVhmaxToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVhmax(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVhmaxFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVhmaxFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVhmaxFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVhmaxFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVhmax(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC6AEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVrmax(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVrmax(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC6AEvent.class)
  public void handle(AssignVrminToExcIEEEAC6AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC6A entity = assignVrmin(event.getExcIEEEAC6AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC6AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC6AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC6AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC6AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC6A entity = unAssignVrmin(event.getExcIEEEAC6AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC6A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC6A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC6A via an ExcIEEEAC6APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC6A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC6A handle(FindExcIEEEAC6AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC6AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC6As
   *
   * @param query FindAllExcIEEEAC6AQuery
   * @return List<ExcIEEEAC6A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC6A> handle(FindAllExcIEEEAC6AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC6A, but only if the id matches
   *
   * @param entity ExcIEEEAC6A
   */
  protected void emitFindExcIEEEAC6A(ExcIEEEAC6A entity) {
    LOGGER.info("handling emitFindExcIEEEAC6A");

    queryUpdateEmitter.emit(
        FindExcIEEEAC6AQuery.class,
        query -> query.getFilter().getExcIEEEAC6AId().equals(entity.getExcIEEEAC6AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC6A
   *
   * @param entity ExcIEEEAC6A
   */
  protected void emitFindAllExcIEEEAC6A(ExcIEEEAC6A entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC6A");

    queryUpdateEmitter.emit(FindAllExcIEEEAC6AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC6AProjector.class.getName());
}
