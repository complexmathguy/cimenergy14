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
 * Projector for ExcAC1A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC1A")
@Component("excAC1A-projector")
public class ExcAC1AProjector extends ExcAC1AEntityProjector {

  // core constructor
  public ExcAC1AProjector(ExcAC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC1AEvent
   */
  @EventHandler(payloadType = CreateExcAC1AEvent.class)
  public void handle(CreateExcAC1AEvent event) {
    LOGGER.info("handling CreateExcAC1AEvent - " + event);
    ExcAC1A entity = new ExcAC1A();
    entity.setExcAC1AId(event.getExcAC1AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UpdateExcAC1AEvent
   */
  @EventHandler(payloadType = UpdateExcAC1AEvent.class)
  public void handle(UpdateExcAC1AEvent event) {
    LOGGER.info("handling UpdateExcAC1AEvent - " + event);

    ExcAC1A entity = new ExcAC1A();
    entity.setExcAC1AId(event.getExcAC1AId());
    entity.setHvlvgates(event.getHvlvgates());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKf1(event.getKf1());
    entity.setKf2(event.getKf2());
    entity.setKs(event.getKs());
    entity.setSeve1(event.getSeve1());
    entity.setSeve2(event.getSeve2());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
    entity.setVe1(event.getVe1());
    entity.setVe2(event.getVe2());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event DeleteExcAC1AEvent
   */
  @EventHandler(payloadType = DeleteExcAC1AEvent.class)
  public void handle(DeleteExcAC1AEvent event) {
    LOGGER.info("handling DeleteExcAC1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC1A entity = delete(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignHvlvgatesToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignHvlvgatesToExcAC1AEvent.class)
  public void handle(AssignHvlvgatesToExcAC1AEvent event) {
    LOGGER.info("handling AssignHvlvgatesToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignHvlvgates(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignHvlvgatesFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignHvlvgatesFromExcAC1AEvent.class)
  public void handle(UnAssignHvlvgatesFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignHvlvgatesFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignHvlvgates(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKaToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC1AEvent.class)
  public void handle(AssignKaToExcAC1AEvent event) {
    LOGGER.info("handling AssignKaToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKa(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC1AEvent.class)
  public void handle(UnAssignKaFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKa(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKcToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKcToExcAC1AEvent.class)
  public void handle(AssignKcToExcAC1AEvent event) {
    LOGGER.info("handling AssignKcToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKc(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcAC1AEvent.class)
  public void handle(UnAssignKcFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKc(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKdToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKdToExcAC1AEvent.class)
  public void handle(AssignKdToExcAC1AEvent event) {
    LOGGER.info("handling AssignKdToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKd(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcAC1AEvent.class)
  public void handle(UnAssignKdFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKd(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKeToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKeToExcAC1AEvent.class)
  public void handle(AssignKeToExcAC1AEvent event) {
    LOGGER.info("handling AssignKeToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKe(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcAC1AEvent.class)
  public void handle(UnAssignKeFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKe(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKfToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKfToExcAC1AEvent.class)
  public void handle(AssignKfToExcAC1AEvent event) {
    LOGGER.info("handling AssignKfToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKf(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcAC1AEvent.class)
  public void handle(UnAssignKfFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKf(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKf1ToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKf1ToExcAC1AEvent.class)
  public void handle(AssignKf1ToExcAC1AEvent event) {
    LOGGER.info("handling AssignKf1ToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKf1(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKf1FromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKf1FromExcAC1AEvent.class)
  public void handle(UnAssignKf1FromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKf1FromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKf1(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKf2ToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKf2ToExcAC1AEvent.class)
  public void handle(AssignKf2ToExcAC1AEvent event) {
    LOGGER.info("handling AssignKf2ToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKf2(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKf2FromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKf2FromExcAC1AEvent.class)
  public void handle(UnAssignKf2FromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKf2FromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKf2(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignKsToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignKsToExcAC1AEvent.class)
  public void handle(AssignKsToExcAC1AEvent event) {
    LOGGER.info("handling AssignKsToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignKs(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcAC1AEvent.class)
  public void handle(UnAssignKsFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignKs(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcAC1AEvent.class)
  public void handle(AssignSeve1ToExcAC1AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignSeve1(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcAC1AEvent.class)
  public void handle(UnAssignSeve1FromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignSeve1(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcAC1AEvent.class)
  public void handle(AssignSeve2ToExcAC1AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignSeve2(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcAC1AEvent.class)
  public void handle(UnAssignSeve2FromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignSeve2(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignTaToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC1AEvent.class)
  public void handle(AssignTaToExcAC1AEvent event) {
    LOGGER.info("handling AssignTaToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignTa(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC1AEvent.class)
  public void handle(UnAssignTaFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignTa(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignTbToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignTbToExcAC1AEvent.class)
  public void handle(AssignTbToExcAC1AEvent event) {
    LOGGER.info("handling AssignTbToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignTb(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcAC1AEvent.class)
  public void handle(UnAssignTbFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignTb(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignTcToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignTcToExcAC1AEvent.class)
  public void handle(AssignTcToExcAC1AEvent event) {
    LOGGER.info("handling AssignTcToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignTc(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcAC1AEvent.class)
  public void handle(UnAssignTcFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignTc(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignTeToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignTeToExcAC1AEvent.class)
  public void handle(AssignTeToExcAC1AEvent event) {
    LOGGER.info("handling AssignTeToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignTe(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcAC1AEvent.class)
  public void handle(UnAssignTeFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignTe(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignTfToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignTfToExcAC1AEvent.class)
  public void handle(AssignTfToExcAC1AEvent event) {
    LOGGER.info("handling AssignTfToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignTf(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcAC1AEvent.class)
  public void handle(UnAssignTfFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignTf(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignVamaxToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcAC1AEvent.class)
  public void handle(AssignVamaxToExcAC1AEvent event) {
    LOGGER.info("handling AssignVamaxToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignVamax(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcAC1AEvent.class)
  public void handle(UnAssignVamaxFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignVamax(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignVaminToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcAC1AEvent.class)
  public void handle(AssignVaminToExcAC1AEvent event) {
    LOGGER.info("handling AssignVaminToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignVamin(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcAC1AEvent.class)
  public void handle(UnAssignVaminFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignVamin(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignVe1ToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcAC1AEvent.class)
  public void handle(AssignVe1ToExcAC1AEvent event) {
    LOGGER.info("handling AssignVe1ToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignVe1(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcAC1AEvent.class)
  public void handle(UnAssignVe1FromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignVe1(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignVe2ToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcAC1AEvent.class)
  public void handle(AssignVe2ToExcAC1AEvent event) {
    LOGGER.info("handling AssignVe2ToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignVe2(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcAC1AEvent.class)
  public void handle(UnAssignVe2FromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignVe2(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcAC1AEvent.class)
  public void handle(AssignVrmaxToExcAC1AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignVrmax(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcAC1AEvent.class)
  public void handle(UnAssignVrmaxFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignVrmax(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event AssignVrminToExcAC1AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcAC1AEvent.class)
  public void handle(AssignVrminToExcAC1AEvent event) {
    LOGGER.info("handling AssignVrminToExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC1A entity = assignVrmin(event.getExcAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcAC1AEvent.class)
  public void handle(UnAssignVrminFromExcAC1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC1A entity = unAssignVrmin(event.getExcAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC1A(entity);
  }

  /**
   * Method to retrieve the ExcAC1A via an ExcAC1APrimaryKey.
   *
   * @param id Long
   * @return ExcAC1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC1A handle(FindExcAC1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC1AId());
  }

  /**
   * Method to retrieve a collection of all ExcAC1As
   *
   * @param query FindAllExcAC1AQuery
   * @return List<ExcAC1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC1A> handle(FindAllExcAC1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC1A, but only if the id matches
   *
   * @param entity ExcAC1A
   */
  protected void emitFindExcAC1A(ExcAC1A entity) {
    LOGGER.info("handling emitFindExcAC1A");

    queryUpdateEmitter.emit(
        FindExcAC1AQuery.class,
        query -> query.getFilter().getExcAC1AId().equals(entity.getExcAC1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC1A
   *
   * @param entity ExcAC1A
   */
  protected void emitFindAllExcAC1A(ExcAC1A entity) {
    LOGGER.info("handling emitFindAllExcAC1A");

    queryUpdateEmitter.emit(FindAllExcAC1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC1AProjector.class.getName());
}
