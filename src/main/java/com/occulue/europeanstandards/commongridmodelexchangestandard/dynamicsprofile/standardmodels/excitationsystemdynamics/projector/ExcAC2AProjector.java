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
 * Projector for ExcAC2A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC2A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC2AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC2A")
@Component("excAC2A-projector")
public class ExcAC2AProjector extends ExcAC2AEntityProjector {

  // core constructor
  public ExcAC2AProjector(ExcAC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC2AEvent
   */
  @EventHandler(payloadType = CreateExcAC2AEvent.class)
  public void handle(CreateExcAC2AEvent event) {
    LOGGER.info("handling CreateExcAC2AEvent - " + event);
    ExcAC2A entity = new ExcAC2A();
    entity.setExcAC2AId(event.getExcAC2AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UpdateExcAC2AEvent
   */
  @EventHandler(payloadType = UpdateExcAC2AEvent.class)
  public void handle(UpdateExcAC2AEvent event) {
    LOGGER.info("handling UpdateExcAC2AEvent - " + event);

    ExcAC2A entity = new ExcAC2A();
    entity.setExcAC2AId(event.getExcAC2AId());
    entity.setHvgate(event.getHvgate());
    entity.setKa(event.getKa());
    entity.setKb(event.getKb());
    entity.setKb1(event.getKb1());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKh(event.getKh());
    entity.setKl(event.getKl());
    entity.setKl1(event.getKl1());
    entity.setKs(event.getKs());
    entity.setLvgate(event.getLvgate());
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
    entity.setVlr(event.getVlr());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event DeleteExcAC2AEvent
   */
  @EventHandler(payloadType = DeleteExcAC2AEvent.class)
  public void handle(DeleteExcAC2AEvent event) {
    LOGGER.info("handling DeleteExcAC2AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC2A entity = delete(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignHvgateToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignHvgateToExcAC2AEvent.class)
  public void handle(AssignHvgateToExcAC2AEvent event) {
    LOGGER.info("handling AssignHvgateToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignHvgate(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignHvgateFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignHvgateFromExcAC2AEvent.class)
  public void handle(UnAssignHvgateFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignHvgateFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignHvgate(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKaToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC2AEvent.class)
  public void handle(AssignKaToExcAC2AEvent event) {
    LOGGER.info("handling AssignKaToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKa(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC2AEvent.class)
  public void handle(UnAssignKaFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKa(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKbToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKbToExcAC2AEvent.class)
  public void handle(AssignKbToExcAC2AEvent event) {
    LOGGER.info("handling AssignKbToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKb(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKbFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKbFromExcAC2AEvent.class)
  public void handle(UnAssignKbFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKbFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKb(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKb1ToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKb1ToExcAC2AEvent.class)
  public void handle(AssignKb1ToExcAC2AEvent event) {
    LOGGER.info("handling AssignKb1ToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKb1(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKb1FromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKb1FromExcAC2AEvent.class)
  public void handle(UnAssignKb1FromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKb1FromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKb1(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKcToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKcToExcAC2AEvent.class)
  public void handle(AssignKcToExcAC2AEvent event) {
    LOGGER.info("handling AssignKcToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKc(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcAC2AEvent.class)
  public void handle(UnAssignKcFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKc(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKdToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKdToExcAC2AEvent.class)
  public void handle(AssignKdToExcAC2AEvent event) {
    LOGGER.info("handling AssignKdToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKd(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcAC2AEvent.class)
  public void handle(UnAssignKdFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKd(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKeToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKeToExcAC2AEvent.class)
  public void handle(AssignKeToExcAC2AEvent event) {
    LOGGER.info("handling AssignKeToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKe(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcAC2AEvent.class)
  public void handle(UnAssignKeFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKe(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKfToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKfToExcAC2AEvent.class)
  public void handle(AssignKfToExcAC2AEvent event) {
    LOGGER.info("handling AssignKfToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKf(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcAC2AEvent.class)
  public void handle(UnAssignKfFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKf(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKhToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKhToExcAC2AEvent.class)
  public void handle(AssignKhToExcAC2AEvent event) {
    LOGGER.info("handling AssignKhToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKh(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKhFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcAC2AEvent.class)
  public void handle(UnAssignKhFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKhFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKh(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKlToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKlToExcAC2AEvent.class)
  public void handle(AssignKlToExcAC2AEvent event) {
    LOGGER.info("handling AssignKlToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKl(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKlFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKlFromExcAC2AEvent.class)
  public void handle(UnAssignKlFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKlFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKl(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKl1ToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKl1ToExcAC2AEvent.class)
  public void handle(AssignKl1ToExcAC2AEvent event) {
    LOGGER.info("handling AssignKl1ToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKl1(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKl1FromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKl1FromExcAC2AEvent.class)
  public void handle(UnAssignKl1FromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKl1FromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKl1(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignKsToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignKsToExcAC2AEvent.class)
  public void handle(AssignKsToExcAC2AEvent event) {
    LOGGER.info("handling AssignKsToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignKs(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcAC2AEvent.class)
  public void handle(UnAssignKsFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignKs(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignLvgateToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignLvgateToExcAC2AEvent.class)
  public void handle(AssignLvgateToExcAC2AEvent event) {
    LOGGER.info("handling AssignLvgateToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignLvgate(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignLvgateFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignLvgateFromExcAC2AEvent.class)
  public void handle(UnAssignLvgateFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignLvgateFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignLvgate(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcAC2AEvent.class)
  public void handle(AssignSeve1ToExcAC2AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignSeve1(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcAC2AEvent.class)
  public void handle(UnAssignSeve1FromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignSeve1(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcAC2AEvent.class)
  public void handle(AssignSeve2ToExcAC2AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignSeve2(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcAC2AEvent.class)
  public void handle(UnAssignSeve2FromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignSeve2(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignTaToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC2AEvent.class)
  public void handle(AssignTaToExcAC2AEvent event) {
    LOGGER.info("handling AssignTaToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignTa(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC2AEvent.class)
  public void handle(UnAssignTaFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignTa(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignTbToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignTbToExcAC2AEvent.class)
  public void handle(AssignTbToExcAC2AEvent event) {
    LOGGER.info("handling AssignTbToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignTb(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcAC2AEvent.class)
  public void handle(UnAssignTbFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignTb(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignTcToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignTcToExcAC2AEvent.class)
  public void handle(AssignTcToExcAC2AEvent event) {
    LOGGER.info("handling AssignTcToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignTc(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcAC2AEvent.class)
  public void handle(UnAssignTcFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignTc(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignTeToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignTeToExcAC2AEvent.class)
  public void handle(AssignTeToExcAC2AEvent event) {
    LOGGER.info("handling AssignTeToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignTe(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcAC2AEvent.class)
  public void handle(UnAssignTeFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignTe(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignTfToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignTfToExcAC2AEvent.class)
  public void handle(AssignTfToExcAC2AEvent event) {
    LOGGER.info("handling AssignTfToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignTf(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcAC2AEvent.class)
  public void handle(UnAssignTfFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignTf(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVamaxToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcAC2AEvent.class)
  public void handle(AssignVamaxToExcAC2AEvent event) {
    LOGGER.info("handling AssignVamaxToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVamax(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcAC2AEvent.class)
  public void handle(UnAssignVamaxFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVamax(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVaminToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcAC2AEvent.class)
  public void handle(AssignVaminToExcAC2AEvent event) {
    LOGGER.info("handling AssignVaminToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVamin(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcAC2AEvent.class)
  public void handle(UnAssignVaminFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVamin(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVe1ToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcAC2AEvent.class)
  public void handle(AssignVe1ToExcAC2AEvent event) {
    LOGGER.info("handling AssignVe1ToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVe1(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcAC2AEvent.class)
  public void handle(UnAssignVe1FromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVe1(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVe2ToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcAC2AEvent.class)
  public void handle(AssignVe2ToExcAC2AEvent event) {
    LOGGER.info("handling AssignVe2ToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVe2(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcAC2AEvent.class)
  public void handle(UnAssignVe2FromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVe2(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVfemaxToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcAC2AEvent.class)
  public void handle(AssignVfemaxToExcAC2AEvent event) {
    LOGGER.info("handling AssignVfemaxToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVfemax(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcAC2AEvent.class)
  public void handle(UnAssignVfemaxFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVfemax(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVlrToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVlrToExcAC2AEvent.class)
  public void handle(AssignVlrToExcAC2AEvent event) {
    LOGGER.info("handling AssignVlrToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVlr(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVlrFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVlrFromExcAC2AEvent.class)
  public void handle(UnAssignVlrFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVlrFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVlr(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcAC2AEvent.class)
  public void handle(AssignVrmaxToExcAC2AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVrmax(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcAC2AEvent.class)
  public void handle(UnAssignVrmaxFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVrmax(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event AssignVrminToExcAC2AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcAC2AEvent.class)
  public void handle(AssignVrminToExcAC2AEvent event) {
    LOGGER.info("handling AssignVrminToExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC2A entity = assignVrmin(event.getExcAC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcAC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcAC2AEvent.class)
  public void handle(UnAssignVrminFromExcAC2AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcAC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC2A entity = unAssignVrmin(event.getExcAC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC2A(entity);
  }

  /**
   * Method to retrieve the ExcAC2A via an ExcAC2APrimaryKey.
   *
   * @param id Long
   * @return ExcAC2A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC2A handle(FindExcAC2AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC2AId());
  }

  /**
   * Method to retrieve a collection of all ExcAC2As
   *
   * @param query FindAllExcAC2AQuery
   * @return List<ExcAC2A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC2A> handle(FindAllExcAC2AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC2A, but only if the id matches
   *
   * @param entity ExcAC2A
   */
  protected void emitFindExcAC2A(ExcAC2A entity) {
    LOGGER.info("handling emitFindExcAC2A");

    queryUpdateEmitter.emit(
        FindExcAC2AQuery.class,
        query -> query.getFilter().getExcAC2AId().equals(entity.getExcAC2AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC2A
   *
   * @param entity ExcAC2A
   */
  protected void emitFindAllExcAC2A(ExcAC2A entity) {
    LOGGER.info("handling emitFindAllExcAC2A");

    queryUpdateEmitter.emit(FindAllExcAC2AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC2AProjector.class.getName());
}
