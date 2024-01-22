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
 * Projector for ExcAC3A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC3A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC3AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC3A")
@Component("excAC3A-projector")
public class ExcAC3AProjector extends ExcAC3AEntityProjector {

  // core constructor
  public ExcAC3AProjector(ExcAC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC3AEvent
   */
  @EventHandler(payloadType = CreateExcAC3AEvent.class)
  public void handle(CreateExcAC3AEvent event) {
    LOGGER.info("handling CreateExcAC3AEvent - " + event);
    ExcAC3A entity = new ExcAC3A();
    entity.setExcAC3AId(event.getExcAC3AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UpdateExcAC3AEvent
   */
  @EventHandler(payloadType = UpdateExcAC3AEvent.class)
  public void handle(UpdateExcAC3AEvent event) {
    LOGGER.info("handling UpdateExcAC3AEvent - " + event);

    ExcAC3A entity = new ExcAC3A();
    entity.setExcAC3AId(event.getExcAC3AId());
    entity.setEfdn(event.getEfdn());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKf1(event.getKf1());
    entity.setKf2(event.getKf2());
    entity.setKlv(event.getKlv());
    entity.setKn(event.getKn());
    entity.setKr(event.getKr());
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
    entity.setVemin(event.getVemin());
    entity.setVfemax(event.getVfemax());
    entity.setVlv(event.getVlv());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event DeleteExcAC3AEvent
   */
  @EventHandler(payloadType = DeleteExcAC3AEvent.class)
  public void handle(DeleteExcAC3AEvent event) {
    LOGGER.info("handling DeleteExcAC3AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC3A entity = delete(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignEfdnToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignEfdnToExcAC3AEvent.class)
  public void handle(AssignEfdnToExcAC3AEvent event) {
    LOGGER.info("handling AssignEfdnToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignEfdn(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignEfdnFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfdnFromExcAC3AEvent.class)
  public void handle(UnAssignEfdnFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignEfdnFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignEfdn(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKaToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC3AEvent.class)
  public void handle(AssignKaToExcAC3AEvent event) {
    LOGGER.info("handling AssignKaToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKa(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC3AEvent.class)
  public void handle(UnAssignKaFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKa(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKcToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKcToExcAC3AEvent.class)
  public void handle(AssignKcToExcAC3AEvent event) {
    LOGGER.info("handling AssignKcToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKc(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcAC3AEvent.class)
  public void handle(UnAssignKcFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKc(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKdToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKdToExcAC3AEvent.class)
  public void handle(AssignKdToExcAC3AEvent event) {
    LOGGER.info("handling AssignKdToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKd(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKdFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcAC3AEvent.class)
  public void handle(UnAssignKdFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKdFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKd(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKeToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKeToExcAC3AEvent.class)
  public void handle(AssignKeToExcAC3AEvent event) {
    LOGGER.info("handling AssignKeToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKe(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcAC3AEvent.class)
  public void handle(UnAssignKeFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKe(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKfToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKfToExcAC3AEvent.class)
  public void handle(AssignKfToExcAC3AEvent event) {
    LOGGER.info("handling AssignKfToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKf(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcAC3AEvent.class)
  public void handle(UnAssignKfFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKf(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKf1ToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKf1ToExcAC3AEvent.class)
  public void handle(AssignKf1ToExcAC3AEvent event) {
    LOGGER.info("handling AssignKf1ToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKf1(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKf1FromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKf1FromExcAC3AEvent.class)
  public void handle(UnAssignKf1FromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKf1FromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKf1(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKf2ToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKf2ToExcAC3AEvent.class)
  public void handle(AssignKf2ToExcAC3AEvent event) {
    LOGGER.info("handling AssignKf2ToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKf2(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKf2FromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKf2FromExcAC3AEvent.class)
  public void handle(UnAssignKf2FromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKf2FromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKf2(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKlvToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKlvToExcAC3AEvent.class)
  public void handle(AssignKlvToExcAC3AEvent event) {
    LOGGER.info("handling AssignKlvToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKlv(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKlvFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKlvFromExcAC3AEvent.class)
  public void handle(UnAssignKlvFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKlvFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKlv(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKnToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKnToExcAC3AEvent.class)
  public void handle(AssignKnToExcAC3AEvent event) {
    LOGGER.info("handling AssignKnToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKn(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKnFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKnFromExcAC3AEvent.class)
  public void handle(UnAssignKnFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKnFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKn(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKrToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKrToExcAC3AEvent.class)
  public void handle(AssignKrToExcAC3AEvent event) {
    LOGGER.info("handling AssignKrToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKr(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKrFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKrFromExcAC3AEvent.class)
  public void handle(UnAssignKrFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKrFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKr(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignKsToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignKsToExcAC3AEvent.class)
  public void handle(AssignKsToExcAC3AEvent event) {
    LOGGER.info("handling AssignKsToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignKs(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcAC3AEvent.class)
  public void handle(UnAssignKsFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignKs(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignSeve1ToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignSeve1ToExcAC3AEvent.class)
  public void handle(AssignSeve1ToExcAC3AEvent event) {
    LOGGER.info("handling AssignSeve1ToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignSeve1(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcAC3AEvent.class)
  public void handle(UnAssignSeve1FromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignSeve1FromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignSeve1(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignSeve2ToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignSeve2ToExcAC3AEvent.class)
  public void handle(AssignSeve2ToExcAC3AEvent event) {
    LOGGER.info("handling AssignSeve2ToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignSeve2(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcAC3AEvent.class)
  public void handle(UnAssignSeve2FromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignSeve2FromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignSeve2(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignTaToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC3AEvent.class)
  public void handle(AssignTaToExcAC3AEvent event) {
    LOGGER.info("handling AssignTaToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignTa(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC3AEvent.class)
  public void handle(UnAssignTaFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignTa(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignTbToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignTbToExcAC3AEvent.class)
  public void handle(AssignTbToExcAC3AEvent event) {
    LOGGER.info("handling AssignTbToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignTb(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcAC3AEvent.class)
  public void handle(UnAssignTbFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignTb(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignTcToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignTcToExcAC3AEvent.class)
  public void handle(AssignTcToExcAC3AEvent event) {
    LOGGER.info("handling AssignTcToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignTc(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcAC3AEvent.class)
  public void handle(UnAssignTcFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignTc(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignTeToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignTeToExcAC3AEvent.class)
  public void handle(AssignTeToExcAC3AEvent event) {
    LOGGER.info("handling AssignTeToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignTe(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcAC3AEvent.class)
  public void handle(UnAssignTeFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignTe(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignTfToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignTfToExcAC3AEvent.class)
  public void handle(AssignTfToExcAC3AEvent event) {
    LOGGER.info("handling AssignTfToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignTf(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcAC3AEvent.class)
  public void handle(UnAssignTfFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignTf(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVamaxToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcAC3AEvent.class)
  public void handle(AssignVamaxToExcAC3AEvent event) {
    LOGGER.info("handling AssignVamaxToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVamax(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcAC3AEvent.class)
  public void handle(UnAssignVamaxFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVamax(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVaminToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVaminToExcAC3AEvent.class)
  public void handle(AssignVaminToExcAC3AEvent event) {
    LOGGER.info("handling AssignVaminToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVamin(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcAC3AEvent.class)
  public void handle(UnAssignVaminFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVamin(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVe1ToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVe1ToExcAC3AEvent.class)
  public void handle(AssignVe1ToExcAC3AEvent event) {
    LOGGER.info("handling AssignVe1ToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVe1(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVe1FromExcAC3AEvent.class)
  public void handle(UnAssignVe1FromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVe1FromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVe1(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVe2ToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVe2ToExcAC3AEvent.class)
  public void handle(AssignVe2ToExcAC3AEvent event) {
    LOGGER.info("handling AssignVe2ToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVe2(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVe2FromExcAC3AEvent.class)
  public void handle(UnAssignVe2FromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVe2FromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVe2(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVeminToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVeminToExcAC3AEvent.class)
  public void handle(AssignVeminToExcAC3AEvent event) {
    LOGGER.info("handling AssignVeminToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVemin(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVeminFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVeminFromExcAC3AEvent.class)
  public void handle(UnAssignVeminFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVeminFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVemin(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVfemaxToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVfemaxToExcAC3AEvent.class)
  public void handle(AssignVfemaxToExcAC3AEvent event) {
    LOGGER.info("handling AssignVfemaxToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVfemax(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVfemaxFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVfemaxFromExcAC3AEvent.class)
  public void handle(UnAssignVfemaxFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVfemaxFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVfemax(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event AssignVlvToExcAC3AEvent
   */
  @EventHandler(payloadType = AssignVlvToExcAC3AEvent.class)
  public void handle(AssignVlvToExcAC3AEvent event) {
    LOGGER.info("handling AssignVlvToExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC3A entity = assignVlv(event.getExcAC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /*
   * @param	event UnAssignVlvFromExcAC3AEvent
   */
  @EventHandler(payloadType = UnAssignVlvFromExcAC3AEvent.class)
  public void handle(UnAssignVlvFromExcAC3AEvent event) {
    LOGGER.info("handling UnAssignVlvFromExcAC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC3A entity = unAssignVlv(event.getExcAC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC3A(entity);
  }

  /**
   * Method to retrieve the ExcAC3A via an ExcAC3APrimaryKey.
   *
   * @param id Long
   * @return ExcAC3A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC3A handle(FindExcAC3AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC3AId());
  }

  /**
   * Method to retrieve a collection of all ExcAC3As
   *
   * @param query FindAllExcAC3AQuery
   * @return List<ExcAC3A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC3A> handle(FindAllExcAC3AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC3A, but only if the id matches
   *
   * @param entity ExcAC3A
   */
  protected void emitFindExcAC3A(ExcAC3A entity) {
    LOGGER.info("handling emitFindExcAC3A");

    queryUpdateEmitter.emit(
        FindExcAC3AQuery.class,
        query -> query.getFilter().getExcAC3AId().equals(entity.getExcAC3AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC3A
   *
   * @param entity ExcAC3A
   */
  protected void emitFindAllExcAC3A(ExcAC3A entity) {
    LOGGER.info("handling emitFindAllExcAC3A");

    queryUpdateEmitter.emit(FindAllExcAC3AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC3AProjector.class.getName());
}
