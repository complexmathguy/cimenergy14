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
 * Projector for ExcIEEEAC3A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC3A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC3AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC3A")
@Component("excIEEEAC3A-projector")
public class ExcIEEEAC3AProjector extends ExcIEEEAC3AEntityProjector {

  // core constructor
  public ExcIEEEAC3AProjector(
      ExcIEEEAC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC3AEvent.class)
  public void handle(CreateExcIEEEAC3AEvent event) {
    LOGGER.info("handling CreateExcIEEEAC3AEvent - " + event);
    ExcIEEEAC3A entity = new ExcIEEEAC3A();
    entity.setExcIEEEAC3AId(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC3AEvent.class)
  public void handle(UpdateExcIEEEAC3AEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC3AEvent - " + event);

    ExcIEEEAC3A entity = new ExcIEEEAC3A();
    entity.setExcIEEEAC3AId(event.getExcIEEEAC3AId());
    entity.setEfdn(event.getEfdn());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKn(event.getKn());
    entity.setKr(event.getKr());
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
    entity.setVemin(event.getVemin());
    entity.setVfemax(event.getVfemax());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC3AEvent.class)
  public void handle(DeleteExcIEEEAC3AEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC3A entity = delete(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignEfdnToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignEfdnToExcIEEEAC3AEvent.class)
  public void handle(AssignEfdnToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignEfdnToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignEfdn(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignEfdnFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfdnFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignEfdnFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignEfdnFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignEfdn(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC3AEvent.class)
  public void handle(AssignKaToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKa(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKa(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC3AEvent.class)
  public void handle(AssignKcToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKc(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKc(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEAC3AEvent.class)
  public void handle(AssignKdToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKd(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKdFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKd(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC3AEvent.class)
  public void handle(AssignKeToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKe(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKe(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEAC3AEvent.class)
  public void handle(AssignKfToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKf(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKfFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKf(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKnToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKnToExcIEEEAC3AEvent.class)
  public void handle(AssignKnToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKnToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKn(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKnFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKnFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKnFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKnFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKn(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignKrToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignKrToExcIEEEAC3AEvent.class)
  public void handle(AssignKrToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignKrToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignKr(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignKrFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKrFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignKrFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignKrFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignKr(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcIEEEAC3AEvent.class)
  public void handle(AssignSeve1ToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignSeve1(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcIEEEAC3AEvent.class)
  public void handle(UnAssignSeve1FromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignSeve1(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcIEEEAC3AEvent.class)
  public void handle(AssignSeve2ToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignSeve2(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcIEEEAC3AEvent.class)
  public void handle(UnAssignSeve2FromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignSeve2(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC3AEvent.class)
  public void handle(AssignTaToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignTa(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignTa(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEAC3AEvent.class)
  public void handle(AssignTbToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignTb(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignTbFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignTb(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEAC3AEvent.class)
  public void handle(AssignTcToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignTc(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignTcFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignTc(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC3AEvent.class)
  public void handle(AssignTeToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignTe(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignTe(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEAC3AEvent.class)
  public void handle(AssignTfToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignTf(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignTfFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignTf(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEAC3AEvent.class)
  public void handle(AssignVamaxToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignVamax(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignVamax(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEAC3AEvent.class)
  public void handle(AssignVaminToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignVamin(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignVaminFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignVamin(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignVe1ToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcIEEEAC3AEvent.class)
  public void handle(AssignVe1ToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignVe1ToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignVe1(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcIEEEAC3AEvent.class)
  public void handle(UnAssignVe1FromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignVe1(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignVe2ToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcIEEEAC3AEvent.class)
  public void handle(AssignVe2ToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignVe2ToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignVe2(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcIEEEAC3AEvent.class)
  public void handle(UnAssignVe2FromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignVe2(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignVeminToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignVeminToExcIEEEAC3AEvent.class)
  public void handle(AssignVeminToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignVeminToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignVemin(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignVeminFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVeminFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignVeminFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignVeminFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignVemin(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event AssignVfemaxToExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcIEEEAC3AEvent.class)
  public void handle(AssignVfemaxToExcIEEEAC3AEvent event) {
    LOGGER.info("handling AssignVfemaxToExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC3A entity = assignVfemax(event.getExcIEEEAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcIEEEAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcIEEEAC3AEvent.class)
  public void handle(UnAssignVfemaxFromExcIEEEAC3AEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcIEEEAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC3A entity = unAssignVfemax(event.getExcIEEEAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC3A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC3A via an ExcIEEEAC3APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC3A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC3A handle(FindExcIEEEAC3AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC3AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC3As
   *
   * @param query FindAllExcIEEEAC3AQuery
   * @return List<ExcIEEEAC3A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC3A> handle(FindAllExcIEEEAC3AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC3A, but only if the id matches
   *
   * @param entity ExcIEEEAC3A
   */
  protected void emitFindExcIEEEAC3A(ExcIEEEAC3A entity) {
    LOGGER.info("handling emitFindExcIEEEAC3A");

    queryUpdateEmitter.emit(
        FindExcIEEEAC3AQuery.class,
        query -> query.getFilter().getExcIEEEAC3AId().equals(entity.getExcIEEEAC3AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC3A
   *
   * @param entity ExcIEEEAC3A
   */
  protected void emitFindAllExcIEEEAC3A(ExcIEEEAC3A entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC3A");

    queryUpdateEmitter.emit(FindAllExcIEEEAC3AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC3AProjector.class.getName());
}
