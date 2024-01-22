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
 * Projector for ExcAVR7 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAVR7 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAVR7Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAVR7")
@Component("excAVR7-projector")
public class ExcAVR7Projector extends ExcAVR7EntityProjector {

  // core constructor
  public ExcAVR7Projector(ExcAVR7Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAVR7Event
   */
  @EventHandler(payloadType = CreateExcAVR7Event.class)
  public void handle(CreateExcAVR7Event event) {
    LOGGER.info("handling CreateExcAVR7Event - " + event);
    ExcAVR7 entity = new ExcAVR7();
    entity.setExcAVR7Id(event.getExcAVR7Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UpdateExcAVR7Event
   */
  @EventHandler(payloadType = UpdateExcAVR7Event.class)
  public void handle(UpdateExcAVR7Event event) {
    LOGGER.info("handling UpdateExcAVR7Event - " + event);

    ExcAVR7 entity = new ExcAVR7();
    entity.setExcAVR7Id(event.getExcAVR7Id());
    entity.setA1(event.getA1());
    entity.setA2(event.getA2());
    entity.setA3(event.getA3());
    entity.setA4(event.getA4());
    entity.setA5(event.getA5());
    entity.setA6(event.getA6());
    entity.setK1(event.getK1());
    entity.setK3(event.getK3());
    entity.setK5(event.getK5());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setVmax1(event.getVmax1());
    entity.setVmax3(event.getVmax3());
    entity.setVmax5(event.getVmax5());
    entity.setVmin1(event.getVmin1());
    entity.setVmin3(event.getVmin3());
    entity.setVmin5(event.getVmin5());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event DeleteExcAVR7Event
   */
  @EventHandler(payloadType = DeleteExcAVR7Event.class)
  public void handle(DeleteExcAVR7Event event) {
    LOGGER.info("handling DeleteExcAVR7Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAVR7 entity = delete(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignA1ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignA1ToExcAVR7Event.class)
  public void handle(AssignA1ToExcAVR7Event event) {
    LOGGER.info("handling AssignA1ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignA1(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignA1FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignA1FromExcAVR7Event.class)
  public void handle(UnAssignA1FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignA1FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignA1(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignA2ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignA2ToExcAVR7Event.class)
  public void handle(AssignA2ToExcAVR7Event event) {
    LOGGER.info("handling AssignA2ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignA2(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignA2FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignA2FromExcAVR7Event.class)
  public void handle(UnAssignA2FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignA2FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignA2(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignA3ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignA3ToExcAVR7Event.class)
  public void handle(AssignA3ToExcAVR7Event event) {
    LOGGER.info("handling AssignA3ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignA3(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignA3FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignA3FromExcAVR7Event.class)
  public void handle(UnAssignA3FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignA3FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignA3(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignA4ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignA4ToExcAVR7Event.class)
  public void handle(AssignA4ToExcAVR7Event event) {
    LOGGER.info("handling AssignA4ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignA4(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignA4FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignA4FromExcAVR7Event.class)
  public void handle(UnAssignA4FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignA4FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignA4(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignA5ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignA5ToExcAVR7Event.class)
  public void handle(AssignA5ToExcAVR7Event event) {
    LOGGER.info("handling AssignA5ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignA5(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignA5FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignA5FromExcAVR7Event.class)
  public void handle(UnAssignA5FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignA5FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignA5(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignA6ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignA6ToExcAVR7Event.class)
  public void handle(AssignA6ToExcAVR7Event event) {
    LOGGER.info("handling AssignA6ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignA6(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignA6FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignA6FromExcAVR7Event.class)
  public void handle(UnAssignA6FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignA6FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignA6(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignK1ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignK1ToExcAVR7Event.class)
  public void handle(AssignK1ToExcAVR7Event event) {
    LOGGER.info("handling AssignK1ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignK1(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignK1FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignK1FromExcAVR7Event.class)
  public void handle(UnAssignK1FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignK1FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignK1(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignK3ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignK3ToExcAVR7Event.class)
  public void handle(AssignK3ToExcAVR7Event event) {
    LOGGER.info("handling AssignK3ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignK3(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignK3FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignK3FromExcAVR7Event.class)
  public void handle(UnAssignK3FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignK3FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignK3(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignK5ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignK5ToExcAVR7Event.class)
  public void handle(AssignK5ToExcAVR7Event event) {
    LOGGER.info("handling AssignK5ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignK5(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignK5FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignK5FromExcAVR7Event.class)
  public void handle(UnAssignK5FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignK5FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignK5(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignT1ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignT1ToExcAVR7Event.class)
  public void handle(AssignT1ToExcAVR7Event event) {
    LOGGER.info("handling AssignT1ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignT1(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignT1FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignT1FromExcAVR7Event.class)
  public void handle(UnAssignT1FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignT1FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignT1(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignT2ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignT2ToExcAVR7Event.class)
  public void handle(AssignT2ToExcAVR7Event event) {
    LOGGER.info("handling AssignT2ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignT2(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignT2FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignT2FromExcAVR7Event.class)
  public void handle(UnAssignT2FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignT2FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignT2(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignT3ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignT3ToExcAVR7Event.class)
  public void handle(AssignT3ToExcAVR7Event event) {
    LOGGER.info("handling AssignT3ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignT3(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignT3FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignT3FromExcAVR7Event.class)
  public void handle(UnAssignT3FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignT3FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignT3(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignT4ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignT4ToExcAVR7Event.class)
  public void handle(AssignT4ToExcAVR7Event event) {
    LOGGER.info("handling AssignT4ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignT4(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignT4FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignT4FromExcAVR7Event.class)
  public void handle(UnAssignT4FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignT4FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignT4(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignT5ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignT5ToExcAVR7Event.class)
  public void handle(AssignT5ToExcAVR7Event event) {
    LOGGER.info("handling AssignT5ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignT5(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignT5FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignT5FromExcAVR7Event.class)
  public void handle(UnAssignT5FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignT5FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignT5(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignT6ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignT6ToExcAVR7Event.class)
  public void handle(AssignT6ToExcAVR7Event event) {
    LOGGER.info("handling AssignT6ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignT6(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignT6FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignT6FromExcAVR7Event.class)
  public void handle(UnAssignT6FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignT6FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignT6(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignVmax1ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignVmax1ToExcAVR7Event.class)
  public void handle(AssignVmax1ToExcAVR7Event event) {
    LOGGER.info("handling AssignVmax1ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignVmax1(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignVmax1FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignVmax1FromExcAVR7Event.class)
  public void handle(UnAssignVmax1FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignVmax1FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignVmax1(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignVmax3ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignVmax3ToExcAVR7Event.class)
  public void handle(AssignVmax3ToExcAVR7Event event) {
    LOGGER.info("handling AssignVmax3ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignVmax3(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignVmax3FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignVmax3FromExcAVR7Event.class)
  public void handle(UnAssignVmax3FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignVmax3FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignVmax3(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignVmax5ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignVmax5ToExcAVR7Event.class)
  public void handle(AssignVmax5ToExcAVR7Event event) {
    LOGGER.info("handling AssignVmax5ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignVmax5(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignVmax5FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignVmax5FromExcAVR7Event.class)
  public void handle(UnAssignVmax5FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignVmax5FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignVmax5(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignVmin1ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignVmin1ToExcAVR7Event.class)
  public void handle(AssignVmin1ToExcAVR7Event event) {
    LOGGER.info("handling AssignVmin1ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignVmin1(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignVmin1FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignVmin1FromExcAVR7Event.class)
  public void handle(UnAssignVmin1FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignVmin1FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignVmin1(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignVmin3ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignVmin3ToExcAVR7Event.class)
  public void handle(AssignVmin3ToExcAVR7Event event) {
    LOGGER.info("handling AssignVmin3ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignVmin3(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignVmin3FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignVmin3FromExcAVR7Event.class)
  public void handle(UnAssignVmin3FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignVmin3FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignVmin3(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event AssignVmin5ToExcAVR7Event
   */
  @EventHandler(payloadType = AssignVmin5ToExcAVR7Event.class)
  public void handle(AssignVmin5ToExcAVR7Event event) {
    LOGGER.info("handling AssignVmin5ToExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR7 entity = assignVmin5(event.getExcAVR7Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /*
   * @param	event UnAssignVmin5FromExcAVR7Event
   */
  @EventHandler(payloadType = UnAssignVmin5FromExcAVR7Event.class)
  public void handle(UnAssignVmin5FromExcAVR7Event event) {
    LOGGER.info("handling UnAssignVmin5FromExcAVR7Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR7 entity = unAssignVmin5(event.getExcAVR7Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR7(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR7(entity);
  }

  /**
   * Method to retrieve the ExcAVR7 via an ExcAVR7PrimaryKey.
   *
   * @param id Long
   * @return ExcAVR7
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAVR7 handle(FindExcAVR7Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAVR7Id());
  }

  /**
   * Method to retrieve a collection of all ExcAVR7s
   *
   * @param query FindAllExcAVR7Query
   * @return List<ExcAVR7>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAVR7> handle(FindAllExcAVR7Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAVR7, but only if the id matches
   *
   * @param entity ExcAVR7
   */
  protected void emitFindExcAVR7(ExcAVR7 entity) {
    LOGGER.info("handling emitFindExcAVR7");

    queryUpdateEmitter.emit(
        FindExcAVR7Query.class,
        query -> query.getFilter().getExcAVR7Id().equals(entity.getExcAVR7Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAVR7
   *
   * @param entity ExcAVR7
   */
  protected void emitFindAllExcAVR7(ExcAVR7 entity) {
    LOGGER.info("handling emitFindAllExcAVR7");

    queryUpdateEmitter.emit(FindAllExcAVR7Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR7Projector.class.getName());
}
