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
 * Projector for ExcAC5A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC5A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC5AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC5A")
@Component("excAC5A-projector")
public class ExcAC5AProjector extends ExcAC5AEntityProjector {

  // core constructor
  public ExcAC5AProjector(ExcAC5ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC5AEvent
   */
  @EventHandler(payloadType = CreateExcAC5AEvent.class)
  public void handle(CreateExcAC5AEvent event) {
    LOGGER.info("handling CreateExcAC5AEvent - " + event);
    ExcAC5A entity = new ExcAC5A();
    entity.setExcAC5AId(event.getExcAC5AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UpdateExcAC5AEvent
   */
  @EventHandler(payloadType = UpdateExcAC5AEvent.class)
  public void handle(UpdateExcAC5AEvent event) {
    LOGGER.info("handling UpdateExcAC5AEvent - " + event);

    ExcAC5A entity = new ExcAC5A();
    entity.setExcAC5AId(event.getExcAC5AId());
    entity.setA(event.getA());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setKa(event.getKa());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKs(event.getKs());
    entity.setSeefd1(event.getSeefd1());
    entity.setSeefd2(event.getSeefd2());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTe(event.getTe());
    entity.setTf1(event.getTf1());
    entity.setTf2(event.getTf2());
    entity.setTf3(event.getTf3());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event DeleteExcAC5AEvent
   */
  @EventHandler(payloadType = DeleteExcAC5AEvent.class)
  public void handle(DeleteExcAC5AEvent event) {
    LOGGER.info("handling DeleteExcAC5AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC5A entity = delete(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignAToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignAToExcAC5AEvent.class)
  public void handle(AssignAToExcAC5AEvent event) {
    LOGGER.info("handling AssignAToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignA(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignAFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignAFromExcAC5AEvent.class)
  public void handle(UnAssignAFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignAFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignA(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcAC5AEvent.class)
  public void handle(AssignEfd1ToExcAC5AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignEfd1(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcAC5AEvent.class)
  public void handle(UnAssignEfd1FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignEfd1(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcAC5AEvent.class)
  public void handle(AssignEfd2ToExcAC5AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignEfd2(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcAC5AEvent.class)
  public void handle(UnAssignEfd2FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignEfd2(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignKaToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC5AEvent.class)
  public void handle(AssignKaToExcAC5AEvent event) {
    LOGGER.info("handling AssignKaToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignKa(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC5AEvent.class)
  public void handle(UnAssignKaFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignKa(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignKeToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignKeToExcAC5AEvent.class)
  public void handle(AssignKeToExcAC5AEvent event) {
    LOGGER.info("handling AssignKeToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignKe(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcAC5AEvent.class)
  public void handle(UnAssignKeFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignKe(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignKfToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignKfToExcAC5AEvent.class)
  public void handle(AssignKfToExcAC5AEvent event) {
    LOGGER.info("handling AssignKfToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignKf(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcAC5AEvent.class)
  public void handle(UnAssignKfFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignKf(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignKsToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignKsToExcAC5AEvent.class)
  public void handle(AssignKsToExcAC5AEvent event) {
    LOGGER.info("handling AssignKsToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignKs(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcAC5AEvent.class)
  public void handle(UnAssignKsFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignKs(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcAC5AEvent.class)
  public void handle(AssignSeefd1ToExcAC5AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignSeefd1(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcAC5AEvent.class)
  public void handle(UnAssignSeefd1FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignSeefd1(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcAC5AEvent.class)
  public void handle(AssignSeefd2ToExcAC5AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignSeefd2(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcAC5AEvent.class)
  public void handle(UnAssignSeefd2FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignSeefd2(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTaToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC5AEvent.class)
  public void handle(AssignTaToExcAC5AEvent event) {
    LOGGER.info("handling AssignTaToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTa(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC5AEvent.class)
  public void handle(UnAssignTaFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTa(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTbToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTbToExcAC5AEvent.class)
  public void handle(AssignTbToExcAC5AEvent event) {
    LOGGER.info("handling AssignTbToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTb(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcAC5AEvent.class)
  public void handle(UnAssignTbFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTb(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTcToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTcToExcAC5AEvent.class)
  public void handle(AssignTcToExcAC5AEvent event) {
    LOGGER.info("handling AssignTcToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTc(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcAC5AEvent.class)
  public void handle(UnAssignTcFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTc(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTeToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTeToExcAC5AEvent.class)
  public void handle(AssignTeToExcAC5AEvent event) {
    LOGGER.info("handling AssignTeToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTe(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcAC5AEvent.class)
  public void handle(UnAssignTeFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTe(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTf1ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTf1ToExcAC5AEvent.class)
  public void handle(AssignTf1ToExcAC5AEvent event) {
    LOGGER.info("handling AssignTf1ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTf1(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTf1FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTf1FromExcAC5AEvent.class)
  public void handle(UnAssignTf1FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTf1FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTf1(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTf2ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTf2ToExcAC5AEvent.class)
  public void handle(AssignTf2ToExcAC5AEvent event) {
    LOGGER.info("handling AssignTf2ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTf2(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTf2FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTf2FromExcAC5AEvent.class)
  public void handle(UnAssignTf2FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTf2FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTf2(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignTf3ToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignTf3ToExcAC5AEvent.class)
  public void handle(AssignTf3ToExcAC5AEvent event) {
    LOGGER.info("handling AssignTf3ToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignTf3(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignTf3FromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTf3FromExcAC5AEvent.class)
  public void handle(UnAssignTf3FromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignTf3FromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignTf3(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcAC5AEvent.class)
  public void handle(AssignVrmaxToExcAC5AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignVrmax(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcAC5AEvent.class)
  public void handle(UnAssignVrmaxFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignVrmax(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event AssignVrminToExcAC5AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcAC5AEvent.class)
  public void handle(AssignVrminToExcAC5AEvent event) {
    LOGGER.info("handling AssignVrminToExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC5A entity = assignVrmin(event.getExcAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcAC5AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcAC5AEvent.class)
  public void handle(UnAssignVrminFromExcAC5AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC5A entity = unAssignVrmin(event.getExcAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC5A(entity);
  }

  /**
   * Method to retrieve the ExcAC5A via an ExcAC5APrimaryKey.
   *
   * @param id Long
   * @return ExcAC5A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC5A handle(FindExcAC5AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC5AId());
  }

  /**
   * Method to retrieve a collection of all ExcAC5As
   *
   * @param query FindAllExcAC5AQuery
   * @return List<ExcAC5A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC5A> handle(FindAllExcAC5AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC5A, but only if the id matches
   *
   * @param entity ExcAC5A
   */
  protected void emitFindExcAC5A(ExcAC5A entity) {
    LOGGER.info("handling emitFindExcAC5A");

    queryUpdateEmitter.emit(
        FindExcAC5AQuery.class,
        query -> query.getFilter().getExcAC5AId().equals(entity.getExcAC5AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC5A
   *
   * @param entity ExcAC5A
   */
  protected void emitFindAllExcAC5A(ExcAC5A entity) {
    LOGGER.info("handling emitFindAllExcAC5A");

    queryUpdateEmitter.emit(FindAllExcAC5AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC5AProjector.class.getName());
}
