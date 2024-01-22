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
 * Projector for ExcIEEEAC1A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC1A")
@Component("excIEEEAC1A-projector")
public class ExcIEEEAC1AProjector extends ExcIEEEAC1AEntityProjector {

  // core constructor
  public ExcIEEEAC1AProjector(
      ExcIEEEAC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC1AEvent.class)
  public void handle(CreateExcIEEEAC1AEvent event) {
    LOGGER.info("handling CreateExcIEEEAC1AEvent - " + event);
    ExcIEEEAC1A entity = new ExcIEEEAC1A();
    entity.setExcIEEEAC1AId(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC1AEvent.class)
  public void handle(UpdateExcIEEEAC1AEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC1AEvent - " + event);

    ExcIEEEAC1A entity = new ExcIEEEAC1A();
    entity.setExcIEEEAC1AId(event.getExcIEEEAC1AId());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
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
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC1AEvent.class)
  public void handle(DeleteExcIEEEAC1AEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC1A entity = delete(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC1AEvent.class)
  public void handle(AssignKaToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignKa(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignKa(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC1AEvent.class)
  public void handle(AssignKcToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignKc(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignKc(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEAC1AEvent.class)
  public void handle(AssignKdToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignKd(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignKdFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignKd(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC1AEvent.class)
  public void handle(AssignKeToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignKe(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignKe(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEAC1AEvent.class)
  public void handle(AssignKfToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignKf(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignKfFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignKf(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcIEEEAC1AEvent.class)
  public void handle(AssignSeve1ToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignSeve1(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcIEEEAC1AEvent.class)
  public void handle(UnAssignSeve1FromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignSeve1(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcIEEEAC1AEvent.class)
  public void handle(AssignSeve2ToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignSeve2(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcIEEEAC1AEvent.class)
  public void handle(UnAssignSeve2FromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignSeve2(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC1AEvent.class)
  public void handle(AssignTaToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignTa(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignTa(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEAC1AEvent.class)
  public void handle(AssignTbToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignTb(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignTbFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignTb(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEAC1AEvent.class)
  public void handle(AssignTcToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignTc(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignTcFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignTc(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC1AEvent.class)
  public void handle(AssignTeToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignTe(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignTe(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEAC1AEvent.class)
  public void handle(AssignTfToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignTf(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignTfFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignTf(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEAC1AEvent.class)
  public void handle(AssignVamaxToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignVamax(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignVamax(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEAC1AEvent.class)
  public void handle(AssignVaminToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignVamin(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignVaminFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignVamin(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignVe1ToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcIEEEAC1AEvent.class)
  public void handle(AssignVe1ToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignVe1ToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignVe1(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcIEEEAC1AEvent.class)
  public void handle(UnAssignVe1FromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignVe1(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignVe2ToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcIEEEAC1AEvent.class)
  public void handle(AssignVe2ToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignVe2ToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignVe2(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcIEEEAC1AEvent.class)
  public void handle(UnAssignVe2FromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignVe2(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC1AEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignVrmax(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignVrmax(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC1AEvent.class)
  public void handle(AssignVrminToExcIEEEAC1AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC1A entity = assignVrmin(event.getExcIEEEAC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC1AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC1A entity = unAssignVrmin(event.getExcIEEEAC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC1A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC1A via an ExcIEEEAC1APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC1A handle(FindExcIEEEAC1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC1AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC1As
   *
   * @param query FindAllExcIEEEAC1AQuery
   * @return List<ExcIEEEAC1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC1A> handle(FindAllExcIEEEAC1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC1A, but only if the id matches
   *
   * @param entity ExcIEEEAC1A
   */
  protected void emitFindExcIEEEAC1A(ExcIEEEAC1A entity) {
    LOGGER.info("handling emitFindExcIEEEAC1A");

    queryUpdateEmitter.emit(
        FindExcIEEEAC1AQuery.class,
        query -> query.getFilter().getExcIEEEAC1AId().equals(entity.getExcIEEEAC1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC1A
   *
   * @param entity ExcIEEEAC1A
   */
  protected void emitFindAllExcIEEEAC1A(ExcIEEEAC1A entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC1A");

    queryUpdateEmitter.emit(FindAllExcIEEEAC1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC1AProjector.class.getName());
}
