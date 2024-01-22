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
 * Projector for ExcIEEEAC2A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC2A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC2AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC2A")
@Component("excIEEEAC2A-projector")
public class ExcIEEEAC2AProjector extends ExcIEEEAC2AEntityProjector {

  // core constructor
  public ExcIEEEAC2AProjector(
      ExcIEEEAC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC2AEvent.class)
  public void handle(CreateExcIEEEAC2AEvent event) {
    LOGGER.info("handling CreateExcIEEEAC2AEvent - " + event);
    ExcIEEEAC2A entity = new ExcIEEEAC2A();
    entity.setExcIEEEAC2AId(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC2AEvent.class)
  public void handle(UpdateExcIEEEAC2AEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC2AEvent - " + event);

    ExcIEEEAC2A entity = new ExcIEEEAC2A();
    entity.setExcIEEEAC2AId(event.getExcIEEEAC2AId());
    entity.setKa(event.getKa());
    entity.setKb(event.getKb());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKh(event.getKh());
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
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC2AEvent.class)
  public void handle(DeleteExcIEEEAC2AEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC2A entity = delete(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC2AEvent.class)
  public void handle(AssignKaToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKa(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKa(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKbToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKbToExcIEEEAC2AEvent.class)
  public void handle(AssignKbToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKbToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKb(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKbFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKbFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKbFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKbFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKb(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC2AEvent.class)
  public void handle(AssignKcToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKc(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKc(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEAC2AEvent.class)
  public void handle(AssignKdToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKd(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKdFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKd(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC2AEvent.class)
  public void handle(AssignKeToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKe(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKe(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEAC2AEvent.class)
  public void handle(AssignKfToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKf(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKfFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKf(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignKhToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignKhToExcIEEEAC2AEvent.class)
  public void handle(AssignKhToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignKhToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignKh(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignKhFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignKhFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignKhFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignKh(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcIEEEAC2AEvent.class)
  public void handle(AssignSeve1ToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignSeve1(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcIEEEAC2AEvent.class)
  public void handle(UnAssignSeve1FromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignSeve1(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcIEEEAC2AEvent.class)
  public void handle(AssignSeve2ToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignSeve2(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcIEEEAC2AEvent.class)
  public void handle(UnAssignSeve2FromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignSeve2(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC2AEvent.class)
  public void handle(AssignTaToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignTa(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignTa(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEAC2AEvent.class)
  public void handle(AssignTbToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignTb(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignTbFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignTb(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEAC2AEvent.class)
  public void handle(AssignTcToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignTc(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignTcFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignTc(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC2AEvent.class)
  public void handle(AssignTeToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignTe(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignTe(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEAC2AEvent.class)
  public void handle(AssignTfToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignTf(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignTfFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignTf(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEAC2AEvent.class)
  public void handle(AssignVamaxToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVamax(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVamax(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEAC2AEvent.class)
  public void handle(AssignVaminToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVamin(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVaminFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVamin(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVe1ToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcIEEEAC2AEvent.class)
  public void handle(AssignVe1ToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVe1ToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVe1(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVe1FromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVe1(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVe2ToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcIEEEAC2AEvent.class)
  public void handle(AssignVe2ToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVe2ToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVe2(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVe2FromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVe2(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVfemaxToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcIEEEAC2AEvent.class)
  public void handle(AssignVfemaxToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVfemaxToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVfemax(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVfemaxFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVfemax(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC2AEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVrmax(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVrmax(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC2AEvent.class)
  public void handle(AssignVrminToExcIEEEAC2AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC2A entity = assignVrmin(event.getExcIEEEAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC2AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC2AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC2A entity = unAssignVrmin(event.getExcIEEEAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC2A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC2A via an ExcIEEEAC2APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC2A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC2A handle(FindExcIEEEAC2AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC2AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC2As
   *
   * @param query FindAllExcIEEEAC2AQuery
   * @return List<ExcIEEEAC2A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC2A> handle(FindAllExcIEEEAC2AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC2A, but only if the id matches
   *
   * @param entity ExcIEEEAC2A
   */
  protected void emitFindExcIEEEAC2A(ExcIEEEAC2A entity) {
    LOGGER.info("handling emitFindExcIEEEAC2A");

    queryUpdateEmitter.emit(
        FindExcIEEEAC2AQuery.class,
        query -> query.getFilter().getExcIEEEAC2AId().equals(entity.getExcIEEEAC2AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC2A
   *
   * @param entity ExcIEEEAC2A
   */
  protected void emitFindAllExcIEEEAC2A(ExcIEEEAC2A entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC2A");

    queryUpdateEmitter.emit(FindAllExcIEEEAC2AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC2AProjector.class.getName());
}
