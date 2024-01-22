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
 * Projector for ExcDC1A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcDC1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcDC1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excDC1A")
@Component("excDC1A-projector")
public class ExcDC1AProjector extends ExcDC1AEntityProjector {

  // core constructor
  public ExcDC1AProjector(ExcDC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcDC1AEvent
   */
  @EventHandler(payloadType = CreateExcDC1AEvent.class)
  public void handle(CreateExcDC1AEvent event) {
    LOGGER.info("handling CreateExcDC1AEvent - " + event);
    ExcDC1A entity = new ExcDC1A();
    entity.setExcDC1AId(event.getExcDC1AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UpdateExcDC1AEvent
   */
  @EventHandler(payloadType = UpdateExcDC1AEvent.class)
  public void handle(UpdateExcDC1AEvent event) {
    LOGGER.info("handling UpdateExcDC1AEvent - " + event);

    ExcDC1A entity = new ExcDC1A();
    entity.setExcDC1AId(event.getExcDC1AId());
    entity.setEdfmax(event.getEdfmax());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setEfdmin(event.getEfdmin());
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
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event DeleteExcDC1AEvent
   */
  @EventHandler(payloadType = DeleteExcDC1AEvent.class)
  public void handle(DeleteExcDC1AEvent event) {
    LOGGER.info("handling DeleteExcDC1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcDC1A entity = delete(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignEdfmaxToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignEdfmaxToExcDC1AEvent.class)
  public void handle(AssignEdfmaxToExcDC1AEvent event) {
    LOGGER.info("handling AssignEdfmaxToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignEdfmax(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignEdfmaxFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignEdfmaxFromExcDC1AEvent.class)
  public void handle(UnAssignEdfmaxFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignEdfmaxFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignEdfmax(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcDC1AEvent.class)
  public void handle(AssignEfd1ToExcDC1AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignEfd1(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcDC1AEvent.class)
  public void handle(UnAssignEfd1FromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignEfd1(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcDC1AEvent.class)
  public void handle(AssignEfd2ToExcDC1AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignEfd2(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcDC1AEvent.class)
  public void handle(UnAssignEfd2FromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignEfd2(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignEfdminToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcDC1AEvent.class)
  public void handle(AssignEfdminToExcDC1AEvent event) {
    LOGGER.info("handling AssignEfdminToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignEfdmin(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcDC1AEvent.class)
  public void handle(UnAssignEfdminFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignEfdmin(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignExclimToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignExclimToExcDC1AEvent.class)
  public void handle(AssignExclimToExcDC1AEvent event) {
    LOGGER.info("handling AssignExclimToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignExclim(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignExclimFromExcDC1AEvent.class)
  public void handle(UnAssignExclimFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignExclimFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignExclim(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignKaToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignKaToExcDC1AEvent.class)
  public void handle(AssignKaToExcDC1AEvent event) {
    LOGGER.info("handling AssignKaToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignKa(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcDC1AEvent.class)
  public void handle(UnAssignKaFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignKa(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignKeToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignKeToExcDC1AEvent.class)
  public void handle(AssignKeToExcDC1AEvent event) {
    LOGGER.info("handling AssignKeToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignKe(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcDC1AEvent.class)
  public void handle(UnAssignKeFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignKe(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignKfToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignKfToExcDC1AEvent.class)
  public void handle(AssignKfToExcDC1AEvent event) {
    LOGGER.info("handling AssignKfToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignKf(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcDC1AEvent.class)
  public void handle(UnAssignKfFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignKf(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignKsToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignKsToExcDC1AEvent.class)
  public void handle(AssignKsToExcDC1AEvent event) {
    LOGGER.info("handling AssignKsToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignKs(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcDC1AEvent.class)
  public void handle(UnAssignKsFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignKs(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcDC1AEvent.class)
  public void handle(AssignSeefd1ToExcDC1AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignSeefd1(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcDC1AEvent.class)
  public void handle(UnAssignSeefd1FromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignSeefd1(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcDC1AEvent.class)
  public void handle(AssignSeefd2ToExcDC1AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignSeefd2(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcDC1AEvent.class)
  public void handle(UnAssignSeefd2FromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignSeefd2(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignTaToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignTaToExcDC1AEvent.class)
  public void handle(AssignTaToExcDC1AEvent event) {
    LOGGER.info("handling AssignTaToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignTa(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcDC1AEvent.class)
  public void handle(UnAssignTaFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignTa(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignTbToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignTbToExcDC1AEvent.class)
  public void handle(AssignTbToExcDC1AEvent event) {
    LOGGER.info("handling AssignTbToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignTb(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcDC1AEvent.class)
  public void handle(UnAssignTbFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignTb(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignTcToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignTcToExcDC1AEvent.class)
  public void handle(AssignTcToExcDC1AEvent event) {
    LOGGER.info("handling AssignTcToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignTc(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcDC1AEvent.class)
  public void handle(UnAssignTcFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignTc(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignTeToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignTeToExcDC1AEvent.class)
  public void handle(AssignTeToExcDC1AEvent event) {
    LOGGER.info("handling AssignTeToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignTe(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcDC1AEvent.class)
  public void handle(UnAssignTeFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignTe(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignTfToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignTfToExcDC1AEvent.class)
  public void handle(AssignTfToExcDC1AEvent event) {
    LOGGER.info("handling AssignTfToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignTf(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcDC1AEvent.class)
  public void handle(UnAssignTfFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignTf(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcDC1AEvent.class)
  public void handle(AssignVrmaxToExcDC1AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignVrmax(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcDC1AEvent.class)
  public void handle(UnAssignVrmaxFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignVrmax(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event AssignVrminToExcDC1AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcDC1AEvent.class)
  public void handle(AssignVrminToExcDC1AEvent event) {
    LOGGER.info("handling AssignVrminToExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC1A entity = assignVrmin(event.getExcDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcDC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcDC1AEvent.class)
  public void handle(UnAssignVrminFromExcDC1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC1A entity = unAssignVrmin(event.getExcDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC1A(entity);
  }

  /**
   * Method to retrieve the ExcDC1A via an ExcDC1APrimaryKey.
   *
   * @param id Long
   * @return ExcDC1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcDC1A handle(FindExcDC1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcDC1AId());
  }

  /**
   * Method to retrieve a collection of all ExcDC1As
   *
   * @param query FindAllExcDC1AQuery
   * @return List<ExcDC1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcDC1A> handle(FindAllExcDC1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcDC1A, but only if the id matches
   *
   * @param entity ExcDC1A
   */
  protected void emitFindExcDC1A(ExcDC1A entity) {
    LOGGER.info("handling emitFindExcDC1A");

    queryUpdateEmitter.emit(
        FindExcDC1AQuery.class,
        query -> query.getFilter().getExcDC1AId().equals(entity.getExcDC1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcDC1A
   *
   * @param entity ExcDC1A
   */
  protected void emitFindAllExcDC1A(ExcDC1A entity) {
    LOGGER.info("handling emitFindAllExcDC1A");

    queryUpdateEmitter.emit(FindAllExcDC1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcDC1AProjector.class.getName());
}
