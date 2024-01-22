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
 * Projector for ExcOEX3T as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcOEX3T are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcOEX3TAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excOEX3T")
@Component("excOEX3T-projector")
public class ExcOEX3TProjector extends ExcOEX3TEntityProjector {

  // core constructor
  public ExcOEX3TProjector(ExcOEX3TRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcOEX3TEvent
   */
  @EventHandler(payloadType = CreateExcOEX3TEvent.class)
  public void handle(CreateExcOEX3TEvent event) {
    LOGGER.info("handling CreateExcOEX3TEvent - " + event);
    ExcOEX3T entity = new ExcOEX3T();
    entity.setExcOEX3TId(event.getExcOEX3TId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UpdateExcOEX3TEvent
   */
  @EventHandler(payloadType = UpdateExcOEX3TEvent.class)
  public void handle(UpdateExcOEX3TEvent event) {
    LOGGER.info("handling UpdateExcOEX3TEvent - " + event);

    ExcOEX3T entity = new ExcOEX3T();
    entity.setExcOEX3TId(event.getExcOEX3TId());
    entity.setE1(event.getE1());
    entity.setE2(event.getE2());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setSee1(event.getSee1());
    entity.setSee2(event.getSee2());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event DeleteExcOEX3TEvent
   */
  @EventHandler(payloadType = DeleteExcOEX3TEvent.class)
  public void handle(DeleteExcOEX3TEvent event) {
    LOGGER.info("handling DeleteExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcOEX3T entity = delete(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignE1ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignE1ToExcOEX3TEvent.class)
  public void handle(AssignE1ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignE1ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignE1(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignE1FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignE1FromExcOEX3TEvent.class)
  public void handle(UnAssignE1FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignE1FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignE1(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignE2ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignE2ToExcOEX3TEvent.class)
  public void handle(AssignE2ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignE2ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignE2(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignE2FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignE2FromExcOEX3TEvent.class)
  public void handle(UnAssignE2FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignE2FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignE2(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignKaToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignKaToExcOEX3TEvent.class)
  public void handle(AssignKaToExcOEX3TEvent event) {
    LOGGER.info("handling AssignKaToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignKa(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignKaFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcOEX3TEvent.class)
  public void handle(UnAssignKaFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignKaFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignKa(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignKcToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignKcToExcOEX3TEvent.class)
  public void handle(AssignKcToExcOEX3TEvent event) {
    LOGGER.info("handling AssignKcToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignKc(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignKcFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcOEX3TEvent.class)
  public void handle(UnAssignKcFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignKcFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignKc(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignKdToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignKdToExcOEX3TEvent.class)
  public void handle(AssignKdToExcOEX3TEvent event) {
    LOGGER.info("handling AssignKdToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignKd(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignKdFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcOEX3TEvent.class)
  public void handle(UnAssignKdFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignKdFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignKd(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignKeToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignKeToExcOEX3TEvent.class)
  public void handle(AssignKeToExcOEX3TEvent event) {
    LOGGER.info("handling AssignKeToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignKe(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignKeFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcOEX3TEvent.class)
  public void handle(UnAssignKeFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignKeFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignKe(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignKfToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignKfToExcOEX3TEvent.class)
  public void handle(AssignKfToExcOEX3TEvent event) {
    LOGGER.info("handling AssignKfToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignKf(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignKfFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcOEX3TEvent.class)
  public void handle(UnAssignKfFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignKfFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignKf(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignSee1ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignSee1ToExcOEX3TEvent.class)
  public void handle(AssignSee1ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignSee1ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignSee1(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignSee1FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignSee1FromExcOEX3TEvent.class)
  public void handle(UnAssignSee1FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignSee1FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignSee1(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignSee2ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignSee2ToExcOEX3TEvent.class)
  public void handle(AssignSee2ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignSee2ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignSee2(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignSee2FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignSee2FromExcOEX3TEvent.class)
  public void handle(UnAssignSee2FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignSee2FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignSee2(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignT1ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignT1ToExcOEX3TEvent.class)
  public void handle(AssignT1ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignT1ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignT1(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignT1FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignT1FromExcOEX3TEvent.class)
  public void handle(UnAssignT1FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignT1FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignT1(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignT2ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignT2ToExcOEX3TEvent.class)
  public void handle(AssignT2ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignT2ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignT2(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignT2FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignT2FromExcOEX3TEvent.class)
  public void handle(UnAssignT2FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignT2FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignT2(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignT3ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignT3ToExcOEX3TEvent.class)
  public void handle(AssignT3ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignT3ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignT3(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignT3FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignT3FromExcOEX3TEvent.class)
  public void handle(UnAssignT3FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignT3FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignT3(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignT4ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignT4ToExcOEX3TEvent.class)
  public void handle(AssignT4ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignT4ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignT4(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignT4FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignT4FromExcOEX3TEvent.class)
  public void handle(UnAssignT4FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignT4FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignT4(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignT5ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignT5ToExcOEX3TEvent.class)
  public void handle(AssignT5ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignT5ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignT5(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignT5FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignT5FromExcOEX3TEvent.class)
  public void handle(UnAssignT5FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignT5FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignT5(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignT6ToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignT6ToExcOEX3TEvent.class)
  public void handle(AssignT6ToExcOEX3TEvent event) {
    LOGGER.info("handling AssignT6ToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignT6(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignT6FromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignT6FromExcOEX3TEvent.class)
  public void handle(UnAssignT6FromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignT6FromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignT6(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignTeToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignTeToExcOEX3TEvent.class)
  public void handle(AssignTeToExcOEX3TEvent event) {
    LOGGER.info("handling AssignTeToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignTe(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignTeFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcOEX3TEvent.class)
  public void handle(UnAssignTeFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignTeFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignTe(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignTfToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignTfToExcOEX3TEvent.class)
  public void handle(AssignTfToExcOEX3TEvent event) {
    LOGGER.info("handling AssignTfToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignTf(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignTfFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcOEX3TEvent.class)
  public void handle(UnAssignTfFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignTfFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignTf(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignVrmaxToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcOEX3TEvent.class)
  public void handle(AssignVrmaxToExcOEX3TEvent event) {
    LOGGER.info("handling AssignVrmaxToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignVrmax(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcOEX3TEvent.class)
  public void handle(UnAssignVrmaxFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignVrmax(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event AssignVrminToExcOEX3TEvent
   */
  @EventHandler(payloadType = AssignVrminToExcOEX3TEvent.class)
  public void handle(AssignVrminToExcOEX3TEvent event) {
    LOGGER.info("handling AssignVrminToExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcOEX3T entity = assignVrmin(event.getExcOEX3TId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcOEX3TEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcOEX3TEvent.class)
  public void handle(UnAssignVrminFromExcOEX3TEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcOEX3TEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcOEX3T entity = unAssignVrmin(event.getExcOEX3TId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcOEX3T(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcOEX3T(entity);
  }

  /**
   * Method to retrieve the ExcOEX3T via an ExcOEX3TPrimaryKey.
   *
   * @param id Long
   * @return ExcOEX3T
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcOEX3T handle(FindExcOEX3TQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcOEX3TId());
  }

  /**
   * Method to retrieve a collection of all ExcOEX3Ts
   *
   * @param query FindAllExcOEX3TQuery
   * @return List<ExcOEX3T>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcOEX3T> handle(FindAllExcOEX3TQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcOEX3T, but only if the id matches
   *
   * @param entity ExcOEX3T
   */
  protected void emitFindExcOEX3T(ExcOEX3T entity) {
    LOGGER.info("handling emitFindExcOEX3T");

    queryUpdateEmitter.emit(
        FindExcOEX3TQuery.class,
        query -> query.getFilter().getExcOEX3TId().equals(entity.getExcOEX3TId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcOEX3T
   *
   * @param entity ExcOEX3T
   */
  protected void emitFindAllExcOEX3T(ExcOEX3T entity) {
    LOGGER.info("handling emitFindAllExcOEX3T");

    queryUpdateEmitter.emit(FindAllExcOEX3TQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcOEX3TProjector.class.getName());
}
