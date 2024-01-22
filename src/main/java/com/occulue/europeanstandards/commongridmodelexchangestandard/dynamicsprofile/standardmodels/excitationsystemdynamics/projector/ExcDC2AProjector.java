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
 * Projector for ExcDC2A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcDC2A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcDC2AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excDC2A")
@Component("excDC2A-projector")
public class ExcDC2AProjector extends ExcDC2AEntityProjector {

  // core constructor
  public ExcDC2AProjector(ExcDC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcDC2AEvent
   */
  @EventHandler(payloadType = CreateExcDC2AEvent.class)
  public void handle(CreateExcDC2AEvent event) {
    LOGGER.info("handling CreateExcDC2AEvent - " + event);
    ExcDC2A entity = new ExcDC2A();
    entity.setExcDC2AId(event.getExcDC2AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UpdateExcDC2AEvent
   */
  @EventHandler(payloadType = UpdateExcDC2AEvent.class)
  public void handle(UpdateExcDC2AEvent event) {
    LOGGER.info("handling UpdateExcDC2AEvent - " + event);

    ExcDC2A entity = new ExcDC2A();
    entity.setExcDC2AId(event.getExcDC2AId());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setExclim(event.getExclim());
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
    entity.setTf(event.getTf());
    entity.setTf1(event.getTf1());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setVtlim(event.getVtlim());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event DeleteExcDC2AEvent
   */
  @EventHandler(payloadType = DeleteExcDC2AEvent.class)
  public void handle(DeleteExcDC2AEvent event) {
    LOGGER.info("handling DeleteExcDC2AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcDC2A entity = delete(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcDC2AEvent.class)
  public void handle(AssignEfd1ToExcDC2AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignEfd1(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcDC2AEvent.class)
  public void handle(UnAssignEfd1FromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignEfd1(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcDC2AEvent.class)
  public void handle(AssignEfd2ToExcDC2AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignEfd2(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcDC2AEvent.class)
  public void handle(UnAssignEfd2FromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignEfd2(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignExclimToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignExclimToExcDC2AEvent.class)
  public void handle(AssignExclimToExcDC2AEvent event) {
    LOGGER.info("handling AssignExclimToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignExclim(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignExclimFromExcDC2AEvent.class)
  public void handle(UnAssignExclimFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignExclimFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignExclim(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignKaToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignKaToExcDC2AEvent.class)
  public void handle(AssignKaToExcDC2AEvent event) {
    LOGGER.info("handling AssignKaToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignKa(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcDC2AEvent.class)
  public void handle(UnAssignKaFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignKa(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignKeToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignKeToExcDC2AEvent.class)
  public void handle(AssignKeToExcDC2AEvent event) {
    LOGGER.info("handling AssignKeToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignKe(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcDC2AEvent.class)
  public void handle(UnAssignKeFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignKe(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignKfToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignKfToExcDC2AEvent.class)
  public void handle(AssignKfToExcDC2AEvent event) {
    LOGGER.info("handling AssignKfToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignKf(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcDC2AEvent.class)
  public void handle(UnAssignKfFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignKf(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignKsToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignKsToExcDC2AEvent.class)
  public void handle(AssignKsToExcDC2AEvent event) {
    LOGGER.info("handling AssignKsToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignKs(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcDC2AEvent.class)
  public void handle(UnAssignKsFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignKs(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcDC2AEvent.class)
  public void handle(AssignSeefd1ToExcDC2AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignSeefd1(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcDC2AEvent.class)
  public void handle(UnAssignSeefd1FromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignSeefd1(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcDC2AEvent.class)
  public void handle(AssignSeefd2ToExcDC2AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignSeefd2(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcDC2AEvent.class)
  public void handle(UnAssignSeefd2FromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignSeefd2(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignTaToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignTaToExcDC2AEvent.class)
  public void handle(AssignTaToExcDC2AEvent event) {
    LOGGER.info("handling AssignTaToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignTa(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcDC2AEvent.class)
  public void handle(UnAssignTaFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignTa(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignTbToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignTbToExcDC2AEvent.class)
  public void handle(AssignTbToExcDC2AEvent event) {
    LOGGER.info("handling AssignTbToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignTb(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcDC2AEvent.class)
  public void handle(UnAssignTbFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignTb(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignTcToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignTcToExcDC2AEvent.class)
  public void handle(AssignTcToExcDC2AEvent event) {
    LOGGER.info("handling AssignTcToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignTc(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcDC2AEvent.class)
  public void handle(UnAssignTcFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignTc(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignTeToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignTeToExcDC2AEvent.class)
  public void handle(AssignTeToExcDC2AEvent event) {
    LOGGER.info("handling AssignTeToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignTe(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcDC2AEvent.class)
  public void handle(UnAssignTeFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignTe(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignTfToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignTfToExcDC2AEvent.class)
  public void handle(AssignTfToExcDC2AEvent event) {
    LOGGER.info("handling AssignTfToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignTf(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcDC2AEvent.class)
  public void handle(UnAssignTfFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignTf(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignTf1ToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignTf1ToExcDC2AEvent.class)
  public void handle(AssignTf1ToExcDC2AEvent event) {
    LOGGER.info("handling AssignTf1ToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignTf1(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignTf1FromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTf1FromExcDC2AEvent.class)
  public void handle(UnAssignTf1FromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignTf1FromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignTf1(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcDC2AEvent.class)
  public void handle(AssignVrmaxToExcDC2AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignVrmax(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcDC2AEvent.class)
  public void handle(UnAssignVrmaxFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignVrmax(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignVrminToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcDC2AEvent.class)
  public void handle(AssignVrminToExcDC2AEvent event) {
    LOGGER.info("handling AssignVrminToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignVrmin(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcDC2AEvent.class)
  public void handle(UnAssignVrminFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignVrmin(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event AssignVtlimToExcDC2AEvent
   */
  @EventHandler(payloadType = AssignVtlimToExcDC2AEvent.class)
  public void handle(AssignVtlimToExcDC2AEvent event) {
    LOGGER.info("handling AssignVtlimToExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC2A entity = assignVtlim(event.getExcDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /*
   * @param	event UnAssignVtlimFromExcDC2AEvent
   */
  @EventHandler(payloadType = UnAssignVtlimFromExcDC2AEvent.class)
  public void handle(UnAssignVtlimFromExcDC2AEvent event) {
    LOGGER.info("handling UnAssignVtlimFromExcDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC2A entity = unAssignVtlim(event.getExcDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC2A(entity);
  }

  /**
   * Method to retrieve the ExcDC2A via an ExcDC2APrimaryKey.
   *
   * @param id Long
   * @return ExcDC2A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcDC2A handle(FindExcDC2AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcDC2AId());
  }

  /**
   * Method to retrieve a collection of all ExcDC2As
   *
   * @param query FindAllExcDC2AQuery
   * @return List<ExcDC2A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcDC2A> handle(FindAllExcDC2AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcDC2A, but only if the id matches
   *
   * @param entity ExcDC2A
   */
  protected void emitFindExcDC2A(ExcDC2A entity) {
    LOGGER.info("handling emitFindExcDC2A");

    queryUpdateEmitter.emit(
        FindExcDC2AQuery.class,
        query -> query.getFilter().getExcDC2AId().equals(entity.getExcDC2AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcDC2A
   *
   * @param entity ExcDC2A
   */
  protected void emitFindAllExcDC2A(ExcDC2A entity) {
    LOGGER.info("handling emitFindAllExcDC2A");

    queryUpdateEmitter.emit(FindAllExcDC2AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcDC2AProjector.class.getName());
}
